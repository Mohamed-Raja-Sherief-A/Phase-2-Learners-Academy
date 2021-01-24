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

import com.learners.service.UserFunctions;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	System.out.println("in login sevlet");
    	if(username!=null && password!=null)
    	{
	    	try {
				if(UserFunctions.login(username, password))//Function validates if credentials exist in the db
				{
					HttpSession session=request.getSession();//SessionManagement
			    	session.setAttribute("user", username);
					response.sendRedirect("mainmenu.jsp");//redirect to main
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					PrintWriter out=response.getWriter();
					rd.include(request, response);
					out.write("<span style=color:red>User credentials not found</span>");//User credentials not found
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
       }
    else
    {
    	response.sendRedirect("index.jsp");
    }
}
}
