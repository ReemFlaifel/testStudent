package com.erabia.service.impl;

import java.util.List;

import com.erabia.dao.StudentDao;
import com.erabia.dao.impl.StudentDbDaoImpl;
import com.erabia.entities.Student;
import com.erabia.exceptions.StudentException;
import com.erabia.service.StudentServices;

public class dbStudentServicesImpl implements StudentServices {
	StudentDao dao = new StudentDbDaoImpl();

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
		dao.updateScore(studentId, updatedScore);

	}

	@Override
	public void delete(int id) throws StudentException, Exception {
		dao.delete(id);

	}

}
