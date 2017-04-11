package com.movilidadescolar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.License;

public interface LicenseRepository extends JpaRepository<License,Long>{
	License findById(String id);
}