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
import java.util.Date;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.getConnection;

import com.order.model.vo.Order;

import oracle.net.aso.p;
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
										String onum = rs.getString("o_number");
										o.setOrderNumber(onum);
										o.setOrderDate(rs.getDate("o_date"));
										o.setAddress(rs.getString("user_addr_o"));
										o.setZipcode(rs.getString("user_zip_o"));
										o.setPhone(rs.getString("o_phone"));
										o.setOrderusername(rs.getString("o_name"));
										o.setReceivername(rs.getString("r_name"));
										o.setTotalPrice(rs.getInt("o_totalprice"));
									result.add(o);
									
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

	public List<Order> showdetailOrder(String userid, String onumber, Connection conn) {
		List<Order> result = new ArrayList();	
		Order order = null;
				try {
						pstmt = conn.prepareStatement(properties.getProperty("showdetail"));
						
						pstmt.setString(1, onumber);
						
						
						rs = pstmt.executeQuery();
						
								while(rs.next()) {
									
									order = new Order();
									order.setCategoryId(rs.getString("c_id"));
									order.setProductId(rs.getString("p_id"));
									order.setProductSize(rs.getString("p_o_size"));
									order.setProductColor(rs.getString("P_O_color"));
									order.setOrderdetailcount(rs.getInt("o_d_count"));
									order.setOrderstat(rs.getString("o_status"));
									order.setProductName(rs.getString("p_name"));
									order.setProductFile(rs.getString("p_file"));
									order.setProductprice(rs.getString("p_price"));
									order.setOrderNumber(onumber);
									
									
									
									
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

	public Order plusProduct(Order a, Connection conn) {
		
		try {
				pstmt = conn.prepareStatement(properties.getProperty("showallproduct"));
				pstmt.setString(1, a.getOrderNumber());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					a.setProductFile(rs.getString("p_file"));
					a.setProductName(rs.getString("p_name"));
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		
		return a;
	}

	public Order countProduct(Order a, Connection conn) {
		try {
			pstmt = conn.prepareStatement(properties.getProperty("productcount"));
			pstmt.setString(1, a.getOrderNumber());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				a.setHowmany(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	public Order infos(String onumber, Order o, Connection conn) {

		
		try {
			pstmt = conn.prepareStatement(properties.getProperty("info"));
			pstmt.setString(1, onumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				o.setAddress(rs.getString("User_addr_o"));
				o.setReceivername(rs.getString("r_name"));
				o.setZipcode(rs.getString("user_zip_o"));
				o.setOrderDate(rs.getDate("o_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close (rs);
			close(pstmt);
		}
		
		return o;
		
	}

	public int refund(String cid, String pid, String size, String color, String onumber, Connection conn) {
		int result = 0;
		
		try {
			String sql = properties.getProperty("refund");
			sql = sql.replace("@", "환불처리중");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, pid);
			pstmt.setString(3, size);
			pstmt.setString(4, color);
			pstmt.setString(5, onumber);
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Order> refundlist(Connection conn) {
		List<Order> result = new ArrayList();
		Order o= null;
		try {
			String sql = properties.getProperty("refundlist");
			sql= sql.replace("@", "환불처리중");
			sql= sql.replace("#", "환불완료");
					
			pstmt=conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
			
			while(rs.next()) {
				o = new Order();
				o.setOrderNumber(rs.getString("o_number"));
				o.setUserid(rs.getString("user_id"));
				o.setAddress(rs.getString("user_addr_o"));
				o.setZipcode(rs.getString("user_zip_o"));
				o.setOrderDate(rs.getDate("o_date"));
				o.setOrderusername(rs.getString("o_name"));
				o.setPhone(rs.getString("o_phone").substring(1,6)+"*******");
				o.setReceivername(rs.getString("r_name"));
				o.setTotalPrice(rs.getInt("o_totalPrice"));
				o.setProductColor(rs.getString("p_o_color"));
				o.setProductSize(rs.getString("p_o_size"));
				o.setHowmany(rs.getInt("o_d_count"));
				o.setOrderstat(rs.getString("o_status"));
				o.setProductName(rs.getString("p_name"));
				o.setO_d_no(rs.getString("o_d_no"));
				
				
				
				result.add(o);
				
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

	public List<Order> adminlist(Connection conn) {
		List<Order> result = new ArrayList();
		Order o= null;
		try {
			String sql = properties.getProperty("adminlist");
			sql= sql.replace("@", "환불처리중");
			sql= sql.replace("#", "환불완료");
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				o = new Order();
				o.setOrderNumber(rs.getString("o_number"));
				o.setUserid(rs.getString("user_id"));
				o.setAddress(rs.getString("user_addr_o"));
				o.setZipcode(rs.getString("user_zip_o"));
				o.setOrderDate(rs.getDate("o_date"));
				o.setOrderusername(rs.getString("o_name"));
				o.setPhone(rs.getString("o_phone").substring(1,6)+"*******");
				o.setReceivername(rs.getString("r_name"));
				o.setTotalPrice(rs.getInt("o_totalPrice"));
				o.setProductColor(rs.getString("p_o_color"));
				o.setProductSize(rs.getString("p_o_size"));
				o.setHowmany(rs.getInt("o_d_count"));
				o.setOrderstat(rs.getString("o_status"));
				o.setProductName(rs.getString("p_name"));
				o.setO_d_no(rs.getString("o_d_no"));
				
				
				result.add(o);
				
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

	public int update(String no, String value, Connection conn) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(properties.getProperty("updatestatus"));
			pstmt.setString(1, value);
			pstmt.setString(2, no);
			
			
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
