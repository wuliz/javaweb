package com.wlz.mvc_collect.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wlz.mvc_collect.bean.Collect;
import com.wlz.mvc_collect.dao.CollectDao;
import com.wlz.mvc_collect.util.DBUtil;

public class CollectDaoImpl implements CollectDao {

	@Override
	public void save(Collect c) {
		// TODO Auto-generated method stub
		String sql = "insert into collect(name,url) values(?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getName());
			stat.setString(2, c.getUrl());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.close(conn);
		}

	}

	@Override
	public void update(Collect c) {
		// TODO Auto-generated method stub
		String sql = "update collect set name=?,url=? where id=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getName());
			stat.setString(2, c.getUrl());
			stat.setInt(3, c.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.close(conn);
		}

	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		String sql = "select *from collect";
		Connection conn = DBUtil.getConnection();
		Statement stat = null;
		ResultSet res = null;
		List<Collect> list = new ArrayList<Collect>();
		try {
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while (res.next()) {
				Collect c = new Collect();
				c.setId(res.getInt("id"));
				c.setName(res.getString("name"));
				c.setUri(res.getString("url"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.close(conn);
		}
		return null;

	}

	@Override
	public void delete(String[] str) {
		// TODO Auto-generated method stub
		String sql = "delete from collect where id=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = null;
		System.out.println(str);
		if (str != null && str.length != 0) {
			try {
				stat=conn.prepareStatement(sql);
				for (int i = 0; i < str.length; i++) {
					int id = Integer.parseInt(str[i]);
					System.out.println(id);
					stat.setInt(1,id);
					stat.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DBUtil.close(conn);
			}

		}
	}

	@Override
	public Collect get(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "select *from collect where id=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement stat = null;
		ResultSet res = null;

		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			res = stat.executeQuery();
			while (res.next()) {
				Collect c = new Collect();
				c.setId(res.getInt("id"));
				c.setName(res.getString("name"));
				c.setUri(res.getString("url"));
				return c;
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.close(conn);
		}
		return null;

	}
}
