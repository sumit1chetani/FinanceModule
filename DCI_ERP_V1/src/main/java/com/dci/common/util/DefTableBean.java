package com.dci.common.util;

public class DefTableBean {
	private Integer defTableId;
	private Integer formFieldId;
	private String value;
	private Boolean isActive;
	private int id;
	private String text;

	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getDefTableId() {
		return defTableId;
	}

	public void setDefTableId(Integer defTableId) {
		this.defTableId = defTableId;
	}

	public Integer getFormFieldId() {
		return formFieldId;
	}

	public void setFormFieldId(Integer formFieldId) {
		this.formFieldId = formFieldId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
