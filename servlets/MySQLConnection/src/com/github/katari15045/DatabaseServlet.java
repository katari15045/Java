package com.github.katari15045;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Database database = new Database();
		String query = request.getParameter("query");
		String radioClicked = request.getParameter("chris");
		String resultString = null;
		
		try 
		{
			database.makeConnection();			
			
			if( radioClicked.equals("radioQuery") )
			{
				ResultSet resultSet = database.executeQuery(query);
				resultString = storeResultSet(resultSet);
				System.out.println(resultString);
			}
			
			else if( radioClicked.equals("radioUpdate") )
			{
				database.executeUpdate(query);
				resultString = "Updated!!!";
			}
			
			database.closeConnection();
			request.setAttribute("output", resultString);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
			requestDispatcher.forward(request, response);
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private String storeResultSet(ResultSet resultSet) throws SQLException
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		while( resultSet.next() )
		{
			stringBuilder.append( resultSet.getString(1) ).append(" ");
			stringBuilder.append( Integer.toString( resultSet.getInt(2) ) ).append("<br>");
		}
		
		return stringBuilder.toString();
	}

}
