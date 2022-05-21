package com.mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoDemo2 {
	public static void main(String[] args) throws SQLException {
		StudentDAO1 dao = new StudentDAO1();
		Student1 s1 = new Student1();
		
		
		s1.id = 1000;
		s1.name = "soniya";
		s1.city = "Nagar";
		s1.country = "India";
		s1.mark = 91;
		dao.connect();
		dao.addStudent(s1);
	}

}
class StudentDAO1 {
	
	Connection con =null;
	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0902");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Student getStudent(int id) throws SQLException {
		
		Student s = new Student();
		
		s.id = id;
		String query = "select name from student where id = " + id; 
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		s.name = name;
		
		return null;
	}
		public void addStudent(Student1 s1) throws SQLException {
			
			String query = "insert into student values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, s1.id);
			pst.setString(2, s1.name);
			pst.setString(3, s1.city);
			pst.setString(4, s1.country);
			pst.setInt(5, s1.mark);
			
			pst.executeUpdate();
		}
	 
}
class Student1 {
	int id,mark;
	String name,city,country;
}