package com.pindian.lonphy.domain;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String receiver;
	private String mobile;
	private String address;
	private String uid;
	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(User user) {
		this.user = user;
	}

	/** full constructor */
	public Address(User user, String receiver, String mobile, String address) {
		this.user = user;
		this.receiver = receiver;
		this.mobile = mobile;
		this.address = address;
	}
	
	// Property accessors

	public Address(String receiver, String mobile, String address, String uid) {
		super();
		this.receiver = receiver;
		this.mobile = mobile;
		this.address = address;
		this.uid = uid;
	}

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

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}