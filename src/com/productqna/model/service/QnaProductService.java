package com.productqna.model.service;

import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.List;


import com.productqna.model.dao.QnaProductDao;
import com.productqna.model.vo.ProductQna;

public class QnaProductService {

	public List<ProductQna> showlist(String pid, String cid) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<ProductQna> result = new QnaProductDao().showlist(conn, pid, cid);
		
		close(conn);
		
		return result;
	}

	public List<ProductQna> detailshow(String qseq) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		
		List<ProductQna> result  = new QnaProductDao().detailShow(qseq, conn);
		
		close(conn);
		return result;
	}

}
