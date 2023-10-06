package com.SpringBootRest.Service;

import java.util.List;
import java.util.Map;

import com.SpringBootRest.Model.Student;

public  interface Studentservice {

	Student savestudent(Student student);

	Student getstudent(int id);

	List<Student> getallstudent();

	Student updatestudent(int id, Student student);

	Student patchstudent(int id, Map<String, Object> fields);

	void deletestudent(int id);

	

	   

}
