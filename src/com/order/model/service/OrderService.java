package com.order.model.service;

import java.sql.Connection;
import java.util.List;

import com.order.model.dao.OrderDao;
import com.order.model.vo.Order;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;

public class OrderService {

	public List<List<Order>> showallOrder(int cPage, int numPerPage, String id) {
		Connection conn = getConnection();
		
		List<List<Order>> result = new OrderDao().showallOrder(cPage, numPerPage, conn, id);
		
		close(conn);
		System.out.println("서비스문제?-올오더");
		return result;
	}

	public int showallOrderCount(String id) {
		Connection conn = getConnection();
		
		int result = new OrderDao().showallOrderCount(conn, id);
		System.out.println("서비스문제?-오더카운트");
		close(conn);
		return result;
	}

	public List<Order> showdetailOrder(String userid, String productid, String category, String size,  String color, int onumber, int odnum) {
		Connection conn=getConnection();
		
		List<Order> result = new OrderDao().showdetailOrder(userid, productid, category, size, color, onumber, odnum , conn);
		
		close(conn);
		
		
		
		return result;
	}

	public int insertOrder(String oname, String rname, String addr, String phone, String id, String zip, int totalPrice) {
		Connection conn = getConnection();
		
		int result = new OrderDao().insertOrder(conn, oname, rname, addr, phone,  id, zip, totalPrice);
				
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public String orderNum(String oname, String rname) {
		Connection conn = getConnection();
		String result = new OrderDao().oderNum(conn, oname, rname);
		close(conn);
		// TODO Auto-generated method stub
		return result;
	}

	public int insertOrderDetail(String onum, String pid, String cid, String size, String color, String stock) {
		Connection conn = getConnection();
		int result = new OrderDao().insertOrderDetail(conn,onum, pid, cid, size, color, stock);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		
		return result;
	}
	

}
