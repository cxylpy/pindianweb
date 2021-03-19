package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Privileges;

public class PrivilegeDao extends OriginDao{
	public List<Privileges> getAllPrivileges() {
		begin();
		List list = session.createQuery("from Privileges").list();
		commit();
		return list;
	}

}
