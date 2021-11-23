package com.dci.master.unit;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "unit", formCode = "F5600")
public class UnitBean {
	private Integer unitid;
	private String modeName;
	private String modeid;
	private String code;
	private String name;
	private Integer mode;
	private String description;
	public boolean isActive;
	private String tableName;
	private String formCode;
	private String mdyDate;
	private String mdyBy;
	private String crtdDate;
	private String crtdBy;
	
	public Integer getUnitid() {
		return unitid;
	}
	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	@AuditLoggable(fieldName = "md_id", displayName = "Mode")
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	public String getModeid() {
		return modeid;
	}
	public void setModeid(String modeid) {
		this.modeid = modeid;
	}
	@AuditLoggable(fieldName = "unt_cd", displayName = "Unit Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@AuditLoggable(fieldName = "unt_nam", displayName = "Unit Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@AuditLoggable(fieldName = "cty_cd", displayName = "City Code")
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@AuditLoggable(fieldName = "actv_bt", displayName = "Active")
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
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
	public String getMdyDate() {
		return mdyDate;
	}
	public void setMdyDate(String mdyDate) {
		this.mdyDate = mdyDate;
	}
	public String getMdyBy() {
		return mdyBy;
	}
	public void setMdyBy(String mdyBy) {
		this.mdyBy = mdyBy;
	}
	public String getCrtdDate() {
		return crtdDate;
	}
	public void setCrtdDate(String crtdDate) {
		this.crtdDate = crtdDate;
	}
	public String getCrtdBy() {
		return crtdBy;
	}
	public void setCrtdBy(String crtdBy) {
		this.crtdBy = crtdBy;
	}
	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
	private String isStstus;

}