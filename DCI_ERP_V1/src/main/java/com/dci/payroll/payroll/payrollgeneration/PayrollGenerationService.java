package com.dci.payroll.payroll.payrollgeneration;

import java.util.List;
import java.util.Map;

import com.dci.payroll.payroll.payslip.PaySlipBean;


public interface PayrollGenerationService {
	List<PayrollGenerationBean> checkSalaryCreated(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	List<PayrollGenerationBean> checkSalaryFixed(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	PayrollGenerationBean generatePayroll(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	PayrollGenerationResultBean taxDeduction(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	List<PayrollGenerationBean> getEmployeeSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	boolean deleteSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

	List<PayrollGenerationBean> getDepartmentList(String branchId) throws Exception;

	List<PayrollGenerationBean> getEmployeeList(String branchId) throws Exception;

	List<PayrollGenerationBean> getTypeList() throws Exception;

	PayrollGenerationResultBean getDepartmentList1() throws Exception;

	List<PayrollGenerationBean> getEmployeeList(String dept, String branchId) throws Exception;

	List<PayrollGenerationBean> getEmployees() throws Exception;

	List<PayrollGenerationBean> getBranchList(String companyId) throws Exception;

	List<PayrollGenerationBean> getMonthYearList() throws Exception;

	List<PayrollGenerationBean> getPaySlipYearList() throws Exception;

	List<PayrollGenerationBean> getCompanyList() throws Exception;

	List<PayrollGenerationBean> checkPayrollFlag();

	List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws Exception;

	PayrollGenerationResultBean checkFlag(Integer departmentId, String employeeId);

	PayrollGenerationResultBean getFlagList(int departmentId, String monthYear, String employeeId);

	PayrollGenerationResultBean withHoldList(String employeeId, String monthYear);

	PayrollGenerationResultBean getcheckFlag(String employeeId);

	PayrollGenerationResultBean getAlreadyGenerated(String employeeId, String startDate);

	List<PayrollGenerationBean> getEmployeeSalarygeneratedList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws Exception;

	// PayrollGenerationResultBean payrolltojv(PaySlipBean PaySlipBean);

	public boolean payrolltojv(PaySlipBean PaySlipBean) throws Exception;

	List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception;

	List<PayrollGenerationBean> pendingSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws Exception;

}