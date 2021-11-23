package com.dci.tenant.finance.inventoryRprt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryRprtServiceImpl implements InventoryRprtService {

	@Autowired
	InventoryRprtDAO inventoryRprtDAO;

	@Override
	public List<InventoryRprtBean> getInventoryMasterList(int limit, int offset) {
		// TODO Auto-generated method stub
		return inventoryRprtDAO.getInventoryMasterList(limit, offset);
	}

	@Override
	public List<InventoryRprtDtlBean> getInventroySubList(int item, int location, String invDate) {
		// TODO Auto-generated method stub
		return inventoryRprtDAO.getInventroySubList(item, location, invDate);
	}

	@Override
	public InventroyRprtListBean getDropDowns() {
		// TODO Auto-generated method stub
		return inventoryRprtDAO.getDropDowns();
	}

	@Override
	public List<InventoryRprtBean> getInventroyListWithParam(int item, int location, String stockon) {
		// TODO Auto-generated method stub
		return inventoryRprtDAO.getInventroyListWithParam(item, location, stockon);
	}

	@Override
	public List<InventoryRprtBean> getinvlistBelowROL() {
		return inventoryRprtDAO.getinvlistBelowROL();
	}

	@Override
	public List<InventoryRprtDtlBean> getSubGridBatchDetails(int ledgerId) {
		return inventoryRprtDAO.getSubGridBatchDetails(ledgerId);
	}

	@Override
	public List<InventoryRprtBean> getInventoryNewMasterList(int limit, int offset) {

		return inventoryRprtDAO.getInventoryNewMasterList(limit, offset);
	}

	@Override
	public List<InventoryRprtBean> getInventroyNewListWithParam(String item, String location, String fromdate, String todate, String category) {

		return inventoryRprtDAO.getInventroyNewListWithParam(item, location, fromdate, todate, category);
	}

	@Override
	public List<InventoryRprtDtlBean> getInventroyNewSubList(int item, String invDate) {

		return inventoryRprtDAO.getInventroyNewSubList(item, invDate);
	}

	@Override
	public boolean exportExcel(String exportFilesPath, List<InventoryRprtBean> list) {

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

			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("Inventory Summary Report");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// set Data
			setExcelRows(excelSheet, list, my_style11, my_style2, my_style3, my_style4);

			// export excell
			String sFileUrl = writeExcel(workbook, exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;

	}

	public void setExcelMainHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
		Cell cell = row.createCell(0);
		cell.setCellValue("Inventory Summary Report");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow(2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Invoice Date");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Item");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Category");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Unit");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Opening");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Received");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Issued");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Current Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(SXSSFSheet excelSheet, List<InventoryRprtBean> list, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;

		try {
			for (InventoryRprtBean bean : list) {

				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style1);
				cell0.setCellValue(bean.getInvDate());

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style1);
				cell1.setCellValue(bean.getItemName());

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style1);
				cell2.setCellValue(bean.getCategoryname());

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style1);
				cell3.setCellValue(bean.getUnit());

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style1);
				cell4.setCellValue(bean.getOpening());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style1);
				cell5.setCellValue(bean.getReceived());

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style1);
				cell6.setCellValue(bean.getIssued());

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style1);
				cell7.setCellValue(bean.getCurBal());

			}

			// for (int i = 0; i < 7; i++) {
			// excelSheet.autoSizeColumn(i);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/InventorySummaryReport.xlsx";

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
			url = path + "/InventorySummaryReport.xlsx";
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

	@Override
	public List<InventoryRprtBean> getInventroyNewListExport(String item, String location, String fomdate, String todate, String categoryid) {
		// TODO Auto-generated method stub
		return inventoryRprtDAO.getInventroyNewListExport(item, location, fomdate, todate, categoryid);
	}

}
