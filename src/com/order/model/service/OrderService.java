package com.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.order.model.dao.OrderDaobk;
import com.order.model.vo.Orderbk;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.close;

public class OrderService {

	public List<Orderbk> showallOrder(int cPage, int numPerPage, String id) {
		Connection conn = getConnection();
		
		List<Orderbk> result = new OrderDaobk().showallOrder(cPage, numPerPage, conn, id);
		
		close(conn);
		return result;
	}

	public int showallOrderCount(String id) {
		Connection conn = getConnection();
		
		int result = new OrderDaobk().showallOrderCount(conn, id);
		
		close(conn);
		return result;
	}

	public List<Orderbk> showdetailOrder(String userid, String productid, String category, String size,  String color, int onumber, int odnum) {
		Connection conn=getConnection();
		
		List<Orderbk> result = new OrderDaobk().showdetailOrder(userid, productid, category, size, color, onumber, odnum , conn);
		
		close(conn);
		
		
		
		return result;
	}
	

}
