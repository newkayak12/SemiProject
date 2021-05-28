package com.admin.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.admin.model.dao.AdminDao;
import com.admin.model.vo.product.ProductAjax;
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




	public List<ProductAjax> selectAllProductAdmin() {
		
		Connection conn = getConnection();
		
		List<ProductAjax> result = dao.selectAllProductAdmin(conn);
		// TODO Auto-generated method stub
				
		close(conn);

		return result;
	}

public int reviewHidden(String reviewNo, String rDelete) {
	
	Connection conn = getConnection();
	
	int result = dao.reviewHidden(conn, reviewNo, rDelete);
	
	if(result > 0) {
		commit(conn);
	} else {
		rollback(conn);
	}
	
	close(conn);
	return result;
	
}
	
	
	

}
