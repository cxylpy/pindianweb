package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.PrivilegeDao;
import com.pindian.lonphy.domain.Privileges;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class PrivilegeService implements Service{
	private PrivilegeDao pDao = BaseFactory.getInstance(PrivilegeDao.class);
	public List<Privileges> getAllPrivileges() {
		return pDao.getAllPrivileges();
	}

}
