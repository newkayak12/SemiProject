package com.review.controller.reviewpost;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.vo.Product;
import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/post/start")
public class ReviewPostStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewPostStartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		String orderNo = request.getParameter("orderNo");
		
//		ReviewService service = new ReviewService();
//		
//		Product p = service.selectProduct(orderNo);
		
				//System.out.println("ReviewPostStartServlet에서 테스트, p : " + p);
		
//		request.setAttribute("selectedProduct", p);
		
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String category = request.getParameter("category");
		String file = request.getParameter("file");
		String onumber = request.getParameter("onumber");
		
		Review r = new Review();
		
		r.setCategoryId(category);
		r.setOrderNumber(onumber);
		r.setProductFile(file);
		r.setProductId(pid);
		r.setProductName(pname);
		r.setProductOptionColor(color);
		r.setProductOptionSize(size);
		
		request.setAttribute("selectedProduct", r);
		
		request.getRequestDispatcher("/views/review/reviewForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
