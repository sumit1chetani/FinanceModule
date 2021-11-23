package com.dci.payroll.tds.tds;

public class TdsQueryUtil {
	public static final String SELECT_TAX_LIST = "select range_from,range_to, rate_in_percentage from tax_rate t, employee_tax_parameters tp where t.tax_payer_type_id = tp.tax_payer_type_id and tp.employee_id = ? and t.financial_year = ? ";

	public static final String SELECT_PAY_LIST = "SELECT * FROM tds_salary(?,?)";

	public static final String SELECT_SUB_SECTION_LIST = "select ss.tax_sub_section_code,ss.tax_sub_section_code,ss.tax_sub_section_description,ss.tax_section_code, coalesce(actual_amount,0) actual_amount, coalesce(declared_amount,0)declared_amount, " + "  case when  not is_computed then " + "  case when coalesce(declared_amount,0) > tax_sub_section_max_limit  then tax_sub_section_max_limit " + "	else  coalesce(declared_amount,0) end " + "  else  case when coalesce(declared_amount,0) > tax_sub_section_max_limit  then tax_sub_section_max_limit "
			+ "  else  coalesce(declared_amount,0) end  end limited from tax_sub_section ss " + "  join ( select tax_sub_section_code, actual_amount, declared_amount from employee_tds_declaration where employee_id = ? and  financial_year_id = ? and tax_sub_section_code!='80U' union  select '80U', case when Ph_type = 1 then 0 when Ph_type = 2 then 50000 when Ph_type = 3 then 75000 end, "
			+ "case when Ph_type = 1 then 0 when Ph_type = 2 then 50000 when Ph_type = 3 then 75000 end from employee_tax_parameters  where employee_id = ?) d on ss.tax_sub_section_code = d.tax_sub_section_code order by display_order";

	public static final String SELECT_SUB_SECTION_LIST_ACTUAL = "select ss.tax_sub_section_code,ss.tax_sub_section_code,ss.tax_sub_section_description,ss.tax_section_code, coalesce(actual_amount,0) actual_amount, coalesce(declared_amount,0)declared_amount, " + "  case when  not is_computed then " + "  case when coalesce(actual_amount,0) > tax_sub_section_max_limit  then tax_sub_section_max_limit " + "	else  coalesce(actual_amount,0) end " + "  else  case when coalesce(actual_amount,0) > tax_sub_section_max_limit  then tax_sub_section_max_limit "
			+ "  else  coalesce(actual_amount,0) end  end limited from tax_sub_section ss " + "  join ( select tax_sub_section_code, actual_amount, declared_amount from employee_tds_declaration where employee_id = ? and  financial_year_id = ? and tax_sub_section_code!='80U' union  select '80U', case when Ph_type = 1 then 0 when Ph_type = 2 then 50000 when Ph_type = 3 then 75000 end, "
			+ "case when Ph_type = 1 then 0 when Ph_type = 2 then 50000 when Ph_type = 3 then 75000 end from employee_tax_parameters  where employee_id = ?) d on ss.tax_sub_section_code = d.tax_sub_section_code order by display_order";

	public static final String SELECT_OTHER_INCOME_LIST = "SELECT OH.other_income_head_id,OH.other_income_head_name,coalesce(EOI.amount,0) amount,coalesce(EOI.amount,0) limited" + " FROM other_income_head OH" + " LEFT OUTER JOIN" + " (SELECT EO.other_income_head_id,coalesce(EO.amount,0) amount" + " FROM employee_other_income EO WHERE EO.employee_id=? AND EO.financial_year_id = ?) EOI" + " ON OH.other_income_head_id=EOI.other_income_head_id" + " ORDER BY OH.display_order";

	public static final String SELECT_MONTH_COUNT = "with  T1 as (select DATE( substr(?,1,4) || '-04-01') + (interval '1' month * generate_series(0,11)) m) select count(*) from T1 where m > now()";

}