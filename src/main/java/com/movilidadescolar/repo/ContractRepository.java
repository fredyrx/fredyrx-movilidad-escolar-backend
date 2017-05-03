package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{
	Contract findById(Long id);
	//List<Contract> findByDriverId(int driver_id);
}
