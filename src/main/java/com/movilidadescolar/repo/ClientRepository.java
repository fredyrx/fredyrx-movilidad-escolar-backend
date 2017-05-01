package com.movilidadescolar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movilidadescolar.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	Client findById(Long id);
	Client findByEmailAndPassword(String email, String password);
}
