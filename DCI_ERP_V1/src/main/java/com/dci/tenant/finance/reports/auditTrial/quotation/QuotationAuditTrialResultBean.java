package com.dci.tenant.finance.reports.auditTrial.quotation;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class QuotationAuditTrialResultBean extends BasicResultBean implements Serializable {

	private List<SelectivityBean> employeeList;

	private List<QuotationAuditTrialBean> quotationList;

	public List<QuotationAuditTrialBean> getQuotationList() {
		return quotationList;
	}

	public void setQuotationList(List<QuotationAuditTrialBean> quotationList) {
		this.quotationList = quotationList;
	}

	public List<SelectivityBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<SelectivityBean> employeeList) {
		this.employeeList = employeeList;
	}

}
