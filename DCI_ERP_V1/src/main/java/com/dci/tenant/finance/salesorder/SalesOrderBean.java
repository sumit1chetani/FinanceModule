package com.dci.tenant.finance.salesorder;

import java.util.List;

public class SalesOrderBean {
	private int salesOrderId;
	private String salesOrderNo;
	private String salesOrderDate;
	private String haspitalCode;
	private String haspitalName;
	private String employeeId;
	private String employeeName;
	private String contactPerson;
	private String customerCode;
	private String customerName;
	private String jobTitleCode;
	private String jobTitleName;
	private String billingAddress;
	private String billingCity;
	private String billingState;
	private String billingCountry;
	private String billingCityCode;
	private String billingStateCode;
	private String billingCountryCode;
	private String billingPinCode;
	private Object select;
	private String deliveryAddress;
	private String deliveryCity;
	private String deliveryCityCode;
	private String deliveryState;
	private String deliveryCountry;
	private String deliveryPinCode;
	private String deliveryStateCode;
	private String deliveryCountryCode;
	private String deliveryPinCodeCode;
	private String status;
	private String customerNote;
	private double totalTax;
	private double totalAmount;
	private double netAmount;
	private String id;
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private List<SalesOrderDtlBean> salesOrderTables;

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getSalesOrderNo() {
		return salesOrderNo;
	}

	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

	public String getSalesOrderDate() {
		return salesOrderDate;
	}

	public void setSalesOrderDate(String salesOrderDate) {
		this.salesOrderDate = salesOrderDate;
	}

	public String getHaspitalCode() {
		return haspitalCode;
	}

	public void setHaspitalCode(String haspitalCode) {
		this.haspitalCode = haspitalCode;
	}

	public String getHaspitalName() {
		return haspitalName;
	}

	public void setHaspitalName(String haspitalName) {
		this.haspitalName = haspitalName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(String jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingPinCode() {
		return billingPinCode;
	}

	public void setBillingPinCode(String billingPinCode) {
		this.billingPinCode = billingPinCode;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public String getDeliveryPinCode() {
		return deliveryPinCode;
	}

	public void setDeliveryPinCode(String deliveryPinCode) {
		this.deliveryPinCode = deliveryPinCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	public String getBillingCityCode() {
		return billingCityCode;
	}

	public void setBillingCityCode(String billingCityCode) {
		this.billingCityCode = billingCityCode;
	}

	public String getBillingStateCode() {
		return billingStateCode;
	}

	public void setBillingStateCode(String billingStateCode) {
		this.billingStateCode = billingStateCode;
	}

	public String getBillingCountryCode() {
		return billingCountryCode;
	}

	public void setBillingCountryCode(String billingCountryCode) {
		this.billingCountryCode = billingCountryCode;
	}

	public String getDeliveryStateCode() {
		return deliveryStateCode;
	}

	public void setDeliveryStateCode(String deliveryStateCode) {
		this.deliveryStateCode = deliveryStateCode;
	}

	public String getDeliveryCountryCode() {
		return deliveryCountryCode;
	}

	public void setDeliveryCountryCode(String deliveryCountryCode) {
		this.deliveryCountryCode = deliveryCountryCode;
	}

	public String getDeliveryPinCodeCode() {
		return deliveryPinCodeCode;
	}

	public void setDeliveryPinCodeCode(String deliveryPinCodeCode) {
		this.deliveryPinCodeCode = deliveryPinCodeCode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public List<SalesOrderDtlBean> getSalesOrderTables() {
		return salesOrderTables;
	}

	public void setSalesOrderTables(List<SalesOrderDtlBean> salesOrderTables) {
		this.salesOrderTables = salesOrderTables;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public String getDeliveryCityCode() {
		return deliveryCityCode;
	}

	public void setDeliveryCityCode(String deliveryCityCode) {
		this.deliveryCityCode = deliveryCityCode;
	}

	public Object getSelect() {
		return select;
	}

	public void setSelect(Object select) {
		this.select = select;
	}

}
