package com.admin.controller.ajax.product.productlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.admin.model.vo.product.ProductAjax;
import com.google.gson.Gson;


@WebServlet("/product/list/admin")
public class ProductlistAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductlistAjaxServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProductAjax> result = new AdminService().selectAllProductAdmin();
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		
		gson.toJson(result, response.getWriter());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
