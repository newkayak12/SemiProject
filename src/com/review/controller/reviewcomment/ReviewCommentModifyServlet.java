package com.review.controller.reviewcomment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;

@WebServlet("/review/commentmodify")
public class ReviewCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewCommentModifyServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				// System.out.println("ReviewCommentModifyServlet 들어옴 !!! ");
		
		String commentNo = request.getParameter("commentNo");
		String commentContent = request.getParameter("commentContent");
		String reviewNo = request.getParameter("reviewNo");
				
		
					//System.out.println("commentno "+commentNo +"commentContent "+ commentContent +"reviewNo" + reviewNo);
					
					
		ReviewService service = new ReviewService();
		
		int result = service.modifyReviewComment(commentNo, commentContent);
		
		if(result > 0) {
		
			System.out.println("리뷰 댓글 수정 성공!!! ");
			
		} else {
			
			System.out.println("리뷰 댓글 수정 실패....");
		}
		
		// 리뷰번호 넘겨줘야함 !! 
		request.getRequestDispatcher("/review/detail?no=" + reviewNo + "").forward(request, response);

	}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
