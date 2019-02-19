package com.wlz.javaweb.chapterThree_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintExcel extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		//设置响应的类型
		res.setContentType("application/vnd.ms-excel");
		try {
			PrintWriter out = res.getWriter();
			out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
			//out.println("Apples\t78\87\92\t29\t=SUM(B2:E2)");
			//out.println("Oranges\t77\t86\")
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
