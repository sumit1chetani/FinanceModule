package com.dci.common.model;

public class CustomerMasterBean {
	private String customerCode;
	private String customerName;
	private String customerShortName;
	private String countryName;
	private String financeAttn;
	private String invoiceEmailId;
	private String isVesselGrp;
	private String paymentCenter;
	private String active;
	private String acctHead;
	private String salesPerson;
	
	
	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getFinanceAttn() {
		return financeAttn;
	}

	public void setFinanceAttn(String financeAttn) {
		this.financeAttn = financeAttn;
	}

	public String getInvoiceEmailId() {
		return invoiceEmailId;
	}

	public void setInvoiceEmailId(String invoiceEmailId) {
		this.invoiceEmailId = invoiceEmailId;
	}


	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsVesselGrp() {
		return isVesselGrp;
	}

	public void setIsVesselGrp(String isVesselGrp) {
		this.isVesselGrp = isVesselGrp;
	}

	public String getPaymentCenter() {
		return paymentCenter;
	}

	public void setPaymentCenter(String paymentCenter) {
		this.paymentCenter = paymentCenter;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAcctHead() {
		return acctHead;
	}

	public void setAcctHead(String acctHead) {
		this.acctHead = acctHead;
	}
	
	

}
