package com.review.controller.reviewdetail;

import java.io.IOException;
import java.util.List;

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
		List<Review> list = service.selectReview(reviewNo);
		
		// 모든 코맨트가 담긴 리스ㅡㅌ가 완성
		//중복되는 내용은 원래 글 
		// 이 안에 코맨트 내용은 다르다.
		// r.get(0) >> 원래 글은 이걸로 쓰면 되고
		// 나머지 코맨트는 list 안에서 for 
		
		
		request.setAttribute("reviewList", list);
		
		request.getRequestDispatcher("/views/review/reviewDetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
