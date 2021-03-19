package com.pindian.lonphy.service;

import com.pindian.lonphy.dao.FilesDao;
import com.pindian.lonphy.domain.Files;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class FilesService implements Service{
	private FilesDao fDao = BaseFactory.getInstance(FilesDao.class);

	public void saveNewEntity(Files files) {
		fDao.saveNewEntity(files);
	}
}
