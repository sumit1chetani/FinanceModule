package com.dci.payroll.tds.professionaltaxslab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface ProfessionalTaxSlabDAO {

	boolean insertEmployeePTList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception;

	boolean insertEmployeeDeductionList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception;

	public List<ProfessionalTaxSlabBean> getProfessionalTaxSlabList() throws CustomException;

	public PtListDTO getProfessionalGenerationList(String companyId, String branchId, int departmentId, String financialYear) throws CustomException;

	public PtListDTO getTypeList(String companyId, String branchId, String dept, String typeId, String financialYear) throws CustomException;

	public List<Map<String, Object>> getProfessionalGenerationListXL(String companyId, String branchId, int departmentId, String financialYear) throws CustomException;

	boolean insertPtSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws CustomException;

	ProfessionalTaxSlabBean getPtSlabById(String branchId, String financialYear, BigDecimal rangeFrom) throws CustomException;

	boolean updatePTSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws CustomException;

	boolean deletePTSlab(String branchId, String financialYear, BigDecimal rangeFrom) throws CustomException;

	public List<ProfessionalTaxSlabBean> getFinancialYear(String companyId) throws CustomException;

	public List<ProfessionalTaxSlabBean> getLoginfinancialYear(String companyId) throws CustomException;

	public List<ProfessionalTaxSlabBean> getFinancialYearList() throws CustomException;

	public ProfessionalTaxSlabBean uploadFile(MultipartFile file);

}