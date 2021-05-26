package com.qna.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.qna.model.vo.Qna;



public class QnaDao {
	private Properties prop=new Properties();

	
	public QnaDao() {
		String path=QnaDao.class.getResource("/properties/sql/qna.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	public List<Qna> selectQnaList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Qna> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectQnaList"));
			// 쿼리문에서 물음표에 해당하는 값을 pstmt.set~으로 해주는 거임
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Qna q = new Qna();
				q.setqSeq(rs.getString("q_seq"));
				q.setUserId(rs.getString("user_id"));
				q.setqTitle(rs.getString("q_title"));
				q.setqContents(rs.getString("q_contents"));
				q.setqFile(rs.getString("q_file"));
				q.setqDate(rs.getDate("q_date"));
				list.add(q);
			}
		}	catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
	}


	public int selectQnaCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectQnaCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}


	public int postQna(Connection conn, Qna q) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("postQna"));
			pstmt.setString(1, q.getUserId()); 
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContents());
			pstmt.setString(4, q.getqFile());
			pstmt.setDate(5, q.getqDate());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}
}
