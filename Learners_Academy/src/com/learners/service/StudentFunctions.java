package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learners.jdbc.MyConnection;

public class StudentFunctions {
	//add student value to db
	public static void addStudent(String name,int age,int classid) throws ClassNotFoundException, SQLException, IOException
	{
		 Connection con=MyConnection.getConnection();
		 String sql="insert into students(student,age,cid) values(?,?,?)";
		 PreparedStatement st=con.prepareStatement(sql);
		 st.setString(1,name);
		 st.setInt(2, age);
		 st.setInt(3, classid);
		 st.execute();
	}
    
	
}
