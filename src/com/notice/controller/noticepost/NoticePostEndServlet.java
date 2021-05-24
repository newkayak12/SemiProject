package com.notice.controller.noticepost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticePostEndServlet
 */
@WebServlet("/notice/post/end/admin")
public class NoticePostEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePostEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice n=new Notice();
		
		n.setnTitle(request.getParameter("noticeTitle"));
		n.setUserId(request.getParameter("noticeWriter"));
//		n.setNoticeTitle(request.getParameter("noticeTitle"));
//		n.setNoticeWriter(request.getParameter("noticeWrite"));
//		n.setNoticeContent(request.getParameter("content"));
//		int result=new NoticeService().insertNotice(n);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
