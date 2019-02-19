package com.wlz.javaweb.chapterTwo_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 数据库元素据  结果集元素据
		 */
		getDBMetaData();
		getResultsetData();
	}
	//得到数据库元素据
	static void getDBMetaData() {
		Connection conn = JDBCUtil.getConnection();

		try {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("数据库版本" + meta.getDatabaseMajorVersion());
			System.out.println("数据库名称" + meta.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//得到结果集元素据
	static void getResultsetData(){
		Connection conn = JDBCUtil.getConnection();
		//得到结果集对象
		try {
			Statement stat = conn.createStatement();
			String sql="select * from money";
			ResultSet res = stat.executeQuery(sql);
			//得到结果集元素据
			ResultSetMetaData meta = res.getMetaData();
			System.out.println("col:"+meta.getColumnCount());
			int count=meta.getColumnCount();
			while(count>0){
				String name = meta.getColumnLabel(count);
				System.out.println(name);
				count--;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
