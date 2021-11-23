package com.dci.master.setting.manageitemcategory;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ManageItemCategoryResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ManageItemCategoryBean> manageItemCategoryList;

	private List categoryList;

	private List purchaseList;

	private List salesList;

	private List parentCategoryList;

	private List incomeAccountList;

	private List expenseAccountList;

	private List propertyList;

	private List checkCategoryList;

	private List grnAttributeList;

	public List<ManageItemCategoryBean> getManageItemCategoryList() {
		return manageItemCategoryList;
	}

	public void setManageItemCategoryList(List<ManageItemCategoryBean> manageItemCategoryList) {
		this.manageItemCategoryList = manageItemCategoryList;
	}

	public List getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}

	public List getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List purchaseList) {
		this.purchaseList = purchaseList;
	}

	public List getSalesList() {
		return salesList;
	}

	public void setSalesList(List salesList) {
		this.salesList = salesList;
	}

	public List getParentCategoryList() {
		return parentCategoryList;
	}

	public void setParentCategoryList(List parentCategoryList) {
		this.parentCategoryList = parentCategoryList;
	}

	public List getIncomeAccountList() {
		return incomeAccountList;
	}

	public void setIncomeAccountList(List incomeAccountList) {
		this.incomeAccountList = incomeAccountList;
	}

	public List getExpenseAccountList() {
		return expenseAccountList;
	}

	public void setExpenseAccountList(List expenseAccountList) {
		this.expenseAccountList = expenseAccountList;
	}

	public List getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List propertyList) {
		this.propertyList = propertyList;
	}

	public List getCheckCategoryList() {
		return checkCategoryList;
	}

	public void setCheckCategoryList(List checkCategoryList) {
		this.checkCategoryList = checkCategoryList;
	}

	public List getGrnAttributeList() {
		return grnAttributeList;
	}

	public void setGrnAttributeList(List grnAttributeList) {
		this.grnAttributeList = grnAttributeList;
	}

}
