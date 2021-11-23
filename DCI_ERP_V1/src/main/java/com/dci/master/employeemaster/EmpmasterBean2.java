package com.dci.master.employeemaster;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "employee_master", formCode = "F0037")
public class EmpmasterBean2 {
	
	private String empId;
	private String pswd;
	
	@AuditLoggable(fieldName = "emp_id", displayName = "Employee")
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	@AuditLoggable(fieldName = "password", displayName = "password")
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	

}
