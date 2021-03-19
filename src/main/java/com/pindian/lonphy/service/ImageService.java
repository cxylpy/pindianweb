package com.pindian.lonphy.service;

import com.pindian.lonphy.dao.ImageDao;
import com.pindian.lonphy.domain.Images;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class ImageService implements Service{
	private ImageDao iDao = BaseFactory.getInstance(ImageDao.class);

	public void saveNewEntity(Images images) {
		iDao.saveNewEntity(images);
	}
	
}
