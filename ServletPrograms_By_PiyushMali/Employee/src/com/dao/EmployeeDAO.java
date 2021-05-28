package com.dao;
import java.util.*;
import java.sql.*;
public class EmployeeDAO {
	
	public List<Employee> getAllEmployees()
	{
		Connection con=ConnectionUtil.getConnection();
		ResultSet rs=null;
		Statement stmt=null;
		String query=null;
		List<Employee> list=null;
		try {
			stmt=con.createStatement();
			query="select * from employee";
			rs=stmt.executeQuery(query);
			list=new ArrayList<>();
			while(rs.next()) {
				list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}//while
       	}//try
		catch(SQLException se) {se.printStackTrace();}
		return list;
	}//getALlEMployees
	

	public boolean addEmployee(Employee e)
	{
		Connection con=ConnectionUtil.getConnection();
		PreparedStatement pmt=null;
		String query=null;
		
		try {
			query="insert into employee values(?,?,?,?)";
			pmt=con.prepareStatement(query);
			pmt.setInt(1, e.getEno());
			pmt.setString(2, e.getEname());
			pmt.setInt(3, e.getSalary());
			pmt.setString(4, e.getCity());
			
			int n=pmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se) {se.printStackTrace();}
		
		return false;
	}//adEmployee
	
	public boolean updateEmployee(Employee e) {
		Connection con=ConnectionUtil.getConnection();
		PreparedStatement pmt=null;
		
		try {
			String query="update employee set ename=? salary=? city=? where eno=?";
			pmt = con.prepareStatement(query);
			pmt.setInt(1, e.getEno());
			pmt.setString(2, e.getEname());
			pmt.setInt(3, e.getSalary());
			pmt.setString(4, e.getCity());
			
			int n=pmt.executeUpdate();
			return n>0?true:false;
		}
		catch(SQLException se) {se.printStackTrace();}
		
		return false;
	}//updateEmployee

	public Employee findEmployee(String name){

		
	    Statement stmt=null;
		ResultSet rs=null;
		
		
		Employee e=new Employee();
		
		try {
			Connection con=ConnectionUtil.getConnection();
			stmt=con.createStatement();
			String query="select * from employee where ename='" + name + "'";
			rs=stmt.executeQuery(query);
		
			
		if ( rs.next() ) {
			
			 e=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		}
		}
		catch(SQLException s) {
			
			s.printStackTrace();
		}
		
		return e;
		
	}//findemp
	
}//class
















