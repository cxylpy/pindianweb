package com.pindian.lonphy.domain;

/**
 * Transporttype entity. @author MyEclipse Persistence Tools
 */

public class Transporttype implements java.io.Serializable {

	// Fields

	private Integer type;
	private String description;

	// Constructors

	/** default constructor */
	public Transporttype() {
	}

	/** minimal constructor */
	public Transporttype(Integer type) {
		this.type = type;
	}

	/** full constructor */
	public Transporttype(Integer type, String description) {
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