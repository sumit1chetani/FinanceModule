package com.dci.finance.leaverequest;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;





@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestDAO leaveRequestDAO;

	@Override
	public List<LeaveRequestBean> getLeaveRequestList() {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getLeaveRequestList();
	}

	@Override
	public LeaveRequestResultBean getLeaveList(LeaveRequestBean leaveRequestBean) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getLeaveList(leaveRequestBean);
	}

	@Override
	public boolean saveLeaveData(LeaveRequestResultBean saveBean) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.saveLeaveData(saveBean);
	}

	@Override
	public LeaveRequestResultBean getHolidayList(LeaveRequestBean leaveRequestBean) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getHolidayList(leaveRequestBean);
	}

	@Override
	public LeaveRequestBean getEditList(int requestId) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getEditList(requestId);
	}

	@Override
	public boolean updateLeaveData(LeaveRequestResultBean updateBean) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.updateLeaveData(updateBean);

	}

	@Override
	public boolean deleteLeave(int leaveRequestId) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.deleteLeave(leaveRequestId);

	}

	// @Override
	// public LeaveRequestResultBean getEmployeeList() throws Exception {
	// return leaveRequestDAO.getEmployeeList();
	// }

	@Override
	public LeaveRequestBean getEmployeeDetails() throws Exception {
		return leaveRequestDAO.getEmployeeDetails();
	}

	@Override
	public LeaveRequestResultBean getLeaveNotification() throws CustomException {
		return leaveRequestDAO.getLeaveNotification();
	}

	@Override
	public void cancelRequest(LeaveRequestBean leaveRequestBean) throws CustomException {
		leaveRequestDAO.cancelRequest(leaveRequestBean);
	}

	@Override
	public LeaveRequestBean leaveExclude(LeaveRequestBean leaveRequestBean) throws Exception {
		return leaveRequestDAO.leaveExclude(leaveRequestBean);
	}

	@Override
	public boolean checkHoliday(LeaveRequestBean leaveRequestBean) throws Exception {
		return leaveRequestDAO.checkHoliday(leaveRequestBean);
	}

	@Override
	public List<LeaveRequestBean> leaveDeductionList() throws Exception {
		return leaveRequestDAO.leaveDeductionList();
	}

	@Override
	public void saveLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception {
		leaveRequestDAO.saveLeaveDeduction(leaveRequestBean);
	}

	@Override
	public LeaveRequestBean editLeaveDeduction(int leaveRequestId) throws Exception {
		return leaveRequestDAO.editLeaveDeduction(leaveRequestId);
	}

	@Override
	public void updateLeaveDeduction(LeaveRequestBean leaveRequestBean) throws Exception {
		leaveRequestDAO.updateLeaveDeduction(leaveRequestBean);
	}

	@Override
	public void deleteLeaveDeduction(int leaveRequestId) throws Exception {
		leaveRequestDAO.deleteLeaveDeduction(leaveRequestId);
	}
	
	@Override
	public LeaveRequestResultBean uploadMLFile(MultipartFile[] files) {

		return leaveRequestDAO.uploadMLFile(files);

	}
	

	/*@Override
	public LeaveRequestResultBean uploadMLFile(MultipartFile file, String fileName) throws Exception {
		// LeaveRequestResultBean leaveRequestResultBean = new
		// LeaveRequestResultBean();
		// LeaveRequestBean leaveRequestBean = new LeaveRequestBean();
		// UserDetail empUser = (UserDetail)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// String filePath = "";
		// if (!file.isEmpty()) {
		// System.out.println("getFilePropertyUrl" + getFilePropertyUrl);
		// System.out.println("getFileServerPath" + getFileServerPath);
		// System.out.println("fileName" + fileName);
		// filePath = HisFileUploadUtillity.uploadFileHandler(file,
		// getFilePropertyUrl, getFileServerPath, empUser.getUserId());
		// System.out.println("filePath" + filePath);
		// leaveRequestBean.setSupportDoc(filePath);
		// leaveRequestResultBean.setLeaveObj(leaveRequestBean);
		// }
		// return leaveRequestResultBean;
		return leaveRequestDAO.uploadMLFile(file, fileName);
	}*/

	@Override
	public LeaveRequestResultBean updateViewMLDoc(LeaveRequestBean leaveRequestBean) throws Exception {
		return leaveRequestDAO.updateViewMLDoc(leaveRequestBean);
	}

	@Override
	public List<LeaveRequestBean> viewLeaveHistory(String empId) throws Exception {
		return leaveRequestDAO.viewLeaveHistory(empId);
	}

	@Override
	public LeaveRequestResultBean getLeaveListHistory(String empId) throws Exception {
		// TODO Auto-generated method stub
		return leaveRequestDAO.getLeaveListHistory(empId);
	}
	

	@Override
	public void insertFiles(String requestId, String filename, String path) {
		leaveRequestDAO.insertFiles(requestId,filename,path);
		
	}

	
	@Override
	public LeaveRequestResultBean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return leaveRequestDAO.uploadFile(file);
	}
	
}
