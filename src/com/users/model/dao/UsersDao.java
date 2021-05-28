package com.users.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public int deleteusers(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt=null;
		
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteusers"));
			System.out.println("다오?");
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	public int checkid(Connection conn, String userid) {
		int result=1;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectone"));
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return result;
	}
	
	
	
	public Users selectUsersupdate(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		Users u = null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectuserupdate"));
			
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				u = new Users();
				u.setUserId(rs.getString("user_id"));
				u.setUserPwd(rs.getString("user_pwd"));
				u.setUserAddr(rs.getString("user_addr"));
				u.setUserZip(rs.getString("user_zip"));
				u.setUserName(rs.getString("USER_NAME"));
				u.setUserEmail(rs.getString("user_email"));
				u.setUserPhone(rs.getString("user_phone"));
				
						System.out.println("dao, u : " + u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return u;
	}
	
	public int updateUsers(Connection conn, Users u) {
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateusers"));
			pstmt.setString(1, u.getUserAddr());
			pstmt.setString(2, u.getUserPwd());
			pstmt.setString(3, u.getUserZip());
			pstmt.setString(4, u.getUserName());
			pstmt.setString(5, u.getUserEmail());
			pstmt.setString(6, u.getUserPhone());
			pstmt.setString(7, u.getUserId());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public Users searchpw(Connection conn, Users u) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users user = null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectsearchpw"));
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPhone());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				user=new Users();
				user.setUserPwd(rs.getString("user_pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
	
	public Users searchid(Connection conn, Users u) {
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		Users user=null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectsearchid"));
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getUserPhone());
			//원래는 이거 받고, api로 검증해서 넘기는거다. 
			//플래그는 고정이어서 properties에 직접 그냥 쓰면 된다. 

			rs=pstmt.executeQuery();
			if(rs.next()) {

				user=new Users();
				user.setUserId(rs.getString("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
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
	
	public List<Users> selectadminUsers(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users u = null;
		List<Users> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectadminUsers"));
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				u=new Users();
				u.setUserId(rs.getString("user_Id"));
				u.setUserName(rs.getString("user_name"));
				u.setUserStatus(rs.getInt("user_status"));
				
				list.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
		
	}

	public int updateadminUsers(Connection conn, String userId, String userStatus) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String query=prop.getProperty("adminuserupdate");
			
			if(userStatus.equals("1")) {
				query=query.replace("@", "0");
			}
			else {
				query=query.replace("@", "1");
			}
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
}
