package com.pindian.lonphy.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.A4package;
import com.pindian.lonphy.domain.Bonus;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.domain.Ordergroup;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserA4package;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.domain.sms.SmsResponse;
import com.pindian.lonphy.domain.sms.SmsTemplate;
import com.pindian.lonphy.domain.sms.TemplateSms;
import com.pindian.lonphy.exception.LoginException;
import com.pindian.lonphy.exception.RegisterException;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.A4packageService;
import com.pindian.lonphy.service.BonusService;
import com.pindian.lonphy.service.BriberyService;
import com.pindian.lonphy.service.OrdersService;
import com.pindian.lonphy.service.UserA4packageService;
import com.pindian.lonphy.service.UserBriberyService;
import com.pindian.lonphy.service.UserService;
import com.pindian.lonphy.util.MD5Util;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user;
	private String phone;
	private String userid;
	private int page;
	private UserService uService = BaseFactory.getInstance(UserService.class);
	private UserBriberyService ubService = BaseFactory
			.getInstance(UserBriberyService.class);
	private UserA4packageService uaService = BaseFactory
			.getInstance(UserA4packageService.class);
	private BriberyService bService = BaseFactory
			.getInstance(BriberyService.class);
	private A4packageService a4packageService = BaseFactory
			.getInstance(A4packageService.class);
	private OrdersService oService = BaseFactory
			.getInstance(OrdersService.class);

	public User getModel() {
		user = new User();
		return user;
	}

	public String hasRegister() {
		User u = uService.hasRegister(phone);
		if (u == null) {
			ServletActionContext.getRequest().setAttribute("result", "ok");
		} else {
			ServletActionContext.getRequest().setAttribute("result", "notok");
		}
		return SUCCESS;
	}

	public String register() {
		user.setMobile(phone);
		try {
			uService.register(user);
		} catch (RegisterException e) {
			ServletActionContext.getRequest().setAttribute("register_message",
					e.getMessage());
			user.setPassword(null);
			return ERROR;
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("user", user);
		Cookie c = new Cookie("pindianppautologin",user.getId()+","+user.getPassword());
		c.setDomain("www.pindianpp.com");
		c.setPath(ServletActionContext.getRequest().getContextPath());
		c.setMaxAge(7*60*60*24);
		ServletActionContext.getResponse().addCookie(c);
		return SUCCESS;
	}

	public String login() {
		try {
			User u = uService.login(user);
			if (u != null) {
				u.calcBirthday();
				ServletActionContext.getRequest().getSession()
						.setAttribute("user", u);
				Cookie c = new Cookie("pindianppautologin",u.getId()+","+u.getPassword());
				c.setDomain("www.pindianpp.com");
				c.setPath(ServletActionContext.getRequest().getContextPath());
				c.setMaxAge(7*60*60*24);
				ServletActionContext.getResponse().addCookie(c);
				return SUCCESS;
			} else {
				ServletActionContext.getRequest().setAttribute("login_message",
						"密码不正确");
				return ERROR;
			}
		} catch (LoginException e) {
			ServletActionContext.getRequest().setAttribute("login_message",
					e.getMessage());
			return ERROR;
		}
	}

	public String logout() {
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Cookie c = new Cookie("pindianppautologin",u.getId()+","+u.getPassword());
		c.setDomain("www.pindianpp.com");
		c.setPath(ServletActionContext.getRequest().getContextPath());
		c.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(c);
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}

	public String getSmsValidation() {
		String accountSid = "5115d7780cca59b64d7329ec493dab61";
		String token = "60a752e184a34146f70afe1cf0524a04";
		String appId = "54f05ae721f64d5d865e7de9446eb987";
		String templateId = "11115";
		String to = phone;
		String para = ",1";
		String number = "";
		for (int i = 0; i < 4; i++) {
			number += new Random().nextInt(10);
		}
		para = number + para;
		if (sendTemplateSms(accountSid, token, appId, templateId, to, para)) {
			ServletActionContext.getRequest().setAttribute("result", number);
			return SUCCESS;
		} else {
			ServletActionContext.getRequest().setAttribute("result", "error");
			return ERROR;
		}
	}

	public String getValidation() {
		String accountSid = "5115d7780cca59b64d7329ec493dab61";
		String token = "60a752e184a34146f70afe1cf0524a04";
		String appId = "aa199be31e634bf79b6c18906db7e2a4";
		String templateId = "8146";
		String to = phone;
		String para = ",1";
		String number = "";
		for (int i = 0; i < 4; i++) {
			number += new Random().nextInt(10);
		}
		para = number + para;
		if (sendTemplateSms(accountSid, token, appId, templateId, to, para)) {
			ServletActionContext.getRequest().setAttribute("result", number);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	private boolean sendTemplateSms(String accountSid, String token,
			String appId, String templateId, String to, String para) {
		// https://api.ucpaas.com/2014-06-30/Accounts/5115d7780cca59b64d7329ec493dab61/Messages/templateSMS?sig=EE06867B28DA6E780293330470F6554A
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String timestamp = formatter.format(new Date());
			String signature = MD5Util.md5(accountSid + token + timestamp)
					.toUpperCase();
			DefaultHttpClient client = new DefaultHttpClient();
			StringBuffer uri = new StringBuffer(
					"https://api.ucpaas.com/2014-06-30/Accounts/");
			uri.append(accountSid).append("/Messages/templateSMS?sig=")
					.append(signature);
			HttpPost httppost = new HttpPost(uri.toString());
			httppost.setHeader("Accept", "application/json");
			httppost.setHeader("Content-Type", "application/json;charset=utf-8");
			String src = accountSid + ":" + timestamp;
			String auth = new BASE64Encoder().encode(src.getBytes("UTF-8"));
			httppost.setHeader("Authorization", auth);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			SmsTemplate template = new SmsTemplate(new TemplateSms(appId, para,
					templateId, to));
			String body = new Gson().toJson(template);
			requestBody.setContent(new ByteArrayInputStream(body
					.getBytes("UTF-8")));
			requestBody.setContentLength(body.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = client.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				SmsResponse smsResponse = new Gson()
						.fromJson(new InputStreamReader(response.getEntity()
								.getContent()), SmsResponse.class);
				if (smsResponse.getResp().getRespCode().equals("000000")) {
					return true;
				}
			} else {
				return false;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public String saveUserInfo() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if (u == null)
			return ERROR;
		try {
			u.setBirthday(DateUtils.parseDate(
					user.getYear() + "-" + user.getMonth() + "-"
							+ user.getDay(), "yyyy-MM-dd"));
			u.setNickname(user.getNickname());
			u.setDistrictNum(user.getDistrictNum());
			u.setTelephone(user.getTelephone());
			u.setSex(user.getSex());
			u.setEmail(user.getEmail());
			u.setSchool(user.getSchool());
		} catch (ParseException e) {
			return ERROR;
		}
		uService.updateInfo(u);
		u.calcBirthday();
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("user", u);
		return SUCCESS;
	}

	public String getBounsHistory() {
		BonusService bService = new BonusService();
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		List<Bonus> bonuses = bService.getUserBonuses(page, user);
		int maxPage = bService.getMaxPage(user);
		List<Ordergroup> groups = new ArrayList<Ordergroup>();
		for (Bonus bonus : bonuses) {
			List<Ordergroup> orderGroups = oService.findByCondition(
					Ordergroup.class, "id = '" + bonus.getOid() + "'");
			// List<Ordergroup> orderGroups = new BaseDao<Ordergroup>()
			// .findByCondition(Ordergroup.class,
			// "id = '" + bonus.getOid() + "'");
			groups.add(orderGroups.get(0));
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bonuses", bonuses);
		request.setAttribute("ordergroups", groups);
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		return SUCCESS;
	}

	public String getSomeUserBounsHistory() {
		BonusService bService = new BonusService();
		User user = uService.findUserById(userid);
		List<Bonus> bonuses = bService.getUserBonuses(page, user);
		int maxPage = bService.getMaxPage(user);
		List<Ordergroup> groups = new ArrayList<Ordergroup>();
		for (Bonus bonus : bonuses) {

			List<Ordergroup> orderGroups = oService.findByCondition(
					Ordergroup.class, "id = '" + bonus.getOid() + "'");
			groups.add(orderGroups.get(0));
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bonuses", bonuses);
		request.setAttribute("ordergroups", groups);
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		return SUCCESS;
	}

	public String manageUsers() {
		List<User> users = uService.getUsersByPage(page);
		int maxPage = uService.getMaxPage();
		for (User user : users) {
			int num = 0;
			List<UserBribery> list1 = ubService.getUsableBriberymoney(user
					.getId());
			if (list1 != null) {
				num += list1.size();
			}
			List<UserA4package> list2 = uaService.getUsableA4packages(user
					.getId());
			if (list2 != null) {
				num += list2.size();
			}
			user.setBriberyNum(num);
		}
		ServletActionContext.getRequest().setAttribute("users", users);
		ServletActionContext.getRequest().setAttribute("maxPage", maxPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return SUCCESS;
	}

	public String getBriberys() {
		user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		List<UserA4package> a4packages = uaService.getUsableA4packages(user
				.getId());
		List<UserBribery> briberys = ubService.getUsableBriberymoney(user
				.getId());
		ServletActionContext.getRequest().setAttribute("packages", a4packages);
		ServletActionContext.getRequest().setAttribute("briberys", briberys);
		return SUCCESS;
	}

	public String manageUserBriberys() {
		List<UserA4package> a4packages = uaService.getUsableA4packages(user
				.getId());
		List<UserBribery> briberys = ubService.getUsableBriberymoney(user
				.getId());
		ServletActionContext.getRequest().setAttribute("packages", a4packages);
		ServletActionContext.getRequest().setAttribute("briberys", briberys);
		return SUCCESS;
	}

	public String getUserDetail() {
		User u = uService.findUserById(user.getId());
		ServletActionContext.getRequest().setAttribute("manageuser", u);
		return SUCCESS;
	}

	public String getBriberyView() {
		Briberymoney briberymoney = bService.findById(user.getId());
		ServletActionContext.getRequest().setAttribute("gift", briberymoney);
		return SUCCESS;
	}

	public String getA4View() {
		A4package a4package = a4packageService.findById(user.getId());
		ServletActionContext.getRequest().setAttribute("gift", a4package);
		return SUCCESS;
	}

	public String getBriberyGift() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if (ubService.hasGet(user.getId(), u.getId())) {
			ServletActionContext.getRequest().setAttribute("msg", "领取失败，您已经领取过该红包了");
			return "fail";
		} else if(!bService.hasLeft(user.getId())){
			ServletActionContext.getRequest().setAttribute("msg", "领取失败，该红包已经领完了");
			return "fail";
		}else {
			ubService.getBribery(user.getId(), u.getId());
			Briberymoney b = bService.findById(user.getId());
			ServletActionContext.getRequest().setAttribute("b", b);
			return SUCCESS;
		}
	}

	public String getA4Gift() {
		User u = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if (uaService.hasGet(user.getId(), u.getId())) {
			ServletActionContext.getRequest().setAttribute("msg", "领取失败，您已经领取过该礼包了");
			return "fail";
		} else if(!a4packageService.hasLeft(user.getId())) {
			ServletActionContext.getRequest().setAttribute("msg", "领取失败，该礼包已经领完了");
			return "fail";
		}else {
			uaService.getPackage(user.getId(), u.getId());
			A4package a4 = a4packageService.findById(user.getId());
			ServletActionContext.getRequest().setAttribute("a4", a4);
			return SUCCESS;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
