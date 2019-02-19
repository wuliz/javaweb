package com.wlz.javaweb.chapterThree_Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public final class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得用户信息
		//访问用户信息合理后，存入cookie，并返回给当前访问的页面
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String auto=request.getParameter("auto");
		String name=request.getParameter("name");
		String psw = request.getParameter("psw");
		if(auto!=null&&auto.equals("yes")){
			Cookie c1 = new Cookie("name",name);
			Cookie c2 = new Cookie("psw",psw);
			//cookie存活时间，一星期
			c1.setMaxAge(60*60*24*7);
			c2.setMaxAge(60*60*24*7);
			response.addCookie(c1);
			response.addCookie(c2);
		
		}
		out.println("welcome"+name);;
	}


}
