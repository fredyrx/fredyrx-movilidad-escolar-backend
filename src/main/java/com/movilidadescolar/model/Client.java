package com.movilidadescolar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "clients")
public class Client implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "born_date")
	private Date bornDate;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "latitude")
	private Float latitude;
	
	@Column(name = "longitude")
	private Float longitude;
	
	protected Client(){}

	public Client(Long id, User user, String name, String lastName, String photo, Date bornDate, String address,
			Float latitude, Float longitude) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.lastName = lastName;
		this.photo = photo;
		this.bornDate = bornDate;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.name = user.getName();
		this.lastName = user.getLastName();
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
}
