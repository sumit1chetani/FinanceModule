package com.dci.tenant.finance.payableAgewise;

import java.util.List;

import com.dci.common.util.BasicResultBean;

@SuppressWarnings("serial")
public class PayableAgewiseResultBean extends BasicResultBean {

	private List<PayableAgewiseBean> lPayableAgewiseList;

	public List<PayableAgewiseBean> getlPayableAgewiseList() {
		return lPayableAgewiseList;
	}

	public void setlPayableAgewiseList(List<PayableAgewiseBean> lPayableAgewiseList) {
		this.lPayableAgewiseList = lPayableAgewiseList;
	}

}
