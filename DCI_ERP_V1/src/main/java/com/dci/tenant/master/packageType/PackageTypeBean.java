package com.dci.tenant.master.packageType;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;


@AuditLoggableType(tableName = "package_type", formCode = "F5088")
public class PackageTypeBean {
	private Integer packageTypeid;
	@AuditLoggable(fieldName = "pckg_id", displayName = "packageTypeid")

	public Integer getPackageTypeid() {
		return packageTypeid;
	}
	public void setPackageTypeid(Integer packageTypeid) {
		this.packageTypeid = packageTypeid;
	}
	
	@AuditLoggable(fieldName = "pckg_cd", displayName = "code")

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@AuditLoggable(fieldName = "pckg_nam", displayName = "name")

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "description")

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	private String code;
	private String mdyDate;

	private String mdyBy;
	private String crtdDate;
	private String crtdBy;

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
	private String name;
	private String description;
	public boolean isActive;
	
	
	@AuditLoggable(fieldName = "actv_bt", displayName = "isActive")


	
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	private String tableName;
	private String isStstus;

	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
	private String formCode;
} 