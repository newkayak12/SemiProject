package com.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.main.model.service.MainProductService;
import com.main.model.vo.MainProduct;
import com.product.model.service.ProductService;
import com.product.model.vo.Product;


@WebServlet("/main/product/list/ajax")
public class MainProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainProductListServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String sort = request.getParameter("sort");
		 
		
		if(sort == null) {
			sort  = "p_view_count";
		} 
		
		request.setAttribute("sort", sort);
		
		String category = request.getParameter("category");
		
		
		
		
		
		
		List<Product> result = new ProductService().selectAllProduct(1, 9,sort,"all");
		
		Gson gson = new Gson();
		response.setContentType("application/json;charset=utf-8");
		gson.toJson(result,response.getWriter());
		
		
		
		
		//ajax로 보낼 곳
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
