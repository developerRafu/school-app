package com.rafu.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafu.school.domain.School;

public interface SchoolRepository extends JpaRepository<School, Long>{

}
