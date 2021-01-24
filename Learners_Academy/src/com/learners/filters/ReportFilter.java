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
 * Servlet Filter implementation class ReportFilter
 */
public class ReportFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ReportFilter() {
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
	    String id=request.getParameter("class");
	   try
	   {
	    if(id.equals("current"))//checks if blank or empty
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("report.jsp");
	    	PrintWriter out=response.getWriter();
	    	rd.include(request, response);
	    	out.write("Please select a valid Batch");
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
