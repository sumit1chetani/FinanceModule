package com.dci.master.setting.manageitemcategory;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "item_category", formCode = "F3024")
public class ManageItemCategoryBean {

	private String id;
	private String text;
	private String categoryName;
	private String categoryTypeId;
	private String parentCategory;
	private String salesTaxesId;
	private String incomeAccountId;
	private String purchaseTaxesId;
	private String expenseAccountId;
	private String itemCategoryId;
	private String categoryTypeName;
	private String parentCategoryName;
	private String purchaseTaxesName;
	private String salesTaxesName;
	private String expenseAccountName;
	private String incomeAccountName;
	private String qualityCheck = "N";

	private String batchNo = "Y";
	private String mrp = "Y";
	private String expiryDate = "Y";
	private String manufactureDetails = "Y";
	private String grnAttributeId;

	private List<ItemPropertiesBean> manageItemPropertiesList;

	private String parentCategoryId;
	private String itemCategoryAccountId;

	private List propertyDetailList;

	private String propertyTypeId;
	private String propertTypeName;
	private String defName;
	private String tableName;
	private String formCode;	

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(String propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public String getPropertTypeName() {
		return propertTypeName;
	}

	public void setPropertTypeName(String propertTypeName) {
		this.propertTypeName = propertTypeName;
	}

	@AuditLoggable(fieldName = "category_name", displayName = "categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@AuditLoggable(fieldName = "category_type", displayName = "categoryTypeId")
	public String getCategoryTypeId() {
		return categoryTypeId;
	}

	public void setCategoryTypeId(String categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getSalesTaxesId() {
		return salesTaxesId;
	}

	public void setSalesTaxesId(String salesTaxesId) {
		this.salesTaxesId = salesTaxesId;
	}

	public String getIncomeAccountId() {
		return incomeAccountId;
	}

	public void setIncomeAccountId(String incomeAccountId) {
		this.incomeAccountId = incomeAccountId;
	}

	public String getPurchaseTaxesId() {
		return purchaseTaxesId;
	}

	public void setPurchaseTaxesId(String purchaseTaxesId) {
		this.purchaseTaxesId = purchaseTaxesId;
	}

	public String getExpenseAccountId() {
		return expenseAccountId;
	}

	public void setExpenseAccountId(String expenseAccountId) {
		this.expenseAccountId = expenseAccountId;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getCategoryTypeName() {
		return categoryTypeName;
	}

	public void setCategoryTypeName(String categoryTypeName) {
		this.categoryTypeName = categoryTypeName;
	}

	public String getParentCategoryName() {
		return parentCategoryName;
	}

	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}

	public String getPurchaseTaxesName() {
		return purchaseTaxesName;
	}

	public void setPurchaseTaxesName(String purchaseTaxesName) {
		this.purchaseTaxesName = purchaseTaxesName;
	}

	public String getSalesTaxesName() {
		return salesTaxesName;
	}

	public void setSalesTaxesName(String salesTaxesName) {
		this.salesTaxesName = salesTaxesName;
	}

	public String getExpenseAccountName() {
		return expenseAccountName;
	}

	public void setExpenseAccountName(String expenseAccountName) {
		this.expenseAccountName = expenseAccountName;
	}

	public String getIncomeAccountName() {
		return incomeAccountName;
	}

	public void setIncomeAccountName(String incomeAccountName) {
		this.incomeAccountName = incomeAccountName;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getItemCategoryAccountId() {
		return itemCategoryAccountId;
	}

	public void setItemCategoryAccountId(String itemCategoryAccountId) {
		this.itemCategoryAccountId = itemCategoryAccountId;
	}

	public List getPropertyDetailList() {
		return propertyDetailList;
	}

	public void setPropertyDetailList(List propertyDetailList) {
		this.propertyDetailList = propertyDetailList;
	}

	public List<ItemPropertiesBean> getManageItemPropertiesList() {
		return manageItemPropertiesList;
	}

	public void setManageItemPropertiesList(List<ItemPropertiesBean> manageItemPropertiesList) {
		this.manageItemPropertiesList = manageItemPropertiesList;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getManufactureDetails() {
		return manufactureDetails;
	}

	public void setManufactureDetails(String manufactureDetails) {
		this.manufactureDetails = manufactureDetails;
	}

	public String getGrnAttributeId() {
		return grnAttributeId;
	}

	public void setGrnAttributeId(String grnAttributeId) {
		this.grnAttributeId = grnAttributeId;
	}

	public String getDefName() {
		return defName;
	}

	public void setDefName(String defName) {
		this.defName = defName;
	}

}
