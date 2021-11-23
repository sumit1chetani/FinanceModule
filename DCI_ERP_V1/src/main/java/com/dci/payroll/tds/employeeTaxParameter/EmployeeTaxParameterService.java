package com.dci.payroll.tds.employeeTaxParameter;

import java.util.List;

public interface EmployeeTaxParameterService {

	List<EmployeeTaxParameterBean> getEmployeeTaxParameterList(String companyId, String branchId, Integer departmentId, String employeeId) throws Exception;

	EmployeeTaxParameterBean getEmpTaxParambyEmpId(String employeeId) throws Exception;

	boolean insertEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception;

	boolean updateEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception;

	boolean deleteEmpTaxParam(String employeeId) throws Exception;
}