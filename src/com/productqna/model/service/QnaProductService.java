package com.productqna.model.service;

import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;
import java.sql.Connection;
import java.sql.SQLTransactionRollbackException;
import java.util.List;


import com.productqna.model.dao.QnaProductDao;
import com.productqna.model.vo.ProductQna;
import com.qna.model.dao.QnaDao;

public class QnaProductService {

	public List<ProductQna> showlist(String pid, String cid) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<ProductQna> result = new QnaProductDao().showlist(conn, pid, cid);
		
		close(conn);
		
		return result;
	}

	public ProductQna detailshow(String qseq) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		
		ProductQna result  = new QnaProductDao().detailShow(qseq, conn);
		
		close(conn);
		return result;
	}

	public List<ProductQna> comment(String qseq) {
		Connection conn = getConnection();
		
		
		List<ProductQna> result  = new QnaProductDao().comment(qseq, conn);
		
		close(conn);
		return result;
	}

	public int postqnacomment(String writer, String comment, String qseq) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = new QnaProductDao().postqnacomment(writer, comment, qseq, conn);
			
		if(result>0) {
			commit(conn);
			
		} else {
			
			rollback(conn);
		}
		return result;
	}

	public static int postqnamain(String qnauser, String qnatitle, String qnacontent, String pid, String cid, String userid) {
Connection conn = getConnection();
		
		int result = new QnaProductDao().postqnamain(qnauser, qnatitle, qnacontent, cid, pid, userid,  conn);
			
		if(result>0) {
			commit(conn);
			
		} else {
			
			rollback(conn);
		}
		return result;
	}

}
