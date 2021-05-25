package com.users.controller.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

/**
 * Servlet implementation class SearchPwEndServlet
 */
@WebServlet("/search/searchpw/end")
public class SearchPwEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		String userPhone=request.getParameter("userPhone");
		
		Users u = new Users();
		u.setUserId(userid);
		u.setUserPhone(userPhone);
		
		Users userpwtemp=new UsersService().searchpw(u);
		
		
		/*
		 * request.setAttribute("userpwtemp", userpwtemp);
		 * request.getRequestDispatcher("/views/member/searchpw.jsp").forward(request,
		 * response);
		 */
		
		String msg="";
		String loc="";
		
		if(userpwtemp!=null) {
			request.setAttribute("msg", "찾아시는 비밀번호는 "+userpwtemp.getUserPwd()+"입니다.");
			request.setAttribute("loc", "/sign/signin/start");
		}
		else {
			request.setAttribute("msg", "아이디 또는 번호가 틀렸습니다.");
			request.setAttribute("loc", "/search/searchid/start");
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
