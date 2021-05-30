package com.review.controller.reviewpost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.renamepolicy.ReviewRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
		
		
		// insert into review values(review_seq.nextval, 'testusers','001','XL','red','제목','내용입니다',sysdate, default, 0, '파일입니다', '1', '001', 'c01');
		
		// 19개 중 3개 : 사용자가 입력한 값 : 제목, 파일, 내용
		r.setReviewContents(mr.getParameter("reviewContent"));
		r.setReviewFile(mr.getFilesystemName("up_file"));
		r.setReviewTitle(mr.getParameter("reviewTitle"));
		
		// 19개 중 8개 : orderlist에서 가져온 상품을 hidden으로 가져온 값 
		r.setCategoryId(mr.getParameter("cId"));
		r.setOrderNumber(mr.getParameter("orderNo"));
		r.setProductFile(mr.getParameter("pFile"));
		r.setProductId(mr.getParameter("pId"));
		r.setProductName(mr.getParameter("pName"));
		r.setProductOptionColor(mr.getParameter("pColor"));
		r.setProductOptionSize(mr.getParameter("pSize"));
		r.setUserId(mr.getParameter("userId"));
		
		// 19개 중 5개 : 관리자가 설정하거나 자동으로 반영되는 값 
//		r.setReviewCount();
//		r.setReviewDate();
//		r.setReviewDelete();
//		r.setReviewLike();
//		r.setReviewNo();
		
		// 19개 중 3개 : 리뷰에 딸린 댓글
//		r.setReviewComment();
//		r.setCommentUserId();
//		r.setReviewCommentDate();
		
				System.out.println("ReviewPostEndServlet에서 테스트, r : " + r);
		
		int result = service.postReview(r);
		
		if(result > 0) {
			// 리뷰 등록 성공
			request.setAttribute("msg", "리뷰를 성공적으로 등록했습니다");
			request.setAttribute("loc", "/review/list");
		} else {
			request.setAttribute("msg", "리뷰등록을 실패했습니다");
			request.setAttribute("loc", "/");
		}
		
		request.setAttribute("close", "window.close();");
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}