package com.dci.tenant.finance.profitAndLoss;

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
public class ProfitAndLossServiceImpl implements ProfitAndLossService {

	@Autowired
	ProfitAndLossDao objProfitAndLossDao;

	@Override
	public List<ProfitAndLossBean> generatePLReport1(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReport1(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReport(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReport(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl1(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportDtl1(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportDtl(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportDtl(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportAHDtl(objProfitAndLossBean);
	}

	@Override
	public List<ProfitAndLossBean> generatePLReportAHDtl1(ProfitAndLossBean objProfitAndLossBean) {
		return objProfitAndLossDao.generatePLReportAHDtl1(objProfitAndLossBean);
	}

	@Override
	public boolean exportPLExcel(ProfitAndLossBean objProfitAndLossBean, String sFilePath) {

		List<ProfitAndLossBean> lProfitLossList = objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);
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
			HSSFSheet excelSheet = workbook.createSheet("Income and Expenditure");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lProfitLossList, my_style2, my_style3);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	@Override
	public boolean exportPLExcel1(ProfitAndLossBean objProfitAndLossBean, String sFilePath) {

		List<ProfitAndLossBean> lProfitLossList = objProfitAndLossDao.getProfitLossReportList1(objProfitAndLossBean);
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
			HSSFSheet excelSheet = workbook.createSheet("Income and Expenditure");

			// set main header
			setExcelMainHeader1(excelSheet, my_style);

			// set header
			setExcelHeader1(excelSheet, my_style1);

			// set Data
			setExcelRows1(excelSheet, lProfitLossList, my_style2, my_style3);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelRows1(HSSFSheet excelSheet, List<ProfitAndLossBean> lProfitLossList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			for (ProfitAndLossBean objProfitAndLossBean : lProfitLossList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sGroupHead = objProfitAndLossBean.getGroupHeadCode() + "-" + objProfitAndLossBean.getGroupHeadName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sGroupHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(objProfitAndLossBean.getDebitAmount());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(objProfitAndLossBean.getCreditAmount());

				firstRow = record;

				if (objProfitAndLossBean.getlSubGroupLevelList().size() > 0) {
					for (ProfitAndLossBean objProfitAndLossSGBean : objProfitAndLossBean.getlSubGroupLevelList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						String sSubGroupCode = objProfitAndLossSGBean.getGroupHeadCode() + "-" + objProfitAndLossSGBean.getGroupHeadName();
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(sSubGroupCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style2);
						cellsg4.setCellValue(objProfitAndLossSGBean.getDebitAmount());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style2);
						cellsg5.setCellValue(objProfitAndLossSGBean.getCreditAmount());

						if (objProfitAndLossSGBean.getlAccountHeadLevelList().size() > 0) {
							for (ProfitAndLossBean objProfitAndLossAHBean : objProfitAndLossSGBean.getlAccountHeadLevelList()) {
								firstAhRow = record;
								Row rowah = excelSheet.createRow((short) record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style2);
								cellah0.setCellValue(sno++);

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

								String sAccountHeadCode = objProfitAndLossAHBean.getGroupHeadCode() + "-" + objProfitAndLossAHBean.getGroupHeadName();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sAccountHeadCode));

								Cell cellah4 = rowah.createCell(4);
								cellah4.setCellStyle(my_style2);
								cellah4.setCellValue(objProfitAndLossAHBean.getDebitAmount());

								Cell cellah5 = rowah.createCell(5);
								cellah5.setCellStyle(my_style2);
								cellah5.setCellValue(objProfitAndLossAHBean.getDebitAmount());

								lastRow = record;
								excelSheet.groupRow(firstAhRow, lastRow);
								excelSheet.setRowGroupCollapsed(firstAhRow, true);
							}
						}
						lastRow = record;
						excelSheet.groupRow(firstSgRow, lastRow);
						excelSheet.setRowGroupCollapsed(firstSgRow, true);
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

	public void setExcelMainHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 5));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Income and Expenditure");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
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
			cell2.setCellValue("Sub Group Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account head");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Debit");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 13));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Income and Expenditure");
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
			cell2.setCellValue("Sub Group Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account head");
			Cell cell21 = row.createCell((short) 4);
			cell21.setCellStyle(my_style1);
			cell21.setCellValue("OMEGA");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 4, (short) 5));

			Cell cell12 = row.createCell((short) 6);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("LMES");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 6, (short) 7));

			Cell cell22 = row.createCell((short) 8);
			cell22.setCellStyle(my_style1);
			cell22.setCellValue("LMOIS CBSE");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 8, (short) 9));

			Cell cell231 = row.createCell((short) 10);
			cell231.setCellStyle(my_style1);
			cell231.setCellValue("LMOIS CIS");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 10, (short) 11));

			Cell cell24 = row.createCell((short) 12);
			cell24.setCellStyle(my_style1);
			cell24.setCellValue("LMOIS MONT");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 12, (short) 13));
			Row row2 = excelSheet.createRow((short) 3);
			Cell cell212 = row2.createCell((short) 0);
			cell212.setCellStyle(my_style1);
			cell212.setCellValue("");
			excelSheet.addMergedRegion(new CellRangeAddress(3, (short) 3, 0, (short) 3));

			Cell cell11 = row2.createCell(4);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Debit");

			Cell cell13 = row2.createCell(5);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("Credit");

			Cell cell4 = row2.createCell(6);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Debit");

			Cell cell41 = row2.createCell(7);
			cell41.setCellStyle(my_style1);
			cell41.setCellValue("Credit");

			Cell cell5 = row2.createCell(8);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Debit");

			Cell cell6 = row2.createCell(9);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Credit");

			Cell cell7 = row2.createCell(10);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Debit");

			Cell cell8 = row2.createCell(11);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Credit");

			Cell cell9 = row2.createCell(12);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Debit");

			Cell cell10 = row2.createCell(13);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<ProfitAndLossBean> lProfitLossList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			for (ProfitAndLossBean objProfitAndLossBean : lProfitLossList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sGroupHead = objProfitAndLossBean.getGroupHeadCode() + "-" + objProfitAndLossBean.getGroupHeadName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sGroupHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(objProfitAndLossBean.getC0008_debitAmount());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(objProfitAndLossBean.getC0008_creditAmount());
				Cell cell41 = row.createCell(6);
				cell41.setCellStyle(my_style2);
				cell41.setCellValue(objProfitAndLossBean.getC0009_debitAmount());

				Cell cell51 = row.createCell(7);
				cell51.setCellStyle(my_style2);
				cell51.setCellValue(objProfitAndLossBean.getC0009_creditAmount());
				Cell cell42 = row.createCell(8);
				cell42.setCellStyle(my_style2);
				cell42.setCellValue(objProfitAndLossBean.getC0010_debitAmount());

				Cell cell53 = row.createCell(9);
				cell53.setCellStyle(my_style2);
				cell53.setCellValue(objProfitAndLossBean.getC0010_creditAmount());
				Cell cell43 = row.createCell(10);
				cell43.setCellStyle(my_style2);
				cell43.setCellValue(objProfitAndLossBean.getC0011_debitAmount());

				Cell cell54 = row.createCell(11);
				cell54.setCellStyle(my_style2);
				cell54.setCellValue(objProfitAndLossBean.getC0011_creditAmount());
				Cell cell44 = row.createCell(12);
				cell44.setCellStyle(my_style2);
				cell44.setCellValue(objProfitAndLossBean.getC0012_debitAmount());

				Cell cell56 = row.createCell(13);
				cell56.setCellStyle(my_style2);
				cell56.setCellValue(objProfitAndLossBean.getC0012_creditAmount());

				firstRow = record;

				if (objProfitAndLossBean.getlSubGroupLevelList().size() > 0) {
					for (ProfitAndLossBean objProfitAndLossSGBean : objProfitAndLossBean.getlSubGroupLevelList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						String sSubGroupCode = objProfitAndLossSGBean.getGroupHeadCode() + "-" + objProfitAndLossSGBean.getGroupHeadName();
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(sSubGroupCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style2);
						cellsg4.setCellValue(objProfitAndLossSGBean.getC0008_debitAmount());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style2);
						cellsg5.setCellValue(objProfitAndLossSGBean.getC0008_creditAmount());

						Cell cellsg41 = rowsg.createCell(6);
						cellsg41.setCellStyle(my_style2);
						cellsg41.setCellValue(objProfitAndLossSGBean.getC0009_debitAmount());

						Cell cellsg52 = rowsg.createCell(7);
						cellsg52.setCellStyle(my_style2);
						cellsg52.setCellValue(objProfitAndLossSGBean.getC0009_creditAmount());

						Cell cellsg43 = rowsg.createCell(8);
						cellsg43.setCellStyle(my_style2);
						cellsg43.setCellValue(objProfitAndLossSGBean.getC0010_debitAmount());

						Cell cellsg54 = rowsg.createCell(9);
						cellsg54.setCellStyle(my_style2);
						cellsg54.setCellValue(objProfitAndLossSGBean.getC0010_creditAmount());

						Cell cellsg45 = rowsg.createCell(10);
						cellsg45.setCellStyle(my_style2);
						cellsg45.setCellValue(objProfitAndLossSGBean.getC0011_debitAmount());

						Cell cellsg55 = rowsg.createCell(11);
						cellsg55.setCellStyle(my_style2);
						cellsg55.setCellValue(objProfitAndLossSGBean.getC0011_creditAmount());

						Cell cellsg47 = rowsg.createCell(12);
						cellsg47.setCellStyle(my_style2);
						cellsg47.setCellValue(objProfitAndLossSGBean.getC0012_debitAmount());

						Cell cellsg59 = rowsg.createCell(13);
						cellsg59.setCellStyle(my_style2);
						cellsg59.setCellValue(objProfitAndLossSGBean.getC0012_creditAmount());

						if (objProfitAndLossSGBean.getlAccountHeadLevelList().size() > 0) {
							for (ProfitAndLossBean objProfitAndLossAHBean : objProfitAndLossSGBean.getlAccountHeadLevelList()) {
								firstAhRow = record;
								Row rowah = excelSheet.createRow((short) record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style2);
								cellah0.setCellValue(sno++);

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

								String sAccountHeadCode = objProfitAndLossAHBean.getGroupHeadCode() + "-" + objProfitAndLossAHBean.getGroupHeadName();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sAccountHeadCode));

								Cell cellah4 = rowah.createCell(4);
								cellah4.setCellStyle(my_style2);
								cellah4.setCellValue(objProfitAndLossAHBean.getC0008_debitAmount());

								Cell cellah5 = rowah.createCell(5);
								cellah5.setCellStyle(my_style2);
								cellah5.setCellValue(objProfitAndLossAHBean.getC0008_creditAmount());

								Cell cellah41 = rowah.createCell(6);
								cellah41.setCellStyle(my_style2);
								cellah41.setCellValue(objProfitAndLossAHBean.getC0009_debitAmount());

								Cell cellah51 = rowah.createCell(7);
								cellah51.setCellStyle(my_style2);
								cellah51.setCellValue(objProfitAndLossAHBean.getC0009_creditAmount());

								Cell cellah42 = rowah.createCell(8);
								cellah42.setCellStyle(my_style2);
								cellah42.setCellValue(objProfitAndLossAHBean.getC0010_debitAmount());

								Cell cellah52 = rowah.createCell(9);
								cellah52.setCellStyle(my_style2);
								cellah52.setCellValue(objProfitAndLossAHBean.getC0010_creditAmount());

								Cell cellah43 = rowah.createCell(10);
								cellah43.setCellStyle(my_style2);
								cellah43.setCellValue(objProfitAndLossAHBean.getC0011_debitAmount());

								Cell cellah53 = rowah.createCell(11);
								cellah53.setCellStyle(my_style2);
								cellah53.setCellValue(objProfitAndLossAHBean.getC0011_creditAmount());

								Cell cellah44 = rowah.createCell(12);
								cellah44.setCellStyle(my_style2);
								cellah44.setCellValue(objProfitAndLossAHBean.getC0012_debitAmount());

								Cell cellah55 = rowah.createCell(13);
								cellah55.setCellStyle(my_style2);
								cellah55.setCellValue(objProfitAndLossAHBean.getC0012_creditAmount());

								lastRow = record;
								excelSheet.groupRow(firstAhRow, lastRow);
								excelSheet.setRowGroupCollapsed(firstAhRow, true);
							}
						}
						lastRow = record;
						excelSheet.groupRow(firstSgRow, lastRow);
						excelSheet.setRowGroupCollapsed(firstSgRow, true);
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

		String sOutFile = path + "/Income and Expenditure.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/Income and Expenditure.xls";
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

	@Override
	public ProfitAndLossBean getProfitLossTransactions(String accountHeadCode, String fromDate, String toDate) {
		return objProfitAndLossDao.getProfitLossTransactions(accountHeadCode, fromDate, toDate);
	}
}
