package com.admin.controller.ajax.product.productdetail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;


@WebServlet("/admin/product/detailend")
public class ProductDetailEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductDetailEndServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String pId = request.getParameter("pId");
		String cId = request.getParameter("cId");
		String pColor = request.getParameter("pColor");
		String pSize = request.getParameter("pSize");
		String pstock = request.getParameter("pStock");
		
				// System.out.println("ProductDetailEndServlet에서 테스트, pId : " + pId + ", pColor : " + pColor + ", pSize : " + pSize);
	
		
		
		
		AdminService service = new AdminService();
		
		int result = service.postProductDetail(pId, pColor, pSize);
		
		
		
		
		if(result > 0) {
			
			// 이미 해당하는 상품상세가 있음 
			// -> 등록 불가
			// -> 재고만 수정 가능
			// -> update
			
			int stockResult = service.updateProductStock(pId, pColor, pSize, Integer.parseInt(pstock));
			
			if( stockResult > 0 ) {
				response.getWriter().write("이미 있는 상세옵션이므로 재고만 수정 완료");
			} else {
				response.getWriter().write("등록 실패!");
			}
			
		} else {
			
			// 해당하는 상품상세가 없음
			// -> 등록 가능 
			// -> insert
			
			int insertResult = service.insertProductDetail(pId, cId, pColor, pSize, Integer.parseInt(pstock));
			
			if( insertResult > 0 ) {
				response.getWriter().write("상품 상세 정보 등록 완료");
			} else {
				response.getWriter().write("등록 실패!");
			}
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
