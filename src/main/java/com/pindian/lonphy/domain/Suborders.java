package com.pindian.lonphy.domain;

/**
 * Suborders entity. @author MyEclipse Persistence Tools
 */

public class Suborders implements java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private Ordergroup ordergroup;
	private String description;
	private String imgPath;
	private Integer number;
	private Float price;
	private String filePath;
	// Constructors

	/** default constructor */
	public Suborders() {
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/** minimal constructor */
	public Suborders(String id) {
		this.id = id;
	}

	/** full constructor */
	public Suborders(String id, Ordergroup ordergroup,
			String description, String imgPath, Integer number, Float price) {
		this.id = id;
		this.ordergroup = ordergroup;
		this.description = description;
		this.imgPath = imgPath;
		this.number = number;
		this.price = price;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ordergroup getOrdergroup() {
		return this.ordergroup;
	}

	public void setOrdergroup(Ordergroup ordergroup) {
		this.ordergroup = ordergroup;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}