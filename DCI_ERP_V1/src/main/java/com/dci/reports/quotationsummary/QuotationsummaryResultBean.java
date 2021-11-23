package com.dci.reports.quotationsummary;
import java.util.List;

public class QuotationsummaryResultBean {

	
	public Boolean Success;
	public String message;
	private List<QuotationsummaryBean> searchList;
	private List<QuotationsummaryBean> lFormMasterBean;

	
	
	public List<QuotationsummaryBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	public void setlFormMasterBean(List<QuotationsummaryBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

	public List<QuotationsummaryBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<QuotationsummaryBean> searchList) {
		this.searchList = searchList;
	}

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
	
	
}
