package com.product.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.product.model.dao.ProductDao;
import com.product.model.vo.Product;


public class ProductService {
	
	private ProductDao dao = new ProductDao();

	public List<Product> selectAllProduct(int cPage, int numPerpage, String sort, String category){
		Connection conn=getConnection();
		List<Product> list = dao.selectAllProduct(conn,cPage,numPerpage,  sort,  category);
		close(conn);
		return list;
	}
	
	public int countAllProduct(String sort, String category) {
		Connection conn = getConnection();
		int count = dao.countAllProduct(conn, sort, category);
		close(conn);
		return count;
	}
}
