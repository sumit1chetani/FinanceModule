package com.dci.tenant.finance.soa;

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
import org.springframework.stereotype.Component;

@Component
public class SOAServiceImpl implements SOAService {

	@Autowired
	SOADao soaDao;

	@Override
	public List<SOABean> getSoaCustomerRprtList(SOABean soabean) {
		// TODO Auto-generated method stub
		return soaDao.getSoaCustomerRprtList(soabean);
	}

	@Override
	public List<SOABean> soaCustomerRprtSubList( SOABean soabean) {
		// TODO Auto-generated method stub
		return soaDao.soaCustomerRprtSubList(soabean);
	}

	@Override
	public double debtorBalance(SOABean soabean) {
		// TODO Auto-generated method stub
		return soaDao.debtorBalance(soabean);
	}

	@Override
	public boolean exportExcel(String filepath, SOABean soabean) {

		boolean isSuccess =false;
		List<SOABean> lSOABean = soaDao.getSoaCustomerRprtList( soabean);
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
			HSSFSheet excelSheet = workbook.createSheet("Statement Of Accounts");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lSOABean, my_style2, my_style3);

			for (int i = 0; i < 13; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, filepath);

			if (lSOABean.size()> 0) {
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

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
	
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 7));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 7));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Statement Of Accounts");
		cell2.setCellStyle(my_style);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 3);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Account Code");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Account Name");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Ledger Date");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Transaction No");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Debit");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Credit");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<SOABean> lSOABean, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		try {

			for (SOABean objSOABean : lSOABean) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objSOABean.getCode()));

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(objSOABean.getName()));

				row.createCell(3).setCellStyle(my_style2);
				row.createCell(4).setCellStyle(my_style2);

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style3);
				cell5.setCellValue(objSOABean.getDebit());

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style3);
				cell6.setCellValue(objSOABean.getCredit());

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(objSOABean.getBalance());

				firstRow = record;
				SOABean soabean = new SOABean();
				//List<SOABean> soaSubList = null;

				List<SOABean> soaSubList = soaDao.soaCustomerRprtSubList(soabean);
				if (soaSubList.size() > 0) {
					for (SOABean objSubSOABean : soaSubList) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(2).setCellStyle(my_style2);

						Cell cellsg3 = rowsg.createCell(3);
						cellsg3.setCellStyle(my_style2);
						cellsg3.setCellValue(objSubSOABean.getLedgerDate());

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style2);
						cellsg4.setCellValue(objSubSOABean.getTransactionNo());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style3);
						cellsg5.setCellValue(objSubSOABean.getDebit());

						Cell cellsg6 = rowsg.createCell(6);
						cellsg6.setCellStyle(my_style3);
						cellsg6.setCellValue(objSubSOABean.getCredit());

						rowsg.createCell(7).setCellStyle(my_style2);
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

/*	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/StatementOfAccounts.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/StatementOfAccounts.xls";
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

*/	
	
	
	
	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/StatementOfAccounts.xls";

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
			url = path + "/StatementOfAccounts.xls";
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
