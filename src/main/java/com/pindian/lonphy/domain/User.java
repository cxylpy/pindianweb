package com.pindian.lonphy.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import freemarker.template.utility.DateUtil;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields
	{
		totalBonus = 0;
		usableBonus = 0;
	}
	private String id;
	private String nickname;
	private String password;
	private String mobile;
	private String sex;
	private Date birthday;
	private String telephone;
	private String email;
	private String school;
	private Integer totalBonus;
	private Integer usableBonus;
	private Set addresses = new HashSet(0);
	private String year;
	private String month;
	private String day;
	private String districtNum;
	private float totalCost;
	private Set userBriberies = new HashSet(0);
	private int briberyNum;
	
	// Constructors
	
	public String getYear() {
		return year;
	}

	public int getBriberyNum() {
		return briberyNum;
	}

	public void setBriberyNum(int briberyNum) {
		this.briberyNum = briberyNum;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String nickname, String password, String mobile, String sex,
			Date birthday, String telephone, String email, String school,
			Integer totalBonus, Integer usableBonus, Set addresses) {
		this.nickname = nickname;
		this.password = password;
		this.mobile = mobile;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.email = email;
		this.school = school;
		this.totalBonus = totalBonus;
		this.usableBonus = usableBonus;
		this.addresses = addresses;
		String[] split = DateFormatUtils.format(birthday, "yyyy-MM-dd").split("-");
		year = split[0];
		month = split[1];
		day = split[2];
	}
	public void calcBirthday(){
		if(this.birthday!=null) {
		String[] split = DateFormatUtils.format(birthday, "yyyy-MM-dd").split("-");
		year = split[0];
		month = split[1];
		day = split[2];
		}
	}
	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getDistrictNum() {
		return districtNum;
	}
	
	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public void setDistrictNum(String districtNum) {
		this.districtNum = districtNum;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getTotalBonus() {
		return this.totalBonus;
	}

	public void setTotalBonus(Integer totalBonus) {
		this.totalBonus = totalBonus;
	}

	public Integer getUsableBonus() {
		return this.usableBonus;
	}

	public void setUsableBonus(Integer usableBonus) {
		this.usableBonus = usableBonus;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getUserBriberies() {
		return userBriberies;
	}


	public void setUserBriberies(Set userBriberies) {
		this.userBriberies = userBriberies;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", password="
				+ password + ", mobile=" + mobile + ", sex=" + sex
				+ ", birthday=" + birthday + ", telephone=" + telephone
				+ ", email=" + email + ", school=" + school + ", totalBonus="
				+ totalBonus + ", usableBonus=" + usableBonus + ", addresses="
				+ addresses + ", year=" + year + ", month=" + month + ", day="
				+ day + ", districtNum=" + districtNum + "]";
	}

}