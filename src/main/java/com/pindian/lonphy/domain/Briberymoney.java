package com.pindian.lonphy.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Briberymoney entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Lonphy
 *
 */
public class Briberymoney implements java.io.Serializable {

	// Fields

	private String id;
	private Float minPrice;
	private Float price;
	private Timestamp validDate;
	private Integer num;
	private Timestamp createTime;
	private String name;
	private Integer isShow;
	private String description;
	private String imgPath;
	private Integer restNum;
	private Set userBriberies = new HashSet(0);

	// Constructors

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

	/** default constructor */
	public Briberymoney() {
	}

	/** minimal constructor */
	public Briberymoney(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/** full constructor */
	public Briberymoney(Float minPrice, Float price,
			Timestamp validDate, Integer num,
			String name) {
		this.minPrice = minPrice;
		this.price = price;
		this.validDate = validDate;
		this.num = num;
		this.name = name;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Timestamp getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Timestamp validDate) {
		this.validDate = validDate;
	}


	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	public Set getUserBriberies() {
		return this.userBriberies;
	}

	public void setUserBriberies(Set userBriberies) {
		this.userBriberies = userBriberies;
	}


}