package com.dci.finance.closingPeriod;

import java.util.List;

public class ClosingPeriodresultBean {

	private static final long serialVersionUID = 1L;

	private List<ClosingPeriodBean> lClosingAccount;

	private List<ClosingPeriodBean> lGrounpCode;

	public List<ClosingPeriodBean> getlClosingAccount() {
		return lClosingAccount;
	}

	public void setlClosingAccount(List<ClosingPeriodBean> lClosingAccount) {
		this.lClosingAccount = lClosingAccount;
	}

	public List<ClosingPeriodBean> getlGrounpCode() {
		return lGrounpCode;
	}

	public void setlGrounpCode(List<ClosingPeriodBean> lGrounpCode) {
		this.lGrounpCode = lGrounpCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
