package com.pindian.lonphy.domain;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private String id;
//	private Paytype paytype;
	private Integer largeType;
	private Float price;
	private String description;
	private Float onsalePrice;
	private String action;
	private String name;
	private String imgPath;
	private Integer saling;
	private Timestamp salingtime;
	private Integer weight;
	private Integer totalsale;
	private Integer monthsale;
	
	private Set<Producttech> techs;
	private Set<Images> images; 
	// Constructors
	{
		this.saling = 0;
		this.weight = 0;
		this.totalsale = 0;
		this.monthsale = 0;
	}
	/** default constructor */
	public Product() {
	}

	public Product(String id) {
		super();
		this.id = id;
	}

	/** full constructor */
	public Product(Integer largeType,
			 Float price, String description,
			Float onsalePrice, String action, String name, String imgPath) {
//		this.paytype = paytype;
		this.largeType = largeType;
		this.price = price;
		this.description = description;
		this.onsalePrice = onsalePrice;
		this.action = action;
		this.name = name;
		this.imgPath = imgPath;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Paytype getPaytype() {
//		return this.paytype;
//	}
//
//	public void setPaytype(Paytype paytype) {
//		this.paytype = paytype;
//	}

	public Integer getLargeType() {
		return this.largeType;
	}

	public void setLargeType(Integer largeType) {
		this.largeType = largeType;
	}


	public Integer getTotalsale() {
		return totalsale;
	}

	public void setTotalsale(Integer totalsale) {
		this.totalsale = totalsale;
	}

	public Integer getMonthsale() {
		return monthsale;
	}

	public void setMonthsale(Integer monthsale) {
		this.monthsale = monthsale;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Float getOnsalePrice() {
		return onsalePrice;
	}

	public void setOnsalePrice(Float onsalePrice) {
		this.onsalePrice = onsalePrice;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Set<Producttech> getTechs() {
		return techs;
	}

	public void setTechs(Set<Producttech> techs) {
		this.techs = techs;
	}


	public Timestamp getSalingtime() {
		return salingtime;
	}

	public void setSalingtime(Timestamp salingtime) {
		this.salingtime = salingtime;
	}


	
	public Integer getSaling() {
		return saling;
	}

	public void setSaling(Integer saling) {
		this.saling = saling;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [id=" + id  + ", largeType="
				+ largeType  + ", price=" + price
				+ ", description=" + description + ", onsalePrice="
				+ onsalePrice + ", action=" + action + ", name=" + name
				+ ", imgPath=" + imgPath + ", techs=" + techs + "]";
	}

	public Set<Images> getImages() {
		return images;
	}

	public void setImages(Set<Images> images) {
		this.images = images;
	}
	

}