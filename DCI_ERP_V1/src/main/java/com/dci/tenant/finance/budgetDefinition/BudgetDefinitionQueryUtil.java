package com.dci.tenant.finance.budgetDefinition;

public class BudgetDefinitionQueryUtil {

	public static final String INSERT_BUDGET_DEFINITIONS = "INSERT INTO public.budget_definition(company, financial_year, budget_type_id,capex_no, project_name, created_date,flag,amount, cost_center,approve_status )  VALUES ( ?, ?, ?,  ?, ?, now(),?,?,?,'Pending')";

	public static final String UPDATE_BUDGET_DEFINITIONS = "UPDATE public.budget_definition  SET  company=?, financial_year=? , budget_type_id= ?, capex_no= ?, project_name= ?,flag = ? , amount = ? ,  cost_center = ?  WHERE budget_definition_id=?";

	public static final String GET_ALL_BUDGET_DEFINITIONS = "select budget_definition_id as budgetDefinitionId, company as company, financial_year as financial_year, bd.budget_type_id as budgetType,  capex_no as capexNo, project_name as projectName, created_date as createdDate, approve_status as status,(select company_name  from company_master com where com.company_code = bd.company limit 1) as companyName,(select budget_type as budgetTypeName from budget_type where budget_type_id = bd.budget_type_id),flag as flag from budget_definition bd order by budget_definition_id desc";

	public static final String EDIT_BUDGET_DEFINITIONS = "SELECT budget_definition_id asbudgetDefinitionId, company as company, financial_year as financial_year, budget_type_id as budgetType,  capex_no as capexNo, project_name as projectName, created_date as createdDate ,flag as flag , coalesce(amount,0) as amount,  cost_center as costCenter , approve_status as status  FROM public.budget_definition where budget_definition_id = ?";

	public static final String DELETE_BUDGET_DEFINITIONS = "delete from budget_definition where budget_definition_id = ?";

	public static final String GET_BUDGET_TYPE_LIST = "select budget_type_id as id , budget_type as text from budget_type";

	public static final String Approve = "update budget_definition set approve_status = 'Approved' where budget_definition_id = ?";

}
