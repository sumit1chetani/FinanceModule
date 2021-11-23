package com.dci.tenant.finance.manualattendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualAttendanceServiceImpl implements ManualAttendanceService {

	@Autowired
	ManualAttendanceDAO manualAttendanceDAO;

	@Override
	public ManualAttendanceResultBean getDepartmentList(String branchId) throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getDepartmentList(branchId);
	}

	@Override
	public ManualAttendanceResultBean getEmployeeList(ManualAttendance manualattend) {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getEmployeeList(manualattend);

	}

	@Override
	public List getShiftTimingList(String shiftId) {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getShiftTimingList(shiftId);

	}

	@Override
	public ManualAttendanceResultBean getShiftList() throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getShiftList();
	}

	@Override
	public List<ManualAttendance> getAttendanceList(int limit, int offset) throws Exception {

		return manualAttendanceDAO.getAttendanceList(limit, offset);
	}

	@Override
	public ManualAttendance insertAttendance(ManualAttendance objAttendance) throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.insertAttendance(objAttendance);
	}

	@Override
	public boolean deleteAttendance(Integer attendanceId) throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.deleteAttendance(attendanceId);
	}

	@Override
	public boolean updateAttendance(ManualAttendance objManualAttendance) throws Exception {
		return manualAttendanceDAO.updateAttendance(objManualAttendance);
	}

	@Override
	public ManualAttendance getAttendanceById(Integer attendanceId) throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getAttendanceById(attendanceId);
	}

	@Override
	public ManualAttendanceResultBean getMyAttendanceDetails() throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.getMyAttendanceDetails();
	}

	@Override
	public boolean saveMyAttendance(ManualAttendance objAttendance) throws Exception {
		// TODO Auto-generated method stub
		return manualAttendanceDAO.saveMyAttendance(objAttendance);
	}
}
