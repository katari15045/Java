<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="DatabaseServlet" method="post">
		Query : <input type="text" name="query" > <br>
		<input type="radio" name="chris" value="radioQuery" > Query
		<input type="radio" name="chris" value="radioUpdate" > Update <br>	
		<input type="submit" value="Send" >
	</form>
</body>
</html>