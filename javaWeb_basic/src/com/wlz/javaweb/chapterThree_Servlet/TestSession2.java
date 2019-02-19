package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class TestSession2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获得session，该接口的实现由特定的容器提供（tomcat）
		HttpSession session = request.getSession();
		// 获得数据
		String a = (String) session.getAttribute("name");
		// 在当前servlet中测试
		out.println(a);

		// 测试。同一个浏览器访问这两个servlet
		// 不同浏览器访问这个Servlet
		out.close();
	}

}
