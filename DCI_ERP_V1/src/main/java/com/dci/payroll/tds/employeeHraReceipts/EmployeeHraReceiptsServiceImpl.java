package com.dci.payroll.tds.employeeHraReceipts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class EmployeeHraReceiptsServiceImpl implements EmployeeHraReceiptsService {
	@Autowired
	EmployeeHraReceiptsDAO employeehrDAO;

	/*@Value("${file.asset.absolutePath}")
	private String getFilePropertyUrl;
*/
	/*@Value("${file.asset.serverPath}")
	private String getFileServerPath;*/

	@Override
	public List<EmployeeHraReceiptsBean> getEmployeeHraReceiptsList() throws Exception {
		return employeehrDAO.getEmployeeHraReceiptsList();
	}

	@Override
	public boolean insertEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception {
		// TODO Auto-generated method stub
		return employeehrDAO.insertEmployeeeHraReceipt(employeeHraReceiptsBean);
	}

	@Override
	public EmployeeHraReceiptsBean getEmployeeHraReceipt(String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return employeehrDAO.getEmployeeHraReceipt(employeeId, monthYear);
	}

	@Override
	public boolean updateEmployeeeHraReceipt(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception {
		// TODO Auto-generated method stub
		return employeehrDAO.updateEmployeeeHraReceipt(employeeHraReceiptsBean);
	}

	@Override
	public boolean approveupdate(EmployeeHraReceiptsBean employeeHraReceiptsBean) throws Exception {
		// TODO Auto-generated method stub
		return employeehrDAO.approveupdate(employeeHraReceiptsBean);
	}

	@Override
	public boolean deleteEmployeeeHraReceipt(String employeeId, String monthYear) throws Exception {
		// TODO Auto-generated method stub
		return employeehrDAO.deleteEmployeeeHraReceipt(employeeId, monthYear);
	}

	@Override
	public EmployeeHraReceiptsResultBean uploadDocFile(MultipartFile file, String fileName) {

		EmployeeHraReceiptsResultBean obj = new EmployeeHraReceiptsResultBean();

		String filePath = "";
		if (!file.isEmpty()) {
/*
			filePath = HisFileUploadUtillity.uploadFileHandlerWithOutRandom(file, getFilePropertyUrl, getFileServerPath, fileName);
			obj.setDocPath(filePath);*/

		}
		return obj;

	}
}