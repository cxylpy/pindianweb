package com.pindian.lonphy.dao;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.User;

public class UserDao  extends OriginDao{
	public void updateInfo(String id, User user) {
		begin();
		User u = (User) session.get(User.class, id);
		try {
			u.setBirthday(DateUtils.parseDate(user.getYear()+"-"+user.getMonth()+"-"+user.getDay(), "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		u.setNickname(user.getNickname());
		u.setDistrictNum(user.getDistrictNum());
		u.setTelephone(user.getTelephone());
		u.setSex(user.getSex());
		u.setEmail(user.getEmail());
		u.setSchool(user.getSchool());
		session.update(u);
		commit();
	}
	public List<User> getUsersByPage(int page) {
		int term = 10;
		begin();
		Query result = session.createQuery("from User");
		result.setMaxResults(term);
		result.setFirstResult((page-1)*term);
		return result.list();
	}
	
	public int getMaxPage() {
		begin();
		Integer maxPage = ((Long)session.createQuery("select count(id) from User").uniqueResult()).intValue();
		commit();
		maxPage = maxPage / 10 + 1;
		return maxPage;
		
	}
	public void addCost(String id, Float totalPrice) {
		begin();
		
		User user = (User) session.get(User.class, id);
		user.setTotalCost(user.getTotalCost()+totalPrice);
		session.update(user);
		commit();
	}
	public User findByMobile(String mobile) {
		begin();
		Query query = session.createQuery("from User where mobile = ?");
		query.setString(0, mobile);
		User u = (User) query.uniqueResult();
		commit();
		return u;
	}
	public User findByMobileAndPassword(String mobile, String password) {
		begin();
		Query query = session.createQuery("from User where mobile = ? and password = ?");
		query.setString(0, mobile);
		query.setString(1, password);
		User u = (User) query.uniqueResult();
		commit();
		return u;
	}
	public User hasRegister(String phone) {
		begin();
		Query query = session.createQuery("from User where mobile = ?");
		query.setString(0, phone);
		User u = (User) query.uniqueResult();
		commit();
		return u;
	}
	public User findUserByIdAndPassword(String id, String encriptpassword) {
		begin();
		Query query = session.createQuery("from User where id = ? and password = ?");
		query.setString(0, id);
		query.setString(1, encriptpassword);
		User u = (User) query.uniqueResult();
		commit();
		return u;
	}
	public void addBonus(String uid, int bonus) {
		begin();
		User u = (User) session.get(User.class, uid);
		u.setTotalBonus(u.getTotalBonus()+bonus);
		u.setUsableBonus(u.getUsableBonus()+bonus);
		session.update(u);
		commit();
	}

}
