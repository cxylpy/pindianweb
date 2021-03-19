package com.pindian.lonphy.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Privileges entity. @author MyEclipse Persistence Tools
 */

public class Privileges implements java.io.Serializable {

	// Fields

	private Integer id;
	private String action;
	private String name;

	// Constructors

	/** default constructor */
	public Privileges() {
	}

	/** full constructor */
	public Privileges(String action, String name) {
		this.action = action;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}