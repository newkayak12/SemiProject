package com.product.model.dao;
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



import com.product.model.vo.Product;


public class ProductDao{
	
	private Properties prop = new Properties();
	
	public ProductDao() {
	
			
			String filePath = ProductDao.class.getResource("/properties/sql/product.properties").getPath();
			
			
			try {
				
				prop.load(new FileReader(filePath));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	
	// 전체상품 조회
	public List<Product> selectAllProduct(Connection conn, int cPage, int numPerpage, String sort, String category){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		try {
			String query = prop.getProperty("selectAllProduct");
			
			if(category.equals("all")) {
				query= query.replace("@","");
				
			} else {
//				category = "f.".concat(category);
				query = query.replace("@"," where c_id = '"+category+"'");
			}
			
			if(sort.equals("p_view_count")) {
//				sort = "f.".concat(sort);
//				System.out.println(sort);
				query = query.replace("#"," order by '"+ sort +"' desc");
				
				
			} else {
				
				if(sort.equals("high")) {
					query = query.replace("#", " order by to_number(p_price) desc");
				} else {
					query = query.replace("#", " order by to_number(p_price) asc ");
					
				}
				
				
				
				
			}
			
			
			
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			
			
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product i = new Product();
				i.setProductId(rs.getInt("p_id"));
				i.setCategoryId(rs.getString("c_id"));
				
				i.setProductName(rs.getString("p_name"));
				i.setProductPrice(rs.getString("p_price"));
				
				i.setProductFile(rs.getString("p_FILE"));
				i.setProductFileDetail1(rs.getString("p_FILE_detail1"));
				i.setProductFileDetail2(rs.getString("p_FILE_detail2"));
				i.setProductExplain(rs.getString("p_explain"));
				i.setProductViewCount(rs.getInt("p_view_count"));
				
				
				list.add(i);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	// 카운트
	public int countAllProduct(Connection conn, String sort, String category) {
		// SQL문 실행
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			
			String query = prop.getProperty("countAllProduct");
			
			if(category.equals("all")) {
				query= query.replace("@","");
				
			} else {
//				category = "f.".concat(category);
				query = query.replace("@"," where c_id = '"+category+"'" );
			}
			
			if(sort.equals("p_view_count")) {
//				sort = "f.".concat(sort);
//				System.out.println(sort);
				query = query.replace("#"," order by '"+ sort +"' desc");
				
				
			} else {
				
				if(sort.equals("high")) {
					query = query.replace("#", " order by p_price desc");
				} else {
					query = query.replace("#", " order by p_price asc ");
					
				}
				
				
				
				
			}
			
			
			pstmt = conn.prepareStatement(query);
			
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

	
	
	public List<Product> productDetail(String productid, String category, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> p = new ArrayList(); 
		try {
			pstmt = conn.prepareStatement(prop.getProperty("productDetail"));
			pstmt.setString(1, productid);
			pstmt.setString(2, category);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("p_id"));
				product.setCategoryId(rs.getString("c_id"));
				product.setProductName(rs.getString("p_name"));
				product.setProductPrice(rs.getString("p_price"));
				product.setProductFile(rs.getString("p_FILE"));
				product.setProductFileDetail1(rs.getString("p_FILE_detail1"));
				product.setProductFileDetail2(rs.getString("p_FILE_detail2"));
				product.setProductExplain(rs.getString("p_explain"));
				product.setProductViewCount(rs.getInt("p_view_count"));
				
				
				product.setProductOptionColor(rs.getString("p_o_color"));
				product.setProductOptionSize(rs.getString("p_o_size"));
				product.setProductStock(rs.getInt("p_detail_stock"));
				p.add(product);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return p;
	}

	
	
	// 상품 검색 
	public List<Product> searchProduct(Connection conn, String keyword) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		List<Product> searchResult = new ArrayList(); 
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("searchProduct"));
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Product p = new Product();
				
				p.setProductId(rs.getInt("p_id"));
				p.setCategoryId(rs.getString("c_id"));
				p.setProductName(rs.getString("p_name"));
				p.setProductPrice(rs.getString("p_price"));
				p.setProductFile(rs.getString("p_file"));
				p.setProductFileDetail1(rs.getString("p_file_detail1"));
				p.setProductFileDetail2(rs.getString("p_file_detail2"));
				p.setProductExplain(rs.getString("p_explain"));
				p.setProductViewCount(rs.getInt("p_view_count"));
				
				searchResult.add(p);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return searchResult;
	}

	public List<Product> keyword(Connection conn, String keyword) {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		Product p = null;
		List<Product> result = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("keyword"));
			String keywords = "%"+keyword+"%";
			pstmt.setString(1, keywords);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				p = new Product();
				p.setProductName(rs.getString("p_name"));
				result.add(p);
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

	
		
}
