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
	
		
		List<ProductAjax> color = new AdminService().colorpicker();
		
		List<ProductAjax> size = new AdminService().sizepicker();
		
		ProductAjax category = new AdminService().categorypicker(cId);
		List<Product> productName = new ProductService().productDetail(pId, cId);
		
		request.setAttribute("pName", productName.get(0).getProductName());
		
		request.setAttribute("pId", pId);
		
		request.setAttribute("category", category);
		
		request.setAttribute("color", color);
		
		request.setAttribute("size", size);
		
		
		
		request.getRequestDispatcher("/views/admin/adminproductdetail.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
