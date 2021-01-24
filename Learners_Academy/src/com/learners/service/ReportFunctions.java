package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learners.jdbc.MyConnection;

public class ReportFunctions {
	//get subject and teacher details of a respective class
	public static ResultSet getData1(int id) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con=MyConnection.getConnection();
		String sql="select su.subject,t.teacher from assign a,subjects su,teachers t where a.cid=? and su.sid=a.sid and t.tid=a.tid";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		return rs;
	}
	//get students of a perticular class
	public static ResultSet getData2(int id) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con=MyConnection.getConnection();
		String sql="select s.student from students s where s.cid=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		return rs;
	}
	//get class name
	public static ResultSet getData3(int id) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con=MyConnection.getConnection();
		String sql="select class from classes where cid=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		return rs;
	}

	

}
