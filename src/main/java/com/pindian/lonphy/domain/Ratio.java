package com.pindian.lonphy.domain;

/**
 * Ratio entity. @author MyEclipse Persistence Tools
 */

public class Ratio implements java.io.Serializable {

	// Fields

	private Integer id;
	private Float price;

	// Constructors

	/** default constructor */
	public Ratio() {
	}

	/** full constructor */
	public Ratio(Float price) {
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}