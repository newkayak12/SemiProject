package com.notice.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.notice.model.vo.Notice;

public class NoticeDao {
private Properties prop=new Properties();

	
	public NoticeDao() {
		String path=NoticeDao.class.getResource("/properties/sql/notice.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Notice> selectNoticeList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Notice> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectNoticeList"));
			// 쿼리문에서 물음표에 해당하는 값을 pstmt.set~으로 해주는 거임
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Notice n=new Notice();
				n.setnSeq(rs.getString("n_seq"));
				n.setUserId(rs.getString("user_id"));
				n.setnTitle(rs.getString("n_title"));
				n.setnContent(rs.getString("n_content"));
				n.setnDate(rs.getDate("n_date"));
				n.setnDelete(rs.getInt("n_delete"));
				n.setnCount(rs.getInt("n_count"));
				list.add(n);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectNoticeCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public Notice selectNotice(Connection conn, String no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Notice n=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectNotice"));
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				n=new Notice();
				n.setnSeq(rs.getString("n_seq"));
				n.setUserId(rs.getString("user_id"));
				n.setnTitle(rs.getString("n_title"));
				n.setnContent(rs.getString("n_content"));
				n.setnDate(rs.getDate("n_date"));
				n.setnDelete(rs.getInt("n_delete"));
				n.setnCount(rs.getInt("n_count"));
				
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return n;
	}

	public int postNotice(Connection conn, Notice n) {
		PreparedStatement pstmt=null;
		int result=0;
		System.out.println(prop.getProperty("postNotice"));
		System.out.println(n.getnDate());
		try {
			pstmt=conn.prepareStatement(prop.getProperty("postNotice"));
			pstmt.setString(1, "testusers");
			pstmt.setString(2,n.getnTitle());
			pstmt.setString(3, n.getnContent());
			pstmt.setDate(4, n.getnDate());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int deleteNotice(Connection conn, String NoticeNo) {
		
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteNotice"));
			pstmt.setInt(1, 1);
			pstmt.setString(2, NoticeNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int modifyNotice(Connection conn, Notice n) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("modifyNotice"));
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, "testusers");
			pstmt.setDate(3, n.getnDate());
			pstmt.setString(4, n.getnContent());
			pstmt.setString(5, n.getnSeq());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
