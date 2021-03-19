package com.pindian.lonphy.service;

import java.util.List;

import com.pindian.lonphy.dao.NewsDao;
import com.pindian.lonphy.domain.News;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.base.Service;

public class NewsService implements Service{
	private NewsDao nDao = BaseFactory.getInstance(NewsDao.class);

	public void addNews(News news, String images) {
		nDao.addNews(news,images);
	}

	public List<News> manageNews() {
		return nDao.manageNews();
	}

	public void updateNews(News news, String contentimages) {
		nDao.updateNews(news,contentimages);
	}

	public News findById(Integer id) {
		return nDao.findById(id);
	}

	public void deleteById(Integer id) {
		nDao.deleteById(id);
	}
}
