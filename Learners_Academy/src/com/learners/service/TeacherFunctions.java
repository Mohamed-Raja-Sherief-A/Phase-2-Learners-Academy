package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learners.jdbc.MyConnection;

public class TeacherFunctions {
	//add teacher to db
 public static void addTeacher(String name) throws ClassNotFoundException, SQLException, IOException
 {
	 Connection con=MyConnection.getConnection();
		String sql="insert into teachers(teacher) values(?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, name);
		st.execute();
 }
 //gets all teacher details from db
 public static ResultSet getTeachers() throws ClassNotFoundException, SQLException, IOException
	{
		 Connection con=MyConnection.getConnection();
		 String sql="select * from teachers";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 return rs;
	}
}
