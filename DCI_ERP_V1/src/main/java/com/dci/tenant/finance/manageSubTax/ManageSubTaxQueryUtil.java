package com.dci.tenant.finance.manageSubTax;

public class ManageSubTaxQueryUtil {

	public static String SELECT_SUB_TAX_LIST = "SELECT sub_tax_id,sub_tax_code subTaxCode, sub_tax_name subTaxName,is_active isactive FROM sub_tax order by sub_tax_code asc";

	public static String INSERT_SUB_TAX = "INSERT INTO sub_tax(sub_tax_code,sub_tax_name,sub_tax_type,tax_account_id,sub_tax_method,sub_tax_amount,sub_tax_percentage,is_active) VALUES (:subTaxCode,:subTaxName,:subTaxTypeId,:subTaxAccount,:subTaxMethodId,:subTaxFixedAmount,:subTaxPercentage,:isActive)";

	public static String CHECK_COUNT_SUB_TAX = "SELECT count(*) FROM sub_tax WHERE sub_tax_name=?";

	public static String DELETE_SUB_TAX = "delete from sub_tax where sub_tax_id=?";

	public static String UPDATE_SUB_TAX = "update sub_tax set sub_tax_code=:subTaxCode,sub_tax_name=:subTaxName,sub_tax_type=:subTaxTypeId,tax_account_id=:subTaxAccount,sub_tax_method=:subTaxMethodId,sub_tax_amount=:subTaxFixedAmount,sub_tax_percentage=:subTaxPercentage,is_active=:isActive where sub_tax_id=:subTaxId";

	public static String SELECT_VALUE_LIST = "select value subTaxMethod,def_table_id subTaxMethodId from def_table where form_field_id=3";

	public static String SELECT_TYPE_LIST = "select value subTaxType, def_table_id subTaxTypeId from def_table where form_field_id=4";

	public static String SELECT_EDIT_LIST = "select sub_tax_id subTaxId,tax_account_id subTaxAccount,sub_tax_code subTaxCode,sub_tax_name subTaxName,sub_tax_method subTaxMethodId,sub_tax_type subTaxTypeId,is_active isactive,sub_tax_percentage subTaxPercentage,sub_tax_amount subTaxFixedAmount,tax_Account_id subTaxAccount,acct_head_name acctName  from sub_tax left join account_head_master ah on ah.acct_head_code = tax_Account_id where sub_tax_id=?";
}