package com.SpringBootRest.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootRest.Model.Student;
import com.SpringBootRest.Service.Studentservice;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	Studentservice studentservice;

	@PostMapping
	public void createstudent(@RequestBody Student student) {
		 System.out.println(student);
		//return studentservice.savestudent(student);
	}

	@GetMapping("/{id}")
	public Student getstudent(@PathVariable int id) {
		return studentservice.getstudent(id);
	}

	@GetMapping
	public List<Student> getallstudent() {
		return studentservice.getallstudent();

	}

	@PutMapping("/{id}")
	public Student putstudent(@PathVariable int id, @RequestBody Student student) {
		return studentservice.updatestudent(id, student);

	}

	@PatchMapping("/{id}")
	public Student patchstudent(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return studentservice.patchstudent(id, fields);
	}
	

	String deletestudent(@PathVariable int id) {
		studentservice.deletestudent(id);
		return "delete succssfully";

	}

}
