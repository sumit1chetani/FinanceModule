package com.dci.payroll.payroll.gratuity;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class GratuityResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<GratuityBean> gratuityList;

	private GratuityBean gratuityBean = null;

	public List<GratuityBean> getGratuityList() {
		return gratuityList;
	}

	public void setGratuityList(List<GratuityBean> gratuityList) {
		this.gratuityList = gratuityList;
	}

	public GratuityBean getGratuityBean() {
		return gratuityBean;
	}

	public void setGratuityBean(GratuityBean gratuityBean) {
		this.gratuityBean = gratuityBean;
	}

}
