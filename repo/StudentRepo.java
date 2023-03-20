package com.satyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satyam.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
