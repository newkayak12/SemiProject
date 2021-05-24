package com.users.controller.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

@WebServlet("/sign/signup/end")
public class SignupEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		String useraddr=request.getParameter("useraddr");
		String userzip=request.getParameter("userzip");
		String userPwd=request.getParameter("password");
		String username=request.getParameter("username");
		String useremail=request.getParameter("useremail");
		String userPhone=request.getParameter("userPhone");
	
		String userPwdCheck=request.getParameter("password-check");
		String useraddrdetail=request.getParameter("useraddrdetail");
		
		
		
		Users u=new Users();
		u.setUserId(userId);
		u.setUserAddr(useraddr);
		u.setUserZip(userzip);
		u.setUserPwd(userPwd);
		u.setUserName(username);
		u.setUserEmail(useremail);
		u.setUserPhone(userPhone);
		

		
		int result= new UsersService().join(u);

		
		if(result!=0) {
			request.setAttribute("msg", "회원가입성공");
			request.setAttribute("loc", "/sign/signin/start");
		}
		else {
			request.setAttribute("msg", "회원가입실패");
			request.setAttribute("loc", "/views/member/join.jsp");
			
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
