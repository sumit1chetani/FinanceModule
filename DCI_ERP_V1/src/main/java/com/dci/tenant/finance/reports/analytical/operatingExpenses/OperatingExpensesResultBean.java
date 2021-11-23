package com.dci.tenant.finance.reports.analytical.operatingExpenses;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class OperatingExpensesResultBean extends BasicResultBean {

	private List<SelectivityBean> vesselList;

	private List<SelectivityBean> voyageList;
	private List<SelectivityBean> locationList;
	private List<SelectivityBean> serviceList;

	private List<SelectivityBean> accountHeadList;

	private List<OperatingExpensesBean> mainReport;

	private List<OperatingExpensesBean> subReport;

	private List<SelectivityBean> companyList;

	public List<SelectivityBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<SelectivityBean> vesselList) {
		this.vesselList = vesselList;
	}

	public List<SelectivityBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<SelectivityBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<SelectivityBean> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<SelectivityBean> serviceList) {
		this.serviceList = serviceList;
	}

	public List<SelectivityBean> getAccountHeadList() {
		return accountHeadList;
	}

	public void setAccountHeadList(List<SelectivityBean> accountHeadList) {
		this.accountHeadList = accountHeadList;
	}

	public List<OperatingExpensesBean> getMainReport() {
		return mainReport;
	}

	public void setMainReport(List<OperatingExpensesBean> mainReport) {
		this.mainReport = mainReport;
	}

	public List<OperatingExpensesBean> getSubReport() {
		return subReport;
	}

	public void setSubReport(List<OperatingExpensesBean> subReport) {
		this.subReport = subReport;
	}

	public List<SelectivityBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectivityBean> companyList) {
		this.companyList = companyList;
	}

	public void setLocationList(List<SelectivityBean> locationList2) {
		// TODO Auto-generated method stub
		
	}

}
