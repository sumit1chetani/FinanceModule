package com.dci.tenant.auditlog;

public class AuditLogBean {
	private String auditLogId;
	private String employeeId;
	private String employeeName;
	private Integer formId;
	private String formName;
	private String action;
	private String fieldName;
	private String oldValue;
	private String newValue;
	private String createdOn;
	private String displayName;
	private String primaryId;
	private String tableName;
	private String parentId;
	private String formCode;
	private String userLogId;
	private Long logdateMillis;
	private String ipAddrs;
	private Object object;
	private Object oldObject;
	private String tenantUserId;

	public String getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(String auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(String userLogId) {
		this.userLogId = userLogId;
	}

	public Object getOldObject() {
		return oldObject;
	}

	public void setOldObject(Object oldObject) {
		this.oldObject = oldObject;
	}

	/**
	 * @return the formName
	 */
	public String getFormName() {
		return formName;
	}

	/**
	 * @param formName
	 *            the formName to set
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the logdateMillis
	 */
	public Long getLogdateMillis() {
		return logdateMillis;
	}

	/**
	 * @param logdateMillis the logdateMillis to set
	 */
	public void setLogdateMillis(Long logdateMillis) {
		this.logdateMillis = logdateMillis;
	}

	public String getIpAddrs() {
		return ipAddrs;
	}

	public void setIpAddrs(String ipAddrs) {
		this.ipAddrs = ipAddrs;
	}

	public String getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
}
