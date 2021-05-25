package com.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.model.service.CartService;
import com.cart.model.vo.Cart;

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
		if(!temp.equals("")) {
			temp = temp.substring(1, temp.length());
			
			String [] temp2 = temp.split("#");
			
			
			//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
				for(String t :temp2) {
					String[] t2 = t.split("@");
					
					
//					System.out.println("\n\n -------");
//					System.out.println(t2[0]);  // pid ..
//					System.out.println(t2[1]);  // size ..
//					System.out.println(t2[2]);  // color ..
//					System.out.println(t2[3]);  // price ..
//					System.out.println(t2[4]);  // stock ..
//					System.out.println(t2[5]);  // category
					
					
					
					
					cart = new CartService().selectCart(t2[0], t2[5]);
					cart.setCartStock(Integer.parseInt(t2[4]));
					cart.setCartOptionColor(t2[2]);
					cart.setCartOptionSize(t2[1]);
					cart.setCartPrice(Integer.parseInt(t2[3]));
					cart.setCategoryId(t2[5]);
					
					
					
					cartlist.add(cart);
				}
			
//=======
//		Cart cart = null;		
//		temp = temp.substring(1, temp.length());
//		
//		String [] temp2 = temp.split("#");
//		
//		
//		//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
//			for(String t :temp2) {
//				String[] t2 = t.split("@");
//				
//				
////				System.out.println("\n\n -------");
////				System.out.println(t2[0]);  // pid ..
////				System.out.println(t2[1]);  // size ..
////				System.out.println(t2[2]);  // color ..
////				System.out.println(t2[3]);  // price ..
////				System.out.println(t2[4]);  // stock ..
////				System.out.println(t2[5]);  // category
//				
//				
//				
//				
//				cart = new CartService().selectCart(t2[0], t2[5]);
//				cart.setCartStock(Integer.parseInt(t2[4]));
//				cart.setCartOptionColor(t2[2]);
//				cart.setCartOptionSize(t2[1]);
//				cart.setCartPrice(Integer.parseInt(t2[3]));
//				cart.setCategoryId(t2[5]);
//				
//				
//>>>>>>> 208815ba15ad7816b36902dd891e9a787d2f6e38
				
			}
		}	
			request.setAttribute("cartlist", cartlist);
			request.getRequestDispatcher("/views/cart/cartlist.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}