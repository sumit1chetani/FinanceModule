package com.dci.truck.staffMaster;

public class StaffBean { 
	
	private String id;
	private String text;
	private String iahsempcode;
	private String trmsempcode;
	private boolean isSuccess;

	
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
	
	public String getTrmsempcode() {
		return trmsempcode;
	}
	public void setTrmsempcode(String trmsempcode) {
		this.trmsempcode = trmsempcode;
	}
	public String getIahsempcode() {
		return iahsempcode;
	}
	public void setIahsempcode(String iahsempcode) {
		this.iahsempcode = iahsempcode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	
	
	
	
}
