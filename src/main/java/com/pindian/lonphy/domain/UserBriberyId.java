package com.pindian.lonphy.domain;

/**
 * UserBriberyId entity. @author MyEclipse Persistence Tools
 */

public class UserBriberyId implements java.io.Serializable {

	// Fields

	private User user;
	private Briberymoney briberymoney;

	// Constructors

	/** default constructor */
	public UserBriberyId() {
	}

	/** full constructor */
	public UserBriberyId(User user, Briberymoney briberymoney) {
		this.user = user;
		this.briberymoney = briberymoney;
	}

	// Property accessors

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Briberymoney getBriberymoney() {
		return this.briberymoney;
	}

	public void setBriberymoney(Briberymoney briberymoney) {
		this.briberymoney = briberymoney;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserBriberyId))
			return false;
		UserBriberyId castOther = (UserBriberyId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getBriberymoney() == castOther.getBriberymoney()) || (this
						.getBriberymoney() != null
						&& castOther.getBriberymoney() != null && this
						.getBriberymoney().equals(castOther.getBriberymoney())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37
				* result
				+ (getBriberymoney() == null ? 0 : this.getBriberymoney()
						.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "UserBriberyId [user=" + user + ", briberymoney=" + briberymoney
				+ "]";
	}

}