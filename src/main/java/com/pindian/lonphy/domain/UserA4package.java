package com.pindian.lonphy.domain;

import java.sql.Timestamp;

/**
 * UserA4package entity. @author MyEclipse Persistence Tools
 */

public class UserA4package implements java.io.Serializable {

	// Fields

	private UserA4packageId id;
	private Integer restPage;
	private Timestamp gettime;
	
	// Constructors

	/** default constructor */
	public UserA4package() {
	}

	/** minimal constructor */
	public UserA4package(UserA4packageId id) {
		this.id = id;
	}

	/** full constructor */
	public UserA4package(UserA4packageId id, Integer restPage) {
		this.id = id;
		this.restPage = restPage;
	}

	// Property accessors

	public UserA4packageId getId() {
		return this.id;
	}

	public void setId(UserA4packageId id) {
		this.id = id;
	}

	public Integer getRestPage() {
		return this.restPage;
	}

	public Timestamp getGettime() {
		return gettime;
	}

	public void setGettime(Timestamp gettime) {
		this.gettime = gettime;
	}

	public void setRestPage(Integer restPage) {
		this.restPage = restPage;
	}

}