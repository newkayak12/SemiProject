package com.review.controller.reviewlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.PageBar;
import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/list")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewListServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// db에 있는 모든 리뷰 가져오기
		ReviewService service = new ReviewService();
		
		
		// cPage, numPerPage 설정
		
		int cPage;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		
		
		int numPerPage;
		
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 5;
		}
		
		
		List<Review> list = service.selectAllReview(cPage, numPerPage);
		
		int totalData = service.countAllReview();
		
		String url = request.getContextPath() + "/views/review/reviewList.jsp";
		
		
		// 페이지바
		PageBar pageBar = new PageBar();
		
		String reviewPageBar = pageBar.pageBar(cPage, numPerPage, totalData, url);
		
		request.setAttribute("reviewList", list);
		request.setAttribute("reviewPageBar", reviewPageBar);
		
		request.getRequestDispatcher("/views/review/reviewList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
