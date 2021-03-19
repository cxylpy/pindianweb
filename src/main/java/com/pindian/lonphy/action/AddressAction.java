package com.pindian.lonphy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.Address;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.AddressService;
import com.pindian.lonphy.service.UserService;

public class AddressAction extends ActionSupport implements ModelDriven<Address>{
	private Address address;
	private AddressService aService = BaseFactory.getInstance(AddressService.class);
	private UserService uService = BaseFactory.getInstance(UserService.class);
	@Override
	public Address getModel() {
		if(address==null)
			address = new Address();
		return address;
	}
	public String newAddressView() {
		ServletActionContext.getRequest().setAttribute("uid", address.getUid());
		return SUCCESS;
	}
	
	public String modifyAddressView() {
		Address a = aService.findAddressById(address.getId());
		ServletActionContext.getRequest().setAttribute("address", a);
		ServletActionContext.getRequest().setAttribute("uid", address.getUid());
		return SUCCESS;
	}

	public String getAll() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<Address> addresses = aService.findUserAddresses(user.getId());
		ServletActionContext.getRequest().getSession().setAttribute("addresses", addresses);
		return SUCCESS;
	}

	public String add() {
		aService.add(address);
		User u = uService.findUserById(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("user", u);
		String url = (String) ServletActionContext.getRequest().getSession().getAttribute("url");
		if(url!=null) {
			ServletActionContext.getRequest().getSession().removeAttribute("url");
			ServletActionContext.getRequest().setAttribute("url", url);
			return "middleperson";
		}
		return SUCCESS;
	}
	
	public String modify() {
		aService.update(address);
		User u = uService.findUserById(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("user", u);
		return SUCCESS;
	}
	
	public String delete() {
		aService.delete(address);
		User u = uService.findUserById(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("user", u);
		return SUCCESS;
	}
}
