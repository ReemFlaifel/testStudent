package com.erabia.facade;

import java.util.List;

import com.erabia.entities.Student;
import com.erabia.exceptions.StudentException;

public interface StudentFacade {
	public List<Student> getall() throws Exception;

	public Student getByID(int id) throws Exception;

	public void add(Student student) throws Exception;

	public void delete(int id) throws Exception;

	public void updateScore(int id, int score) throws Exception;
}
