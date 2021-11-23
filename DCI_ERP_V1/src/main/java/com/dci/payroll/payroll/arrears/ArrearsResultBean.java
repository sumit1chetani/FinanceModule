package com.dci.payroll.payroll.arrears;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class ArrearsResultBean extends BasicResultBean implements Serializable {
	private List<ArrearsBean> arrearsBeanList;
	private ArrearsBean arrearsBean = null;

	public List<ArrearsBean> getArrearsBeanList() {
		return arrearsBeanList;
	}

	public void setArrearsBeanList(List<ArrearsBean> arrearsBeanList) {
		this.arrearsBeanList = arrearsBeanList;
	}

	public ArrearsBean getArrearsBean() {
		return arrearsBean;
	}

	public void setArrearsBean(ArrearsBean arrearsBean) {
		this.arrearsBean = arrearsBean;
	}
}
