package com.review.controller.reviewdetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.model.service.ReviewService;
import com.review.model.vo.Review;

@WebServlet("/review/detail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewDetailServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reviewNo = request.getParameter("no");
		
		ReviewService service = new ReviewService();
		
		
		// 리뷰번호로 db에 접근해서 해당하는 리뷰글과 댓글 조회 
//		List<Review> list = service.selectReview(reviewNo);
		
		
		// 모든 코맨트가 담긴 리스ㅡㅌ가 완성
		//중복되는 내용은 원래 글 
		// 이 안에 코맨트 내용은 다르다.
		// r.get(0) >> 원래 글은 이걸로 쓰면 되고
		// 나머지 코맨트는 list 안에서 for 
		
		
		// 조회수 기능
		
		// 게시글 상세페이지에서 새로고침하면 조회수가 계속 증가한다 
		// 해결방법 : 회원이 이 글을 읽었는지 아닌지 쿠키에 저장해서 분기처리 한다 
				
		// boardRead : 쿠키에 저장할 값
		// 읽은 게시글의 번호를 저장
		
		Cookie[] cookies = request.getCookies();
		
		String reviewRead = "";
		
		boolean readFlag = false; // 디폴트는 글을 읽지 않은 상태
		
		
		if( cookies != null ) {
			
			for( Cookie c : cookies ) {
				
				String name = c.getName(); // 쿠키의 key값
				String value = c.getValue(); // 쿠키의 value값
				
				if( name.equals( "reviewRead" ) ) {
					
					reviewRead = value;
					
					if( value.contains( "|" + reviewNo + "|" ) ) {
						
						readFlag = true;
						
						break;
					}
				}
			}
		}
		
		
		// 사용자가 게시글을 안읽었을 때 실행되는 로직
		// ( readFlag가 false인 상태니까 )
		// 그래서 조건을 !붙여서 true로 만들어준것 뿐 
		if( !readFlag ) {
			
			// 해당하는 리뷰를 읽지 않은상태면 
			// reviewRead에 이전에 읽은 |1| |2| 리뷰번호가 이런식으로 저장되어있음
			// 쿠키는 새로 덮어쓰기 때문에 이렇게 누적해줘야한다
			// ( 사용자가 이전에 다른 리뷰를 읽었으면 그 리뷰번호들은 쿠키에 계속 저장되어있어야 하니까. )
			Cookie c = new Cookie("reviewRead", reviewRead + "|" + reviewNo + "|");
			
			c.setMaxAge(60*60*24);
			
			response.addCookie(c);
		}
		
		
		List<Review> review = service.selectReview(reviewNo, readFlag);
				
		
		
		request.setAttribute("review", review);
		
		request.getRequestDispatcher("/views/review/reviewDetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
