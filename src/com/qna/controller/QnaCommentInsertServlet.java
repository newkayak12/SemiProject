package com.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qna.model.service.QnaService;
import com.qna.model.vo.QnaComment;

/**
 * Servlet implementation class QnaCommentServlet
 */
@WebServlet("/qna/inserQnaComment")
public class QnaCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 가져와야 할 것
		// 내용, 유저아이디, ref값
		
		String qRef = request.getParameter("qnaRef");
		String userId = request.getParameter("userId");
		String qCommentContent = request.getParameter("content");
		
		System.out.println("jsp에서 잘 받아오고 있는가?"+qRef + userId+qCommentContent);
		
		QnaComment qc = new QnaComment();
		qc.setqRef(qRef);
		qc.setUserId(userId);
		qc.setqComment(qCommentContent);
		
		int result = new QnaService().insertQnaComment(qc);
		
		String msg="";
		
		String loc="/qna/qnadetail?qSeq="+qRef;
		
		if(result>0) {
			//등록성공
			msg="댓글등록 성공";
		}else {
			//등록실패
			msg="댓글등록 실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
		
		
//    ----------------------------------------------------------------------------------		
//		int boardRef=Integer.parseInt(request.getParameter("boardRef"));
//		int boardCommentRef=Integer.parseInt(request.getParameter("boardCommentRef"));
//		int boardLevel=Integer.parseInt(request.getParameter("boardCommentLevel"));
//		String boardComment=request.getParameter("content");
//		String boardCommentWriter=request.getParameter("commentWriter");
//		
//		BoardComment bc=new BoardComment();
//		bc.setBoardCommentRef(boardCommentRef);
//		bc.setBoardCommentLevel(boardLevel);
//		bc.setBoardRef(boardRef);
//		bc.setBoardCommentWriter(boardCommentWriter);
//		bc.setBoardCommentContent(boardComment);
//		
//		int result=new BoardService().insertBoardComment(bc);
//		String msg="";
//		
//		String loc="/board/boardView?no="+boardRef;
//		
//		if(result>0) {
//			//등록성공
//			msg="댓글등록 성공";
//		}else {
//			//등록실패
//			msg="댓글등록 실패";
//		}
//		request.setAttribute("msg", msg);
//		request.setAttribute("loc", loc);
//		request.getRequestDispatcher("/views/common/msg.jsp")
//		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
