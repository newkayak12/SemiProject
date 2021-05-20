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
	public List<Product> selectAllProduct(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectAllProduct"));
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
				i.setProductFile(rs.getString("p_file"));
				
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
	public int countAllProduct(Connection conn) {
		// SQL문 실행
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("countAllProduct"));
			
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
