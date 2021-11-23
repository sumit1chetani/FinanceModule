package com.dci.finance.leavedeclare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveDeclareServiceImpl implements LeaveDeclareService {
	@Autowired
	LeaveDeclareDAO leaveDAO;

	@Override
	public List<LeaveDeclareBean> getLeaveList() throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.getLeaveList();
	}

	@Override
	public LeaveDeclareResultBean getGradeList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.getGradeList(companyId);
	}

	@Override
	public LeaveDeclareResultBean getYearList() throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.getYearList();
	}

	@Override
	public LeaveDeclareResultBean getLeaveType(String branchId,int yearId) throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.getLeaveType(branchId, yearId);
	}

	@Override
	public void saveLeaveDetails(LeaveDeclareResultBean leaveBean) throws Exception {
		// TODO Auto-generated method stub
		leaveDAO.saveLeaveDetails(leaveBean);
	}

	@Override
	public LeaveDeclareResultBean getEditList(String branch, int year) throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.getEditList(branch, year);
	}

	@Override
	public boolean deleteLeave(int gradeId, int year) throws Exception {
		// TODO Auto-generated method stub
		return leaveDAO.deleteLeave(gradeId, year);
	}

}