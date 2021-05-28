package com.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.vo.Users;

/**
 * Servlet implementation class SigninAjaxServlet
 */
@WebServlet("/sign/signin/ajax")
public class SigninAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("signin");
		String username = request.getParameter("username");
		
		Users user = new Users();
		user.setUserId(id);
		user.setUserName(username);
		user.setUserAdmin("0");
		user.setUserAddr("카카오로그인 사용자는 직접 입력해주십시오@카카오로그인 사용자는 직접 입력해주십시오");
		user.setUserZip("카카오로그인 사용자는 직접 입력해주십시오");
		user.setUserPhone("카카오로그인 사용자는 직접 입력해주십시오");
		user.setUserEmail("카카오로그인 사용자는 직접 입력해주십시오");
		
		
//		u.setUserId(rs.getString("USER_ID"));
//		u.setUserAddr(rs.getString("user_addr"));
//		u.setUserZip(rs.getString("user_zip"));
//		u.setUserName(rs.getString("USER_NAME"));
//		u.setUserEmail(rs.getString("user_email"));
//		u.setUserPhone(rs.getString("user_phone"));
//		u.setUserAdmin(String.valueOf(rs.getInt("user_admin")));
		
		
		request.getSession().setAttribute("user", user);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
