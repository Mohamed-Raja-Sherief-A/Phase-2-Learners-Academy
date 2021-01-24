<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@ include file="css/registration.css"%>
</style>
</head>
<body>
<%--validates session --%>
	<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>
	<header><h1>Class Manager</h1></header>
	<div class="container">
		<form action="ClassServlet" method="post">
			Enter Class Name:<input type="text" name="class" placeholder="Batch-n"/>
			<input type="submit" value="Add"/><br/>
		</form>
		<a href="mainmenu.jsp">Back</a><br/>
	</div>
</body>
</html>