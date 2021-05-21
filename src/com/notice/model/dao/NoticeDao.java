package com.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.notice.model.vo.Notice;
import static com.common.JDBCTemplate.close;

public class NoticeDao {
private Properties prop=new Properties();
	
	public NoticeDao() {
		String path=NoticeDao.class.getResource("/sql/notice_sql.properties").getPath();
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
				n.setUserAddr(rs.getString("user_addr"));
				n.setUserZip(rs.getString("user_zip"));
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
}
