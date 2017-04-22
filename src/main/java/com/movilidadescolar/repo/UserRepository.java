package com.movilidadescolar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

import com.movilidadescolar.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
	User findByEmailAndPasswordHash(String email, String password);
	//User save(User user);
}
