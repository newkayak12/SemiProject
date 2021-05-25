package com.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cartpost
 */
@WebServlet("/cart/post")
public class Cartpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartadd = request.getParameter("cartlist");
		String pid = request.getParameter("pid");
		String category = request.getParameter("category");
		Cookie[] list = request.getCookies();
		String value = "";
		Cookie a  = null;
		
		
		
//		이미 있을 떄
		if(list != null) {
			for(Cookie c : list) {
				if(c.getName().equals("cartlist")) {
					value=c.getValue();
					 a = new Cookie("cartlist", c.getValue()+"#"+cartadd);
					 a.setPath(request.getContextPath()+"/");
					 a.setMaxAge(60*60*24*365*100);
					

					break;
				}
				
				
			}
		}
		
		
		if( value.equals("")) {
			
			a = new Cookie("cartlist","#"+cartadd);
			a.setMaxAge(60*60*24*365*100);
			a.setPath(request.getContextPath()+"/");
		}
		
		
		response.addCookie(a);
//		response.sendRedirect(request.getContextPath()+"/");
		request.setAttribute("msg", "카트에 저장했습니다.");
		request.setAttribute("loc","/product/detail?pid="+pid+"&category="+category);
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
