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
 * Servlet Filter implementation class StudentFilter
 */
public class StudentFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StudentFilter() {
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
		String name=request.getParameter("student");
		String age=request.getParameter("age");
		String cid=request.getParameter("class");
	    try
	    {
		if(name.trim().isEmpty()||age.trim().isEmpty()||cid.equals("current"))//checks for blank and empty inputs
		{
			 RequestDispatcher rd=request.getRequestDispatcher("studentForm.jsp");
			 PrintWriter out=response.getWriter();
			 rd.include(request, response);
			 out.write("Enter non empty values");
		}
	
		else
		{
		chain.doFilter(request, response);//forwards it to the servlet
		}
	    }
	    catch(NullPointerException e)//checks for null
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
