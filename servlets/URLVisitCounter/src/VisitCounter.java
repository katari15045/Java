

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounter")
public class VisitCounter extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int visitCounter;
	
	//If this Servlet is called 10 times service() is called 10 times and init() is called once.
	
	public void init()
	{
		visitCounter = 0;
	}
       
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			visitCounter = visitCounter + 1;
			PrintWriter printWriter = response.getWriter();
			printWriter.println("<html><body><h1>" + visitCounter + "</h1></body></html>");
		}
		
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
}
