package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties properties = new Properties();
		
			try {	
						String path = JDBCTemplate.class.getResource("/properties/driver/prop.properties").getPath();
							properties.load(new FileInputStream(path));
							
						String driver = properties.getProperty("driver");
						String url = properties.getProperty("url");
						String id = properties.getProperty("id");
						String pw = properties.getProperty("pw");
						
						Class.forName(driver);
							conn = DriverManager.getConnection(url,id,pw);
							conn.setAutoCommit(false);
					
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return conn;
	}
	
	public static void close(Connection conn) {
		try {
					if(conn!=null && !conn.isClosed()) {
						conn.close();
					}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	

	public static void close(Statement stmt) {
		try {
					if(stmt!=null && !stmt.isClosed()) {
						stmt.close();
					}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public static void close(ResultSet rs) {
		try {
					if(rs!=null && !rs.isClosed()) {
						rs.close();
					}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
}
