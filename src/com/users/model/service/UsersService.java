package com.users.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.users.model.dao.UsersDao;
import com.users.model.vo.Users;
public class UsersService {
	
	private UsersDao dao = new UsersDao();
	
	public int deleteusers(String userId, String userPwd) {
		Connection conn=getConnection();
		int result = dao.deleteusers(conn, userId, userPwd);
		
		if(result!=0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		System.out.println("서비스?");
		close(conn);
		return result;
	}
	
	
	public int checkid(String userid) {
		Connection conn=getConnection();
		int result = dao.checkid(conn,userid);
		close(conn);
		return result;
	}
	
	
	public Users selectUsersupdate(String userId) {
		Connection conn=getConnection();
		Users result = dao.selectUsersupdate(conn, userId);
		
		close(conn);
		return result;
	}
	
	public int updateUsers(Users u) {
		Connection conn=getConnection();
		int result = dao.updateUsers(conn, u);
		
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	public Users login(String userId, String userPwd) {
		Connection conn=getConnection();
		Users u=dao.login(conn,userId,userPwd);
		close(conn);
		return u;
	}
	
	public int join(Users u){
			Connection conn=getConnection();
			int result=dao.join(conn,u);
			
			if(result!=0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
	
	
	
	
	public Users searchid(Users u) {
		Connection conn=getConnection();
		Users user=dao.searchid(conn,u);
		close(conn);
		return user;
		
	}
	
	public Users searchpw(Users u) {
		Connection conn=getConnection();
		Users user=dao.searchpw(conn,u);
		close(conn);
		return user;
	}
	
	/*여기서 부터 관리자용 */	
	
		public List<Users> selectadminUsers() {
		Connection conn = getConnection();
		List<Users> list = dao.selectadminUsers(conn);
		return list;
	}


		public int updateadminUsers(String userId, String userStatus) {
			Connection conn = getConnection();
			int result = dao.updateadminUsers(conn, userId, userStatus);
			

			if(result!=0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
			close(conn);
			
			return result;
		}
		
		
}



