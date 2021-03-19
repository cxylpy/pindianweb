package com.pindian.lonphy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.Manager;
import com.pindian.lonphy.domain.Privileges;
import com.pindian.lonphy.domain.Product;
import com.pindian.lonphy.domain.Role;
import com.pindian.lonphy.exception.LoginException;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.ManagerService;
import com.pindian.lonphy.service.PrivilegeService;
import com.pindian.lonphy.service.ProductService;
import com.pindian.lonphy.service.RoleService;
import com.pindian.lonphy.util.MD5Util;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	private Manager manager;
	private String rid;
	private ManagerService mService = BaseFactory.getInstance(ManagerService.class);
	private RoleService rService = BaseFactory.getInstance(RoleService.class);
	private PrivilegeService pService = BaseFactory.getInstance(PrivilegeService.class);
	private int page;
	private String name;
	private String description;
	private String privileges;
	private Integer type;
	private ProductService productService = BaseFactory.getInstance(ProductService.class);
	@Override
	public Manager getModel() {
		if(manager==null)
		manager = new Manager();
		return manager;
	}

	public String login() {
		manager.setPassword(MD5Util.md5(manager.getPassword()));
		try {
			Manager m = mService.login(manager);
			ServletActionContext.getRequest().getSession().setAttribute("manager", m);
		} catch (LoginException e) {
			ServletActionContext.getRequest().setAttribute("login_message",e.getMessage());
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String manageAllProduct() {
		int maxPage = productService.getMaxPage();
		List<Product> products = productService.manageByLargeType(page,type);
		ServletActionContext.getRequest().setAttribute("products", products);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("maxPage", maxPage);
		ServletActionContext.getRequest().setAttribute("type", type);
		return SUCCESS;
	}
	
	public String getManagerRoles() {
		List<Role> roles = rService.getAllRoles();
		ServletActionContext.getRequest().setAttribute("roles", roles);
		return SUCCESS;
	}
	
	public String addRoleView() {
		List<Privileges> privileges = pService.getAllPrivileges();
		ServletActionContext.getRequest().setAttribute("privileges", privileges);
		return SUCCESS;
	}
	
	
	public String addRole() {
		Role r = new Role();
		r.setName(name);
		r.setDescription(description);
		rService.addRole(r,privileges);
		return SUCCESS;
	}
	
	public String modifyRoleView() {
		Role r = rService.findById(manager.getId());
		ServletActionContext.getRequest().setAttribute("r", r);
		List<Privileges> ps = pService.getAllPrivileges();
		ServletActionContext.getRequest().setAttribute("privileges", ps);
		return SUCCESS;
	}
	public String updateRole() {
		rService.updateRole(manager.getId(),name,description,privileges);
		return SUCCESS;
	}
	
	public String deleteRole() {
		rService.deleteById(manager.getId());
		return SUCCESS;
	}
	
	public String addManagerView() {
		List<Role> roles = rService.getAllRoles();
		ServletActionContext.getRequest().setAttribute("roles", roles);
		return SUCCESS;
	}
	
	public String addManager() {
		mService.addManager(manager,rid);
		return SUCCESS;
	}
	
	
	public String manageManager() {
		List<Manager> managers = mService.getAllManagers();
		ServletActionContext.getRequest().setAttribute("managers", managers);
		return SUCCESS;
	}
	
	public String modifyManagerView() {
		Manager m = mService.findById(manager.getId());
		ServletActionContext.getRequest().setAttribute("m", m);
		List<Role> roles = rService.getAllRoles();
		ServletActionContext.getRequest().setAttribute("roles", roles);
		return SUCCESS;
	}
	
	public String modifyManager() {
		mService.modifyManager(manager,rid);
		return SUCCESS;
	}
	
	public String deleteManager() {
		mService.deleteManager(manager.getId());
		return SUCCESS;
	}
	
	
	
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
	
}
