package com.learners.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learners.jdbc.MyConnection;

public class AssignFunctions {
	//function to add assignments 
	public static void addAssign(int classid, int teacherid, int subjectid) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con=MyConnection.getConnection();
		String sql="insert into assign(cid,tid,sid) values(?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);		
		st.setInt(1, classid);
		st.setInt(2, teacherid);
		st.setInt(3, subjectid);
		st.execute();
	}
	//function to get all assignments
	public static ResultSet getAssign() throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=MyConnection.getConnection();
		String sql="select c.class,t.teacher,s.subject from classes c,assign a,teachers t,subjects s where a.cid=c.cid and a.tid=t.tid and a.sid=s.sid";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		return rs;
	}
	//function to delete assignments
	public static void deleteAssign(String classname,String teacher,String subject) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=MyConnection.getConnection();
		String sql="delete from assign where cid in (select cid from classes where class=?) and tid in (select tid from teachers where teacher=?) and sid in (select sid from subjects where subject=?)";
		PreparedStatement st=con.prepareStatement(sql);	
		st.setString(1, classname);
		st.setString(2, teacher);
		st.setString(3, subject);
		st.execute();
	}

}
