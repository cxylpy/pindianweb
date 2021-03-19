package com.pindian.lonphy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.BriberyService;

public class BriberyMoneyAction extends ActionSupport implements ModelDriven<Briberymoney>{
	private Briberymoney bribery;
	private BriberyService bService = BaseFactory.getInstance(BriberyService.class);
	private File image;
	private String imageFileName;
	@Override
	public Briberymoney getModel() {
		if(bribery==null)
			bribery = new Briberymoney();
		return bribery;
	}
	
	public String addBribery() {
		bribery.setIsShow(0);
		bribery.setImgPath(uploadImage());
		bribery.setRestNum(bribery.getNum());
		bService.addBribery(bribery);
		return SUCCESS;
	}
	public String uploadImage() {
		String fileName = UUID.randomUUID().toString() + "_" + imageFileName;
		String hexString = Integer.toHexString(fileName.hashCode());
		char[] dirs = hexString.toCharArray();
		StringBuffer dirPath = new StringBuffer(ServletActionContext
				.getServletContext().getRealPath("/WEB-INF/upload/images"));
		StringBuffer urlPath = new StringBuffer();
		for (char c : dirs) {
			urlPath.append("/").append(c);
		}
		urlPath.append("/").append(fileName);
		dirPath.append(urlPath.toString());
		try {
			FileUtils.copyFile(image, new File(dirPath.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlPath.toString();
	}
	public String showAll() {
		List<Briberymoney> briberys = bService.findAllOrderByTime();
		ServletActionContext.getRequest().setAttribute("briberys", briberys);
		return SUCCESS;
	}
	
	public String modifyBriberyView() {
		Briberymoney b = bService.findById(bribery);
		ServletActionContext.getRequest().setAttribute("bribery", b);
		return SUCCESS;
	}
	
	public String modifyBribery() {
		if(image==null) {
			
		} else {
			bribery.setImgPath(uploadImage());
		}
		bService.update(bribery);
		return SUCCESS;
	}
	public String showThisBribery() {
		bService.setState(bribery.getId(),1);
		return SUCCESS;
	}
	public String hideThisBribery() {
		bService.setState(bribery.getId(),0);
		return SUCCESS;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
