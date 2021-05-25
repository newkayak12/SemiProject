 package com.order.controller.orderplace;

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

@WebServlet("/order/place/cart/start")
public class OrderPlaceStartCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaceStartCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		Cookie[] cookiejar = request.getCookies();
		String cartlist = "";
		for(Cookie e : cookiejar) {
			if(e.getName().equals("cartlist")) {
				cartlist = e.getValue();
			}
		}
		
		
			cartlist = cartlist.substring(1,cartlist.length());
			System.out.println(cartlist);
			Cart cart = null;
			List<Cart> list = new ArrayList();
		
			
			
			
		if(cartlist.contains("#")){
			String[] split1 = cartlist.split("#");
			
			for(String a : split1) {
				System.out.println(a);
				String[] b= a.split("@");
				
				cart = new Cart();
				cart.setProductId(b[0]);
				cart.setCartOptionSize(b[1]);
				cart.setCartOptionColor(b[2]);
				cart.setCartPrice(Integer.parseInt(b[3]));
				cart.setCartStock(Integer.parseInt(b[4]));
				cart.setCategoryId(b[5]);
				Cart ls = new CartService().selectCart(b[0], b[5]);
				cart.setProductExplain(ls.getProductExplain());
				cart.setProductFile(ls.getProductFile());
				
				
				
				list.add(cart);
				
				request.setAttribute("list", list);
				request.setAttribute("flag2", "list");
				
			}
			
		} else {
			
			
			String[] b = cartlist.split("@");
			
			cart = new Cart();
			cart.setProductId(b[0]);
			cart.setCartOptionSize(b[1]);
			cart.setCartOptionColor(b[2]);
			cart.setCartPrice(Integer.parseInt(b[3]));
			cart.setCartStock(Integer.parseInt(b[4]));
			cart.setCategoryId(b[5]);
			Cart ls = new CartService().selectCart(b[0], b[5]);
			cart.setProductExplain(ls.getProductExplain());
			cart.setProductFile(ls.getProductFile());
			
			request.setAttribute("list", cart);
			request.setAttribute("flag2", "cart");

		}
		
		request.setAttribute("flag",1);
		
		request.getRequestDispatcher("/views/order/orderplace/orderplace.jsp").forward(request, response);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
