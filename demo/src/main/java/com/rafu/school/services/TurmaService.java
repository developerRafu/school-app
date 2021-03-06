package com.rafu.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.school.domain.Turma;
import com.rafu.school.repositories.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository repository;
	
	public List<Turma> findAll(){
		return this.repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> turma = this.repository.findById(id);
		if (turma.isPresent()) {
			return turma.get();
		} else {
			return null;
		}
	}

	public Turma save(Turma turma) {
		return this.repository.save(turma);
	}
	

	public Turma update(Turma turma) {
		return this.repository.save(turma);
	}

	public Turma deleteById(Turma turma) {
		this.repository.deleteById(turma.getId());
		return turma;
	}
}
