package com.pindian.lonphy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pindian.lonphy.dao.UserA4packageDao;
import com.pindian.lonphy.domain.UserA4package;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class UserA4packageService implements Service{
	private UserA4packageDao uaDao = BaseFactory.getInstance(UserA4packageDao.class);

	public List<UserA4package> getUsableA4packages(String id) {
		List<UserA4package> a4packages = uaDao.getUsableA4packages(id);
		List<UserA4package> usableA4packages = new ArrayList<UserA4package>();
		for (UserA4package userA4package : a4packages) {
			if(userA4package.getRestPage()<=0) continue;
			if(userA4package.getId().getA4package().getValidDate().getTime()<new Date().getTime()) continue;
			usableA4packages.add(userA4package);
		}
		return usableA4packages;
	}

	public void use(int a4pages, String id, String packageid) {
		uaDao.use(a4pages,id,packageid);
	}

	public boolean hasGet(String packageid, String userid) {
		return uaDao.hasGet(packageid,userid);
	}

	public void getPackage(String packageid, String userid) {
		uaDao.add(userid, packageid);
	}
}
