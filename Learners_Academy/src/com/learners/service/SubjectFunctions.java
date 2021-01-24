package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learners.jdbc.MyConnection;

public class SubjectFunctions {
	//add subject to db
	public static void addSubject(String name) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=MyConnection.getConnection();
		String sql="insert into subjects(subject) values(?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, name);
		st.execute();
	}
	//get all subjects from db
	public static ResultSet getSubjects() throws ClassNotFoundException, SQLException, IOException
	{
		 Connection con=MyConnection.getConnection();
		 String sql="select * from subjects";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 return rs;
	}
}

