package com.review.controller.reviewlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.PageBar;
import com.review.model.service.ReviewService;
import com.review.model.vo.Review;
import com.users.model.vo.Users;

/**
 * Servlet implementation class MyReviewServlet
 */
@WebServlet("/review/MyReviewList")
public class MyReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 유저 데이터를 보내야 함.
		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		String id = user.getUserId();	
		
		if(id != null) {
			int cPage = 1;
			int numPerPage = 5;
						try {
									cPage=Integer.parseInt(request.getParameter("cPage"));
						} catch (NumberFormatException e) {
							
						}
						
						try {
									numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
						} catch(NumberFormatException e) {
							
						}
			
			
			// 내가 쓴 리뷰 가져오기
			List<Review> list = new ReviewService().MyReviewList(cPage, numPerPage, id);
			request.setAttribute("list", list);
		
			//페이지 바
			int totalData = new ReviewService().countAllMyReview(id);
			String url = request.getContextPath() + "/review/MyReviewList";
			PageBar pageBar = new PageBar();
			
			String reviewPageBar = pageBar.pageBar(cPage, numPerPage, totalData, url);

			request.setAttribute("reviewList", list);
			request.setAttribute("reviewPageBar", reviewPageBar);
			
			request.getRequestDispatcher("/views/review/MyReviewList.jsp").forward(request, response);
			
		}
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
