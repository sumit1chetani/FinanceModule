package com.dci.tenant.finance.reports.charterhirestatement;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class CharterHireStatementResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7481669274170968682L;

	private List<CharterHireStatementBean> lCharterHireStatementBean;

	public List<CharterHireStatementBean> getlCharterHireStatementBean() {
		return lCharterHireStatementBean;
	}

	public void setlCharterHireStatementBean(List<CharterHireStatementBean> lCharterHireStatementBean) {
		this.lCharterHireStatementBean = lCharterHireStatementBean;
	}

}
