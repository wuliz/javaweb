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
		 * ���ݿ�Ԫ�ؾ�  �����Ԫ�ؾ�
		 */
		getDBMetaData();
		getResultsetData();
	}
	//�õ����ݿ�Ԫ�ؾ�
	static void getDBMetaData() {
		Connection conn = JDBCUtil.getConnection();

		try {
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("���ݿ�汾" + meta.getDatabaseMajorVersion());
			System.out.println("���ݿ�����" + meta.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�õ������Ԫ�ؾ�
	static void getResultsetData(){
		Connection conn = JDBCUtil.getConnection();
		//�õ����������
		try {
			Statement stat = conn.createStatement();
			String sql="select * from money";
			ResultSet res = stat.executeQuery(sql);
			//�õ������Ԫ�ؾ�
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
