package com.productqna.controller.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productqna.model.service.QnaProductService;
import com.qna.model.service.QnaService;

/**
 * Servlet implementation class QnaProductCommentPostAjax
 */
@WebServlet("/product/qna/post/ajax")
public class QnaProductCommentPostAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaProductCommentPostAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String writer = request.getParameter("writer");
		String comment = request.getParameter("comment");
		String qseq = request.getParameter("qseq");
		System.out.println(writer +":"+ comment +":"+qseq);
		int result = new QnaProductService().postqnacomment(writer, comment, qseq);
		
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
