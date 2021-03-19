package com.pindian.lonphy.domain;

/**
 * Teckdetail entity. @author MyEclipse Persistence Tools
 */

public class Teckdetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Producttech producttech;
	private String description;
	private Float priceDelta;

	// Constructors

	/** default constructor */
	public Teckdetail() {
	}

	/** full constructor */
	public Teckdetail(Producttech producttech, String description,
			Float priceDelta) {
		this.producttech = producttech;
		this.description = description;
		this.priceDelta = priceDelta;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producttech getProducttech() {
		return this.producttech;
	}

	public void setProducttech(Producttech producttech) {
		this.producttech = producttech;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Float getPriceDelta() {
		return priceDelta;
	}

	public void setPriceDelta(Float priceDelta) {
		this.priceDelta = priceDelta;
	}

	@Override
	public String toString() {
		return "Teckdetail [id=" + id 
				+ ", description=" + description + ", priceDelta=" + priceDelta
				+ "]";
	}

}