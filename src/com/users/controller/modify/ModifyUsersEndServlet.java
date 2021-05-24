package com.users.controller.modify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

@WebServlet("/sign/modify/start")
public class ModifyUsersEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUsersEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		String userpw=request.getParameter("userpw");
		String username=request.getParameter("username");
		String useraddr=request.getParameter("useraddr");
		String useremail=request.getParameter("useremail");
		String userzip=request.getParameter("userzip");
		String userphone=request.getParameter("userphone");
		
		UsersService sevice=new UsersService();
		Users u=new Users(userid,userpw,username,useraddr,useremail,userzip,userphone, null);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
