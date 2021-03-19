package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Query;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.A4package;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserA4package;
import com.pindian.lonphy.domain.UserA4packageId;

public class UserA4packageDao  extends OriginDao{
	public List<UserA4package> getUsableA4packages(String id) {
		return findByCondition(UserA4package.class, " uid = '"+id+"'");
	}
	public void add(String uid, String a4id) {
		begin();
		User user = (User) session.get(User.class, uid);
		A4package a4 = (A4package) session.get(A4package.class, a4id);
		a4.setRestNum(a4.getRestNum()-1);
		UserA4package userA4package =new UserA4package(new UserA4packageId(user, a4), a4.getPages());
		session.save(userA4package);
		commit();
	}
	public void use(int a4pages, String id, String packageid) {
		begin();
		Query query = session.createQuery("from UserA4package where uid = ? and pid = ?");
		query.setString(0, id);
		query.setString(1, packageid);
		UserA4package ua = (UserA4package) query.uniqueResult();
		ua.setRestPage(ua.getRestPage()-a4pages);
		session.update(ua);
		commit();
	}
	public boolean hasGet(String packageid, String userid) {
		begin();
		Query query = session.createQuery("from UserA4package where uid = ? and pid = ?");
		query.setString(0, userid);
		query.setString(1, packageid);
		UserA4package a4 = (UserA4package) query.uniqueResult();
		A4package a = (A4package) session.get(A4package.class, packageid);
		if(a.getRestNum()<1) return true;
		commit();
		return a4!=null;
	}
}
