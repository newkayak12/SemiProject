package com.admin.controller.ajax.product.productdetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.admin.model.vo.product.ProductAjax;
import com.product.model.service.ProductService;
import com.product.model.vo.Product;


@WebServlet("/admin/product/detail")
public class Productdetailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public Productdetailservlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("pId");
		String cId = request.getParameter("cId");
		
			System.out.println("Productdetailservlet에서 테스트, pId : " + pId);
			System.out.println("Productdetailservlet에서 테스트, cId : " + cId);
		
			
		// 모든 컬러 옵션
		List<ProductAjax> colors = new AdminService().colorpicker();
		
		// 모든 사이즈 옵션
		List<ProductAjax> sizes = new AdminService().sizepicker();
		
		
		// 카테고리 번호에 해당하는 카테고리 이름
		ProductAjax category = new AdminService().categorypicker(cId);
		
		// 상품 번호에 해당하는 상품의 디테일 ( 디테일번호, 색상, 사이즈, 재고 )
//		String productName = new AdminService().selectProductName(pId);
		List<Product> productDetails = new AdminService().selectProductDetails(pId);
		
		
//		request.setAttribute("pName", productName);
		
		request.setAttribute("productDetails", productDetails);
		
		request.setAttribute("pId", pId);
		
		request.setAttribute("category", category);
		
		request.setAttribute("colors", colors);
		
		request.setAttribute("sizes", sizes);
		
		
		
		request.getRequestDispatcher("/views/admin/adminproductdetail.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
