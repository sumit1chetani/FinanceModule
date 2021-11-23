package com.dci.master.servicepartnerNew;

public class ServiceNewMapBean {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private boolean visible;


	public String getPartnerClassification() {
		return partnerClassification;
	}

	public void setPartnerClassification(String partnerClassification) {
		this.partnerClassification = partnerClassification;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private int id;
	
	private String title;

	private String remarks;

	
	private String partnerClassification;
}
