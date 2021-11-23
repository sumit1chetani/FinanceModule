package com.dci.tenant.master.iata;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;



@AuditLoggableType(tableName = "IATA", formCode = "F5084")
public class IataBean {
	private Integer iataid;
	private String iataCode;
	private String iataName;
	private String description;
	public boolean isActive;
	private Integer iataCity;
	private String iataCityid;
	private String iataCityName;
	private String mdyDate;
	private String isStstus;

	private String mdyBy;
	private String crtdDate;
	private String crtdBy;
	private String iataCountryName1;
	
	
	public String getIataCityName() {
		return iataCityName;
	}
	public void setIataCityName(String iataCityName) {
		this.iataCityName = iataCityName;
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
	public Integer getIataid() {
		return iataid;
	}
	public void setIataid(Integer iataid) {
		this.iataid = iataid;
	}
	
	@AuditLoggable(fieldName = "iata_cd", displayName = "IATA code")
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	@AuditLoggable(fieldName = "iata_nam", displayName = "IATA Name")
	public String getIataName() {
		return iataName;
	}
	public void setIataName(String iataName) {
		this.iataName = iataName;
	}
	
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	/*@AuditLoggable(fieldName = "actv_bt", displayName = "active")*/
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@AuditLoggable(fieldName = "cty_id", displayName = "City")
	public Integer getIataCity() {
		return iataCity;
	}
	public void setIataCity(Integer iataCity) {
		this.iataCity = iataCity;
	}
	public String getIataCityid() {
		return iataCityid;
	}
	public void setIataCityid(String iataCityid) {
		this.iataCityid = iataCityid;
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
	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
	
	
	public String getIataCountryName1() {
		return iataCountryName1;
	}
	public void setIataCountryName1(String iataCountryName1) {
		this.iataCountryName1 = iataCountryName1;
	}


	private String tableName;
	private String formCode;
}
