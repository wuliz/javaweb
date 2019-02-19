package com.wlz.javaweb.chapterTwo_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StatementTest {

	public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
    int n=s.nextInt();
     Integer[] A=new Integer[n];
    
        for(int i=0;i<A.length;i++){
            A[i]=s.nextInt();
        }
      ArrayList<Integer> a=new ArrayList<Integer>(Arrays.asList(A));
         Collections.sort(a,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
        	 
         });
     if(a.get(1)*a.get(2)<a.get(a.size()-1)*a.get(a.size()-2)){
    	 System.out.println();
     }
    System.out.println(a);
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.get(a.size()-1));
        System.out.println(a.get(a.size()-2));
        System.out.println(a.get(a.size()-1)*a.get(a.size()-2)*a.get(0));
	}
	//得到语句对象
	/**
	 * statement对象：对数据库进行操作，DDL,DML，DQL,DCL等操作
	 * statement对象可以把sql语句发送到数据库
	 */
	//执行DDL操作
	static void getStatement(){
		Connection conn = JDBCUtil.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
			String sql="create table test(id int,name varchar(10),age int)";
			stat.execute(sql);
			System.out.println(stat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				stat.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
