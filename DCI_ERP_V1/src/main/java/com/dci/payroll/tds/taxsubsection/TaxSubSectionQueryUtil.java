package com.dci.payroll.tds.taxsubsection;

public class TaxSubSectionQueryUtil {
	public static final String TAXSUBSEC_LIST = "select tax_sub_section_code,tax_section_code,tax_sub_section_description,tax_sub_section_max_limit,is_computed computed,display_order,tax_sub_section_status from tax_sub_section ORDER BY display_order";

	public static final String TAXSUBSEC_BY_CODE = "select tax_sub_section_code,tax_section_code,tax_sub_section_description,tax_sub_section_max_limit,is_computed computed,display_order,tax_sub_section_status from tax_sub_section WHERE tax_sub_section_code=?";

	public static final String TAXSECTION_LIST = "SELECT tax_section_code FROM tax_section WHERE tax_section_status=true";

	public static final String INSERT_TAXSUBSEC = "INSERT INTO tax_sub_section(tax_sub_section_code,tax_section_code,tax_sub_section_description,tax_sub_section_max_limit,is_computed,display_order,tax_sub_section_status) VALUES(:tax_sub_section_code,:tax_section_code,:tax_sub_section_description,:tax_sub_section_max_limit,:is_computed,:display_order,:tax_sub_section_status)";

	public static final String UPDATE_TAXSUBSEC = "UPDATE tax_sub_section SET tax_section_code=:tax_section_code,tax_sub_section_description=:tax_sub_section_description,tax_sub_section_max_limit=:tax_sub_section_max_limit,is_computed=:is_computed,display_order=:display_order,tax_sub_section_status=:tax_sub_section_status WHERE tax_sub_section_code=:tax_sub_section_code";

	public static final String DELETE_TAXSUBSEC = "DELETE FROM tax_sub_section WHERE tax_sub_section_code=?";
}