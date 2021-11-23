package com.dci.master.settings.uomcategory;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "uom_category", formCode = "F5189")
public class UOMCatogoryBean {

	private int uomId;
	private String uomcategoryId;
	private String uomcategoryName;
	private String uomcategoryDesc;
	private boolean status;
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

	private UOMCatogoryBean uomcategoryData;

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getUomcategoryId() {
		return uomcategoryId;
	}

	public void setUomcategoryId(String uomcategoryId) {
		this.uomcategoryId = uomcategoryId;
	}

	@AuditLoggable(fieldName = "uomcategory_name", displayName = "uomcategoryName")
	public String getUomcategoryName() {
		return uomcategoryName;
	}

	public void setUomcategoryName(String uomcategoryName) {
		this.uomcategoryName = uomcategoryName;
	}
	@AuditLoggable(fieldName = "uomcategory_desc", displayName = "uomcategoryDesc")
	public String getUomcategoryDesc() {
		return uomcategoryDesc;
	}

	public void setUomcategoryDesc(String uomcategoryDesc) {
		this.uomcategoryDesc = uomcategoryDesc;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UOMCatogoryBean getUomcategoryData() {
		return uomcategoryData;
	}

	public void setUomcategoryData(UOMCatogoryBean uomcategoryData) {
		this.uomcategoryData = uomcategoryData;
	}

}
