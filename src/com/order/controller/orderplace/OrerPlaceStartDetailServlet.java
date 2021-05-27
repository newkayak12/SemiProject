package com.order.controller.orderplace;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.model.vo.Cart;
import com.product.model.service.ProductService;
import com.product.model.vo.Product;

/**
 * Servlet implementation class OrerPlaceStartDetailServlet
 */
@WebServlet("/order/place/page/start")
public class OrerPlaceStartDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrerPlaceStartDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");
//		String flag = request.getParameter("flag");
		
		List<Product> product = new ProductService().productDetail(pid, category);
		
		int flag = 0;
		
		
		
//		 cart 1 or many
//		 page 1
		
		
		
		
		
		//detail - 0
		
		Cart cart = new Cart();
		cart.setCartName(product.get(0).getProductName());
		cart.setProductFile(product.get(0).getProductFile());
		cart.setCartOptionColor(color);
		cart.setCartOptionSize(size);
		cart.setCartPrice(Integer.parseInt(price));
		cart.setCartStock(Integer.parseInt(stock));
		cart.setProductId(pid);
		cart.setCategoryId(category);
		
		
		request.setAttribute("list",cart);
//		request.setAttribute("flag", flag);
		request.setAttribute("flag2", "page");
		
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
