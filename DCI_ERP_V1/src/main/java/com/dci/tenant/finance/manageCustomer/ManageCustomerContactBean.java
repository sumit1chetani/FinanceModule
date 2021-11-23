package com.dci.tenant.finance.manageCustomer;

public class ManageCustomerContactBean {

	private Integer entityContactId;
	private Integer entityId;
	private String contactName;
	private String jobPosition;
	private String phone;
	private String mobile;
	private String email;
	private boolean select = false;

	public Integer getEntityContactId() {
		return entityContactId;
	}

	public void setEntityContactId(Integer entityContactId) {
		this.entityContactId = entityContactId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

}
