package com.pindian.lonphy.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pindian.lonphy.dao.base.OriginDao;
import com.pindian.lonphy.domain.Images;
import com.pindian.lonphy.domain.News;

public class NewsDao  extends OriginDao{

	public void addNews(News news, String images) {
		begin();
		if (images != null && !images.equals("")) {
			Set<Images> imageset = new HashSet<Images>();
			String[] split = images.split(",");
			if (split != null)
				for (String str : split) {
					Query query = session
							.createQuery("from Images where urlpath = ?");
					query.setString(0, str.trim());
					Images image = (Images) query.uniqueResult();
					imageset.add(image);
				}
			news.setImages(imageset);
		}
		session.save(news);
		commit();
	}

	public List<News> manageNews() {
		begin();
		List list = session.createQuery("from News order by pubTime desc")
				.list();
		commit();
		return list;
	}

	public void updateNews(News news, String contentimages) {
		Set<Images> imageset = new HashSet<Images>();
		begin();

		String[] split = contentimages.split(",");
		for (String str : split) {
			Query query = session.createQuery("from Images where urlpath = ?");
			query.setString(0, str.trim());
			Images image = (Images) query.uniqueResult();
			imageset.add(image);
		}
		news.setImages(imageset);
		session.update(news);
		commit();
	}

	public News findById(Integer id) {
		begin();
		News n = (News) session.get(News.class, id);
		commit();
		return n;
	}

	public void deleteById(Integer id) {
		begin();
		News n = (News) session.get(News.class, id);
		session.delete(n);
		commit();
	}
}
