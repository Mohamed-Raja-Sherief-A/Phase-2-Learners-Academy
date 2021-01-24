<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Control</title>
	<style type="text/css">
	<%@ include file="css/index.css" %>
	</style>
</head>
<body>
	 <header>
	  Learner Academy<br/>
	  Admin Control
	 </header>
	 <div class="container">
		 <form action="LoginServlet" method="post"><%--Login credential form --%>
			 <h3>Login Form</h3>
			 Enter username: <input type="text" name="username"/><br/>
			 Enter password: <input type="text" name="password"/><br/>
			  <input type="submit" value="submit"/><br/>
		 </form>
		  <a href="registration.jsp">New User Register here..</a><%--link for new registration --%>
	 </div>
</body>
</html>