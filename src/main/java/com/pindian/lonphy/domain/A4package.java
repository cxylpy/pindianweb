package com.pindian.lonphy.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * A4package entity. @author MyEclipse Persistence Tools
 */

public class A4package implements java.io.Serializable {

	// Fields

	private String id;
	private Integer num;
	private Integer pages;
	private Timestamp validDate;
	private Timestamp createTime;
	private String name;
	private String description;
	private Set userA4packages = new HashSet(0);
	private String imgPath;
	private Integer restNum;
	private Integer isShow;
	// Constructors

	/** default constructor */
	public A4package() {
	}

	/** minimal constructor */
	public A4package(String id) {
		this.id = id;
	}

	/** full constructor */
	public A4package(String id, Integer num, Integer pages,
			Timestamp underCarriage, Timestamp validDate,
			String name, Set userA4packages) {
		this.id = id;
		this.num = num;
		this.pages = pages;
		this.validDate = validDate;
		this.createTime = createTime;
		this.name = name;
		this.userA4packages = userA4packages;
	}

	// Property accessors

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPages() {
		return this.pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Timestamp getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Timestamp validDate) {
		this.validDate = validDate;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getUserA4packages() {
		return this.userA4packages;
	}

	public void setUserA4packages(Set userA4packages) {
		this.userA4packages = userA4packages;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getRestNum() {
		return restNum;
	}

	public void setRestNum(Integer restNum) {
		this.restNum = restNum;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
 
}