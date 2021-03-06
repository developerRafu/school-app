package com.rafu.school.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafu.school.domain.School;
import com.rafu.school.domain.SchoolDTO;
import com.rafu.school.domain.Student;
import com.rafu.school.domain.StudentDTO;
import com.rafu.school.services.SchoolService;

@RestController
@RequestMapping("/escolas")
public class SchoolController {

	@Autowired
	SchoolService service;

	@GetMapping
	public ResponseEntity<?> getEscolas() {
		List<School> lista = this.service.findAll();
		List<SchoolDTO> listaDTO = new ArrayList<>();
		for(School s : lista) {
			listaDTO.add(this.service.schoolToDTO(s));
		}
		return ResponseEntity.ok().body(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEscola(@PathVariable Long id) {
		School school = this.service.findById(id);
		return ResponseEntity.ok().body(this.service.schoolToDTO(school));
	}

	@GetMapping("/{id}/alunos")
	public ResponseEntity<?> getAlunosByEscola(@PathVariable Long id) {
		List<Student> lista = this.service.findAlunosByEscola(id);
		List<StudentDTO> listaDTO = new ArrayList<>();
		for(Student s : lista) {
			listaDTO.add(this.service.studentToDTO(s));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<?> saveEscola(@RequestBody School school){
		return ResponseEntity.ok().body(this.service.save(school));
	}
	
	@PostMapping("/{id}/alunos/novo")
	public ResponseEntity<?> saveAlunoByEscola(@RequestBody Student student, @PathVariable Long id){
		Student studentSave = this.service.saveAlunoByEscola(student, id);
		return ResponseEntity.ok().body(this.service.studentToDTO(studentSave));
	}
	@PostMapping("/{id}/apagar")
	public ResponseEntity<?> apagarEscola(@PathVariable Long id){
		this.service.deleteById(id);
		return ResponseEntity.ok().body(null);
	}
}
