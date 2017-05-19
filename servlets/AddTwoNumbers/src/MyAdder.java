

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyAdder")
public class MyAdder extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int firstNumber;
	private int secondNumber;
	private int sum;
	private PrintWriter printWriter;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		firstNumber = Integer.parseInt( request.getParameter("firstNumber") );
		secondNumber = Integer.parseInt( request.getParameter("secondNumber") );
		sum = firstNumber + secondNumber;
		
		try 
		{
			printWriter = response.getWriter();
			printWriter.println("<html><body><h1>" + sum + "</h1></body></html>");
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doPost(request, response);
	}
}
