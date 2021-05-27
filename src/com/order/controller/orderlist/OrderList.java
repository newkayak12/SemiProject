package com.order.controller.orderlist;

import static com.common.PageBar.pageBar;

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

@WebServlet("/order/list")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		String id = user.getUserId();
//		String id = "testusers";
		
		if(id != null) {
			int cPage = 1;
			int numPerPage = 5;
						try {
									cPage=Integer.parseInt(request.getParameter("cPage"));
						} catch (NumberFormatException e) {
							
						}
						
						try {
									numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
						} catch(NumberFormatException e) {
							
						}
						
			List<List<Order>> result = new OrderService().showallOrder(cPage, numPerPage, id);
			
			
			int resultCount = new OrderService().showallOrderCount(id);
			String url = request.getContextPath()+"/order/list";
			String pageBar = pageBar(cPage, numPerPage, resultCount,url );
				request.setAttribute("pageBar",pageBar);
				request.setAttribute("result", result);
				request.setAttribute("orderCount",resultCount);
				request.getRequestDispatcher("/views/order/orderlist/orderlist.jsp").forward(request, response);
		
//			response.setContentType("application/json;charset=utf-8");
//			 Gson gson = new Gson();
//			 gson.toJson(
			
		} 
//			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

