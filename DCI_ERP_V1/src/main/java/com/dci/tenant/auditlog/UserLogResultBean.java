package com.dci.tenant.auditlog;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class UserLogResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserLog> userLogList;
	private List<EmployeeMasterBean> employeeList;
	private List<AuditLogBean> auditLogList;
	private List<UserLog> formCodeList;
	private List<UserLog> tableNameList;
	private List<UserLog> userIPLogList;

	public List<UserLog> getUserLogList() {
		return userLogList;
	}

	public void setUserLogList(List<UserLog> userLogList) {
		this.userLogList = userLogList;
	}

	public List<AuditLogBean> getAuditLogList() {
		return auditLogList;
	}

	public void setAuditLogList(List<AuditLogBean> auditLogList) {
		this.auditLogList = auditLogList;
	}

	public List<UserLog> getFormCodeList() {
		return formCodeList;
	}

	public void setFormCodeList(List<UserLog> formCodeList) {
		this.formCodeList = formCodeList;
	}

	/**
	 * @return the employeeList
	 */

	public List<UserLog> getTableNameList() {
		return tableNameList;
	}

	public void setTableNameList(List<UserLog> tableNameList) {
		this.tableNameList = tableNameList;
	}
	
	public List<UserLog> getUserIPLogList() {
		return userIPLogList;
	}

	public void setUserIPLogList(List<UserLog> userIPLogList) {
		this.userIPLogList = userIPLogList;
	}

	public List<EmployeeMasterBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeMasterBean> employeeList) {
		this.employeeList = employeeList;
	}

}
