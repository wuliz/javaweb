package com.wlz.javaweb.chapterThree_Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintJpeg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");
		//��÷��ı��ļ���������
		//InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.jpg");
		FileInputStream in = new FileInputStream("D:\\myelipse workspace\\javaWeb_basic\\src\\com\\wlz\\javaweb\\test.jpg");
		byte[] buff=new byte[in.available()];
		in.read(buff);
		//����ֽ������
		ServletOutputStream out = response.getOutputStream();
		out.write(buff);
	}

}
