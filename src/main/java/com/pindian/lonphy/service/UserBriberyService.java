package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.BriberyDao;
import com.pindian.lonphy.dao.UserBriberyDao;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class UserBriberyService implements Service{
	private UserBriberyDao ubDao = BaseFactory.getInstance(UserBriberyDao.class);
	public void setUsed(UserBribery bribery) {
		ubDao.setUsed(bribery);
	}
	public List<UserBribery> getUsableBriberymoney(String id) {
		return ubDao.getUsableBriberymoney(id);
	}
	public boolean hasGet(String briberyId, String userid) {
		return ubDao.hasGet(briberyId,userid);
	}
	public void getBribery(String briberyId, String userid) {
		ubDao.add(userid, briberyId);
	}
	public List<UserBribery> findByCondition(Class<UserBribery> clazz,
			String condition) {
		return ubDao.findByCondition(clazz, condition);
	}
}
