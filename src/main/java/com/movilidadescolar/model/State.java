package com.movilidadescolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State {
	
	@Id
	@Column(name = "id", length = 2)
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "order_number", nullable = false)
	private Integer orderNumber;
	
	@Column(name = "at_work", nullable = false)
	private boolean atWork;

	public boolean isAtWork() {
		return atWork;
	}

	public void setAtWork(boolean atWork) {
		this.atWork = atWork;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	protected State(){
		// Will be use by JPA
	}
	
	public State(String id, String name, Integer orderNumber, boolean atWork){
		this.id = id;
		this.name = name;
		this.orderNumber = orderNumber;
		this.atWork = atWork;
	}
}
