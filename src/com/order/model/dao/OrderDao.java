package com.order.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.order.model.vo.Order;
public class OrderDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Properties properties = null;
	
	
	public OrderDao() {
		String path = OrderDao.class.getResource("/properties/sql/order.properties").getPath();
		 properties = new Properties();
				 try {
					properties.load(new FileInputStream(path));
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public List<Order> showallOrder(int cPage, int numPerPage, Connection conn, String id) {
		List<Order> result = new ArrayList();	
		Order order = null;
				try {
					
						String sql = properties.getProperty("showall");
						sql = sql.replace("@", "환불처리중");
						sql = sql.replace("#", "환불완료");
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,id);
						pstmt.setInt(2, (cPage-1)*numPerPage+1);
						pstmt.setInt(3, cPage*numPerPage);
						
						rs = pstmt.executeQuery();
						
								while(rs.next()) {
									order = new Order();
									order.setOrderNumber(rs.getInt("O_NUMBER"));
									order.setProductId(rs.getString("P_ID"));
									order.setCategoryId(rs.getString("C_ID"));
									order.setProductSize(rs.getString("p_o_size"));
									order.setProductColor(rs.getString("P_O_color"));
									order.setProductStock(rs.getInt("O_D_COUNT"));
									order.setOrderDate(rs.getDate("O_DATE"));
									order.setOrderStatus(rs.getString("o_status"));
									order.setOrderCompleted(rs.getString("O_completed"));
									order.setProductName(rs.getString("P_NAME"));
									order.setProductPrice(rs.getInt("p_price"));
									order.setProductFile(rs.getString("p_file"));
									order.setAddress(rs.getString("user_addr"));
									order.setZipcode(rs.getString("user_zip"));
									order.setPhone(rs.getString("o_phone"));
									order.setOdno(rs.getString("O_D_No"));
									result.add(order);
									
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

	public int showallOrderCount(Connection conn, String id) {
		int result = 0;
				try {
						pstmt = conn.prepareStatement(properties.getProperty("showallCount"));
						pstmt.setString(1, id);
						
						rs = pstmt.executeQuery();
						
								if(rs.next()) {
									result = rs.getInt(1);
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

	public List<Order> showdetailOrder(String userid, String productid, String category, String size,  String color, int onumber, int odnum, Connection conn) {
		List<Order> result = new ArrayList();	
		Order order = null;
				try {
						pstmt = conn.prepareStatement(properties.getProperty("showdetail"));
						pstmt.setString(1, userid);
						pstmt.setInt(2, onumber);
						pstmt.setInt(3, odnum);
						pstmt.setString(4, productid);
						pstmt.setString(5, category);
						pstmt.setString(6, size);
						pstmt.setString(7, color);
						
						rs = pstmt.executeQuery();
						
								while(rs.next()) {
									
									order = new Order();
									order.setOrderNumber(rs.getInt("O_NUMBER"));
									order.setProductId(rs.getString("P_ID"));
									order.setCategoryId(rs.getString("C_ID"));
									order.setProductSize(rs.getString("p_o_size"));
									order.setProductColor(rs.getString("P_O_color"));
									order.setProductStock(rs.getInt("O_D_COUNT"));
									order.setOrderDate(rs.getDate("O_DATE"));
									order.setOrderStatus(rs.getString("o_status"));
									order.setOrderCompleted(rs.getString("O_completed"));
									order.setProductName(rs.getString("P_NAME"));
									order.setProductPrice(rs.getInt("p_price"));
									order.setProductFile(rs.getString("p_file"));
									order.setAddress(rs.getString("user_addr"));
									order.setZipcode(rs.getString("user_zip"));
									order.setPhone(rs.getString("o_phone"));
									order.setOdno(rs.getString("o_d_no"));
									result.add(order);
									
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
