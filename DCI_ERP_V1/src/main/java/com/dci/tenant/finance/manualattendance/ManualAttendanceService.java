package com.dci.tenant.finance.manualattendance;

import java.util.List;

public interface ManualAttendanceService {
	ManualAttendanceResultBean getDepartmentList(String branchId) throws Exception;

	ManualAttendanceResultBean getShiftList() throws Exception;

	public List<ManualAttendance> getAttendanceList(int limit, int offset) throws Exception;

	public ManualAttendanceResultBean getEmployeeList(ManualAttendance manualattend);

	public List getShiftTimingList(String shiftId);

	ManualAttendance insertAttendance(ManualAttendance objAttendance) throws Exception;

	ManualAttendance getAttendanceById(Integer attendanceId) throws Exception;

	boolean deleteAttendance(Integer attendanceId) throws Exception;

	public boolean updateAttendance(ManualAttendance objManualAttendance) throws Exception;

	ManualAttendanceResultBean getMyAttendanceDetails() throws Exception;

	boolean saveMyAttendance(ManualAttendance objAttendance) throws Exception;

}
