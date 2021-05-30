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
 * Servlet implementation class MyProductDetailQnaServlet
 */
@WebServlet("/qna/MyProductDetailQna")
public class MyProductDetailQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProductDetailQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Product 상세 Qna만 가져오는 서블릿 
		
		// 유저 데이터를 보내야 함.
		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		String id = user.getUserId();	
		
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
	
		// ProductQna 정보 가져와서 List 뿌려줘야 함.
		List<ProductQna> list = new QnaService().MyProductDetailQnaList(cPage, numPerPage, id);
		request.setAttribute("list", list);
		
		
		int totalData = new QnaService().MyProductDetailQnaCount(id);
		String url = request.getContextPath()+"/qna/MyProductDetailQna";
		PageBar pageBar = new PageBar();
		
		String MyProductDetailQnaPageBar = pageBar.pageBar(cPage, numPerPage, totalData, url);
		request.setAttribute("MyProductDetailQnaPageBar",MyProductDetailQnaPageBar);
		
		request.getRequestDispatcher("/views/qna/MyProductDetailQna.jsp").forward(request, response);
		
		
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
