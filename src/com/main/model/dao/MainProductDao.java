package com.main.model.dao;

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

import com.main.model.vo.MainProduct;
import com.product.model.dao.ProductDao;
import com.product.model.vo.Product;

public class MainProductDao {
	
	
	private Properties prop = new Properties();
	
	
	public MainProductDao() {
	
			
			String filePath = ProductDao.class.getResource("/properties/sql/mainproduct.properties").getPath();
			
			
			try {
				
				prop.load(new FileReader(filePath));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	}

	

	public List<MainProduct> selectProduct(Connection conn) {
		
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		List<MainProduct> list=new ArrayList<>();
		
		try {
			
			pstmt=conn.prepareStatement(prop.getProperty("selectProduct"));
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				MainProduct p = new MainProduct();
				
				p.setProductId(rs.getInt("p_id"));
				p.setCategoryId(rs.getString("c_id"));
				
				p.setProductName(rs.getString("p_name"));
				p.setProductPrice(rs.getString("p_price"));
				
				p.setProductFile(rs.getString("p_FILE"));
				p.setProductFileDetail1(rs.getString("p_FILE_detail1"));
				p.setProductFileDetail2(rs.getString("p_FILE_detail2"));
				p.setProductExplain(rs.getString("p_explain"));
				p.setProductViewCount(rs.getInt("p_view_count"));
				
				
				list.add(p);
			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}
