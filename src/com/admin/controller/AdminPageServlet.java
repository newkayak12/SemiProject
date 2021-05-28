package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.PageBar;
import com.notice.model.service.NoticeService;
import com.users.model.service.UsersService;
import com.users.model.vo.Users;


@WebServlet("/admin/adminPageStart")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminPageServlet() {
       super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/views/admin/adminPage.jsp").forward(request, response);
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
