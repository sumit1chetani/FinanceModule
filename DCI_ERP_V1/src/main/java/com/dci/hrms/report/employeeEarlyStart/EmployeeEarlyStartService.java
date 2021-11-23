package com.dci.hrms.report.employeeEarlyStart;

import java.util.List;

import com.dci.common.util.CustomException;


public interface EmployeeEarlyStartService {

	public EmployeeEarlyStartResultBean getHospitalList(String formCode) throws CustomException;

	public List<EmployeeEarlyStartBean> getEarlyStartList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException;

	public List<EmployeeEarlyStartBean> getEarlyLateList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException;

	public List<EmployeeEarlyStartBean> getHabitualLate(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException;

	public EmployeeEarlyStartResultBean getEmployeeList(String branchId) throws CustomException;

	public EmployeeEarlyStartResultBean getEmployeeListDiv(String divisionId) throws CustomException;

	public EmployeeEarlyStartResultBean getDivisionList(String companyId) throws CustomException;

	public List<EmployeeEarlyStartBean> getEmpDetailList(EmployeeEarlyStartBean employeeEarlyStartBean) throws CustomException;

	public EmployeeEarlyStartResultBean getLeaveList(String empId) throws CustomException;

	public List<EmployeeEarlyStartBean> getLeaveDetails(String leaveType, String empId) throws CustomException;

}
