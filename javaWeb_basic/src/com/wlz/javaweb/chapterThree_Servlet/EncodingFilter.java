package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//控制编码问题
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//权限访问
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession sess = req.getSession();
		String u =(String) sess.getAttribute("user");
		if(u!=null&&!u.equals("")){
			chain.doFilter(request, response);
		}else{
			req.setAttribute("error", "你还没有登录");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		chain.doFilter(request, response);
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
