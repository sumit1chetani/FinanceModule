package com.dci.payroll.payroll.rate;

public class RateQueryUtil {

	public static final String SELECT_RATELIST = "select id,range_to,range_from,unit_charge from electricity_charges";

	public static final String SELECT_RATE_BY_ID = "select id,range_to,range_from,unit_charge from electricity_charges WHERE id=?";

	public static final String INSERT_RATE = "INSERT INTO electricity_charges(id,range_from,range_to,unit_charge) VALUES (:id,:range_from,:range_to,:unit_charge)";

	public static final String UPDATE_RATE = "UPDATE electricity_charges SET unit_charge=:unit_charge,range_from=:range_from,range_to=:range_to WHERE id=:id";

	public static final String DELETE_RATE = "DELETE FROM electricity_charges WHERE id=?";

	public static String slabRateIdAutoGen = "SELECT CASE WHEN MAX(id) IS NULL THEN '1' ELSE MAX(id)+1 END FROM electricity_charges";
}
