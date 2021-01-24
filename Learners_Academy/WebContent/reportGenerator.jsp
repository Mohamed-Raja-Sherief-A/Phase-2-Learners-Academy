<%@page import="com.learners.model.Subject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@ include file="css/report.css"%>
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
<%String classname=(String)request.getAttribute("classname");
ArrayList<Subject> subjects=(ArrayList<Subject>) request.getAttribute("subjects");
ArrayList<String> students=(ArrayList<String>) request.getAttribute("students");
%>
<header><h1>Class:<%= classname %></h1></header>
<div class="maincontainer">
	<div class="container1" id="style-2">
		<h3>Student Name</h3>
		<ol type="1">
		<% 
		for(String student:students)
		{
			out.println("<li>"+student+"</li>");
		}
		%>
		</ol>
	</div>
	<div class="container2" id="style-2">
	<h3>Teacher-Subject</h3>
		<ol type="1">
		<%
		for(Subject subject:subjects)
		{
			out.print("<li>"+subject.getSubject()+" Hanedled by "+subject.getTeacher()+"</li>");
		}%>
		</ol>
	</div>
	<div class="fix"></div>
	<a href="mainmenu.jsp">back</a><br/>
</div>
</body>
</html>