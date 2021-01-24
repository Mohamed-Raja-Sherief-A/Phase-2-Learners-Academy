<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
<%@ include file="css/registration.css"%>
</style>
</head>
<body>
<header>
Registration Page
</header>
    <div class="container">
		<form action="RegistrationServlet" method="post">
			Enter username:<input type="text" name="username"/><br/>
			Enter password:<input type="text" name="password"/><br/>
			<input type="submit" value="submit"/><br/>
		</form>
    <a href="index.jsp">back</a><br/>
    </div>
</body>
</html>