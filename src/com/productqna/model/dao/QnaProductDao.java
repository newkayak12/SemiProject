package com.productqna.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

import com.productqna.model.vo.ProductQna;

public class QnaProductDao {
	Properties properties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public QnaProductDao() {
		// TODO Auto-generated constructor stub
		
		properties = new Properties();
		String path = QnaProductDao.class.getResource("/properties/sql/qnaproduct.properties").getPath();
		try {
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ProductQna> showlist(Connection conn, String pid, String cid) {
		// TODO Auto-generated method stub
			List<ProductQna> result = new ArrayList();
			ProductQna pq = null;
			try {
					pstmt= conn.prepareStatement(properties.getProperty("qnaall"));
					pstmt.setString(1, cid);
					pstmt.setString(2, pid);
					rs = pstmt.executeQuery();
					
					
					while(rs.next()) {
						pq = new ProductQna();
						pq.setQnaProductSeq(rs.getString("q_p_seq"));
						pq.setQnaUserId(rs.getString("user_id"));
						pq.setQnaTitle(rs.getString("q_title"));
						pq.setQnaDate(rs.getDate("q_date"));
						pq.setQnaContent(rs.getString("q_contents"));
						
//						
//						pq.setQnaCommentUserId(rs.getString("user_id_comment"));
//						pq.setQnaCommentcontent(rs.getString("q_p_c_comment"));
//						pq.setQnaCommentDate(rs.getDate("q_p_c_date"));
						
						
						result.add(pq);
						
					}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		return result;
	}

	public ProductQna detailShow(String qseq, Connection conn) {
		
		ProductQna pq = null;
		try {
			pstmt= conn.prepareStatement(properties.getProperty("qnadetail"));
			pstmt.setString(1, qseq);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				pq = new ProductQna();
				pq.setQnaProductSeq(rs.getString("q_p_seq"));
				pq.setQnaUserId(rs.getString("user_id"));
				pq.setQnaTitle(rs.getString("q_title"));
				pq.setQnaDate(rs.getDate("q_date"));
				pq.setQnaContent(rs.getString("q_contents"));
				
//				
//				pq.setQnaCommentUserId(rs.getString("user_id_comment"));
//				pq.setQnaCommentcontent(rs.getString("q_p_c_comment"));
//				pq.setQnaCommentDate(rs.getDate("q_p_c_date"));
				
				
				
				
			}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rs);
		close(pstmt);
	}


return pq;
	}

	public List<ProductQna> comment(String qseq, Connection conn) {
		List<ProductQna> result = new ArrayList();
		ProductQna pq = null;
		try {
			pstmt= conn.prepareStatement(properties.getProperty("comment"));
			pstmt.setString(1, qseq);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				pq = new ProductQna();
				
				
//				
				pq.setQnaCommentUserId(rs.getString("user_id"));
				pq.setQnaCommentcontent(rs.getString("q_p_c_comment"));
				pq.setQnaCommentDate(rs.getDate("q_p_c_date"));
				
				
				result.add(pq);
				
			}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rs);
		close(pstmt);
	}


return result;
	}

	public int postqnacomment(String writer, String comment, String qseq, Connection conn) {
		int result = 0;	
		
			try {
						pstmt = conn.prepareStatement(properties.getProperty("insertcomment"));
						pstmt.setString(1, writer);
						pstmt.setString(2, comment);
						pstmt.setString(3, qseq);
						result = pstmt.executeUpdate();
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		
		
		
		
		return result;
	}

	public int postqnamain(String qnauser, String qnatitle, String qnacontent, String cid, String pid,
			String userid, Connection conn) {
		int result = 0;
				try {
							pstmt=conn.prepareStatement(properties.getProperty("insertqna"));
							pstmt.setString(1, userid);
							pstmt.setString(2, qnatitle);
							
							pstmt.setString(3, qnacontent);
							pstmt.setString(4, cid);
							pstmt.setString(5, pid);
							
							result = pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					close(pstmt);
				}
		return result;
	}

}
