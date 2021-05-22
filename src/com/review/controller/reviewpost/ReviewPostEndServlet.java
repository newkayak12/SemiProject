package com.review.controller.reviewpost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.renamepolicy.ReviewRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/post/end")
public class ReviewPostEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReviewPostEndServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewService service = new ReviewService();
		

		//파일 업로드
		
		if( !ServletFileUpload.isMultipartContent(request) ) {
			request.setAttribute("msg", "잘못된 요청입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = request.getServletContext().getRealPath("/upload/review/");
		
		int maxSize = 1024*1024*10;
		
		String encode = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, new ReviewRenamePolicy());
		
		Review r = new Review();
		
		
		// insert into review values('r-'||review_seq.nextval, 'testusers','001','XL','red','제목','내용입니다',sysdate, default, 0, '파일입니다', '1', '001', 'c01');
		
		// 16개 중 3개 : 사용자가 입력한 값 : 제목, 파일, 내용
		r.setReviewContents(mr.getParameter("reviewContent"));
		r.setReviewFile(mr.getParameter("up_file"));
		r.setReviewTitle(mr.getParameter("reviewTitle"));
		
		// 16개 중 8개 : orderlist에서 가져온 상품을 hidden으로 가져온 값 
		r.setCategoryId(mr.getParameter("cId"));
		r.setOrderNumber(mr.getParameter("orderNo"));
		r.setProductFile(mr.getParameter("pFile"));
		r.setProductId(mr.getParameter("pId"));
		r.setProductName(mr.getParameter("pName"));
		r.setProductOptionColor(mr.getParameter("pColor"));
		r.setProductOptionSize(mr.getParameter("pSize"));
		r.setUserId(mr.getParameter("userId"));
		
		// 16개 중 5개 : 관리자가 설정하거나 자동으로 반영되는 값 
//		r.setReviewCount();
//		r.setReviewDate();
//		r.setReviewDelete();
//		r.setReviewLike();
//		r.setReviewNo();
		
		
		
		int result = service.postReview(r);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}