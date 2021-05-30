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
import com.productqna.model.vo.ProductQna;
import com.review.model.vo.Review;
import com.review.model.vo.ReviewComment;

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
				r.setProductName(rs.getString("p_name"));
				r.setProductFile(rs.getString("p_file"));
				
				// 추가된 필드 세팅
//				private String commentUserId;
//				private String reviewComment;
//				private String reviewCommentDate;
				
//				r.setCommentUserId(rs.getString("r_c_user_id"));
//				r.setReviewComment(rs.getString("r_comment"));
//				r.setReviewCommentDate(rs.getString("r_c_date"));
//				
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



	public List<Review> selectReview(Connection conn, String reviewNo) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		List<Review> list = new ArrayList<>();
		
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
				
				// 추가된 필드 세팅
//				private String commentUserId;
//				private String reviewComment;
//				private String reviewCommentDate;
				
				r.setCommentUserId(rs.getString("r_c_user_id"));
				r.setReviewComment(rs.getString("r_comment"));
				r.setReviewCommentDate(rs.getString("r_c_date"));
				
				// 추가된 필드
				
				r.setReviewCommentNo(rs.getString("r_c_seq"));
				
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
			
			// insert into review values('r-'||review_seq.nextval, 'testusers','001','XL','red','제목','내용입니다',sysdate, default, 0, '파일입니다', 1, '001', 'c01');
			pstmt = conn.prepareStatement(prop.getProperty("postReview"));
			
			pstmt.setString(1, r.getUserId()); 
			pstmt.setString(2, r.getProductId());
			pstmt.setString(3, r.getProductOptionSize());
			pstmt.setString(4, r.getProductOptionColor());
			pstmt.setString(5, r.getReviewTitle());
			pstmt.setString(6, r.getReviewContents());
			pstmt.setString(7, r.getReviewFile());
			pstmt.setString(8, r.getOrderNumber());
			pstmt.setString(9, r.getCategoryId());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	public int insertReviewComment(Connection conn, ReviewComment comment) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			// insertReviewComment = INSERT INTO REVIEW_COMMENT VALUES(REVIEW_COMMENT_SEQ, ?, ?, SYSDATE, ?)
																		// r_c_seq, r_c_user_id, r_comment, r_c_date, r_seq_ref
			pstmt = conn.prepareStatement(prop.getProperty("insertReviewComment"));
			
			pstmt.setString(1, comment.getReviewCommentUserId());
			pstmt.setString(2, comment.getReviewCommentContent());
			pstmt.setString(3, comment.getReviewNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	public int modifyReviewComment(Connection conn, String commentNo, String commentContent) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		// modifyReviewComment = UPDATE REVIEW_COMMENT SET R_COMMENT = ?, R_C_DATE = SYSDATE WHERE R_C_SEQ = ?
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("modifyReviewComment"));
			
			pstmt.setString(1, commentContent);
			pstmt.setString(2, commentNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}



	public int deleteReviewComment(Connection conn, String commentNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("deleteReviewComment"));
			
			pstmt.setString(1, commentNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}


	
	
	// 상품상세페이지에서 쓸 리뷰 조회
	public List<Review> selectProductReview(Connection conn, String productid) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
				
		Review r = null;
		
		List<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectProductReview"));
			
			pstmt.setString(1, productid);
			
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
	
	
	
	
	
	public int modifyReviewReadCount(Connection conn, String reviewNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		// UPDATE REVIEW SET R_COUNT = R_COUNT + 1 WHERE R_SEQ = ?
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("modifyReviewReadCount"));
			
			pstmt.setString(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}

		return result;

	
	}




	
	public List<Review> selectBestReview(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
				
		Review r = null;
		
		List<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectBestReview"));
			
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
	
	
	
	
	
	
	

	public List<Review> selectmain(Connection conn, int cPage, int numPerPage) {

		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
				
		Review r = null;
		
		List<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectmain"));
			
			pstmt.setInt(1, cPage);
			pstmt.setInt(2, numPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				r = new Review();
				
				r.setReviewNo(rs.getString("r_seq"));
				r.setUserId(rs.getString("user_id"));
				r.setProductId(rs.getString("p_id"));
				r.setProductOptionSize(rs.getString("p_o_size"));
				r.setProductOptionColor(rs.getString("p_o_color"));
				r.setReviewCount(rs.getString("r_count"));
				r.setProductName(rs.getString("p_name"));
				r.setReviewFile(rs.getString("r_file"));
				r.setProductPrice(rs.getString("p_price"));
				
				// 추가된 필드 세팅
//				private String commentUserId;
//				private String reviewComment;
//				private String reviewCommentDate;
				
//				r.setCommentUserId(rs.getString("r_c_user_id"));
//				r.setReviewComment(rs.getString("r_comment"));
//				r.setReviewCommentDate(rs.getString("r_c_date"));
//				
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



	public List<Review> MyReviewList(Connection conn, int cPage, int numPerPage, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Review> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("MyReviewList"));
			
			pstmt.setString(1, id);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Review r = new Review();
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
				r.setReviewNo(rs.getString("r_seq"));
				
				
				list.add(r);
			}
		}	catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
	}



	public int countAllMyReview(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("MyProductDetailQnaCount"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}



	
	
	

}