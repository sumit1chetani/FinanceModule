package com.dci.tenant.finance.receivableAgewise;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class ReceivableAgewiseResultBean extends BasicResultBean {

	private List<ReceivableAgewiseBean> lReceivableAgewiseList;

	public List<ReceivableAgewiseBean> getlReceivableAgewiseList() {
		return lReceivableAgewiseList;
	}

	public void setlReceivableAgewiseList(List<ReceivableAgewiseBean> lReceivableAgewiseList) {
		this.lReceivableAgewiseList = lReceivableAgewiseList;
	}

}
