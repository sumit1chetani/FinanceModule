package com.dci.finance.leavedeclare;

import java.util.List;

public interface LeaveDeclareService {
	
	List<LeaveDeclareBean> getLeaveList() throws Exception;

	LeaveDeclareResultBean getGradeList(String companyId) throws Exception;

	LeaveDeclareResultBean getYearList() throws Exception;

	LeaveDeclareResultBean getLeaveType(String branchId,int yearId) throws Exception;

	public void saveLeaveDetails(LeaveDeclareResultBean leaveBean) throws Exception;

	LeaveDeclareResultBean getEditList(String branch, int year) throws Exception;

	public boolean deleteLeave(int gradeId, int year) throws Exception;

}
