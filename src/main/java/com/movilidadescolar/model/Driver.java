package com.movilidadescolar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@SuppressWarnings("serial")
@Entity
@Table(name = "drivers")
public class Driver implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "license_id", nullable = false, unique = true)
	private String licenseId;
	
	@Column(name = "car_model")
	private String carModel;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
	List<SchoolDriver> schoolDrivers;
	
	public List<SchoolDriver> getSchoolDrivers() {
		return schoolDrivers;
	}

	public void setSchoolDrivers(List<SchoolDriver> schoolDrivers) {
		this.schoolDrivers = schoolDrivers;
	}

	protected Driver(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Driver(Integer id, String name, String lastName, String email, String password, String phoneNumber,
			String licenseId, String carModel) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.licenseId = licenseId;
		this.carModel = carModel;
	}
	
}
