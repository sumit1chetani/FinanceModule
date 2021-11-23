package com.dci.finance.hrmanageAttendance;

import java.util.List;

public interface HrManageAttendanceService {

	List<HrManageAttendanceBean> getEmployeeList(String departmentId);

	HrManageAttendanceResultBean saveHrManageAttendance(HrManageAttendanceBean objBean);

	HrManageAttendanceResultBean getHrManageAttendance();

	HrManageAttendanceBean editHrManageAttendance(String departmentId, String attendanceDate);

	HrManageAttendanceResultBean updateHrManageAttendance(HrManageAttendanceBean objBean);

	HrManageAttendanceResultBean deleteHrManageAttendance(int attendanceId);

	HrManageAttendanceResultBean getEmployeeList1(HrManageAttendanceBean objBean);

	HrManageAttendanceResultBean getAcademicYearList();

	HrManageAttendanceResultBean getDepartmentName();

	HrManageAttendanceResultBean getFirstName();

}
