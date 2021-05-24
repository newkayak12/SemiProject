package com.cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.model.vo.Cart;
import java.util.List;

@WebServlet("/cart/list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookiejar = request.getCookies();
		List<Cart> cartlist = new ArrayList();
		String temp = "";
		
		if(cookiejar != null) {
				for(Cookie cookie : cookiejar) {
					if(cookie.getName().equals("cartlist")) {
						temp = cookie.getValue();
						
						break;
					}
					
				}
				
				
		Cart cart = null;		
		temp = temp.substring(1, temp.length());
		System.out.println("cookies"+temp);
		
		String [] temp2 = temp.split("#");
		
		for(String test :temp2) {
			System.out.println(test);
		}
		
		System.out.println("cookie"+temp2[0]);
		//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
			for(String t :temp2) {
				String[] t2 = t.split("@");
				
				
				
				System.out.println(t2[0]);
				System.out.println(t2[1]);
				System.out.println(t2[2]);
				System.out.println(t2[3]);
				System.out.println(t2[4]);
				System.out.println(t2[5]);
				
				
				
				
				cart = new Cart();
				cart.setProductId(t2[0]);
				cart.setProductOptionSize(t2[1]);
				cart.setProductOptionColor(t2[2]);
				cart.setProductPrice(Integer.parseInt(t2[3]));
				cart.setProductCount(Integer.parseInt(t2[4]));
				cart.setCategoryId(t2[5]);
				
				cartlist.add(cart);
			}
		
			request.setAttribute("cartlist", cartlist);
			
		}
			
			request.getRequestDispatcher("/views/cart/cartlist/cartlist.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}