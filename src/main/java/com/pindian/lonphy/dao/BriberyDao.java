package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Briberymoney;

public class BriberyDao extends OriginDao{
	
	public void setState(String id, int state) {
		begin();
		Briberymoney b = (Briberymoney) session.get(Briberymoney.class, id);
		b.setIsShow(state);
		session.update(b);
		commit();
	}
	public List<Briberymoney> getOnShelfBriberys() {
		begin();
		List list = session.createQuery("from Briberymoney where isShow = 1").list();
		commit();
		return list;
	}
	public boolean hasLeft(String id) {
		boolean hasLeft = true;
		begin();
		Briberymoney b = (Briberymoney) session.get(Briberymoney.class, id);
		if(b.getRestNum()>0) {
			hasLeft = true;
		} else {
			hasLeft = false;
		}
		commit();
		return hasLeft;
	}
}
