package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Bonus;
import com.pindian.lonphy.domain.Ordergroup;
import com.pindian.lonphy.domain.User;

public class UserBonusDao  extends OriginDao{
	public void addBonusRecord(String uid, String oid, int delta) {
		begin();
		User user = (User) session.get(User.class, uid);
		user.setUsableBonus(user.getUsableBonus()+delta);
		user.setTotalBonus(user.getTotalBonus()+Math.abs(delta));
		Bonus b = new Bonus(user,oid,delta);
		session.save(b);
		commit();
	}
	public int getMaxPage(String id) {
		begin();
		Query query = session.createQuery("select count(id) from Bonus where uid = ?");
		query.setString(0, id);
		Integer maxPage = ((Long) query.uniqueResult()).intValue();
		maxPage = maxPage /10 +1;
		commit();
		return maxPage;
	}
	public List<Bonus> getUserBonuses(int page, String id) {
		int term = 10;
		begin();
		Query query = session.createQuery("from Bonus where uid = ? order by createTime desc");
		query.setString(0, id);
		query.setFirstResult((page-1)*term);
		query.setMaxResults(10);
		List<Bonus> bonuese = query.list();
		commit();
		return bonuese;
	}
	
	
}
