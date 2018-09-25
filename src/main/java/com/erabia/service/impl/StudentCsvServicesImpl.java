package com.erabia.service.impl;

import java.util.List;

import com.erabia.dao.StudentDao;
import com.erabia.dao.impl.StudentCsvDaoImpl;
import com.erabia.entities.Student;
import com.erabia.service.StudentServices;

public class StudentCsvServicesImpl implements StudentServices {
	private StudentDao dao = new StudentCsvDaoImpl();

	@Override
	public List<Student> getAll() throws Exception {
		return dao.getAll();
	}

	@Override
	public void add(Student student) throws Exception {
		dao.add(student);
	}

	@Override
	public Student getbyId(int id) throws Exception {
		return dao.getById(id);
	}

	@Override
	public void updateScoreByID(int studentId, int updatedScore) throws Exception {
		dao.updateScore(1, updatedScore);
	}

	@Override
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
}