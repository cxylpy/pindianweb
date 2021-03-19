package com.pindian.lonphy.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Privileges;
import com.pindian.lonphy.domain.Role;

public class RoleDao  extends OriginDao{
	public List<Role> getAllRoles() {
		begin();
		List list = session.createQuery("from Role").list();
		commit();
		return list;
	}
	public void addRole(Role r, String privileges) {
		begin();
		Set<Privileges> ps = new HashSet<Privileges>();
		String[] ids = privileges.split(",");
		for (String id : ids) {
			ps.add((Privileges) session.get(Privileges.class, Integer.parseInt(id.trim())));
		}
		r.setPrivileges(ps);
		session.save(r);
		commit();
	}
	
	public Role findById(Integer id) {
		begin();
		Role r = (Role) session.get(Role.class, id);
		commit();
		return r;
	}
	public void updateRole(Integer id, String name, String description, String privileges) {
		begin();
		Role r = (Role) session.get(Role.class, id);
		Set<Privileges> ps = new HashSet<Privileges>();
		String[] ids = privileges.split(",");
		for (String pid : ids) {
			ps.add((Privileges) session.get(Privileges.class, Integer.parseInt(pid.trim())));
		}
		r.getPrivileges().clear();
		r.setPrivileges(ps);
		r.setName(name);
		r.setDescription(description);
		session.update(r);
		commit();
	}
	public void deleteById(Integer id) {
		begin();
		Role r = (Role) session.get(Role.class, id);
		session.delete(r);
		commit();
	}
}
