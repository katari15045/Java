

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie cookies[] = request.getCookies();
		String name = null;
		
		for(Cookie c:cookies)
		{
			if(c.getName().equals("cookieName"))
			{
				name = c.getValue();
			}
		}
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><body><h1>Hi, " + name + "</h1></body></html>" );
	}

}
