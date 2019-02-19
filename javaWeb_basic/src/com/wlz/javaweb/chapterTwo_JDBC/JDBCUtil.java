package com.wlz.javaweb.chapterTwo_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
//�õ����ݿ�����
	public static Connection getConnection(){
		Connection conn=null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	public static Connection getConnection(String driver,String username,String password,String url){
		Connection conn=null;
		//��������
		try {
			Class.forName(driver);
			 conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
