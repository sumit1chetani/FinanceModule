package com.dci.tenant.finance.BudgetReport;

import java.util.List;

public class BudgetReportResultBean {

	public Boolean Success;
	public String message;
	private List<BudgetReportBean> lQuotationBean;

	private List<BudgetReportBean> searchList;

	public Boolean getSuccess() {
		return Success;
	}

	public void setSuccess(Boolean success) {
		Success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BudgetReportBean> getlQuotationBean() {
		return lQuotationBean;
	}

	public void setlQuotationBean(List<BudgetReportBean> lQuotationBean) {
		this.lQuotationBean = lQuotationBean;
	}

	public List<BudgetReportBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<BudgetReportBean> searchList) {
		this.searchList = searchList;
	}

}
