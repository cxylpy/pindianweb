package com.pindian.lonphy.domain;

/**
 * Paystatus entity. @author MyEclipse Persistence Tools
 */

public class Paystatus implements java.io.Serializable {

	// Fields

	private Integer type;
	private String description;

	// Constructors

	/** default constructor */
	public Paystatus() {
	}

	/** minimal constructor */
	public Paystatus(Integer type) {
		this.type = type;
	}

	/** full constructor */
	public Paystatus(Integer type, String description) {
		this.type = type;
		this.description = description;
	}

	// Property accessors

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}