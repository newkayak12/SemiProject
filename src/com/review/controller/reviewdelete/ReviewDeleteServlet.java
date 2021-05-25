package com.review.controller.reviewdelete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;

@WebServlet("/review/delete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewDeleteServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("no");
				
				System.out.println("ReviewDeleteServlet에서 테스트, reviewNo :" + reviewNo);
		
		ReviewService service = new ReviewService();
		
		int result = service.deleteReview(reviewNo);
				
		
		if(result > 0) {
			// 삭제여부 컬럼 변경 완료
			request.setAttribute("msg", "리뷰가 정상적으로 삭제되었습니다");
		} else {
			request.setAttribute("msg", "리뷰가 삭제되지 않았습니다.");
		}
		
		request.setAttribute("loc", "/review/list");
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
