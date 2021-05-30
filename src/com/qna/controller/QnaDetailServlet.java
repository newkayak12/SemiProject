package com.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qna.model.service.QnaService;
import com.qna.model.vo.Qna;
import com.qna.model.vo.QnaComment;

/**
 * Servlet implementation class QnaDetailServlet
 */
@WebServlet("/qna/qnadetail")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("qSeq");
		
		// Qna에 있는 거 가져오기
		Qna q = new QnaService().selectQna(no);
		
		// Qna_Comment에 있는 거 List로 쫙 가져오기
		List<QnaComment> comments = new QnaService().selectQnaComment(no);
		
		// Qna 상세페이지로 넘어가게 하기
		request.setAttribute("qna",q);
		request.setAttribute("comments", comments);
		request.getRequestDispatcher("/views/qna/QnaDetail.jsp").forward(request,response);

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
