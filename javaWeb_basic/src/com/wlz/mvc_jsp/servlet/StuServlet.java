package com.wlz.mvc_jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wlz.mvc_jsp.bean.Stu;
import com.wlz.mvc_jsp.dao.StuDao;
import com.wlz.mvc_jsp.dao.daoimpl.StuDaoImpl;

public class StuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		StuDao dao=new StuDaoImpl();
		Stu s=new Stu();
		s.setAge(age);
		s.setName(name);
		dao.save(s);
		List<Stu> list = dao.list();
		request.setAttribute("list", list);
		System.out.println(list.get(0));
		request.getRequestDispatcher("/mvc_jsp/stu.jsp").forward(request, response);
		
	}

}
