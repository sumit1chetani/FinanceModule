package com.dci.tenant.finance.chartOfAccounts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChartOfAccountsServiceImpl implements ChartOfAccountsService {

	@Autowired
	ChartOfAccountsDAO objChartOfAccountsDAO;

	@Override
	public List<ChartOfAccountsBean> getGroupHeadList() {
		return objChartOfAccountsDAO.getGroupHeadList();
	}

	@Override
	public List<ChartOfAccountsBean> getSubGroupHeadList(String groupHeadCode) {
		return objChartOfAccountsDAO.getSubGroupHeadList(groupHeadCode);
	}

	@Override
	public List<ChartOfAccountsBean> getAccountHeadList(String subGroupAcctCode) {
		return objChartOfAccountsDAO.getAccountHeadList(subGroupAcctCode);
	}

	@Override
	public boolean exportExcel(String sFilePath) {

		boolean isSuccess = false;
		List<ChartOfAccountsBean> lChartOfAccountList = objChartOfAccountsDAO.getChartOfAccountsList();
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
			HSSFSheet excelSheet = workbook.createSheet("Chart of accounts");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lChartOfAccountList, my_style2, my_style3);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}
			if (lChartOfAccountList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 3));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Chart of Accounts");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Group Head");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Sub Group");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account Head");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<ChartOfAccountsBean> lChartOfAccountList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 3, sno = 1;
		try {

			for (ChartOfAccountsBean objChartOfAccountsBean : lChartOfAccountList) {

				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);

				for (int i = 0; i < 4; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sGroupHead = objChartOfAccountsBean.getGroupHeadCode() + "-" + objChartOfAccountsBean.getGroupHeadName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sGroupHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				if (objChartOfAccountsBean.getlSubGrpList().size() > 0) {
					for (ChartOfAccountsBean objChartOfAccountSGBean : objChartOfAccountsBean.getlSubGrpList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);

						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						String sSubGroupCode = objChartOfAccountSGBean.getSubGroupAcctCode() + "-" + objChartOfAccountSGBean.getSubGroupAcctName();
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(sSubGroupCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						if (objChartOfAccountSGBean.getlAccountHeadList().size() > 0) {
							for (ChartOfAccountsBean objChartOfAccountAHBean : objChartOfAccountSGBean.getlAccountHeadList()) {
								Row rowah = excelSheet.createRow((short) record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style2);
								cellah0.setCellValue(sno++);

								String sAccountHead = objChartOfAccountAHBean.getAccountHeadCode() + "-" + objChartOfAccountAHBean.getAccountHeadName();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sAccountHead));

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

							}
						}

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/ChartOfAccounts.xls";

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
			url = path + "/ChartOfAccounts.xls";
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
