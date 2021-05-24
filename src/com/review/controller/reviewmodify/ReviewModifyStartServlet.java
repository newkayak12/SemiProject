package com.review.controller.reviewmodify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/modify/start")
public class ReviewModifyStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewModifyStartServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면전환용 서블릿 
		
		String reviewNo = request.getParameter("no");
		
//				 System.out.println("ReviewModifyStartServlet에서 테스트, reviewNo : " + reviewNo);
		
		ReviewService service = new ReviewService();
		
		List<Review> list = service.selectReview(reviewNo);
		
//				System.out.println("ReviewModifyStartServlet에서 테스트, list : " + list);
		
		request.setAttribute("reviewNo", reviewNo);
		request.setAttribute("reviewList", list);
		
		
		request.getRequestDispatcher("/views/review/reviewFormModify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
