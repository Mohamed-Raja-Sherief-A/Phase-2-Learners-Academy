<%@page import="java.sql.ResultSet"%>
<%@page import="com.learners.service.ClassFunctions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
<style type="text/css">
<%@ include file="css/registration.css"%>
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
<header><h1>Student Manager</h1></header>
    <div class="container">
	<form action="StudentServlet" method="post">
		Enter Student Name:<input type="text" name="student" placeholder="Enter here"/><br/>
		Enter Age:<input type="text" name="age" placeholder="Enter here"/><br/>
		Select Class:
		<select name="class">
		 <option value="current">Select</option>
		 <%--loops all the classes in select in option --%>
			<%
			  ResultSet rs=ClassFunctions.getClasses();
			  
			  while(rs.next())
			  {
				  	out.print("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
			  }
			%>
		</select>
		<input type="submit" value="Add"/><br/>
	</form>
	<a href="mainmenu.jsp">Back</a><br/>
	</div>
</body>
</body>
</html>