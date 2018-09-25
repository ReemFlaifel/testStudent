package com.erabia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.erabia.dao.StudentDao;
import com.erabia.entities.Student;
import com.erabia.enums.StudentExceptionType;
import com.erabia.exceptions.StudentException;
import com.erabia.service.CSVFileService;
import com.erabia.service.impl.CSVFileServiceImpl;

public class StudentCsvDaoImpl implements StudentDao {

	CSVFileService service = new CSVFileServiceImpl();

	private static final String PATH = "/home/rflaifel/Desktop/Reem/workspaces/my-src/Student/Docs/students.csv";

	protected String getDSPath() {

		return PATH;

	}

	@Override
	public List<Student> getAll() {

		List<Student> allStudents = new ArrayList<Student>();

		List<Map<Integer, String>> recordsList = service.readFile(getDSPath(), ",");

		for (Map<Integer, String> map : recordsList) {
			int id = Integer.parseInt(map.get(new Integer(0)));
			String name = map.get(new Integer(1));
			int score = Integer.parseInt(map.get(new Integer(2)));

			allStudents.add(fillStudent(id, name, score));
		}

		return allStudents;

	}

	@Override
	public void add(Student student) {

		service.addRecord(student.getName(), student.getId(), student.getScore(), getDSPath());

	}

	@Override
	public void updateScore(int studentId, int updatedScore) {

		List<Student> allStudents = getAll();

		for (Student student : allStudents) {
			if (student.getId() != studentId) {
				continue;
			}

			student.setScore(updatedScore);
		}

		addAllStudents(allStudents);

	}

	@Override
	public void delete(int deletedStudentId) throws StudentException {

		List<Student> allStudents = getAll();
		Student deletedStudent = null;
		for (Student student : allStudents) {
			if (student.getId() == deletedStudentId) {
				deletedStudent = student;
				break;
			}

		}
		if (deletedStudent == null) {
			throw new StudentException(StudentExceptionType.STUDENTNOTFOUND);
		}
		allStudents.remove(deletedStudent);
		addAllStudents(allStudents);

	}

	@Override
	public Student getById(int id) {

		for (Student student : getAll()) {
			if (student.getId() == id) {
				return student;
			}
		}

		return null;

	}

	public void addAllStudents(List<Student> studentList) {

		List<String> updatedRecords = new ArrayList<String>();

		for (Student student : studentList) {
			String name = student.getName();
			int id = student.getId();
			int score = student.getScore();
			updatedRecords.add(id + "," + name + "," + score);
		}
		service.addAllRecords(updatedRecords, getDSPath());

	}

	protected Student fillStudent(final int id, final String name, final int score) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setScore(score);

		return student;

	}

}
