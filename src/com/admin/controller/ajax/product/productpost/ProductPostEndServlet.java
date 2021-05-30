package com.admin.controller.ajax.product.productpost;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.admin.model.service.AdminService;
import com.common.renamepolicy.ProductRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.product.model.vo.Product;


@WebServlet("/product/postend/admin")
public class ProductPostEndServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public ProductPostEndServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				System.out.println("ProductPostEndServlet 들어옴");
				
		if( !ServletFileUpload.isMultipartContent(request) ) {
			
			request.setAttribute("msg", "잘못된 접근입니다");
			request.setAttribute("loc", "/views/admin/adminproductdetail.jsp");
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		
		
		String filePath = request.getServletContext().getRealPath("/upload/product/"); 
		
		int maxPostSize = 1024*1024*10;
		
		String encode = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(request, filePath,  maxPostSize, encode, new ProductRenamePolicy());
		
		
		
		
		Product p = new Product();
		
		p.setCategoryId(mr.getParameter("category"));
		p.setProductExplain(mr.getParameter("mainexplain").concat("@").concat(mr.getParameter("detailexplain")));
		p.setProductFile(mr.getFilesystemName("mainimage"));
		p.setProductFileDetail1(mr.getFilesystemName("detailimage1"));
		p.setProductFileDetail2(mr.getFilesystemName("detailimage2"));
		p.setProductName(mr.getParameter("productname"));
		p.setProductPrice(mr.getParameter("productprice"));
		
		
				System.out.println("ProductPostEndServlet에서 테스트, p : " + p);
				
				
				
				
		AdminService service = new AdminService();
		
		int result = service.postProduct(p);
		
			String msg = "";
		
		if(result > 0) {
			
			msg = "게시글 등록 성공";
			
		} else {
			
			msg = "게시글 등록 실패";
		}
		
		String loc = "/views/admin/adminproductmanage.jsp";
		
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
