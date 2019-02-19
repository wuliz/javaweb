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
		//���session���ýӿڵ�ʵ�����ض��������ṩ��tomcat��
		HttpSession session = request.getSession();
		// �������
		String a = (String) session.getAttribute("name");
		// �ڵ�ǰservlet�в���
		out.println(a);

		// ���ԡ�ͬһ�����������������servlet
		// ��ͬ������������Servlet
		out.close();
	}

}
