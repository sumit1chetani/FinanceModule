package com.dci.tenant.finance.manageCustomer;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.BasicResultBean;

public class ManageCustomerResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CommonUtilityBean> mainCityList;
	private List<ManageCustomerBean> shippingCityList;
	private List<ManageCustomerBean> deliveryCityList;
	private List<ManageCustomerBean> billingCityList;

	private List<ManageCustomerBean> paymentList;;
	private List<ManageCustomerBankBean> accountTypeList;
	private List<ManageCustomerBean> lManageCustomerBean;
	private List<CommonUtilityBean> locationList;

	public List<CommonUtilityBean> getMainCityList() {
		return mainCityList;
	}

	public void setMainCityList(List<CommonUtilityBean> mainCityList) {
		this.mainCityList = mainCityList;
	}

	public List<ManageCustomerBean> getShiftSchemeMasterList() {
		return shiftSchemeMasterList;
	}

	public void setShiftSchemeMasterList(List<ManageCustomerBean> shiftSchemeMasterList) {
		this.shiftSchemeMasterList = shiftSchemeMasterList;
	}

	public List getShiftNameList() {
		return shiftNameList;
	}

	public void setShiftNameList(List shiftNameList) {
		this.shiftNameList = shiftNameList;
	}

	public ManageCustomerBean getShiftSchemeMaster() {
		return shiftSchemeMaster;
	}

	public void setShiftSchemeMaster(ManageCustomerBean shiftSchemeMaster) {
		this.shiftSchemeMaster = shiftSchemeMaster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<ManageCustomerBean> shiftSchemeMasterList;

	private List shiftNameList;

	private ManageCustomerBean shiftSchemeMaster = new ManageCustomerBean();

	public List<ManageCustomerBean> getlManageCustomerBean() {
		return lManageCustomerBean;
	}

	public void setlManageCustomerBean(List<ManageCustomerBean> lManageCustomerBean) {
		this.lManageCustomerBean = lManageCustomerBean;
	}

	public List<ManageCustomerBean> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<ManageCustomerBean> paymentList) {
		this.paymentList = paymentList;
	}

	public List<ManageCustomerBankBean> getAccountTypeList() {
		return accountTypeList;
	}

	public void setAccountTypeList(List<ManageCustomerBankBean> accountTypeList) {
		this.accountTypeList = accountTypeList;
	}

	public List<ManageCustomerBean> getShippingCityList() {
		return shippingCityList;
	}

	public void setShippingCityList(List<ManageCustomerBean> shippingCityList) {
		this.shippingCityList = shippingCityList;
	}

	public List<ManageCustomerBean> getDeliveryCityList() {
		return deliveryCityList;
	}

	public void setDeliveryCityList(List<ManageCustomerBean> deliveryCityList) {
		this.deliveryCityList = deliveryCityList;
	}

	public List<ManageCustomerBean> getBillingCityList() {
		return billingCityList;
	}

	public void setBillingCityList(List<ManageCustomerBean> billingCityList) {
		this.billingCityList = billingCityList;
	}

	public List<CommonUtilityBean> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<CommonUtilityBean> locationList) {
		this.locationList = locationList;
	}

}
