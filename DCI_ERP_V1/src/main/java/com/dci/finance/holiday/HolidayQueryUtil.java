package com.dci.finance.holiday;

public class HolidayQueryUtil {

	// public static final String holidaySelect =
	// "select holiday.holiday_id ,branch.branch_name,to_char(holiday.holiday_date, 'DD/MM/YYYY') as holidaydate,to_char(holiday_date, 'Day') as days ,holiday.holiday_name from holiday,branch where holiday.branch_id=branch.branch_id order by holiday_date asc";
/*
	public static final String holidaySelect = " select holiday_id as holidayId,h.branch_id as branchid,to_char(h.holiday_date, 'DD/MM/YYYY') as holidaydate,"
			+ " h.holiday_name as holidayName,b.branch_name as branch, "
			+ " to_char(holiday_date, 'Day') as days,c.short_name as companyName"
			+ " from holiday h  "
			+ " left join branch_master b on h.branch_id::int=b.branch_id "
			+ " left join company_master c on b.company_code=b.company_code ";*/

	public static final String holidaySelect ="select holiday_id as holidayId,h.branch_id as branchid,holiday_date as holidaydate,h.holiday_name as holidayName,b.brnch_nam as branch,c.company_name as companyName "
			+ "  from holiday h  "
			+ "  left join branch b on b.brnch_id::char=h.branch_id "
			+ "  left join company_master c on c.company_code=h.company_code ";
	public static final String holidayList = "select holiday.branch_id as branchId, holiday.holiday_id as holidayId, to_char(holiday.holiday_date, 'DD/MM/YYYY') as holidaydate ,holiday.holiday_name as holidayName,(select company_id from company where company.company_id=b.company_id) as companyId, to_char(holiday_date, 'Day') as days, b.branch_name as branch from holiday inner join branch b on holiday.branch_id=b.branch_id order by holiday_date asc";

	// public static final String holidayInsert =
	// "insert into holiday(holiday_id,branch_id,holiday_date,holiday_name) values(?,?,?,?) ";

	public static final String holidayInsert = "insert into holiday(holiday_id,holiday_date,holiday_name,branch_id,company_code) values(?,?,?,?,?) ";
	//public static final String getBranch = "SELECT branch_id FROM branch_master WHERE branch_name = ?";

	public static final String getBranch = "SELECT brnch_id as id,brnch_nam as text FROM branch WHERE brnch_name = ?";
	public static final String getHolidayId = "SELECT CASE WHEN MAX(holiday_id) IS NULL THEN '1' ELSE MAX(holiday_id)+1 END FROM holiday";

	//public static final String getHolidayEditList = "select holiday.holiday_id as holidayId,b.branch_name as branch , to_char(holiday.holiday_date, 'DD/MM/YYYY') as date ,holiday.holiday_name as holidayName,(select company_code from company_master where company_master.company_code=b.company_code) as companyId, holiday.branch_id as branchId from holiday inner join branch_master b on holiday.branch_id::int=b.branch_id where holiday.holiday_id=?";

	/*public static final String getHolidayEditList = "select holiday.holiday_id as holidayId,b.branch_name as branch , holiday.holiday_date as date ,holiday.holiday_name as holidayName, "
	 + "(select company_code from company_master where company_master.company_code=b.company_code) as companyId, holiday.branch_id as branchId from holiday "
	 + "inner join branch b on holiday.branch_id::int=b.branch_id where holiday.holiday_id=?";*/
	
	public static final String getHolidayEditList = "select holiday.holiday_id as holidayId , holiday.branch_id as branchId,holiday.holiday_date as date ,holiday.holiday_name as holidayName,b.brnch_nam as branch ,c.company_code as  companyId  from holiday "
	 + " left join branch b on b.brnch_id::char=holiday.branch_id "
	 +  " left join company_master c on c.company_code=holiday.company_code " 
	 + "   where holiday.holiday_id=? ";
	
	public static final String updateHoliday = "update holiday set holiday_date= ?,holiday_name= ?,branch_id=? where holiday_id=?";

	public static final String deleteHoliday = "delete  from holiday where holiday_id= ?";

	public static final String INSERT_HOSPITAL_UPLOAD = "INSERT INTO holiday(holiday_id, branch_id, holiday_name, holiday_date) values(?, ?, ?, ?)";

	public static final String GET_Branch_LIST = "select brnch_id as id,brnch_name as text from branch";

	public static final String GET_GRADE_LIST = "select grade_id as id,name as text from grade ";

	public static final String GET_EMP_DEPT_LISt = "select emp_id as id,emp_name as text from employee_master  where dept=?";
	public final static String get_branch_list = "select brnch_id as id,brnch_nam as text  from branch  order by brnch_nam";

}
