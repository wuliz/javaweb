package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestScopeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setAttribute("req_name", "req_value");
		HttpSession session = request.getSession();
		session.setAttribute("session_name", "session_value");
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("context_name", "context_value");
		
		request.getRequestDispatcher("/ResultServlet").forward(request, response);
	}


}
