<%@page import="java.sql.ResultSet"%>
<%@ page import="com.learners.service.AssignFunctions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<style type="text/css">
<%@ include file="css/delete.css"%>
</style>
</head>
<body>
<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>
<header><h1>Delete Assignments</h1></header>
<form action="DeleteServlet" method="post">
	<div class="container">
	<%
	ResultSet rs=AssignFunctions.getAssign();
	
	while(rs.next())
	{
		out.print("<div class='sub'>");
		out.print("<input type='radio' name='delete' value='"+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+"'/><span class='a' style='text-align:left'>class:"+rs.getString(1)+"</span><span class='a' style='text-align:center'>teacher:"+rs.getString(2)+"</span><span class='a' style=text-align:right>subject:"+rs.getString(3)+"</span>");
		out.print("</div>");
	}
	%>
	</div>
	<input type="submit" value="Delete"/>
</form>
<a href="mainmenu.jsp">Back</a><br/>
</body>
</html>