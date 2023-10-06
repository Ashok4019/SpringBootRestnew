package com.SpringBootRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRest.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
