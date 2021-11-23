package com.dci.payroll.payroll.electricalcharges;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



public interface ElectricalChargesService {
	List<ElectricalChargesBean> getemployeeEBList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception;

	boolean insertEmployeeEbList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception;

	boolean updatePayComponentList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception;

	public ElectricalChargesBean getChargeValue(Integer units) throws Exception;

	public ElectricalChargesBean uploadFile(MultipartFile file);

	public void exportExcel(ElectricalChargesBean chargesBean, String filePath) throws CustomException, IOException, Exception;

}
