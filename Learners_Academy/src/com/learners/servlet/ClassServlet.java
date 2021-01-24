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

import com.learners.service.ClassFunctions;

/**
 * Servlet implementation class ClassServlet
 */
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name=req.getParameter("class");
      try {
    	HttpSession session=req.getSession();
    	if(session.getAttribute("user")==null)//checks if session exist
    	{
    		resp.sendRedirect("index.jsp");
    	}
    	else
    	{
    	RequestDispatcher rd=req.getRequestDispatcher("classForm.jsp");
		ClassFunctions.addClass(name);//function to add class to db
		PrintWriter out=resp.getWriter();
		rd.include(req, resp);
		out.write("Class Added Succesfully");
    	}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {//exception throws if class already exists
		RequestDispatcher rd=req.getRequestDispatcher("classForm.jsp");
		PrintWriter out=resp.getWriter();
		rd.include(req, resp);
		out.write("Class Already Exist");
	}
    }
}
