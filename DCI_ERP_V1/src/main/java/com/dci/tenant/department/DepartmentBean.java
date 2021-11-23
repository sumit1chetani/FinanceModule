package com.dci.tenant.department;



import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "department_master", formCode = "F0246")

public class DepartmentBean {
	private String deptCode;
	private String deptName;
	private String deptHead;
	private String deptDesc;
	private String isActive;
	private String id;
	private String text;
	private boolean isEdit;
	private String formCode;
	private String tableName;
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

	// For Drop Down
	private String empId;
	private String empName;
	
	@AuditLoggable(fieldName = "dept_code", displayName = "deptCode")

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@AuditLoggable(fieldName = "dept_name", displayName = "deptName")

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@AuditLoggable(fieldName = "dept_head", displayName = "deptHead")

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	@AuditLoggable(fieldName = "dept_desc", displayName = "deptDesc")

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@AuditLoggable(fieldName = "dept_status", displayName = "isActive")

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
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

}
