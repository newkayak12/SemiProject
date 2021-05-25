package com.main.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.main.model.dao.MainProductDao;
import com.main.model.vo.MainProduct;

public class MainProductService {
	
	
	
	private MainProductDao dao = new MainProductDao();

	
	
	public List<MainProduct> selectProduct() {
		
		Connection conn=getConnection();
		
		List<MainProduct> list = dao.selectProduct(conn);
		
		close(conn);
		
		return list;
	}
	
	

}
