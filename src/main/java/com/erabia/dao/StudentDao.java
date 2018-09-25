package com.erabia.dao;

import java.util.List;

import com.erabia.entities.Student;
import com.erabia.exceptions.StudentException;

public interface StudentDao {

	public List<Student> getAll() throws Exception;

	public void add(Student s) throws Exception;

	public void updateScore(int studentId, int updatedScore) throws Exception;

	public void delete(int deletedStudentId) throws StudentException, Exception;

	public Student getById(int id) throws Exception;

}
