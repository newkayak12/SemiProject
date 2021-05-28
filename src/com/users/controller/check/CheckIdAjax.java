package com.users.controller.check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;

/**
 * Servlet implementation class CheckIdAjax
 */
@WebServlet("/check/checkid/ajax")
public class CheckIdAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid = request.getParameter("userId");
		
		
		
		UsersService service = new UsersService();
		System.out.println(userid);
		int result= service.checkid(userid);
//		response.getWriter().print((result>0)?"no":"ok");
//		response.getWriter().write((result>0)?"no":"ok");
		PrintWriter out = response.getWriter();
		out.print(result);
		/*
		 * request.getRequestDispatcher("/views/member/join.jsp").forward(request,
		 * response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
