
<%@page import="java.sql.ResultSet"%>
<%@page import="com.learners.service.ClassFunctions"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Generator</title>
<style type="text/css">
<%@ include file="css/assign.css"%>
</style>
</head>
<body>
<%--session management --%>
<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>
<header><h1>Report Generator</h1></header>
	<div class="container">
	<form action="ReportServlet" method="post">
		Select Class:<select name="class">
		<option value="current">Select</option>
		<%--Display all classes --%>
		<%	
		ResultSet rs=ClassFunctions.getClasses();
		while(rs.next())
		{
			out.print("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
		}
		%>
		</select><br/>
		<input type="submit" value="Search"/><br/>
	</form>
	<a class="delete" href="mainmenu.jsp">Back</a><br/>
	</div>
</body>
</html>