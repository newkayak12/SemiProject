package com.qna.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.renamepolicy.QnaRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.qna.model.service.QnaService;
import com.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaPostEndServlet
 */
@WebServlet("/qna/qnaPostEnd")
public class QnaPostEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaPostEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QnaService service = new QnaService();
		
		// 파일 업로드  -> 
		if( !ServletFileUpload.isMultipartContent(request) ) {
			request.setAttribute("msg", "잘못된 요청입니다.");
			request.setAttribute("loc", "/qna/qnaList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		// qna문의시 사용자가 첨부한 이미지 저장하는 폴더경로
		String path = request.getServletContext().getRealPath("/upload/qna/");
		
		int maxSize = 1024*1024*10;
		
		String encode = "UTF-8";
		
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, new QnaRenamePolicy());
		
		Qna q = new Qna();
		
		// 1. 가져와야 하는 데이터  : 제목, 작성자, 날짜, 내용, 파일
	
		q.setqTitle(mr.getParameter("qnaTitle"));
		q.setUserId(mr.getParameter("qnaWriter"));
		// 날짜를 가져와 보자.
		
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("qnaDate")); 
		    java.sql.Date dateSelected = new java.sql.Date(selectedDate.getTime());
			//n.setnDate(new Date(Date.parse(request.getParameter("noticeDate"))));
		    q.setqDate(dateSelected);
		    //System.out.println(dateSelected);
		}catch(Exception e) {
			e.printStackTrace();
		}
		q.setqContents(mr.getParameter("qnaContent"));
		q.setqFile(mr.getFilesystemName("up_file"));
		
		//2. service - dao로 post 데이터 보내자
		int result = service.postQna(q);
		System.out.println("등록완료됐잖아");
		
		if(result > 0) {
			// 리뷰 등록 성공
			request.setAttribute("msg", "Q&A를 성공적으로 등록했습니다");
			request.setAttribute("loc", "/qna/qnaList");
		} else {
			request.setAttribute("msg", "Q&A등록을 실패했습니다");
			request.setAttribute("loc", "/");
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
