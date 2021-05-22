package com.review.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.order.model.vo.Order;
import com.product.model.vo.Product;
import com.review.model.vo.Review;

public class ReviewDao {
	
	
	
	private Properties prop = new Properties();
	
	
	
	public ReviewDao() {

		
		String filePath = ReviewDao.class.getResource("/properties/sql/review.properties").getPath();
		
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public List<Review> selectAllReview(Connection conn, int cPage, int numPerPage) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
				
		Review r = null;
		
		List<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectAllReview"));
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				r = new Review();
				
				r.setReviewNo(rs.getString("r_seq"));
				r.setUserId(rs.getString("user_id"));
				r.setProductId(rs.getString("p_id"));
				r.setProductOptionSize(rs.getString("p_o_size"));
				r.setProductOptionColor(rs.getString("p_o_color"));
				r.setReviewTitle(rs.getString("r_title"));
				r.setReviewContents(rs.getString("r_contents"));
				r.setReviewDate(rs.getDate("r_date"));
				r.setReviewDelete(rs.getString("r_delete"));
				r.setReviewCount(rs.getString("r_count"));
				r.setReviewFile(rs.getString("r_file"));
				r.setReviewLike(rs.getString("r_like"));
				r.setOrderNumber(rs.getString("o_number"));
				r.setCategoryId(rs.getString("c_id"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		
		return list;
	}



	public int countAllReview(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("countAllReview"));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 1은 컬럼인덱스번호 
				// 또는 count(*)에 별칭부여해서 그걸 사용해도 됌 
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}



	public Review selectReview(Connection conn, String reviewNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Review r = null;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectReview"));
			
			pstmt.setString(1, reviewNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				r = new Review();
				
				r.setReviewNo(rs.getString("r_seq"));
				r.setUserId(rs.getString("user_id"));
				r.setProductId(rs.getString("p_id"));
				r.setProductOptionSize(rs.getString("p_o_size"));
				r.setProductOptionColor(rs.getString("p_o_color"));
				r.setReviewTitle(rs.getString("r_title"));
				r.setReviewContents(rs.getString("r_contents"));
				r.setReviewDate(rs.getDate("r_date"));
				r.setReviewDelete(rs.getString("r_delete"));
				r.setReviewCount(rs.getString("r_count"));
				r.setReviewFile(rs.getString("r_file"));
				r.setReviewLike(rs.getString("r_like"));
				r.setOrderNumber(rs.getString("o_number"));
				r.setCategoryId(rs.getString("c_id"));
				r.setProductName(rs.getString("p_name"));
				r.setProductFile(rs.getString("p_file"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return r;
	}



	public int deleteReview(Connection conn, String reviewNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			// deleteReview = UPDATE REVIEW SET R_DELETE = ? WHERE R_SEQ = ? 
			pstmt = conn.prepareStatement(prop.getProperty("deleteReview"));
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	public int modifyReview(Connection conn, Review r) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			// modifyReview = UPDATE REVIEW SET R_TITLE = ?, R_CONTENTS = ?, R_FILE = ? WHERE R_SEQ = ? 
			pstmt = conn.prepareStatement(prop.getProperty("modifyReview"));
			
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContents());
			pstmt.setString(3, r.getReviewFile());
			pstmt.setString(4, r.getReviewNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}

	
	public Product selectProduct(Connection conn, String orderNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Product p = null;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectProduct"));
			
			pstmt.setString(1, orderNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				p = new Product();
				
				p.setProductId(rs.getInt("p_id"));
				p.setProductName(rs.getString("p_name"));
				p.setProductOptionColor(rs.getString("p_o_color"));
				p.setProductOptionSize(rs.getString("p_o_size"));
				p.setProductFile(rs.getString("p_file"));
				
				
						System.out.println("ReviewDao에서 테스트, p : " + p);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return p;
	}


	
	
	
	
	
	public int postReview(Connection conn, Review r) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("postReview"));
			
//			pstmt.setString(1, );
//			pstmt.setString(2, x);
//			pstmt.setString(3, x);
//			pstmt.setString(4, x);
//			pstmt.setString(5, x);
//			pstmt.setString(6, x);
//			pstmt.setString(7, x);
//			pstmt.setString(8, x);
//			pstmt.setString(9, x);
//			pstmt.setString(10, x);
//			pstmt.setString(11, x);
//			pstmt.setString(12, x);
//			pstmt.setString(13, x);
//			pstmt.setString(14, x);
//			pstmt.setString(15, x);
//			pstmt.setString(16, x);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	
	
	

}
