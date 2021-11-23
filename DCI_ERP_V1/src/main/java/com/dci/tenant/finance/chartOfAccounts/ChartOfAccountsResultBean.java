package com.dci.tenant.finance.chartOfAccounts;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ChartOfAccountsResultBean extends BasicResultBean {

	private static final long serialVersionUID = 6805986863083414881L;

	private List<ChartOfAccountsBean> lChartOfAccountsBean;

	public List<ChartOfAccountsBean> getlChartOfAccountsBean() {
		return lChartOfAccountsBean;
	}

	public void setlChartOfAccountsBean(List<ChartOfAccountsBean> lChartOfAccountsBean) {
		this.lChartOfAccountsBean = lChartOfAccountsBean;
	}

}
