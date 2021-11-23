package com.dci.payroll.tds.taxsection;

public class TaxsectionQueryUtil {

	public static final String taxsectionSelect = "select tax_section_code,tax_section_code as text,tax_section_description,tax_section_code as id,tax_section_max_limit,display_order,tax_section_status from tax_section";

	public static final String INSERT_TAXSECTION = "INSERT INTO tax_section" + " (tax_section_code,tax_section_description,tax_section_max_limit,display_order,tax_section_status)" + " VALUES (:tax_section_code,:tax_section_description,:tax_section_max_limit,:display_order,:tax_section_status)";

	public static String taxsectionIdAutoGen = "SELECT CASE WHEN MAX(tax_section_code) IS NULL THEN 'T001' ELSE rpad(MAX(tax_section_code),1,'T')|| lpad(cast(cast((SUBSTRING(MAX(tax_section_code),3)) as int)+1 as text),4,'0') END FROM tax_section";

	public static String CHECK_COUNT_TAX = "select count(*) from tax_section where tax_section_code=?";

	public static String SELECT_TAXSECTIONENTRYBYID = "select tax_section_code ,tax_section_description ,tax_section_max_limit ,display_order ,tax_section_status from tax_section WHERE tax_section_code=?";

	public static String UPDATE_TAXSECTION = "UPDATE tax_section SET tax_section_description=:tax_section_description, tax_section_max_limit=:tax_section_max_limit, display_order=:display_order, tax_section_status=:tax_section_status WHERE tax_section_code=:tax_section_code";

	public static String DELETE_TAXSECTION = "Delete from tax_section where tax_section_code=?";

}