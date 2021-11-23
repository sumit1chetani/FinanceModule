package com.dci.tenant.finance.BudgetReport;

public class BudgetReportQueryUtil {

	public static String list = " select company as companyName,financial_year as financeyear,expense_type as expense_type,amount as amount," + "	b.status as status,company_name as companyCode from budget_allocation b " + "	left join  company c on company=c.company_id " + "	where  1=1 ";

}
