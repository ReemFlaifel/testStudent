package com.erabia.service;

import java.util.List;

import com.erabia.entities.Student;
import com.erabia.exceptions.StudentException;

public interface StudentServices {

	public List<Student> getAll() throws Exception;

	public void add(Student student) throws Exception;

	public Student getbyId(int id) throws Exception;

	public void updateScoreByID(int studentId, int updatedScore) throws Exception;

	public void delete(int id) throws StudentException, Exception;

}
