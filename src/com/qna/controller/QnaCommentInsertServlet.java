package com.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String qRef = request.getParameter("QnaRef");
		String userId = request.getParameter("commentWrtier");
		int qCommentref = Integer.parseInt(request.getParameter("QnaCommentLevel"));
		
		
		
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
