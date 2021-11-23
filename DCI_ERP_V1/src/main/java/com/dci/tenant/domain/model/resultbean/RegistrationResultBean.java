package com.dci.tenant.domain.model.resultbean;

import com.dci.common.util.BasicResultBean;

public class RegistrationResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tenantId;
	// private boolean success;
	private String message;

	private String confPwd;
	private String newPwd;
	private String vcode;
	private String password;

	private String imagePath;
	private Integer tenantUserId;
	private String userName;
	private String domain;
	private String secretKey;
	private String adDetails;

	public String getConfPwd() {
		return confPwd;
	}

	public void setConfPwd(String confPwd) {
		this.confPwd = confPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	// public boolean isSuccess() {
	// return success;
	// }
	//
	// public void setSuccess(boolean success) {
	// this.success = success;
	// }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(Integer tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getAdDetails() {
		return adDetails;
	}

	public void setAdDetails(String adDetails) {
		this.adDetails = adDetails;
	}

}