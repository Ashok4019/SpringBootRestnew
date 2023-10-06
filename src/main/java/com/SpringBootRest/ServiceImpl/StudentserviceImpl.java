package com.SpringBootRest.ServiceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.SpringBootRest.Model.Student;
import com.SpringBootRest.Repository.StudentRepo;
import com.SpringBootRest.Service.Studentservice;

@Service
public class StudentserviceImpl implements Studentservice {
    
	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student savestudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student getstudent(int id) {
		
		return studentRepo.findById(id).get();
	}

	@Override
	public List<Student> getallstudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student updatestudent(int id, Student student) {
		Student studentupdate = studentRepo.findById(id).get();
		studentupdate.setLocation(student.getLocation());
		studentupdate.setName(student.getName());
		return studentRepo.save(studentupdate);
	}

	@Override
	public Student patchstudent(int id, Map<String, Object> fields) {
		Optional<Student> findById = studentRepo.findById(id);
		if(findById.isPresent()) {
			fields.forEach((key,value)->{
				Field field = ReflectionUtils.findField(Student.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, findById.get(), value);
				
			});
			return studentRepo.save(findById.get());
		}
		return null;
	}

	@Override
	public void deletestudent(int id) {
		studentRepo.deleteById(id);
		
	}


}
