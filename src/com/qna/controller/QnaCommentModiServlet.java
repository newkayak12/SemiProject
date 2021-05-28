package com.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qna.model.service.QnaService;

/**
 * Servlet implementation class QnaCommentModiStartServlet
 */
@WebServlet("/qna/commentmodify")
public class QnaCommentModiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommentModiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String commentNo = request.getParameter("qSeq");
		String commentContent = request.getParameter("commentContent");
		String QnaNo = request.getParameter("QnaNo");
		
		QnaService service = new QnaService();
		System.out.println("데이터 잘 가져오늕 ㅣ "+commentNo + commentContent + QnaNo);
		
		int result = service.modifyQnaComment(commentNo, commentContent);
		
		request.getRequestDispatcher("/qna/qnadetail?qSeq="+ QnaNo).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
