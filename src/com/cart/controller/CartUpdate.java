package com.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartUpdate
 */
@WebServlet("/cart/update")
public class CartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartdel = request.getParameter("cartCookie");
		
		cartdel = cartdel.substring(0,cartdel.length());
		System.out.println(cartdel+"  update");
		
		
		
		String cookiecontent = "";
		Cookie[] cart = request.getCookies();
		
			for(Cookie c : cart) {
				if(c.getName().equals("cartlist")) {
					cookiecontent=c.getValue();
					
//					System.out.println("cookie " + cookiecontent );
					
					if(cartdel.contains("!")) {
						String[] temp2 = cartdel.split("#");
						
						for(String temp3 : temp2) {
							cookiecontent = cookiecontent.replace("#"+temp3, "");
						}
						
						
					} else {
						
						cookiecontent = cookiecontent.replace(cartdel, "");
						
					}
					
					
					break;
				}
				
				
			}
			
//			System.out.println("update "+cookiecontent);
			Cookie cookie = new Cookie("cartlist", cookiecontent);
			cookie.setPath(request.getContextPath()+"/");
			cookie.setMaxAge(60*60*24*365*100);
			response.addCookie(cookie);
			
			response.sendRedirect(request.getContextPath()+"/cart/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
