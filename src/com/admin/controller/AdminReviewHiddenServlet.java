package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;


@WebServlet("/admin/reviewHidden")
public class AdminReviewHiddenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminReviewHiddenServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("reviewNo");
		String rDelete = request.getParameter("rDelete");
		
		int result = new AdminService().reviewHidden(reviewNo, rDelete);
		
		if(result>0) {
			request.getRequestDispatcher("/admin/reviewManage").forward(request, response);
		}
		else {
			request.setAttribute("msg", "공개여부 수정 실패");
			request.setAttribute("loc", "/views/admin/adminPage.jsp");
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
