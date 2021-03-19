package com.pindian.lonphy.domain;

/**
 * Transportcost entity. @author MyEclipse Persistence Tools
 */

public class Transportcost implements java.io.Serializable {

	// Fields

	private String id;
	private Float price;
	private String description;

	// Constructors

	/** default constructor */
	public Transportcost() {
	}

	/** minimal constructor */
	public Transportcost(String id) {
		this.id = id;
	}

	/** full constructor */
	public Transportcost(String id, Float price, String description) {
		this.id = id;
		this.price = price;
		this.description = description;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transportcost [id=" + id + ", price=" + price
				+ ", description=" + description + "]";
	}

}