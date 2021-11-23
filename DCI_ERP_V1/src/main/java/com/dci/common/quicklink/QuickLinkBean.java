package com.dci.common.quicklink;

import java.util.List;

public class QuickLinkBean {
	public String id;
	public String text;
	public String qlLink;
	private boolean success;
	private String quickLinkId;
	private List<String> quickLinkIdList; 
	
	public String getQuickLinkId() {
		return quickLinkId;
	}
	public void setQuickLinkId(String quickLinkId) {
		this.quickLinkId = quickLinkId;
	}
	public List<String> getQuickLinkIdList() {
		return quickLinkIdList;
	}
	public void setQuickLinkIdList(List<String> quickLinkIdList) {
		this.quickLinkIdList = quickLinkIdList;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
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
	public String getQlLink() {
		return qlLink;
	}
	public void setQlLink(String qlLink) {
		this.qlLink = qlLink;
	}
	
	
	
}
