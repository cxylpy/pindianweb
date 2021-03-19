package com.pindian.lonphy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.A4package;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.A4packageService;

public class A4packageAction extends ActionSupport implements ModelDriven<A4package>{
	private A4package a4package;
	private A4packageService a4packageService = BaseFactory.getInstance(A4packageService.class);
	private File image;
	private String imageFileName;
	@Override
	public A4package getModel() {
		if(a4package==null)
			a4package = new A4package();
		return a4package;
	}

	public String addA4package() {
		a4package.setImgPath(uploadImage());
		a4package.setRestNum(a4package.getNum());
		a4package.setIsShow(0);
		a4packageService.addA4package(a4package);
		return SUCCESS;
	}
	
	public String showAllA4package() {
		List<A4package> packages = a4packageService.getAllOrderByTime();
		ServletActionContext.getRequest().setAttribute("a4packages", packages);
		return SUCCESS;
	}
	
	public String modifyA4packageView() {
		A4package a4= a4packageService.findById(a4package);
		ServletActionContext.getRequest().setAttribute("a4package", a4);
		return SUCCESS;
	}
	
	public String modifyA4package() {
		if(image==null) {
			
		} else {
			a4package.setImgPath(uploadImage());
		}
		a4packageService.update(a4package);
		return SUCCESS;
	}
	
	public String showThisPackage() {
		a4packageService.setState(a4package.getId(),1);
		return SUCCESS;
	}
	public String hideThisPackage() {
		a4packageService.setState(a4package.getId(),0);
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
