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
 * Servlet Filter implementation class SubjectFilter
 */
public class SubjectFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SubjectFilter() {
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
		String subject=request.getParameter("subject");
		try
		{
		if(subject.isBlank())
		{
			 RequestDispatcher rd=request.getRequestDispatcher("subjectForm.jsp");
			 PrintWriter out=response.getWriter();
			 rd.include(request, response);
			 out.write("Enter non empty values");
		}
		
		else
		{
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