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

import com.productqna.model.vo.ProductQna;
import com.qna.model.vo.Qna;
import com.qna.model.vo.QnaComment;



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


	public Qna selectQna(Connection conn, String no) {
		
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		Qna q=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectQna"));
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				q = new Qna();
				q.setqSeq(rs.getString("q_seq"));
				q.setUserId(rs.getString("user_id"));
				q.setqTitle(rs.getString("q_title"));
				q.setqContents(rs.getString("q_contents"));
				q.setqFile(rs.getString("q_file"));
				q.setqDate(rs.getDate("q_date"));

//				private String qCommentSeq; // 댓글번호
//				private String qCommentContens; // 댓글 내용
//				private Date qCommentDate;
//				
//				q.setqCommentSeq(rs.getString("q_c_seq"));
//				q.setqCommentContens(rs.getString("q_c_comment"));
//				q.setqDate(rs.getDate("q_c_date"));
				
				System.out.println("select QNA"+q);
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return q;
	}


	public int insertQnaComment(Connection conn, QnaComment qc) {
		PreparedStatement pstmt=null;
		int result=0;
		System.out.println("dao에서 " + qc);
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertQnaComment"));
//			insertQnaComment = INSERT INTO QNA_COMMENT VALUES(QC_SEQ.NEXTVAL,?,?,?,?)
//			USER_ID, Q_C_COMMENT, Q_C_REF = Q_SEQ
			
			pstmt.setString(1, qc.getUserId());
			pstmt.setString(2, qc.getqComment());
			pstmt.setString(3, qc.getqRef());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public List<QnaComment> selectQnaComment(Connection conn, String no){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<QnaComment> list=new ArrayList();
		try {
			// selectQnaComment = SELECT * FROM QNA_COMMENT WHERE Q_C_REF = ?

			pstmt=conn.prepareStatement(prop.getProperty("selectQnaComment"));
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				QnaComment qc = new QnaComment();
				// Q_C_SEQ, USER_ID, Q_C_COMMENT, Q_C_DATE, Q_C_REF = Q_SEQ
				
				qc.setqSeq(rs.getString("q_c_seq"));
				qc.setUserId(rs.getString("user_id"));
				qc.setqComment(rs.getString("q_c_comment"));
				qc.setqDate(rs.getDate("q_c_date"));
				qc.setqRef(rs.getString("q_c_ref"));
				list.add(qc);
				System.out.println("dao 에서 rs 후"+list);
				
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;

	}


	public int deleteQna(Connection conn, String no) {

		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteQna"));
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteQnaComment(Connection conn, String no) {
		PreparedStatement pstmt = null;

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deleteQnaComment"));			
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			close(pstmt);
		}
		return result;
	}


	public int modifyQna(Connection conn, Qna q) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		System.out.println("dao"+q);
		try {
			pstmt = conn.prepareStatement(prop.getProperty("modifyQna"));
//			UPDATE QNA SET Q_TITLE = ?, Q_CONTENTS=?, Q_DATE=?, Q_DATE=? WHERE Q_SEQ =?
			pstmt.setString(1, q.getqTitle());
			pstmt.setString(2, q.getqContents());
			pstmt.setString(3, q.getqFile());
			pstmt.setDate(4, q.getqDate());
			pstmt.setString(5, q.getqSeq());
			System.out.println("dao 끝자락" +q);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();			
		} finally {
			
			close(pstmt);
		}
		System.out.println("성공여부"+result);
		return result;
	}


	public int modifyQnaComment(Connection conn, String commentNo, String commentContent) {
PreparedStatement pstmt = null;
		
		int result = 0;
		// modifyQnaComment = UPDATE QNA_COMMENT SET Q_C_COMMENT =?, Q_C_DATE = SYSDATE WHERE Q_C_SEQ =?
		try {
			
			pstmt = conn.prepareStatement(prop.getProperty("modifyQnaComment"));
			
			pstmt.setString(1, commentContent);
			pstmt.setString(2, commentNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}


	public List<Qna> MyQnaList(Connection conn, int cPage, int numPerPage, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Qna> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("MyQnaList"));
			
			pstmt.setString(1, id);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
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


	public int selectMyQnaCount(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMyQnaCount"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}


	public List<ProductQna> MyProductDetailQnaList(Connection conn, int cPage, int numPerPage, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductQna> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("MyProductDetailQnaList"));
			
			pstmt.setString(1, id);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductQna pq = new ProductQna();
				pq.setQnaProductSeq(rs.getString("q_p_seq"));
				pq.setQnaUserId(rs.getString("user_id"));
				pq.setQnaTitle(rs.getString("q_title"));
				pq.setQnaContent(rs.getString("q_contents"));
				pq.setQnaDate(rs.getDate("q_date"));
				
				list.add(pq);
			}
		}	catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return list;
	}


	public int MyProductDetailQnaCount(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("MyProductDetailQnaCount"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}


	public ProductQna selectMyProductQnaDetail(Connection conn, String id, String qSeq) {


		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		ProductQna pq=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMyProductQnaDetail"));
			pstmt.setString(1, id);
			pstmt.setString(2, qSeq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pq = new ProductQna();
				
				pq.setQnaProductSeq(rs.getString("q_p_seq"));
				pq.setQnaUserId(rs.getString("user_id"));
				pq.setQnaTitle(rs.getString("q_title"));
				pq.setQnaContent(rs.getString("q_contents"));
				pq.setQnaDate(rs.getDate("q_date"));

				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return pq;
			
	}
}
