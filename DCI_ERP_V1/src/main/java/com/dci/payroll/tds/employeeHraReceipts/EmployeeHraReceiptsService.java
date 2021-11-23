package com.dci.payroll.tds.employeeHraReceipts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeHraReceiptsService {

	List<EmployeeHraReceiptsBean> getEmployeeHraReceiptsList() throws Exception;

	boolean insertEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception;

	EmployeeHraReceiptsBean getEmployeeHraReceipt(String employeeId, String monthYear) throws Exception;

	boolean updateEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception;

	boolean approveupdate(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception;

	boolean deleteEmployeeeHraReceipt(String employeeId, String monthYear) throws Exception;

	EmployeeHraReceiptsResultBean uploadDocFile(MultipartFile file, String employeeName);
}