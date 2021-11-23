package com.dci.master.setting.manageitemcategory;

import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "item_category", formCode = "F3024")
public class ManageItemCategoryPropertyBean {

	private String propertyType;
	private String propName;
	private String propLength;
	private String propValue;
	private String defaultValSingleDropProp;
	private String manditory = "Y";
	private String dateName;
	private String lengthValue;
	private double decimalValue;
	private String defaultsValue;
	private String defaultValueList;
	private String typeId;
	private String typeName;
	private String isSelected = "Y";
	private boolean select = false;
	private String qualityCheck = "N";
	private String batchNo = "Y";
	private String mrp = "Y";
	private String expiryDate = "Y";
	private String manufactureDetails = "Y";
	private String grnAttributeId;
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

	public String getGrnAttributeId() {
		return grnAttributeId;
	}

	public void setGrnAttributeId(String grnAttributeId) {
		this.grnAttributeId = grnAttributeId;
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

	private String propertyTypeName;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private String itemPropertiesId;

	private String id;
	private String text;

	private String defaultValueId;
	private String defaultValueName;

	public String getDefaultValueId() {
		return defaultValueId;
	}

	public void setDefaultValueId(String defaultValueId) {
		this.defaultValueId = defaultValueId;
	}

	public String getDefaultValueName() {
		return defaultValueName;
	}

	public void setDefaultValueName(String defaultValueName) {
		this.defaultValueName = defaultValueName;
	}

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

	private List colors;

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropLength() {
		return propLength;
	}

	public void setPropLength(String propLength) {
		this.propLength = propLength;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public String getDefaultValSingleDropProp() {
		return defaultValSingleDropProp;
	}

	public void setDefaultValSingleDropProp(String defaultValSingleDropProp) {
		this.defaultValSingleDropProp = defaultValSingleDropProp;
	}

	public String getManditory() {
		return manditory;
	}

	public void setManditory(String manditory) {
		this.manditory = manditory;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public String getLengthValue() {
		return lengthValue;
	}

	public void setLengthValue(String lengthValue) {
		this.lengthValue = lengthValue;
	}

	public double getDecimalValue() {
		return decimalValue;
	}

	public void setDecimalValue(double decimalValue) {
		this.decimalValue = decimalValue;
	}

	public String getDefaultsValue() {
		return defaultsValue;
	}

	public void setDefaultsValue(String defaultsValue) {
		this.defaultsValue = defaultsValue;
	}

	public String getDefaultValueList() {
		return defaultValueList;
	}

	public void setDefaultValueList(String defaultValueList) {
		this.defaultValueList = defaultValueList;
	}

	public List getColors() {
		return colors;
	}

	public void setColors(List colors) {
		this.colors = colors;
	}

	public String getItemPropertiesId() {
		return itemPropertiesId;
	}

	public void setItemPropertiesId(String itemPropertiesId) {
		this.itemPropertiesId = itemPropertiesId;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

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

	private String parentCategoryId;
	private String itemCategoryAccountId;

	private List<ManageItemCategoryPropertyBean> propertyDetailList;

	private List<ManageItemCategoryPropertyBean> deletedIds;

	private String propertyTypeId;
	private String propertTypeName;

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

	public List<ManageItemCategoryPropertyBean> getPropertyDetailList() {
		return propertyDetailList;
	}

	public void setPropertyDetailList(List<ManageItemCategoryPropertyBean> propertyDetailList) {
		this.propertyDetailList = propertyDetailList;
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	public String getItemCategoryPropertyId() {
		return itemCategoryPropertyId;
	}

	public void setItemCategoryPropertyId(String itemCategoryPropertyId) {
		this.itemCategoryPropertyId = itemCategoryPropertyId;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public List<ManageItemCategoryPropertyBean> getDeletedIds() {
		return deletedIds;
	}

	public void setDeletedIds(List<ManageItemCategoryPropertyBean> deletedIds) {
		this.deletedIds = deletedIds;
	}

	private String itemCategoryPropertyId;

}
