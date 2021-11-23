package com.dci.tenant.finance.financialyear;

public class FinancialyearQueryUtil {

	public static String sViewFinancialYear = "select financial_year_id fyId ,to_char(fy_start_date,'dd/mm/yyyy') fyFrom,to_char(fy_end_date,'dd/mm/yyyy') fyTo,fy_short_id fyShortId,c.company_code companyCode,company_name companyName,is_current iscurrent from financial_year fy left join company_master c on fy.company_code = c.company_code order by fy_short_id desc";

	public static final String FY_CODE = "SELECT CASE WHEN MAX(fy_short_id) IS NULL THEN 'FY001' ELSE RPAD(MAX(fy_short_id),2,'FY')||LPAD (cast(cast((SUBSTRING(MAX(fy_short_id),3)) as int)+1 as text),3,'0') END FROM financial_year";

	public static final String SAVE_FY = "INSERT INTO financial_year(financial_year_id, fy_start_date, fy_end_date, fy_short_id, company_code,is_current) VALUES (?, to_date(?,'DD-MM-YY'), to_date(?,'DD-MM-YY'), ?, ?,?)";

	public static final String UPDATE_FY = "UPDATE financial_year SET is_current=?, fy_start_date=to_date(?,'DD-MM-YY'), fy_end_date=to_date(?,'DD-MM-YY'), financial_year_id=?, company_code=? WHERE fy_short_id=?";

	public static final String UPDATE_CURRENT = "UPDATE financial_year SET  is_current=? where company_code=?";

	public static final String DELETE_FY = "Delete from financial_year where fy_short_id=?";

	public static final String VALIDATE_FY = "select count(*) from financial_year where financial_year_id = ? and company_code = ?";

	public static String FY_EDIT = "select financial_year_id fyId ,to_char(fy_start_date,'dd/mm/yyyy') fyFrom,to_char(fy_end_date,'dd/mm/yyyy') fyTo,fy_short_id fyShortId,coalesce(c.company_code,'') companyCode,company_name companyName,is_current iscurrent,is_current as active from financial_year fy left join company_master c on fy.company_code = c.company_code where fy_short_id =?";

}
