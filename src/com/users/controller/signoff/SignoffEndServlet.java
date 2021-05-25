package com.users.controller.signoff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

@WebServlet("/sign/signoff/end")
public class SignoffEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignoffEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String userPwd=request.getParameter("password");
		System.out.println(userId+userPwd);
		int result = new UsersService().deleteusers(userId, userPwd);
		
		System.out.println(result);
		if(result!=0) {
			request.setAttribute("msg", "탈퇴성공");
			request.setAttribute("loc", "/sign/signout");
		}
		else {
			request.setAttribute("msg", "탈퇴실패");
			request.setAttribute("loc", "/views/member/mypage.jsp");
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
