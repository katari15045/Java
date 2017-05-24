<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	
	<jsp:useBean id="user" scope="request" class="com.github.katari15045.User"/>
	
	Hi, <jsp:getProperty property="userName" name="user"/>, Son of <jsp:getProperty property="userFather" name="user"/> <br>
	How is <jsp:getProperty property="userCountry" name="user"/>??? <br>
	
	<jsp:setProperty property="userCountry" name="user" value="Pakistan" />
	Welcome to <jsp:getProperty property="userCountry" name="user"/>!!!
	
</body>
</html>