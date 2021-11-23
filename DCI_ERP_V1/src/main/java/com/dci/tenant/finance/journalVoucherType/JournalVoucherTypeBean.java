package com.dci.tenant.finance.journalVoucherType;

public class JournalVoucherTypeBean {
	private String name;
	private String description;
	private boolean active;
	private int journalVoucherTypeId;
	private int id;
	private String text;
	private boolean isEdit; // Button Change While Adding and Updating

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getJournalVoucherTypeId() {
		return journalVoucherTypeId;
	}

	public void setJournalVoucherTypeId(int journalVoucherTypeId) {
		this.journalVoucherTypeId = journalVoucherTypeId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
