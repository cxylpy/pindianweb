package com.pindian.lonphy.service;

import com.pindian.lonphy.dao.TransportcostDao;
import com.pindian.lonphy.domain.Transportcost;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class TransportcostService implements Service{
	private TransportcostDao tDao = BaseFactory.getInstance(TransportcostDao.class);

	public Transportcost findById(String id) {
		return tDao.findById(Transportcost.class, id);
	}

	public void update(Class<Transportcost> class1, String id,
			Transportcost cost) {
		tDao.update(class1, id, cost);
	}
}
