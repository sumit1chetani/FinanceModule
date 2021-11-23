package com.dci.payroll.payroll.rate;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class RateResultBean extends BasicResultBean implements Serializable {
	private List<RateBean> rateList;
	private RateBean rateBean;

	public RateBean getRateBean() {
		return rateBean;
	}

	public void setRateBean(RateBean rateBean) {
		this.rateBean = rateBean;
	}

	public List<RateBean> getRateList() {
		return rateList;
	}

	public void setRateList(List<RateBean> rateList) {
		this.rateList = rateList;
	}

}
