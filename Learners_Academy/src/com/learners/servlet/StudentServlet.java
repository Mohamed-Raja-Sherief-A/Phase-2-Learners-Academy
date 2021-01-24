package com.learners.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learners.service.StudentFunctions;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	if(session.getAttribute("user")==null)//session management
    	{
    		response.sendRedirect("index.jsp");
    	}
    	else
    	{
		String name=request.getParameter("student");
		String batch=request.getParameter("class");
		String a=request.getParameter("age");
		int age=Integer.parseInt(a);
		int classid=Integer.parseInt(batch);
		RequestDispatcher rd=request.getRequestDispatcher("studentForm.jsp");
		PrintWriter out=response.getWriter();
		try {
			StudentFunctions.addStudent(name, age, classid);//funtion to add student details to db
			rd.include(request, response);
			out.write("Student Added Succesfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	}

}
