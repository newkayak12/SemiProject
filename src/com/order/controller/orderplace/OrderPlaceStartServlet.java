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

import com.cart.model.vo.Cart;

@WebServlet("/order/place")
public class OrderPlaceStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaceStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = "";
		String productname = "";
		String productid = "";
		String productcolor = "";
		String productsize = "";
		int productprice = 0;
		int productcount = 0;
		List<Cart> cartlist = new ArrayList();
		Cart cart = null;		
//		boolean bool = 
		
		
			
				try {
					
					category = request.getParameter("catgory");
					productid = request.getParameter("productid");
					productcolor = request.getParameter("productcolor");
					productsize = request.getParameter("productsize");
					productname = request.getParameter("productname");
					productprice = Integer.parseInt(request.getParameter("productprice"));
					productcount = Integer.parseInt(request.getParameter("productstock"));
					
					cart = new Cart();
					cart.setProductId(productid);
					cart.setCategoryId(category);
					cart.setProductName(productname);
					cart.setProductOptionColor(productcolor);
					cart.setProductOptionSize(productsize);
					cart.setProductPrice(productprice);
					cart.setProductCount(productcount);
					request.setAttribute("list", cart);
					request.setAttribute("flag", 0);
					
					
	//				바로 구매
				} catch(NumberFormatException e) {
	//				장바구니
					Cookie[] cookiejar = request.getCookies();
					String temp = "";
							for(Cookie cookie : cookiejar) {
								if(cookie.getName().equals("cart")) {
									temp = cookie.getValue();
									break;
								}
								
							}
					
					String [] temp2 = temp.split("||");
					//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
						for(String t :temp2) {
							String[] t2 = t.split("_");
							cart = new Cart();
							cart.setProductId(t2[0]);
							cart.setCategoryId(t2[1]);
							cart.setProductOptionSize(t2[2]);
							cart.setProductOptionColor(t2[3]);
							cart.setProductName(t2[4]);
							cart.setProductPrice(Integer.parseInt(t2[5]));
							cart.setProductCount(Integer.parseInt(t2[6]));
							
							cartlist.add(cart);
							
						}
					
						
						request.setAttribute("list",cartlist);
						request.setAttribute("flag", 1);
				}
		
		
		
			request.getRequestDispatcher("/views/orderplace/orderplace.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
