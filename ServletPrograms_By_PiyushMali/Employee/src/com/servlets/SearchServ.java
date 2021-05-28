package com.hcl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;


@WebServlet("/SearchServ")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		
		EmployeeDAO dao=new EmployeeDAO();
		
		out.println("<html><body><center>");
		
		Employee e=dao.findEmployee(name);
		
		if(e!=null) {
			
			out.println("<table border='1' cellpadding='5' cellspacing='5'><tr><th>Employee No</th><th>Name</th><th>Salary</th><th>City</th></tr>");
			out.println("<tr><td>"+e.getEno()+"</td><td>"+e.getEname()+"</td><td>"+e.getSalary()+"</td><td>"+e.getCity()+"</td></tr>");
			
		}else {
			
			out.println("<font color='red' size='4'>No Employee Find. Please Check Name!</font>");
		}
		
		out.println("<a href='index.html'>Home</a>");
		out.println("</center></body></html>");
		out.close();
	}


	}




