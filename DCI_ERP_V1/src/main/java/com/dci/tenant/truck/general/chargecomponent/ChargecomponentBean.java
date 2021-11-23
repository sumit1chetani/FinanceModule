package com.dci.tenant.truck.general.chargecomponent;


import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "chargecomponent", formCode = "F0242")
public class ChargecomponentBean {
	
	private Integer chargeComponentid;
	private String chargeCode;
	private String chargeName;
	private String chargeComponentdescription;
	private String isActive;
	private String chargeType;
	private String chargeTypeid;
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
	public Integer getChargeComponentid() {
		return chargeComponentid;
	}
	public void setChargeComponentid(Integer chargeComponentid) {
		this.chargeComponentid = chargeComponentid;
	}
	
	@AuditLoggable(fieldName = "chargecomponentcode", displayName = "chargeCode")
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	
	@AuditLoggable(fieldName = "chargecomponentname", displayName = "chargeName")
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getChargeComponentdescription() {
		return chargeComponentdescription;
	}
	public void setChargeComponentdescription(String chargeComponentdescription) {
		this.chargeComponentdescription = chargeComponentdescription;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@AuditLoggable(fieldName = "chargetype_id", displayName = "chargeType")
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeTypeid() {
		return chargeTypeid;
	}
	public void setChargeTypeid(String chargeTypeid) {
		this.chargeTypeid = chargeTypeid;
	}
	
	
	
	
	
	
	
	
}

