package com.dci.payroll.payroll.arrears;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;


public interface ArrearsService {
	List<ArrearsBean> getemployeeArrearList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception;

	boolean insert(ArrayList<ArrearsBean> arrearsBeans) throws Exception;

	boolean updatePayComponentList(ArrayList<ArrearsBean> arrearsBeans) throws Exception;

	public ArrearsBean uploadFile(MultipartFile file);

	public void exportExcel(ArrearsBean chargesBean, String filePath) throws CustomException, IOException, Exception;

}
