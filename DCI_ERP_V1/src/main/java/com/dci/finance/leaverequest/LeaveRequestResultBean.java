package com.dci.finance.leaverequest;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LeaveRequestResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<LeaveRequestBean> leaveRequestList;
	private List<LeaveRequestBean> internalList;
	private List<LeaveRequestLeaveBean> leaveList;
	private LeaveRequestBean leaveObj = new LeaveRequestBean();
	private List<LeaveRequestHolidayBean> holidayList;
	private List<LeaveRequestHolidayBean> holidayListEdit;
	private List<LeaveRequestBean> employeeList;
	private LeaveRequestBean employeeDetailsList = new LeaveRequestBean();
	private List<LeaveRequestLeaveBean> clList;
	private List<String> fileName;
	private List<String> docUrl;
	private String imgPath;
	
	
	
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public List<LeaveRequestBean> getLeaveRequestList() {
		return leaveRequestList;
	}
	public void setLeaveRequestList(List<LeaveRequestBean> leaveRequestList) {
		this.leaveRequestList = leaveRequestList;
	}
	public List<LeaveRequestBean> getInternalList() {
		return internalList;
	}
	public void setInternalList(List<LeaveRequestBean> internalList) {
		this.internalList = internalList;
	}
	public List<LeaveRequestLeaveBean> getLeaveList() {
		return leaveList;
	}
	public void setLeaveList(List<LeaveRequestLeaveBean> leaveList) {
		this.leaveList = leaveList;
	}
	public LeaveRequestBean getLeaveObj() {
		return leaveObj;
	}
	public void setLeaveObj(LeaveRequestBean leaveObj) {
		this.leaveObj = leaveObj;
	}
	public List<LeaveRequestHolidayBean> getHolidayList() {
		return holidayList;
	}
	public void setHolidayList(List<LeaveRequestHolidayBean> holidayList) {
		this.holidayList = holidayList;
	}
	public List<LeaveRequestHolidayBean> getHolidayListEdit() {
		return holidayListEdit;
	}
	public void setHolidayListEdit(List<LeaveRequestHolidayBean> holidayListEdit) {
		this.holidayListEdit = holidayListEdit;
	}
	public List<LeaveRequestBean> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<LeaveRequestBean> employeeList) {
		this.employeeList = employeeList;
	}
	public LeaveRequestBean getEmployeeDetailsList() {
		return employeeDetailsList;
	}
	public void setEmployeeDetailsList(LeaveRequestBean employeeDetailsList) {
		this.employeeDetailsList = employeeDetailsList;
	}
	public List<LeaveRequestLeaveBean> getClList() {
		return clList;
	}
	public void setClList(List<LeaveRequestLeaveBean> clList) {
		this.clList = clList;
	}
	public List<String> getFileName() {
		return fileName;
	}
	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}
	public List<String> getDocUrl() {
		return docUrl;
	}
	public void setDocUrl(List<String> docUrl) {
		this.docUrl = docUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
