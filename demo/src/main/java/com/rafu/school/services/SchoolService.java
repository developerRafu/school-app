package com.rafu.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.school.domain.School;
import com.rafu.school.domain.SchoolDTO;
import com.rafu.school.domain.Student;
import com.rafu.school.domain.StudentDTO;
import com.rafu.school.repositories.SchoolRepository;
import com.rafu.school.repositories.StudentRepository;

@Service
public class SchoolService {
	@Autowired
	SchoolRepository repository;
	@Autowired
	StudentRepository studentRepository;

	public List<School> findAll() {
		return this.repository.findAll();
	}

	public School findById(Long id) {
		Optional<School> school = this.repository.findById(id);
		if (school.isPresent()) {
			return school.get();
		} else {
			return null;
		}
	}

	public School save(School school) {
		return this.repository.save(school);
	}

	public School update(School school) {
		return this.repository.save(school);
	}

	public void deleteById(Long id) {
		Optional<School> schoolFound = this.repository.findById(id);
		if (schoolFound.isPresent()) {
			this.repository.delete(schoolFound.get());
		}
	}

	public List<Student> findAlunosByEscola(Long id) {
		Optional<School> schoolFound = this.repository.findById(id);
		if (schoolFound.isPresent()) {
			return schoolFound.get().getAlunos();
		} else {
			return null;
		}
	}

	public Student saveAlunoByEscola(Student student, Long id) {
		Optional<School> schoolFound = this.repository.findById(id);
		if (schoolFound.isPresent()) {
			schoolFound.get().getAlunos().add(student);
			student.setEscola(schoolFound.get());
			this.repository.save(schoolFound.get());
			return this.studentRepository.save(student);
		}
		return null;
	}

	public SchoolDTO schoolToDTO(School school) {
		return new SchoolDTO(school);
	}

	public StudentDTO studentToDTO(Student student) {
		return new StudentDTO(student);
	}
}
