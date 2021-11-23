package com.dci.hrms.hr.leave.leaveSummary;

import java.util.List;

import com.dci.common.util.CustomException;


public interface LeaveSummaryDAO {

	public List<LeaveSummaryBean> getSummaryDetails(String leaveType) throws CustomException;

}
