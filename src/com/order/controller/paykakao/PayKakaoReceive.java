package com.order.controller.paykakao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayKakaoReceive
 */
@WebServlet("/order/pay/kakao/receive")
public class PayKakaoReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayKakaoReceive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("success");
		String tid = request.getParameter("tid");
		String redirectPcUrl = request.getParameter("next_redirect_pc_url");
		String redirectAppUrl = request.getParameter("next_redirect_app_url");
		String redirectMobileUrl = request.getParameter("next_redirect_mobile_url");
		String created = request.getParameter("created_at");
		
		System.out.println(tid+":"+redirectPcUrl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
