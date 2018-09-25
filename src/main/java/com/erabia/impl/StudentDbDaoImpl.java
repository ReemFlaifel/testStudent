package com.erabia.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;
import com.erabia.dao.StudentDao;
import com.erabia.entities.Student;

public class StudentDbDaoImpl implements StudentDao {

	private static final String URL = "jdbc:mysql://localhost:3306/students?useLegacyDatetimeCode=false&serverTimezone=UTC";

	String username = "root";
	String password = "123123";

	protected String getURL() {

		return URL;

	}

	public void add(Student studnt) throws Exception {

		String query = "insert into student values(?,?,?)";
		Connection connection = DriverManager.getConnection(getURL(), username, password);
		PreparedStatement statment = connection.prepareStatement(query);
		statment.setInt(1, studnt.getId());
		statment.setString(2, studnt.getName());
		statment.setInt(3, studnt.getScore());
		statment.executeUpdate();
		connection.close();
	}

	@Override
	public List<Student> getAll() throws Exception {

		List<Student> students = new ArrayList<Student>();
		Connection connection = DriverManager.getConnection(getURL(), username, password);
		Statement statment = connection.createStatement();
		ResultSet set = statment.executeQuery("select * from student");

		while (set.next()) {
			Student student = new Student();
			student.setId(set.getInt(1));
			student.setName(set.getString(2));
			student.setScore(set.getInt(3));
			students.add(student);

		}

		return students;

	}

	@Override
	public void updateScore(int studentId, int updatedScore) throws Exception {

		String query = "update student set score = ? where id = ?";
		Connection connection = DriverManager.getConnection(getURL(), username, password);
		PreparedStatement statment = connection.prepareStatement(query);
		statment.setInt(1, updatedScore);
		statment.setInt(2, studentId);
		statment.executeUpdate();

		connection.close();

	}

	@Override
	public void delete(int deletedStudentId) throws Exception {

		String query = "delete from student where id = ?";
		Connection connection = DriverManager.getConnection(getURL(), username, password);
		PreparedStatement statment = connection.prepareStatement(query);
		statment.setInt(1, deletedStudentId);
		statment.executeUpdate();

		connection.close();

	}

	@Override
	public Student getById(int id) throws Exception {

		String query = "select * from student where id=?";
		Connection connection = DriverManager.getConnection(getURL(), username, password);
		PreparedStatement statment = connection.prepareStatement(query);
		statment.setInt(1, id);
		ResultSet set = statment.executeQuery("select * from student");
		Student student = new Student();
		set.next();
		student.setId(set.getInt(1));
		student.setName(set.getString(2));
		student.setScore(set.getInt(3));
		connection.close();
		return student;

	}
}
