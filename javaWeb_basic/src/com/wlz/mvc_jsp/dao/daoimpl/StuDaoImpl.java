package com.wlz.mvc_jsp.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wlz.mvc_jsp.bean.Stu;
import com.wlz.mvc_jsp.dao.StuDao;
import com.wlz.mvc_jsp.util.DBUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public void save(Stu s) {
		// TODO Auto-generated method stub
		// 获取数据库连接
		PreparedStatement stat = null;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into stu_db1(name,age) values(?,?)";
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, s.getName());
			stat.setInt(2, s.getAge());
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
	public List<Stu> list() {
		// TODO Auto-generated method stub
		List<Stu> list = new ArrayList<Stu>();
		String sql = "select * from stu_db1";
		ResultSet res = null;
		Statement stat = null;
		Connection conn = DBUtil.getConnection();
		try {
			stat = conn.createStatement();
			res = stat.executeQuery(sql);
			while (res.next()) {
				Stu s = new Stu();
				s.setId(res.getInt("id"));
				s.setName(res.getString("name"));
				s.setAge(res.getInt("age"));
				list.add(s);
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

		return list;
	}

}
