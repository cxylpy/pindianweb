package com.pindian.lonphy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Ordergroup;

public class OrdersDao  extends OriginDao{
	public List<Ordergroup> getUserOrders(String id, String type, int page) {
		int term = 10;
		begin();
		Query query = null;
		if(Integer.parseInt(type)==5) {
			query = session.createQuery("from Ordergroup where uid = ? order by generatetime desc");
			query.setString(0, id);
		}else {
			query = session.createQuery("from Ordergroup where uid = ? and payStatus = ? order by generatetime desc");
			query.setString(0, id);
			query.setString(1, type);
			
		}
		query.setFirstResult((page-1)*term);
		query.setMaxResults(10);
		List<Ordergroup> orders = query.list();
		commit();
		return orders;
	}
	public List<Ordergroup> getManagerAllOrders(int page, String queryString) {
		int term = 10;
		begin();
		Query query = session.createQuery("from Ordergroup "+queryString+" order by generatetime desc");
		query.setFirstResult((page-1)*term);
		query.setMaxResults(10);
		List<Ordergroup> orders = query.list();
		commit();
		return orders;
	}
	public int getMaxPage(String queryString) {
		begin();
		Query query = session.createQuery("select count(id) from Ordergroup "+queryString);
		Integer maxPage = ((Long) query.uniqueResult()).intValue();
		maxPage = maxPage /10 +1;
		commit();
		return maxPage;
	}
	public Ordergroup findOrderById(String id) {
		begin();
		Ordergroup order = (Ordergroup) session.get(Ordergroup.class, id);
		commit();
		return order;
	}
	public void setOrderStatus(String id, int status) {
		begin();
		
		Ordergroup order = (Ordergroup) session.get(Ordergroup.class, id);
		order.setPayStatus(status);
		session.update(order);
		commit();
	}
	public void setTbid(String out_trade_no, String trade_no) {
		begin();
		Ordergroup order = (Ordergroup) session.get(Ordergroup.class, out_trade_no);
		order.setTbid(trade_no);
		session.update(order);
		commit();
	}
	public Ordergroup getLatestUserOrder(String id) {
		begin();
		Query query = session.createQuery("from Ordergroup where uid = ? order by generatetime desc");
		query.setString(0, id);
		List list = query.list();
		commit();
		return (Ordergroup) list.get(0);
	}
}
