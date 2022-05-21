package com.mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoDemo {
	public static void main(String[] args) throws SQLException {
		StudentDAO dao = new StudentDAO();
		
		Student s1 = dao.getStudent(100);
		System.out.println(s1.name);
	}

}
class StudentDAO {
	public Student getStudent(int id) throws SQLException {
		
		Student s = new Student();
		
		s.id = id;
		try {
			String query = "select name from student where id = " + id; 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0902");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.name = name;
			return s;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
class Student {
	int id;
	String name;
}