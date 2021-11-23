package com.dci.tenant.finance.balanceSheet;

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
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.finance.GeneralLedger.GeneralLedgerBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BalanceSheetServiceImpl implements BalanceSheetService {

	@Autowired
	BalanceSheetDao objBalanceSheetDao;

	@Override
	public List<SelectivityBean> getCompanyList() {
		return objBalanceSheetDao.getCompanyList();
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetList1(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.getBalanceSheetList1(objBalanceSheetBean);
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetListAsset(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.getBalanceSheetListAsset(objBalanceSheetBean);
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetListLiabilities(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.getBalanceSheetListLiabilities(objBalanceSheetBean);
	}

	@Override
	public List<BalanceSheetBean> getBalanceSheetList(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.getBalanceSheetList(objBalanceSheetBean);
	}

	@Override
	public List<BalanceSheetBean> generateBalanceSheetReportDtl(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.generateBalanceSheetReportDtl(objBalanceSheetBean);
	}

	@Override
	public List<BalanceSheetBean> generateBalanceSheetReportAHDtl(BalanceSheetBean objBalanceSheetBean) {
		return objBalanceSheetDao.generateBalanceSheetReportAHDtl(objBalanceSheetBean);
	}

	@Override
	public boolean excelBSExport(BalanceSheetBean objBalanceSheetBean, String filepath) {

		boolean isSuccess=false;
		List<BalanceSheetBean> lBalanceSheetList = objBalanceSheetDao.getBalanceSheetReportList(objBalanceSheetBean);
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
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			

			HSSFCellStyle my_styleTotal = workbook.createCellStyle();
			my_styleTotal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			org.apache.poi.ss.usermodel.Font fontTotal = workbook.createFont();
			fontTotal.setFontHeight((short) 200);
			fontTotal.setFontName("Arial");
			fontTotal.setColor(HSSFColor.BLACK.index);
			fontTotal.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			fontTotal.setFontHeightInPoints((short) 10);
			my_styleTotal.setFont(fontTotal);
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Balance Sheet");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lBalanceSheetList, my_style2, my_style3, my_styleTotal);

			for (int i = 0; i < 12; i++) {
				excelSheet.autoSizeColumn(i);
			}

			if (lBalanceSheetList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			
			
			// export excell
			String sFileUrl = writeExcel(workbook, filepath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	@Override
	public boolean excelBSExport1(BalanceSheetBean objBalanceSheetBean, String filepath) {
		boolean isSuccess=false;

		List<BalanceSheetBean> lBalanceSheetList = objBalanceSheetDao.getBalanceSheetReportList1(objBalanceSheetBean);
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
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			HSSFCellStyle my_styleTotal = workbook.createCellStyle();
			my_styleTotal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_styleTotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			org.apache.poi.ss.usermodel.Font fontTotal = workbook.createFont();
			fontTotal.setFontHeight((short) 200);
			fontTotal.setFontName("Arial");
			fontTotal.setColor(HSSFColor.BLACK.index);
			fontTotal.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
			fontTotal.setFontHeightInPoints((short) 10);
			my_styleTotal.setFont(fontTotal);

			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Balance Sheet");

			// set main header
			setExcelMainHeader1(excelSheet, my_style, objBalanceSheetBean);

			// set header
			setExcelHeader1(excelSheet, my_style1);

			// set Data
			setExcelRows1(excelSheet, lBalanceSheetList, my_style2, my_style3, my_styleTotal);

			for (int i = 0; i < 12; i++) {
				excelSheet.autoSizeColumn(i);
			}

			if (lBalanceSheetList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			// export excell
			String sFileUrl = writeExcel(workbook, filepath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelMainHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style, BalanceSheetBean objBalanceSheetBean) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 4));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue ( objBalanceSheetBean.getFromDate());
		cell2.setCellStyle(my_style);
		
		Row row3 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 4));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue ("Balance Sheet");
		cell3.setCellStyle(my_style);
		
	}

	public void setExcelHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 4);
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
			cell4.setCellValue("Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows1(HSSFSheet excelSheet, List<BalanceSheetBean> lBalanceSheetList, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_styleTotal) {
		int record = 5, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			for (BalanceSheetBean objBalanceSheetBean : lBalanceSheetList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sGroupHead = objBalanceSheetBean.getGroupHeadCode() + "-" + objBalanceSheetBean.getGroupHeadName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_styleTotal);
				cell1.setCellValue(checkNullValue(sGroupHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style3);
				cell4.setCellValue(objBalanceSheetBean.getAmount());
				firstRow = record;

				if (objBalanceSheetBean.getlSubGroupLevelList().size() > 0) {
					for (BalanceSheetBean objBalanceSheetSGBean : objBalanceSheetBean.getlSubGroupLevelList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						String sSubGroupCode = objBalanceSheetSGBean.getGroupHeadCode() + "-" + objBalanceSheetSGBean.getGroupHeadName();
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_styleTotal);
						cellsg2.setCellValue(checkNullValue(sSubGroupCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style3);
						cellsg4.setCellValue(objBalanceSheetSGBean.getBalance());

						if (objBalanceSheetSGBean.getlAccountHeadLevelList().size() > 0) {
							for (BalanceSheetBean objBalanceSheetAHBean : objBalanceSheetSGBean.getlAccountHeadLevelList()) {
								firstAhRow = record;
								Row rowah = excelSheet.createRow((short) record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style2);
								cellah0.setCellValue(sno++);

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

								String sAccountHeadCode = objBalanceSheetAHBean.getGroupHeadCode() + "-" + objBalanceSheetAHBean.getGroupHeadName();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sAccountHeadCode));

								Cell cellah4 = rowah.createCell(4);
								cellah4.setCellStyle(my_style3);
								cellah4.setCellValue(objBalanceSheetAHBean.getBalance());

								lastRow = record;
								// excelSheet.groupRow(firstAhRow, lastRow);
								// excelSheet.setRowGroupCollapsed(firstAhRow,
								// true);
							}
						}
						lastRow = record;
						// excelSheet.groupRow(firstSgRow, lastRow);
						// excelSheet.setRowGroupCollapsed(firstSgRow, true);
					}

				}
				lastRow = record;
				// excelSheet.groupRow(firstRow, lastRow);
				// excelSheet.setRowGroupCollapsed(firstRow, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 8));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Balance Sheet");
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

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("OMEGA Balance");
			Cell cell41 = row.createCell(5);
			cell41.setCellStyle(my_style1);
			cell41.setCellValue("LMES Balance");
			Cell cell42 = row.createCell(6);
			cell42.setCellStyle(my_style1);
			cell42.setCellValue("LMOIS CBSE Balance");
			Cell cell43 = row.createCell(7);
			cell43.setCellStyle(my_style1);
			cell43.setCellValue("LMOIS CIS Balance");
			Cell cell45 = row.createCell(8);
			cell45.setCellStyle(my_style1);
			cell45.setCellValue("LMOIS MONT Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<BalanceSheetBean> lBalanceSheetList, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_styleTotal) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
		int lastRow = 0;
		try {

			for (BalanceSheetBean objBalanceSheetBean : lBalanceSheetList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sGroupHead = objBalanceSheetBean.getGroupHeadCode() + "-" + objBalanceSheetBean.getGroupHeadName();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_styleTotal);
				cell1.setCellValue(checkNullValue(sGroupHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_styleTotal);
				cell4.setCellValue(objBalanceSheetBean.getC0008_amount());
				Cell cell41 = row.createCell(5);
				cell41.setCellStyle(my_styleTotal);
				cell41.setCellValue(objBalanceSheetBean.getC0009_amount());
				Cell cell42 = row.createCell(6);
				cell42.setCellStyle(my_styleTotal);
				cell42.setCellValue(objBalanceSheetBean.getC0010_amount());
				Cell cell43 = row.createCell(7);
				cell43.setCellStyle(my_styleTotal);
				cell43.setCellValue(objBalanceSheetBean.getC0011_amount());
				Cell cell444 = row.createCell(8);
				cell444.setCellStyle(my_styleTotal);
				cell444.setCellValue(objBalanceSheetBean.getC0012_amount());
				firstRow = record;

				if (objBalanceSheetBean.getlSubGroupLevelList().size() > 0) {
					for (BalanceSheetBean objBalanceSheetSGBean : objBalanceSheetBean.getlSubGroupLevelList()) {
						Row rowsg = excelSheet.createRow((short) record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style2);
						cellsg0.setCellValue(sno++);

						String sSubGroupCode = objBalanceSheetSGBean.getGroupHeadCode() + "-" + objBalanceSheetSGBean.getGroupHeadName();
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_styleTotal);
						cellsg2.setCellValue(checkNullValue(sSubGroupCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_styleTotal);
						cellsg4.setCellValue(objBalanceSheetSGBean.getC0008_amount());

						Cell cellsg41 = rowsg.createCell(5);
						cellsg41.setCellStyle(my_styleTotal);
						cellsg41.setCellValue(objBalanceSheetSGBean.getC0009_amount());

						Cell cellsg42 = rowsg.createCell(6);
						cellsg42.setCellStyle(my_styleTotal);
						cellsg42.setCellValue(objBalanceSheetSGBean.getC0010_amount());

						Cell cellsg43 = rowsg.createCell(7);
						cellsg43.setCellStyle(my_styleTotal);
						cellsg43.setCellValue(objBalanceSheetSGBean.getC0011_amount());

						Cell cellsg444 = rowsg.createCell(8);
						cellsg444.setCellStyle(my_styleTotal);
						cellsg444.setCellValue(objBalanceSheetSGBean.getC0012_amount());
						if (objBalanceSheetSGBean.getlAccountHeadLevelList().size() > 0) {
							for (BalanceSheetBean objBalanceSheetAHBean : objBalanceSheetSGBean.getlAccountHeadLevelList()) {
								firstAhRow = record;
								Row rowah = excelSheet.createRow((short) record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style2);
								cellah0.setCellValue(sno++);

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

								String sAccountHeadCode = objBalanceSheetAHBean.getGroupHeadCode() + "-" + objBalanceSheetAHBean.getGroupHeadName();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sAccountHeadCode));

								Cell cellah4 = rowah.createCell(4);
								cellah4.setCellStyle(my_style2);
								cellah4.setCellValue(objBalanceSheetAHBean.getC0008_amount());
								Cell cellah42 = rowah.createCell(5);
								cellah42.setCellStyle(my_style2);
								cellah42.setCellValue(objBalanceSheetAHBean.getC0009_amount());
								Cell cellah43 = rowah.createCell(6);
								cellah43.setCellStyle(my_style2);
								cellah43.setCellValue(objBalanceSheetAHBean.getC0010_amount());
								Cell cellah44 = rowah.createCell(7);
								cellah44.setCellStyle(my_style2);
								cellah44.setCellValue(objBalanceSheetAHBean.getC0011_amount());

								Cell cellah45 = rowah.createCell(8);
								cellah45.setCellStyle(my_style2);
								cellah45.setCellValue(objBalanceSheetAHBean.getC0012_amount());

								lastRow = record;
								// excelSheet.groupRow(firstAhRow, lastRow);
								// excelSheet.setRowGroupCollapsed(firstAhRow,
								// true);
							}
						}
						lastRow = record;
						// excelSheet.groupRow(firstSgRow, lastRow);
						// excelSheet.setRowGroupCollapsed(firstSgRow, true);
					}

				}
				lastRow = record;
				// excelSheet.groupRow(firstRow, lastRow);
				// excelSheet.setRowGroupCollapsed(firstRow, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/BalanceSheet.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/BalanceSheet.xls";
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
	public BalanceSheetBean getBalanceSheetListAssetCurrentPeriod(BalanceSheetBean objBalanceSheetBean) {
		// TODO Auto-generated method stub
		return objBalanceSheetDao.getBalanceSheetListAssetCurrentPeriod(objBalanceSheetBean);
	}

	@Override
	public BalanceSheetBean pdfExportNew(BalanceSheetBean bsreport, String exportFilesPath) {
	//	List<BalanceSheetBean> lBalanceSheetList = objBalanceSheetDao.getBalanceSheetReportList(objBalanceSheetBean);

		List<BalanceSheetBean> Listbean = new ArrayList<>();
		try {
			// ServletContext context1 = request.getServletContext();
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/BalanceSheet.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("BalanceSheet");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);
		

			
			document.open();
		//	List<BalanceSheetBean> lBalanceSheetList = objBalanceSheetDao.getBalanceSheetReportList(bsreport);

		//	Listbean = objBalanceSheetDao.getBalanceSheetList(bsreport);
			
			if (bsreport.getCompany().equalsIgnoreCase("ALL")) {
				Listbean = objBalanceSheetDao.getBalanceSheetReportList(bsreport);
			} else {
				Listbean = objBalanceSheetDao.getBalanceSheetReportList1(bsreport);
			}
			
			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD, new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph("Balance Sheet \n",bfBold123);
			paragraphmain1 = new Paragraph("\n",bfBold123);
			paragraphmain.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphmain3);
			document.add(paragraphmain);
			document.add(paragraphmain1);
//			
			
			
			PdfPTable table = new PdfPTable(1);
			table.getDefaultCell().setBorder(0);
			Font bfBold12 = new Font(FontFamily.HELVETICA, 8,  Font.BOLD, new BaseColor(0, 0, 0)); 
			Font bf12 = new Font(FontFamily.HELVETICA, 8); 
			 
			   table = new PdfPTable(2);
			   table.getDefaultCell().setBorder(0);
			    table.setWidthPercentage(100);
				Font tableFont = FontFactory.getFont("Helvetica", 10, Font.NORMAL);

			

				table.addCell("\n");
				table.addCell("\n");
				table.addCell("\n");
			    
			    

				  DecimalFormat df = new DecimalFormat("0.00");

				   document.add(table);
			    

				   //specify column widths
				   float[] columnWidths = {5f, 5f, 6f, 4f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				 
				   //insert column headings
				   insertCell(table1, "GROUP HEAD", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "SUB GROUP ACCOUNT", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "ACCOUNT HEAD", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "BALANCE", Element.ALIGN_LEFT, 1, bfBold12);				  
				  

				   table1.setHeaderRows(1);
				 
				   
				   
				   
				   
				   
				   //insert an empty row
				  /* insertCell(table1, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table1, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);*/
				   double orderTotal, total = 0;
				    
				   //just some random data to fill 
		//		   for(BalanceSheetBean detail : Listbean){
					   int record = 3, sno = 1;
						int firstRow = 0, firstSgRow = 0, firstAhRow = 0;
						int lastRow = 0;
						

							/* for(BalanceSheetBean detail : Listbean) { 
				 
					   BaseColor color = BaseColor.BLACK;
					   if (detail.getGroupHeadCode()==null)
						   detail.setGroupHeadCode("");
					   if (detail.getGroupHeadName()==null)
						   detail.setGroupHeadName("");
					   if (detail.getGroupHeadType()==null)
						   detail.setGroupHeadType("");					   					 					   					  						  					 
					   
					   insertCell(table1, "" +detail.getGroupHeadCode() + "-" + detail.getGroupHeadName()+"" , Element.ALIGN_CENTER,color, 1, bf12);
				   insertCell(table1, "" +detail.getGroupHeadType()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getGroupHeadType()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getAmount()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					  
					   
				     
				   }*/
						
						
						
						for (BalanceSheetBean detail : Listbean) {
							   BaseColor color = BaseColor.BLACK;

							   insertCell(table1, "" +detail.getGroupHeadCode() + "-" + detail.getGroupHeadName()+"" , Element.ALIGN_CENTER,color, 1, bf12);
							   insertCell(table1, "" + "" , Element.ALIGN_CENTER,color, 1, bf12);
								   insertCell(table1, ""+"" , Element.ALIGN_CENTER,color, 1, bf12);
								   insertCell(table1, "" +df.format(detail.getAmount())+"" , Element.ALIGN_RIGHT,color, 1, bf12);
							
							if (detail.getlSubGroupLevelList().size() > 0) {
								for (BalanceSheetBean objBalanceSheetSGBean : detail.getlSubGroupLevelList()) {
									   insertCell(table1, ""+"" , Element.ALIGN_CENTER,color, 1, bf12);
										insertCell(table1, "" +objBalanceSheetSGBean.getGroupHeadCode() + "-" + objBalanceSheetSGBean.getGroupHeadName()+"" , Element.ALIGN_CENTER,color, 1, bf12);
										   insertCell(table1, ""+"" , Element.ALIGN_CENTER,color, 1, bf12);
										   insertCell(table1, "" +df.format(objBalanceSheetSGBean.getBalance())+"" , Element.ALIGN_RIGHT,color, 1, bf12);

											
									
									if (objBalanceSheetSGBean.getlAccountHeadLevelList().size() > 0) {
										for (BalanceSheetBean objBalanceSheetAHBean : objBalanceSheetSGBean.getlAccountHeadLevelList()) {
											
											   insertCell(table1, ""+"" , Element.ALIGN_CENTER,color, 1, bf12);
												   insertCell(table1, ""+"" , Element.ALIGN_CENTER,color, 1, bf12);
													 insertCell(table1, "" +objBalanceSheetAHBean.getGroupHeadCode() + "-" + objBalanceSheetAHBean.getGroupHeadName()+"" , Element.ALIGN_CENTER,color, 1, bf12);

												   insertCell(table1, "" +df.format(objBalanceSheetAHBean.getBalance())+"" , Element.ALIGN_RIGHT,color, 1, bf12);
											
										}
									}

								}

							}
							
						}
				   
				/*   insertCell(table1, "Total", Element.ALIGN_RIGHT, 6, bfBold12);
				   insertCell(table1, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);*/
				  
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


	         bsreport.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bsreport;
	
	}
	
	
	
	
	
	
	private void insertCell(PdfPTable table, String text, int align,BaseColor color, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), (com.itextpdf.text.Font) font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  cell.setBorderColor(color);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	
	 private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);

	}
}
