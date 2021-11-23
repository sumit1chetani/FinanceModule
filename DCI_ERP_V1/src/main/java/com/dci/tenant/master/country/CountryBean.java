package com.dci.tenant.master.country;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "country", formCode = "F5595")
public class CountryBean {
	private Integer countryid;
	private String regionName;
	private String regionid;
	private String code;
	private String name;
	private Integer region;
	private String description;
	public boolean isActive;
	private String tableName;
	private String formCode;
	private String mdyDate;
	private String mdyBy;
	private String crtdDate;
	private String crtdBy;
	public Integer getCountryid() {
		return countryid;
	}
	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	
	@AuditLoggable(fieldName = "cntry_cd", displayName = "Country Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@AuditLoggable(fieldName = "cntry_nam", displayName = "Country Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@AuditLoggable(fieldName = "rgn_id", displayName = "Region")
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getRegionid() {
		return regionid;
	}
	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
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