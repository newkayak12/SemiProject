package com.notice.model.service;

import java.sql.Connection;
import java.util.List;

import com.notice.model.dao.NoticeDao;
import com.notice.model.vo.Notice;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

public class NoticeService {

	private NoticeDao dao = new NoticeDao();
	
	public List<Notice> selectNoticeList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Notice> list=dao.selectNoticeList(conn,cPage,numPerpage);
		close(conn);
		return list;
		
	}
	
	public int selectNoticeCount() {
		Connection conn=getConnection();
		int result=dao.selectNoticeCount(conn);
		close(conn);
		return result;
	}

	public Notice selectNotice(String no) {
		Connection conn=getConnection();
		Notice n=dao.selectNotice(conn, no);
		close(conn);
		return n;
	}
}
