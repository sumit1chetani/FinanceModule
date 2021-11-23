package com.dci.common.model;

import com.dci.tenant.auditlog.AuditLoggable;

public class CustomerDtlBean {
	private String polCode;
	private String podCode;
	private String email;
	private String payerCode;
	private boolean checked;

	
	@AuditLoggable(fieldName = "PORT_CODE", displayName = "Pol Code")
	public String getPolCode() {
		return polCode;
	}

	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}

	@AuditLoggable(fieldName = "POD", displayName = "Pod Code")
	public String getPodCode() {
		return podCode;
	}

	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}

	@AuditLoggable(fieldName = "EMAIL", displayName = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@AuditLoggable(fieldName = "PAYER_ID", displayName = "Payer Code")
	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
