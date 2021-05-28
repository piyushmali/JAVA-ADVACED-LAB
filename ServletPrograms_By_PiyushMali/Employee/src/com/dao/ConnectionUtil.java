package com.dao;
import java.sql.*;
public class ConnectionUtil {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","121555");
		}
		catch(ClassNotFoundException ce) {ce.printStackTrace();}
		catch(SQLException se) {se.printStackTrace();}
		return con;
	}

}
