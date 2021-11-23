package com.dci.master.servicepartner;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.CustomerMasterBean;
import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class ServicePartnerResultBean extends BasicResultBean implements Serializable {

	

private List<CustomerMasterBean> customerList;
	private List<CustomerMasterCommDetail2> customerMasterCommDetails;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ServicePartnerBean> lServicePartnerBean;
	
	private ServicePartnerBean servicePartnerBean;
	
	private ServicePartnerBean servicePartner;

	private List<ServicePartnerKeyBean> servicePartnerTable;
	private List<ServicePartnerBean> salesTable;
	private List<SelectivityBean> counryList; 
	private List<SelectivityBean> classificationList;
	private List<SelectivityBean> countryList;
	private List<String> errorList;
	/*private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}*/

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	private String region;
	private String country;
	
	
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
	private List<ServiceMapBean> servicePartnerType;
	private List<SelectivityBean> serviceList; 
	private List<Integer> servicePartnerTypeList;

	public List<SelectivityBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<SelectivityBean> cityList) {
		this.cityList = cityList;
	}

	public List<SelectivityBean> getRegionList() {
		return regionList;
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

	public ServicePartnerBean getServicePartnerBean() {
		return servicePartnerBean;
	}

	public void setServicePartnerBean(ServicePartnerBean servicePartnerBean) {
		this.servicePartnerBean = servicePartnerBean;
	}

	public List<ServicePartnerBean> getlServicePartnerBean() {
		return lServicePartnerBean;
	}

	public void setlServicePartnerBean(List<ServicePartnerBean> lServicePartnerBean) {
		this.lServicePartnerBean = lServicePartnerBean;
	}

	public List<SelectivityBean> getCounryList() {
		return counryList;
	}

	public void setCounryList(List<SelectivityBean> counryList) {
		this.counryList = counryList;
	}

	public ServicePartnerBean getServicePartner() {
		return servicePartner;
	}

	public void setServicePartner(ServicePartnerBean servicePartner) {
		this.servicePartner = servicePartner;
	}



	public List<ServiceMapBean> getServicePartnerType() {
		return servicePartnerType;
	}

	public void setServicePartnerType(List<ServiceMapBean> servicePartnerType) {
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

	public List<ServicePartnerKeyBean> getServicePartnerTable() {
		return servicePartnerTable;
	}

	public void setServicePartnerTable(List<ServicePartnerKeyBean> servicePartnerTable) {
		this.servicePartnerTable = servicePartnerTable;
	}
//kyc
	public List<CustomerMasterBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerMasterBean> customerList) {
		this.customerList = customerList;
	}

	public List<CustomerMasterCommDetail2> getCustomerMasterCommDetails() {
		return customerMasterCommDetails;
	}

	public void setCustomerMasterCommDetails(
			List<CustomerMasterCommDetail2> customerMasterCommDetails2) {
		this.customerMasterCommDetails = customerMasterCommDetails2;
	}

	public List<SelectivityBean> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<SelectivityBean> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ServicePartnerBean> getSalesTable() {
		return salesTable;
	}

	public void setSalesTable(List<ServicePartnerBean> salesTable) {
		this.salesTable = salesTable;
	}

}
