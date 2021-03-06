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
import com.product.model.vo.Product;
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
				
				// ????????? ?????? ??????
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
				result = rs.getInt(1); // 1??? ????????????????????? 
				// ?????? count(*)??? ?????????????????? ?????? ???????????? ??? 
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
			
			e.printStackTrace();
				
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return color;
		
	}



	public List<ProductAjax> sizepicker(Connection conn) {
		
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
					
			e.printStackTrace();
				
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		
		return size;
	}
	
	

	public List<ProductAjax> categorypicker(Connection conn) {
		
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
							
			e.printStackTrace();
		
		} finally {
			
			close(rs);
			close(pstmt);
		}
				
				
		return category;
	}
	



	
	public ProductAjax categorypicker(String cId, Connection conn) {
		
		//List<ProductAjax> category = new ArrayList();
		
		ProductAjax pro = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs= null;
		
				
		try {
						
			pstmt= conn.prepareStatement(prop.getProperty("selectCategory"));
						
						
			pstmt.setString(1,cId);
						
						
			rs= pstmt.executeQuery();
							
							
			while(rs.next()) {
								
								
				pro = new ProductAjax();
								
				pro.setcId(rs.getString("c_id"));
								
				pro.setCategoryName(rs.getString("c_name"));
								
				//category.add(pro);
								
			}

				
		} catch (SQLException e) {
					
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return pro;
	}



	public int searchProductDetail(Connection conn, String pId, String pColor, String pSize) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs= null;
		
		int result = 0;
		
		
		try {
			
			// searchProductDetail = 
			// SELECT COUNT(*) FROM PRODUCT_DETAIL WHERE P_ID = ? AND P_O_COLOR = ? AND P_O_SIZE = ?
			
			pstmt = conn.prepareStatement(prop.getProperty("searchProductDetail"));
			
			pstmt.setString(1, pId);
			pstmt.setString(2, pColor);
			pstmt.setString(3, pSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return result;
	}



	public int updateProductStock(Connection conn, String pId, String pColor, String pSize, int pstock) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			// updateProductStock = 
			// UPDATE PRODUCT_DETAIL SET P_DETAIL_STOCK = ? WHERE P_ID = ? AND P_O_COLOR = ? AND P_O_SIZE = ?
			pstmt = conn.prepareStatement(prop.getProperty("updateProductStock"));
			
			pstmt.setInt(1, pstock);
			pstmt.setString(2, pId);
			pstmt.setString(3, pColor);
			pstmt.setString(4, pSize);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
		
			close(pstmt);
		}
		
		
		return result;	
		
	}



	public int insertProductDetail(Connection conn, String pId, String cId, String pColor, String pSize, int pstock) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("insertProductDetail"));
			
			// pdetail, pid, cid, pocolor, posize, pdetailstock
			pstmt.setString(1, pId);
			pstmt.setString(2, cId);
			pstmt.setString(3, pColor);
			pstmt.setString(4, pSize);
			pstmt.setInt(5, pstock);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;	
		
	}



	public int postProduct(Connection conn, Product p) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			// postProduct = INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?. DEFAULT)
			pstmt = conn.prepareStatement(prop.getProperty("postProduct"));
			
			pstmt.setString(1, p.getCategoryId());
			pstmt.setString(2, p.getProductName());
			pstmt.setString(3, p.getProductPrice());
			pstmt.setString(4, p.getProductFile());
			pstmt.setString(5, p.getProductFileDetail1());
			pstmt.setString(6, p.getProductFileDetail2());
			pstmt.setString(7, p.getProductExplain());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		
		return result;
	}



	public List<Product> selectProductDetails(Connection conn, String pId) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs= null;
		
		List<Product> productDetails = new ArrayList<Product>();
		
		Product p = null;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("selectProductName"));
			
			pstmt.setString(1, pId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				p = new Product();
				
				p.setCategoryId(rs.getString("c_id"));
				p.setProductExplain(rs.getString("p_explain"));
				p.setProductFile(rs.getString("p_file"));
				p.setProductFileDetail1(rs.getString("p_file_detail1"));
				p.setProductFileDetail2(rs.getString("p_file_detail2"));
				p.setProductId(rs.getInt("p_id"));
				p.setProductName(rs.getString("p_name"));
				p.setProductOptionColor(rs.getString("p_o_color"));
				p.setProductOptionSize(rs.getString("p_o_size"));
				p.setProductPrice(rs.getString("p_price"));
				p.setProductStock(rs.getInt("p_detail_stock"));
				p.setProductViewCount(rs.getInt("p_view_count"));
				
				productDetails.add(p);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return productDetails;
	}



	
	
}
