package com.dci.tenant.finance.receivableAgewise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceivableAgewiseServiceImpl implements ReceivableAgewiseService {

	@Autowired
	ReceivableAgewiseDao objReceivableAgewiseDao;

	@Override
	public List<ReceivableAgewiseBean> getReceivableAgewiseReport(String sDate) {
		return objReceivableAgewiseDao.getReceivableAgewiseReport(sDate);
	}

	@Override
	public List<ReceivableAgewiseBean> getReceivableAgewiseReportDtl(ReceivableAgewiseBean objReceivableAgewiseBean) {
		return objReceivableAgewiseDao.getReceivableAgewiseReportDtl(objReceivableAgewiseBean);
	}

	@Override
	public boolean exportReceivableAgewiseExcel(String filepath, String sDate) {

		boolean isSuccess = false;
		List<ReceivableAgewiseBean> lReceivableAgewiseList = objReceivableAgewiseDao.getReceivableAgewiseListForExcel(sDate);
		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			HSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			HSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Accounts Receivable");

			// set main header
			setExcelMainHeader(excelSheet, my_style, sDate);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lReceivableAgewiseList, my_style2, my_style3);

			for (int i = 0; i < 13; i++) {
				excelSheet.autoSizeColumn(i);
			}
			if (lReceivableAgewiseList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			// export excell
			isSuccess = writeExcel(workbook, filepath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style, String sDate) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		 
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 12));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		
		
		Row row3 = excelSheet.createRow((short)2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 12));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue(sDate);
		cell3.setCellStyle(my_style);
		
		Row row2 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 12));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Accounts Receivable");
		cell2.setCellStyle(my_style);
		
		
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("S.No");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Customer");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Invoice no");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Invoice Dt");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Invoice Amt");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Paid Amt");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Balance Amt");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Below 15 days");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Below 30 days");

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Below 45 days");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Below 90 days");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Below 180 days");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Above 180 days");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<ReceivableAgewiseBean> lReceivableAgewiseList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		int firstRow = 0;
		int lastRow = 0;
		try {

			for (ReceivableAgewiseBean objReceivableAgewiseBean : lReceivableAgewiseList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 13; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sSupplierName = objReceivableAgewiseBean.getCustomerCode() + "-" + objReceivableAgewiseBean.getCustomerName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sSupplierName));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);
				row.createCell(4).setCellStyle(my_style2);
				row.createCell(5).setCellStyle(my_style2);
				row.createCell(6).setCellStyle(my_style2);

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style2);
				cell7.setCellValue(objReceivableAgewiseBean.getBelow15days());

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(objReceivableAgewiseBean.getDays30());

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style2);
				cell9.setCellValue(objReceivableAgewiseBean.getDays45());

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style2);
				cell10.setCellValue(objReceivableAgewiseBean.getDays90());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style2);
				cell11.setCellValue(objReceivableAgewiseBean.getDays180());

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style2);
				cell12.setCellValue(objReceivableAgewiseBean.getAbove180days());

				firstRow = record;

				if (objReceivableAgewiseBean.getlReceivableAgewiseDtlList().size() > 0) {
					for (ReceivableAgewiseBean objReceivableAgewiseDtlBean : objReceivableAgewiseBean.getlReceivableAgewiseDtlList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						rowsg.createCell(1).setCellStyle(my_style2);

						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(objReceivableAgewiseDtlBean.getInvoiceNo()));

						Cell cellsg3 = rowsg.createCell(3);
						cellsg3.setCellStyle(my_style2);
						cellsg3.setCellValue(checkNullValue(objReceivableAgewiseDtlBean.getInvoiceDate()));

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style2);
						cellsg4.setCellValue(objReceivableAgewiseDtlBean.getInvoiceAmount());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style2);
						cellsg5.setCellValue(objReceivableAgewiseDtlBean.getPaidAmount());

						Cell cellsg6 = rowsg.createCell(6);
						cellsg6.setCellStyle(my_style2);
						cellsg6.setCellValue(objReceivableAgewiseDtlBean.getBalanceAmount());

						Cell cellsg7 = rowsg.createCell(7);
						cellsg7.setCellStyle(my_style2);
						cellsg7.setCellValue(objReceivableAgewiseDtlBean.getBelow15days());

						Cell cellsg8 = rowsg.createCell(8);
						cellsg8.setCellStyle(my_style2);
						cellsg8.setCellValue(objReceivableAgewiseDtlBean.getDays30());

						Cell cellsg9 = rowsg.createCell(9);
						cellsg9.setCellStyle(my_style2);
						cellsg9.setCellValue(objReceivableAgewiseDtlBean.getDays45());

						Cell cellsg10 = rowsg.createCell(10);
						cellsg10.setCellStyle(my_style2);
						cellsg10.setCellValue(objReceivableAgewiseDtlBean.getDays90());

						Cell cellsg11 = rowsg.createCell(11);
						cellsg11.setCellStyle(my_style2);
						cellsg11.setCellValue(objReceivableAgewiseDtlBean.getDays180());

						Cell cellsg12 = rowsg.createCell(12);
						cellsg12.setCellStyle(my_style2);
						cellsg12.setCellValue(objReceivableAgewiseDtlBean.getAbove180days());

					}

				}
				lastRow = record;
				excelSheet.groupRow(firstRow, lastRow);
				excelSheet.setRowGroupCollapsed(firstRow, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean writeExcel(HSSFWorkbook myWorkBook, String path) {

		boolean isSuccess = true;
		String sOutFile = path + "/AccountReceivable.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}

		}
		return isSuccess;
	}

	private String checkNullValue(String value) {

		String t = "";
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			return t;
		}

		return value;
	}
}
