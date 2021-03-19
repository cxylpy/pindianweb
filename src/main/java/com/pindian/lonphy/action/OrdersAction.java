package com.pindian.lonphy.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.config.AlipayConfig;
import com.pindian.lonphy.domain.Address;
import com.pindian.lonphy.domain.Cart;
import com.pindian.lonphy.domain.Ordergroup;
import com.pindian.lonphy.domain.Product;
import com.pindian.lonphy.domain.Ratio;
import com.pindian.lonphy.domain.Suborders;
import com.pindian.lonphy.domain.Transportcost;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.BonusService;
import com.pindian.lonphy.service.OrdersService;
import com.pindian.lonphy.service.ProductService;
import com.pindian.lonphy.service.RatioService;
import com.pindian.lonphy.service.TransportcostService;
import com.pindian.lonphy.service.UserA4packageService;
import com.pindian.lonphy.service.UserBriberyService;
import com.pindian.lonphy.util.AlipaySubmit;
import com.pindian.lonphy.util.OrderIdUtil;

public class OrdersAction extends ActionSupport implements
		ModelDriven<Ordergroup> {
	private Ordergroup ordergroup;
	private int addressindex;
	private boolean useBribery;
	private boolean useBonus;
	private boolean usePackage;
	private int bonus;
	private String packageid;
	private BonusService bonusService = BaseFactory.getInstance(BonusService.class);
	private Ratio ratio;
	private String uid;
	private String pid;
	private int page;
	private String type;
	private int a4pages;
	private OrdersService oService = BaseFactory.getInstance(OrdersService.class);
	private ProductService pService = BaseFactory.getInstance(ProductService.class);
	private TransportcostService tService = BaseFactory.getInstance(TransportcostService.class);
	private RatioService rService = BaseFactory.getInstance(RatioService.class);
	private UserBriberyService ubService = BaseFactory.getInstance(UserBriberyService.class);
	@Override
	public Ordergroup getModel() {
		if (ordergroup == null)
			ordergroup = new Ordergroup();
		return ordergroup;
	}

	public String newOrder() throws UnsupportedEncodingException {
		float totalPrice = 0;
		List<Cart> carts = (List<Cart>) ServletActionContext.getRequest()
				.getSession().getAttribute("carts");
		Set<Suborders> sorders = new HashSet<Suborders>();
		for (Cart cart : carts) {
			Suborders sorder = new Suborders();
			sorder.setDescription(cart.getDescription());
			sorder.setImgPath(cart.getImgPath());
			sorder.setNumber(cart.getNumber());
			sorder.setPrice(cart.getPerPrice());
			sorder.setOrdergroup(ordergroup);
			sorder.setPid(cart.getPid());
			if(cart.getFilePath()!=null&&!cart.getFilePath().equals("")) {
				sorder.setFilePath(cart.getFilePath());
				ordergroup.setOrderType(2);
			}
			sorders.add(sorder);
			totalPrice += cart.getPerPrice() * cart.getNumber();
		}
		ordergroup.setDescription(carts.get(0).getDescription() + "\n共"
				+ carts.size() + "件商品");
		ordergroup.setImgPath(carts.get(0).getImgPath());
		if (carts == null || carts.size() == 0)
			return ERROR;
		List<Address> addresses = (List<Address>) ServletActionContext
				.getRequest().getSession().getAttribute("addresses");
		Address address = addresses.get(addressindex);
		ordergroup.setAddress(address.getAddress());
		ordergroup.setMobile(address.getMobile());
		ordergroup.setReceiver(address.getReceiver());
		ordergroup.setId(OrderIdUtil.newOrderId());
		// ordergroup.setId(UUID.randomUUID().toString());
		Integer transportType = ordergroup.getTransportType();
		if (transportType == 0) {
			Transportcost transportcost = tService.findById("1");
			totalPrice += transportcost.getPrice();
			ordergroup.setTransportCost(transportcost.getPrice());
		} else {
			ordergroup.setTransportCost(0f);
		}
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		ratio = rService.findById(1);
		if (useBonus) {
			if (user.getUsableBonus() < bonus) {
				bonus = user.getUsableBonus();
			}
			totalPrice -= bonus / ratio.getPrice();
		}
		if (useBribery) {
//			List<UserBribery> briberies = new BaseDao<UserBribery>()
//					.findByCondition(UserBribery.class,
//							"uid = '" + user.getId() + "' and bid = '"
//									+ ordergroup.getBid() + "'");
			List<UserBribery> briberies = ubService.findByCondition(UserBribery.class,
					"uid = '" + user.getId() + "' and bid = '"
							+ ordergroup.getBid() + "'");
			
			
			if (briberies == null || briberies.size() == 0)
				return ERROR;
			UserBribery bribery = briberies.get(0);
			if (bribery.getUsed() == 0)
				totalPrice -= bribery.getId().getBriberymoney().getPrice();
			new UserBriberyService().setUsed(bribery);
		}
		if(usePackage) {
			Product p = pService.findProductById(carts.get(0).getPid());
			Float pprice = p.getPrice();
			totalPrice -= pprice*a4pages;
			new UserA4packageService().use(a4pages,user.getId(),packageid);
		}
		if(totalPrice<=0.1) totalPrice = 0.1f;
		ordergroup.setSuborders(sorders);
		totalPrice = (float)((int)(totalPrice * 100))/100;
		ordergroup.setTotalPrice(totalPrice);
		ordergroup.setPayStatus(0);
		oService.saveNewEntity(ordergroup);
		// bonusService.addBonusRecord(user.getId(), ordergroup.getId(), (int)
		// (totalPrice/ratio.getPrice()));
//		if(bonus>0)
//		bonusService.addBonusRecord(user.getId(), ordergroup.getId(), -bonus);

		

		// 建立请求
		String sHtmlText = alipay();
		// out.println(sHtmlText);
		sHtmlText = sHtmlText.replaceFirst(" ", " target=\"_blank\"");
		ServletActionContext.getRequest().setAttribute("result", sHtmlText);
		ServletActionContext.getRequest().getSession().removeAttribute("carts");
		ServletActionContext.getRequest().getSession()
				.removeAttribute("addresses");
		ServletActionContext.getRequest().getSession()
				.removeAttribute("totalPrice");
		return SUCCESS;
	}

	public String getOrderDetail() {
		Ordergroup order = oService.getOrderById(ordergroup.getId());
		ServletActionContext.getRequest().setAttribute("order", order);
		return SUCCESS;
	}

	public String confirmSendView() {
		Ordergroup order = oService.getOrderById(ordergroup.getId());
		ServletActionContext.getRequest().setAttribute("order", order);
		return SUCCESS;
	}

	public String getUserOrders() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		int maxPage = 1;
		if (Integer.parseInt(type) == 5) {
			maxPage = oService.getMaxPage("");
		} else {
			maxPage = oService.getMaxPage(" where payStatus = " + type);
		}
		List<Ordergroup> orders = oService.getUserOrders(user.getId(), type,
				page);
		ServletActionContext.getRequest().setAttribute("orders", orders);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("maxPage", maxPage);
		ServletActionContext.getRequest().setAttribute("type", type);
		return SUCCESS;
	}

	public String getManagerAllOrders() {
		int maxPage = 1;
		if (Integer.parseInt(type) == 5) {
			maxPage = oService.getMaxPage("");
		} else {
			maxPage = oService.getMaxPage(" where payStatus = " + type);
		}
		List<Ordergroup> orders = oService.getManagerAllOrders(type, page);
		ServletActionContext.getRequest().setAttribute("orders", orders);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("maxPage", maxPage);
		ServletActionContext.getRequest().setAttribute("type", type);
		return SUCCESS;
	}

	public String getLastestOrderDetail() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		Ordergroup order = oService.getLatestUserOrder(user.getId());
		ServletActionContext.getRequest().setAttribute("order", order);
		return SUCCESS;
	}

	public String payByOrderId() {
		// //////////////////////////////////请求参数//////////////////////////////////////
		this.ordergroup = oService.getOrderById(ordergroup.getId());
		String sHtmlText = alipay();
		// out.println(sHtmlText);
		ServletActionContext.getRequest().setAttribute("result", sHtmlText);
		ServletActionContext.getRequest().getSession().removeAttribute("carts");
		ServletActionContext.getRequest().getSession()
				.removeAttribute("addresses");
		ServletActionContext.getRequest().getSession()
				.removeAttribute("totalPrice");
		return SUCCESS;
	}
	
	
	
	public String repay() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		this.ordergroup = oService.getLatestUserOrder(user.getId());
		String sHtmlText = alipay();
		ServletActionContext.getRequest().setAttribute("result", sHtmlText);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	

	private String alipay() {
		// 支付类型
		String payment_type = "1";
		// 必填，不能修改
		// 服务器异步通知页面路径
		String notify_url = "http://www.pindianpp.com/alipay/notify";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数

		// 页面跳转同步通知页面路径
		String return_url = "http://www.pindianpp.com/alipay/returnUrl";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
		
		// 商户订单号
		String out_trade_no = ordergroup.getId();
		// 商户网站订单系统中唯一订单号，必填

		// 订单名称
		String subject = "品点·订单";
		// 必填

		// 付款金额
		String price = ordergroup.getTotalPrice() + "";
		// 必填

		// 商品数量
		String quantity = "1";
		// 必填，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品
		// 物流费用
		String logistics_fee = ordergroup.getTransportCost() + "";
		// 必填，即运费
		// 物流类型
		String logistics_type = "EXPRESS";
		// 必填，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		// 物流支付方式
		String logistics_payment = "SELLER_PAY";
		// 必填，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
		// 订单描述

		String body = null;
		// 商品展示地址
		String show_url = "http://www.pindianpp.com/order/showUserOrders";
		// 需以http://开头的完整路径，如：http://www.商户网站.com/myorder.html

		// 收货人姓名
		String receive_name = ordergroup.getReceiver();// new
														// String(ordergroup.getReceiver().getBytes("ISO-8859-1"),"UTF-8");
		// 如：张三
		// 收货人地址
		String receive_address = ordergroup.getAddress();// new
															// String(ordergroup.getAddress().getBytes("ISO-8859-1"),"UTF-8");
		// 如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
		// 收货人邮编
		String receive_zip = null;
		// 如：123456

		// 收货人电话号码
		String receive_phone = null;
		// 如：0571-88158090

		// 收货人手机号码
		String receive_mobile = ordergroup.getMobile();
		// 如：13312341234

		// ////////////////////////////////////////////////////////////////////////////////

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_partner_trade_by_buyer");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_email", AlipayConfig.seller_email);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("price", price);
		sParaTemp.put("quantity", quantity);
		sParaTemp.put("logistics_fee", logistics_fee);
		sParaTemp.put("logistics_type", logistics_type);
		sParaTemp.put("logistics_payment", logistics_payment);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("receive_name", receive_name);
		sParaTemp.put("receive_address", receive_address);
		sParaTemp.put("receive_zip", receive_zip);
		sParaTemp.put("receive_phone", receive_phone);
		sParaTemp.put("receive_mobile", receive_mobile);

		// 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
		return sHtmlText;
	}


	
	public Ordergroup getOrdergroup() {
		return ordergroup;
	}

	public void setOrdergroup(Ordergroup ordergroup) {
		this.ordergroup = ordergroup;
	}

	public int getAddressindex() {
		return addressindex;
	}

	public void setAddressindex(int addressindex) {
		this.addressindex = addressindex;
	}

	public boolean isUseBribery() {
		return useBribery;
	}

	public void setUseBribery(boolean useBribery) {
		this.useBribery = useBribery;
	}

	public boolean isUseBonus() {
		return useBonus;
	}

	public void setUseBonus(boolean useBonus) {
		this.useBonus = useBonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isUsePackage() {
		return usePackage;
	}

	public void setUsePackage(boolean usePackage) {
		this.usePackage = usePackage;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getA4pages() {
		return a4pages;
	}

	public void setA4pages(int a4pages) {
		this.a4pages = a4pages;
	}

	public String getPackageid() {
		return packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

}
