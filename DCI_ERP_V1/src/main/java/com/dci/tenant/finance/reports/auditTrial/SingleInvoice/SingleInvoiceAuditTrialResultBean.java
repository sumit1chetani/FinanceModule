package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SingleInvoiceAuditTrialResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SingleInvoiceAuditTrialBean> singleInvoiceList;
	
	private List<SingleInvoiceAuditTrialBean> customerList;

	public List<SingleInvoiceAuditTrialBean> getSingleInvoiceList() {
		return singleInvoiceList;
	}

	public void setSingleInvoiceList(List<SingleInvoiceAuditTrialBean> singleInvoiceList) {
		this.singleInvoiceList = singleInvoiceList;
	}

	public List<SingleInvoiceAuditTrialBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SingleInvoiceAuditTrialBean> customerList) {
		this.customerList = customerList;
	}


}
