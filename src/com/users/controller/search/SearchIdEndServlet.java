package com.users.controller.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.users.model.service.UsersService;
import com.users.model.vo.Users;

@WebServlet("/search/searchid/end")
public class SearchIdEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿확인용");
		String username=request.getParameter("username");
		String userPhone=request.getParameter("userPhone");
		
		Users u = new Users();
		u.setUserName(username);
		u.setUserPhone(userPhone);
		
		
		Users useridtemp = new UsersService().searchid(u);
		
		
		request.setAttribute("useridtemp", useridtemp);
		System.out.println(useridtemp);
		request.getRequestDispatcher("/views/member/searchid.jsp").forward(request, response);
		
	
		/*
		input tag에 입력안하면 안넘어가게하는거
		required > 속성 input 


		아이디 중복은 servlet
		>> 새 창을 띄우고 입력을 받고 
		1. 있는 아이디면 중복검사 입력 받는 창을 다시 띄운다.
		2. 없는 아이디면 사용해도 좋다는 또 다른 새창을 띄우고 닫기 버튼을 누르면 
			원래 회원 가입 id 의 input  태그에 javascript로 값을 넣는다. \
	
		>>> javascript로 아이디의 길이가 8글자보다 적으면 alert()


		비밀번호1 
		비밀번호2 

		두 개 일치하는지 javascript

		>>> 비밀번호의 길이가 8글자 보다 적으면 alert

		*/

		//String userid = useridtemp.getUserId().substring(0,4)+"*******";
		//어디에?/ 1. 새 창에 뿌려준다. 

		

		// 헤더 내용  { 찾으신 아이디는 ~~입니다. } a(로그인화면으로 돌아가기) 푸터 

		/*

		헤더
			<div>
				<p> 찾으신 아이디는 ~~~입니다. </p>
			</div>
			<a href="<%%>" 돌아가기 </a>

		푸터 
		*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
