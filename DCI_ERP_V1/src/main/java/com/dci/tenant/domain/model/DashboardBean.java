package com.dci.tenant.domain.model;

import java.util.List;

public class DashboardBean {

	private int curUserLogin;

	private int changePwrdCount;

	private int noOfApps;

	private int acctLogdIn;

	private String firstMonth;

	private String lastMonth;

	private int usersUsage;

	private int appsUsage;

	private List<String> monthList;

	private List<Integer> userStatList;

	private List<Integer> appStatList;

	private String monthVal;

	private int count;

	private String name;

	private List<DashboardBean> monthUserSignList;

	private List<DashboardBean> monthAppSignList;

	private List<DashboardBean> weekUserSignList;

	private List<DashboardBean> weekAppSignList;

	private List<DashboardBean> todayUserSignList;

	private List<DashboardBean> todayAppSignList;

	public int getCurUserLogin() {
		return curUserLogin;
	}

	public void setCurUserLogin(int curUserLogin) {
		this.curUserLogin = curUserLogin;
	}

	public int getChangePwrdCount() {
		return changePwrdCount;
	}

	public void setChangePwrdCount(int changePwrdCount) {
		this.changePwrdCount = changePwrdCount;
	}

	public int getNoOfApps() {
		return noOfApps;
	}

	public void setNoOfApps(int noOfApps) {
		this.noOfApps = noOfApps;
	}

	public int getAcctLogdIn() {
		return acctLogdIn;
	}

	public void setAcctLogdIn(int acctLogdIn) {
		this.acctLogdIn = acctLogdIn;
	}

	public int getUsersUsage() {
		return usersUsage;
	}

	public void setUsersUsage(int usersUsage) {
		this.usersUsage = usersUsage;
	}

	public int getAppsUsage() {
		return appsUsage;
	}

	public void setAppsUsage(int appsUsage) {
		this.appsUsage = appsUsage;
	}

	public String getFirstMonth() {
		return firstMonth;
	}

	public void setFirstMonth(String firstMonth) {
		this.firstMonth = firstMonth;
	}

	public String getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(String lastMonth) {
		this.lastMonth = lastMonth;
	}

	public List<String> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<String> monthList) {
		this.monthList = monthList;
	}

	public List<Integer> getUserStatList() {
		return userStatList;
	}

	public void setUserStatList(List<Integer> userStatList) {
		this.userStatList = userStatList;
	}

	public List<Integer> getAppStatList() {
		return appStatList;
	}

	public void setAppStatList(List<Integer> appStatList) {
		this.appStatList = appStatList;
	}

	public String getMonthVal() {
		return monthVal;
	}

	public void setMonthVal(String monthVal) {
		this.monthVal = monthVal;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DashboardBean> getMonthUserSignList() {
		return monthUserSignList;
	}

	public void setMonthUserSignList(List<DashboardBean> monthUserSignList) {
		this.monthUserSignList = monthUserSignList;
	}

	public List<DashboardBean> getMonthAppSignList() {
		return monthAppSignList;
	}

	public void setMonthAppSignList(List<DashboardBean> monthAppSignList) {
		this.monthAppSignList = monthAppSignList;
	}

	public List<DashboardBean> getWeekUserSignList() {
		return weekUserSignList;
	}

	public void setWeekUserSignList(List<DashboardBean> weekUserSignList) {
		this.weekUserSignList = weekUserSignList;
	}

	public List<DashboardBean> getWeekAppSignList() {
		return weekAppSignList;
	}

	public void setWeekAppSignList(List<DashboardBean> weekAppSignList) {
		this.weekAppSignList = weekAppSignList;
	}

	public List<DashboardBean> getTodayUserSignList() {
		return todayUserSignList;
	}

	public void setTodayUserSignList(List<DashboardBean> todayUserSignList) {
		this.todayUserSignList = todayUserSignList;
	}

	public List<DashboardBean> getTodayAppSignList() {
		return todayAppSignList;
	}

	public void setTodayAppSignList(List<DashboardBean> todayAppSignList) {
		this.todayAppSignList = todayAppSignList;
	}

}
