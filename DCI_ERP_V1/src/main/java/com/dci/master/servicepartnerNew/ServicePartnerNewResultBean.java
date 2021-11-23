package com.dci.master.servicepartnerNew;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.CustomerMasterBean;
import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class ServicePartnerNewResultBean extends BasicResultBean implements Serializable {

	

private List<CustomerMasterBean> customerList;
	private List<CustomerMasterNewCommDetail2> customerMasterCommDetails;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ServicePartnerNewBean> lServicePartnerBean;
	private List<ServicePartnerNewBean> servicePartnerCharge;
	
	private List<ServicePartnerNewBean> servicePartnerexcel;


	public List<ServicePartnerNewBean> getServicePartnerCharge() {
		return servicePartnerCharge;
	}

	public void setServicePartnerCharge(List<ServicePartnerNewBean> servicePartnerCharge) {
		this.servicePartnerCharge = servicePartnerCharge;
	}

	private ServicePartnerNewBean servicePartnerBean;
	
	private ServicePartnerNewBean servicePartner;

	private List<ServicePartnerNewKeyBean> servicePartnerTable;
	private List<ServicePartnerNewBean> salesTable;
	private List<SelectivityBean> counryList; 
	private List<SelectivityBean> classificationList;
	private List<SelectivityBean> countryList;
	//private boolean success;
	/*private boolean successs;

	public boolean isSuccesss() {
		return successs;
	}

	public void setSuccesss(boolean successs) {
		this.successs = successs;
	}*/

	/*public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}*/

	private String region;
	private String country;
	private List<String> errorList;

	
	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public List<ServicePartnerNewBean> getServicePartnerexcel() {
		return servicePartnerexcel;
	}

	public void setServicePartnerexcel(List<ServicePartnerNewBean> servicePartnerexcel) {
		this.servicePartnerexcel = servicePartnerexcel;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<SelectivityBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<SelectivityBean> countryList) {
		this.countryList = countryList;
	}

	public List<SelectivityBean> getClassificationList() {
		return classificationList;
		
	}

	public void setClassificationList(List<SelectivityBean> classificationList) {
		this.classificationList = classificationList;
	}

	private List<SelectivityBean> branchList;
	private List<SelectivityBean> cityList;
	private List<SelectivityBean> regionList; 
	private List<SelectivityBean> defaultTypeList; 
	private List<SelectivityBean> gstnStateList;
	private List<SelectivityBean> partnerClassificationList; 
	private List<ServiceNewMapBean> servicePartnerType;
	private List<SelectivityBean> serviceList; 
	private List<Integer> servicePartnerTypeList;
	public String message;
	private String servicePartnerLedgerName;


	public String getServicePartnerLedgerName() {
		return servicePartnerLedgerName;
	}

	public void setServicePartnerLedgerName(String servicePartnerLedgerName) {
		this.servicePartnerLedgerName = servicePartnerLedgerName;
	}

	public List<SelectivityBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<SelectivityBean> cityList) {
		this.cityList = cityList;
	}

	public List<SelectivityBean> getRegionList() {
		return regionList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRegionList(List<SelectivityBean> regionList) {
		this.regionList = regionList;
	}

	public List<SelectivityBean> getDefaultTypeList() {
		return defaultTypeList;
	}

	public void setDefaultTypeList(List<SelectivityBean> defaultTypeList) {
		this.defaultTypeList = defaultTypeList;
	}

	public List<SelectivityBean> getGstnStateList() {
		return gstnStateList;
	}

	public void setGstnStateList(List<SelectivityBean> gstnStateList) {
		this.gstnStateList = gstnStateList;
	}

	public List<SelectivityBean> getPartnerClassificationList() {
		return partnerClassificationList;
	}

	public void setPartnerClassificationList(
			List<SelectivityBean> partnerClassificationList) {
		this.partnerClassificationList = partnerClassificationList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ServicePartnerNewBean getServicePartnerBean() {
		return servicePartnerBean;
	}

	public void setServicePartnerBean(ServicePartnerNewBean servicePartnerBean) {
		this.servicePartnerBean = servicePartnerBean;
	}

	public List<ServicePartnerNewBean> getlServicePartnerBean() {
		return lServicePartnerBean;
	}

	public void setlServicePartnerBean(List<ServicePartnerNewBean> lServicePartnerBean) {
		this.lServicePartnerBean = lServicePartnerBean;
	}

	public List<SelectivityBean> getCounryList() {
		return counryList;
	}

	public void setCounryList(List<SelectivityBean> counryList) {
		this.counryList = counryList;
	}

	public ServicePartnerNewBean getServicePartner() {
		return servicePartner;
	}

	public void setServicePartner(ServicePartnerNewBean servicePartner) {
		this.servicePartner = servicePartner;
	}



	public List<ServiceNewMapBean> getServicePartnerType() {
		return servicePartnerType;
	}

	public void setServicePartnerType(List<ServiceNewMapBean> servicePartnerType) {
		this.servicePartnerType = servicePartnerType;
	}

	public List<SelectivityBean> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<SelectivityBean> branchList) {
		this.branchList = branchList;
	}

	public List<Integer> getServicePartnerTypeList() {
		return servicePartnerTypeList;
	}

	public void setServicePartnerTypeList(List<Integer> servicePartnerTypeList) {
		this.servicePartnerTypeList = servicePartnerTypeList;
	}

	public List<ServicePartnerNewKeyBean> getServicePartnerTable() {
		return servicePartnerTable;
	}

	public void setServicePartnerTable(List<ServicePartnerNewKeyBean> servicePartnerTable) {
		this.servicePartnerTable = servicePartnerTable;
	}
//kyc
	public List<CustomerMasterBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerMasterBean> customerList) {
		this.customerList = customerList;
	}

	public List<CustomerMasterNewCommDetail2> getCustomerMasterCommDetails() {
		return customerMasterCommDetails;
	}

	public void setCustomerMasterCommDetails(
			List<CustomerMasterNewCommDetail2> customerMasterCommDetails2) {
		this.customerMasterCommDetails = customerMasterCommDetails2;
	}

	public List<SelectivityBean> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<SelectivityBean> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ServicePartnerNewBean> getSalesTable() {
		return salesTable;
	}

	public void setSalesTable(List<ServicePartnerNewBean> salesTable) {
		this.salesTable = salesTable;
	}

}
