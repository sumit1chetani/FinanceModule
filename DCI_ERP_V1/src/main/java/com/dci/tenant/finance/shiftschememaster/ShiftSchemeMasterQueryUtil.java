package com.dci.tenant.finance.shiftschememaster;

public class ShiftSchemeMasterQueryUtil {

	public static final String GetShiftSchemeMasterList = "select scheme_name as schemeName,TO_CHAR(valid_from,'dd/mm/yyyy') as validityFrom,TO_CHAR(valid_to,'dd/mm/yyyy') as validityTo, scheme_id as schemeId from shift_scheme s where company_id = ? order by scheme_name desc";

	public static final String sCheckShiftName = "SELECT count(*) FROM shift_scheme WHERE scheme_name = ? ";

	public static String SELECT_SHIFT_NAME_LIST = "select shift_id as shiftCode,shift_id id,shift_name as shiftName,shift_name as text from shift s where efect_from_date <= ? and s.company_id =? ";

	public static String sGetShiftSchemeMasterEditList = "select scheme_name as schemeName,To_CHAR(valid_from,'dd/mm/yyyy') as validityFrom,TO_CHAR(valid_to,'dd/mm/yyyy') as validityTo from shift_scheme where scheme_name=? ";

	public static final String sCheckAllShiftName = "SELECT count(*) FROM shifts_in_scheme WHERE scheme_name = ? and shift_id= ? and week_day= ? ";

	public static String sGetShiftSchemeMasterWeekList = "select scheme_name as schemeName,week_day as weekDay,shift_id as shiftId from shifts_in_scheme where scheme_name=?";

	public static final String sUpdateDeleteShiftSchemeDetails = "delete from shifts_in_scheme where scheme_name=? and week_day= ?";

	public static String sDeleteShiftSchemeMaster = "delete from shift_scheme where scheme_Id=? ";

	public static String sDeleteEmployeeShiftMaster = "delete from employee_shift_scheme where scheme_Id=? ";

	public static String sDeleteShiftSchemeDetails = "delete from shifts_in_scheme where scheme_name=? ";

	public static String sCheckShiftNameDetails = "SELECT count(*) FROM shifts_in_scheme WHERE scheme_name = ? ";

	public static String sCheckShiftEmpDetails = "SELECT count(*) FROM employee_shift_scheme WHERE scheme_Id = ? ";

	public static final String INSERT_SHIFTSCHEME_UPLOAD = "INSERT INTO shift_scheme(scheme_name, valid_from, valid_to) values(?, ?, ?)";

	public static final String getSchemeName = "select scheme_name from shift_scheme where scheme_name=?";

	public static final String INSERT_SHIFT_SCHEME = "INSERT INTO shift_scheme ( scheme_name ,valid_from, valid_to,company_id) values (?,?,?,?)";

	public static final String UPDATE_SHIFT_SCHEME = "Update shift_scheme set  scheme_name=?,valid_from=?,valid_to=? where scheme_name=?";

	public static String sCheckSchemeName = "SELECT count(*) FROM shifts_in_scheme WHERE scheme_name = ? and week_day=?";

}
