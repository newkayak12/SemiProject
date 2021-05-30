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

import org.apache.catalina.filters.AddDefaultCharsetFilter;

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

	public List<List<Order>> showallOrder(int cPage, int numPerPage, Connection conn, String id) {
		List<List<Order>> result = new ArrayList();	
		List<Order> semi = new ArrayList();
		Order o = null;
				try {
						pstmt = conn.prepareStatement(properties.getProperty("showall"));
			
						pstmt.setString(1,id);
						pstmt.setInt(2, (cPage-1)*numPerPage+1);
						pstmt.setInt(3, cPage*numPerPage);
						System.out.println("다오문제?");
						rs = pstmt.executeQuery();
						
								while(rs.next()) {
									o = new Order();
									o.setOrderNumber(rs.getString("o_number"));
									o.setOrderDate(rs.getDate("o_date"));
									o.setProductFile(rs.getString("p_file"));
									o.setProductName(rs.getString("p_name"));
									o.setTotalPrice(rs.getInt("o_totalprice"));
									semi.add(o);
									result.add(semi);
									
								}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
				}
				
				System.out.println("다오문제?-트라이 끝나고");
		
		
		return result;
	}

	public int showallOrderCount(Connection conn, String id) {
		int result = 0;
		Order order = null;
		List<Order> semi = new ArrayList<Order>();
				try {
						pstmt = conn.prepareStatement(properties.getProperty("showallCount"));
						pstmt.setString(1, id);
						
						rs = pstmt.executeQuery();
						
						while(rs.next()) {
							order = new Order();
							
							order.setOrderNumber(rs.getString("o_number"));
							order.setOrderDate(rs.getDate("o_date"));
							order.setProductFile(rs.getString("p_file"));
							order.setProductName(rs.getString("p_name"));
							order.setTotalPrice(rs.getInt("o_totalprice"));
							semi.add(order);
							
							
						}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
				}
				
				result = semi.size();
		
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

	public int insertOrder(Connection conn, String oname, String rname, String addr, String phone, String id, String zip, int totalPrice) {
		int result = 0;
		
		try {
				pstmt = conn.prepareStatement(properties.getProperty("insertorder"));
				pstmt.setString(1, id);
				pstmt.setString(2, addr);
				pstmt.setString(3, zip);
				pstmt.setString(4, oname);
				pstmt.setString(5, phone);
				pstmt.setString(6, rname);
				pstmt.setInt(7, totalPrice);
				
				result = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
//		id, add, zip, oname, ophone, rname
		
		return result;
	}

	public String oderNum(Connection conn, String oname, String rname) {
		String onum = "";
		try {
			pstmt = conn.prepareStatement(properties.getProperty("onum"));
			pstmt.setString(1, oname);
			pstmt.setString(2, rname);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				onum = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		// TODO Auto-generated method stub
		return onum;
	}

	public int insertOrderDetail(Connection conn, String onum, String pid, String cid, String size, String color, String stock) {
		int result = 0;
		
				try {
						pstmt = conn.prepareStatement(properties.getProperty("orderdetail"));
						pstmt.setString(1, onum);
						pstmt.setString(2, pid);
						pstmt.setString(3, cid);
						pstmt.setString(4, size);
						pstmt.setString(5, color);
						pstmt.setInt(6, Integer.parseInt(stock));
						
						result = pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
		
		return result;
	}

}
