package com.dci.tenant.truck.commodity;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "commodity", formCode = "F0123")

public class CommodityBean {

	public String commodityCode;
	public String commodity;
	public String classification;
	public String hazardous;
	
	public String unno;
	public String flashPoint;
	public String imdgPage;
	public String hsCode;
	public String blClause;
	public String imdgCode;
	public Boolean isSuccess;
	public String message;
	public String id;
	public String text;
	public String active;
	public String taxExem;
	public String getTaxExem() {
		return taxExem;
	}

	public void setTaxExem(String taxExem) {
		this.taxExem = taxExem;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@AuditLoggable(fieldName = "classification", displayName = "Classification")
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	@AuditLoggable(fieldName = "commodity", displayName = "Commodity")
	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	@AuditLoggable(fieldName = "hazardous", displayName = "Hazardous")
	public String getHazardous() {
		return hazardous;
	}

	public void setHazardous(String hazardous) {
		this.hazardous = hazardous;
	}

	@AuditLoggable(fieldName = "unno", displayName = "UNNO")
	public String getUnno() {
		return unno;
	}

	public void setUnno(String unno) {
		this.unno = unno;
	}

	@AuditLoggable(fieldName = "flashPoint", displayName = "Flash Point")
	public String getFlashPoint() {
		return flashPoint;
	}

	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
	}

	@AuditLoggable(fieldName = "imdgPage", displayName = "IMDG CodePage")
	public String getImdgPage() {
		return imdgPage;
	}

	public void setImdgPage(String imdgPage) {
		this.imdgPage = imdgPage;
	}

	@AuditLoggable(fieldName = "hsCode", displayName = "HS Code")
	public String getHsCode() {
		return hsCode;
	}

	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}

	@AuditLoggable(fieldName = "custname", displayName = "Customer Name")
	public String getBlClause() {
		return blClause;
	}

	public void setBlClause(String blClause) {
		this.blClause = blClause;
	}

	@AuditLoggable(fieldName = "imdgCode", displayName = "IMDG Class Code")
	public String getImdgCode() {
		return imdgCode;
	}

	public void setImdgCode(String imdgCode) {
		this.imdgCode = imdgCode;
	}

}
