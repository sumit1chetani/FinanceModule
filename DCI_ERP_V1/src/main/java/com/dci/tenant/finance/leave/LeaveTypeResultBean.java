package com.dci.tenant.finance.leave;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;



public class LeaveTypeResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<LeaveType> leaveTypeList;

	private LeaveType leaveType = new LeaveType();

	public List<LeaveType> getLeaveTypeList() {
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<LeaveType> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

}
