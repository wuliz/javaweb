package com.wlz.mvc_collect.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wlz.mvc_collect.bean.Collect;
import com.wlz.mvc_collect.dao.CollectDao;
import com.wlz.mvc_collect.dao.impl.CollectDaoImpl;


public class CollectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action!=null&&action.equals("save")){
			save(request,response);
		}else if(action!=null&&action.equals("list")){
			list(request,response);
		}else if(action!=null&&action.equals("get")){
			get(request,response);
		}else if(action!=null&&action.equals("update")){
			update(request,response);
		}
		else if(action!=null&&action.equals("delete")){
			delete(request,response);
		}
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] ids=request.getParameterValues("ids");
		CollectDao dao=new CollectDaoImpl();
		
		System.out.println(ids.toString()+" "+ids.length);
		dao.delete(ids);
		list(request,response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String url = (request.getParameter("url"));
		int id = Integer.parseInt(request.getParameter("id"));
		CollectDao dao=new CollectDaoImpl();
		Collect c=new Collect();
		c.setName(name);
		c.setUri(url);
		c.setId(id);
		dao.update(c);
		list(request,response);
	}


	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String url = (request.getParameter("url"));
		CollectDao dao=new CollectDaoImpl();
		Collect c=new Collect();
		c.setName(name);
		c.setUri(url);
		dao.save(c);
		list(request,response);
	
		
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CollectDao dao=new CollectDaoImpl();
		List<Collect> list = dao.list();
		request.setAttribute("list", list);
		System.out.println(list.get(0));
		request.getRequestDispatcher("/mvc_collect/collect.jsp").forward(request, response);
		
	}
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CollectDao dao=new CollectDaoImpl();
		Collect c = dao.get(id);
		System.out.println(c);
		request.setAttribute("collect", c);
		
		request.getRequestDispatcher("/mvc_collect/edit.jsp").forward(request, response);
		
	}


}
