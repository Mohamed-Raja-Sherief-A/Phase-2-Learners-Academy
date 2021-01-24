package com.learners.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	//Function to connect to DB
   public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException
   {
	   String driver="com.mysql.cj.jdbc.Driver";//replace with your driver
	   String url="jdbc:mysql://localhost:3306/learners";//replace with your url
	   String username="root";//replace with your username
	   String password="2435932";//replace with your password
	   Class.forName(driver);
	    Connection con=DriverManager.getConnection(url,username,password);
	    return con;
   }
}
