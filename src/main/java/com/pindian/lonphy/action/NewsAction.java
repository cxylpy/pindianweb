package com.pindian.lonphy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.News;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.NewsService;

public class NewsAction extends ActionSupport implements ModelDriven<News>{
	private News news;
	private String contentimages;
	private NewsService nService = BaseFactory.getInstance(NewsService.class);
	@Override
	public News getModel() {
		if(news==null) 
			news = new News();
		return news;
	}
	
	
	public String getSumNews() {
		List<News> newslist = nService.manageNews();
		ServletActionContext.getRequest().setAttribute("news", newslist);
		return SUCCESS;
	}
	
	public String addNews() {
		nService.addNews(news,contentimages);
		return SUCCESS;
	}
	
	public String getDetail() {
		News n = nService.findById(news.getId());
		ServletActionContext.getRequest().setAttribute("news", n);
		return SUCCESS;
	}
	
	public String manageNews() {
		List<News> ns = nService.manageNews();
		ServletActionContext.getRequest().setAttribute("news", ns);
		return SUCCESS;
	}


	public String getContentimages() {
		return contentimages;
	}


	public void setContentimages(String contentimages) {
		this.contentimages = contentimages;
	}
	
	public String updateNews() {
		nService.updateNews(news,contentimages);
		return SUCCESS;
	}
	
	public String modifyNewsView() {
		News n = nService.findById(news.getId());
		ServletActionContext.getRequest().setAttribute("news", n);
		return SUCCESS;
	}
	
	public String deleteNews() {
		nService.deleteById(news.getId());
		return SUCCESS;
	}
	
}
