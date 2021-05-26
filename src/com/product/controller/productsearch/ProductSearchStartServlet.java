package com.product.controller.productsearch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.service.ProductService;
import com.product.model.vo.Product;


@WebServlet("/product/searchProductStart")
public class ProductSearchStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductSearchStartServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String keyword = request.getParameter("keyword");
		
		ProductService service = new ProductService();
		
		List<Product> searchResult = service.searchProduct(keyword);
		
		request.setAttribute("searchResult", searchResult);
		
		request.getRequestDispatcher("/views/product/productSearchList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
