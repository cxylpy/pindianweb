package com.pindian.lonphy.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Ordergroup entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Lonphy
 *
 */
public class Ordergroup implements java.io.Serializable {

	// Fields

	private String id;
	private String tbid;
//	private Integer payType;
	private Integer transportType;
	private Float totalPrice;
	private String description;
	private Integer payStatus;
	private Float transportCost;
	private String comment;
	private String bid;
	private Timestamp generatetime;
	private String address;
	private String receiver;
	private String mobile;
	private String imgPath;
	private String uid;
	private Integer orderType;
	private Set<Suborders> suborders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ordergroup() {
	}

	/** minimal constructor */
	public Ordergroup(String id) {
		this.id = id;
	}

	/** full constructor */
	public Ordergroup(String id, Integer transportType,
			Float totalPrice, String description, Integer payStatus,
			Float transportCost, String comment, String bid, String address,
			String receiver, String mobile,
			Set suborders) {
		this.id = id;
//		this.payType = payType;
		this.transportType = transportType;
		this.totalPrice = totalPrice;
		this.description = description;
		this.payStatus = payStatus;
		this.transportCost = transportCost;
		this.comment = comment;
		this.bid = bid;
		this.address = address;
		this.receiver = receiver;
		this.mobile = mobile;
		this.suborders = suborders;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Integer getPayType() {
//		return this.payType;
//	}
//
//	public void setPayType(Integer payType) {
//		this.payType = payType;
//	}

	public Timestamp getGeneratetime() {
		return generatetime;
	}

	public void setGeneratetime(Timestamp generatetime) {
		this.generatetime = generatetime;
	}

	public Integer getTransportType() {
		return this.transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}


	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getTbid() {
		return tbid;
	}

	public void setTbid(String tbid) {
		this.tbid = tbid;
	}

	public Float getTransportCost() {
		return this.transportCost;
	}

	public void setTransportCost(Float transportCost) {
		this.transportCost = transportCost;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAddress() {
		return this.address;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setAddress(String address) {
		this.address = address;
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



	public Set<Suborders> getSuborders() {
		return suborders;
	}

	public void setSuborders(Set<Suborders> suborders) {
		this.suborders = suborders;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}