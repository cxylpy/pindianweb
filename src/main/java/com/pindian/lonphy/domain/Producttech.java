package com.pindian.lonphy.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Producttech entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Lonphy
 *
 */
public class Producttech implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private String name;
	private Integer inputType;
	private Set teckdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Producttech() {
	}

	/** full constructor */
	public Producttech(Product product, String name, Integer inputType,
			Set teckdetails) {
		this.product = product;
		this.name = name;
		this.inputType = inputType;
		this.teckdetails = teckdetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInputType() {
		return this.inputType;
	}

	public void setInputType(Integer inputType) {
		this.inputType = inputType;
	}

	public Set getTeckdetails() {
		return this.teckdetails;
	}

	public void setTeckdetails(Set teckdetails) {
		this.teckdetails = teckdetails;
	}

	@Override
	public String toString() {
		return "Producttech [id=" + id +  ", name="
				+ name + ", inputType=" + inputType + ", teckdetails="
				+ teckdetails + "]";
	}

}