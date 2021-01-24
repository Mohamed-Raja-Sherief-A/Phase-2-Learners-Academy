package com.learners.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.service.UserFunctions;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username!=null && password!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			PrintWriter out=response.getWriter();
			try {
				UserFunctions.registration(username, password);
				rd.include(request, response);
				out.write("User Added Succesfully");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				
				rd.include(request, response);
				out.write("User Already Exists");
			}
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

}
