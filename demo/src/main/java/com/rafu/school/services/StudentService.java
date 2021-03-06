package com.rafu.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.school.domain.Student;
import com.rafu.school.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	
	public List<Student> findAll(){
		return this.repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> student = this.repository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			return null;
		}
	}

	public Student save(Student student) {
		return this.repository.save(student);
	}
	

	public Student update(Student student) {
		return this.repository.save(student);
	}

	public Student deleteById(Student student) {
		this.repository.deleteById(student.getId());
		return student;
	}
}
