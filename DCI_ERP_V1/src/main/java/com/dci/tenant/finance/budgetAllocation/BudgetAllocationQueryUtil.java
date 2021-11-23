package com.dci.tenant.finance.budgetAllocation;

public class BudgetAllocationQueryUtil {

	public static final String GET_COMPANY_LIST = "select distinct cu.company_code as id,company_name as text from company_user cu inner join company_master c on cu.company_code = c.company_code ";

	public static final String GET_FIN_YEAR_LIST = "select distinct financial_year_id as id,financial_year_id as text from financial_year where company_code =?  order by financial_year_id desc ";

	/*
	 * public static final String SAVE_ALLOCATION =
	 * "INSERT INTO budget_allocation( company, financial_year, expense_type, misc_expenses, "
	 * +
	 * "salaries, communication, travel_entertainment, prof_fees, maintanance,asset_purchase, supplier_payment, status) "
	 * + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 */

	public static final String SAVE_ALLOCATION = "INSERT INTO budget_allocation( company, financial_year, expense_type, status,amount) " + "VALUES (?, ?, ?, ?, ?) returning budget_allocation_id";

	public static final String GET_ALLOCATION_LIST = "SELECT budget_allocation_id, company,company_name companyName, financial_year, expense_type, b.status   " + "FROM budget_allocation b inner join company c on b.company = c.company_id order by budget_allocation_id desc";

	public static final String GET_ALLOCATION_EDIT = "SELECT budget_allocation_id,company,company_name companyName, financial_year, expense_type, b.status,amount " + "FROM budget_allocation b inner join company c on b.company = c.company_id where budget_allocation_id =? order by budget_allocation_id desc";

	/*
	 * public static final String UPDATE_ALLOCATION =
	 * "UPDATE budget_allocation SET company=?, financial_year=?, expense_type=?, misc_expenses=?, salaries=?, communication=?, travel_entertainment=?, "
	 * +
	 * "prof_fees=?, maintanance=?, asset_purchase=?, supplier_payment=?, status=? WHERE budget_allocation_id=?"
	 * ;
	 */

	public static final String UPDATE_ALLOCATION = "UPDATE budget_allocation SET company=?, financial_year=?, expense_type=?, status=? ,amount=? WHERE budget_allocation_id=?";

	public static final String APPROVE_ALLOCATION = "UPDATE budget_allocation SET status=? WHERE budget_allocation_id=?";

	public static final String DELETE_ALLOCATION = "Delete from budget_allocation WHERE budget_allocation_id=?";

	public static final String CHECK_ALLOCATION = "select count(*) from budget_allocation where company=? and financial_year = ? and expense_type=?";

	public static final String GET_BUDGET_TYPE_COLUMNS = "select expenses from budget_type where lower(budget_type)=lower(?)";

	public static final String SAVE_ALLOCATION_ACCOUNTS = "INSERT INTO budget_allocation_account_mapping( budget_allocation_id, sub_group_account,amount)VALUES (?, ?, ?)";

	public static final String GET_ALLOCATION_ACCOUNT = "select sub_group_account subGrpCode,sub_group_acct_name subGrpName,amount from budget_allocation_account_mapping ba inner join sub_group_acct_master sg on sg.sub_group_acct_code = ba.sub_group_account where budget_allocation_id=?";

	public static final String UPDATE_ALLOCATION_AMOUNT = "UPDATE budget_allocation_account_mapping SET amount=? WHERE budget_allocation_id=? and sub_group_account=?";

	public static final String GET_FIN_YEAR_LIST_BUDGET = "select distinct financial_year_id as id,financial_year_id as text from financial_year ";

	public static final String GET_TDS_LIST = " select  tds_code as id,tds_type as text from tds_master ";

	public static final String GET_Vendor_list = "select  supplier_acct_code as id,entity_name as text from entity";

	public static final String GET_getaccontnameTds_list = "select acct_head_code as id ,acct_head_name as text from account_head_master where acct_head_name  like '%TDS%'";
}
