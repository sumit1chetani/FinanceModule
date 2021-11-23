package com.dci.tenant.finance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class RebateFreightRefundResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<RebateFreightRefundBean> rebateFreightRefundBeanList;
	List<SelectivityBean> customerList = new ArrayList<SelectivityBean>();
	List<SelectivityBean> invoiceList = new ArrayList<SelectivityBean>();
	List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
	List<SelectivityBean> quotationList = new ArrayList<SelectivityBean>();
	List<SelectivityBean> portList = new ArrayList<SelectivityBean>();

	public List<RebateFreightRefundBean> getRebateFreightRefundBeanList() {
		return rebateFreightRefundBeanList;
	}

	public void setRebateFreightRefundBeanList(List<RebateFreightRefundBean> rebateFreightRefundBeanList) {
		this.rebateFreightRefundBeanList = rebateFreightRefundBeanList;
	}

	public List<SelectivityBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SelectivityBean> customerList) {
		this.customerList = customerList;
	}

	public List<SelectivityBean> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<SelectivityBean> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public List<SelectivityBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<SelectivityBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<SelectivityBean> getQuotationList() {
		return quotationList;
	}

	public void setQuotationList(List<SelectivityBean> quotationList) {
		this.quotationList = quotationList;
	}

	public List<SelectivityBean> getPortList() {
		return portList;
	}

	public void setPortList(List<SelectivityBean> portList) {
		this.portList = portList;
	}

}
