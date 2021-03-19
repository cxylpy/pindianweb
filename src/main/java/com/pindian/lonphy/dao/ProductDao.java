package com.pindian.lonphy.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Product;

public class ProductDao  extends OriginDao{
	public void setSaling(int saling, Serializable id) {
		begin();

		Product p = (Product) session.get(Product.class, id);
		p.setSaling(saling);
		session.update(p);
		commit();
	}

	public void saveWeight(String id, Integer weight) {
		begin();
		Product p = (Product) session.get(Product.class, id);
		p.setWeight(weight);
		session.update(p);
		commit();
	}

	public void updateProduct(Product product) {
		begin();

		Product p = (Product) session.get(Product.class, product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setOnsalePrice(product.getOnsalePrice());
		p.setImgPath(product.getImgPath());
		p.setLargeType(product.getLargeType());
		// p.setPaytype(product.getPaytype());
		p.setTechs(product.getTechs());
		p.setAction(product.getAction());
		p.getImages().clear();
		session.update(p);
		commit();
		begin();
		Product pp = (Product) session.get(Product.class, product.getId());
		pp.getImages().addAll(product.getImages());

		session.update(pp);

		commit();
	}

	public void addSale(String pid, Integer number) {
		begin();
		Product p = (Product) session.get(Product.class, pid);
		p.setMonthsale(p.getMonthsale() + number);
		p.setTotalsale(p.getTotalsale() + number);
		session.update(p);
		commit();
	}

	/**
	 * @param page
	 * @param type
	 * @return
	 */
	public List<Product> manageByLargeType(int page, Integer type) {
		begin();
		Query query = null;
		if (type == 0) {
			query = session.createQuery("from Product order by salingtime desc");
		} else {
			query = session.createQuery("from Product where largeType = ? order by salingtime desc");
			query.setInteger(0, type);
		}
		query.setMaxResults(20);
		query.setFirstResult((page-1)*20);
		List list = query.list();
		commit();
		return list;
	}

	public int getMaxPage() {
		begin();
		Integer maxPage = ((Long) session.createQuery("select count(id) from Product").uniqueResult()).intValue();
		maxPage = maxPage/20 + 1;
		commit();
		return maxPage;
	}

	public void deleteProductById(String id) {
		begin();
		Product p = (Product) session.get(Product.class, id);
		session.delete(p);
		commit();
		
	}
}
