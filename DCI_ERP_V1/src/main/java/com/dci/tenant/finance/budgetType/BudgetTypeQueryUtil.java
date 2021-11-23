package com.dci.tenant.finance.budgetType;

public class BudgetTypeQueryUtil {

	public static final String GET_ACCT_LIST = "select txt.id,txt.text from " + "(select sub_group_acct_code as id,sub_group_acct_name as text from sub_group_acct_master where group_head_code ='E' " + "union " + "select sub_group_acct_code as id,sub_group_acct_name as text from sub_group_acct_master where sub_group_acct_code ='2000') txt order by text";

	public static final String GET_FIN_YEAR_LIST = "select distinct financial_year_id as id,financial_year_id as text from financial_year where company_id =?";

	public static final String SAVE_ALLOCATION = "INSERT INTO budget_allocation( company, financial_year, expense_type, misc_expenses, " + "salaries, communication, travel_entertainment, prof_fees, maintanance,asset_purchase, supplier_payment, status) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_BUDGET_TYPE_LIST = "select budget_type_id,budget_type,expenses,amount as amount from budget_type order by budget_type_id desc ";

	public static final String UPDATE_ALLOCATION = "UPDATE budget_allocation SET company=?, financial_year=?, expense_type=?, misc_expenses=?, salaries=?, communication=?, travel_entertainment=?, " + "prof_fees=?, maintanance=?, asset_purchase=?, supplier_payment=?, status=? WHERE budget_allocation_id=?";

	public static final String APPROVE_ALLOCATION = "UPDATE budget_allocation SET status=? WHERE budget_allocation_id=?";

	public static final String DELETE_ALLOCATION = "Delete from budget_allocation WHERE budget_allocation_id=?";

	public static final String CHECK_ALLOCATION = "select count(*) from budget_allocation where company=? and financial_year = ? and expense_type=?";

	public static final String GET_ACCT_NAME = "select sub_group_acct_name from sub_group_acct_master where sub_group_acct_code =?";

	public static final String GET_ACCT_CODE = "select sub_group_acct_code from sub_group_acct_master where sub_group_acct_name =?";

	public static final String GET_BUDGET_TYPE_EDIT = "select budget_type_id,budget_type,expenses,amount from budget_type where budget_type_id =?";

	public static final String UPDATE_BUDGET_TYPE = "UPDATE budget_type SET budget_type=?, expenses=?,amount=? WHERE budget_type_id=?";

	public static final String INSERT_BUDGET_TYPE = "INSERT INTO budget_type(budget_type, expenses,amount) VALUES (?,?,?);";

}
