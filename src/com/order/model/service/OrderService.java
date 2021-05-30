package com.order.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.order.model.dao.OrderDao;
import com.order.model.vo.Order;

public class OrderService {

	public List<Order> showallOrder(int cPage, int numPerPage, String id) {
		Connection conn = getConnection();
		
		List<Order> temp = new OrderDao().showallOrder(cPage, numPerPage, conn, id);
		List<Order> result = new ArrayList();
		
		for(Order a: temp ) {
			
			Order b = new OrderDao().plusProduct(a, conn );
			b = new OrderDao().countProduct (a, conn);
			result.add(b);
		}
		
		
		
		
		close(conn);
		return result;
	}

	public int showallOrderCount(String id) {
		Connection conn = getConnection();
		
		int result = new OrderDao().showallOrderCount(conn, id);
		close(conn);
		return result;
	}

	public List<Order> showdetailOrder(String userid, String onumber) {
		Connection conn=getConnection();
		
		List<Order> temp = new OrderDao().showdetailOrder(userid,  onumber , conn);
		List<Order> result = new ArrayList();
		for( Order o : temp ) {
			Order l = new OrderDao().infos(onumber, o, conn);
			result.add(l);
		}
		
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
