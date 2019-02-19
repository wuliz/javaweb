package com.wlz.javaweb.chapterTwo_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert();

	}
	static void insert(){
		Connection conn = JDBCUtil.getConnection();
		String sql="insert into money(name,money) values(?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,"wlz");
			pst.setDouble(2, 3322);
			int b = pst.executeUpdate();
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
