package com.dci.tenant.finance.manualattendance;

import java.util.List;

import com.dci.common.util.CustomException;




public interface ManualAttendanceDAO {
	public ManualAttendanceResultBean getDepartmentList(String branchId) throws CustomException;

	public ManualAttendanceResultBean getShiftList() throws CustomException;

	public ManualAttendanceResultBean getEmployeeList(ManualAttendance manualattend);

	public List getShiftTimingList(String shiftId);

	public List<ManualAttendance> getAttendanceList(int limit, int offset) throws CustomException;

	public ManualAttendance insertAttendance(ManualAttendance objAttendance) throws CustomException;

	public boolean deleteAttendance(Integer attendanceId) throws CustomException;

	public boolean updateAttendance(ManualAttendance objManualAttendance) throws Exception;

	public ManualAttendance getAttendanceById(Integer attendanceId) throws CustomException;

	public ManualAttendanceResultBean getMyAttendanceDetails() throws CustomException;

	public boolean saveMyAttendance(ManualAttendance objAttendance) throws CustomException;
}
