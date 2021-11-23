package com.dci.tenant.domain.model;

public class DashboardlistBean {
	
	public String userId;
	public String userName;
	public String ipAddrs;
	public String createdDt;
	public String active;
	public String action;
	
	public String description;
	public String countActivity;
	private Integer orderby;
	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIpAddrs() {
		return ipAddrs;
	}
	public void setIpAddrs(String ipAddrs) {
		this.ipAddrs = ipAddrs;
	}
	public String getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCountActivity() {
		return countActivity;
	}
	public void setCount(String countActivity) {
		this.countActivity = countActivity;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public void setCountActivity(String countActivity) {
		this.countActivity = countActivity;
	}
	
	   

	
	
	
}
