package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.BriberyDao;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class BriberyService implements Service{
	private BriberyDao briberyDao = BaseFactory.getInstance(BriberyDao.class);
	public void addBribery(Briberymoney bribery) {
		briberyDao.saveNewEntity(bribery);
	}
	public List<Briberymoney> findAllOrderByTime() {
		return briberyDao.findByCondition(Briberymoney.class, " 1=1 order by createTime desc");
	}
	public Briberymoney findById(String str) {
		return briberyDao.findById(Briberymoney.class, str);
	}
	public void update(Briberymoney bribery) {
		briberyDao.update(Briberymoney.class, bribery.getId(),bribery);
	}
	public List<UserBribery> findByUser(User user) {
		return briberyDao.findByCondition(UserBribery.class, "uid = '"+user.getId()+"'");
	}
	public void setState(String id, int state) {
		briberyDao.setState(id,state);
	}
	public List<Briberymoney> getOnShelfBriberys() {
		return briberyDao.getOnShelfBriberys();
	}
	public Briberymoney findById(Briberymoney bribery) {
		return briberyDao.findById(Briberymoney.class, bribery.getId());
	}
	public boolean hasLeft(String id) {
		return briberyDao.hasLeft(id);
	}

}
