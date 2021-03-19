package com.pindian.lonphy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.domain.UserBriberyId;

public class UserBriberyDao extends OriginDao {
	public void add(String userid, String briberyid) {
		begin();
		
		User u = (User) session.get(User.class, userid);
		Briberymoney b = (Briberymoney) session.get(Briberymoney.class, briberyid);
		b.setRestNum(b.getRestNum()-1);
		UserBribery ub = new UserBribery();
		ub.setId(new UserBriberyId(u, b));
		ub.setUsed(0);
		session.save(ub);
		
		commit();
	}
	public void setUsed(UserBribery bribery) {
		begin();
		UserBribery userBribery = (UserBribery) session.createQuery("from UserBribery where uid = '"+bribery.getId().getUser().getId()+"' and bid = '"+bribery.getId().getBriberymoney().getId()+"'").list().get(0);
		userBribery.setUsed(1);
		session.update(userBribery);
		commit();
	}
	public List<UserBribery> getUsableBriberymoney(String id) {
		begin();
		Query query = session.createQuery("from UserBribery where uid = ?");
		query.setString(0, id);
		List<UserBribery> list = query.list();
		List<UserBribery> usableBribery = new ArrayList<UserBribery>();
		for (UserBribery userBribery : list) {
			if(userBribery.getId().getBriberymoney().getValidDate().getTime()<new Date().getTime())continue;
			usableBribery.add(userBribery);
		}
		commit();
		return usableBribery;
	}
	public boolean hasGet(String briberyId, String userid) {
		begin();
		Query query = session.createQuery("from UserBribery where uid= ? and bid = ?");
		query.setString(0, userid);
		query.setString(1, briberyId);
		UserBribery ub = (UserBribery) query.uniqueResult();
		Briberymoney b = (Briberymoney) session.get(Briberymoney.class, briberyId);
		if(b.getRestNum()<1) return true;
		commit();
		return ub != null;
	}
	
	
}
