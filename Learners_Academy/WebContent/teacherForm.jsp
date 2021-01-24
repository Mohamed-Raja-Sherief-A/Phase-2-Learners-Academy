<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Form</title>
<style type="text/css">
<%@ include file="css/registration.css"%>
</style>
</head>
<body>
<%--Session tracking --%>
<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>
<header><h1>Teacher Manager</h1></header>
<div class="container">
	<form action="TeacherServlet" method="post">
		Enter Teacher Name:<input type="text" name="teacher" placeholder="Enter here"/><br/>
		<input type="submit" value="Add"/><br/>
	</form>
	<a href="mainmenu.jsp">Back</a><br/>
</div>
</body>
</html>