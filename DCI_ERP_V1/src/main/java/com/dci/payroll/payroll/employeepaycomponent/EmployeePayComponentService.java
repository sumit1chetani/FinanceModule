package com.dci.payroll.payroll.employeepaycomponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeePayComponentService {
	public List<Map<String, Object>> getEmployeePayComponentList(String employeeId) throws Exception;

	public List<Map<String, Object>> getEmployeePayComponentList1() throws Exception;

	public List<Map<String, Object>> getEmployeePayComponentList2(String departmentId) throws Exception;

	public List<Map<String, Object>> getEmployeePayComponentList3(String employeeId) throws Exception;

	public List<EmployeePayComponentBean> getListByIdDate(String employeeId, String fromDate) throws Exception;

	public boolean insertEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws Exception;

	public EmployeePayComponentBean getEmployeeMaxDate(String employeeId) throws Exception;

	public boolean updateEmployeePayComponent(ArrayList<EmployeePayComponentBean> empPayComBean) throws Exception;

	boolean deleteEmployeePayComponenet(String employeeId, String fromDate) throws Exception;

	public EmployeePayComponentBean uploadFile(MultipartFile file);

	public void exportExcel(EmployeePayComponentBean employeePayComponentBean, String filePath) throws CustomException, IOException, Exception;

	public void exportSampleExcel(EmployeePayComponentBean employeePayComponentBean, String filePath) throws CustomException, IOException, Exception;

	public EmployeePayComponentResultBean getpayExport(List<Map<String, Object>> empPayComBean) throws Exception;

	public EmployeePayComponentResultBean checkArrearDate(String arrearDate, String employeeId);

}