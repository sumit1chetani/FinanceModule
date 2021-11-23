package com.dci.payroll.payroll.employeelop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface EmployeeLopDAO {
	public List<EmployeeLopBean> getEmployeeLopList(String companyId, String branchId, String dept, String monthYear) throws CustomException;

	public boolean insertEmployeeLopList(ArrayList<EmployeeLopBean> empLOPBean) throws CustomException;

	public EmployeeLopBean uploadFile(MultipartFile file);

}