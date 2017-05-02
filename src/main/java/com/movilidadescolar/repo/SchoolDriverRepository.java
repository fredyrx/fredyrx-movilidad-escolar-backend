package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.SchoolDriver;

public interface SchoolDriverRepository extends JpaRepository<SchoolDriver,Long>{
	List<SchoolDriver> findByDriverId(int driver_id);
}
