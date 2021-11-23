package com.dci.tenant.finance.openingbalanceupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dci.tenant.finance.purchaseInvoice.PurchaseInvoiceDetailBean;
import com.dci.tenant.user.UserDetail;

@Service
public class OpeningBalanceServiceImpl implements OpeningBalanceService {

	@Autowired
	private OpeningBalanceDAO branchDAO;

	/*@Autowired
	private OpeningBalanceDAOImpl objDao;
*/
	@Override
	public List<OpeningBalanceBean> getBranchList() throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getBranchList();
	}

	@Override
	public List<OpeningBalanceBean> getBranchList1(OpeningBalanceBean bean) throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getBranchList1(bean);
	}

	@Override
	public OpeningBalanceResultBean getdropList() throws Exception {
		// TODO Auto-generated method stub
		return branchDAO.getdropList();
	}

	@Override
	public OpeningBalanceResultBean save(OpeningBalanceBean mablBean) {
		// TODO Auto-generated method stub
		return branchDAO.save(mablBean);
	}

	@Override
	public OpeningBalanceResultBean generateJv(OpeningBalanceBean mablBean) {
		// TODO Auto-generated method stub
		return branchDAO.generateJv(mablBean);
	}

	@Override
	public OpeningBalanceResultBean editMabl(int transactionid) {
		// TODO Auto-generated method stub
		return branchDAO.editMabl(transactionid);
	}

	@Override
	public OpeningBalanceResultBean update(OpeningBalanceBean mablBean) {
		// TODO Auto-generated method stub
		return branchDAO.update(mablBean);
	}

	@Override
	public List<OpeningBalanceBean> getJournalVoucherList(OpeningBalanceBean journalVoucherBean) throws Exception {
		return branchDAO.getJournalVoucherList(journalVoucherBean);
	}

	@Override
	public void excellExport(List<OpeningBalanceBean> feereport, OpeningBalanceBean FeeBeanobj, String pdfFile) {
		try {
			// Blank workbook
			// HSSFWorkbook workbook = new HSSFWorkbook();

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();
			/*
			 * HSSFPalette palette = workbook.getCustomPalette();
			 * palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 0, // RGB
			 * red (byte) 32, // RGB green (byte) 96 // RGB blue );
			 */
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.BLUE.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			XSSFCellStyle my_style1 = workbook.createCellStyle();
			// my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLUE.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			// my_style2.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style2.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
			// my_style3.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style3.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			Font fonts = workbook.createFont();

			fonts.setFontName("Arial");
			fonts.setFontHeight((short) 200);
			fonts.setColor(HSSFColor.RED.index);
			fonts.setBoldweight(Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			fonts.setFontHeightInPoints((short) 12);
			my_style3.setFont(fonts);

			XSSFCellStyle my_style6 = workbook.createCellStyle();
			// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style6.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			Font font6 = workbook.createFont();

			font6.setFontName("Arial");
			font6.setFontHeight((short) 200);
			font6.setColor(HSSFColor.BLUE.index);
			font6.setBoldweight(Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			font6.setFontHeightInPoints((short) 12);
			my_style6.setFont(font6);

			XSSFCellStyle my_style7 = workbook.createCellStyle();
			// my_style6.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style7.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			Font font7 = workbook.createFont();

			font7.setFontName("Arial");
			font7.setFontHeight((short) 200);
			font7.setColor(HSSFColor.BLUE.index);
			font7.setBoldweight(Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			font7.setFontHeightInPoints((short) 10);
			my_style7.setFont(font7);

			/**
			 * Style For Focus on differentiate Income or Expenses
			 */
			XSSFCellStyle my_style4 = workbook.createCellStyle();
			// my_style4.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style4.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style4.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			Font font2 = workbook.createFont();

			font2.setFontName("Arial");
			font2.setFontHeight((short) 200);
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);
			my_style4.setFont(font2);

			/**
			 * Style For Focus on differentiate Income or Expenses
			 */
			XSSFCellStyle my_style5 = workbook.createCellStyle();
			// my_style5.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			// my_style5.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style5.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			Font font3 = workbook.createFont();

			font3.setFontName("Arial");
			font3.setFontHeight((short) 200);
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);
			my_style5.setFont(font3);

			XSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style8.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			Font font8 = workbook.createFont();
			font2.setFontName("Arial");
			font2.setFontHeight((short) 200);
			font8.setColor(HSSFColor.RED.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);
			my_style8.setFont(font8);
			// Create a blank sheet
			XSSFSheet excelSheet = workbook.createSheet("OPENING BALANCE");

			// set main header
			setExcelMainHeader(excelSheet, my_style, FeeBeanobj, my_style8);
			// set header
			setExcelHeader(excelSheet, my_style8);

			// set Data
			setExcelRows(workbook, excelSheet, feereport, my_style2, my_style3, my_style4, my_style5, my_style6, my_style7, my_style8);

			// export excell
			writeExcel(workbook, pdfFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, List<OpeningBalanceBean> feereport, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5, XSSFCellStyle my_style6, XSSFCellStyle my_style7, XSSFCellStyle my_style8) {
		int record = 4, sno = 1;
		try {

			for (OpeningBalanceBean FeeBeanobj : feereport) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				/*
				 * cell1.setCellStyle(my_style4);
				 * cell1.setCellValue(sno++);manifestBeanobj cell1 =
				 * row1.createCell((short) 1);
				 */

				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getCompanyName());

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getCustomerName());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getInvoiceNo());

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getInvoiceDate());

				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getAccountHead());

				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getAccountHeadName());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(FeeBeanobj.getBcAmount());

				/*
				 * for (int i = 0; i < 11; i++) { if (i == 4 || i == 7 || i == 9
				 * | i == 10) { excelSheet.autoSizeColumn(i); } }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*private static void writeExcel(XSSFWorkbook myWorkBook, String filePath) {
		String l_str_file_out = filePath + "/OpeningBalance.xlsx";
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(l_str_file_out);
			myWorkBook.write(fileOut);
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
*/
	
	private String writeExcel(XSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/OpeningBalance.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/OpeningBalance.xls";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return url;
	}

	public void setMergingStyle(Row row, XSSFCellStyle cellStyle, int start, int end) {
		for (int i = start; i <= end; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
		}

	}

	private void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row1 = excelSheet.createRow((short) 3);
			excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);

			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Company Name");
			excelSheet.setColumnWidth(0, (short) ((30 * 15) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Customer/Vendor");
			excelSheet.setColumnWidth(1, (short) ((30 * 10) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Invoice No");
			excelSheet.setColumnWidth(2, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Invoice Date");
			excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Account Head");
			excelSheet.setColumnWidth(4, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Account Head Name");
			excelSheet.setColumnWidth(4, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Amount");
			excelSheet.setColumnWidth(5, (short) ((30 * 9) / ((double) 1 / 20)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, OpeningBalanceBean FeeBeanobj, XSSFCellStyle my_style4) {
		/*Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				0, // last row (0-based)
				0, // first column (0-based)
				10 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		cell.setCellValue("OPENING BALANCE");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);*/
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 10));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);

		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 10));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("OPENING BALANCE");
		cell2.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 10);
		
	}

	@Override
	public OpeningBalanceResultBean uploadFile(MultipartFile file) {

		OpeningBalanceResultBean resultbean = new OpeningBalanceResultBean();

		OpeningBalanceBean hdrBean = new OpeningBalanceBean();

		UserDetail userDtl = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String fileName = file.getOriginalFilename();
		Iterator<Row> rowIterator = null;
		StringBuffer sb = new StringBuffer();

		Workbook workbook = null;

		try {
			org.apache.poi.ss.usermodel.Workbook wb_xssf; // Declare XSSF
			org.apache.poi.ss.usermodel.Workbook wb_hssf; // Declare HSSF
			// int j=0;
			Sheet sheet = null;
			if (fileName.endsWith("xls")) {

				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);
				sheet = wb_hssf.getSheetAt(0);
				rowIterator = sheet.rowIterator();
				// j=2;
			} else if (fileName.endsWith("xlsx")) {

				workbook = new XSSFWorkbook(file.getInputStream());
				XSSFSheet sheet1 = (XSSFSheet) workbook.getSheetAt(0);
				rowIterator = sheet1.rowIterator();
				// j=2;

			} else {
				sb.append("Not a valid file format");
			}

			int rowCnt = 0;
			String error = "";
			Row row1 = rowIterator.next();
			Cell qdate = row1.getCell(1);
			hdrBean.setInvoiceNo(qdate.getStringCellValue());

			Row row2 = rowIterator.next();
			Cell Purchasefor = row2.getCell(1);
			boolean purchaseforValid = false;
			if (Purchasefor != null) {
				String purchasefor = "";
				if (Purchasefor.getCellType() == 0) {
					long myNumber = (long) Purchasefor.getNumericCellValue();
					purchasefor = String.valueOf(myNumber);
				} else if (Purchasefor.getCellType() == 1) {
					purchasefor = Purchasefor.getStringCellValue().trim();

				}
				/*String purfor = branchDAO.getPurchaseTypeList(purchasefor.trim());
				if (purfor != null && !purfor.trim().equalsIgnoreCase("null") && !purfor.trim().isEmpty()) {

					hdrBean.setCustomer(purfor);
					purchaseforValid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Customer For is not valid");
					sb.append("<br>");
				}
*/			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Customer For should not be empty");
				sb.append("<br>");
			}
			Row row3 = rowIterator.next();
			Cell Purchasetype = row3.getCell(1);
			boolean purchasetypevalid = false;
			if (Purchasetype != null) {
				String purchasetype = "";
				if (Purchasetype.getCellType() == 0) {
					long myNumber = (long) Purchasetype.getNumericCellValue();
					purchasetype = String.valueOf(myNumber);
				} else if (Purchasetype.getCellType() == 1) {
					purchasetype = Purchasetype.getStringCellValue().trim();
				}
				/*String purtypefor = branchDAO.getCompanyList(purchasetype.trim());
				if (purtypefor != null && !purtypefor.trim().equalsIgnoreCase("null") && !purtypefor.trim().isEmpty()) {
					hdrBean.setCompanyId(purtypefor);
					purchasetypevalid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Company is not valid");
					sb.append("<br>");
				}*/
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Company should not be empty");
				sb.append("<br>");
			}

			Row row4 = rowIterator.next();
			Cell Entityid = row4.getCell(1);
			boolean entityidvalid = false;
			if (Entityid != null) {
				String entityid = "";
				if (Entityid.getCellType() == 0) {
					long myNumber = (long) Entityid.getNumericCellValue();
					entityid = String.valueOf(myNumber);
				} else if (Entityid.getCellType() == 1) {
					entityid = Entityid.getStringCellValue().trim();
				}
			/*	String entityidnew = branchDAO.getVendorList(entityid.trim());
				if (entityidnew != null && !entityidnew.trim().equalsIgnoreCase("null") && !entityidnew.trim().isEmpty()) {
					hdrBean.setAccountHead(entityidnew);
					entityidvalid = true;
				} else {
					sb.append(" row- " + (rowCnt) + " : " + "Account Head  is not valid");
					sb.append("<br>");
				}*/
			} else {
				sb.append(" row- " + (rowCnt) + " : " + "Account Head Fo should not be empty");
				sb.append("<br>");
			}

			Row row5 = rowIterator.next();
			Cell amount = row5.getCell(1);
			hdrBean.setBcAmount(amount.getNumericCellValue());

			Row row6 = rowIterator.next();
			Cell currency = row6.getCell(1);
			hdrBean.setCurrency(currency.getStringCellValue());
			/*
			 * Row row7 = rowIterator.next(); Cell invodate = row7.getCell(1);
			 * hdrBean.setInvoiceDate(invodate.getStringCellValue());
			 */
			resultbean.setOpeningBalance(hdrBean);

			if (error != null || !error.equalsIgnoreCase("")) {
				resultbean.setSuccess(true);
			} else {
				resultbean.setSuccess(true);
				resultbean.setMessage(error);
			}

		} catch (Exception e) {
			resultbean.setSuccess(true);
			e.printStackTrace();
		}

		return resultbean;
	}

	@Override
	public String uploadFile1(MultipartFile file) {
		String alertMsg = "";
		boolean isOverWriteable = false;
		@SuppressWarnings("unused")
		boolean isDeleted = false;
		try {

			org.apache.poi.ss.usermodel.Workbook wb_xssf;
			org.apache.poi.ss.usermodel.Workbook wb_hssf;
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/M/yyyy");
			String fileName = file.getOriginalFilename();
			Sheet sheet = null;
			StringBuffer sb = new StringBuffer();
			if (fileName.endsWith("xlsx") || fileName.endsWith("XLSX")) {
				wb_xssf = new XSSFWorkbook(file.getInputStream());
				sheet = wb_xssf.getSheetAt(0);
			}
			if (fileName.endsWith("xls") || fileName.endsWith("XLS")) {
				POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
				wb_hssf = new HSSFWorkbook(fs);

				sheet = wb_hssf.getSheetAt(0);
			}

			String company = "";
			String supplier = "";
			String costCenter = "";
			String purchaseInvoiceDate = "";
			String partyInvoiceNo = "";
			String dueDate = "";
			String description = "";
			Double amountHeader = 0.0;
			String acctHeadCode = "";
			String customer = "";

			// List<OpeningBalanceBean> headerList = new ArrayList<>();
			List<OpeningBalanceBean> detailList = new ArrayList<>();
			OpeningBalanceResultBean headerList = new OpeningBalanceResultBean();
			System.out.println(sheet.getLastRowNum());
			for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {
				OpeningBalanceBean purchaseInvoiceHeader = new OpeningBalanceBean();

				int index = 0;
				int rownnum = rowCount + 1;
				XSSFRow companyCode = (XSSFRow) sheet.getRow(rowCount);
				System.out.println("Row = " + rownnum);
				if (companyCode != null && companyCode.getCell(0) != null && companyCode.getCell(1) != null) {

					Cell supplierData = companyCode.getCell(0);
					if (supplierData == null) {
						supplier = "";
					} else if (supplierData.getCellType() == 1) {
						System.out.println(supplierData);
						supplier = checkNullValue(supplierData.getStringCellValue()).trim();
					} else {
						supplier = "";
					}

					Cell acctHead = companyCode.getCell(1);
					if (acctHead == null) {
						acctHeadCode = "";
					} else if (acctHead.getCellType() == 1) {
						System.out.println(acctHead);
						acctHeadCode = checkNullValue(acctHead.getStringCellValue()).trim();
					} else {
						acctHeadCode = "";
					}

					Cell partyInvoiceNo1 = companyCode.getCell(2);
					String partyInvoiceNoData = "";
					if (partyInvoiceNo1 == null) {
						partyInvoiceNoData = "";
					} else if (partyInvoiceNo1.getCellType() == 1) {
						partyInvoiceNoData = checkNullValue(partyInvoiceNo1.getStringCellValue()).trim();
						System.out.println("Invoice +++++++++++++++ " + partyInvoiceNo1);
						purchaseInvoiceHeader.setInvoiceNo(partyInvoiceNoData);
					} else {
						partyInvoiceNoData = "";
					}

					Cell customerData = companyCode.getCell(4);
					if (customerData == null) {
						customer = "";
					} else if (customerData.getCellType() == 1) {
						System.out.println(customerData);
						customer = checkNullValue(customerData.getStringCellValue()).trim();
					} else {
						customer = "";
					}

					Cell narration = companyCode.getCell(5);
					String narrationData = "";
					if (narration == null) {
						narrationData = "";
					} else if (narration.getCellType() == 1) {
						narrationData = checkNullValue(narration.getStringCellValue()).trim();
						System.out.println("Currency +++++++++++++++ " + narration);
						purchaseInvoiceHeader.setCurrency(narrationData);
					} else {
						narrationData = "";
					}

					Cell amountCell = companyCode.getCell(6);
					if (amountCell == null) {
						alertMsg = "Row " + rownnum + " Amount is empty. Excel file cannot be uploaded.";
						return alertMsg;
					} else if (amountCell.getCellType() == 0) {
						amountHeader = amountCell.getNumericCellValue();
						purchaseInvoiceHeader.setBcAmount(amountHeader);
					} else if (amountCell.getCellType() == 1) {
						alertMsg = "Row " + rownnum + " Amount Should be Numeric. Excel file cannot be uploaded.";
						return alertMsg;
					} else {
						alertMsg = "Row " + rownnum + " Amount Format is Wrong. Excel file cannot be uploaded.";
						return alertMsg;
					}

					Cell sundry = companyCode.getCell(7);
					String sundryData = "";
					if (sundry == null) {
						sundryData = "";
					} else if (sundry.getCellType() == 1) {
						sundryData = checkNullValue(sundry.getStringCellValue()).trim();
						System.out.println("Sundry +++++++++++++++ " + sundry);
						purchaseInvoiceHeader.setSundryStatus(sundryData);
					} else {
						sundryData = "";
					}

					Cell finYear = companyCode.getCell(8);
					String finYearData = "";
					if (finYear == null) {
						finYearData = "";
					} else if (finYear.getCellType() == 1) {
						finYearData = checkNullValue(finYear.getStringCellValue()).trim();
						System.out.println("finYear +++++++++++++++ " + finYear);
						purchaseInvoiceHeader.setFinYear(finYearData);
					} else {
						finYearData = "";
					}
					HashMap<String, String> customerMap = new HashMap<>();
					HashMap<String, String> supplierMap = new HashMap<>();
					HashMap<String, String> acctHeadCodeMap = new HashMap<>();

					// companyMap = objPurchaseInvoiceDAO.getCompany();
					supplierMap = branchDAO.getCompany();
					acctHeadCodeMap = branchDAO.getAccount();
					customerMap = branchDAO.getCustomer();

					if (supplier.isEmpty()) {
						purchaseInvoiceHeader.setCompanyId("");

					} else if (checkNullValue(supplier).isEmpty()) {

						alertMsg = "Row " + rownnum + " Company is not Available in Sytem. Excel file cannot be uploaded.";
						return alertMsg;

					} else {
						purchaseInvoiceHeader.setCompanyId(supplierMap.get(supplier));
					}

					if (acctHeadCode.isEmpty()) {
						purchaseInvoiceHeader.setAccountHead("");

					} else if (checkNullValue(acctHeadCode).isEmpty()) {

						alertMsg = "Row " + rownnum + " Account Head is not Available in Sytem. Excel file cannot be uploaded.";
						return alertMsg;

					} else {
						purchaseInvoiceHeader.setAccountHead(acctHeadCodeMap.get(acctHeadCode));
					}

					if (customer.isEmpty()) {
						purchaseInvoiceHeader.setCustomer("");

					} else if (checkNullValue(customer).isEmpty()) {

						alertMsg = "Row " + rownnum + " Customer is not Available in Sytem. Excel file cannot be uploaded.";
						return alertMsg;

					} else {
						purchaseInvoiceHeader.setCustomer(customerMap.get(customer));
					}

					HashMap<String, String> chargesMap = new HashMap<>();
					PurchaseInvoiceDetailBean bean = new PurchaseInvoiceDetailBean();

					index++;
					;
				}

				if (sb.toString().isEmpty()) {

					headerList = branchDAO.save(purchaseInvoiceHeader);
					// alertMsg = "Data uploaded successfully";
					DateFormat FILE_DATE_FORMAT = new SimpleDateFormat("dd_MM_yyyy_HHmmss");

				} else {
					alertMsg = sb.toString();
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			String error[] = String.valueOf(ExceptionUtils.getRootCauseMessage(e)).split(":");
			alertMsg = error[0] + "-" + error[1];
		}
		return alertMsg;

	}

	private Date myFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String checkNullValue(String value) {
		try {

			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			value = "";
			return value;

		}
		return value;
	}

	private int checkNullInteger(String value) {

		int t = 0;
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			} else {
				t = Integer.parseInt(value);
			}
		} catch (Exception e) {
			return t;
		}

		return t;
	}

	private double checkNullDouble(String value) {

		double t = 0;
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			} else {
				t = Double.parseDouble(value);
			}
		} catch (Exception e) {
			return t;
		}

		return t;
	}

}
