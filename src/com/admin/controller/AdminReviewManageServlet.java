package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.common.PageBar;
import com.review.model.vo.Review;


@WebServlet("/admin/reviewManage")
public class AdminReviewManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminReviewManageServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService service = new AdminService();
		
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
			numPerPage = 10;
		}
		
		List<Review> list = service.adminSelectAllReview(cPage, numPerPage);
		
		int totalData = service.adminCountAllReview();

		String url = request.getContextPath() + "/admin/reviewManage";
		
		PageBar pageBar = new PageBar();
		
		String reviewPageBar = pageBar.pageBar(cPage, numPerPage, totalData, url);
		
		request.setAttribute("reviewList", list);
		request.setAttribute("reviewPageBar", reviewPageBar);
	
		request.getRequestDispatcher("/views/admin/reviewManage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
