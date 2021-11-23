package com.dci.payroll.payroll.payrollreport;

import java.util.List;
import java.util.Map;

import com.dci.common.util.CustomException;


public interface PayrollReportDAO {
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, String dept, String monthYear) throws CustomException;

	public List<Map<String, Object>> getMonthlyPayrollList(String employeeId) throws CustomException;
}