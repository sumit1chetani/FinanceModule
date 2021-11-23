package com.dci.reports.quotationsummary;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationsummaryServiceImpl implements QuotationsummaryService {
	
	@Autowired
	QuotationsummaryDAO quotationsummaryDAO;

	
	@Override
	public List<QuotationsummaryBean> getDropDown() {
		
		return quotationsummaryDAO.getDropDown();
	}
	
	
	@Override
	public List<QuotationsummaryBean> searchInvoiceDtl(QuotationsummaryBean objQuotationsummaryBean) throws Exception {
		
		return quotationsummaryDAO.searchInvoiceDtl(objQuotationsummaryBean);
	}


	@Override
	public List<QuotationsummaryBean> getFeeList(QuotationsummaryBean objQuotationsummaryBean) {
		return quotationsummaryDAO.getFeeList(objQuotationsummaryBean);
		
	}
		

	@Override
	public void excellExport(QuotationsummaryResultBean objQuotationsummaryResultBean , QuotationsummaryBean objQuotationsummaryBean,
			String pdfFile) {
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
			XSSFSheet excelSheet = workbook.createSheet("Quotation  REPORT");

			// set main header
			setExcelMainHeader(excelSheet, my_style, objQuotationsummaryBean, my_style4);
			// set header
			setExcelHeader(excelSheet, my_style5);

			// set Data
			setExcelRows(workbook, excelSheet, objQuotationsummaryResultBean, my_style2, my_style3, my_style4, my_style5, my_style6,
					my_style7, my_style8);

			// export excell
			writeExcel(workbook, pdfFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, QuotationsummaryResultBean objQuotationsummaryResultBean,
			XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5,
			XSSFCellStyle my_style6, XSSFCellStyle my_style7, XSSFCellStyle my_style8) {
		int record = 2, sno = 1;
		try {

			for (QuotationsummaryBean objQuotationsummaryBean : objQuotationsummaryResultBean.getSearchList()) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				/*
				 * cell1.setCellStyle(my_style4);
				 * cell1.setCellValue(sno++);manifestBeanobj cell1 =
				 * row1.createCell((short) 1);
				 */

				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getBookingNo());

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getCustomer());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getPol());


				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getPodId());
				
				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getQuotationNo());
				
	
				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getBookingDate());
				
				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getCurrencyCode());
				
				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getVessel());
				
				
				cell1 = row1.createCell((short) 8);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(objQuotationsummaryBean.getVoyage());

				/*
				 * for (int i = 0; i < 11; i++) { if (i == 4 || i == 7 || i == 9
				 * | i == 10) { excelSheet.autoSizeColumn(i); } }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeExcel(XSSFWorkbook myWorkBook, String filePath) {
		String l_str_file_out = filePath + "/Quotation.xlsx";
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

	public void setMergingStyle(Row row, XSSFCellStyle cellStyle, int start, int end) {
		for (int i = start; i <= end; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
		}

	}

	private void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row1 = excelSheet.createRow((short) 1);
			excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);


			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Booking Num");
			excelSheet.setColumnWidth(0, (short) ((30 * 7) / ((double) 1 / 20)));


			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Customer");
			excelSheet.setColumnWidth(2, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Pol");
			excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Pod");
			excelSheet.setColumnWidth(4, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Quotation No");
			excelSheet.setColumnWidth(5, (short) ((30 * 7) / ((double) 1 / 20)));
		
			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Booking date");
			excelSheet.setColumnWidth(7, (short) ((30 * 7) / ((double) 1 / 20)));
		
			
			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Currency code");
			excelSheet.setColumnWidth(8, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 7);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Vessel");
			excelSheet.setColumnWidth(9, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 8);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Voyage");
			excelSheet.setColumnWidth(10, (short) ((30 * 7) / ((double) 1 / 20)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style,
			QuotationsummaryBean objQuotationsummaryBean, XSSFCellStyle my_style4) {
		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row (0-based)
															
				0, // last row (0-based)
				0, // first column (0-based)
				6 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Quotation Summary");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 6);
	}

}
