package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learners.jdbc.MyConnection;

public class ClassFunctions {
	//Adds class to db
	public static void addClass(String name) throws ClassNotFoundException, SQLException, IOException
	{
		 Connection con=MyConnection.getConnection();
		 String sql="insert into classes(class) values(?)";
		 PreparedStatement st=con.prepareStatement(sql);
		 st.setString(1, name);
		 st.execute();
	}
	//Gets all class from db
	public static ResultSet getClasses() throws ClassNotFoundException, SQLException, IOException
	{
		 Connection con=MyConnection.getConnection();
		 String sql="select * from classes";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(sql);
		 return rs;
	}
}
