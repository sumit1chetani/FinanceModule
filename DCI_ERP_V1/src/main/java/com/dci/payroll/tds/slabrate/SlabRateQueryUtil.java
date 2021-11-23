package com.dci.payroll.tds.slabrate;

public class SlabRateQueryUtil {
	public static final String slabrateSelect = "select tr.*,tp.tax_payer_type_name from tax_rate tr LEFT OUTER JOIN tax_payer_type tp on tr.tax_payer_type_id=tp.tax_payer_type_id WHERE tp.status=true";

	public static final String SELECT_PAYERTYPE = "SELECT tax_payer_type_id as id,tax_payer_type_name as text,tax_payer_type_id as taxPayerTypeId,tax_payer_type_name as taxPayerTypeName FROM tax_payer_type";

	public static final String slabRateById = "select tr.*,tp.tax_payer_type_name from tax_rate tr LEFT OUTER JOIN tax_payer_type tp on tr.tax_payer_type_id=tp.tax_payer_type_id WHERE tr.tax_rate_id=?";

	public static final String INSERT_SLABRATE = "INSERT INTO tax_rate(tax_rate_id,tax_payer_type_id,range_from,range_to,rate_in_percentage,financial_year) VALUES (:tax_rate_id,:tax_payer_type_id,:range_from,:range_to,:rate_in_percentage,:financial_year)";

	public static final String UPDATE_SLABRATE = "UPDATE tax_rate SET tax_payer_type_id=:tax_payer_type_id,range_from=:range_from,range_to=:range_to,rate_in_percentage=:rate_in_percentage,financial_year=:financial_year WHERE tax_rate_id=:tax_rate_id";

	public static final String DELETE_SLABRATE = "DELETE FROM tax_rate WHERE tax_rate_id=?";

	public static String slabRateIdAutoGen = "SELECT CASE WHEN MAX(tax_rate_id) IS NULL THEN '1' ELSE MAX(tax_rate_id)+1 END FROM tax_rate";
}