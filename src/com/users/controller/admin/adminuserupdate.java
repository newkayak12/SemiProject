package com.users.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;

/**
 * Servlet implementation class adminuserupdate
 */
@WebServlet("/admin/userupdate/end")
public class adminuserupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminuserupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userId= request.getParameter("userid");
		String userStatus = request.getParameter("userstatus");
		
		
		int result = new UsersService().updateadminUsers(userId,userStatus);
		
		if(result>0) {
			request.getRequestDispatcher("/admin/userselect/start").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
