package com.connectionPool;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class connectionpool {
	private static List<Connection> list=new ArrayList<Connection>();
	private static int size=10;
	private static String url="jdbc:postgresql://localhost:5432/studentdb?user=postgres&password=root";
	
	public static Connection createConnection() {
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(url);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
				
			for(int i=1;i<=size;i++) {
				Connection c=createConnection();
				list.add(c);
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection fetchConnection() {
		Connection c=null;
		if(!list.isEmpty()) {
			c=list.remove(0);
		}
		else {
			c=createConnection();
		}
		return c;
	}
	
	public static void receiveConnection(Connection cn) {
		if(list.size()<size) {
			list.add(cn);
		}
		else {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}