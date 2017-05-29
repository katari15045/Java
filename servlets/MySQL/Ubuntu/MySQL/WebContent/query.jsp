<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query</title>
</head>
<body>
	<form action="DatabaseServlet" method="post">
		Query : <input type="text" name="query" > <br> <br>
		<input type="radio" name="query_type" value="query" > Query
		<input type="radio" name="query_type" value="update"> Update <br> <br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>