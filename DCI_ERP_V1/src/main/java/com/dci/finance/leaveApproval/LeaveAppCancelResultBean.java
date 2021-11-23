package com.dci.finance.leaveApproval;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;



public class LeaveAppCancelResultBean extends BasicResultBean implements Serializable {

	private List<LeaveAppCancelBean> leaveAppList;

	public List<LeaveAppCancelBean> getLeaveAppList() {
		return leaveAppList;
	}

	public void setLeaveAppList(List<LeaveAppCancelBean> leaveAppList) {
		this.leaveAppList = leaveAppList;
	}

}
