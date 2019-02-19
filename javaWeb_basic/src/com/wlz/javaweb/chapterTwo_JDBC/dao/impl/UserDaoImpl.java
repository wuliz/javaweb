package com.wlz.javaweb.chapterTwo_JDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wlz.javaweb.chapterTwo_JDBC.JDBCUtil;
import com.wlz.javaweb.chapterTwo_JDBC.bean.User;
import com.wlz.javaweb.chapterTwo_JDBC.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User Login(String name, String psw) {
		// TODO Auto-generated method stub
		User u=null;
		//��ѯ�Ĺ���
		String sql="select *from user where name=?,psw=?";
		//�õ����ݿ�����
				Connection conn = JDBCUtil.getConnection();
				//Ԥ�������
				PreparedStatement stat = null;
				try {
					stat = conn.prepareStatement(sql);
					stat.setString(1, name);
					stat.setString(2, psw);
					ResultSet res = stat.executeQuery();
					if(res.next()){
						int id=res.getInt("id");
						u.setId(id);
						u.setName(name);
						u.setPsw(psw);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					
					try {
						stat.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return u;
				
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		//��ӵĹ���
		String sql="insert into user(name,psw) values(?,?)";
		//�õ����ݿ�����
		Connection conn = JDBCUtil.getConnection();
		//Ԥ�������
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, u.getName());
			stat.setString(2, u.getPsw());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public boolean check(String name) {
		//��ѯ�Ĺ���
				String sql="select *from user where name=?";
				//�õ����ݿ�����
						Connection conn = JDBCUtil.getConnection();
						//Ԥ�������
						PreparedStatement stat = null;
						try {
							stat = conn.prepareStatement(sql);
							stat.setString(1, name);
							ResultSet res = stat.executeQuery();
							if(res.next()){
								return true;
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							
							try {
								stat.close();
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						return false;
	}

}
