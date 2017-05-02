package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.Driver;

public interface DriverRepository extends JpaRepository<Driver,Long>{
	Driver findById(Integer id);
	Driver findByEmailAndPassword(String email, String password);
	Driver findByEmail(String email);
	List<Driver> findBySchoolDriversSchoolId(Long id);
}
