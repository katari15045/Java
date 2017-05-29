package com.github.katari15045;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	private String query;
	private String queryType;
	
	private Database database;
	private  PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private int responseCode;
	private StringBuilder resultSetStringBuilder;
	
	private RequestDispatcher requestDispatcher;
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		getUserData(request);
		database = new Database();
		
		try
		{
			database.makeConnection();
			preparedStatement = database.getConnection().prepareStatement(query);
			
			if( queryType.equals("query") )
			{
				resultSet = database.executeQuery(preparedStatement);
				storeResultSet();
				request.setAttribute("results", resultSetStringBuilder.toString());
			}
			
			else if( queryType.equals("update") )
			{
				responseCode = database.executeUpdate(preparedStatement);
				request.setAttribute("results", String.valueOf(responseCode));
			}
			
			requestDispatcher = request.getRequestDispatcher("results.jsp");
			requestDispatcher.forward(request, response);
		}
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void getUserData(HttpServletRequest request)
	{
		query = request.getParameter("query");
		queryType = request.getParameter("query_type");
	}

	private void storeResultSet() throws SQLException
	{
		resultSetStringBuilder = new StringBuilder();
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int totalColumns = resultSetMetaData.getColumnCount();
		int currentColumn = 1;
		
		while( currentColumn <= totalColumns )
		{
			resultSetStringBuilder.append( resultSetMetaData.getColumnLabel(currentColumn) + "|" );
			currentColumn = currentColumn + 1;
		}
		
		resultSetStringBuilder.append("<br>---------------------<br>");
		
		while( resultSet.next() )
		{
			currentColumn = 1;
			
			while( currentColumn <= totalColumns )
			{
				resultSetStringBuilder.append( resultSet.getString(currentColumn) ).append("|");
				currentColumn = currentColumn + 1;
			}
			
			resultSetStringBuilder.append("<br>");
		}
	}
	
}
