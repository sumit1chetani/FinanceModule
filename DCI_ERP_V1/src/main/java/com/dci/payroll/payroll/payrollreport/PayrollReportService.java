package com.dci.payroll.payroll.payrollreport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dci.common.util.CustomException;


public interface PayrollReportService {
	List<Map<String, Object>> getPayrollList(String companyId, String branchId, String dept, String monthYear) throws Exception;

	List<Map<String, Object>> getMonthlyPayrollList(String employeeId) throws Exception;

	public void exportExcel(PayrollReportBean payrollReportBean, String filePath) throws CustomException, IOException, Exception;
}