package com.dci.tenant.finance.leave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	@Autowired
	LeaveTypeDAO leaveTypeDao;

	@Override
	public List<LeaveType> getLeaveTypeList() throws CustomException {
		// TODO Auto-generated method stub
		return leaveTypeDao.getLeaveTypeList();
	}

	@Override
	public boolean insertLeaveType(LeaveType leaveType) throws CustomException {
		return leaveTypeDao.insertLeaveType(leaveType);
	}

	@Override
	public void updateLeaveType(LeaveType leaveType) throws CustomException {
		// TODO Auto-generated method stub
		leaveTypeDao.updateLeaveType(leaveType);
	}

	@Override
	public void deleteLeaveType(String shortName) throws CustomException {
		// TODO Auto-generated method stub
		leaveTypeDao.deleteLeaveType(shortName);
	}

	@Override
	public LeaveType getLeaveTypeByShortName(String shortName) throws CustomException {
		// TODO Auto-generated method stub
		return leaveTypeDao.getLeaveTypeByShortName(shortName);
	}

	@Override
	public void bulkDeleteLeaveType(List<String> shortNameList) throws CustomException {
		leaveTypeDao.bulkDeleteLeaveType(shortNameList);
	}

	@Override
	public boolean uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return leaveTypeDao.uploadFile(file);

	}
}
