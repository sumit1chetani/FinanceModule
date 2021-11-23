package com.dci.finance.hrmanageAttendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrManageAttendanceServiceImpl implements HrManageAttendanceService {

	@Autowired
	HrManageAttendanceDAO HrmanageAttendanceDAO;

	@Override
	public HrManageAttendanceResultBean saveHrManageAttendance(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.saveHrManageAttendance(objBean);
	}

	@Override
	public HrManageAttendanceResultBean getHrManageAttendance() {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getHrManageAttendance();
	}

	@Override
	public HrManageAttendanceBean editHrManageAttendance(String departmentId, String attendanceDate) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.editHrManageAttendance(departmentId, attendanceDate);
	}

	@Override
	public HrManageAttendanceResultBean updateHrManageAttendance(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.updateHrManageAttendance(objBean);
	}

	@Override
	public HrManageAttendanceResultBean deleteHrManageAttendance(int attendanceId) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.deleteHrManageAttendance(attendanceId);
	}

	@Override
	public HrManageAttendanceResultBean getEmployeeList1(HrManageAttendanceBean objBean) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getEmployeeList1(objBean);
	}

	@Override
	public HrManageAttendanceResultBean getAcademicYearList() {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getAcademicYearList();
	}

	@Override
	public HrManageAttendanceResultBean getDepartmentName() {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getDepartmentName();
	}

	@Override
	public HrManageAttendanceResultBean getFirstName() {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getFirstName();
	}

	@Override
	public List<HrManageAttendanceBean> getEmployeeList(String departmentId) {
		// TODO Auto-generated method stub
		return HrmanageAttendanceDAO.getEmployeeList(departmentId);
	}

}
