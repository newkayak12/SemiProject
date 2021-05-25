package com.cart.model.servcie;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.cart.model.dao.CartDao;
import com.cart.model.vo.Cart;

public class CartService {

	public Cart selectCart(String pid, String category) {
		
		Connection conn = getConnection();
		
		Cart cart = new CartDao().selectCart(conn, pid, category);
		
		close(conn);
		
		
		return cart;
	}

}
