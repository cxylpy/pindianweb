package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.RoleDao;
import com.pindian.lonphy.domain.Role;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class RoleService implements Service{
	private RoleDao rDao = BaseFactory.getInstance(RoleDao.class);
	public List<Role> getAllRoles() {
		return rDao.getAllRoles();
	}
	public void addRole(Role r, String privileges) {
		rDao.addRole(r,privileges);
	}
	public Role findById(Integer id) {
		return rDao.findById(id);
	}
	public void updateRole(Integer id, String name, String description, String privileges) {
		rDao.updateRole(id,name,description,privileges);
	}
	public void deleteById(Integer id) {
		rDao.deleteById(id);
	}

}
