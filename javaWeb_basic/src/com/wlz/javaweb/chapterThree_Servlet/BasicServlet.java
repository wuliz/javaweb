package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	public BasicServlet(){
		System.out.println("basicServlet");
	
	}
	public void init(){
	
		System.out.println("init");
		String name = this.getInitParameter("name");
		System.out.println(name);
		String conName = this.getServletContext().getInitParameter("name");
		System.out.println(conName);
	}
	public void destory(){
		System.out.println("destory");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Get");
		
		String name = req.getParameter("name");
		if(name.equals("zs")){
			//请求转发是req处理的
			try {
				req.getRequestDispatcher("/index.jsp").forward(req, res);
				//请求重定向是res处理的。
				//res.sendRedirect("http://baidu.com");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				req.getRequestDispatcher("/hello.html").forward(req, res);
				//res.sendRedirect("http://www.yahoo.com");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		doGet(req,res);
		System.out.println("Post");
	}
	/*public void service(HttpServletRequest req, HttpServletResponse res){
	
		System.out.println("service");
	}*/
}
