package com.dci.tenant.finance.chartOfAccounts;

import java.util.List;

public interface ChartOfAccountsDAO {

	public List<ChartOfAccountsBean> getGroupHeadList();

	public List<ChartOfAccountsBean> getSubGroupHeadList(String groupHeadCode);

	public List<ChartOfAccountsBean> getAccountHeadList(String subGroupAcctCode);

	public List<ChartOfAccountsBean> getChartOfAccountsList();

}
