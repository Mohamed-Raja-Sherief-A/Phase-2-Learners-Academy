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
 * Servlet Filter implementation class RegistrationFilter
 */
public class RegistrationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegistrationFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	    try
	    {
		if((username.isBlank()||password.isBlank()))
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			request.setAttribute("message", "Enter all credentials");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.write("Enter all Credentials");
			
		}
	 
		else
		{
		// pass the request along the filter chain
		chain.doFilter(request, response);
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
