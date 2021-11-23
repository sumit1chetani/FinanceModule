package com.dci.tenant.finance.ManageCostCenter;

public class ManageCostCenterQueryUtil {
	public static final String COST_CENTER_LIST = "select company_id,cost_center_id,cost_center_code,cost_center_name,cost_center_description,status from cost_center  ORDER BY cost_center_id ";

	public static final String COST_CENTER_BY_ID = "select company_id,cost_center_id,cost_center_code,cost_center_name,cost_center_description,status from cost_center WHERE cost_center_id=?";

	public static final String INSERT_COST_CENTER = "INSERT INTO cost_center(company_id,cost_center_code,cost_center_name,cost_center_description,status) VALUES(:company_id,:cost_center_code,:cost_center_name,:cost_center_description,:status)";

	public static final String UPDATE_COST_CENTER = "UPDATE cost_center SET company_id=:company_id, cost_center_code=:cost_center_code,cost_center_name=:cost_center_name,cost_center_description=:cost_center_description,status=:status WHERE cost_center_id=:cost_center_id";

	public static final String DELETE_COST_CENTER = "DELETE FROM cost_center WHERE cost_center_id=?";
}