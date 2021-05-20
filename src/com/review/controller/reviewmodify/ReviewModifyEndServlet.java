package com.review.controller.reviewmodify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/modify/end")
public class ReviewModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewModifyEndServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("reviewNo");
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewTitle = request.getParameter("reviewTitle");
		String up_file = request.getParameter("up_file");
		String reviewContent = request.getParameter("reviewContent");
		
		Review r = new Review();
		
		r.setReviewNo(reviewNo);
		r.setUserId(reviewWriter);
		r.setReviewTitle(reviewTitle);
		r.setReviewFile(up_file);
		r.setReviewContents(reviewContent);
		
				System.out.println("ReviewModifyEndServelt에서 테스트, r : " + r);
		
		ReviewService service = new ReviewService();
		
		int result = service.modifyReview(r);
		
		
		
		if(result > 0) {
			request.setAttribute("msg", "리뷰가 정상적으로 수정되었습니다.");
			request.setAttribute("loc", "/review/list");
		} else {
			request.setAttribute("msg", "리뷰를 수정하지 못했습니다. 다시 실행하십시오.");
			request.setAttribute("loc", "/review/modify/start?no=" + r.getReviewNo());
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

