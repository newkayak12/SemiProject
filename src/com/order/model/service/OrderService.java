package com.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.order.model.dao.OrderDao;
import com.order.model.vo.Order;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.close;

public class OrderService {

	public List<Order> showallOrder(int cPage, int numPerPage, String id) {
		Connection conn = getConnection();
		
		List<Order> result = new OrderDao().showallOrder(cPage, numPerPage, conn, id);
		
		close(conn);
		return result;
	}

	public int showallOrderCount(String id) {
		Connection conn = getConnection();
		
		int result = new OrderDao().showallOrderCount(conn, id);
		
		close(conn);
		return result;
	}

	public List<Order> showdetailOrder(String userid, String productid, String category, String size,  String color, int onumber, int odnum) {
		Connection conn=getConnection();
		
		List<Order> result = new OrderDao().showdetailOrder(userid, productid, category, size, color, onumber, odnum , conn);
		
		close(conn);
		
		
		
		return result;
	}
	

}
