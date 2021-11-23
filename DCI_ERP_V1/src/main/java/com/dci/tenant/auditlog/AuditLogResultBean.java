package com.dci.tenant.auditlog;

import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.user.UserMasterBean;

public class AuditLogResultBean extends BasicResultBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<AuditLogBean> auditLogBeanList;
	private List<UserMasterBean> employeeList;
	private List<SesLogBean> sesLogBeanList;

	public List<AuditLogBean> getAuditLogBeanList() {
		return auditLogBeanList;
	}

	public void setAuditLogBeanList(List<AuditLogBean> auditLogBeanList) {
		this.auditLogBeanList = auditLogBeanList;
	}

	public List<UserMasterBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<UserMasterBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<SesLogBean> getSesLogBeanList() {
		return sesLogBeanList;
	}

	public void setSesLogBeanList(List<SesLogBean> sesLogBeanList) {
		this.sesLogBeanList = sesLogBeanList;
	}

}
