package com.dci.tenant.master.city;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "city", formCode = "F5593")
public class CityBean {
	private Integer cityid;
	private String stateName;
	private String stateid;
	private String code;
	private String name;
	private Integer state;
	private String description;
	private String pin;
	public boolean isActive;
	private String tableName;
	private String formCode;
	private String mdyDate;
	private String mdyBy;
	private String crtdDate;
	private String crtdBy;
	private String isStstus;
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	
	@AuditLoggable(fieldName = "cty_cd", displayName = "City Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@AuditLoggable(fieldName = "cty_nam", displayName = "City Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@AuditLoggable(fieldName = "stt_id", displayName = "State ")
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "Desciption")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@AuditLoggable(fieldName = "zp_cd", displayName = "Postal Code")
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
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