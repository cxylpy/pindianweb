package com.pindian.lonphy.domain;

/**
 * Files entity. @author MyEclipse Persistence Tools
 */

public class Files implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String absolutepath;
	private String urlpath;
	// Constructors

	/** default constructor */
	public Files() {
	}

	/** full constructor */
	public Files(User user, String absolutepath, String urlpath) {
		this.user = user;
		this.absolutepath = absolutepath;
		this.urlpath = urlpath;
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

	public String getAbsolutepath() {
		return this.absolutepath;
	}

	public void setAbsolutepath(String absolutepath) {
		this.absolutepath = absolutepath;
	}

	public String getUrlpath() {
		return this.urlpath;
	}

	public void setUrlpath(String urlpath) {
		this.urlpath = urlpath;
	}

}