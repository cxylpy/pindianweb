package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.ManagerDao;
import com.pindian.lonphy.domain.Manager;
import com.pindian.lonphy.exception.LoginException;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;
import com.pindian.lonphy.util.MD5Util;

public class ManagerService implements Service{
	private ManagerDao managerDao = BaseFactory.getInstance(ManagerDao.class);
	public Manager login(Manager m) throws LoginException{
		List<Manager> managers = managerDao.findByCondition(Manager.class, " username='"+m.getUsername()+"'");
		if(managers!=null&&managers.size()>0) {
			List<Manager> ms = managerDao.findByCondition(Manager.class, " username='"+m.getUsername()+"' and password = '"+m.getPassword()+"'");
			if(ms!=null&&ms.size()>0) {
				return ms.get(0);
			}
			throw new LoginException("密码不正确！");
		}
		throw new LoginException("没有该管理员！");
	}
	public void addManager(Manager manager, String rid) {
		manager.setPassword(MD5Util.md5(manager.getPassword()));
		managerDao.addManager(manager,rid);
	}
	public List<Manager> getAllManagers() {
		return managerDao.getAllManagers();
	}
	public Manager findById(Integer id) {
		return managerDao.findById(id);
	}
	public void modifyManager(Manager manager, String rid) {
		managerDao.modifyManager(manager,rid);
	}
	public void deleteManager(Integer id) {
		managerDao.deleteManager(id);
	}
}
