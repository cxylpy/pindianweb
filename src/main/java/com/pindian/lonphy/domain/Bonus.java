package com.pindian.lonphy.domain;

import java.sql.Timestamp;

/**
 * Bonus entity. @author MyEclipse Persistence Tools
 */

public class Bonus implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String oid;
	private Timestamp createTime;
	private Integer delta;

	// Constructors

	/** default constructor */
	public Bonus() {
	}

	/** full constructor */
	public Bonus(User user, String oid, Integer delta) {
		this.user = user;
		this.oid = oid;
		this.delta = delta;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}


	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getDelta() {
		return this.delta;
	}

	public void setDelta(Integer delta) {
		this.delta = delta;
	}

}