package com.dci.payroll.tds.TdsDeclaration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface TdsDeclarationService {

	List<TdsDeclarationBean> getTdsDeclarationList(String employeeId, String financialYearId, String taxSectionCode) throws Exception;

	List<TdsDeclarationBean> getTdsGenerationList(String companyId, String branchId, int departmentId, String employeeId, String monthYear) throws Exception;

	TdsDeclarationBean getTdsDeclarationBySk(int sk) throws Exception;

	boolean insertTdsDeclaration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception;

	boolean insertTdsGeneration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception;

	boolean updateTdsDeclaration(TdsDeclarationBean tdsDeclaration) throws Exception;

	boolean updateActualAmount(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception;

	boolean deleteTdsDeclarationBySk(int sk) throws Exception;

	TdsDeclarationResultBean uploadDocFile(MultipartFile file, String fileName);

}
