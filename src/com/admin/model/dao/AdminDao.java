package com.admin.model.dao;

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

import com.admin.model.vo.product.ProductAjax;
import com.review.model.dao.ReviewDao;
import com.review.model.vo.Review;

public class AdminDao {
	
	

	private Properties prop = new Properties();
	
	
	
	public AdminDao() {
		
		String filePath = ReviewDao.class.getResource("/properties/sql/admin.properties").getPath();
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}



	public List<Review> adminSelectAllReview(Connection conn, int cPage, int numPerPage) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
				
		Review r = null;
		
		List<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("adminSelectAllReview"));
			
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
				
				r.setReviewReportCount(rs.getInt("r_report_count"));
				
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



	public int adminCountAllReview(Connection conn) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("adminCountAllReview"));
			
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




	public List<ProductAjax> selectAllProductAdmin(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ProductAjax productajax = null;
		List<ProductAjax>  result = new ArrayList();
		
				try {
							pstmt=conn.prepareStatement(prop.getProperty("adminproductselect"));
							rs = pstmt.executeQuery();
							
							while(rs.next()) {
								productajax = new ProductAjax();
								productajax.setpId(rs.getString("p_id"));
								productajax.setcId(rs.getString("c_id"));
								productajax.setpName(rs.getString("p_Name"));
								productajax.setpPrice(rs.getString("p_price"));
								productajax.setpFile(rs.getString("p_file"));
//								productajax.setpFiledetail1(rs.getString("p_file_detail1"));
//								productajax.setpFiledetail2(rs.getString("p_file_detail2"));
								productajax.setpExplain(rs.getString("p_explain"));
//								productajax.setpDetail(rs.getString("p_detail"));
//								productajax.setColor(rs.getString("P_O_Color"));
//								productajax.setSize(rs.getString("p_o_size"));
//								productajax.setStock(rs.getInt("p_detail_stock"));
								
								result.add(productajax);
								
							}
							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
					close(rs);
					close(pstmt);
				}
		
		
		
		
		return result;

}
	
	
	public int reviewHidden(Connection conn, String reviewNo, String rDelete) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("reviewHidden");
		
		if(rDelete.equals("1")) {
			
			sql=sql.replace("@", "0");
			
		} else {
			
			sql=sql.replace("@", "1");
		}
		
		try {
			
			// UPDATE REVIEW SET R_DELETE = ? WHERE R_SEQ = ?
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;

	}



	public List<ProductAjax> colorpicker(Connection conn) {
		// TODO Auto-generated method stub
		List<ProductAjax> color = new ArrayList();
		ProductAjax pro = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
				try {
							pstmt= conn.prepareStatement(prop.getProperty("colorpicker"));
							rs= pstmt.executeQuery();
							
							while(rs.next()) {
								pro = new ProductAjax();
								pro.setColor(rs.getString("p_o_color"));
								
								color.add(pro);
								
							}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return color;
		
	}



	public List<ProductAjax> sizepicker(Connection conn) {
		// TODO Auto-generated method stub
		List<ProductAjax> size = new ArrayList();
		ProductAjax pro = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
				try {
							pstmt= conn.prepareStatement(prop.getProperty("sizepicker"));
							rs= pstmt.executeQuery();
								
								while(rs.next()) {
									pro = new ProductAjax();
									pro.setSize(rs.getString("p_o_size"));
									size.add(pro);
									
								}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
		return size;
	}



	public List<ProductAjax> categorypicker(Connection conn) {
		// TODO Auto-generated method stub
		List<ProductAjax> category = new ArrayList();
		ProductAjax pro = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
				try {
							pstmt= conn.prepareStatement(prop.getProperty("categorypicker"));
							rs= pstmt.executeQuery();
							
							while(rs.next()) {
								pro = new ProductAjax();
								pro.setcId(rs.getString("c_id"));
								pro.setCategoryName(rs.getString("c_name"));
								category.add(pro);
								
							}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return category;
	}
	
	
	
	
	
	
	
}
