package com.notice.controller.noticelist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.PageBar;
import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징 처리 
		int cPage; // 현재페이지
		int numPerpage; // 페이지 당 5개만 띄우도록 하겠음.
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		try {
			numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			numPerpage=5;
		}
		
		List<Notice> list=new NoticeService().selectNoticeList(cPage,numPerpage);
		request.setAttribute("list", list);
		
		// 페이지 바
		int totalData=new NoticeService().selectNoticeCount();
		String url = request.getContextPath() + "/notice/list";
		PageBar pageBar = new PageBar();
		
		String noticePageBar = pageBar.pageBar(cPage, numPerpage, totalData, url);
		
		
		request.setAttribute("noticePageBar",noticePageBar);
		request.getRequestDispatcher("/views/notice/NoticeList.jsp")
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
