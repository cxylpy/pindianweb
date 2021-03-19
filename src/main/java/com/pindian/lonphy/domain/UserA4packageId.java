package com.pindian.lonphy.domain;

/**
 * UserA4packageId entity. @author MyEclipse Persistence Tools
 */

public class UserA4packageId implements java.io.Serializable {

	// Fields

	private User user;
	private A4package a4package;

	// Constructors

	/** default constructor */
	public UserA4packageId() {
	}

	/** full constructor */
	public UserA4packageId(User user, A4package a4package) {
		this.user = user;
		this.a4package = a4package;
	}

	// Property accessors

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public A4package getA4package() {
		return this.a4package;
	}

	public void setA4package(A4package a4package) {
		this.a4package = a4package;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserA4packageId))
			return false;
		UserA4packageId castOther = (UserA4packageId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getA4package() == castOther.getA4package()) || (this
						.getA4package() != null
						&& castOther.getA4package() != null && this
						.getA4package().equals(castOther.getA4package())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getA4package() == null ? 0 : this.getA4package().hashCode());
		return result;
	}

}