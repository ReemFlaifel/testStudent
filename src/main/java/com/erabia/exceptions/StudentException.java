package com.erabia.exceptions;

import com.erabia.enums.StudentExceptionType;

public class StudentException extends Exception {

	private static final long serialVersionUID = 1L;
	private StudentExceptionType type;

	public StudentException(StudentExceptionType type) {
		setType(type);
	}

	@Override
	public String getMessage() {
		if (type == StudentExceptionType.STUDENTNOTFOUND) {
			return "Student not found";
		}
		
		return super.getMessage();
	}

	public StudentExceptionType getType() {
		return type;
	}

	public void setType(StudentExceptionType type) {
		this.type = type;
	}

}
