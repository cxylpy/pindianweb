package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.A4package;

public class A4packageDao extends OriginDao{
	public void setState(String id, int state) {
		begin();
		A4package a4 = (A4package) session.get(A4package.class, id);
		a4.setIsShow(state);
		session.update(a4);
		commit();
	}
	public List<A4package> getOnShelfA4packages() {
		begin();
		List list = session.createQuery("from A4package where isShow = 1").list();
		commit();
		return list;
	}
	public boolean hasLeft(String id) {
		boolean hasLeft = true;
		begin();
		A4package a4package = (A4package) session.get(A4package.class, id);
		hasLeft = a4package.getRestNum() > 0;
		commit();
		return hasLeft;
	}
}
