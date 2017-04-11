package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.State;
import com.movilidadescolar.model.User;

public interface StateRepository extends JpaRepository<State,Long>{

	State findById(String id);
	State findByOrderNumber(Integer orderNumber);
}
