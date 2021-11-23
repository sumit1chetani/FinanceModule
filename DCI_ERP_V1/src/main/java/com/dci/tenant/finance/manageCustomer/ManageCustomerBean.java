package com.dci.tenant.finance.manageCustomer;

import java.util.ArrayList;

public class ManageCustomerBean {

	private int entityId;
	private String entityName;
	private String contactPerson;
	private String jobPosition;
	private String phoneNo;
	private String mobile;
	private String email;
	private String fax;
	private String url;
	private String website;
	private String tinNumber;
	private String cstNumber;
	private String gstNumber;

	private String totalReceivable;
	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	private String desState;
	private String panNumber;

	private String locationAddress;
	private String internalNotes;

	private String accountPayable;
	private String customerPayment;
	private String custCredit;

	private String isVendor;
	private String isCollege;
	private String isCustomer;
	private String isOthers;
	private String isActive;
	private String responsiblePersonSales; // Responsible Person Sales

	private String responsiblePersonPurchase;
	private Integer customerLocation;
	private Integer vendorLocation;
	private String deliveryMethod;
	private Integer creditLimit;
	private Integer vendorCreditLimit;
	private int addressId;

	private String desZipcode;
	private String desCountry;
	private String desStateCode;
	private String desCountryCode;

	private int city;
	private int cityId;
	private String cityName;
	private String stateCode;
	private String stateName;
	private String pincode;
	private String countryCode;
	private String countryName;

	private String customerAcctCode;
	private String supplierAcctCode;
	private String entityAcctCode;

	private Integer custPaymentTerm;
	private Integer vendorPaymentTerm;
	private Integer paymentId;
	private String paymentTerms;

	private String currencyCode;

	private String screenName;

	// Selectivity
	private String id;
	private String text;

	private ArrayList<ManageCustomerAddressBean> customerAddressobj = new ArrayList<ManageCustomerAddressBean>();
	private ArrayList<ManageCustomerBankBean> customerBankobj = new ArrayList<ManageCustomerBankBean>();
	private ArrayList<ManageCustomerContactBean> customerContactobj = new ArrayList<ManageCustomerContactBean>();

	// Address Tab
	private String shipAddress;
	private String billingAddress;
	private String deliveryAddress;

	// Shipping Address
	private Integer cityAddressId;
	private String cityNameAddress;

	// Billing Address
	private Integer citybillingId;
	private String cityNameBilling;

	// Delivery Address
	private Integer citydeliveryId;
	private String cityNameDelivery;

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

	public ArrayList<ManageCustomerAddressBean> getCustomerAddressobj() {
		return customerAddressobj;
	}

	public void setCustomerAddressobj(ArrayList<ManageCustomerAddressBean> customerAddressobj) {
		this.customerAddressobj = customerAddressobj;
	}

	public ArrayList<ManageCustomerBankBean> getCustomerBankobj() {
		return customerBankobj;
	}

	public void setCustomerBankobj(ArrayList<ManageCustomerBankBean> customerBankobj) {
		this.customerBankobj = customerBankobj;
	}

	public ArrayList<ManageCustomerContactBean> getCustomerContactobj() {
		return customerContactobj;
	}

	public void setCustomerContactobj(ArrayList<ManageCustomerContactBean> customerContactobj) {
		this.customerContactobj = customerContactobj;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesState() {
		return desState;
	}

	public void setDesState(String desState) {
		this.desState = desState;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getInternalNotes() {
		return internalNotes;
	}

	public void setInternalNotes(String internalNotes) {
		this.internalNotes = internalNotes;
	}

	public String getAccountPayable() {
		return accountPayable;
	}

	public void setAccountPayable(String accountPayable) {
		this.accountPayable = accountPayable;
	}

	public String getCustomerPayment() {
		return customerPayment;
	}

	public void setCustomerPayment(String customerPayment) {
		this.customerPayment = customerPayment;
	}

	public String getCustCredit() {
		return custCredit;
	}

	public void setCustCredit(String custCredit) {
		this.custCredit = custCredit;
	}

	public String getIsVendor() {
		return isVendor;
	}

	public void setIsVendor(String isVendor) {
		this.isVendor = isVendor;
	}

	public String getIsOthers() {
		return isOthers;
	}

	public void setIsOthers(String isOthers) {
		this.isOthers = isOthers;
	}

	public String getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getResponsiblePersonSales() {
		return responsiblePersonSales;
	}

	public void setResponsiblePersonSales(String responsiblePersonSales) {
		this.responsiblePersonSales = responsiblePersonSales;
	}

	public Integer getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getDesZipcode() {
		return desZipcode;
	}

	public void setDesZipcode(String desZipcode) {
		this.desZipcode = desZipcode;
	}

	public String getDesCountry() {
		return desCountry;
	}

	public void setDesCountry(String desCountry) {
		this.desCountry = desCountry;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDesStateCode() {
		return desStateCode;
	}

	public void setDesStateCode(String desStateCode) {
		this.desStateCode = desStateCode;
	}

	public String getDesCountryCode() {
		return desCountryCode;
	}

	public void setDesCountryCode(String desCountryCode) {
		this.desCountryCode = desCountryCode;
	}

	public String getCustomerAcctCode() {
		return customerAcctCode;
	}

	public void setCustomerAcctCode(String customerAcctCode) {
		this.customerAcctCode = customerAcctCode;
	}

	public String getSupplierAcctCode() {
		return supplierAcctCode;
	}

	public void setSupplierAcctCode(String supplierAcctCode) {
		this.supplierAcctCode = supplierAcctCode;
	}

	public String getEntityAcctCode() {
		return entityAcctCode;
	}

	public void setEntityAcctCode(String entityAcctCode) {
		this.entityAcctCode = entityAcctCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}

	public String getCstNumber() {
		return cstNumber;
	}

	public void setCstNumber(String cstNumber) {
		this.cstNumber = cstNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Integer getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(Integer customerLocation) {
		this.customerLocation = customerLocation;
	}

	public Integer getCustPaymentTerm() {
		return custPaymentTerm;
	}

	public void setCustPaymentTerm(Integer custPaymentTerm) {
		this.custPaymentTerm = custPaymentTerm;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getCityAddressId() {
		return cityAddressId;
	}

	public void setCityAddressId(Integer cityAddressId) {
		this.cityAddressId = cityAddressId;
	}

	public String getCityNameAddress() {
		return cityNameAddress;
	}

	public void setCityNameAddress(String cityNameAddress) {
		this.cityNameAddress = cityNameAddress;
	}

	public Integer getCitybillingId() {
		return citybillingId;
	}

	public void setCitybillingId(Integer citybillingId) {
		this.citybillingId = citybillingId;
	}

	public String getCityNameBilling() {
		return cityNameBilling;
	}

	public void setCityNameBilling(String cityNameBilling) {
		this.cityNameBilling = cityNameBilling;
	}

	public Integer getCitydeliveryId() {
		return citydeliveryId;
	}

	public void setCitydeliveryId(Integer citydeliveryId) {
		this.citydeliveryId = citydeliveryId;
	}

	public String getCityNameDelivery() {
		return cityNameDelivery;
	}

	public void setCityNameDelivery(String cityNameDelivery) {
		this.cityNameDelivery = cityNameDelivery;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getResponsiblePersonPurchase() {
		return responsiblePersonPurchase;
	}

	public void setResponsiblePersonPurchase(String responsiblePersonPurchase) {
		this.responsiblePersonPurchase = responsiblePersonPurchase;
	}

	public Integer getVendorCreditLimit() {
		return vendorCreditLimit;
	}

	public void setVendorCreditLimit(Integer vendorCreditLimit) {
		this.vendorCreditLimit = vendorCreditLimit;
	}

	public Integer getVendorPaymentTerm() {
		return vendorPaymentTerm;
	}

	public void setVendorPaymentTerm(Integer vendorPaymentTerm) {
		this.vendorPaymentTerm = vendorPaymentTerm;
	}

	public Integer getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(Integer vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public String getIsCollege() {
		return isCollege;
	}

	public void setIsCollege(String isCollege) {
		this.isCollege = isCollege;
	}

	public String getTotalReceivable() {
		return totalReceivable;
	}

	public void setTotalReceivable(String totalReceivable) {
		this.totalReceivable = totalReceivable;
	}
	
	

	
}
