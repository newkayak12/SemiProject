package com.order.controller.orderdetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.model.service.OrderService;
import com.order.model.vo.Order;
import com.users.model.vo.Users;

@WebServlet("/order/detail")
public class OrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ordernumber = request.getParameter("orderNumber");

		List<Order> list = new OrderService().showdetailOrder(ordernumber);
		
		
		
		HttpSession session  = request.getSession();

		Users user = (Users) session.getAttribute("user");

		
		request.setAttribute("user", user);
		request.setAttribute("list",list);
		request.getRequestDispatcher("/views/order/orderdetail/orderdetail.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

