<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.github.katari15045.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user" scope="request" class="com.github.katari15045.User"></jsp:useBean>
	
	Hi, <jsp:getProperty property="userName" name="user"/>!!! <br>
	How is <jsp:getProperty property="country" name="user"/>???
	
</body>
</html>

<%--

1.In jsp:useBean, "user" is an argument, "request" is scope and return type is of user(in class) i.e (User) request.getAttribute("user");
  By default it stores in user i.e same as id
2.In jsp:getProperty, you are doing user.getCountry()

 --%>