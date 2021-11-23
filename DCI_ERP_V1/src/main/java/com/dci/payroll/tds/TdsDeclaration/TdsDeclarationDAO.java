package com.dci.payroll.tds.TdsDeclaration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface TdsDeclarationDAO {

	public List<TdsDeclarationBean> getTdsDeclarationList(String employeeId, String financialYearId, String taxSectionCode) throws CustomException;

	public List<TdsDeclarationBean> getTdsGenerationList(String companyId, String branchId, int departmentId, String employeeId, String monthYear) throws CustomException;

	public TdsDeclarationBean getTdsDeclarationBySk(int sk) throws CustomException;

	public boolean insertTdsDeclaration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws CustomException;

	public boolean insertTdsGeneration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws CustomException;

	public boolean updateTdsDeclaration(TdsDeclarationBean tdsDeclaration) throws CustomException;

	public boolean updateActualAmount(ArrayList<TdsDeclarationBean> tdsDeclaration) throws CustomException;

	public boolean deleteTdsDeclarationBySk(int sk) throws CustomException;

	TdsDeclarationResultBean uploadDocFile(MultipartFile file, String employeeName, String taxSubSectionName, String taxSectionCode);

}
