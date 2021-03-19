package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.OrdersDao;
import com.pindian.lonphy.domain.Ordergroup;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class OrdersService implements Service {
	private OrdersDao oDao = BaseFactory.getInstance(OrdersDao.class);

	public List<Ordergroup> getUserOrders(String id, String type, int page) {
		return oDao.getUserOrders(id, type, page);
	}

	public List<Ordergroup> getManagerAllOrders(String type, int page) {
		if (Integer.parseInt(type) == 5) {
			return oDao.getManagerAllOrders(page, "");
		}
		return oDao.getManagerAllOrders(page, " where payStatus = " + type);
	}

	public int getMaxPage(String queryString) {
		return oDao.getMaxPage(queryString);
	}

	public Ordergroup getOrderById(String id) {
		return oDao.findOrderById(id);
	}

	public void setOrderStatus(String id, int status) {
		oDao.setOrderStatus(id, status);
	}

	public void setTbid(String out_trade_no, String trade_no) {
		oDao.setTbid(out_trade_no, trade_no);
	}

	public Ordergroup getLatestUserOrder(String id) {
		return oDao.getLatestUserOrder(id);
	}

	public void saveNewEntity(Ordergroup ordergroup) {
		oDao.saveNewEntity(ordergroup);
	}

	public List<Ordergroup> findByCondition(Class<Ordergroup> clazz,
			String condition) {
		return oDao.findByCondition(clazz, condition);
	}

}
