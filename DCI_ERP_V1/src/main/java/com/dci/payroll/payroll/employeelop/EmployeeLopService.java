package com.dci.payroll.payroll.employeelop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeeLopService {
	List<EmployeeLopBean> getEmployeeLopList(String companyId, String branchId, String dept, String monthYear) throws Exception;

	boolean insertEmployeeLopList(ArrayList<EmployeeLopBean> empLOPBean) throws Exception;

	public EmployeeLopBean uploadFile(MultipartFile file);

	public void exportExcel(EmployeeLopBean employeeLopBean, String filePath) throws CustomException, IOException, Exception;
}