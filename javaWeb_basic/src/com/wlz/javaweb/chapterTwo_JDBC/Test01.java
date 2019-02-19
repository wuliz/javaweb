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
		//加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","123456");
			//得到语句对象
			stat = conn.createStatement();
			//执行语句
			 res = stat.executeQuery("select *from money");
			//遍历Result结果集
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
			
			//关闭自动提交(转账业务)
			conn.setAutoCommit(false);
			 st = conn.createStatement();
			int b = st.executeUpdate(sql);
			//提交
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
	 * 开启事务
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
			
			//关闭自动提交(转账业务)
			conn.setAutoCommit(false);
			 st = conn.createStatement();
			int b = st.executeUpdate(sql);
			int b2 = st.executeUpdate(sql2);
			//提交
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
