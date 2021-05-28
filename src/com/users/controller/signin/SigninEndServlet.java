package com.users.controller.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

@WebServlet("/sign/signin/end")
public class SigninEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("password");
		String check = request.getParameter("idsave");
		
		
		Users u=new UsersService().login(userId,userPwd);
		
		if(u!=null) {
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*30);
			
			session.setAttribute("user", u);
			
				if(check!=null && check.equals("on")) {
					
					Cookie cookie = new Cookie("userid", userId);
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
			

			response.sendRedirect(request.getContextPath()+"/");
			
		} else {
			
			request.setAttribute("msg", "로그인에 실패했습니다.");
			request.setAttribute("loc", "/sign/signin/start");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//			response.getWriter().write("1");
			
			
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
