package com.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.PageBar;
import com.productqna.model.vo.ProductQna;
import com.qna.model.service.QnaService;
import com.qna.model.vo.Qna;
import com.users.model.vo.Users;

/**
 * Servlet implementation class MyProDetailQnaDetailStartServlet
 */
@WebServlet("/qna/MyProDetailQnaDetailStartServlet")
public class MyProDetailQnaTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProDetailQnaTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// user 가져오기 
		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		String id = user.getUserId();
		
		// 글 번호
		String qSeq = request.getParameter("qSeq");
		
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
						
		
		QnaService service = new QnaService();
		
		ProductQna pq = new ProductQna();
		pq = service.selectMyProductQnaDetail(id, qSeq);
		
		request.setAttribute("pq",pq);
		
		request.getRequestDispatcher("/views/qna/MyProDetailQnaTitle.jsp").forward(request, response);
		
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
