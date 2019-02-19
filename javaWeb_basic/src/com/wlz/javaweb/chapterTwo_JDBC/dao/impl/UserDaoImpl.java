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
		//查询的过程
		String sql="select *from user where name=?,psw=?";
		//拿到数据库连接
				Connection conn = JDBCUtil.getConnection();
				//预处理语句
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
		//添加的过程
		String sql="insert into user(name,psw) values(?,?)";
		//拿到数据库连接
		Connection conn = JDBCUtil.getConnection();
		//预处理语句
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
		//查询的过程
				String sql="select *from user where name=?";
				//拿到数据库连接
						Connection conn = JDBCUtil.getConnection();
						//预处理语句
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
