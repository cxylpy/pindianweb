package com.pindian.lonphy.action;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.util.TextUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.A4package;
import com.pindian.lonphy.domain.Briberymoney;
import com.pindian.lonphy.domain.Images;
import com.pindian.lonphy.domain.Product;
import com.pindian.lonphy.domain.Producttech;
import com.pindian.lonphy.domain.Teckdetail;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.A4packageService;
import com.pindian.lonphy.service.BriberyService;
import com.pindian.lonphy.service.ProductService;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private ProductService pService = BaseFactory
			.getInstance(ProductService.class);
	private BriberyService bService = BaseFactory
			.getInstance(BriberyService.class);
	private A4packageService a4packageService = BaseFactory
			.getInstance(A4packageService.class);
	private Product product;
	private File image;
	private String product_image;
	private String details_image;
	private String imageContentType;
	private String imageFileName;
	private String techName;
	private String payTypeString;
	private String inputType1;
	private String inputType2;
	private String inputType3;
	private String inputType4;
	private String inputType5;
	private String inputType6;
	private String inputType7;
	private String inputType8;
	private String inputType9;
	private String inputType10;
	private String techDescription1;
	private String techDescription2;
	private String techDescription3;
	private String techDescription4;
	private String techDescription5;
	private String techDescription6;
	private String techDescription7;
	private String techDescription8;
	private String techDescription9;
	private String techDescription10;
	private String techPriceDelta1;
	private String techPriceDelta2;
	private String techPriceDelta3;
	private String techPriceDelta4;
	private String techPriceDelta5;
	private String techPriceDelta6;
	private String techPriceDelta7;
	private String techPriceDelta8;
	private String techPriceDelta9;
	private String techPriceDelta10;
	private File[] productImages1;
	private File[] productImages2;
	private File[] productImages3;
	private File[] productImages4;
	private File[] productImages5;
	private File[] productImages6;
	private File[] productImages7;
	private File[] productImages8;
	private File[] productImages9;
	private File[] productImages10;
	private int type;

	@Override
	public Product getModel() {
		if (product == null)
			product = new Product();
		return product;
	}

	public String addProduct() {
		String[] inputTypes = { inputType1, inputType2, inputType3, inputType4,
				inputType5, inputType6, inputType7, inputType8, inputType9,
				inputType10 };
		String[] techDescriptions = { techDescription1, techDescription2,
				techDescription3, techDescription4, techDescription5,
				techDescription6, techDescription7, techDescription8,
				techDescription9, techDescription10 };
		String[] techPriceDeltas = { techPriceDelta1, techPriceDelta2,
				techPriceDelta3, techPriceDelta4, techPriceDelta5,
				techPriceDelta6, techPriceDelta7, techPriceDelta8,
				techPriceDelta9, techPriceDelta10 };
		if (techName != null) {
			String[] techs = techName.split(",");
			Set<Producttech> techSet = new HashSet<Producttech>();
			for (int i = 0; i < techs.length; i++) {
				if (techs[i].equals("") || techs[i] == null)
					continue;
				String[] techDescs = techDescriptions[i].split(",");
				String[] techDeltas = techPriceDeltas[i].split(",");
				Set<Teckdetail> details = new HashSet<Teckdetail>();
				Producttech producttech = new Producttech(product,
						techs[i].trim(),
						Integer.parseInt(inputTypes[i].trim()), null);
				for (int j = 0; j < techDescs.length; j++) {
					if (techDescs[j].equals("") || techDescs[j] == null)
						continue;
					Teckdetail detail = new Teckdetail(producttech,
							techDescs[j].trim(), Float.parseFloat(techDeltas[j]
									.trim()));
					details.add(detail);
				}
				producttech.setTeckdetails(details);
				techSet.add(producttech);
			}
			product.setTechs(techSet);
		}
		if (!TextUtils.isEmpty(product_image)) {
			product.setImgPath(product_image);
		}
		String[] detail_images = details_image.split(",");
		Set<Images> image_set = new HashSet<Images>();
		for (String detail : detail_images) {
			List<Images> images_list = pService.findByCondition(
					Images.class, " urlpath= '" + detail.trim() + "'");
			if (images_list != null && images_list.size() > 0) {
				image_set.add(images_list.get(0));
			}
		}
		product.setImages(image_set);
		// String[] payTypes = payTypeString.split(",");
		// Paytype paytype;
		// if (payTypes.length >= 2) {
		// paytype = new BaseDao<Paytype>().findById(Paytype.class, 2);
		// } else {
		// paytype = new BaseDao<Paytype>().findById(Paytype.class,
		// Integer.parseInt(payTypeString.trim()));
		// }
		pService.save(product);
		return SUCCESS;

	}

	public String updateProduct() {
		String[] inputTypes = { inputType1, inputType2, inputType3, inputType4,
				inputType5, inputType6, inputType7, inputType8, inputType9,
				inputType10 };
		String[] techDescriptions = { techDescription1, techDescription2,
				techDescription3, techDescription4, techDescription5,
				techDescription6, techDescription7, techDescription8,
				techDescription9, techDescription10 };
		String[] techPriceDeltas = { techPriceDelta1, techPriceDelta2,
				techPriceDelta3, techPriceDelta4, techPriceDelta5,
				techPriceDelta6, techPriceDelta7, techPriceDelta8,
				techPriceDelta9, techPriceDelta10 };
		if (techName != null) {
			String[] techs = techName.split(",");
			Set<Producttech> techSet = new HashSet<Producttech>();
			for (int i = 0; i < techs.length; i++) {
				if (techs[i] == null || techs[i].trim().equals(""))
					continue;
				String[] techDescs = techDescriptions[i].split(",");
				String[] techDeltas = techPriceDeltas[i].split(",");
				Set<Teckdetail> details = new HashSet<Teckdetail>();
				Producttech producttech = new Producttech(product,
						techs[i].trim(),
						Integer.parseInt(inputTypes[i].trim()), null);
				for (int j = 0; j < techDescs.length; j++) {
					if (techDescs[j] == null || techDescs[j].trim().equals(""))
						continue;
					Teckdetail detail = new Teckdetail(producttech,
							techDescs[j].trim(), Float.parseFloat(techDeltas[j]
									.trim()));
					details.add(detail);
				}
				producttech.setTeckdetails(details);
				techSet.add(producttech);
			}
			product.setTechs(techSet);
		}
		if (!TextUtils.isEmpty(product_image)) {
			product.setImgPath(product_image);
		}
		String[] detail_images = details_image.split(",");
		Set<Images> image_set = new HashSet<Images>();
		for (String detail : detail_images) {
			List<Images> images_list = pService.findByCondition(
					Images.class, " urlpath= '" + detail.trim() + "'");
			if (images_list != null && images_list.size() > 0) {
				image_set.add(images_list.get(0));
			}
		}
		product.setImages(image_set);
		// String[] payTypes = payTypeString.split(",");
		// Paytype paytype;
		// if (payTypes.length >= 2) {
		// paytype = new BaseDao<Paytype>().findById(Paytype.class, 2);
		// } else {
		// paytype = new BaseDao<Paytype>().findById(Paytype.class,
		// Integer.parseInt(payTypeString.trim()));
		// }
		// product.setPaytype(paytype);
		pService.updateProduct(product);
		return SUCCESS;

	}

	public String showByLargeType() {
		List<Product> products = pService.showByLargeType(type);
		ServletActionContext.getRequest().removeAttribute("products");
		ServletActionContext.getRequest().setAttribute("products", products);
		return SUCCESS;
	}

	public String indexShowByLargeType() {
		List<Product> products = pService.indexShowByLargeType(type);
		ServletActionContext.getRequest().setAttribute("products", products);
		return SUCCESS;
	}

	public String findProductById() {
		Product p = pService.findProductById(product.getId());
		ServletActionContext.getRequest().setAttribute("product", p);
		return SUCCESS;
	}

	public String putOn() {
		pService.putOn(product.getId());
		return SUCCESS;
	}

	public String pullOff() {
		pService.pullOff(product.getId());
		return SUCCESS;
	}

	public String showIndex() {
		List<Product> cultures = pService.indexShowByLargeType(1);
		List<Product> posts = pService.indexShowByLargeType(3);
		List<Product> dms = pService.indexShowByLargeType(4);
		List<Product> flags = pService.indexShowByLargeType(5);
		List<Product> cards = pService.indexShowByLargeType(6);
		List<Briberymoney> briberys = bService.getOnShelfBriberys();
		List<A4package> a4packages = a4packageService.getOnShelfA4packages();
		ServletActionContext.getRequest().setAttribute("cultures", cultures);
		ServletActionContext.getRequest().setAttribute("posts", posts);
		ServletActionContext.getRequest().setAttribute("dms", dms);
		ServletActionContext.getRequest().setAttribute("flags", flags);
		ServletActionContext.getRequest().setAttribute("briberys", briberys);
		ServletActionContext.getRequest().setAttribute("cards", cards);
		ServletActionContext.getRequest()
				.setAttribute("a4packages", a4packages);
		return SUCCESS;
	}

	public String saveWeight() {
		pService.saveWeight(product.getId(), product.getWeight());
		return SUCCESS;
	}

	public String modifyProductView() {
		Product p = pService.findProductById(product.getId());
		ServletActionContext.getRequest().setAttribute("product", p);
		return SUCCESS;
	}

	public String deleteProductById() {
		pService.deleteProductById(product.getId());
		return SUCCESS;
	}
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getInputType1() {
		return inputType1;
	}

	public void setInputType1(String inputType1) {
		this.inputType1 = inputType1;
	}

	public String getInputType2() {
		return inputType2;
	}

	public void setInputType2(String inputType2) {
		this.inputType2 = inputType2;
	}

	public String getInputType3() {
		return inputType3;
	}

	public void setInputType3(String inputType3) {
		this.inputType3 = inputType3;
	}

	public String getInputType4() {
		return inputType4;
	}

	public void setInputType4(String inputType4) {
		this.inputType4 = inputType4;
	}

	public String getInputType5() {
		return inputType5;
	}

	public void setInputType5(String inputType5) {
		this.inputType5 = inputType5;
	}

	public String getInputType6() {
		return inputType6;
	}

	public void setInputType6(String inputType6) {
		this.inputType6 = inputType6;
	}

	public String getInputType7() {
		return inputType7;
	}

	public void setInputType7(String inputType7) {
		this.inputType7 = inputType7;
	}

	public String getInputType8() {
		return inputType8;
	}

	public void setInputType8(String inputType8) {
		this.inputType8 = inputType8;
	}

	public String getInputType9() {
		return inputType9;
	}

	public void setInputType9(String inputType9) {
		this.inputType9 = inputType9;
	}

	public String getInputType10() {
		return inputType10;
	}

	public void setInputType10(String inputType10) {
		this.inputType10 = inputType10;
	}

	public String getPayTypeString() {
		return payTypeString;
	}

	public void setPayTypeString(String payTypeString) {
		this.payTypeString = payTypeString;
	}

	public String getTechDescription1() {
		return techDescription1;
	}

	public void setTechDescription1(String techDescription1) {
		this.techDescription1 = techDescription1;
	}

	public String getTechDescription2() {
		return techDescription2;
	}

	public void setTechDescription2(String techDescription2) {
		this.techDescription2 = techDescription2;
	}

	public String getTechDescription3() {
		return techDescription3;
	}

	public void setTechDescription3(String techDescription3) {
		this.techDescription3 = techDescription3;
	}

	public String getTechDescription4() {
		return techDescription4;
	}

	public void setTechDescription4(String techDescription4) {
		this.techDescription4 = techDescription4;
	}

	public String getTechDescription5() {
		return techDescription5;
	}

	public void setTechDescription5(String techDescription5) {
		this.techDescription5 = techDescription5;
	}

	public String getTechDescription6() {
		return techDescription6;
	}

	public void setTechDescription6(String techDescription6) {
		this.techDescription6 = techDescription6;
	}

	public String getTechDescription7() {
		return techDescription7;
	}

	public void setTechDescription7(String techDescription7) {
		this.techDescription7 = techDescription7;
	}

	public String getTechDescription8() {
		return techDescription8;
	}

	public void setTechDescription8(String techDescription8) {
		this.techDescription8 = techDescription8;
	}

	public String getTechDescription9() {
		return techDescription9;
	}

	public void setTechDescription9(String techDescription9) {
		this.techDescription9 = techDescription9;
	}

	public String getTechDescription10() {
		return techDescription10;
	}

	public void setTechDescription10(String techDescription10) {
		this.techDescription10 = techDescription10;
	}

	public String getTechPriceDelta1() {
		return techPriceDelta1;
	}

	public void setTechPriceDelta1(String techPriceDelta1) {
		this.techPriceDelta1 = techPriceDelta1;
	}

	public String getTechPriceDelta2() {
		return techPriceDelta2;
	}

	public void setTechPriceDelta2(String techPriceDelta2) {
		this.techPriceDelta2 = techPriceDelta2;
	}

	public String getTechPriceDelta3() {
		return techPriceDelta3;
	}

	public void setTechPriceDelta3(String techPriceDelta3) {
		this.techPriceDelta3 = techPriceDelta3;
	}

	public String getTechPriceDelta4() {
		return techPriceDelta4;
	}

	public void setTechPriceDelta4(String techPriceDelta4) {
		this.techPriceDelta4 = techPriceDelta4;
	}

	public String getTechPriceDelta5() {
		return techPriceDelta5;
	}

	public void setTechPriceDelta5(String techPriceDelta5) {
		this.techPriceDelta5 = techPriceDelta5;
	}

	public String getTechPriceDelta6() {
		return techPriceDelta6;
	}

	public void setTechPriceDelta6(String techPriceDelta6) {
		this.techPriceDelta6 = techPriceDelta6;
	}

	public String getTechPriceDelta7() {
		return techPriceDelta7;
	}

	public void setTechPriceDelta7(String techPriceDelta7) {
		this.techPriceDelta7 = techPriceDelta7;
	}

	public String getTechPriceDelta8() {
		return techPriceDelta8;
	}

	public void setTechPriceDelta8(String techPriceDelta8) {
		this.techPriceDelta8 = techPriceDelta8;
	}

	public String getTechPriceDelta9() {
		return techPriceDelta9;
	}

	public void setTechPriceDelta9(String techPriceDelta9) {
		this.techPriceDelta9 = techPriceDelta9;
	}

	public String getTechPriceDelta10() {
		return techPriceDelta10;
	}

	public void setTechPriceDelta10(String techPriceDelta10) {
		this.techPriceDelta10 = techPriceDelta10;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getDetails_image() {
		return details_image;
	}

	public void setDetails_image(String details_image) {
		this.details_image = details_image;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
