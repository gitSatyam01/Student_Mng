package com.satyam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satyam.entity.Student;
import com.satyam.repo.StudentRepo;

@SpringBootApplication
public class StudentMngSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentMngSystemApplication.class, args);
	}

	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
