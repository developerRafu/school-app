package com.rafu.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafu.school.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
