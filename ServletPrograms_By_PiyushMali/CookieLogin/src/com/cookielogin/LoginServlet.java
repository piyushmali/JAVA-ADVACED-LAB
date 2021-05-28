package com.bridgelabz.cookielogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();  

		String username=request.getParameter("username");  
		String password=request.getParameter("password");  
		ServletConfig servletConfig=getServletConfig();
		if(password.equals(servletConfig.getInitParameter("password")) && 
				username.equals(servletConfig.getInitParameter("name"))){  
			printWriter.print("Welcome, "+username+" You are successfully logged in.");  
			request.getRequestDispatcher("profile.html").include(request, response); 
			Cookie ck=new Cookie("name",username);  
			response.addCookie(ck);  
		}else{  
			printWriter.print("Sorry, username and password missmatch, please login again.");  
			request.getRequestDispatcher("index.html").include(request, response);  
		}  
		printWriter.flush();
		printWriter.close();  
	}
}
