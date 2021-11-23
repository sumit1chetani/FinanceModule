package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

import java.util.List;

import com.dci.common.util.BasicResultBean;

public class AdminBudgetAndProjectionResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6807924160358664096L;

	private List<AdminBudgetAndProjectionBean> lAdminBudgetAndProjectionBean;
	private AdminBudgetAndProjectionBean adminBudgetProjectionBean = new AdminBudgetAndProjectionBean();

	public List<AdminBudgetAndProjectionBean> getlAdminBudgetAndProjectionBean() {
		return lAdminBudgetAndProjectionBean;
	}

	public void setlAdminBudgetAndProjectionBean(List<AdminBudgetAndProjectionBean> lAdminBudgetAndProjectionBean) {
		this.lAdminBudgetAndProjectionBean = lAdminBudgetAndProjectionBean;
	}

	public AdminBudgetAndProjectionBean getAdminBudgetProjectionBean() {
		return adminBudgetProjectionBean;
	}

	public void setAdminBudgetProjectionBean(AdminBudgetAndProjectionBean adminBudgetProjectionBean) {
		this.adminBudgetProjectionBean = adminBudgetProjectionBean;
	}

}
