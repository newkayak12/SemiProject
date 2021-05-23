package com.review.controller.reviewcomment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;
import com.review.model.vo.ReviewComment;


@WebServlet("/review/insertReviewComment")
public class ReviewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewCommentServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentContent = request.getParameter("reviewCommentContent");
		String commentUserId = request.getParameter("userId");
		String reviewNo = request.getParameter("reviewNo");
		
		ReviewComment comment = new ReviewComment();
		
		comment.setReviewCommentContent(commentContent);
		comment.setReviewCommentUserId(commentUserId);
		comment.setReviewNo(reviewNo);
		
				System.out.println("ReviewCommentServlet에서 테스트, comment : " + comment);
		
		ReviewService service = new ReviewService();
		
		int result = service.insertReviewComment(comment);
		
		request.setAttribute("comment", comment);
		
		if(result > 0) {
			request.setAttribute("msg", "댓글 등록 성공");
		} else {
			request.setAttribute("msg", "댓글 등록 실패");
		}
		
		request.setAttribute("loc", "/views/review/reviewDetail.jsp");
		
		request.getRequestDispatcher("/review/detail").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
