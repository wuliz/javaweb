package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获得session，该接口的实现由特定的容器提供（tomcat）
		HttpSession session = request.getSession();
		//当前游览器和服务器得一一对应得关系
		//session的作用，在服务器端保存信息，且默认存活期为半小时。共享数据，该项目创建的session可在任意地方获得。而request得存活期是一次会话
		//存入信息到session中，可存放对象
		session.setAttribute("name", "wlz");
		//获得数据
		String a = (String)session.getAttribute("name");
		//在当前servlet中测试
		out.println(a);
		out.close();
	}

}
