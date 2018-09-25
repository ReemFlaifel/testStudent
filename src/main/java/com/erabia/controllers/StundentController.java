package com.erabia.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erabia.entities.Student;
import com.erabia.service.StudentServices;
import com.erabia.service.impl.StudentCsvServicesImpl;

@RestController
public class StundentController {
	StudentServices services = new StudentCsvServicesImpl();

	@GetMapping("/allStudent")
	public List<Student> getAll() throws Exception {

		return services.getAll();

	}

	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) throws Exception {
		services.add(student);
	}
}
