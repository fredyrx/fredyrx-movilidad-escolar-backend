package com.movilidadescolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@SuppressWarnings("serial")
@Entity
@Table(name = "Users")
public class User implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "password_hash")
	private String passwordHash;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "active")
	private Boolean active;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "create_at")
	private Date createdAt;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "alter_at")
	private Date alterAt;
	
	protected User(){
		// Will be used by JPA
	}
	
	public User(String email, String passwordHash, String name, String lastName){
		this.email = email;
		this.passwordHash = passwordHash;
		this.name = name;
		this.lastName = lastName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getAlterAt() {
		return alterAt;
	}

	public void setAlterAt(Date alterAt) {
		this.alterAt = alterAt;
	}

	@Override
	public String toString(){
		return String.format("User[id=%s, name=%s, lastName=%s]",this.id,  this.name, this.lastName);
	}
}
