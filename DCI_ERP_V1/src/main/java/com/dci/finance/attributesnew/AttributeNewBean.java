package com.dci.finance.attributesnew;

public class AttributeNewBean {

	private String attributeName;
	private String attributeValue;
	private int attributeId;

	private Integer id;
	private String text;

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

}
