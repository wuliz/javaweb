package com.wlz.mvc_jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn=null;
		//加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db","root","123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	//关闭数据库连接
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
