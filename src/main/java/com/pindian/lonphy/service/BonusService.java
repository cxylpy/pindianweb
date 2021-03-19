package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.UserBonusDao;
import com.pindian.lonphy.domain.Bonus;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class BonusService implements Service{
	private UserBonusDao ubDao = BaseFactory.getInstance(UserBonusDao.class);
	public void addBonusRecord(String uid, String oid, int delta) {
		ubDao.addBonusRecord(uid,oid,delta);
	}
	public int getMaxPage(User user) {
		return ubDao.getMaxPage(user.getId());
	}
	public List<Bonus> getUserBonuses(int page, User user) {
		return ubDao.getUserBonuses(page,user.getId());
	}
}
