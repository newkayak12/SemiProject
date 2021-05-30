package com.users.controller.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;

/**
 * Servlet implementation class SearchPwReplaceServlet
 */
@WebServlet("/user/search/replace")
public class SearchPwReplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwReplaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		
		int result = new UsersService().changepw(id,password);
		
		if(result >0) {
			request.setAttribute("close", "window.close()");
			request.setAttribute("msg", "변경이 완료되었습니다.");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		} else {
			request.setAttribute("close", "window.close()");
			request.setAttribute("msg", "변경에 실패했습니다..");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
