package com.movilidadescolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licenses")
public class License {

	@Id
	@Column(name = "id", length = 5)
	private String id;
	
	@Column(name = "license_class", length = 1, nullable = false)
	private String licenseClass;
	
	@Column(name = "license_category", length = 4, nullable = false)
	private String licenseCategory;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLicenseClass() {
		return licenseClass;
	}

	public void setLicenseClass(String licenseClass) {
		this.licenseClass = licenseClass;
	}

	public String getLicenseCategory() {
		return licenseCategory;
	}

	public void setLicenseCategory(String licenseCategory) {
		this.licenseCategory = licenseCategory;
	}

	protected License(){
		// Will be used by JPA
	}
	
	public License(String id, String licenseClass, String licenseCategory){
		this.id = id;
		this.licenseClass = licenseClass;
		this.licenseCategory = licenseCategory;
	}
}
