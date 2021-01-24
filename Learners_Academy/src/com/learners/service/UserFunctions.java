package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.learners.jdbc.MyConnection;


public class UserFunctions {
//Function to add credentials
 public static void registration(String username,String password) throws ClassNotFoundException, SQLException, IOException
 {
	  Connection con=MyConnection.getConnection();
	  String sql="insert into users(username,password) values(?,?)";
	  PreparedStatement st=con.prepareStatement(sql);
	  st.setString(1, username);
	  st.setString(2, password);
	  st.execute();
 }
 //Function to check if credentials exist
 public static boolean login(String username,String password) throws ClassNotFoundException, SQLException, IOException
 {
	  Connection con=MyConnection.getConnection();
	  String sql="select * from users where username=? and password=?"; 
	  PreparedStatement st=con.prepareStatement(sql);
	  st.setString(1, username);
	  st.setString(2, password);
	  ResultSet rs=st.executeQuery();
	  if(rs.next())
	  {
		  return true;
	  }
	  return false;
	  
 }
}
