package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.Dependent;

public interface DependentRepository extends JpaRepository<Dependent,Long> {
	Dependent findById(Integer id);
	List<Dependent> findByClient(Integer client_id);
}
