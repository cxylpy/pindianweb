package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.ProductDao;
import com.pindian.lonphy.domain.Images;
import com.pindian.lonphy.domain.Product;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class ProductService implements Service{
	private ProductDao productDao = new BaseFactory().getInstance(ProductDao.class);
	public void save(Product product) {
		productDao.saveNewEntity(product);
	}

	public List<Product> showByLargeType(int type) {
		return productDao.findByCondition(Product.class, " largeType = "+type +" and saling = 1 order by weight desc");
	}

	public Product findProductById(String id) {
		return productDao.findById(Product.class, id);
	}

	public void update(Product p) {
		productDao.update(Product.class, p.getId(), p);
	}

	public void pullOff(String id) {
		productDao.setSaling(0, id);
	} 
	
	public void putOn(String id) {
		productDao.setSaling(1, id);
	}

	public void saveWeight(String id, Integer weight) {
		productDao.saveWeight(id,weight);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public List<Product> indexShowByLargeType(int type) {
		List<Product> list = productDao.findByCondition(Product.class, " largeType = "+type +" and saling = 1 order by weight");
		if(list.size()>6) {
			return list.subList(0, 6);
		}
		return list;
	}

	public void addSale(String pid, Integer number) {
		productDao.addSale(pid,number);
	}

	public List<Product> manageByLargeType(int page, Integer type) {
		return productDao.manageByLargeType(page,type);
	}

	public int getMaxPage() {
		return productDao.getMaxPage();
	}

	public void deleteProductById(String id) {
		productDao.deleteProductById(id);
	}

	public List<Images> findByCondition(Class<Images> clazz, String condition) {
		return productDao.findByCondition(clazz, condition);
	}
}
