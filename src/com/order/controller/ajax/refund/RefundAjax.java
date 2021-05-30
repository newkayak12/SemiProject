package com.order.controller.ajax.refund;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.model.service.OrderService;

/**
 * Servlet implementation class RefundAjax
 */
@WebServlet("/order/refund/ajax")
public class RefundAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		String pid = request.getParameter("pid");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String onumber = request.getParameter("onumber");
		
		int result = new OrderService().refund(cid, pid, size, color, onumber);
		if(result>0) {
			response.getWriter().write("환불신청완료");
		} else {
			response.getWriter().write("환불신청실패");
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
