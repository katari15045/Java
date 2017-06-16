<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
	
	<%
	
		int totalItems = Integer.valueOf( request.getParameter("totalItems") ); 
		int totalItemsPerPage = Integer.valueOf( (String) request.getParameter("totalItemsPerPage" ) ); 
		int targetPage;
				
		if( request.getAttribute("targetPage") == null )
		{
			targetPage = 1;
		}
		
		else
		{
			targetPage = (Integer) request.getAttribute("targetPage");
		}
				
		int totalPages = totalItems/totalItemsPerPage;
		int currentItem = ( totalItemsPerPage*(targetPage-1) ) + 1;
		
		while( currentItem <= totalItemsPerPage )
		{
			
	%>
	
			<%=currentItem%> <br>
	
	<%
			
			currentItem = currentItem + 1;
		}
	%>
	
</body>
</html>