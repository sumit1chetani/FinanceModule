package com.dci.finance.leaverequest;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;




public interface LeaveRequestDAO {


	List<LeaveRequestBean> getLeaveRequestList();

	public LeaveRequestResultBean getLeaveList(LeaveRequestBean leaveRequestBean) throws Exception;

	LeaveRequestResultBean getLeaveListHistory(String empId) throws Exception;

	public boolean saveLeaveData(LeaveRequestResultBean saveBean) throws Exception;

	public LeaveRequestResultBean getHolidayList(LeaveRequestBean leaveRequestBean) throws Exception;

	LeaveRequestBean getEditList(int requestId) throws Exception;

	public boolean updateLeaveData(LeaveRequestResultBean updateBean) throws Exception;

	public boolean deleteLeave(int leaveRequestId) throws Exception;

	// LeaveRequestResultBean getEmployeeList() throws Exception;

	public LeaveRequestBean getEmployeeDetails() throws Exception;

	public LeaveRequestResultBean getLeaveNotification() throws CustomException;

	public void cancelRequest(LeaveRequestBean leaveRequestBean) throws CustomException;

	public LeaveRequestBean leaveExclude(LeaveRequestBean leaveRequestBean) throws Exception;

	public boolean checkHoliday(LeaveRequestBean leaveRequestBean) throws Exception;

	public List<LeaveRequestBean> leaveDeductionList() throws Exception;

	public void saveLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception;

	public LeaveRequestBean editLeaveDeduction(int leaveRequestId) throws Exception;

	public void updateLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception;

	public void deleteLeaveDeduction(int leaveRequestId) throws Exception;

	/*public LeaveRequestResultBean uploadMLFile(MultipartFile file, String fileName) throws Exception;*/
	
	public LeaveRequestResultBean uploadMLFile(MultipartFile[] files);

	public LeaveRequestResultBean updateViewMLDoc(LeaveRequestBean leaveRequestBean) throws Exception;

	public List<LeaveRequestBean> viewLeaveHistory(String empId) throws Exception;

	
	public void insertFiles(String requestId, String  filename,String  path);

	LeaveRequestResultBean uploadFile(MultipartFile file);

}
