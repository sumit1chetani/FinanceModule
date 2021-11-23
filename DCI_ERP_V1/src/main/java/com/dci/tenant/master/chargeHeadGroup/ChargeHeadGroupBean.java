package com.dci.tenant.master.chargeHeadGroup;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "charge_head_group", formCode = "F5087")
public class ChargeHeadGroupBean {
	private Integer chargeHeadGroupid;
	private String code;
	private String name;
	public Integer getChargeHeadGroupid() {
		return chargeHeadGroupid;
	}
	public void setChargeHeadGroupid(Integer chargeHeadGroupid) {
		this.chargeHeadGroupid = chargeHeadGroupid;
	}
	@AuditLoggable(fieldName = "chrg_hd_grp_cd", displayName = "Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@AuditLoggable(fieldName = "chrg_hd_grp_nam", displayName = "Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getMdyDate() {
		return mdyDate;
	}
	public void setMdyDate(String mdyDate) {
		this.mdyDate = mdyDate;
	}
	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
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
	private String description;
	public boolean isActive;
	
	private String mdyDate;
	private String isStstus;

	private String mdyBy;
	private String crtdDate;
	private String crtdBy;

	

	
	private String tableName;
	private String formCode;
}
