package com.dci.tenant.truck.commodityclassification;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "commodity_classification", formCode = "F0124")
public class CommodityClassificationBean {
	
	
	 public String classificationCode; 
	 public String description ;
	 public Boolean isSuccess;
	 public String message;
	 
	 @AuditLoggable(fieldName = "classificationCode", displayName = "Classification Code")
	public String getClassificationCode() {
		return classificationCode;
	}
	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}
	
	 @AuditLoggable(fieldName = "description", displayName = "Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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



}
