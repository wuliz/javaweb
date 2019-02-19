package com.wlz.javaweb.chapterTwo_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javassist.bytecode.analysis.Type;

public class CallableStatementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callableState();
		callableInState();
		callableInOutState();
	}
	//���ü򵥴洢����
	static void callableState(){
		Connection conn = JDBCUtil.getConnection();
		String sql="{call all_money()}";
		CallableStatement state=null;
		ResultSet res = null;
		try {
			state = conn.prepareCall(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			res = state.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String name = res.getString("name");
				System.out.println(id+":"+name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				res.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
	}
	//�����вεĴ洢����
	static void callableInState(){
		Connection conn = JDBCUtil.getConnection();
		String sql="{call insert_money(?,?)}";
		CallableStatement state = null;
		try {
			state = conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			state.setString(1,"call");
			state.setDouble(2, 6650);
			state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//�����в��з���ֵ�Ĵ洢����
	static void callableInOutState(){
		Connection conn = JDBCUtil.getConnection();
		//ִ�д洢���̵�sql���
		String sql="{call getmoney(?,?)}";
		CallableStatement state = null;
		try {
			//�õ�����洢���̵�������
			state = conn.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//�����������
			state.setString(1, "zs");
			//ע���������
			state.registerOutParameter(2,Types.DOUBLE);
			//ִ�����
			state.executeQuery();
			//�õ�������
			double money = state.getDouble(2);
			System.out.println(money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}