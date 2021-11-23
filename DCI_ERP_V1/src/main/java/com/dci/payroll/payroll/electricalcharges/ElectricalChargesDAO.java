package com.dci.payroll.payroll.electricalcharges;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ElectricalChargesDAO {
	List<ElectricalChargesBean> getemployeeEBList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception;

	boolean insertEmployeeEbList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception;

	public ElectricalChargesBean getChargeValue(Integer units) throws Exception;

	boolean updatePayComponentList(ArrayList<ElectricalChargesBean> chargesBeans) throws Exception;

	public ElectricalChargesBean uploadFile(MultipartFile file);
}
