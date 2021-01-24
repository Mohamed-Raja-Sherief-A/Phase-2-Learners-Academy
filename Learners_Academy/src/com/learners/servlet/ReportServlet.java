package com.learners.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learners.model.Subject;
import com.learners.service.ReportFunctions;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();//session tracking
    	if(session.getAttribute("user")==null)
    	{
    		response.sendRedirect("index.jsp");
    	}
    	else
    	{
			String classid=request.getParameter("class");
			RequestDispatcher rd=request.getRequestDispatcher("reportGenerator.jsp");
			  PrintWriter out=response.getWriter();
			  ArrayList<Subject>subjects=new ArrayList<>();//consist of subjects and teachers
			  ArrayList<String>students=new ArrayList<>();
			int id=Integer.parseInt(classid);
			try {
				ResultSet rs=ReportFunctions.getData1(id);//function to get subject,teacher details
				ResultSet rs1=ReportFunctions.getData2(id);//function to get student details
				ResultSet rs3=ReportFunctions.getData3(id);//function to get class name
				
				while(rs.next())
				{
					String s=rs.getString(1);
					String t=rs.getString(2);
					Subject subject=new Subject(s,t);
					subjects.add(subject);
				}
				System.out.println(subjects.size());
				while(rs1.next())
				{
					String name=rs1.getString(1);
					students.add(name);
				}
				rs3.next();
				//sets attributes
				request.setAttribute("classname", rs3.getString(1));
				request.setAttribute("subjects", subjects);
				request.setAttribute("students", students);
				rd.forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			  
			}
    	}
	}

}
