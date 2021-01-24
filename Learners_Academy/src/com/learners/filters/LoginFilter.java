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
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	//Login Filter
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	System.out.println("in login filter");
		if(username.isBlank()||password.isBlank()) //checks for blank spaces and empty elements
    	{
    		 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
    		 PrintWriter out=response.getWriter();
    		 rd.include(request, response);//includes index.jsp and displays error
    		 out.write("<span style=color:red>Enter all credentials</span>");
    	}
		else {
		// pass the request along the filter chain Login Servlet
			System.out.println("passing to another servlet");
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
