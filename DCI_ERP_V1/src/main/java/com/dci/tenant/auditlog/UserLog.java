package com.dci.tenant.auditlog;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public class UserLog {

	private String userLogId;
	private String employeeId;
	private String logdate;
	private Long logdateMillis;
	private String primaryDataId;
	private String formCode;
	private String tableName;
	private String actionType;
	private String ipAddres;
	private String logDescription;
	private String employeeName;
	private String formName;
	private String id;
	private String text;
	private String dateFrom;
	private String dateTo;
	private String tenantUserId;
	private String userIpAddress;
	private List<SelectivityBean> onkk;

	public String getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(String userLogId) {
		this.userLogId = userLogId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLogdate() {
		return logdate;
	}

	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getLogDescription() {
		return logDescription;
	}

	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
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

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getPrimaryDataId() {
		return primaryDataId;
	}

	public void setPrimaryDataId(String primaryDataId) {
		this.primaryDataId = primaryDataId;
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

	public String getIpAddres() {
		return ipAddres;
	}

	public void setIpAddres(String ipAddres) {
		this.ipAddres = ipAddres;
	}

	public String getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getUserIpAddress() {
		return userIpAddress;
	}

	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}

	public List<SelectivityBean> getOnkk() {
		return onkk;
	}

	public void setOnkk(List<SelectivityBean> onkk) {
		this.onkk = onkk;
	}

}
