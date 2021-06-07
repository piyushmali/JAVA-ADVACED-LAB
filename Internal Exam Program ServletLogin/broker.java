import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class broker extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
{   response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session_id");
        String username=request.getParameter("login");
        out.println("<h1>Hello Broker  </h1>");     
    }
}
