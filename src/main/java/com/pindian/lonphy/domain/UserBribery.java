package com.pindian.lonphy.domain;

import java.sql.Timestamp;

/**
 * UserBribery entity. @author MyEclipse Persistence Tools
 */

public class UserBribery implements java.io.Serializable {

	// Fields

	private UserBriberyId id;
	private Ordergroup ordergroup;
	private Integer used;
	private Timestamp usetime;
	private Timestamp gettime;

	// Constructors

	/** default constructor */
	public UserBribery() {
	}

	/** minimal constructor */
	public UserBribery(UserBriberyId id) {
		this.id = id;
	}

	/** full constructor */
	public UserBribery(UserBriberyId id, Ordergroup ordergroup, Integer used,
			Timestamp usetime, Timestamp gettime) {
		this.id = id;
		this.ordergroup = ordergroup;
		this.used = used;
		this.usetime = usetime;
		this.gettime = gettime;
	}

	// Property accessors

	public UserBriberyId getId() {
		return this.id;
	}

	public void setId(UserBriberyId id) {
		this.id = id;
	}



	public Ordergroup getOrdergroup() {
		return ordergroup;
	}

	public void setOrdergroup(Ordergroup ordergroup) {
		this.ordergroup = ordergroup;
	}

	public Integer getUsed() {
		return this.used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Timestamp getUsetime() {
		return this.usetime;
	}

	public void setUsetime(Timestamp usetime) {
		this.usetime = usetime;
	}

	public Timestamp getGettime() {
		return this.gettime;
	}

	public void setGettime(Timestamp gettime) {
		this.gettime = gettime;
	}

	@Override
	public String toString() {
		return "UserBribery [id=" + id + ", ordergroup=" + ordergroup
				+ ", used=" + used + ", usetime=" + usetime + ", gettime="
				+ gettime + "]";
	}

}