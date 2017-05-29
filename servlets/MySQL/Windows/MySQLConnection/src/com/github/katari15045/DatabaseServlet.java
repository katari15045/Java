package com.github.katari15045;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSetMetaData;

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
		PreparedStatement preparedStatement;
		
		try 
		{
			database.makeConnection();	
			preparedStatement = database.getConnection().prepareStatement(query); // Use '?' if possible to avoid SQL injections
			
			if( radioClicked.equals("radioQuery") )
			{
				ResultSet resultSet = database.executeQuery(preparedStatement);
				resultString = storeResultSet(resultSet);
				System.out.println(resultString);
			}
			
			else if( radioClicked.equals("radioUpdate") )
			{
				database.executeUpdate(preparedStatement);
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
		ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
		int totalCols = resultSetMetaData.getColumnCount();
		int currentColumn;
		
		while( resultSet.next() )
		{
			currentColumn = 1;
			
			while( currentColumn <= totalCols )
			{
				System.out.println( resultSet.getString(currentColumn) + " " );
				stringBuilder.append( resultSet.getString(currentColumn) ).append("|");
				currentColumn = currentColumn + 1;
			}
			
			stringBuilder.append("<br>");
		}
		
		return stringBuilder.toString();
	}

}
