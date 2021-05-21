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
				query= query.replace("@"," ");
				
				System.out.println("product all");
			} else {
				query = query.replace("@","where c_id = "+category);
			}
			
			if(sort.equals("p_view_count")) {
				query = query.replace("#","order by "+ sort +" desc");
				
				System.out.println("pviewcount"+query);
				
			} else {
				
				if(sort.equals("high")) {
					query = query.replace("#", "order by p_price desc");
				} else {
					query = query.replace("#", "order by p_price asc ");
					
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
				i.setProductOptionSize(rs.getString("p_o_size"));
				i.setProductOptionColor(rs.getString("p_option_color"));
				i.setProductName(rs.getString("p_name"));
				i.setProductPrice(rs.getString("p_price"));
				i.setProductStock(rs.getInt("p_stock"));
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
				query= query.replace("@"," ");
			} else {
				query = query.replace("@","where c_id = "+category);
			}
			
			if(sort.equals("p_view_count")) {
				query = query.replace("#","ordery by "+ sort +"desc");
				
			} else {
				
				if(sort.equals("high")) {
					query = query.replace("#", "order by p_price desc");
				} else {
					query = query.replace("#", "order by p_price asc ");
					
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
		
}
