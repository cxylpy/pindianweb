package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.UserDao;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.exception.LoginException;
import com.pindian.lonphy.exception.RegisterException;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;
import com.pindian.lonphy.util.MD5Util;

public class UserService implements Service{
	private UserDao userDao = BaseFactory.getInstance(UserDao.class);
	public void register(User user) throws RegisterException {		
		user.setPassword(MD5Util.md5(user.getPassword()));
		User u = userDao.findByMobile(user.getMobile());
		if(u!=null)
			throw new RegisterException("该手机号已被注册");
		userDao.saveNewEntity(user);
	}
	public User login(User user) throws LoginException {
		
		User u = userDao.findByMobile(user.getMobile());
		if(u==null) {
			throw new LoginException("手机号不正确");
		}
		User user2 = userDao.findByMobileAndPassword(user.getMobile(),MD5Util.md5(user.getPassword()));//uDao.findByCondition(User.class, "mobile = '"+user.getMobile()+"' and password = '"+MD5Util.md5(user.getPassword())+"'");
		if(user2!=null)
			return user2;
		return null;
	}
	public void updateInfo(User user) {
		userDao.updateInfo(user.getId(),user);
	}
	public List<User> getUsersByPage(int page) {
		return userDao.getUsersByPage(page);
	}
	
	public int getMaxPage() {
		return userDao.getMaxPage();
	}
	public User findUserById(String userid) {
		return userDao.findById(User.class, userid);
	}
	public void addCost(String id, Float totalPrice) {
		userDao.addCost(id,totalPrice);
	}
	public User hasRegister(String phone) {
		return userDao.hasRegister(phone);
	}
	public User findUserByIdAndPassword(String id, String encriptpassword) {
		return userDao.findUserByIdAndPassword(id,encriptpassword);
	}
	public void addBonus(String uid, int bonus) {
		userDao.addBonus(uid,bonus);
	}
}
