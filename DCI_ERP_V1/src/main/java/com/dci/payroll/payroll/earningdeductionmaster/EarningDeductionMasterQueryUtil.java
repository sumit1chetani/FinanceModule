package com.dci.payroll.payroll.earningdeductionmaster;

public class EarningDeductionMasterQueryUtil {

	public static final String earningDeductionMasterSelect = "	select pay_component_id,pay_component_name,value_type,CASE WHEN value IS NULL THEN 0.00 ELSE value END AS value,percentage_applied_on,status,formula,is_permanant AS permanant, is_allowance AS allowance,case when pay_component_type = 1 then 'Earning' else 'Deduction' end as type,display_order,pay_component_type FROM pay_component ORDER BY pay_component_type ASC,display_order";

	public static final String selectPaycomponentId = "select pay_component_id payComponentId,pay_component_name payComponentName,pay_component_id as id,pay_component_name as text from pay_component where is_permanant=true and pay_component_type=1";

	public static final String INSERT_EARNINGDEDUCTION = "INSERT INTO pay_component" + " (pay_component_id,pay_component_name,is_permanant,is_allowance,value_type,value,percentage_applied_on,status,pay_component_type,display_order, jv_mapping , account_head, debit_account_head,non_standard_deduction)" + " VALUES (:pay_component_id,:pay_component_name,:is_permanant,:is_allowance,:value_type,:value,:percentage_applied_on,:status,:pay_component_type,:display_order,:jv_mapping,:account_head,:debit_account_head,:nonStandardDeduction)";

	public static String SELECT_EARNINGDEDUCTIONBYID = "select pay_component_id,pay_component_type,pay_component_name,value,value_type,percentage_applied_on,status,formula,is_permanant, is_allowance ,display_order , coalesce(jv_mapping,false) jv_mapping ,account_head, debit_account_head, coalesce(non_standard_deduction,false) non_standard_deduction  FROM pay_component where pay_component_id=?";

	public static String UPDATE_EARNINGDEDUCTION = "UPDATE pay_component SET pay_component_name=:pay_component_name, is_permanant=:is_permanant, is_allowance=:is_allowance, value_type=:value_type, value=:value,percentage_applied_on=:percentage_applied_on, status=:status, pay_component_type=:pay_component_type, display_order=:display_order , jv_mapping =:jv_mapping ,account_head =:account_head , debit_account_head=:debit_account_head, non_standard_deduction=:nonStandardDeduction  WHERE pay_component_id=:pay_component_id";

	public static String DELETE_EARNINGDEDUCTION = "Delete from pay_component where pay_component_id=?";

}