package com.dci.payroll.tds.otherheadentry;

public class OtherHeadEntryQueryUtil {

	public static final String SELET_OTHER_ENTRY = " SELECT OH.*,coalesce(amount,0) amount,? employee_id, ? financial_year_id  from other_income_head OH LEFT OUTER JOIN employee_other_income EO ON OH.other_income_head_id=EO.other_income_head_id AND financial_year_id=? AND employee_id=?";

	public static final String INSERT_OTHERHEAD = "INSERT INTO employee_other_income" + " (employee_id,financial_year_id,amount,other_income_head_id)" + " VALUES (:employee_id,:financial_year_id,:amount,:other_income_head_id)";

	public static String otherHeadEntryIdAutoGen = "SELECT CASE WHEN MAX(employee_other_income_id) IS NULL THEN '1' ELSE MAX(employee_other_income_id)+1 END FROM employee_other_income";

	public static String CHECK_OTHER_HEAD_ENTRY = "SELECT * FROM employee_other_income where employee_id =? and  financial_year_id=? and other_income_head_id=?";

	public static String CHECK_COUNT_TAX = "select count(*) from other_income_head where other_income_head_id=?";

	public static String SELECT_OTHERHEADENTRY_BYID = "select other_income_head_id ,other_income_head_name ,description WHERE other_income_head_id=?";

	public static String UPDATE_OTHERHEAD = "UPDATE employee_other_income SET amount=:amount  where employee_id =:employee_id and  financial_year_id=:financial_year_id and other_income_head_id=:other_income_head_id";

	public static String DELETE_OTHERINCOME = "Delete from employee_other_income  where employee_id =:employee_id and  financial_year_id=:financial_year_id and other_income_head_id=:other_income_head_id";

	public static String DELETE_OTHERHEAD = "Delete from other_income_head where other_income_head_id=?";
}