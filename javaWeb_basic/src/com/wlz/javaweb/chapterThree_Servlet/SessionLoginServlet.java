package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wlz.javaweb.chapterTwo_JDBC.bean.User;
import com.wlz.javaweb.chapterTwo_JDBC.dao.UserDao;
import com.wlz.javaweb.chapterTwo_JDBC.dao.impl.UserDaoImpl;

public class SessionLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		System.out.println(name + psw);
		UserDao dao = new UserDaoImpl();
		User u = dao.Login(name, psw);
		System.out.println(u);
		if (u != null) {
			HttpSession s = request.getSession();
			s.setAttribute("user", u);
			request.getRequestDispatcher("/welcome.jsp").forward(request,
					response);

		} else {
			String msg = "username or password error,please relogin";
			request.setAttribute("error", msg);
			request.getRequestDispatcher("/sessionLogin.jsp").forward(request,
					response);
		}
	}

}
