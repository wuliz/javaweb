package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrepareLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ȷ��ʸ�servlet���ж��Ƿ���cookie����cookie�Ļ�����ת������¼ҳ�棬��cookie��ֵ�����ڸ������У�����¼ҳ����ȡ�á�
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("name")){
					String value=cookies[i].getValue();
					request.setAttribute("name",value);
				}
				if(cookies[i].getName().equals("psw")){
					String value=cookies[i].getValue();
					request.setAttribute("psw", value);
				}
			}
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


}
