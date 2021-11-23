package com.dci.tenant.finance.manageTax;

public class ManageTaxQueryUtil {

	public static String SELECT_TAX_LIST = "SELECT tax_id taxId,tax_code taxCode, tax_name taxName,is_active isactive FROM tax order by tax_id desc";

	public static String INSERT_TAX = "INSERT INTO tax(tax_code,tax_name,tax_type,tax_account_id,tax_method,tax_amount,tax_percentage,is_active) VALUES (:code,:taxName,:taxTypeId,:taxAccount,:taxMethodId,:taxFixedAmount,:taxPercentage,:isActive) returning tax_id";

	public static String INSERT_TAX_SUBTAX = "INSERT INTO tax_subtax(tax_id,sub_tax_id) VALUES(:taxId,:subTaxId)";

	public static final String DELETE_TAX_SUBTAX = "delete from tax_subtax where tax_id=:taxId";

	public static String CHECK_COUNT_TAX_name = "SELECT count(*) FROM tax WHERE lower(tax_name)=?";

	public static String CHECK_COUNT_TAX_code = "SELECT count(*) FROM tax WHERE lower(tax_code)=?";

	public static String CHECK_UPDATE_COUNT_TAX = "SELECT count(*) FROM tax WHERE tax_id<>? and tax_name=?";

	public static String SELECT_VALUE_LIST = "select value taxMethod, def_table_id taxMethodId from def_table where form_field_id=3";

	public static String SELECT_TYPE_LIST = "select value taxType,def_table_id taxTypeId from def_table where form_field_id=4";

	public static String SELECT_SUBTAX_LIST = "select sub_tax_id subTaxId,sub_tax_id as id,sub_tax_name subTaxName,sub_tax_name as text from sub_tax order by sub_tax_name asc";

	public static String DELETE_TAX = "delete from tax where tax_id=?";

	public static String DELETE_TAX_SUB = "delete from tax_subtax where tax_id=?";

	public static String SELECT_EDIT_LIST = "select tax.tax_id taxId,tax_code code,tax_name taxName,tax_method taxMethodId,def_table.value as taxMethod,tax_type taxTypeId, " + " COALESCE(tax_account_id,'') taxAccount,tax.is_active isActive, CASE WHEN def_table.value='Percentage' THEN tax_percentage ELSE tax_amount END AS taxMethodAmount, " + "COALESCE(sub_tax_id,0) subTaxId from tax left join tax_subtax on tax_subtax.tax_id = tax.tax_id " + "left join def_table on def_table.def_table_id = tax_method where tax.tax_id=?";

	public static String SELECT_EDIT_SUBTAX_LIST = "select sub_tax_id subTaxId from tax_subtax where tax_id=?";

	public static String UPDATE_TAX = "update tax set tax_code=:code,tax_name=:taxName,tax_type=:taxTypeId,tax_account_id=:taxAccount,tax_method=:taxMethodId,tax_amount=:taxFixedAmount,tax_percentage=:taxPercentage,is_active=:isActive where tax_id=:taxId";

	public static String DELETE_DETAIL = "delete from tax_subtax where tax_id =?";

	public static final String ACCT_HEAD_COMBO = "select acct_head_code id,acct_head_name as text from account_head_master where subgroup_acct_code =?";

	public static final String TAX_ACCT_HEAD = "select tax_Account_id from tax where tax_type =? order by tax_id desc limit 1";

	public static final String SUB_TAX_ACCT_HEAD = "select tax_Account_id from sub_tax where sub_tax_type =? order by sub_tax_id desc limit 1";

	public static final String SELECT_CHILD_TAX_DETAILS = "select value as subTaxMethod, sub_tax_percentage subTaxPercentage, sub_tax_amount subTaxAmount from sub_tax " + "left join def_table on def_Table_id = sub_tax_method where sub_tax_id=?";

}