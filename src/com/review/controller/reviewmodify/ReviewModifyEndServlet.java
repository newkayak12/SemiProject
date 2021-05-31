package com.review.controller.reviewmodify;

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

@WebServlet("/review/modify/end")
public class ReviewModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewModifyEndServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		
//		String reviewNo = request.getParameter("reviewNo");
//		String reviewTitle = request.getParameter("reviewTitle");
//		String up_file = request.getParameter("up_file");
//		String reviewContent = request.getParameter("reviewContent");
//		
//		Review r = new Review();
//		
//		r.setReviewNo(reviewNo);
//		r.setReviewTitle(reviewTitle);
//		r.setReviewFile(up_file);
//		r.setReviewContents(reviewContent);
//		
//				System.out.println("ReviewModifyEndServelt에서 테스트, r : " + r);
//		
		
		// 주의 !!! 
		// reviewFormModify.jsp에서 form의 enctype이 multipart/form-data라서 MultipartRequest 객체를 사용해야한다

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
		
		r.setReviewNo(mr.getParameter("reviewNo"));
		r.setReviewTitle(mr.getParameter("reviewTitle"));
		r.setReviewFile(mr.getFilesystemName("up_file"));
		r.setReviewContents(mr.getParameter("reviewContent"));
		
//				System.out.println("ReviewModifyEndServelt에서 테스트, r : " + r);
		
		ReviewService service = new ReviewService();
		
		int result = service.modifyReview(r);
		
		
		if(result > 0) {
			request.setAttribute("msg", "리뷰가 정상적으로 수정되었습니다.");
			
		} else {
			request.setAttribute("msg", "리뷰를 수정하지 못했습니다. 다시 실행하십시오.");
		}
		
		request.setAttribute("loc", "/review/list");
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

