package com.dci.master.employeeAdminMaster;

public class EmployeeAdminDocumentBean {
	private String empId;
	private String docName;
	private String description;
	private String uploadDoc;
	private Integer empDocId;

	private String docType;

	private String issuecountry;
	private String expiryDate;
	public String issueDate;

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getIssuecountry() {
		return issuecountry;
	}

	public void setIssuecountry(String issuecountry) {
		this.issuecountry = issuecountry;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadDoc() {
		return uploadDoc;
	}

	public void setUploadDoc(String uploadDoc) {
		this.uploadDoc = uploadDoc;
	}

	public Integer getEmpDocId() {
		return empDocId;
	}

	public void setEmpDocId(Integer empDocId) {
		this.empDocId = empDocId;
	}

}
