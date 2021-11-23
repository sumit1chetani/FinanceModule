package com.dci.payroll.payroll.employeeTds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeeTdsDAO {

	public List<EmployeeTdsBean> getEmployeeTdsList(String companyId, String branchId, String dept, String monthYear) throws CustomException;

	public EmployeeTdsBean insertEmployeeTdsList(ArrayList<EmployeeTdsBean> empLOPBean) throws CustomException;

	public EmployeeTdsBean uploadFile(MultipartFile file);

}	