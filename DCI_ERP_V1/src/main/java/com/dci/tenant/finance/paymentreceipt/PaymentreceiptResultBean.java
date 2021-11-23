package com.dci.tenant.finance.paymentreceipt;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

/*import com.feedertech.core.util.BasicResultBean;*/

public class PaymentreceiptResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<PaymentreceiptMasterBean> lAccountHeadMasterBeanBean;

	private List<PaymentreceiptMasterBean> searchList;

	public List<PaymentreceiptMasterBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<PaymentreceiptMasterBean> searchList) {
		this.searchList = searchList;
	}

	public List<PaymentreceiptMasterBean> getlAccountHeadMasterBeanBean() {
		return lAccountHeadMasterBeanBean;
	}

	public void setlAccountHeadMasterBeanBean(List<PaymentreceiptMasterBean> lAccountHeadMasterBeanBean) {

		this.lAccountHeadMasterBeanBean = lAccountHeadMasterBeanBean;
	}

	private List subGroupHeadList;

	public List getSubGroupHeadList() {
		return subGroupHeadList;
	}

	public void setSubGroupHeadList(List subGroupHeadList) {
		this.subGroupHeadList = subGroupHeadList;
	}

	private List currencyList;

	public List getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List currencyList) {
		this.currencyList = currencyList;
	}

}
