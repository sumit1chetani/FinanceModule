package com.dci.common.model;


import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class CustomerMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customerCode;

	private List<CustomerMasterBean> customerList;
	private List<SelectivityBean> customerNames;
	private boolean isAgent;
	private boolean success;

	private List<SelectivityBean> countryList;
	private List<SelectivityBean> currencyList;
	private List<SelectivityBean> paymentCenterList;
	private List<SelectivityBean> cityList;
	private List<SelectivityBean> customerTypeList;
	private List<SelectivityBean> currencyCategoryList;
	private List<SelectivityBean> controllingAgentList;
	private List<SelectivityBean> portList;
	private List<SelectivityBean> payerList;
	private boolean isExists;
	private boolean isCustomerNameExists;
	private List<SelectivityBean> employeeList;
	private List<CustomMasterBean> customerMasterCommDetails;

	private List<SelectivityBean> referralList;

	public List<SelectivityBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<SelectivityBean> currencyList) {
		this.currencyList = currencyList;
	}

	public List<SelectivityBean> getPaymentCenterList() {
		return paymentCenterList;
	}

	public void setPaymentCenterList(List<SelectivityBean> paymentCenterList) {
		this.paymentCenterList = paymentCenterList;
	}

	public List<SelectivityBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<SelectivityBean> cityList) {
		this.cityList = cityList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CustomerMasterBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerMasterBean> customerList) {
		this.customerList = customerList;
	}

	public List<SelectivityBean> getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(List<SelectivityBean> customerNames) {
		this.customerNames = customerNames;
	}

	public List<SelectivityBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<SelectivityBean> countryList) {
		this.countryList = countryList;
	}

	public List<SelectivityBean> getCustomerTypeList() {
		return customerTypeList;
	}

	public void setCustomerTypeList(List<SelectivityBean> customerTypeList) {
		this.customerTypeList = customerTypeList;
	}

	public List<SelectivityBean> getCurrencyCategoryList() {
		return currencyCategoryList;
	}

	public void setCurrencyCategoryList(List<SelectivityBean> currencyCategoryList) {
		this.currencyCategoryList = currencyCategoryList;
	}

	public List<SelectivityBean> getControllingAgentList() {
		return controllingAgentList;
	}

	public void setControllingAgentList(List<SelectivityBean> controllingAgentList) {
		this.controllingAgentList = controllingAgentList;
	}

	public List<SelectivityBean> getPortList() {
		return portList;
	}

	public void setPortList(List<SelectivityBean> portList) {
		this.portList = portList;
	}

	public List<SelectivityBean> getPayerList() {
		return payerList;
	}

	public void setPayerList(List<SelectivityBean> payerList) {
		this.payerList = payerList;
	}

	public boolean getIsExists() {
		return isExists;
	}

	public void setIsExists(boolean isExists) {
		this.isExists = isExists;
	}

	public List<SelectivityBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<SelectivityBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<CustomMasterBean> getCustomerMasterCommDetails() {
		return customerMasterCommDetails;
	}

	public void setCustomerMasterCommDetails(List<CustomMasterBean> customerMasterCommDetails2) {
		this.customerMasterCommDetails = customerMasterCommDetails2;
	}

	public List<SelectivityBean> getReferralList() {
		return referralList;
	}

	public void setReferralList(List<SelectivityBean> referralList) {
		this.referralList = referralList;
	}

	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public boolean isCustomerNameExists() {
		return isCustomerNameExists;
	}

	public void setCustomerNameExists(boolean isCustomerNameExists) {
		this.isCustomerNameExists = isCustomerNameExists;
	}

	public boolean isAgent() {
		return isAgent;
	}

	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setType(String string) {
		// TODO Auto-generated method stub
		
	}

}
