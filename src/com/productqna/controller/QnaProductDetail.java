package com.productqna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productqna.model.service.QnaProductService;
import com.productqna.model.vo.ProductQna;
import com.users.model.vo.Users;

/**
 * Servlet implementation class QnaProductDetail
 */
@WebServlet("/qna/product/detail")
public class QnaProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qseq = request.getParameter("qseq");
		String writer = request.getParameter("writer");
		
		Users user = (Users) request.getSession().getAttribute("user");
		String loc ="";
			
		
			if(user.getUserId().equals(writer)|| user.getUserAddr().equals("1")) {
				
				List<ProductQna> result = new QnaProductService().detailshow(qseq);
					loc="";
			} else {
				
					loc="/views/common/msg.jsp";
					request.setAttribute("loc", "/");
					request.setAttribute("msg", "잘못된 접근입니다.");
							
			}
			
			request.getRequestDispatcher(loc).forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
