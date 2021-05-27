package com.admin.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.admin.model.dao.AdminDao;
import com.review.model.vo.Review;

public class AdminService {
	
	
	private AdminDao dao = new AdminDao();

	
	
	public List<Review> adminSelectAllReview(int cPage, int numPerPage) {
		
		Connection conn = getConnection();
		
		List<Review> list = dao.adminSelectAllReview(conn, cPage, numPerPage);
		
		close(conn);
		
		return list;
	}



	public int adminCountAllReview() {

		Connection conn = getConnection();
		
		int count = dao.adminCountAllReview(conn);
		
		close(conn);
		
		return count;
	}
	
	
	

}
