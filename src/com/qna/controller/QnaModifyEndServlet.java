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
 * Servlet implementation class QnaModifyEndServlet
 */
@WebServlet("/qna/qnaModifyEnd")
public class QnaModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaModifyEndServlet() {
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
		
		System.out.println("end servlet"+q);
		
		// 데이터 가져오기 
		q.setqSeq(mr.getParameter("qSeq"));
		q.setqTitle(mr.getParameter("qnaTitle"));
		q.setUserId(mr.getParameter("qnaWriter"));
		
		// 개행된 content가져오기
		String contents = mr.getParameter("qnaContent");
		q.setqContents(contents.replace("\r\n", "<br>"));
		
		// 파일데이터 가져오기 
		String ori = mr.getParameter("oriFile");
		String modi = mr.getFilesystemName("up_file");
		if(modi==null) {
			q.setqFile(ori);
		}else {
			q.setqFile(modi);
		}
		
	
		
		// 날짜 가져오기
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(mr.getParameter("qnaDate")); 
		    java.sql.Date dateSelected = new java.sql.Date(selectedDate.getTime());
			//n.setnDate(new Date(Date.parse(request.getParameter("noticeDate"))));
		    q.setqDate(dateSelected);
		    //System.out.println(dateSelected);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("end servlet"+q);
		
		int result = service.modifyQna(q);
		
		if(result > 0) {
			// 리뷰 등록 성공
			request.setAttribute("msg", "Q&A를 성공적으로 수정했습니다");
			request.setAttribute("loc", "/qna/qnaList");
		} else {
			request.setAttribute("msg", "Q&A수정에 실패하셨습니다");
			request.setAttribute("loc", "/qna/qnaList");
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
