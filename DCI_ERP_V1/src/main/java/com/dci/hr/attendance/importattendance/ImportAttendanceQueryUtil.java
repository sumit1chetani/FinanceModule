package com.dci.hr.attendance.importattendance;

public class ImportAttendanceQueryUtil {

	public static final String INSERT_ATTENDENCE_UPLOAD = "INSERT INTO attendance(employee_id, shift_id, attendance_date,in_time,out_time,department_id) values(?, ?, ?, ?, ?, ?)";

}
