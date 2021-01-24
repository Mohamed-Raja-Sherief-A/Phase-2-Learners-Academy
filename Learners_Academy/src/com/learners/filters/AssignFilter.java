package com.learners.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AssignFilter
 */
public class AssignFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AssignFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String classname=request.getParameter("class");
		String subject=request.getParameter("subject");
		String teacher=request.getParameter("teacher");
		try
		{
		if(classname.equals("current")||subject.equals("current")||teacher.equals("current"))//check empty inputs
		{
			RequestDispatcher rd=request.getRequestDispatcher("assignForm.jsp");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.print("Select All Values");
		}
		
		else
		{
			chain.doFilter(request, response);//forwards to servlet
		}
		}
		catch(NullPointerException e)
		{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
