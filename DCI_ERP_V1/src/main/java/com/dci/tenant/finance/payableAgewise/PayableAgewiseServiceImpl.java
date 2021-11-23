package com.dci.tenant.finance.payableAgewise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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
public class PayableAgewiseServiceImpl implements PayableAgewiseService {

	@Autowired
	PayableAgewiseDAO objPayableAgewiseDAO;

	@Override
	public List<PayableAgewiseBean> getPayableAgewiseReport(String sDate) {
		return objPayableAgewiseDAO.getPayableAgewiseReport(sDate);
	}

	@Override
	public List<PayableAgewiseBean> getPayableAgewiseReportDtl(PayableAgewiseBean objPayableAgewiseBean) {
		return objPayableAgewiseDAO.getPayableAgewiseReportDtl(objPayableAgewiseBean);
	}

	@Override
	public boolean exportPayableAgewiseExcel(String filepath, String sDate) {

		boolean  isSuccess = false;
		List<PayableAgewiseBean> lPayableAgewiseList = objPayableAgewiseDAO.getPayableAgewiseListForExcel(sDate);
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
		//	my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Accounts Payable");

			// set main header
			setExcelMainHeader(excelSheet, my_style,sDate);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lPayableAgewiseList, my_style2, my_style3);

			for (int i = 0; i < 13; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, filepath);

			
			if (lPayableAgewiseList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

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
		cell2.setCellValue("Accounts Payable");
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
			cell1.setCellValue("Vendor");

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

	public void setExcelRows(HSSFSheet excelSheet, List<PayableAgewiseBean> lPayableAgewiseList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		int firstRow = 0;
		int lastRow = 0;
		try {

			for (PayableAgewiseBean objPayableAgewiseBean : lPayableAgewiseList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 13; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sSupplierName = objPayableAgewiseBean.getSupplierCode() + "-" + objPayableAgewiseBean.getSupplierName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sSupplierName));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);
				row.createCell(4).setCellStyle(my_style2);
				row.createCell(5).setCellStyle(my_style2);
				row.createCell(6).setCellStyle(my_style2);

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(objPayableAgewiseBean.getBelow15days());

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style3);
				cell8.setCellValue(objPayableAgewiseBean.getDays30());

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style3);
				cell9.setCellValue(objPayableAgewiseBean.getDays45());

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style3);
				cell10.setCellValue(objPayableAgewiseBean.getDays90());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style3);
				cell11.setCellValue(objPayableAgewiseBean.getDays180());

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style3);
				cell12.setCellValue(objPayableAgewiseBean.getAbove180days());

				firstRow = record;

				if (objPayableAgewiseBean.getlPayableAgewiseDtlList().size() > 0) {
					for (PayableAgewiseBean objPayableAgewiseDtlBean : objPayableAgewiseBean.getlPayableAgewiseDtlList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						rowsg.createCell(1).setCellStyle(my_style2);

						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(objPayableAgewiseDtlBean.getInvoiceNo()));

						Cell cellsg3 = rowsg.createCell(3);
						cellsg3.setCellStyle(my_style2);
						cellsg3.setCellValue(checkNullValue(objPayableAgewiseDtlBean.getInvoiceDate()));

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style3);
						cellsg4.setCellValue(objPayableAgewiseDtlBean.getInvoiceAmount());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style3);
						cellsg5.setCellValue(objPayableAgewiseDtlBean.getPaidAmount());

						Cell cellsg6 = rowsg.createCell(6);
						cellsg6.setCellStyle(my_style3);
						cellsg6.setCellValue(objPayableAgewiseDtlBean.getBalanceAmount());

						Cell cellsg7 = rowsg.createCell(7);
						cellsg7.setCellStyle(my_style3);
						cellsg7.setCellValue(objPayableAgewiseDtlBean.getBelow15days());

						Cell cellsg8 = rowsg.createCell(8);
						cellsg8.setCellStyle(my_style3);
						cellsg8.setCellValue(objPayableAgewiseDtlBean.getDays30());

						Cell cellsg9 = rowsg.createCell(9);
						cellsg9.setCellStyle(my_style3);
						cellsg9.setCellValue(objPayableAgewiseDtlBean.getDays45());

						Cell cellsg10 = rowsg.createCell(10);
						cellsg10.setCellStyle(my_style3);
						cellsg10.setCellValue(objPayableAgewiseDtlBean.getDays90());

						Cell cellsg11 = rowsg.createCell(11);
						cellsg11.setCellStyle(my_style3);
						cellsg11.setCellValue(objPayableAgewiseDtlBean.getDays180());

						Cell cellsg12 = rowsg.createCell(12);
						cellsg12.setCellStyle(my_style3);
						cellsg12.setCellValue(objPayableAgewiseDtlBean.getAbove180days());

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

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/AccountPayable.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/AccountPayable.xls";
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
