package com.review.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.order.model.vo.Order;
import com.product.model.vo.Product;
import com.review.model.dao.ReviewDao;
import com.review.model.vo.Review;

public class ReviewService {
	
	
	
	
	private ReviewDao dao = new ReviewDao();
	
	
	

	public List<Review> selectAllReview(int cPage, int numPerPage) {
		
		Connection conn = getConnection();
		
		List<Review> list = dao.selectAllReview(conn, cPage, numPerPage);
		
		close(conn);
		
		return list;
	}




	public int countAllReview() {
		
		Connection conn = getConnection();
		
		int count = dao.countAllReview(conn);
		
		close(conn);
		
		return count;
	}




	public List<Review> selectReview(String reviewNo) {
		
		Connection conn = getConnection();
		
		List<Review> list = dao.selectReview(conn, reviewNo);
		
		close(conn);
		
		return list;
	}




	public int deleteReview(String reviewNo) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteReview(conn, reviewNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}




	public int modifyReview(Review r) {
		
		Connection conn = getConnection();
		
		int result = dao.modifyReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	public int postReview(Review r) {
		
		Connection conn = getConnection();
		
		int result = dao.postReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}




	public Product selectProduct(String orderNo) {
		
		Connection conn = getConnection();
		
		Product p = dao.selectProduct(conn, orderNo);
		
		close(conn);
		
		return p;
	}

}