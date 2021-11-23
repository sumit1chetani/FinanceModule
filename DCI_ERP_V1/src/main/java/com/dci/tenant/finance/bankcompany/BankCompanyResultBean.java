package com.dci.tenant.finance.bankcompany;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class BankCompanyResultBean extends BasicResultBean implements Serializable {

	private List<BankcompanyBean> lAccountHeadMasterBeanBean;

	public List<BankcompanyBean> getlAccountHeadMasterBeanBean() {
		return lAccountHeadMasterBeanBean;
	}

	public void setlAccountHeadMasterBeanBean(List<BankcompanyBean> lAccountHeadMasterBeanBean) {
		this.lAccountHeadMasterBeanBean = lAccountHeadMasterBeanBean;
	}

}
