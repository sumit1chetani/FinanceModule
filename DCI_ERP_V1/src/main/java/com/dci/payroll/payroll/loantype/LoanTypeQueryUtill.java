package com.dci.payroll.payroll.loantype;

public class LoanTypeQueryUtill {
	public static final String SELECT_LOANTYPE_LIST = "SELECT loan_type_id,loan_type_name,flat_or_diminishing,CASE WHEN interest_rate IS NULL THEN 0 ELSE interest_rate END AS interest_rate,status FROM loan_type  where loan_type.company_id = ? ";
	// public static final String SELECT_LOANTYPE_BY_ID =
	// "SELECT loan_type_id loanId, loan_type_name loanName, status status FROM
	// loan_type where loan_type_id=?";
	public static final String SELECT_ACTIVELOANTYPE_LIST = "SELECT loan_type_id,loan_type_id as id,loan_type_name,loan_type_name as text FROM loan_type WHERE status='t' and  loan_type.company_id = ? ";

	public static final String SELECT_LOANTYPE_BY_ID = "SELECT loan_type_id loanTypeId,loan_type_name loanTypeName,flat_or_diminishing flatId,CASE WHEN interest_rate IS NULL THEN 0 ELSE interest_rate END AS interestRate,status status FROM loan_type WHERE loan_type_id=?";

	public static final String INSERT_LOAN_TYPE = "INSERT INTO loan_type(loan_type_id,loan_type_name,interest_rate,flat_or_diminishing,status,company_id) VALUES(:loanTypeId,:loanTypeName,:interestRate,:flatId,:status,:companyId)";

	public static final String UPDATE_LOAN_TYPE = "UPDATE loan_type SET loan_type_name=:loanTypeName,interest_rate=:interestRate,flat_or_diminishing=:flatOrDiminishing,status=:status WHERE loan_type_id=:loanTypeId";

	public static final String DELETE_LOAN_TYPE = "DELETE FROM loan_type WHERE loan_type_id=?";

	public static final String INSERT_EARNINGDEDUCTION1 = "INSERT INTO pay_component" + " (pay_component_id,pay_component_name,is_permanant,is_allowance,value_type,value,percentage_applied_on,status,pay_component_type,display_order,jv_mapping)" + " VALUES (:pay_component_id,:pay_component_name,:is_permanant,:is_allowance,:value_type,:value,:percentage_applied_on,:status,:pay_component_type,:display_order,:jv_mapping)";

	public static String UPDATE_EARNINGDEDUCTION1 = "UPDATE pay_component SET pay_component_name=:pay_component_name, is_permanant=:is_permanant, is_allowance=:is_allowance, value_type=:value_type, value=:value,percentage_applied_on=:percentage_applied_on, status=:status, pay_component_type=:pay_component_type, display_order=:display_order , jv_mapping =:jv_mapping   WHERE pay_component_id=:pay_component_id";

}
