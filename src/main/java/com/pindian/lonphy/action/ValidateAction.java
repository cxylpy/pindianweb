package com.pindian.lonphy.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pindian.lonphy.config.AlipayConfig;
import com.pindian.lonphy.domain.Ordergroup;
import com.pindian.lonphy.domain.Ratio;
import com.pindian.lonphy.domain.Suborders;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.BonusService;
import com.pindian.lonphy.service.OrdersService;
import com.pindian.lonphy.service.ProductService;
import com.pindian.lonphy.service.RatioService;
import com.pindian.lonphy.service.UserService;
import com.pindian.lonphy.util.AlipayNotify;
import com.pindian.lonphy.util.AlipaySubmit;

public class ValidateAction extends ActionSupport {
	private OrdersService oService = BaseFactory
			.getInstance(OrdersService.class);
	// 总金额
	private String total_fee;
	// 商户订单号
	private String out_trade_no;
	// 支付宝交易号
	private String trade_no;
	// 交易状态
	private String trade_status;
	private String type;
	private String number;
	private String tbid;
	private String comName;
	private String id;
	private ProductService pService = BaseFactory
			.getInstance(ProductService.class);
	private BonusService bonusService = BaseFactory
			.getInstance(BonusService.class);
	private UserService uService = BaseFactory.getInstance(UserService.class);
	private RatioService rService = BaseFactory.getInstance(RatioService.class);

	public String returnUrl() {
		// 获取支付宝GET过来反馈信息
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// try {
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			// } catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			// }
			params.put(name, valueStr);
		}

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		// 计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		if (verify_result) {// 验证成功
			// ////////////////////////////////////////////////////////////////////////////////////////
			// 请在这里加上商户的业务逻辑程序代码
			// System.out.println("验证成功");
			// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

			if (trade_status.equals("WAIT_SELLER_SEND_GOODS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				oService.setTbid(out_trade_no, trade_no);
				oService.setOrderStatus(out_trade_no, 1);
			}
			request.setAttribute("orderid", out_trade_no);
			request.setAttribute("price", oService.getOrderById(out_trade_no)
					.getTotalPrice());
			// 该页面可做页面美工编辑
			return SUCCESS;
			// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			// ////////////////////////////////////////////////////////////////////////////////////////
		} else {
			// System.out.println("验证失败");
			// 该页面可做页面美工编辑
			return "fail";
		}
	}

	public String confirmSend() {
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "send_goods_confirm_by_platform");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("trade_no", tbid);
		sParaTemp.put("logistics_name", comName);
		sParaTemp.put("invoice_no", number);
		sParaTemp.put("transport_type", type);
		// 建立请求
		try {
			String sHtmlText = AlipaySubmit.buildRequest("", "", sParaTemp);
			oService.setOrderStatus(id, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Ordergroup order = oService.getOrderById(id);
		ServletActionContext.getRequest().setAttribute("order", order);
		return SUCCESS;
	}

	public String notifyUrl() {
		// 获取支付宝POST过来反馈信息
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		// 支付宝交易号

		String trade_no = request.getParameter("trade_no");

		// 交易状态
		String trade_status = request.getParameter("trade_status");

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if (AlipayNotify.verify(params)) {// 验证成功
			// ////////////////////////////////////////////////////////////////////////////////////////
			// 请在这里加上商户的业务逻辑程序代码

			// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

			if (trade_status.equals("WAIT_BUYER_PAY")) {
				// 该判断表示买家已在支付宝交易管理中产生了交易记录，但没有付款

				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				ServletActionContext.getRequest().setAttribute("result",
						"success");
			} else if (trade_status.equals("WAIT_SELLER_SEND_GOODS")) {
				// 该判断表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货

				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				ServletActionContext.getRequest().setAttribute("result",
						"success");
				oService.setOrderStatus(out_trade_no, 1);
			} else if (trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")) {
				// 该判断表示卖家已经发了货，但买家还没有做确认收货的操作

				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				ServletActionContext.getRequest().setAttribute("result",
						"success");
				oService.setOrderStatus(out_trade_no, 2);
			} else if (trade_status.equals("TRADE_FINISHED")) {
				// 该判断表示买家已经确认收货，这笔交易完成

				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				ServletActionContext.getRequest().setAttribute("result",
						"success");
				Ordergroup mOrder = oService.getOrderById(out_trade_no);
				if (mOrder.getPayStatus() != 3) {
					oService.setOrderStatus(out_trade_no, 3);
					Ordergroup order = oService.getOrderById(out_trade_no);
					Ratio ratio = rService.findById(2);
					bonusService.addBonusRecord(order.getUid(), order.getId(),
							(int) (order.getTotalPrice() * ratio.getPrice()));
					uService.addBonus(order.getUid(),
							(int) (order.getTotalPrice() * ratio.getPrice()));
					for (Suborders sub : order.getSuborders()) {
						pService.addSale(sub.getPid(), sub.getNumber());
					}
					uService.addCost(order.getUid(), order.getTotalPrice());
				}
			} else {
				ServletActionContext.getRequest().setAttribute("result",
						"success");
			}

			// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			// ////////////////////////////////////////////////////////////////////////////////////////
		} else {// 验证失败
			ServletActionContext.getRequest().setAttribute("result", "fail");
		}
		return SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTbid() {
		return tbid;
	}

	public void setTbid(String tbid) {
		this.tbid = tbid;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
