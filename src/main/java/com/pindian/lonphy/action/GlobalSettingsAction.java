package com.pindian.lonphy.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pindian.lonphy.domain.Ratio;
import com.pindian.lonphy.domain.Transportcost;
import com.pindian.lonphy.factory.BaseFactory;
import com.pindian.lonphy.service.RatioService;
import com.pindian.lonphy.service.TransportcostService;

public class GlobalSettingsAction extends ActionSupport implements ModelDriven<Transportcost>{
	private Transportcost cost = new Transportcost();
	private float ratio1;
	private float ratio2;
	private int ratioid1;
	private int ratioid2;
	private RatioService rService = BaseFactory.getInstance(RatioService.class);
	private TransportcostService tService = BaseFactory.getInstance(TransportcostService.class);
	@Override
	public Transportcost getModel() {
		if(cost!=null) cost = new Transportcost();
		return cost;
	}
	

	public int getRatioid1() {
		return ratioid1;
	}


	public void setRatioid1(int ratioid1) {
		this.ratioid1 = ratioid1;
	}


	public int getRatioid2() {
		return ratioid2;
	}


	public void setRatioid2(int ratioid2) {
		this.ratioid2 = ratioid2;
	}


	public Transportcost getCost() {
		return cost;
	}
	public void setCost(Transportcost cost) {
		this.cost = cost;
	}
	
	public float getRatio1() {
		return ratio1;
	}

	public void setRatio1(float ratio1) {
		this.ratio1 = ratio1;
	}

	public float getRatio2() {
		return ratio2;
	}

	public void setRatio2(float ratio2) {
		this.ratio2 = ratio2;
	}

	public String update() {
		Ratio r1 = new Ratio(ratio1);
		r1.setId(ratioid1);
		rService.update(Ratio.class,ratioid1,r1);
		Ratio r2 = new Ratio(ratio2);
		r2.setId(ratioid2);
		rService.update(Ratio.class, ratioid2, r2);
		tService.update(Transportcost.class, cost.getId(), cost);
		return SUCCESS;
	}
	
	public String show() {
		
		Ratio ratio1 = rService.findById(1);
		Ratio ratio2 = rService.findById(2);
		Transportcost c = tService.findById("1");
		ServletActionContext.getRequest().setAttribute("ratio1", ratio1);
		ServletActionContext.getRequest().setAttribute("ratio2", ratio2);
		ServletActionContext.getRequest().setAttribute("cost", c);
		return SUCCESS;
	}
	
}
