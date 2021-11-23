package com.dci.master.port;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "port_icd", formCode = "F5089")
public class PortBean {
	private Integer portid;
	private String code;
	private String name;
	private String description;
	public boolean isActive;
	private Integer city;
	private String cityid;
	private String cityName;
	private String tableName;
	private String formCode;
	private String mdyDate;
	private String countryName;
    public boolean isPort;
    public boolean isIcd;
    public boolean isDepot;
    public boolean isLocation;
	private String mdyBy;
	private String isStstus;

	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
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
	public Integer getPortid() {
		return portid;
	}
	public void setPortid(Integer portid) {
		this.portid = portid;
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
	@AuditLoggable(fieldName = "port_bt", displayName = "Port")
	public boolean getIsPort() {
		return isPort;
	}
	public void setIsPort(boolean isPort) {
		this.isPort = isPort;
	}
	@AuditLoggable(fieldName = "icd_bt", displayName = "Icd")
	public boolean getIsIcd() {
		return isIcd;
	}
	public void setIsIcd(boolean isIcd) {
		this.isIcd = isIcd;
	}
	@AuditLoggable(fieldName = "depot_bt", displayName = "Depot")
	public boolean getIsDepot() {
		return isDepot;
	}
	public void setIsDepot(boolean isDepot) {
		this.isDepot = isDepot;
	}
	@AuditLoggable(fieldName = "loc_bt", displayName = "Location")
	public boolean getIsLocation() {
		return isLocation;
	}
	public void setIsLocation(boolean isLocation) {
		this.isLocation = isLocation;
	}
	@AuditLoggable(fieldName = "prt_icd_cd", displayName = "Port Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@AuditLoggable(fieldName = "prt_icd_nam", displayName = "Port Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@AuditLoggable(fieldName = "cty_id", displayName = "City")
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
