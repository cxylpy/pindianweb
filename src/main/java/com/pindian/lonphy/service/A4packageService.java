package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.A4packageDao;
import com.pindian.lonphy.domain.A4package;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class A4packageService implements Service{
	private A4packageDao a4packageDao = BaseFactory.getInstance(A4packageDao.class);
	public void addA4package(A4package a4package) {
		a4packageDao.saveNewEntity(a4package);
	}
	public List<A4package> getAllOrderByTime() {
		return a4packageDao.findByCondition(A4package.class, " 1=1 order by createTime desc");
	}
	public A4package findById(String str) {
		return a4packageDao.findById(A4package.class, str);
	}
	public void update(A4package a4package) {
		a4packageDao.update(A4package.class, a4package.getId(), a4package);
	}
	public void setState(String id, int state) {
		a4packageDao.setState(id,state);
	}
	public List<A4package> getOnShelfA4packages() {
		return a4packageDao.getOnShelfA4packages();
	}
	public A4package findById(A4package a4package) {
		return a4packageDao.findById(A4package.class, a4package.getId());
	}
	public boolean hasLeft(String id) {
		return a4packageDao.hasLeft(id);
	}
}
