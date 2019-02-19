package com.wlz.javaweb.chapterTwo_JDBC.dao;

import com.wlz.javaweb.chapterTwo_JDBC.bean.User;

public interface UserDao {
public User Login(String name,String psw);
public void register(User u);
public boolean check(String name);
}
