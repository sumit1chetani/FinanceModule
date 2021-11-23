package com.dci.tenant.truck.general.chargetype;



import java.util.List;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "chargetype", formCode = "F0243")
public class ChargetypeBean {
	
	private Integer chargeTypeid;
	private String chargeTypecode;
	private String chargeTypename;
	private String chargeTypedescription;
	private String isActive;
	private List<ChargetypeBean> getSavemodel;
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
	public Integer getChargeTypeid() {
		return chargeTypeid;
	}
	public void setChargeTypeid(Integer chargeTypeid) {
		this.chargeTypeid = chargeTypeid;
	}
	
	@AuditLoggable(fieldName = "chargetypecode", displayName = "chargeTypecode")
	public String getChargeTypecode() {
		return chargeTypecode;
	}
	public void setChargeTypecode(String chargeTypecode) {
		this.chargeTypecode = chargeTypecode;
	}
	
	@AuditLoggable(fieldName = "chargetypename", displayName = "chargeTypename")
	public String getChargeTypename() {
		return chargeTypename;
	}
	public void setChargeTypename(String chargeTypename) {
		this.chargeTypename = chargeTypename;
	}
	public String getChargeTypedescription() {
		return chargeTypedescription;
	}
	public void setChargeTypedescription(String chargeTypedescription) {
		this.chargeTypedescription = chargeTypedescription;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public List<ChargetypeBean> getGetSavemodel() {
		return getSavemodel;
	}
	public void setGetSavemodel(List<ChargetypeBean> getSavemodel) {
		this.getSavemodel = getSavemodel;
	}
	
}

