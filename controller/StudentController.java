package com.satyam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.satyam.entity.Student;
import com.satyam.service.StudentService;

@Controller
public class StudentController {

	private StudentService service;

//constructor injection
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	// handler

	@GetMapping("/students")
	public String listStudent(Model m) {
		System.out.println("student controller");
		m.addAttribute("students", service.getAllStudent());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudent(Model m) {

		Student student = new Student();
		m.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudeentForm(@PathVariable Long id, Model m) {

		m.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model m) {

		// get student from database by id
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		service.updateStudent(existingStudent);

		// m.addAttribute("student", service.updateStudent(student));
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);

		return "redirect:/students";

	}

}
