package com.dci.tenant.designation;


import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "designation_master", formCode = "F0245")
public class DesignationBean {
	private String desgnCode;
	private String desgnName;
	private String desgnDesc;
	private String isActive;
	private boolean isEdit;
	private String formCode;
	private String tableName;
	@AuditLoggable(fieldName = "desgn_code", displayName = "desgnCode")

	public String getDesgnCode() {
		return desgnCode;
	}

	public void setDesgnCode(String desgnCode) {
		this.desgnCode = desgnCode;
	}
	
	@AuditLoggable(fieldName = "desgn_name", displayName = "Designation Name")

	public String getDesgnName() {
		return desgnName;
	}

	public void setDesgnName(String desgnName) {
		this.desgnName = desgnName;
	}

	@AuditLoggable(fieldName = "desgn_status", displayName = "Active")

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@AuditLoggable(fieldName = "desgn_desc", displayName = "Remarks")

	public String getDesgnDesc() {
		return desgnDesc;
	}

	public void setDesgnDesc(String desgnDesc) {
		this.desgnDesc = desgnDesc;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
