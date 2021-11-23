package com.dci.tenant.finance.shiftmaster;

public class ShiftMasterQueryUtil {

	public static String GetShiftMasterList = "select shift_id as shiftId,shift_name as shiftName,code as shiftCode,description as description,TO_CHAR(efect_from_date,'dd/mm/yyyy') as effectFromDate,start_time as startTime,end_time as endTime,break_start_time as breakStartTime,break_end_time as breakEndTime,threshold_time as thresholdTime,is_night_shift as nightShift,late_after as lateAfter,early_exit as earlyExit,number_of_time_allowed as noOfTimeAllowed,min_working_hrs_half_day as halfDay,min_working_hrs_full_day as fullDay from shift s where s.company_id = ?";

	public static String sCheckShiftCode = "SELECT count(*) FROM shift WHERE code = ? ";

	public static String sGetShiftMasterEditList = "select shift_id as shiftId,shift_name as shiftName,code as shiftCode,description as description,TO_CHAR(efect_from_date,'dd/mm/yyyy') as effectFromDate,start_time as startTime,end_time as endTime,break_start_time as breakStartTime,break_end_time as breakEndTime,threshold_time as thresholdTime,is_night_shift as nightShift,late_after as lateAfter,early_exit as earlyExit,number_of_time_allowed as noOfTimeAllowed,min_working_hrs_half_day as halfDay,min_working_hrs_full_day as fullDay from shift where shift_id=? ";

	public static String sDeleteShiftMaster = "delete from shift where shift_id=?";

	public static String sCheckShiftName = "SELECT count(*) FROM shift WHERE shift_name = ? ";

	public static String getShiftName = "SELECT shift_name FROM shift WHERE shift_id = ?";

	public static String UPDATE_SHIFT_MASTER = "update shift set shift_name=?, code=?, description=?, efect_from_date=?, start_time=?, end_time=?,break_start_time=?, break_end_time=?, threshold_time=?, is_night_shift=?, late_after=?, early_exit=?,number_of_time_allowed=?, min_working_hrs_half_day=?, min_working_hrs_full_day=? where shift_id=?";

	public static final String INSERT_SHIFT_UPLOAD = "INSERT INTO shift(shift_name, code, description, efect_from_date, start_time, end_time, break_start_time, break_end_time, threshold_time, is_night_shift, late_after, early_exit, number_of_time_allowed, min_working_hrs_half_day, min_working_hrs_full_day) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String INSERT_SHIFT_MASTER = "INSERT INTO shift ( shift_name, code, description, efect_from_date, start_time, end_time,break_start_time, break_end_time, threshold_time, is_night_shift, late_after, early_exit,number_of_time_allowed, min_working_hrs_half_day, min_working_hrs_full_day ) values (?,?,?,?,to_timestamp(?,'hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?)";

}
