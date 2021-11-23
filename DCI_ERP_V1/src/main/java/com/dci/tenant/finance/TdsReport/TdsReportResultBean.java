package com.dci.tenant.finance.TdsReport;

import java.util.List;

public class TdsReportResultBean {

	public Boolean Success;
	public String message;
	private List<TdsReportBean> lQuotationBean;

	private List<TdsReportBean> searchList;

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

	public List<TdsReportBean> getlQuotationBean() {
		return lQuotationBean;
	}

	public void setlQuotationBean(List<TdsReportBean> lQuotationBean) {
		this.lQuotationBean = lQuotationBean;
	}

	public List<TdsReportBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<TdsReportBean> searchList) {
		this.searchList = searchList;
	}

}
