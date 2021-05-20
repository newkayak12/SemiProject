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
		
		// 리뷰 작성폼에서 입력한 값을 가져와서 db에 저장 
		
//		String reviewTitle = request.getParameter("reviewTitle");
//		String userId = request.getParameter("userId");
//		String up_file = request.getParameter("up_file");
//		String reviewContent = request.getParameter("reviewContent");
//		
//		Review r = new Review();
		
		
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
		
		// insert into review values('r-'||review_seq.nextval, 'testusers','001','XL','red','제목','내용입니다',sysdate,default,0,'파일입니다','1','001','c01');
		
		r.setReviewContents(mr.getParameter("reviewContent"));
		r.setReviewFile(mr.getParameter("up_file"));
		r.setReviewTitle(mr.getParameter("reviewTitle"));
		
		
		
		ReviewService service = new ReviewService();
		
		int result = service.postReview(r);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}