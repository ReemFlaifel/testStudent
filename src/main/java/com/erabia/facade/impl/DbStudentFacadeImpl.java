package com.erabia.facade.impl;

import java.util.List;

import com.erabia.entities.Student;
import com.erabia.facade.StudentFacade;
import com.erabia.service.StudentServices;
import com.erabia.service.impl.dbStudentServicesImpl;

public class DbStudentFacadeImpl implements StudentFacade {
	private StudentServices services = new dbStudentServicesImpl();

	@Override
	public List<Student> getall() throws Exception {
		return services.getAll();
	}

	@Override
	public Student getByID(int id) throws Exception {
		return services.getbyId(id);
	}

	@Override
	public void add(Student student) throws Exception {
		services.add(student);
	}

	@Override
	public void delete(int id) throws Exception {
		services.delete(id);
	}

	@Override
	public void updateScore(int id, int score) throws Exception {
		services.updateScoreByID(id, score);
	}

}
