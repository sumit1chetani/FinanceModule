package com.dci.payroll.payroll.payslip;

import java.util.List;
import java.util.Map;

import com.dci.common.util.CustomException;


public interface PaySlipDAO {
	public List<PaySlipBean> getPaySlipList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException;

	public List<PaySlipBean> getPaySlipListChk(String monthYear, Integer departmentId) throws CustomException;

	public List<PaySlipBean> getPaySlipListChkDept(String monthYear, String dept) throws CustomException;

	public List<PaySlipBean> getPaySlipList1(String monthYear, Integer departmentId) throws CustomException;

	public List<PaySlipBean> getPaySlipListmont(String monthYear) throws CustomException;

	public List<Map<String, Object>> getPaySlipList1(String companyId, String branchId, String departmentId, String employeeId, String monthYear) throws CustomException;

	public PaySlipResultBean getEmpDetailList(String employeeId) throws Exception;

	public PaySlipBean getemail(String employeeId) throws Exception;

	public PaySlipResultBean getemailid(List<PaySlipBean> employeeIdlist) throws Exception;

}