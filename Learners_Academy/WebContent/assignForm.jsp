<%@page import="com.learners.service.SubjectFunctions"%>
<%@page import="com.learners.service.ClassFunctions"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.learners.service.TeacherFunctions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Form</title>
<style type="text/css">
<%@ include file="css/assign.css"%>
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
<header><h1>Assign Class-Subject-Teacher Form</h1></header>
<div class="container">
 <form action="AssignServlet" method="post">
  
   Select Teacher:<select name="teacher">
   <option value="current">Select</option>
			<%
			  ResultSet rs=TeacherFunctions.getTeachers();
			  while(rs.next())
			  {
				  	out.print("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
			  }
			%>
   </select><br/>
   Select Class:<select name="class">
   <option value="current">Select</option>
			<%
			  ResultSet rs1=ClassFunctions.getClasses();
			  while(rs1.next())
			  {
				  	out.print("<option value="+rs1.getString(1)+">"+rs1.getString(2)+"</option>");
			  }
			%>
   </select><br/>
   Select subject:<select name="subject">
   <option value="current">Select</option>
			<%
			  ResultSet rs2=SubjectFunctions.getSubjects();
			  while(rs2.next())
			  {
				  	out.print("<option value="+rs2.getString(1)+">"+rs2.getString(2)+"</option>");
			  }
			%>
   </select><br/>
   <input type="submit" value="Add"/><br/>
 </form>
 <a href="mainmenu.jsp">Back</a><br/>
 <a class="delete" href="deleteAssign.jsp">Delete Assignments</a>
</div>
</body>
</html>