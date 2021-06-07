import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class valide extends HttpServlet {
@Override
public void doPost(HttpServletRequest request,HttpServletResponse response) 
			  throws ServletException,IOException
  {   
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	RequestDispatcher rd;
	String login=request.getParameter("login");
	String pwd=request.getParameter("pwd");
	String session=request.getParameter("session_id");

    if( login.equals("Owner") && pwd.equals("own") || login.equals("Renter") && pwd.equals("rent") || login.equals("Broker") && pwd.equals("broke") ){
        if(login.equals("Owner") && pwd.equals("own"))
        {
         rd=request.getRequestDispatcher("owner");
         rd.forward(request, response);
        }
        
        if(login.equals("Renter") && pwd.equals("rent"))
        {
	    rd=request.getRequestDispatcher("renter");
	    rd.forward(request, response);        
        }//if
        
        if(login.equals("Broker") && pwd.equals("broke"))
        {
	    rd=request.getRequestDispatcher("broker");
	    rd.forward(request, response);        
        }//if
    }

else
{
 	out.println("<center><p><h1>Incorrect LoginId/Password </h1></p></center>");
	rd=request.getRequestDispatcher("/index.html");
	rd.include(request, response);

}
  }}
