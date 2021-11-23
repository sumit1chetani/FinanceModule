package com.dci.tenant.finance.TDSForm;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class TDSFormResultBean extends BasicResultBean implements Serializable {

	private List<TDSFormBean> lAccountHeadMasterBeanBean;

	public List<TDSFormBean> getlAccountHeadMasterBeanBean() {
		return lAccountHeadMasterBeanBean;
	}

	public void setlAccountHeadMasterBeanBean(List<TDSFormBean> lAccountHeadMasterBeanBean) {
		this.lAccountHeadMasterBeanBean = lAccountHeadMasterBeanBean;
	}

}
