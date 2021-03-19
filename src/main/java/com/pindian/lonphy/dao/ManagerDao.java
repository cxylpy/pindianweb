package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Manager;
import com.pindian.lonphy.domain.Role;

public class ManagerDao  extends OriginDao{
	public void addManager(Manager manager, String rid) {
		begin();
		Role r = (Role) session.get(Role.class, Integer.parseInt(rid.trim()));
		manager.setRole(r);
		session.save(manager);
		commit();
	}
	public List<Manager> getAllManagers() {
		begin();
		List list = session.createQuery("from Manager").list();
		commit();
		return list;
	}
	public Manager findById(Integer id) {
		begin();
		Manager m = (Manager) session.get(Manager.class, id);
		commit();
		return m;
	}
	public void modifyManager(Manager manager, String rid) {
		begin();
		Role r = (Role) session.get(Role.class, Integer.parseInt(rid.trim()));
		Manager m = (Manager) session.get(Manager.class, manager.getId());
		m.setRole(r);
		m.setUsername(manager.getUsername());
		session.update(m);
		commit();		
	}
	public void deleteManager(Integer id) {
		begin();
		Manager m = (Manager) session.get(Manager.class, id);
		session.delete(m);
		commit();
	}
	
}
