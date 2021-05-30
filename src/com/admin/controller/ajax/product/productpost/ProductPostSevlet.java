package com.admin.controller.ajax.product.productpost;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.admin.model.vo.product.ProductAjax;


@WebServlet("/product/post/admin")
public class ProductPostSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductPostSevlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		List<ProductAjax> category = new AdminService().categorypicker();
		
//		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/views/admin/adminproductpost.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
