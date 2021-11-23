package com.dci.tenant.finance.accounthead;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

/*import com.feedertech.core.util.BasicResultBean;*/

public class AccountHeadMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<AccountHeadMasterBean> lAccountHeadMasterBeanBean;

	private List<AccountHeadMasterBean> searchList;

	public List<AccountHeadMasterBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<AccountHeadMasterBean> searchList) {
		this.searchList = searchList;
	}

	public List<AccountHeadMasterBean> getlAccountHeadMasterBeanBean() {
		return lAccountHeadMasterBeanBean;
	}

	public void setlAccountHeadMasterBeanBean(List<AccountHeadMasterBean> lAccountHeadMasterBeanBean) {

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
