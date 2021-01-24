<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
<style type="text/css">
<%@ include file="css/mainmenu.css"%>
</style>
</head>
<body>
	<%--Validates session --%>
	<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>
	<header>Main Menu</header>
	<div class="container">
	<a href="classForm.jsp">Class Manager</a><br/>
	<a href="subjectForm.jsp">Subject Manager</a><br/>
	<a href="teacherForm.jsp">Teacher Manager</a><br/>
	<a href="studentForm.jsp">Student Manager</a><br/>
	<a href="assignForm.jsp">Class Assignment Manager</a><br/>
	<a href="report.jsp">Report Card</a><br/>
	<a href="LogOutServlet">Log Out</a><br/>
	</div>
</body>
</html>