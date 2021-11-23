package com.dci.payroll.tds.employeeTaxParameter;

import java.util.List;

public interface EmployeeTaxParameterDAO {
	List<EmployeeTaxParameterBean> getEmployeeTaxParameterList(String companyId, String branchId, Integer departmentId, String employeeId) throws Exception;

	public EmployeeTaxParameterBean getEmpTaxParambyEmpId(String employeeId) throws Exception;

	public boolean insertEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception;

	public boolean updateEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception;

	public boolean deleteEmpTaxParam(String employeeId) throws Exception;
}