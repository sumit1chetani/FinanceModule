package com.dci.payroll.tds.professionaltaxslab;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface ProfessionalTaxSlabService {

	public List<ProfessionalTaxSlabBean> getProfessionalTaxSlabList() throws Exception;

	public PtListDTO getProfessionalGenerationList(String companyId, String branchId, int departmentId, String financialYear) throws Exception;

	public PtListDTO gettypeList(String companyId, String branchId, String dept, String typeId, String financialYear) throws Exception;

	boolean insertPtSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws Exception;

	ProfessionalTaxSlabBean getPtSlabById(String branchId, String financialYear, BigDecimal rangeFrom) throws Exception;

	boolean updatePTSlab(ProfessionalTaxSlabBean professionalTaxSlabBean) throws Exception;

	boolean insertEmployeePTList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception;

	boolean insertEmployeedeDuctionList(ArrayList<ProfessionalTaxSlabBean> empLOPBean) throws Exception;

	boolean deletePTSlab(String branchId, String financialYear, BigDecimal rangeFrom) throws Exception;

	public List<ProfessionalTaxSlabBean> getFinancialYear(String companyId) throws CustomException, Exception;

	public List<ProfessionalTaxSlabBean> getLoginfinancialYear(String companyId) throws CustomException, Exception;

	public List<ProfessionalTaxSlabBean> getFinancialYearList() throws CustomException, Exception;

	public ProfessionalTaxSlabBean uploadFile(MultipartFile file);

	public void exportExcel(ProfessionalTaxSlabBean professionalTaxSlabBean, String filePath) throws CustomException, IOException, Exception;

	public void exportExcel1(ProfessionalTaxSlabBean professionalTaxSlabBean, String filePath) throws CustomException, IOException, Exception;

}