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

import com.learners.service.SubjectFunctions;
import com.learners.service.TeacherFunctions;

/**
 * Servlet implementation class TeacherServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
    	if(session.getAttribute("user")==null)//session tracking
    	{
    		resp.sendRedirect("index.jsp");
    	}
    	else
    	{
		String name=req.getParameter("teacher");
    	RequestDispatcher rd=req.getRequestDispatcher("teacherForm.jsp");
    	PrintWriter out=resp.getWriter();
    	try {
			TeacherFunctions.addTeacher(name);//adds teacher to db
			rd.include(req, resp);
			out.write("Teacher Added Succesfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {//if error occurs while adding
			rd.include(req, resp);
			out.write("Record not added");
		}
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
