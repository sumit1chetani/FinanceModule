package com.dci.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	private String type;
	private boolean success;
	private List<String> errors = new ArrayList<String>();
	private String customer;
	private String vessel;
	private String imgPath;
	private boolean success1;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getErrors() {
		return errors;
	}

	public boolean isSuccess1() {
		return success1;
	}

	public void setSuccess1(boolean success1) {
		this.success1 = success1;
	}

	public void setErrors(String error) {
		this.errors.add(error);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String path;


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
