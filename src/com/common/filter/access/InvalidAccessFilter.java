package com.common.filter.access;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.users.model.vo.Users;

@WebFilter(filterName = "/InvalidAccessFilter", urlPatterns = {"/*/modify/start","/review/modify/end","/*/delete","/*/post/start","/*/post/end"})
public class InvalidAccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public InvalidAccessFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpSession session = rq.getSession(false);
		
		Users user = (Users)session.getAttribute("user");
		if(user != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("loc", "/sign/signin/start");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
