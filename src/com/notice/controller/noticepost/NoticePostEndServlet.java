package com.notice.controller.noticepost;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notice.model.service.NoticeService;
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
		
		// 날짜가져오기
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("noticeDate")); 
		    java.sql.Date dateSelected = new java.sql.Date(selectedDate.getTime());
			//n.setnDate(new Date(Date.parse(request.getParameter("noticeDate"))));
		    n.setnDate(dateSelected);
		    //System.out.println(dateSelected);
		}catch(Exception e) {
			e.printStackTrace();
		}
		n.setnContent(request.getParameter("noticeContent"));
		int result=new NoticeService().postNotice(n);
		
		String msg="";
		String loc="";
		if(result>0) {
			msg="공지사항 작성 성공";
			loc="/notice/list";
		}else {
			msg="공지사항 작성 실패";
			loc="/notice/post/start/admin";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
