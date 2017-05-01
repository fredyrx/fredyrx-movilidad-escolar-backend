package com.movilidadescolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "dependant")
public class Dependent implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String photo;
	
	private Date born;
	
	@Column(name = "home_address")
	private String homeAddress;
	
	private Double latitude;
	private Double longitude;
	
	protected Dependent(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Dependent(Long id, String name, String lastName, String photo, Date born, String homeAddress,
			Double latitude, Double longitude) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.photo = photo;
		this.born = born;
		this.homeAddress = homeAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
}
