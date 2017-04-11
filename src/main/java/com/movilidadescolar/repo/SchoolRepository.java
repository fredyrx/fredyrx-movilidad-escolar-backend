package com.movilidadescolar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.School;

public interface SchoolRepository extends JpaRepository<School,Long> {
	School findById(Long id);
}
