package com.dci.payroll.tds.TdsDeclaration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class TdsDeclarationServiceImpl implements TdsDeclarationService {
	@Autowired
	TdsDeclarationDAO tdsDeclarationDAO;
/*
	@Value("${file.asset.absolutePath}")
	private String getFilePropertyUrl;
*/
	/*@Value("${file.asset.serverPath}")
	private String getFileServerPath;*/

	@Override
	public List<TdsDeclarationBean> getTdsDeclarationList(String employeeId, String financialYearId, String taxSectionCode) throws Exception {
		return tdsDeclarationDAO.getTdsDeclarationList(employeeId, financialYearId, taxSectionCode);
	}

	@Override
	public List<TdsDeclarationBean> getTdsGenerationList(String companyId, String branchId, int departmentId, String employeeId, String monthYear) throws Exception {
		return tdsDeclarationDAO.getTdsGenerationList(companyId, branchId, departmentId, employeeId, monthYear);
	}

	@Override
	public TdsDeclarationBean getTdsDeclarationBySk(int sk) throws Exception {
		return tdsDeclarationDAO.getTdsDeclarationBySk(sk);
	}

	@Override
	public boolean insertTdsDeclaration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception {
		return tdsDeclarationDAO.insertTdsDeclaration(tdsDeclaration);
	}

	@Override
	public boolean insertTdsGeneration(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception {
		return tdsDeclarationDAO.insertTdsGeneration(tdsDeclaration);
	}

	@Override
	public boolean updateTdsDeclaration(TdsDeclarationBean tdsDeclaration) throws Exception {
		return tdsDeclarationDAO.updateTdsDeclaration(tdsDeclaration);
	}

	@Override
	public boolean updateActualAmount(ArrayList<TdsDeclarationBean> tdsDeclaration) throws Exception {
		return tdsDeclarationDAO.updateActualAmount(tdsDeclaration);
	}

	@Override
	public boolean deleteTdsDeclarationBySk(int sk) throws Exception {
		return tdsDeclarationDAO.deleteTdsDeclarationBySk(sk);
	}

	@Override
	public TdsDeclarationResultBean uploadDocFile(MultipartFile file, String fileName) {
		TdsDeclarationResultBean obj = new TdsDeclarationResultBean();

		String filePath = "";
		if (!file.isEmpty()) {

	/*		filePath = HisFileUploadUtillity.uploadFileHandlerWithOutRandom(file, getFilePropertyUrl, getFileServerPath, fileName);
			obj.setDocPath(filePath);*/

		}
		return obj;
	}
}
