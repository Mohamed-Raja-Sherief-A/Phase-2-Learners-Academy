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
 * Servlet Filter implementation class ClassFilter
 */
public class ClassFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClassFilter() {
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
	//Filter in class servlet
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("class");
		try
		{
		if(name.trim().isEmpty())//Checks for empty elements
		{
			RequestDispatcher rd=request.getRequestDispatcher("classForm.jsp");//Error message to display in class form itself
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.write("Enter non empty values");
		}
	
		else
		{
			chain.doFilter(request, response); //Passes to class servlet
		}
		}
		catch(NullPointerException e)//Catches null pointers
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
