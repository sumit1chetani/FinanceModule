package com.dci.payroll.tds.otherincomemaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class OtherIncomeMasterResultBean extends BasicResultBean implements Serializable {
	private List<OtherIncomeMasterBean> otherIncomeMasterList;
	private OtherIncomeMasterBean otherIncomeMasterBean = null;

	public List<OtherIncomeMasterBean> getOtherIncomeMasterList() {
		return otherIncomeMasterList;
	}

	public void setOtherIncomeMasterList(List<OtherIncomeMasterBean> otherIncomeMasterList) {
		this.otherIncomeMasterList = otherIncomeMasterList;
	}

	public OtherIncomeMasterBean getOtherIncomeMasterBean() {
		return otherIncomeMasterBean;
	}

	public void setOtherIncomeMasterBean(OtherIncomeMasterBean otherIncomeMasterBean) {
		this.otherIncomeMasterBean = otherIncomeMasterBean;
	}
}