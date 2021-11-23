package com.dci.tenant.finance.salesorder;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class SalesOrderResultBean extends BasicResultBean implements Serializable {

	private List<SalesOrderBean> salesOrderBeanList;
	private List<SalesOrderBean> employeeList;
	private List<SalesOrderBean> cityList;
	private List<SalesOrderBean> cityList1;
	private List<SalesOrderBean> companyList;
	private List<SalesOrderBean> customerList;
	List<SalesOrderDtlBean> itemList;
	List<SalesOrderDtlBean> taxList;

	public List<SalesOrderBean> getSalesOrderBeanList() {
		return salesOrderBeanList;
	}

	public void setSalesOrderBeanList(List<SalesOrderBean> salesOrderBeanList) {
		this.salesOrderBeanList = salesOrderBeanList;
	}

	public List<SalesOrderBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<SalesOrderBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<SalesOrderBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<SalesOrderBean> cityList) {
		this.cityList = cityList;
	}

	public List<SalesOrderBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SalesOrderBean> companyList) {
		this.companyList = companyList;
	}

	public List<SalesOrderBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SalesOrderBean> customerList) {
		this.customerList = customerList;
	}

	public List<SalesOrderBean> getCityList1() {
		return cityList1;
	}

	public void setCityList1(List<SalesOrderBean> cityList1) {
		this.cityList1 = cityList1;
	}

	public List<SalesOrderDtlBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<SalesOrderDtlBean> itemList) {
		this.itemList = itemList;
	}

	public List<SalesOrderDtlBean> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<SalesOrderDtlBean> taxList) {
		this.taxList = taxList;
	}

}
