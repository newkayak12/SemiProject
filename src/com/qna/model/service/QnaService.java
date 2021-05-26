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

public class QnaService {
	
	private QnaDao dao = new QnaDao();

	public List<Qna> selectQnaList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Qna> list=dao.selectQnaList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}

	public int selectQnaCount() {
		Connection conn=getConnection();
		int result=dao.selectQnaCount(conn);
		close(conn);
		return result;
	}

	public Qna selectQna(String no) {
		// TODO Auto-generated method stub
		return null;
	}

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
	

}
