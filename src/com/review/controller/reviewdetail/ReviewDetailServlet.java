package com.review.controller.reviewdetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/detail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewDetailServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("no");
		
		ReviewService service = new ReviewService();
		
		
		// 리뷰번호로 db에 접근해서 해당하는 리뷰글과 댓글 조회 
		Review r = service.selectReview(reviewNo);
		
		request.setAttribute("review", r);
		
		request.getRequestDispatcher("/views/review/reviewDetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
