package com.satyam.service;

import java.util.List;

import com.satyam.entity.Student;

public interface StudentService {

	public List<Student> getAllStudent();

	public Student saveStudent(Student student);

	public Student getStudentById(Long id);

	public Student updateStudent(Student student);
	
	public void deleteStudentById(Long id);

}
