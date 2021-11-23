package com.dci.tenant.master.containersize;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "container_size_type", formCode = "F5594")
public class ContainerSizeBean {
	private Integer containerid;
	private String code;
	private String name;
	private String description;
	public boolean isActive;
	private String tableName;
	private String formCode;
	private String mdyDate;
	private String mdyBy;
	private String crtdDate;
	private String crtdBy;
	private String isStstus;
	public Integer getContainerid() {
		return containerid;
	}
	public void setContainerid(Integer containerid) {
		this.containerid = containerid;
	}
	
	@AuditLoggable(fieldName = "cntnr_sz_typ_cd", displayName = "Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@AuditLoggable(fieldName = "cntnr_sz_typ_nam", displayName = "Name")
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
	
	
}