package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String re_v = (String)request.getAttribute("req_name");
		HttpSession session = request.getSession();
		String se_v = (String)session.getAttribute("session_name");
		ServletContext servletContext = this.getServletContext();
		String context_v =(String) servletContext.getAttribute("context_name");
		
		System.out.println(re_v+" "+se_v+" "+context_v);
	}

}
