package com.satyam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satyam.entity.Student;
import com.satyam.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepo repo;

	public StudentServiceImpl(StudentRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {

		return repo.findById(id).get();

	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);

	}

}
