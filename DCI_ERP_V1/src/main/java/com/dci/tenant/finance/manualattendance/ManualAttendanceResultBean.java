package com.dci.tenant.finance.manualattendance;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;




public class ManualAttendanceResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ManualAttendance> departmentList;
	private List<ManualAttendance> shiftList;
	private List<ManualAttendance> attendanceDataList;
	private List<ManualAttendance> employeeList;
	private ManualAttendance manualattendance = new ManualAttendance();

	/*
	 * @JsonProperty("employeeList")
	 * 
	 * @XmlElement(required = true) protected List<ManualAttendance>
	 * employeeList;
	 */
	private List<ManualAttendance> inTimeList;
	private List<ManualAttendance> shiftTimingList;

	private List<ManualAttendance> myAttendanceList;

	private List<ManualAttendance> myAttendanceDetails;

	public List<ManualAttendance> getMyAttendanceDetails() {
		return myAttendanceDetails;
	}

	public void setMyAttendanceDetails(List<ManualAttendance> myAttendanceDetails) {
		this.myAttendanceDetails = myAttendanceDetails;
	}

	public List<ManualAttendance> getMyAttendanceList() {
		return myAttendanceList;
	}

	public void setMyAttendanceList(List<ManualAttendance> myAttendanceList) {
		this.myAttendanceList = myAttendanceList;
	}

	public List<ManualAttendance> getShiftTimingList() {
		return shiftTimingList;
	}

	public void setShiftTimingList(List<ManualAttendance> shiftTimingList) {
		this.shiftTimingList = shiftTimingList;
	}

	public List<ManualAttendance> getInTimeList() {
		return inTimeList;
	}

	public void setInTimeList(List<ManualAttendance> inTimeList) {
		this.inTimeList = inTimeList;
	}

	public List<ManualAttendance> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<ManualAttendance> employeeList) {
		this.employeeList = employeeList;
	}

	public List<ManualAttendance> getAttendanceDataList() {
		return attendanceDataList;
	}

	public void setAttendanceDataList(List<ManualAttendance> attendanceDataList) {
		this.attendanceDataList = attendanceDataList;
	}

	public List<ManualAttendance> getShiftList() {
		return shiftList;
	}

	public void setShiftList(List<ManualAttendance> shiftList) {
		this.shiftList = shiftList;
	}

	public List<ManualAttendance> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<ManualAttendance> departmentList) {
		this.departmentList = departmentList;
	}

	public ManualAttendance getManualattendance() {
		return manualattendance;
	}

	public void setManualattendance(ManualAttendance manualattendance) {
		this.manualattendance = manualattendance;
	}

}
