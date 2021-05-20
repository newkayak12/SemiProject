package com.users.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.users.model.vo.Users;
public class UsersDao {
	
	private Properties prop=new Properties();
	
	public UsersDao() {
		try {
			String filePath=UsersDao.class.getResource("/properties/sql/Users.properties").getPath();
			prop.load(new FileReader(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Users login(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Users u = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectUsers"));
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				u=new Users();
				u.setUserId(rs.getString("USER_ID"));
				u.setUserAddr(rs.getString("user_addr"));
				u.setUserZip(rs.getString("user_zip"));
				u.setUserName(rs.getString("USER_NAME"));
				u.setUserEmail(rs.getString("user_email"));
				u.setUserPhone(rs.getString("user_phone"));
				u.setUserAdmin(String.valueOf(rs.getInt("user_admin")));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}
	
	public int join(Connection conn,Users u) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertUsersjoin"));
			
			System.out.println("here?_dao");
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserAddr());
			pstmt.setString(3, u.getUserZip());
			pstmt.setString(4, u.getUserPwd());
			pstmt.setString(5, u.getUserName());
			pstmt.setString(6, u.getUserEmail());
			pstmt.setString(7, u.getUserPhone());
			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
