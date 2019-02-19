package com.wlz.mvc_jsp.dao;

import java.util.List;

import com.wlz.mvc_jsp.bean.Stu;

public interface StuDao {
	public void save(Stu s);
	public List<Stu> list();
}
