package com.productqna.controller.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productqna.model.service.QnaProductService;

/**
 * Servlet implementation class Qnamainpost
 */
@WebServlet("/product/qna/main/post/ajax")
public class Qnamainpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qnamainpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qnauser = request.getParameter("qnauser");
		String qnacontent = request.getParameter("qnacontent");
		String qnatitle = request.getParameter("qnatitle");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String userid = request.getParameter("userid");
		
		int result = QnaProductService.postqnamain(qnauser, qnatitle, qnacontent, pid, cid, userid);
		
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
