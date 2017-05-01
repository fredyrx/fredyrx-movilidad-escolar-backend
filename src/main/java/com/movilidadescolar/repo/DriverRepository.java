package com.movilidadescolar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.Driver;

public interface DriverRepository extends JpaRepository<Driver,Long>{
	Driver findById(Long id);
	Driver findByEmailAndPassword(String email, String password);
}
