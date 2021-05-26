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

	public List<QnaComment> selectQnaComment(String qRef) {
		Connection conn=getConnection();
		List<QnaComment>  list=dao.selectQnaComment(conn,qRef);
		close(conn);
		return list;
	}

	// Qna에 달린 댓글
	

}
