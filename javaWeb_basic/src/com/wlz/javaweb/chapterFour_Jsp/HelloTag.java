package com.wlz.javaweb.chapterFour_Jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{
	private PageContext con;
	private Tag tag;
	
	//当访问该标签时，主要是调用这个方法。
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		String str="hello jsp tag;";
		try {
			con.getOut().print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return tag;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		this.con=arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		this.tag=tag;
	}

}
