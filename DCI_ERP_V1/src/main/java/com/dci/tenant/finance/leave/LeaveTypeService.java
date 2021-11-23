package com.dci.tenant.finance.leave;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



public interface LeaveTypeService {

	public List<LeaveType> getLeaveTypeList() throws CustomException;

	public boolean insertLeaveType(LeaveType leaveType) throws CustomException;

	public void updateLeaveType(LeaveType leaveType) throws CustomException;

	public void deleteLeaveType(String shortName) throws CustomException;

	public LeaveType getLeaveTypeByShortName(String shortName) throws CustomException;

	public void bulkDeleteLeaveType(List<String> shortNameList) throws CustomException;

	public boolean uploadFile(MultipartFile file);
}
