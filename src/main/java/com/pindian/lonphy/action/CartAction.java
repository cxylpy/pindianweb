package com.pindian.lonphy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pindian.lonphy.domain.Address;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.domain.Cart;
import com.pindian.lonphy.domain.Product;
import com.pindian.lonphy.domain.Producttech;
import com.pindian.lonphy.domain.Ratio;
import com.pindian.lonphy.domain.Teckdetail;
import com.pindian.lonphy.domain.Transportcost;
import com.pindian.lonphy.domain.User;
import com.pindian.lonphy.domain.UserA4package;
import com.pindian.lonphy.domain.UserBribery;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.AddressService;
import com.pindian.lonphy.service.BriberyService;
import com.pindian.lonphy.service.ProductService;
import com.pindian.lonphy.service.RatioService;
import com.pindian.lonphy.service.TransportcostService;
import com.pindian.lonphy.service.UserA4packageService;

/**
 * @author Lonphy
 * 
 */
public class CartAction extends ActionSupport {
	private String tech_detail1;
	private String tech_detail2;
	private String tech_detail3;
	private String tech_detail4;
	private String tech_detail5;
	private String tech_detail6;
	private String tech_detail7;
	private String tech_detail8;
	private String tech_detail9;
	private String tech_detail10;
	private int number;
	private int pos;
	private String[] imgPaths;
	private String[] perPrices;
	private String[] descriptions;
	private String[] nums;
	private String[] checkedItems;
	private String pid;
	private BriberyService bService = BaseFactory.getInstance(BriberyService.class);
	private UserA4packageService uaService = BaseFactory.getInstance(UserA4packageService.class);
	private ProductService pService = BaseFactory.getInstance(ProductService.class);
	private RatioService rService = BaseFactory.getInstance(RatioService.class);
	private TransportcostService tService = BaseFactory.getInstance(TransportcostService.class);
	public String[] getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String[] imgPaths) {
		this.imgPaths = imgPaths;
	}

	public String[] getPerPrices() {
		return perPrices;
	}

	public void setPerPrices(String[] perPrices) {
		this.perPrices = perPrices;
	}

	public String[] getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String[] descriptions) {
		this.descriptions = descriptions;
	}

	public String[] getNums() {
		return nums;
	}

	public void setNums(String[] nums) {
		this.nums = nums;
	}

	public String[] getCheckedItems() {
		return checkedItems;
	}

	public void setCheckedItems(String[] checkedItems) {
		this.checkedItems = checkedItems;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getTech_detail1() {
		return tech_detail1;
	}

	public void setTech_detail1(String tech_detail1) {
		this.tech_detail1 = tech_detail1;
	}

	public String getTech_detail2() {
		return tech_detail2;
	}

	public void setTech_detail2(String tech_detail2) {
		this.tech_detail2 = tech_detail2;
	}

	public String getTech_detail3() {
		return tech_detail3;
	}

	public void setTech_detail3(String tech_detail3) {
		this.tech_detail3 = tech_detail3;
	}

	public String getTech_detail4() {
		return tech_detail4;
	}

	public void setTech_detail4(String tech_detail4) {
		this.tech_detail4 = tech_detail4;
	}

	public String getTech_detail5() {
		return tech_detail5;
	}

	public void setTech_detail5(String tech_detail5) {
		this.tech_detail5 = tech_detail5;
	}

	public String getTech_detail6() {
		return tech_detail6;
	}

	public void setTech_detail6(String tech_detail6) {
		this.tech_detail6 = tech_detail6;
	}

	public String getTech_detail7() {
		return tech_detail7;
	}

	public void setTech_detail7(String tech_detail7) {
		this.tech_detail7 = tech_detail7;
	}

	public String getTech_detail8() {
		return tech_detail8;
	}

	public void setTech_detail8(String tech_detail8) {
		this.tech_detail8 = tech_detail8;
	}

	public String getTech_detail9() {
		return tech_detail9;
	}

	public void setTech_detail9(String tech_detail9) {
		this.tech_detail9 = tech_detail9;
	}

	public String getTech_detail10() {
		return tech_detail10;
	}

	public void setTech_detail10(String tech_detail10) {
		this.tech_detail10 = tech_detail10;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String add() {
		String techdetails[] = { tech_detail1, tech_detail2, tech_detail3,
				tech_detail4, tech_detail5, tech_detail6, tech_detail7,
				tech_detail8, tech_detail9, tech_detail10 };
		Product p = pService.findProductById(pid);
		StringBuffer sb = new StringBuffer(p.getName());
		String imgPath = null;
		float price = p.getPrice();
		if (p.getOnsalePrice() > 0)
			price = p.getOnsalePrice();
		Set<Producttech> techs = p.getTechs();
		for (Producttech tech : techs) {
			Set<Teckdetail> details = tech.getTeckdetails();
			boolean ok = false;
			boolean append = true;
			if (tech.getInputType() == 3) {
				append = false;
			}
			for (Teckdetail detail : details) {
				for (String str : techdetails) {
					if (str != null) {
						String[] split = str.split(",");
						if (split[0].equals(detail.getDescription())) {
							ok = true;
							price += detail.getPriceDelta();
							if (append) {
								sb.append(tech.getName()).append(":")
										.append(detail.getDescription())
										.append("　　");
							} else {
								imgPath = detail.getDescription();
							}
						}
						if (tech.getInputType() == 2 && split.length == 1) {
							ok = true;
							price += Float.parseFloat(split[0])
									* detail.getPriceDelta();
							sb.append(tech.getName()).append(":")
									.append(split[0])
									.append(detail.getDescription())
									.append("　　");
						}

					}
				}
			}
			if (!ok)
				return ERROR;
		}

		if (imgPath == null) {
			imgPath = p.getImgPath();
		}
		Cart cart = new Cart();
		cart.setDescription(sb.toString());
		cart.setPerPrice(price);
		cart.setImgPath(imgPath);
		cart.setNumber(number);
		cart.setPid(p.getId());
		List<Cart> carts = (List<Cart>) ServletActionContext.getRequest()
				.getSession().getAttribute("carts");
		if (carts != null) {
			carts.add(cart);
		} else {
			carts = new ArrayList<Cart>();
			carts.add(cart);
			ServletActionContext.getRequest().getSession()
					.setAttribute("carts", carts);
		}
		return SUCCESS;
	}

	public String delete() {
		List<Cart> carts = (List<Cart>) ServletActionContext.getRequest()
				.getSession().getAttribute("carts");
		if (carts != null && carts.size() >= pos) {
			carts.remove(pos - 1);
		}
		return SUCCESS;
	}

	public String buyNow() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if(user.getAddresses()==null||user.getAddresses().size()<1) {
			String referer = ServletActionContext.getRequest().getHeader("Referer");
			ServletActionContext.getRequest().getSession().setAttribute("url", referer);
			return "newaddress";
		}
		String techdetails[] = { tech_detail1, tech_detail2, tech_detail3,
				tech_detail4, tech_detail5, tech_detail6, tech_detail7,
				tech_detail8, tech_detail9, tech_detail10 };
		Product p = pService.findProductById(pid);
		ServletActionContext.getRequest().getSession()
				.setAttribute("a4price", p.getPrice());
		StringBuffer sb = new StringBuffer(p.getName());
		String imgPath = null;
		float price = p.getPrice();
		if (p.getOnsalePrice() > 0)
			price = p.getOnsalePrice();
		if (p.getLargeType() == 2)
			price = 0;
		Set<Producttech> techs = p.getTechs();
		for (Producttech tech : techs) {
			Set<Teckdetail> details = tech.getTeckdetails();
			boolean ok = false;
			boolean append = true;
			if (tech.getInputType() == 3) {
				append = false;
			}
			for (Teckdetail detail : details) {
				for (String str : techdetails) {
					if (str != null) {
						String[] split = str.split(",");
						if (split[0].equals(detail.getDescription())) {
							ok = true;
							price += detail.getPriceDelta();
							if (append) {
								sb.append(tech.getName()).append(":")
										.append(detail.getDescription())
										.append("　　");
							} else {
								imgPath = detail.getDescription();
							}
						}
						if (tech.getInputType() == 2 && split.length == 1) {
							ok = true;
							price += Float.parseFloat(split[0])
									* detail.getPriceDelta();
							sb.append(tech.getName()).append(":")
									.append(split[0])
									.append(detail.getDescription())
									.append("　　");
						}

					}
				}
			}
			if (!ok)
				return ERROR;
		}

		if (imgPath == null) {
			imgPath = p.getImgPath();
		}
		Cart cart = new Cart();
		cart.setDescription(sb.toString());
		cart.setPerPrice(price);
		cart.setImgPath(imgPath);
		cart.setNumber(number);
		if(p.getLargeType()==2) {
			cart.setFilePath((String) ServletActionContext.getRequest().getSession().getAttribute("pdfUrlPath"));
		}
		cart.setPid(p.getId());
		List<Cart> carts = new ArrayList<Cart>();
		carts.add(cart);
		ServletActionContext.getRequest().getSession().removeAttribute("carts");
		ServletActionContext.getRequest().getSession()
				.setAttribute("carts", carts);
		float totalPrice = cart.getNumber() * cart.getPerPrice();
		List<Address> addresses = new AddressService().findUserAddresses(user
				.getId());
		ServletActionContext.getRequest().getSession()
				.setAttribute("addresses", addresses);
		ServletActionContext.getRequest().getSession()
				.setAttribute("totalPrice", totalPrice);
		List<UserBribery> userBriberys = bService.findByUser(user);
		List<Briberymoney> briberys = new ArrayList<Briberymoney>();
		for (UserBribery userBribery : userBriberys) {
			if (userBribery.getUsed() == 1)
				continue;
			if (userBribery.getId().getBriberymoney().getMinPrice() > totalPrice)
				continue;
			briberys.add(userBribery.getId().getBriberymoney());

		}

		ServletActionContext.getRequest().getSession()
				.removeAttribute("briberys");
		if (briberys.size() > 0) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("briberys", briberys);
		}
		ServletActionContext.getRequest().getSession()
				.removeAttribute("userpackages");
		if (p.getLargeType() == 2) {
			List<UserA4package> userpackages = uaService
					.getUsableA4packages(user.getId());
			if (userpackages.size() > 0)
				ServletActionContext.getRequest().getSession()
						.setAttribute("userpackages", userpackages.get(0));
		}

//		Transportcost cost = new BaseDao<Transportcost>().findById(
//				Transportcost.class, "1");
		Transportcost cost = tService.findById("1");
		Ratio ratio1 = rService.findById(1);
		Ratio ratio2 = rService.findById(2);
		ServletActionContext.getRequest().getSession()
				.setAttribute("bonusRatio1", ratio1);
		ServletActionContext.getRequest().getSession()
				.setAttribute("bonusRatio2", ratio2);
		ServletActionContext.getRequest().getSession()
				.setAttribute("transportcost", cost);
		return SUCCESS;
	}

	public String generateOrder() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		if(user.getAddresses()==null||user.getAddresses().size()<1) {
			ServletActionContext.getRequest().getSession().setAttribute("url", "http://www.pindianpp.com/jsp_cart");
			return "newaddress";
		}
		List<Cart> oldCarts = (List<Cart>) ServletActionContext.getRequest()
				.getSession().getAttribute("carts");
		List<Cart> carts = new ArrayList<Cart>();
		for (String index : checkedItems) {
			Cart cart = new Cart();
			cart.setDescription(descriptions[Integer.parseInt(index)]);
			cart.setImgPath(imgPaths[Integer.parseInt(index)]);
			cart.setPerPrice(Float.parseFloat(perPrices[Integer.parseInt(index)]
					.trim()));
			cart.setNumber(Integer.parseInt(nums[Integer.parseInt(index)]
					.trim()));
			cart.setPid(oldCarts.get(Integer.parseInt(index)).getPid());
			carts.add(cart);
		}
		ServletActionContext.getRequest().getSession().removeAttribute("carts");
		ServletActionContext.getRequest().getSession()
				.setAttribute("carts", carts);
		float totalPrice = 0;
		for (Cart cart : carts) {
			totalPrice += cart.getPerPrice() * cart.getNumber();
		}
		List<Address> addresses = new AddressService().findUserAddresses(user
				.getId());
		ServletActionContext.getRequest().getSession()
				.setAttribute("addresses", addresses);
		ServletActionContext.getRequest().getSession()
				.setAttribute("totalPrice", totalPrice);
		List<UserBribery> userBriberys = bService.findByUser(user);
		List<Briberymoney> briberys = new ArrayList<Briberymoney>();
		for (UserBribery userBribery : userBriberys) {
			if (userBribery.getUsed() == 1)
				continue;
			if (userBribery.getId().getBriberymoney().getMinPrice() > totalPrice)
				continue;
			briberys.add(userBribery.getId().getBriberymoney());
		}
		ServletActionContext.getRequest().getSession()
				.removeAttribute("briberys");
		if (briberys.size() > 0) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("briberys", briberys);
		}
		Transportcost cost = tService.findById("1");
		Ratio ratio1 = rService.findById(1);
		Ratio ratio2 = rService.findById(2);
		ServletActionContext.getRequest().getSession()
				.setAttribute("bonusRatio1", ratio1);
		ServletActionContext.getRequest().getSession()
				.setAttribute("bonusRatio2", ratio2);
		ServletActionContext.getRequest().getSession()
				.setAttribute("transportcost", cost);
		return SUCCESS;
	}
}
