package com.product.controller.productdetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.service.ProductService;
import com.product.model.vo.Product;
import com.review.model.service.ReviewService;
import com.review.model.vo.Review;


@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductDetailServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String productid= request.getParameter("pid");
		String category = request.getParameter("category");
		
		
		List<Product> product = new ProductService().productDetail(productid, category);
		
		List<Review> reviews = new ReviewService().selectProductReview(productid);
		
		int result = new ProductService().counting(productid, category);
		System.out.println(result);
		
		request.setAttribute("productlist", product);
		
		request.setAttribute("reviewlist", reviews);
		
		
		request.getRequestDispatcher("/views/product/productdetail.jsp").forward(request, response);
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
