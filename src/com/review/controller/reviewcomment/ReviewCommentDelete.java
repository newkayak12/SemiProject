package com.review.controller.reviewcomment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;


@WebServlet("/review/commentdelete")
public class ReviewCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewCommentDelete() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentNo = request.getParameter("commentNo");
		
		String reviewNo = request.getParameter("reviewNo");
		
				//System.out.println("ReviewCommentDelete에서 테스트, commentNo : " + commentNo);
		
		
	ReviewService service = new ReviewService();
	
	int result = service.deleteReviewComment(commentNo);
	
	if(result > 0) {
	
		System.out.println("리뷰 댓글 삭제 성공!!! ");
		
	} else {
		
		System.out.println("리뷰 댓글 삭제 실패....");
	}
	
	// 리뷰번호 넘겨줘야함 !! 
	request.getRequestDispatcher("/review/detail?no=" + reviewNo + "").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
