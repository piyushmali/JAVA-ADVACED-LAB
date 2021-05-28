package com.hcl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.EmployeeDAO;

@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int eno=Integer.parseInt(request.getParameter("eno"));
		String ename=request.getParameter("ename");
		int salary=Integer.parseInt(request.getParameter("salary"));
		String city=request.getParameter("city");
		
		EmployeeDAO dao=new EmployeeDAO();
		Employee e=new Employee(eno,ename,salary,city);
		
		out.println("<html><body><center>");
		if(dao.updateEmployee(e))
		{
			out.println("<font color='green' size='4'>Employee record has been updated successfully!</font>");
		}
		else
		{
			out.println("<font color='red' size='4'>Error in updating employee.Pls try later!</font>");
		}
		
		out.println("<a href='index.html'>Home</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href='SelectServ'>Display All Employees</a>");
		out.println("</center></body></html>");
		out.close();
	}

}
