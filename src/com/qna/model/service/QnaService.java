package com.qna.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.notice.model.vo.Notice;
import com.qna.model.dao.QnaDao;
import com.qna.model.vo.Qna;
import com.qna.model.vo.QnaComment;
import com.review.model.vo.Review;

public class QnaService {
	
	private QnaDao dao = new QnaDao();
	
	//Qna 리스트 가져오기
	public List<Qna> selectQnaList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Qna> list=dao.selectQnaList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}

	// Qna 리스트 중 데
	public int selectQnaCount() {
		Connection conn=getConnection();
		int result=dao.selectQnaCount(conn);
		close(conn);
		return result;
	}

	// Qna 상세페이지 
	public Qna selectQna(String no) {
		Connection conn=getConnection();
		Qna q = dao.selectQna(conn, no);
		close(conn);
		return q;
	}
	
	// Qna 등록페이지
	public int postQna(Qna q) {
		Connection conn = getConnection();

		int result = dao.postQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertQnaComment(QnaComment qc) {
		Connection conn=getConnection();
		System.out.println("service에서 qc" + qc);
		
		
		int result=dao.insertQnaComment(conn,qc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	// Qna 댓글 등록
	// 댓글같은 경우 해당 Board를 참조하고 있기 때문에 BoardRef를 매개변수로 받아와야 함.
		public List<QnaComment> selectQnaComment(String no){
			Connection conn=getConnection();
			List<QnaComment> list=dao.selectQnaComment(conn,no);
			close(conn);
			return list;
		}

		public int deleteQna(String no) {
			Connection conn=getConnection();
			int result=dao.deleteQna(conn,no);
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		public int deleteQnaComment(String no) {
			Connection conn = getConnection();
			
			int result = dao.deleteQnaComment(conn, no);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			
			return result;
		}

		public int modifyQna(Qna q) {
			Connection conn = getConnection();
			System.out.println("서비스" + q);
			int result = dao.modifyQna(conn, q);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			return result;
		}

		public int modifyQnaComment(String commentNo, String commentContent) {
			Connection conn = getConnection();
			int result = dao.modifyQnaComment(conn, commentNo, commentContent);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result;
		}
	

}
