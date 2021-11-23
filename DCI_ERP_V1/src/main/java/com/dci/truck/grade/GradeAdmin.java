package com.dci.truck.grade;


import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "grade", formCode = "F0247")

public class GradeAdmin {
	

	private int gradeId;
	private String gradeName;
	private boolean status;
	private String formCode;
	private String tableName;
	private String description;
	private String companyId;
	private String hospitalName;
	private String id;
	private String text;

	@AuditLoggable(fieldName = "grade_id", displayName = "gradeId")

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	@AuditLoggable(fieldName = "description", displayName = "description")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@AuditLoggable(fieldName = "grade_name", displayName = "gradeName")

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@AuditLoggable(fieldName = "status", displayName = "status")

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

