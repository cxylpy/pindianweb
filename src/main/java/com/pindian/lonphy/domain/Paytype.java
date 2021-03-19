package com.pindian.lonphy.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Paytype entity. @author MyEclipse Persistence Tools
 */

public class Paytype implements java.io.Serializable {

	// Fields

	private Integer type;
	private String description;
//	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Paytype() {
	}

	/** minimal constructor */
	public Paytype(Integer type) {
		this.type = type;
	}

	/** full constructor */
	public Paytype(Integer type, String description, Set products) {
		this.type = type;
		this.description = description;
//		this.products = products;
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

//	public Set getProducts() {
//		return this.products;
//	}
//
//	public void setProducts(Set products) {
//		this.products = products;
//	}

}