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

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//session tracking
    	HttpSession session=req.getSession();
    	if(session.getAttribute("user")==null)
    	{
    		resp.sendRedirect("index.jsp");
    	}
    	else
    	{
    	String name=req.getParameter("subject");
    	RequestDispatcher rd=req.getRequestDispatcher("subjectForm.jsp");
    	PrintWriter out=resp.getWriter();
    	try {
			SubjectFunctions.addSubject(name);//add subject data
			rd.include(req, resp);
			out.write("Subject Added Succesfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {//if subject already exisits
			rd.include(req, resp);
			out.write("Subject Already Exist");
		}
    	}
    }

}
