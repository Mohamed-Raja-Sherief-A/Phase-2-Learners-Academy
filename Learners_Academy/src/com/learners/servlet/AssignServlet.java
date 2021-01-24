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

import com.learners.service.AssignFunctions;

/**
 * Servlet implementation class AssignServlet
 */
public class AssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();//session management
    	if(session.getAttribute("user")==null)
    	{
    		response.sendRedirect("index.jsp");
    	}
    	else
    	{
			String classid=request.getParameter("class");
			String teacher=request.getParameter("teacher");
			String subject=request.getParameter("subject");
			RequestDispatcher rd=request.getRequestDispatcher("assignForm.jsp");
			PrintWriter out=response.getWriter();
			try {
				AssignFunctions.addAssign(Integer.parseInt(classid),Integer.parseInt(teacher),Integer.parseInt(subject));//add assign values to db
				rd.include(request, response);
				out.print("Assignment Added Succesfully");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				rd.include(request, response);
				out.print("Assignment Already Exist");
			}
    	}
	}

}
