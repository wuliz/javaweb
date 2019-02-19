package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		StringBuffer url = req.getRequestURL();
		System.out.println(url);
		//产生一个响应
		//得到输出流对象
		PrintWriter out = res.getWriter();
		out.println(url);
	}
}
