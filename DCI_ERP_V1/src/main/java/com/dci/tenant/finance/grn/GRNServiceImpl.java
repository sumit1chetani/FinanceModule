package com.dci.tenant.finance.grn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dci.common.util.CustomException;

@Component
public class GRNServiceImpl implements GRNService {

	@Autowired
	GRNDAO objGRNDAO;

	@Override
	public List<GRNBean> getGRNMasterList(int limit, int offset, String formName) throws Exception {
		return objGRNDAO.getGRNMasterList(limit, offset, formName);
	}

	@Override
	public GRNResultBean getLocationList() {
		// TODO Auto-generated method stub
		return objGRNDAO.getLocationList();
	}

	@Override
	public GRNResultBean getVendorList() {
		// TODO Auto-generated method stub
		return objGRNDAO.getVendorList();
	}

	@Override
	public GRNResultBean getPOList() {
		// TODO Auto-generated method stub
		return objGRNDAO.getPOList();
	}

	@Override
	public GRNResultBean getPODtlList(int poId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getPODtlList(poId);
	}

	@Override
	public boolean saveGrn(GRNBean bean) throws Exception {
		// TODO Auto-generated method stub
		return objGRNDAO.saveGrn(bean);
	}

	@Override
	public String grnAutoIncrementNo() {
		// TODO Auto-generated method stub
		return objGRNDAO.grnAutoIncrementNo();
	}

	@Override
	public GRNResultBean getRequisition(int poId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getRequisition(poId);
	}

	@Override
	public GRNResultBean getVendorAddress(int vendorId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getVendorAddress(vendorId);
	}

	@Override
	public GRNResultBean getGrnEditData(String grnCode) {
		// TODO Auto-generated method stub
		return objGRNDAO.getGrnEditData(grnCode);
	}

	@Override
	public boolean updateGRN(GRNBean bean) throws Exception {
		// TODO Auto-generated method stub
		return objGRNDAO.updateGRN(bean);
	}

	@Override
	public boolean deleteGRN(String grnNo) {
		// TODO Auto-generated method stub
		return objGRNDAO.deleteGRN(grnNo);
	}

	@Override
	public GRNResultBean getDeliverySchedule(int poDtlId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getDeliverySchedule(poDtlId);
	}

	@Override
	public boolean updateGRNwithQC(GRNBean bean) {
		// TODO Auto-generated method stub
		return objGRNDAO.updateGRNwithQC(bean);
	}

	@Override
	public GRNPurchaseOrderBean getItemAttributes(int itemId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getItemAttributes(itemId);
	}

	@Override
	public void exportExcel(String filePath) throws CustomException {
		List<GRNBean> lGrnBean = objGRNDAO.getGRNExportMasterList();
		GenerateGRNListExportALL(lGrnBean, filePath);
	}

	private void GenerateGRNListExportALL(List<GRNBean> lGrnBean, String filePath) {

		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("GRN_File");

		sheet1.setZoom(5, 6);
		CellStyle style = wb.createCellStyle();
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setFontHeight((short) 200);
		font.setFontName("Arial");
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		sheet1.setFitToPage(true);
		sheet1.setMargin((short) 0, 0.20);
		sheet1.setMargin((short) 1, 0.20);
		sheet1.setMargin((short) 2, 0.20);
		sheet1.setMargin((short) 3, 0.20);
		PrintSetup ps = sheet1.getPrintSetup();
		ps.setFitHeight((short) 1);
		ps.setFitWidth((short) 1);
		ps.setFooterMargin(0);
		ps.setLandscape(true);
		ps.setLeftToRight(true);
		ps.setScale((short) 100);
		ps.setPaperSize((short) 9);
		ps.setHeaderMargin(0);
		int rowNumber = 0;
		// heading row
		Row row1 = sheet1.createRow((short) 0);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);

		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("GRN No");

		cell = row1.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("Organization Name");

		cell = row1.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("Purchase Order");

		cell = row1.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("GRN Date");

		cell = row1.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue("Vendor Name");

		cell = row1.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue("Requistion No");

		cell = row1.createCell((short) 6);
		cell.setCellStyle(style);
		cell.setCellValue("Vendor Address");

		cell = row1.createCell((short) 7);
		cell.setCellStyle(style);
		cell.setCellValue("Mode of Transport");

		cell = row1.createCell((short) 8);
		cell.setCellStyle(style);
		cell.setCellValue("Invoice No");

		cell = row1.createCell((short) 9);
		cell.setCellStyle(style);
		cell.setCellValue("Invoice Date");

		cell = row1.createCell((short) 10);
		cell.setCellStyle(style);
		cell.setCellValue("Source Location");

		cell = row1.createCell((short) 11);
		cell.setCellStyle(style);
		cell.setCellValue("Payment Due Date");

		cell = row1.createCell((short) 12);
		cell.setCellStyle(style);
		cell.setCellValue("Destination Location");

		cell = row1.createCell((short) 13);
		cell.setCellStyle(style);
		cell.setCellValue("Delivery Order No");

		cell = row1.createCell((short) 14);
		cell.setCellStyle(style);
		cell.setCellValue("Purchase Type");

		cell = row1.createCell((short) 15);
		cell.setCellStyle(style);
		cell.setCellValue("Delivery Order Date");

		cell = row1.createCell((short) 16);
		cell.setCellStyle(style);
		cell.setCellValue("Description");

		cell = row1.createCell((short) 17);
		cell.setCellStyle(style);
		cell.setCellValue("Created By");

		cell = row1.createCell((short) 18);
		cell.setCellStyle(style);
		cell.setCellValue("Created Date");

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (GRNBean grnBean : lGrnBean) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);

			cell = row.createCell((short) 0);
			cell.setCellValue(grnBean.getGrnCode());
			cell = row.createCell((short) 1);
			cell.setCellValue(grnBean.getCompanyId());
			cell = row.createCell((short) 2);
			cell.setCellValue(grnBean.getPoNo());
			cell = row.createCell((short) 3);
			cell.setCellValue(grnBean.getGrnDate());
			cell = row.createCell((short) 4);
			cell.setCellValue(grnBean.getVendorName());
			cell = row.createCell((short) 5);
			cell.setCellValue(grnBean.getPoRequisition());
			cell = row.createCell((short) 6);
			if (grnBean.getVendorAddress().equalsIgnoreCase(",  - ,  - , ")) {
				cell.setCellValue(" ");

			} else {
				cell.setCellValue(grnBean.getVendorAddress());

			}

			// cell.setCellValue(grnBean.getVendorAddress());
			cell = row.createCell((short) 7);
			if (grnBean.getTransMode() == 1) {
				cell.setCellValue("Person");
			} else if (grnBean.getTransMode() == 2) {
				cell.setCellValue("Courier");

			} else {
				cell.setCellValue("Transport");

			}
			cell = row.createCell((short) 8);
			cell.setCellValue(grnBean.getInvoiceNo());
			cell = row.createCell((short) 9);
			cell.setCellValue(grnBean.getInvoiceDate());
			cell = row.createCell((short) 10);
			cell.setCellValue(grnBean.getLocName());
			cell = row.createCell((short) 11);
			if (grnBean.getDueDate().equalsIgnoreCase("")) {
				cell.setCellValue("");

			} else {
				cell.setCellValue(grnBean.getDueDate());

			}

			cell = row.createCell((short) 12);
			cell.setCellValue(grnBean.getDstLocName());
			cell = row.createCell((short) 13);
			cell.setCellValue(grnBean.getDelOrderNo());
			cell = row.createCell((short) 14);
			cell.setCellValue(grnBean.getPoType());
			cell = row.createCell((short) 15);
			cell.setCellValue(grnBean.getDelOrderDate());
			cell = row.createCell((short) 16);
			cell.setCellValue(grnBean.getDescription());
			cell = row.createCell((short) 17);
			cell.setCellValue(grnBean.getPreparedBy());
			cell = row.createCell((short) 18);
			cell.setCellValue(grnBean.getCreatedDate());

		}

		for (int colNum = 0; colNum < row1.getLastCellNum(); colNum++)
			wb.getSheetAt(0).autoSizeColumn(colNum);

		Random r = new Random();
		number = String.valueOf(r.nextInt()).substring(1, 3);
		writeExcel(wb, filePath);

	}

	public void setExcelMainHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
		Cell cell = row.createCell(0);
		cell.setCellValue("GRN Report");
		cell.setCellStyle(my_style);
	}

	private void setHeading(HSSFWorkbook wb, CellStyle cellStyle) {
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("Arial");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}

	private void writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/GRN_File.xlsx";

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
			url = path + "/GRN_File.xlsx";
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
	public GRNResultBean getPOEditList() throws CustomException {
		// TODO Auto-generated method stub
		return objGRNDAO.getPOEditList();
	}

	@Override
	public GRNPurchaseOrderBean getGrnOldBatchValue(GRNPurchaseOrderBean bean) {
		// TODO Auto-generated method stub
		return objGRNDAO.getGrnOldBatchValue(bean);
	}

	@Override
	public List<GRNPurchaseOrderBean> getBatchList(String grnCode) {
		// TODO Auto-generated method stub
		return objGRNDAO.getBatchList(grnCode);
	}

	@Override
	public GRNResultBean getPOListbasedonCompany(String companyId, int vendorId) {
		// TODO Auto-generated method stub
		return objGRNDAO.getPOListbasedonCompany(companyId, vendorId);
	}

	@Override
	public GRNResultBean getGrnPrintData(String grnCode) {
		// TODO Auto-generated method stub
		return objGRNDAO.getGrnPrintData(grnCode);
	}

	@Override
	public List<GRNBean> getGRNExportMasterList() throws Exception {
		// TODO Auto-generated method stub
		return objGRNDAO.getGRNExportMasterList();
	}

	@Override
	public boolean exportExcelnew(String sFilePath, List<GRNBean> rsList) {
		try {
			// Blank workbook
			// HSSFWorkbook workbook = new HSSFWorkbook();
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			workbook.setCompressTempFiles(true);

			XSSFCellStyle my_style = (XSSFCellStyle) workbook.createCellStyle();
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
			my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = (XSSFCellStyle) workbook.createCellStyle();
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style3 = (XSSFCellStyle) workbook.createCellStyle();
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style4 = (XSSFCellStyle) workbook.createCellStyle();
			my_style4.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style4.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			// my_style4.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			// Create a blank sheet

			XSSFCellStyle my_style11 = (XSSFCellStyle) workbook.createCellStyle();
			my_style11.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style11.setAlignment(my_style.ALIGN_CENTER);
			my_style11.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style11.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style11.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font11 = workbook.createFont();
			font11.setFontHeight((short) 200);
			font11.setFontName("Arial");
			font11.setColor(HSSFColor.BLACK.index);
			// font11.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font11.setFontHeightInPoints((short) 10);
			my_style11.setFont(font11);

			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("GRN");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// set main header
			setExcelMainHeader1(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// set Data
			setExcelRows(excelSheet, rsList, my_style11, my_style2, my_style3, my_style4);

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;

	}

	public void setExcelMainHeader1(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 18));
		Cell cell = row.createCell(0);
		cell.setCellValue("GRN");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row1 = excelSheet.createRow(2);
			row1.setHeight((short) 350);
			Cell cell0 = row1.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("GRN No");

			Cell cell1 = row1.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Organization Name");

			Cell cell2 = row1.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Purchase Order");

			Cell cell3 = row1.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("GRN Date");

			Cell cell4 = row1.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Vendor Name");

			Cell cell5 = row1.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Requistion No");

			Cell cell6 = row1.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Vendor Address");

			Cell cell7 = row1.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Mode of Transport");

			Cell cell8 = row1.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Invoice No");

			Cell cell9 = row1.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Invoice Date");

			Cell cell10 = row1.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Source Location");

			Cell cell11 = row1.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Payment Due Date");

			Cell cell12 = row1.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Destination Location");

			Cell cell13 = row1.createCell(13);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("Delivery Order No");

			Cell cell14 = row1.createCell(14);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue("Purchase Type");

			Cell cell15 = row1.createCell(15);
			cell15.setCellStyle(my_style1);
			cell15.setCellValue("Delivery Order Date");

			Cell cell16 = row1.createCell(16);
			cell16.setCellStyle(my_style1);
			cell16.setCellValue("Description");

			Cell cell17 = row1.createCell(17);
			cell17.setCellStyle(my_style1);
			cell17.setCellValue("Created By");

			Cell cell18 = row1.createCell(18);
			cell18.setCellStyle(my_style1);
			cell18.setCellValue("Created Date");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(SXSSFSheet excelSheet, List<GRNBean> list, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;

		try {
			for (GRNBean bean : list) {

				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style1);
				cell0.setCellValue(bean.getGrnCode());

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style1);
				cell1.setCellValue(bean.getCompanyId());

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style1);
				cell2.setCellValue(bean.getPoNo());

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style1);
				cell3.setCellValue(bean.getGrnDate());

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style1);
				cell4.setCellValue(bean.getVendorName());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style1);
				cell5.setCellValue(bean.getPoRequisition());

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style1);
				if (bean.getVendorAddress().equalsIgnoreCase(",  - ,  - , ")) {

					cell6.setCellValue("");
				} else {
					cell6.setCellValue(bean.getVendorAddress());

				}

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style1);
				if (bean.getTransMode() == 1) {
					cell7.setCellValue("Person");
				} else if (bean.getTransMode() == 2) {
					cell7.setCellValue("Courier");

				} else {
					cell7.setCellValue("Transport");

				}

				// cell7.setCellValue(bean.getInvoiceNo());

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style1);
				cell8.setCellValue(bean.getInvoiceNo());

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style1);
				cell9.setCellValue(bean.getInvoiceDate());

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style1);
				cell10.setCellValue(bean.getLocName());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style1);
				if (bean.getDueDate().equalsIgnoreCase("")) {
					cell11.setCellValue("");

				} else {
					cell11.setCellValue(bean.getDueDate());

				}

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style1);
				cell12.setCellValue(bean.getDstLocName());

				Cell cell13 = row.createCell(13);
				cell13.setCellStyle(my_style1);
				cell13.setCellValue(bean.getDelOrderNo());

				Cell cell14 = row.createCell(14);
				cell14.setCellStyle(my_style1);
				cell14.setCellValue(bean.getPoType());

				Cell cell15 = row.createCell(15);
				cell15.setCellStyle(my_style1);
				cell15.setCellValue(bean.getDelOrderDate());

				Cell cell16 = row.createCell(16);
				cell16.setCellStyle(my_style1);
				cell16.setCellValue(bean.getDescription());

				Cell cell17 = row.createCell(17);
				cell17.setCellStyle(my_style1);
				cell17.setCellValue(bean.getPreparedBy());

				Cell cell18 = row.createCell(18);
				cell18.setCellStyle(my_style1);
				cell18.setCellValue(bean.getCreatedDate());

			}

			// for (int i = 0; i < 7; i++) {
			// excelSheet.autoSizeColumn(i);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/GRN_File.xlsx";

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
			url = path + "/GRN_File.xlsx";
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

	/*
	 * @Override public boolean exportExcelnew(String sFilePath, List<GRNBean>
	 * rsList) { // TODO Auto-generated method stub return false; }
	 */

}
