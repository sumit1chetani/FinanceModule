package com.dci.payroll.tds.employeeTaxParameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTaxParameterServiceImpl implements EmployeeTaxParameterService {
	@Autowired
	EmployeeTaxParameterDAO empTaxParamDAO;

	@Override
	public List<EmployeeTaxParameterBean> getEmployeeTaxParameterList(String companyId, String branchId, Integer departmentId, String employeeId) throws Exception {
		return empTaxParamDAO.getEmployeeTaxParameterList(companyId, branchId, departmentId, employeeId);
	}

	@Override
	public EmployeeTaxParameterBean getEmpTaxParambyEmpId(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return empTaxParamDAO.getEmpTaxParambyEmpId(employeeId);
	}

	@Override
	public boolean insertEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception {
		// TODO Auto-generated method stub
		return empTaxParamDAO.insertEmpTaxParam(empTaxParamBean);
	}

	@Override
	public boolean updateEmpTaxParam(EmployeeTaxParameterBean empTaxParamBean) throws Exception {
		// TODO Auto-generated method stub
		return empTaxParamDAO.updateEmpTaxParam(empTaxParamBean);
	}

	@Override
	public boolean deleteEmpTaxParam(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return empTaxParamDAO.deleteEmpTaxParam(employeeId);
	}
}