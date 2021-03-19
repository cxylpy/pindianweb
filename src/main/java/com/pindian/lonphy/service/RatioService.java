package com.pindian.lonphy.service;

import com.pindian.lonphy.dao.RatioDao;
import com.pindian.lonphy.domain.Ratio;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class RatioService implements Service{
	private RatioDao rDao = BaseFactory.getInstance(RatioDao.class);
	public Ratio findById(int id) {
		return rDao.findById(Ratio.class, id);
	}
	public void update(Class<Ratio> clazz, int ratioid1, Ratio r1) {
		rDao.update(clazz, ratioid1, r1);
	}

}
