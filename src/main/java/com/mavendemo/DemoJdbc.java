package com.mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoJdbc {
  public static void main(String[] args) throws Exception {
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  String url = "jdbc:mysql://localhost:3306/learn";
	  String uname = "root";
	  String pass = "0902";
		String query ="select * from student"; 	  
	  
	  
	  Connection con = DriverManager.getConnection(url,uname,pass);
	  Statement st = con.createStatement();
	  ResultSet rs = st.executeQuery(query);
	  String userdata="";
	  while(rs.next()){
	  userdata = rs.getInt(1) + " : " + rs.getString("name") + " : " + rs.getString("city") + " : " + rs.getString("country") + " : " + rs.getInt(5);
	  System.out.println(userdata);
	  }
	  st.close();
	  con.close();
}
}