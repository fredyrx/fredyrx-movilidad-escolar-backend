package com.movilidadescolar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.State;

public interface StateRepository extends JpaRepository<State,Long>{

	State findById(String id);
	State findByOrderNumber(Integer orderNumber);
}
