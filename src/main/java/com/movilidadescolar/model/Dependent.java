package com.movilidadescolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.JoinColumn;

@SuppressWarnings("serial")
@Entity
@Table(name = "dependant")
public class Dependent implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
	private Client client;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "photo_uri")
	private String photoUri;
	
	private Date birthday;
	
	@Column(name = "home_address")
	private String homeAddress;
	
	private Double latitude;
	private Double longitude;
	
	protected Dependent(){}

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

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photo) {
		this.photoUri = photo;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Dependent(Integer id, String name, String lastName, String photo, Date born, String homeAddress,
			Double latitude, Double longitude) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.photoUri = photo;
		this.birthday = born;
		this.homeAddress = homeAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
}
