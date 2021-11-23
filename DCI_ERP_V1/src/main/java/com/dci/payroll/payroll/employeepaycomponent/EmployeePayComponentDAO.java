package com.dci.payroll.payroll.employeepaycomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeePayComponentDAO {
	public List<Map<String, Object>> getEmployeePayComponentList(String employeeId) throws CustomException;

	public List<Map<String, Object>> getEmployeePayComponentList1() throws CustomException;

	public List<Map<String, Object>> getEmployeePayComponentList2(String departmentId) throws CustomException;

	public List<Map<String, Object>> getEmployeePayComponentList3(String employeeId) throws CustomException;

	public List<EmployeePayComponentBean> getListByIdDate(String employeeId, String fromDate) throws CustomException;

	public boolean insertEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws CustomException;

	public EmployeePayComponentBean getEmployeeMaxDate(String employeeId) throws CustomException;

	public boolean updateEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws CustomException;

	public boolean deleteEmployeePayComponenet(String employeeId, String fromDate) throws CustomException;

	public EmployeePayComponentBean uploadFile(MultipartFile file);

	public List<EmployeePayComponentBean> getSampleExcelList(EmployeePayComponentBean employeePayComponentBean) throws CustomException;

	public List<EmployeePayComponentBean> getEmployeeList(EmployeePayComponentBean employeePayComponentBean) throws CustomException;

	EmployeePayComponentResultBean getpayExport(List<Map<String, Object>> empPayComBean) throws Exception;

	public boolean checkArrearDate(String arrearsStartDate);

	public EmployeePayComponentResultBean checkArrearDate(String arrearDate, String employeeId);

}
