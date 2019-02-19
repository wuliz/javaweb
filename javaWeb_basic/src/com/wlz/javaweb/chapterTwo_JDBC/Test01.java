package com.wlz.javaweb.chapterTwo_JDBC;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet res=null;
		//�������ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//������ݿ����Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","123456");
			//�õ�������
			stat = conn.createStatement();
			//ִ�����
			 res = stat.executeQuery("select *from money");
			//����Result�����
			while(res.next()){
				int id = res.getInt("id");
				String name = res.getString("name");
				String money = res.getString("money");
				System.out.println(id+name+money);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				res.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Test
	public void test(){
		Properties p = new Properties();
		Connection conn =null;
		Statement st=null;
		try {
			//p.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
			p.load(new BufferedInputStream(
					new FileInputStream("D:\\myelipse workspace\\javaWeb_basic\\src\\com\\wlz\\javaweb\\chapterTwo_JDBC\\db.properties")));
			String username = p.getProperty("username");
			conn = JDBCUtil.getConnection(p.getProperty("driver"), username, p.getProperty("password"), p.getProperty("url"));
			System.out.println(conn);
			String sql="insert into money(name,money) values('zhansan',11)";
			
			//�ر��Զ��ύ(ת��ҵ��)
			conn.setAutoCommit(false);
			 st = conn.createStatement();
			int b = st.executeUpdate(sql);
			//�ύ
			conn.commit();
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * ��������
	 * conn.setAutoCommit(false)
	 * conn.commit()
	 * conn.rollback();
	 */
	@Test
	public void trans(){
		Properties p = new Properties();
		Connection conn =null;
		Statement st=null;
		try {
			//p.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
			p.load(new BufferedInputStream(
					new FileInputStream("D:\\myelipse workspace\\javaWeb_basic\\src\\com\\wlz\\javaweb\\chapterTwo_JDBC\\db.properties")));
			String username = p.getProperty("username");
			conn = JDBCUtil.getConnection(p.getProperty("driver"), username, p.getProperty("password"), p.getProperty("url"));
			System.out.println(conn);
			String sql="update money set money=money-1000 where name='zs'";
			String sql2="update money set money=money+1000 wher name='ls'";
			
			//�ر��Զ��ύ(ת��ҵ��)
			conn.setAutoCommit(false);
			 st = conn.createStatement();
			int b = st.executeUpdate(sql);
			int b2 = st.executeUpdate(sql2);
			//�ύ
			conn.commit();
			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
