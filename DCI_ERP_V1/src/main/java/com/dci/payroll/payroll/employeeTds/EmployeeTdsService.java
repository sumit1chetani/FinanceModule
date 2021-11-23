package com.dci.payroll.payroll.employeeTds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeeTdsService {

	List<EmployeeTdsBean> getEmployeeTdsList(String companyId, String branchId, String dept, String monthYear) throws Exception;

	EmployeeTdsBean insertEmployeeTdsList(ArrayList<EmployeeTdsBean> empLOPBean) throws Exception;

	public EmployeeTdsBean uploadFile(MultipartFile file);

	public void exportExcel(EmployeeTdsBean employeeTdsBean, String filePath) throws CustomException, IOException, Exception;
}