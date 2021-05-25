package com.notice.controller.noticemodify;

import java.io.IOException;
import java.text.ParseException;
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
 * Servlet implementation class NoticeModifyEndServlet
 */
@WebServlet("/notice/modify/end/admin")
public class NoticeModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Notice n=new Notice();
		
//		n.setnTitle(request.getParameter("noticeTitle"));
//		n.setUserId(request.getParameter("noticeWriter"));
		
		String Title = request.getParameter("noticeTitle");
		String userId = request.getParameter("noticeWriter");
		System.out.println(Title);
		System.out.println(userId);
		
		
		// 날짜가져오기
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("noticeDate")); 
		    java.sql.Date dateSelected = new java.sql.Date(selectedDate.getTime());
			//n.setnDate(new Date(Date.parse(request.getParameter("noticeDate"))));
		    n.setnDate(dateSelected);
		    
		    System.out.println(dateSelected);
		}catch(Exception e) {
			e.printStackTrace();
		}

		n.setnContent(request.getParameter("noticeContent"));
		
		int result=new NoticeService().modifyNotice(n);
		
		String msg="";
		String loc="";
		if(result>0){
			request.setAttribute("msg", "공지사항이 정상적으로 수정되었습니다.");
		}else {
			request.setAttribute("msg", "공지사항을 수정할 수 없습니다.");
		}
		request.setAttribute("loc","/notice/list" );
		
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
