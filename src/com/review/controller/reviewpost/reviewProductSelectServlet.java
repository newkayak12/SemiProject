package com.review.controller.reviewpost;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.model.vo.Order;
import com.review.model.service.ReviewService;


@WebServlet("/review/selectReviewProduct")
public class reviewProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public reviewProductSelectServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNo = (String)request.getParameter("orderNo");
		
		ReviewService service = new ReviewService();
		
		List<Order> list = service.selectProduct(orderNo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
