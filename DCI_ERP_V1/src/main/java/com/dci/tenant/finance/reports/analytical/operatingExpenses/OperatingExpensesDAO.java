package com.dci.tenant.finance.reports.analytical.operatingExpenses;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface OperatingExpensesDAO {


	public List<SelectivityBean> setVoyageList(OperatingExpensesBean expensesBean);

	public List<SelectivityBean> getVesselList(OperatingExpensesBean expensesBean);

	public List<SelectivityBean> getAccoundHeadList(OperatingExpensesBean expensesBean);

	public List<OperatingExpensesBean> getMainReport(OperatingExpensesBean expensesBean);

	public List<OperatingExpensesBean> getSubReport(OperatingExpensesBean expensesBean);

	public List<SelectivityBean> getCompanyList(OperatingExpensesBean expensesBean);
	
	public List<SelectivityBean> getGroupHeadList();
	public List<SelectivityBean> getLocationList();
	public List<SelectivityBean> getLocationList1(String brnch) ;


}
