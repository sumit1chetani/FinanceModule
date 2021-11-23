package com.dci.tenant.finance.openingbalanceupload;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class OpeningBalanceResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<OpeningBalanceBean> openingBalanceList;
	private List<SelectivityBean> companyList;
	private List<SelectivityBean> currecncyList;
	private List<SelectivityBean> customerList;
	private List<OpeningBalanceBean> balanceBean;
	private OpeningBalanceBean bean;

	private OpeningBalanceBean openingBalance = new OpeningBalanceBean();

	public OpeningBalanceBean getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(OpeningBalanceBean openingBalance) {
		this.openingBalance = openingBalance;
	}

	public OpeningBalanceBean getBean() {
		return bean;
	}

	public void setBean(OpeningBalanceBean bean) {
		this.bean = bean;
	}

	public List<OpeningBalanceBean> getBalanceBean() {
		return balanceBean;
	}

	public void setBalanceBean(List<OpeningBalanceBean> balanceBean) {
		this.balanceBean = balanceBean;
	}

	public List<SelectivityBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectivityBean> companyList) {
		this.companyList = companyList;
	}

	public List<SelectivityBean> getCurrecncyList() {
		return currecncyList;
	}

	public void setCurrecncyList(List<SelectivityBean> currecncyList) {
		this.currecncyList = currecncyList;
	}

	public List<SelectivityBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SelectivityBean> customerList) {
		this.customerList = customerList;
	}

	public List<OpeningBalanceBean> getOpeningBalanceList() {
		return openingBalanceList;
	}

	public void setOpeningBalanceList(List<OpeningBalanceBean> openingBalanceList) {
		this.openingBalanceList = openingBalanceList;
	}

}
