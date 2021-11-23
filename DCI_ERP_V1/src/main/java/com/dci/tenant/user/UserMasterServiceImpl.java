package com.dci.tenant.user;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.InvoiceMoveToDraft;
import com.google.common.collect.Lists;

@Service
public class UserMasterServiceImpl implements UserMasterService {

	@Autowired
	UserMasterDAO objUserMasterDAO;
	
	 

	@Override
	public List<ModuleMasterBean> getModuleMasterList() throws Exception {
		return objUserMasterDAO.getModuleMasterList();
	}

	@Override
	public List<PropertyMasterBean> getPropertyMasterBeanList() throws Exception {
		return objUserMasterDAO.getPropertyMasterBeanList();
	}

	@Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode) throws Exception {
		return objUserMasterDAO.getFormMasterListByCompanyUser(userId, companyCode, moduleCode);
	}

	@Override
	public List<FormMasterBean> getFormMasterListByDesgn(String desgnCode, String moduleCode) throws Exception {
		return objUserMasterDAO.getFormMasterListByDesgn(moduleCode, desgnCode);
	}

	@Override
	public List<FormMasterBean> getFormMasterListAll(int companyUserId, boolean isAgent) throws Exception {

		List<Integer> lFormPropertyIdActive = null;
		if (isAgent) {
			lFormPropertyIdActive = objUserMasterDAO.getlFormPropIdByCustomer();
		}
		else
		{
			lFormPropertyIdActive = objUserMasterDAO.getlFormPropIdByCompUser(companyUserId);	
		}
		
		
		List<FormMasterBean> lFormMasterBean = objUserMasterDAO.getFormMasterListAll(isAgent);
		List<FormMasterBean> lFormMasterBeanReturn = new ArrayList<FormMasterBean>();

		for (int i = 0; i < lFormMasterBean.size(); i++) {
			FormMasterBean formMasterBean = lFormMasterBean.get(i);
			if (formMasterBean.isParentForm()) {
				formMasterBean.setEnabled(true);
			} else {
				List<FormPropertyBean> lFormPropertyBean = objUserMasterDAO
						.getFormPropertyBeanListByFormCode(formMasterBean.getFormCode());
				for (FormPropertyBean formPropertyBean : lFormPropertyBean) {
					if (lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId())) {
						formMasterBean.setEnabled(true);
					}
				}
			}
		}

		Map<String, FormMasterBean> hmFormMasterBean = new HashMap<String, FormMasterBean>();
		for (FormMasterBean objFormMasterBean : lFormMasterBean) {
			hmFormMasterBean.put(objFormMasterBean.getFormCode(), objFormMasterBean);
		}

		Map<String, List<FormMasterBean>> hmFormMasterBeanNew = new TreeMap<String, List<FormMasterBean>>(Collections.reverseOrder());

		for (FormMasterBean objFormMasterBean : lFormMasterBean) {
			List<FormMasterBean> lFormMasterBeanNew = new ArrayList<FormMasterBean>();
			for (FormMasterBean objFormMasterBeanNew : lFormMasterBean) {
				if (objFormMasterBean.getFormCode().equalsIgnoreCase(objFormMasterBeanNew.getFormCodeParent())) {
					if (objFormMasterBeanNew.isEnabled()) {
						lFormMasterBeanNew.add(objFormMasterBeanNew);
					}
				}
			}
			if (lFormMasterBeanNew.size() > 0 && objFormMasterBean.isParentForm()) {
				hmFormMasterBeanNew.put(objFormMasterBean.getFormCode(), lFormMasterBeanNew);
			} else if (lFormMasterBeanNew.size() == 0 && objFormMasterBean.isParentForm()) {
				objFormMasterBean.setEnabled(false);
			}
		}

		for (Iterator<Map.Entry<String, List<FormMasterBean>>> itHmFormMasterBeanNew = hmFormMasterBeanNew.entrySet()
				.iterator(); itHmFormMasterBeanNew.hasNext();) {
			Map.Entry<String, List<FormMasterBean>> mFormMasterEntry = itHmFormMasterBeanNew.next();
			FormMasterBean objFormMasterBean = hmFormMasterBean.get(mFormMasterEntry.getKey());
			objFormMasterBean.setlFormMasterBean(mFormMasterEntry.getValue());
			if (hmFormMasterBeanNew.containsKey(objFormMasterBean.getFormCodeParent())) {
				List<FormMasterBean> lFormMasterBeanNew = hmFormMasterBeanNew
						.get(objFormMasterBean.getFormCodeParent());
				for (Iterator<FormMasterBean> itlFormMasterBeanNew = lFormMasterBeanNew.iterator(); itlFormMasterBeanNew
						.hasNext();) {
					if (itlFormMasterBeanNew.next().getFormCode().equalsIgnoreCase(objFormMasterBean.getFormCode())) {
						itlFormMasterBeanNew.remove();
					}
				}
				lFormMasterBeanNew.add(objFormMasterBean);
				Collections.sort(lFormMasterBeanNew, new FormMasterBeanComparator());
				itHmFormMasterBeanNew.remove();
			}
		}

		if (hmFormMasterBeanNew.size() > 0) {
			lFormMasterBeanReturn = hmFormMasterBeanNew.get("F0001");
			for (FormMasterBean objFormMasterBeanReturn : lFormMasterBeanReturn) {
				objFormMasterBeanReturn.setEnabled(getEnabled(objFormMasterBeanReturn));
			}

			for (FormMasterBean objFormMasterBeanReturn : lFormMasterBeanReturn) {

				objFormMasterBeanReturn.setChildCount(getCount(objFormMasterBeanReturn, 0));

			}

			for (FormMasterBean objFormMasterBeanReturn : lFormMasterBeanReturn) {

				List<FormMasterBean> list = integrateAllList(objFormMasterBeanReturn, new ArrayList<FormMasterBean>());

				objFormMasterBeanReturn.setlFormMasterBean(list);

			}

		}
		
		return lFormMasterBeanReturn;
	}

	public boolean getEnabled(FormMasterBean objFormMasterBean) throws Exception {
		boolean isSuccess = false;
		for (FormMasterBean objFormMasterBeanReturn : objFormMasterBean.getlFormMasterBean()) {
			if (!objFormMasterBeanReturn.isParentForm() && objFormMasterBeanReturn.isEnabled()) {
				isSuccess = true;
			} else if (objFormMasterBeanReturn.isParentForm()) {
				objFormMasterBeanReturn.setEnabled(getEnabled(objFormMasterBeanReturn));
				if (!isSuccess) {
					isSuccess = objFormMasterBeanReturn.isEnabled();
				}
			}
		}
		return isSuccess;
	}

	public List<FormMasterBean> integrateAllList(FormMasterBean objFormMasterBean, List<FormMasterBean> integratedList)
			throws Exception {
		for (FormMasterBean objFormMasterBeanReturn : objFormMasterBean.getlFormMasterBean()) {
			objFormMasterBeanReturn.setMenuLevel(objFormMasterBean.getMenuLevel() + 1);
			if (objFormMasterBeanReturn.getlFormMasterBean() != null
					&& objFormMasterBeanReturn.getlFormMasterBean().size() > 0) {
				integratedList.add(objFormMasterBeanReturn);
				integratedList.addAll(integrateAllList(objFormMasterBeanReturn, new ArrayList<FormMasterBean>()));
			} else {
				integratedList.add(objFormMasterBeanReturn);
			}
		}
		return integratedList;
	}

	/*
	 * @Override public List<FormMasterBean> getFormMasterListAll(int
	 * companyUserId, boolean isAgent) throws Exception {
	 * 
	 * List<FormMasterBean> lFormMasterBeanReturn = new
	 * ArrayList<FormMasterBean>();
	 * 
	 * List<String> lFormCode =
	 * objUserMasterDAO.getlEnabledFormCode(companyUserId); List<FormMasterBean>
	 * lFormMasterBeanAll = objUserMasterDAO.getFormMasterListAll(isAgent);
	 * 
	 * for (int i = 0; i < lFormMasterBeanAll.size(); i++) { FormMasterBean
	 * formMasterBean = lFormMasterBeanAll.get(i); if
	 * (lFormCode.contains(formMasterBean.getFormCode()) &&
	 * !formMasterBean.isParentForm()) { formMasterBean.setEnabled(true); } }
	 * 
	 * Map<String, List<FormMasterBean>> hmFormMasterBeanParent = new
	 * TreeMap<String, List<FormMasterBean>>();
	 * 
	 * for (FormMasterBean objFormMasterBean : lFormMasterBeanAll) { if
	 * (objFormMasterBean.isParentForm()) { List<FormMasterBean>
	 * lFormMasterBean1 = new ArrayList<FormMasterBean>(); for (FormMasterBean
	 * objFormMasterBean1 : lFormMasterBeanAll) { if
	 * (objFormMasterBean.getFormCode
	 * ().equalsIgnoreCase(objFormMasterBean1.getFormCodeParent())) {
	 * lFormMasterBean1.add(objFormMasterBean1); } }
	 * hmFormMasterBeanParent.put(objFormMasterBean.getFormCode(),
	 * lFormMasterBean1); } }
	 * 
	 * lFormMasterBeanReturn.addAll(hmFormMasterBeanParent.get("F0001"));
	 * Collections.sort(lFormMasterBeanReturn, new FormMasterBeanComparator());
	 * 
	 * for (FormMasterBean formMasterBean : lFormMasterBeanReturn) {
	 * filterForms(formMasterBean, hmFormMasterBeanParent); }
	 * 
	 * return lFormMasterBeanReturn; }
	 * 
	 * public boolean filterForms(FormMasterBean objFormMasterBean, Map<String,
	 * List<FormMasterBean>> hmFormMasterBeanParent) throws Exception {
	 * 
	 * boolean isSuccess = false; List<FormMasterBean> lFormMasterBean =
	 * hmFormMasterBeanParent.get(objFormMasterBean.getFormCode());
	 * 
	 * if (lFormMasterBean.size() > 0) { for (FormMasterBean formMasterBean :
	 * hmFormMasterBeanParent.get(objFormMasterBean.getFormCode())) { if
	 * (!formMasterBean.isParentForm() && formMasterBean.isEnabled()) {
	 * isSuccess = true; } else if (formMasterBean.isParentForm()) { if
	 * (!isSuccess) { isSuccess = filterForms(formMasterBean,
	 * hmFormMasterBeanParent); } } } isSuccess = true; } if (isSuccess) {
	 * Collections.sort(lFormMasterBean, new FormMasterBeanComparator());
	 * objFormMasterBean.setlFormMasterBean(lFormMasterBean); }
	 * objFormMasterBean.setEnabled(isSuccess); return isSuccess; }
	 */

	@Override
	public List<FormMasterBean> saveFormMasterListByCompanyUser(List<FormMasterBean> lFormMasterBean, String userId,
			String companyCode, String moduleCode,String mode) throws Exception {

		Integer companyUserId = objUserMasterDAO.insertCompanyUserId(companyCode, userId,mode);
		List<Integer> lFormPropertyId = objUserMasterDAO.getlFormPropIdByCompUser(companyUserId);

		List<Integer> lFormPropertyIdInsert = new ArrayList<Integer>();
		List<Integer> lFormPropertyIdDelete = new ArrayList<Integer>();

		for (FormMasterBean formMasterBean : lFormMasterBean) {
			for (FormPropertyBean formPropertyBean : formMasterBean.getlFormPropertyBean()) {
				if (lFormPropertyId.contains(formPropertyBean.getFormPropertyId())) {
					if (!formPropertyBean.isEnabled()) {
						lFormPropertyIdDelete.add(formPropertyBean.getFormPropertyId());
					}
				} else if (formPropertyBean.isEnabled() && formPropertyBean.getFormPropertyId() > 0) {
					lFormPropertyIdInsert.add(formPropertyBean.getFormPropertyId());
				}
			}
    		}

		for (List<Integer> partition : Lists.partition(lFormPropertyIdDelete, 999)) {
			objUserMasterDAO.deleteFormPropertyBeanListByCompanyUser(partition, companyUserId);
		}

		objUserMasterDAO.insertFormPropertyBeanListByCompanyUser(lFormPropertyIdInsert, companyUserId,userId,companyCode,mode);
		//objUserMasterDAO.insertFormPropertyBeanListByCompanyUsermode(companyCode, userId,companyUserId,mode);


		return getFormMasterListByCompanyUser(userId, companyCode, moduleCode);
	}

	@Override
	// @Transactional
	public List<FormMasterBean> saveFormMasterListByDesgn(List<FormMasterBean> lFormMasterBean, String desgnCode,
			String moduleCode) throws Exception {

		List<Integer> lFormPropertyId = objUserMasterDAO.getlFormPropIdByDesgn(desgnCode);
		List<Integer> lFormPropertyIdInsert = new ArrayList<Integer>();
		List<Integer> lFormPropertyIdDelete = new ArrayList<Integer>();

		for (FormMasterBean formMasterBean : lFormMasterBean) {
			for (FormPropertyBean formPropertyBean : formMasterBean.getlFormPropertyBean()) {
				if (lFormPropertyId.contains(formPropertyBean.getFormPropertyId())) {
					if (!formPropertyBean.isEnabled()) {
						lFormPropertyIdDelete.add(formPropertyBean.getFormPropertyId());
					}
				} else if (formPropertyBean.isEnabled() && formPropertyBean.getFormPropertyId() > 0) {
					lFormPropertyIdInsert.add(formPropertyBean.getFormPropertyId());
				}
			}
		}

		for (List<Integer> partition : Lists.partition(lFormPropertyIdDelete, 999)) {
			objUserMasterDAO.deleteFormPropertyBeanListDesgn(partition, desgnCode);
		}

		objUserMasterDAO.insertFormPropertyBeanListDesgn(lFormPropertyIdInsert, desgnCode);

		return getFormMasterListByDesgn(desgnCode, moduleCode);
	}

	@Override
	public List<UserMasterBean> getUserList() throws Exception {
		return objUserMasterDAO.getUserList();
	}

	@Override
	public List<UserMasterBean> getUserList(String companyCode) throws Exception {
		return objUserMasterDAO.getUserList(companyCode);
	}

	@Override
	public List<CompanyDetailsBean> getCompanyList() throws Exception {
		return objUserMasterDAO.getCompanyList();
	}

	@Override
	public List<DesignationMasterBean> getDesignationList() throws Exception {
		return objUserMasterDAO.getDesignationList();
	}

	@Override
	// @Transactional
	public UserMasterBean insertCompanyToCompany(String fromCompId, String toCompId, String userId) throws Exception {
		int fromCompUserId = objUserMasterDAO.getCompanyUserId(fromCompId, userId);
		int toCompUserId = objUserMasterDAO.insertCompanyUserId(toCompId, userId,"");
		objUserMasterDAO.insertCompanyToCompany(fromCompUserId, toCompUserId);
		return objUserMasterDAO.getUser(userId);
	}

	@Override
	// @Transactional
	public boolean insertUserToUser(String fromUserId, String toUserId, String compMapped) throws CustomException {
		objUserMasterDAO.deleteFormPropertyBeanListByUser(toUserId);
		String[] compCodeList = compMapped.split(",");
		for (String compCode : compCodeList) {
			int fromCompUserId = objUserMasterDAO.getCompanyUserId(compCode, fromUserId);
			int toCompUserId = objUserMasterDAO.insertCompanyUserId(compCode, toUserId,"");
			objUserMasterDAO.insertCompanyToCompany(fromCompUserId, toCompUserId);
		}
		return true;
	}

	@Override
	public List<UserMasterBean> getCompanyList(String formCode) {
		return objUserMasterDAO.getCompanyList(formCode);
	}

	@Override
	public List<UserMasterBean> getCompanyList1(String formCode) {
		return objUserMasterDAO.getCompanyList1(formCode);
	}
	


	@Override
	public void excelFormexport(String formCode, String filePath) {

		String code = formCode.substring(0, formCode.indexOf("-")).trim();
		String name = formCode.substring(formCode.indexOf("-") + 1, formCode.length()).trim();

		// TODO Auto-generated method stub
		try {
			// Create HSSFWork Book
			XSSFWorkbook workbook = new XSSFWorkbook();

			/**
			 * Style For Focus on Header
			 */

			XSSFCellStyle mainHeaderStyle = workbook.createCellStyle();
			mainHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 15);

			mainHeaderStyle.setFont(font);

			/**
			 * Style For Focus on SubHeader
			 */

			XSSFCellStyle subHeaderStyle = workbook.createCellStyle();
			subHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);

			font1.setFontHeightInPoints((short) 10);
			subHeaderStyle.setFont(font1);

			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("UserRights");
			setExcelFormMainHeader(excelsheet, mainHeaderStyle);
			setExcelFormSubHeader(excelsheet, subHeaderStyle, name);
			setExcelFormRows(excelsheet, workbook, code, name, subHeaderStyle);

			String fileName = "UserRights";

			writeFormExcel(workbook, filePath, fileName);
			// setLabelDetails(excelsheet, workbook, subHeaderStyle,
			// objWholeData);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excellexport(UserMasterResultBean objWholeData, String filepath, String fileNme) {
		try {
			// Create HSSFWork Book
			XSSFWorkbook workbook = new XSSFWorkbook();

			/**
			 * Style For Focus on Header
			 */

			XSSFCellStyle mainHeaderStyle = workbook.createCellStyle();
			mainHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

			Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 15);

			mainHeaderStyle.setFont(font);

			/**
			 * Style For Focus on SubHeader
			 */

			XSSFCellStyle subHeaderStyle = workbook.createCellStyle();
			subHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.BLACK.index);
			font1.setFontHeightInPoints((short) 10);
			subHeaderStyle.setFont(font1);

			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("UserRights");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			// setLabelDetails(excelsheet, workbook, subHeaderStyle,
			// objWholeData);
			setExcelSubHeader(excelsheet, subHeaderStyle);
			setExcelRows(excelsheet, workbook, objWholeData, subHeaderStyle);

			String fileName = "UserRights";
			if (fileNme != null) {
				fileName = fileNme;
			} else {
				fileName = "UserRights";
			}
			writeExcel(workbook, filepath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle) {
		try {

			Row row = excelsheet.createRow((short) 4);
			row.setHeight((short) 700);
			subHeaderStyle.setWrapText(true);
			int countofheaders = 2;
			Cell cell = row.createCell(0);
			excelsheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
			cell.setCellValue("FORM NAME");
			cell.setCellStyle(subHeaderStyle);

			cell = row.createCell(1);
			cell.setCellStyle(subHeaderStyle);

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("VIEW(V)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADD(A)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("DELETE(D)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("UNLOCK(U)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("APPROVE(AU)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("MODIFY(M)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("LOC FLAG(L)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("SEARCH(S)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADVICE(C)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("CORRECTION APPROVE(CA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADMIN ADD UPDATE(AUA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("DF APP(DA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADD UPDATE(AU)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADMIN UNLOCK(AUL)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("INVOICE ALLO(IA))");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("UPLOAD(UP)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("EXPORT");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("PRINT");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("SEND MAIL");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelFormSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle, String formName) {
		try {

			Row row = excelsheet.createRow((short) 4);
			row.setHeight((short) 1200);

			subHeaderStyle.setWrapText(true);

			subHeaderStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
			subHeaderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			int countofheaders = 2;
			Cell cell = row.createCell(0);
			excelsheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
			cell.setCellValue("FORM NAME = " + formName);
			cell.setCellStyle(subHeaderStyle);

			cell = row.createCell(1);
			cell.setCellStyle(subHeaderStyle);

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("VIEW(V)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADD(A)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("DELETE(D)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("UNLOCK(U)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("APPROVE(AU)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("MODIFY(M)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("LOC FLAG(L)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("SEARCH(S)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADVICE(C)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("CORRECTION APPROVE(CA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADMIN ADD UPDATE(AUA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("DF APP(DA)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADD UPDATE(AU)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("ADMIN UNLOCK(AUL)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("INVOICE ALLO(IA))");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("UPLOAD(UP)");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("EXPORT");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("PRINT");

			cell = row.createCell(countofheaders++);
			cell.setCellStyle(subHeaderStyle);
			cell.setCellValue("SEND MAIL");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 16));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("User Rights ");

	}

	private void setExcelFormMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 20));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("User Rights ");

	}

	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, UserMasterResultBean objWholeData,
			XSSFCellStyle subHeaderStyle) {
		List<FormMasterBean> lcontainerBean = objWholeData.getlFormMasterBean();
		try {
			/**
			 * Content
			 */
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font1.setFontHeightInPoints((short) 10);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle merge_style = workbook.createCellStyle();
			Font fontmerge = workbook.createFont();
			fontmerge.setFontHeight((short) 200);
			fontmerge.setFontName("Arial");
			fontmerge.setColor(HSSFColor.BLACK.index);
			fontmerge.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			fontmerge.setFontHeightInPoints((short) 10);
			my_style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
			merge_style.setFont(fontmerge);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			/**
			 * Number Aligned
			 */
			XSSFCellStyle my_style3 = workbook.createCellStyle();
			Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);

			my_style3.setFont(font2);
			my_style3.setWrapText(true);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

			/**
			 * Sub Total and Grand Total
			 */

			XSSFCellStyle totalStyle = workbook.createCellStyle();
			Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);

			totalStyle.setFont(font3);
			totalStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle totalStyle1 = workbook.createCellStyle();
			Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);

			totalStyle1.setFont(font4);
			totalStyle1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			// print first column
			int rCount = 5;
			System.out.println(objWholeData.getlFormMasterBean().size());
			for (int i = 0; i < objWholeData.getlFormMasterBean().size(); i++) {
				int cellCount = 2;
				Row row = excelsheet.createRow((short) rCount);
				Cell cell = row.createCell(0);
				excelsheet.addMergedRegion(new CellRangeAddress(rCount, rCount, 0, 1));
				cell.setCellValue(lcontainerBean.get(i).getFormName());
				cell.setCellStyle(my_style2);
				cell = row.createCell(1);
				cell.setCellStyle(my_style2);

				FormMasterBean bean = objWholeData.getlFormMasterBean().get(i);

				if (bean.getlFormPropertyBean().size() == 0) {

					for (int j = 1; j < 21; j++) {
						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue("false");
					}

				} else {
					System.out.println(bean.getlFormPropertyBean().size());
					for (int j = 0; j < bean.getlFormPropertyBean().size(); j++) {
						FormPropertyBean probean = bean.getlFormPropertyBean().get(j);
						cell = row.createCell(cellCount++);
						cell.setCellStyle(my_style2);
						if (probean.isEnabled())
							cell.setCellValue("true");
						else
							cell.setCellValue("false");

					}
				}

				rCount = rCount + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelFormRows(XSSFSheet excelsheet, XSSFWorkbook workbook, String formCode, String formName,
			XSSFCellStyle subHeaderStyle) {
		UserFormRightsPropertyBean objWholeData = objUserMasterDAO.getUserFormRights(formCode);
		Map<String, List<String>> map = objWholeData.getUserRights();
		Iterator<String> keys = map.keySet().iterator();
		try {
			/**
			 * Content
			 */
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font1.setFontHeightInPoints((short) 10);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle merge_style = workbook.createCellStyle();
			Font fontmerge = workbook.createFont();
			fontmerge.setFontHeight((short) 200);
			fontmerge.setFontName("Arial");
			fontmerge.setColor(HSSFColor.BLACK.index);
			fontmerge.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			fontmerge.setFontHeightInPoints((short) 10);
			my_style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
			merge_style.setFont(fontmerge);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			/**
			 * Number Aligned
			 */
			XSSFCellStyle my_style3 = workbook.createCellStyle();
			Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);

			my_style3.setFont(font2);
			my_style3.setWrapText(true);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

			/**
			 * Sub Total and Grand Total
			 */

			XSSFCellStyle totalStyle = workbook.createCellStyle();
			Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);

			totalStyle.setFont(font3);
			totalStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle totalStyle1 = workbook.createCellStyle();
			Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);

			totalStyle1.setFont(font4);
			totalStyle1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			int rCount = 5;
			UserFormRightsPropertyBean bean = null;
			List<String> list = new ArrayList<String>();
			list.add("V");
			list.add("A");
			list.add("D");
			list.add("U");
			list.add("AU");
			list.add("M");
			list.add("L");
			list.add("S");
			list.add("C");
			list.add("CA");
			list.add("AUA");
			list.add("DAL");
			list.add("AU");
			list.add("AUL");
			list.add("IA");
			list.add("UP");
			list.add("EX");
			list.add("P");
			list.add("SM");

			List<String> users = new ArrayList<String>();
			Cell cell = null;
			Row row = null;

			int cellCount = 2;
			int i = 0;
			int m = 0;
			String key = null;
			while (keys.hasNext()) {

				key = keys.next();

				cellCount = 0;
				row = excelsheet.createRow((short) rCount);

				rCount += 1;
				List<String> rights = map.get(key);

				cell = row.createCell(cellCount);
				cellCount +=1;
				excelsheet.addMergedRegion(new CellRangeAddress(rCount, rCount, 0, 1));
				if(key.length() < 10) {
					key = key +"        ";
				}				
				cell.setCellValue(key);

				cell.setCellStyle(my_style2);
				cell = row.createCell(cellCount);
				cell.setCellStyle(my_style2);
			
				int r = 0;
				String[] fRights = new String[list.size()];
				for (int k = 0; k < list.size(); k++) {
					String val = list.get(k);

					if (rights.contains(val)) {

						fRights[k] = "true";

					} else {
						fRights[k] = "false";
					}
				}
				for (int l = 0; l < list.size(); l++) {
					cellCount+=1;
					cell = row.createCell(cellCount);
					cell.setCellStyle(my_style2);

					cell.setCellValue(fRights[l]);

				}

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		// print first column
	}

	private void writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("UserRights")) {
			fileName = filePath + "/" + filePathName + ".xlsx";
		} else {
			fileName = filePath + "/UserRights.xlsx";
		}

		System.out.println("file name");
		System.out.println(fileName);
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
			System.out.println(fileName);
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void writeFormExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("UserRights")) {
			fileName = filePath + "/" + filePathName + ".xlsx";
		} else {
			fileName = filePath + "/UserRights.xlsx";
		}

		System.out.println("file name");
		System.out.println(fileName);
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
			System.out.println(fileName);
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void insertUserLogIp(UserDetail user, String actionType) {

		objUserMasterDAO.insertUserLogIp(user, actionType);
	}

	@Override
	public void generateEmployeeCompany(UserMasterBean objWholeData, String exportFilesPath) {

		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFCellStyle style5 = wb.createCellStyle();
			XSSFFont headerFont = wb.createFont();
			headerFont.setBold(true);
			style5.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
			style5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style5.setFont(headerFont);

			XSSFCellStyle style2 = wb.createCellStyle();

			style2.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
			style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style2.setFont(headerFont);

			CellStyle cellStyle1 = wb.createCellStyle();
			cellStyle1.setBorderBottom((short) 1);
			cellStyle1.setBorderTop((short) 1);
			cellStyle1.setBorderRight((short) 1);
			cellStyle1.setBorderLeft((short) 1);
			int j = 0;
			Sheet sheet = null;
			String empname = "";
			int rowIndx = 2;
			List<Map<String, Object>> rows = objUserMasterDAO.getEmployeeIncompany(objWholeData);
			for (Map row : rows) {

				System.out.println(String.valueOf(row.get("EMP_ID")) + "-" + String.valueOf(row.get("emp_name")));
				if (!empname.equals(String.valueOf(row.get("EMP_ID")))) {
					j = 0;
				}
				if (j == 0) {
					empname = String.valueOf(row.get("EMP_ID"));
					sheet = wb
							.createSheet(String.valueOf(row.get("EMP_ID")) + "-" + String.valueOf(row.get("emp_name")));
					rowIndx = 2;
				}

				Row erow = sheet.createRow(rowIndx);

				Cell cell = erow.createCell((short) 0);
				cell.setCellValue("EMP ID");

				cell = erow.createCell((short) 2);
				cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row.get("emp_id"))));

				cell = erow.createCell((short) 4);
				cell.setCellValue("EMP Name");

				cell = erow.createCell((short) 6);
				cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row.get("emp_name"))));

				cell = erow.createCell((short) 8);
				cell.setCellValue("Country");

				cell = erow.createCell((short) 10);
				cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row.get("companyrights"))));

				rowIndx = rowIndx + 4;

				erow = sheet.createRow(rowIndx);
				cell = erow.createCell((short) 0);
				cell.setCellValue("Form Names");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 1);
				cell.setCellValue("ADD");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 2);
				cell.setCellValue("View");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 3);
				cell.setCellValue("Modify");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 4);
				cell.setCellValue("Delete");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 5);
				cell.setCellValue("Search");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 6);
				cell.setCellValue("Approve");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 7);
				cell.setCellValue("Advice");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 8);
				cell.setCellValue("Correction Approve");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 9);
				cell.setCellValue("Admin Add");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 10);
				cell.setCellValue("Admin unlock");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 11);
				cell.setCellValue("Upload");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 12);
				cell.setCellValue("Export");
				cell.setCellStyle(style5);
				cell = erow.createCell((short) 13);
				cell.setCellValue("Send Mail");
				cell.setCellStyle(style5);
				rowIndx = rowIndx + 2;

				List<Map<String, Object>> rows1 = objUserMasterDAO.getEmployeeModule(String.valueOf(row.get("emp_id")),
						String.valueOf(row.get("company_code")));
				for (Map row1 : rows1) {
					erow = sheet.createRow(rowIndx);
					cell = erow.createCell((short) 0);
					cell.setCellValue(String.valueOf(row1.get("module_name")));
					cell.setCellStyle(style2);
					sheet.addMergedRegion(new CellRangeAddress(rowIndx, (short) rowIndx, 0, (short) 9));

					rowIndx = rowIndx + 2;
					List<Map<String, Object>> rows2 = objUserMasterDAO.getEmployeeRights(
							String.valueOf(row.get("emp_id")), String.valueOf(row1.get("module_code")),
							String.valueOf(row.get("company_code")));
					for (Map row2 : rows2) {

						erow = sheet.createRow(rowIndx);
						cell = erow.createCell((short) 0);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("form_name"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 1);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("add"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 2);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("view"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 3);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("modify"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 4);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("delete"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 5);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("search"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 6);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("approve"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 7);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("advice"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 8);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("correction_approve"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 9);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("admin_add_update"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 10);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("admin_unlock"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 11);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("upload"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 12);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("export"))));
						cell.setCellStyle(cellStyle1);
						cell = erow.createCell((short) 13);
						cell.setCellValue(CommonUtil.checkEmptyString(String.valueOf(row2.get("send_mail"))));
						cell.setCellStyle(cellStyle1);
						rowIndx++;
					}
					rowIndx = rowIndx + 2;
				}
				rowIndx = rowIndx + 2;

				for (int i = 0; i < 10; i++) {
					sheet.autoSizeColumn(i);
				}
				j++;
			}
			writeExcel(wb, exportFilesPath, objWholeData.getFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDetail loadUserByUsername(String username) throws CustomException {
		// TODO Auto-generated method stub
		return objUserMasterDAO.loadUserByUsername(username);
	}

	@Override
	public int getCompanyUserId(String companyCode, String userId) throws CustomException {
		// TODO Auto-generated method stub
		return objUserMasterDAO.getCompanyUserId(companyCode, userId);
	}

	@Override
	public List<GrantedAuthority> loadPermissionsByUsername(int companyUserId, boolean isAgent) {
		// TODO Auto-generated method stub
		return objUserMasterDAO.loadPermissionsByUsername(companyUserId, isAgent);
	}

	@Override
	public Map<String, String> getFormCodeUrlMap() throws CustomException {
		// TODO Auto-generated method stub
		return objUserMasterDAO.getFormCodeUrlMap();
	}

	@Override
	public Map<String, String> getAddUrlFormCodeMap() throws CustomException {
		// TODO Auto-generated method stub
		return objUserMasterDAO.getAddUrlFormCodeMap();
	}

	@Override
	public List<GrantedAuthority> loadPermissionsByUsernameCustomer(boolean isAgent) {
		// TODO Auto-generated method stub
		return objUserMasterDAO.loadPermissionsByUsernameCustomer(isAgent);
	}

	public int getCount(FormMasterBean objFormMasterBean, int count) throws Exception {
		for (FormMasterBean objFormMasterBeanReturn : objFormMasterBean.getlFormMasterBean()) {
			if (objFormMasterBeanReturn.isEnabled()) {
				count++;
				if (objFormMasterBeanReturn.isParentForm()) {
					for (FormMasterBean objFormMasterBeanReturn1 : objFormMasterBeanReturn.getlFormMasterBean()) {
						count = getCount(objFormMasterBeanReturn1, count);
					}
				}
			}
		}
		return count;
	}

	@Override
	public int getcount(String userName) throws CustomException {
		// TODO Auto-generated method stub
		return objUserMasterDAO.getcount(userName);

	}

	@Override
	public boolean forgetPassword(String emailId) throws Exception {
		return objUserMasterDAO.forgetPassword(emailId);
	}

	public static void setHTMLContent(Message msg, String bodyhtml) throws MessagingException {

		msg.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));
	}

	private static void setTextContent(Message msg, String bodytext) throws MessagingException {
		// Set message content
		msg.setText(bodytext);

		// Alternate form
		msg.setContent(bodytext, "text/plain");

	}

	private static void setFileAsAttachment(Message msg, String filename, String bodytext) throws MessagingException {

		// Create and fill first part
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setText(bodytext + " \n Please find the attached file");

		// Create second part
		MimeBodyPart p2 = new MimeBodyPart();

		// Put a file in the second part
		FileDataSource fds = new FileDataSource(filename);
		p2.setDataHandler(new DataHandler(fds));
		p2.setFileName(fds.getName());

		// Create the Multipart. Add BodyParts to it.
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(p1);
		mp.addBodyPart(p2);

		// Set Multipart as the message's content
		msg.setContent(mp);
	}

	private static void setFileAsAttachmentWithHTML(Message msg, String filename, String bodyhtml)
			throws MessagingException {
		// Create second part
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setDataHandler(new DataHandler(new HTMLDataSource(bodyhtml)));

		MimeBodyPart p2 = new MimeBodyPart();

		// Put a file in the second part
		FileDataSource fds = new FileDataSource(filename);
		p2.setDataHandler(new DataHandler(fds));
		p2.setFileName(fds.getName());

		// Create the Multipart. Add BodyParts to it.
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(p1);
		mp.addBodyPart(p2);

		// Set Multipart as the message's content
		msg.setContent(mp);

	}

	static class HTMLDataSource implements DataSource {
		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		// Return html string in an InputStream.
		// A new stream must be returned each time.
		@Override
		public InputStream getInputStream() throws IOException {
			if (html == null)
				throw new IOException("Null HTML");
			return new ByteArrayInputStream(html.getBytes());
		}

		@Override
		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		@Override
		public String getContentType() {
			return "text/html";
		}

		@Override
		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}

	@Override
	public List<UserDetail> getBranchList() throws Exception {
		// TODO Auto-generated method stub
		return objUserMasterDAO.getBranchList();
	}

	@Override
	public boolean invoicemovetodraft(InvoiceMoveToDraft invoiceDraft) {
		// TODO Auto-generated method stub
		return objUserMasterDAO.invoicemovetodraft(invoiceDraft);
	}

	@Override
	public List<SelectivityBean> getInvoiceList(String invoiceType, String mode) {
		return objUserMasterDAO.getInvoiceList(invoiceType, mode);
	}

	@Override
	public void sendMail2(org.hibernate.validator.constraints.Email email, String sFilePath) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<FormPropertyBean> getFormNames() {
		return objUserMasterDAO.getFormNames();
	}

}
