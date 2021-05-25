package com.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.model.service.MainProductService;
import com.main.model.vo.MainProduct;


@WebServlet("/main/product/list")
public class MainProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainProductListServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<MainProduct> products = new MainProductService().selectProduct();
		
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
