package com.cart.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.cart.model.vo.Cart;
import com.order.model.dao.OrderDaobk;

import static com.common.JDBCTemplate.close;


public class CartDao {
	private Properties prop = null;
	private String path = CartDao.class.getResource("/properties/sql/cart.properties").getPath();
	
	public CartDao()  {

		
		try {
			prop = new Properties();
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cart selectCart(Connection conn, String pid, String category) {
			
				Cart cart = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
		try {
				pstmt = conn.prepareStatement(prop.getProperty("selectproduct"));
				
				pstmt.setString(1, pid);
				pstmt.setString(2, category);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					cart = new Cart();
					cart.setProductId(rs.getString("p_id"));
					//cid
					cart.setCartName(rs.getString("p_name"));
					cart.setProductFile(rs.getString("p_file"));
					cart.setProductExplain(rs.getString("p_explain"));
					
					
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return cart;
	}

}
