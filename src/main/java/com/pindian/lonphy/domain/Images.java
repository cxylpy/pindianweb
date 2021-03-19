package com.pindian.lonphy.domain;

/**
 * Images entity. @author MyEclipse Persistence Tools
 */

public class Images implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private String absolutepath;
	private String urlpath;

	// Constructors

	/** default constructor */
	public Images() {
	}

	/** full constructor */
	public Images(Product product, String absolutepath, String urlpath) {
		this.product = product;
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
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