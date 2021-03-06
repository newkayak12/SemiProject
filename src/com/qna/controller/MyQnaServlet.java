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
import com.qna.model.service.QnaService;
import com.qna.model.vo.Qna;
import com.users.model.vo.Users;

/**
 * Servlet implementation class MyQnaServlet
 */
@WebServlet("/MyQna/list")
public class MyQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		String id = user.getUserId();
		System.out.println("session값으로 가져온 " + id);
		
		// 일반 QNA에 작성한 거 가져오기 
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
						
			List<Qna> list = new QnaService().MyQnaList(cPage, numPerPage, id);
			request.setAttribute("list", list);
			
			int totalData = new QnaService().selectMyQnaCount(id);
			String url = request.getContextPath()+"/MyQna/list";
			PageBar pageBar = new PageBar();
			
			String qnaPageBar = pageBar.pageBar(cPage, numPerPage, totalData, url);
			request.setAttribute("qnaPageBar",qnaPageBar);
			
			
			request.getRequestDispatcher("/views/qna/MyQnaList.jsp").forward(request, response);
			
	
					
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
