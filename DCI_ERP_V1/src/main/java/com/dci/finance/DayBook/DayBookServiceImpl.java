package com.dci.finance.DayBook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.trialBalance.TrialBalanceBean;
import com.dci.tenant.finance.trialBalance.TrialBalanceDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import jxl.write.WriteException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DayBookServiceImpl implements DayBookService {

	@Autowired
	DayBookDao objGeneralLedgerDao;

	@Autowired
	TrialBalanceDAO objTrialBalanceDao;
	@Resource
	private DataSource dataSource;

	@Override
	public List<DayBookBean> getGeneralLedgerReport(DayBookBean objGeneralLedgerBean) {
		return objGeneralLedgerDao.getGeneralLedgerReport(objGeneralLedgerBean);
	}

	@Override
	public List<DayBookBean> getGeneralLedgerAHLevel(DayBookBean objGeneralLedgerBean) {
		return objGeneralLedgerDao.getGeneralLedgerAHLevel(objGeneralLedgerBean);
	}

	@Override
	public List<DayBookBean> getGeneralTransaction(DayBookBean objGeneralLedgerBean) {
		return objGeneralLedgerDao.getGeneralTransaction(objGeneralLedgerBean);
	}

	@Override
	public List<DayBookBean> getGLTransactionLevel(DayBookBean objGeneralLedgerBean) {
		return objGeneralLedgerDao.getGLTransactionLevel(objGeneralLedgerBean);
	}

	@Override
	public List<SelectivityBean> getGroupHeadList() {
		return objGeneralLedgerDao.getGroupHeadList();
	}

	@Override
	public List<SelectivityBean> mainaccountList() {
		return objGeneralLedgerDao.mainaccountList();
	}

	@Override
	public DayBookBean getJournalVoucherforPrint(String voyage) {
		return objGeneralLedgerDao.getJournalVoucherforPrint(voyage);
	}

	// account head
	@Override
	public boolean exportGeneralLedgerExcel(String sFilePath, DayBookBean objGeneralLedgerBean) {
		boolean isSuccess = false;

		List<DayBookBean> lGeneralLedgerList = objGeneralLedgerDao.getConsolidatedGeneralLedgerList(objGeneralLedgerBean);
		try {

			// Blank workbook
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			workbook.setCompressTempFiles(true);

			// HSSFWorkbook workbook = new HSSFWorkbook();
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
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight((short) Font.BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
			my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight((short) Font.BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = (XSSFCellStyle) workbook.createCellStyle();
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		//	my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style3 = (XSSFCellStyle) workbook.createCellStyle();
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		    my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style_green = (XSSFCellStyle) workbook.createCellStyle();
			my_style_green.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_green.setAlignment(my_style.ALIGN_LEFT);
			my_style_green.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			org.apache.poi.ss.usermodel.Font font_green = workbook.createFont();
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight((short) Font.BOLD);
			my_style_green.setFont(font_green);

			XSSFCellStyle my_style_green_right_align = (XSSFCellStyle) workbook.createCellStyle();
			my_style_green_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setAlignment(my_style.ALIGN_RIGHT);
			my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight((short) Font.BOLD);
			my_style_green_right_align.setFont(font_green);

			XSSFCellStyle my_style_red = (XSSFCellStyle) workbook.createCellStyle();
			my_style_red.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_red.setAlignment(my_style.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font font_red = workbook.createFont();
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight((short) Font.BOLD);
			my_style_red.setFont(font_red);

			XSSFCellStyle my_style_red_right_align = (XSSFCellStyle) workbook.createCellStyle();
			my_style_red_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setAlignment(my_style.ALIGN_RIGHT);
			my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight((short) Font.BOLD);
			my_style_red_right_align.setFont(font_red);

			XSSFCellStyle my_style_narration = (XSSFCellStyle) workbook.createCellStyle();
			my_style_narration.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style_narration.setWrapText(true);
			my_style_narration.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			CellStyle cellDateStyle = workbook.createCellStyle();
			CreationHelper createHelper = workbook.getCreationHelper();
			cellDateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));
			cellDateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			// Create a blank sheet
			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("DAY BOOK");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// HSSFSheet excelSheet = workbook.createSheet("General Ledger");

			// set main header
			setExcelMainHeaderByAccountHead(excelSheet, my_style, objGeneralLedgerBean);

			// set header
			setExcelHeaderByAccountHead(excelSheet, my_style1);

			for (int i = 0; i < 21; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// set Data
			setExcelRowsByAccountHead(workbook, excelSheet, lGeneralLedgerList, my_style1, my_style2, my_style3, cellDateStyle);

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);
			if (lGeneralLedgerList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}
		} catch (Exception e) {
		}
		return isSuccess;
	}

	public void setExcelMainHeaderByAccountHead(SXSSFSheet excelSheet, XSSFCellStyle my_style, DayBookBean objGeneralLedgerBean ) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 8));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 8));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue( objGeneralLedgerBean.getFromDate() +" TO " + objGeneralLedgerBean.getToDate());
		cell2.setCellStyle(my_style);
		
		Row row3 = excelSheet.createRow((short)3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 8));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue("DAY BOOK");
		cell3.setCellStyle(my_style);
	}

	public void setExcelHeaderByAccountHead(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Voucher Date");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Voucher No");
			
			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Fund Type");
			
			Cell cell26 = row.createCell(4);
			cell26.setCellStyle(my_style1);
			cell26.setCellValue("Created By");

			/*Cell cell3 = row.createCell(4);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Created Date");
*/
		/*	Cell cell4 = row.createCell(5);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Part Inv No");
*/
			Cell cell42 = row.createCell(5);
			cell42.setCellStyle(my_style1);
			cell42.setCellValue("Account Head  Code");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Account Head Name");

/*			Cell cell7 = row.createCell(8);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Narration");
*/
			Cell cell73 = row.createCell(7);
			cell73.setCellStyle(my_style1);
			cell73.setCellValue("Credit");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Debit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsByAccountHead(SXSSFWorkbook workbook, SXSSFSheet excelSheet, List<DayBookBean> lGeneralLedgerList, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, CellStyle cellDateStyle) {
		int record = 5, sno = 1;

		double dTotalTCDebitAmt = 0.0, dTotalTCCreditAmt = 0.0;
		double dTotalBCDebitAmt = 0.0, dTotalBCCreditAmt = 0.0;
		try {

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle2 = workbook.createCellStyle();
			dateCellStyle2.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateCellStyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			for (DayBookBean objGeneralLedgerBean : lGeneralLedgerList) {
				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objGeneralLedgerBean.getTransactionDate()));

				
				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(objGeneralLedgerBean.getTransactionNo()));

			
				
				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(objGeneralLedgerBean.getCostCenter()));

				
				
				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(checkNullValue(objGeneralLedgerBean.getCreatedBy()));

		/*		Cell cell3 = row.createCell(4);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(objGeneralLedgerBean.getCreatedDate()));*/

			/*	Cell cell4 = row.createCell(5);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(checkNullValue(objGeneralLedgerBean.getPartyInvoiceNo()));
*/
				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(checkNullValue(objGeneralLedgerBean.getAccountHeadCode()));

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(checkNullValue(objGeneralLedgerBean.getAccountHeadName()));

			/*	Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(checkNullValue(objGeneralLedgerBean.getNarration()));*/

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(objGeneralLedgerBean.getTcCredit());

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style3);
				cell8.setCellValue(objGeneralLedgerBean.getBcCredit());

				dTotalBCCreditAmt = dTotalBCCreditAmt + objGeneralLedgerBean.getBcCredit();
				dTotalTCDebitAmt = dTotalTCDebitAmt + objGeneralLedgerBean.getTcDebit();
				dTotalBCDebitAmt = dTotalBCDebitAmt + objGeneralLedgerBean.getBcDebit();
				dTotalTCCreditAmt = dTotalTCCreditAmt + objGeneralLedgerBean.getTcCredit();
			}

			// Create total row
			Row rowTotal = excelSheet.createRow(record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style1);
			rowTotal.createCell(1).setCellStyle(my_style1);
			rowTotal.createCell(2).setCellStyle(my_style1);
			/* rowTotal.createCell(3).setCellStyle(my_style1); */
			rowTotal.createCell(3).setCellStyle(my_style1);
			rowTotal.createCell(4).setCellStyle(my_style1);
			rowTotal.createCell(5).setCellStyle(my_style1);
			rowTotal.createCell(6).setCellStyle(my_style1);
			rowTotal.createCell(7).setCellStyle(my_style1);
			rowTotal.createCell(8).setCellStyle(my_style1);
			//rowTotal.createCell(9).setCellStyle(my_style1);
			/*
			 * rowTotal.createCell(10).setCellStyle(my_style1);
			 * rowTotal.createCell(11).setCellStyle(my_style1);
			 * rowTotal.createCell(12).setCellStyle(my_style1);
			 * rowTotal.createCell(13).setCellStyle(my_style1);
			 * rowTotal.createCell(14).setCellStyle(my_style1);
			 */
			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style1);
			cellah1.setCellValue("Total");
			/*
			 * Cell cellahTcdbt13 = rowTotal.createCell(12);
			 * cellahTcdbt13.setCellStyle(my_style1);
			 * cellahTcdbt13.setCellValue(dTotalTCDebitAmt);
			 * 
			 * Cell cellahBcdbt14 = rowTotal.createCell(13);
			 * cellahBcdbt14.setCellStyle(my_style1);
			 * cellahBcdbt14.setCellValue(dTotalBCDebitAmt);
			 */

			Cell cellahTcCrdt15 = rowTotal.createCell(7);
			cellahTcCrdt15.setCellStyle(my_style1);
			cellahTcCrdt15.setCellValue(dTotalTCCreditAmt);

			Cell cellahBcCrdt16 = rowTotal.createCell(8);
			cellahBcCrdt16.setCellStyle(my_style1);
			cellahBcCrdt16.setCellValue(dTotalBCCreditAmt);

			/*
			 * rowTotal.createCell(16).setCellStyle(my_style1);
			 * rowTotal.createCell(17).setCellStyle(my_style1);
			 * rowTotal.createCell(18).setCellStyle(my_style1);
			 * rowTotal.createCell(19).setCellStyle(my_style1);
			 * rowTotal.createCell(20).setCellStyle(my_style1);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 10));
		Cell cell = row.createCell(0);
		cell.setCellValue("DAY BOOK");
		cell.setCellStyle(my_style);
	}

	public void setExcelMainHeaderSubLedger(SXSSFSheet excelSheet, XSSFCellStyle my_style, DayBookBean objGeneralLedgerBean, String acctHead) {
		if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {

			Row row = excelSheet.createRow(0);
			excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 6));
			Cell cell = row.createCell(0);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String query = objGeneralLedgerDao.getcompanycode(objGeneralLedgerBean);
			String header = query;
			// String header=query;
			cell.setCellValue(header);
			cell.setCellStyle(my_style);

		} else {
			Row row = excelSheet.createRow(0);
			excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
			Cell cell = row.createCell(0);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			String query = objGeneralLedgerDao.getcompanycode(objGeneralLedgerBean);
			String header = query;
			// String header=query;
			cell.setCellValue(header);
			cell.setCellStyle(my_style);
		}
	}

	public void setExcelMainHeaderSubLedgerSubgroup(SXSSFSheet excelSheet, XSSFCellStyle my_style, DayBookBean objGeneralLedgerBean, String acctHead) {

		if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {

			Row row = excelSheet.createRow(2);
			excelSheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 6));
			String query = "";
			Cell cell = row.createCell(0);

			if (!objGeneralLedgerBean.getSubAccountCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getsubaccountname(objGeneralLedgerBean);

			} else if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getaccountname(objGeneralLedgerBean);

			} else if (!objGeneralLedgerBean.getSubGroupCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getsubgroup(objGeneralLedgerBean);
			}

			String header = query;
			cell.setCellValue(header);
			cell.setCellStyle(my_style);
		} else {
			Row row = excelSheet.createRow(2);
			excelSheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 7));
			String query = "";
			Cell cell = row.createCell(0);
			if (!objGeneralLedgerBean.getSubAccountCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getsubaccountname(objGeneralLedgerBean);

			} else if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getaccountname(objGeneralLedgerBean);

			}

			else if (!objGeneralLedgerBean.getSubGroupCode().equalsIgnoreCase("")) {
				query = objGeneralLedgerDao.getsubgroup(objGeneralLedgerBean);
			}

			String header = query;
			cell.setCellValue(header);
			cell.setCellStyle(my_style);
		}
	}

	public void setExcelHeader(HSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow(2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Company");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Main Account code");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Main Account name");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Sub Account code");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Sub Account name");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Transaction NO");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Transaction Date");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Narration");

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Currency");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Exchange Rate");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("TC Debit");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("BC Debit");

			Cell cell13 = row.createCell(13);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("TC Credit");

			Cell cell14 = row.createCell(14);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue("BC Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(SXSSFWorkbook workbook, HSSFSheet excelSheet, List<DayBookBean> lGeneralLedgerList, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3) {
		int record = 3, sno = 1;

		double dTotalTCDebitAmt = 0.0, dTotalTCCreditAmt = 0.0;
		double dTotalBCDebitAmt = 0.0, dTotalBCCreditAmt = 0.0;
		try {

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle2 = workbook.createCellStyle();
			dateCellStyle2.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateCellStyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			for (DayBookBean objGeneralLedgerBean : lGeneralLedgerList) {
				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 14; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objGeneralLedgerBean.getCompanyName()));

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(objGeneralLedgerBean.getAccountHeadCode()));

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(objGeneralLedgerBean.getAccountHeadName()));

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(checkNullValue(objGeneralLedgerBean.getSubAccountCode()));

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(checkNullValue(objGeneralLedgerBean.getSubAccountName()));

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style2);
				cell6.setCellValue(checkNullValue(objGeneralLedgerBean.getTransactionNo()));

				/*
				 * Cell cell7 = row.createCell(7); cell7.setCellStyle(my_style2);
				 * cell7.setCellValue(checkNullValue
				 * (objGeneralLedgerBean.getTransactionDate()));
				 */

				DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Date date = format.parse(checkNullValue(objGeneralLedgerBean.getTransactionDate()));
				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(dateCellStyle2);
				cell7.setCellValue(date);

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(checkNullValue(objGeneralLedgerBean.getNarration()));

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style2);
				cell9.setCellValue(checkNullValue(objGeneralLedgerBean.getCurrency()));

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style2);
				cell10.setCellValue(objGeneralLedgerBean.getExchangeRate());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style2);
				cell11.setCellValue(objGeneralLedgerBean.getTcDebit());
				dTotalTCDebitAmt = dTotalTCDebitAmt + objGeneralLedgerBean.getTcDebit();

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style2);
				cell12.setCellValue(objGeneralLedgerBean.getBcDebit());
				dTotalBCDebitAmt = dTotalBCDebitAmt + objGeneralLedgerBean.getBcDebit();

				Cell cell13 = row.createCell(13);
				cell13.setCellStyle(my_style2);
				cell13.setCellValue(objGeneralLedgerBean.getTcCredit());
				dTotalTCCreditAmt = dTotalTCCreditAmt + objGeneralLedgerBean.getTcCredit();

				Cell cell14 = row.createCell(14);
				cell14.setCellStyle(my_style2);
				cell14.setCellValue(objGeneralLedgerBean.getBcCredit());
				dTotalBCCreditAmt = dTotalBCCreditAmt + objGeneralLedgerBean.getBcCredit();

			}

			// Create total row
			Row rowTotal = excelSheet.createRow(record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style1);
			rowTotal.createCell(1).setCellStyle(my_style1);
			rowTotal.createCell(2).setCellStyle(my_style1);
			rowTotal.createCell(3).setCellStyle(my_style1);
			rowTotal.createCell(4).setCellStyle(my_style1);
			rowTotal.createCell(5).setCellStyle(my_style1);
			rowTotal.createCell(6).setCellStyle(my_style1);
			rowTotal.createCell(7).setCellStyle(my_style1);
			rowTotal.createCell(8).setCellStyle(my_style1);
			rowTotal.createCell(9).setCellStyle(my_style1);
			rowTotal.createCell(10).setCellStyle(my_style1);
			rowTotal.createCell(11).setCellStyle(my_style1);
			rowTotal.createCell(12).setCellStyle(my_style1);
			rowTotal.createCell(13).setCellStyle(my_style1);
			rowTotal.createCell(14).setCellStyle(my_style1);

			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style1);
			cellah1.setCellValue("Total");

			Cell cellahTcdbt12 = rowTotal.createCell(11);
			cellahTcdbt12.setCellStyle(my_style1);
			cellahTcdbt12.setCellValue(dTotalTCDebitAmt);

			Cell cellahBcdbt12 = rowTotal.createCell(12);
			cellahBcdbt12.setCellStyle(my_style1);
			cellahBcdbt12.setCellValue(dTotalBCDebitAmt);

			Cell cellahTcCrdt13 = rowTotal.createCell(13);
			cellahTcCrdt13.setCellStyle(my_style1);
			cellahTcCrdt13.setCellValue(dTotalTCCreditAmt);

			Cell cellahBcCrdt13 = rowTotal.createCell(14);
			cellahBcCrdt13.setCellStyle(my_style1);
			cellahBcCrdt13.setCellValue(dTotalBCCreditAmt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean exportGeneralLedgerExcelSecondary(String sFilePath, DayBookBean objGeneralLedgerBean) {

		List<DayBookBean> lGeneralLegerList = objGeneralLedgerDao.getGeneralLedgerList(objGeneralLedgerBean);
		try {
			// Blank workbook
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			workbook.setCompressTempFiles(true);

			// HSSFWorkbook workbook = new HSSFWorkbook();
			XSSFCellStyle my_style = (XSSFCellStyle) workbook.createCellStyle();
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight((short) Font.BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
			my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight((short) Font.BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = (XSSFCellStyle) workbook.createCellStyle();
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = (XSSFCellStyle) workbook.createCellStyle();
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

			XSSFCellStyle my_style_green = (XSSFCellStyle) workbook.createCellStyle();
			my_style_green.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_green.setAlignment(my_style.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font font_green = workbook.createFont();
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight((short) Font.BOLD);
			my_style_green.setFont(font_green);

			XSSFCellStyle my_style_green_right_align = (XSSFCellStyle) workbook.createCellStyle();
			my_style_green_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setAlignment(my_style.ALIGN_RIGHT);
			my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight((short) Font.BOLD);
			my_style_green_right_align.setFont(font_green);

			XSSFCellStyle my_style_red = (XSSFCellStyle) workbook.createCellStyle();
			my_style_red.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_red.setAlignment(my_style.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font font_red = workbook.createFont();
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight((short) Font.BOLD);
			my_style_red.setFont(font_red);

			XSSFCellStyle my_style_red_right_align = (XSSFCellStyle) workbook.createCellStyle();
			my_style_red_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setAlignment(my_style.ALIGN_RIGHT);
			my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			font_red.setColor(HSSFColor.RED.index);
			((org.apache.poi.ss.usermodel.Font) font_red).setBoldweight((short) Font.BOLD);
			my_style_red_right_align.setFont(font_red);

			XSSFCellStyle my_style_narration = (XSSFCellStyle) workbook.createCellStyle();
			my_style_narration.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style_narration.setWrapText(true);

			// Create a blank sheet
			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("DAY BOOK");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// HSSFSheet excelSheet = workbook.createSheet("General Ledger");

			// set main header
			setExcelMainHeaderSecondary(excelSheet, my_style);

			// set header
			setExcelHeaderSecondary(excelSheet, my_style1);

			// set Data
			setExcelRowsSecondary(workbook, excelSheet, lGeneralLegerList, my_style1, my_style2, my_style3, my_style_green, my_style_green_right_align, my_style_red, my_style_red_right_align, my_style_narration);

			for (int i = 0; i < 9; i++) {
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

	public void setExcelMainHeaderSecondary(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 10));
		Cell cell = row.createCell(0);
		cell.setCellValue("DAY BOOK");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeaderSecondary(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow(2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Ledger No");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Ledger Sequence");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Transaction No");

			/*
			 * Cell cell3 = row.createCell(3); cell3.setCellStyle(my_style1);
			 * cell3.setCellValue("Intra Company Voucher No");
			 */

			Cell cell4 = row.createCell(3);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Transaction Dt");

			Cell cell5 = row.createCell(4);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Sub Account");

			Cell cell6 = row.createCell(5);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Currency");

			Cell cell7 = row.createCell(6);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Exchange Rate");

			Cell cell8 = row.createCell(7);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Narration");

			Cell cell9 = row.createCell(8);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Opening Bal(USD)");

			Cell cel24 = row.createCell(9);
			cel24.setCellStyle(my_style1);
			cel24.setCellValue("Opening Bal(Local)");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("TC Debit");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("TC Credit");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("BC Debit");

			Cell cell13 = row.createCell(13);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("BC Credit");

			Cell cell14 = row.createCell(14);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue("Closing Bal(USD)");

			Cell cell25 = row.createCell(15);
			cell25.setCellStyle(my_style1);
			cell25.setCellValue("Closing Bal(Local)");

			Cell cell15 = row.createCell(16);
			cell15.setCellStyle(my_style1);
			cell15.setCellValue("Vessel");

			Cell cell16 = row.createCell(17);
			cell16.setCellStyle(my_style1);
			cell16.setCellValue("Voyage");

			Cell cell17 = row.createCell(18);
			cell17.setCellStyle(my_style1);
			cell17.setCellValue("Service");

			Cell cell18 = row.createCell(19);
			cell18.setCellStyle(my_style1);
			cell18.setCellValue("POL");

			Cell cell19 = row.createCell(20);
			cell19.setCellStyle(my_style1);
			cell19.setCellValue("POD");

			Cell cell20 = row.createCell(21);
			cell20.setCellStyle(my_style1);
			cell20.setCellValue("Posted By");

			Cell cell21 = row.createCell(22);
			cell21.setCellStyle(my_style1);
			cell21.setCellValue("Party Inv No");

			Cell cell22 = row.createCell(23);
			cell22.setCellStyle(my_style1);
			cell22.setCellValue("Status");

			Cell cell23 = row.createCell(24);
			cell23.setCellStyle(my_style1);
			cell23.setCellValue("Allocated To");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsSecondary(SXSSFWorkbook workbook, SXSSFSheet excelSheet, List<DayBookBean> lGeneralLedgerList, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style_green, XSSFCellStyle my_style_green_right_align, XSSFCellStyle my_style_red, XSSFCellStyle my_style_red_right_align, XSSFCellStyle my_style_narration) {
		int record = 3, sno = 1;
		try {

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle2 = workbook.createCellStyle();
			dateCellStyle2.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateCellStyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			for (DayBookBean objGeneralLedgerBean : lGeneralLedgerList) {
				Row rowah = excelSheet.createRow(record++);
				rowah.setHeight((short) 350);

				String sOpening_Balance = objGeneralLedgerBean.getAccountHeadCode() + "-" + objGeneralLedgerBean.getAccountHeadName();

				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 0, 5));
				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 3, 8));

				Cell cellop = rowah.createCell(0);
				cellop.setCellValue(sOpening_Balance);
				cellop.setCellStyle(my_style_green);

				Cell cellop1 = rowah.createCell(5);
				cellop1.setCellValue("Opening Bal(USD) ");
				cellop1.setCellStyle(my_style_green);

				// rowah.createCell(7).setCellStyle(my_style2);

				Cell cellop7 = rowah.createCell(8);
				cellop7.setCellValue(objGeneralLedgerBean.getOpeningBalance());
				cellop7.setCellStyle(my_style_green_right_align);

				Cell cellop24 = rowah.createCell(9);
				cellop24.setCellValue(objGeneralLedgerBean.getOpeningBalanceTC());
				cellop24.setCellStyle(my_style_green_right_align);

				// rowah.createCell(1).setCellStyle(my_style2);
				// rowah.createCell(2).setCellStyle(my_style2);
				// rowah.createCell(3).setCellStyle(my_style2);
				// rowah.createCell(4).setCellStyle(my_style2);
				// rowah.createCell(5).setCellStyle(my_style2);
				// rowah.createCell(6).setCellStyle(my_style2);
				// rowah.createCell(7).setCellStyle(my_style2);
				// rowah.createCell(8).setCellStyle(my_style2);
				// rowah.createCell(9).setCellStyle(my_style2);
				// rowah.createCell(10).setCellStyle(my_style2);
				rowah.createCell(11).setCellStyle(my_style2);
				rowah.createCell(12).setCellStyle(my_style2);
				rowah.createCell(13).setCellStyle(my_style2);
				rowah.createCell(14).setCellStyle(my_style2);
				rowah.createCell(15).setCellStyle(my_style2);
				rowah.createCell(16).setCellStyle(my_style2);
				rowah.createCell(17).setCellStyle(my_style2);
				rowah.createCell(18).setCellStyle(my_style2);
				rowah.createCell(19).setCellStyle(my_style2);
				rowah.createCell(20).setCellStyle(my_style2);
				rowah.createCell(21).setCellStyle(my_style2);
				rowah.createCell(22).setCellStyle(my_style2);
				rowah.createCell(23).setCellStyle(my_style2);

				/*
				 * Cell cell1 = rowah.createCell(1); cell1.setCellStyle(my_style2);
				 * cell1.setCellValue(objGeneralLedgerBean .getAccountHeadCode());
				 * 
				 * Cell cell2 = rowah.createCell(2); cell2.setCellStyle(my_style2);
				 * cell2.setCellValue(objGeneralLedgerBean .getAccountHeadName());
				 * 
				 * Cell cell3 = rowah.createCell(3); cell3.setCellStyle(my_style2);
				 * cell3.setCellValue("Opening Bal");
				 * 
				 * Cell cell4 = rowah.createCell(4); cell4.setCellStyle(my_style2);
				 * cell4.setCellValue(objGeneralLedgerBean.getOpeningBalance());
				 */

				if (objGeneralLedgerBean.getlTransactionList().size() > 0) {
					for (DayBookBean objGeneralLedgerTransBean : objGeneralLedgerBean.getlTransactionList()) {
						Row rowsg = excelSheet.createRow(record++);
						rowsg.setHeight((short) 350);

						String sSubAccount = "";
						if (String.valueOf(objGeneralLedgerTransBean.getSubAccountCode()) == null || String.valueOf(objGeneralLedgerTransBean.getSubAccountCode()).equalsIgnoreCase("null") || String.valueOf(objGeneralLedgerTransBean.getSubAccountCode()).equalsIgnoreCase(""))
							sSubAccount = "";
						else
							sSubAccount = objGeneralLedgerTransBean.getSubAccountCode() + "-" + objGeneralLedgerTransBean.getSubAccountName();

						Cell cellah0 = rowsg.createCell(0);
						cellah0.setCellStyle(my_style2);
						// cellah0.setCellValue(checkNullValue(objGeneralLedgerTransBean.getLedgerNo().toString()));
						if (String.valueOf(objGeneralLedgerTransBean.getLedgerNo()) == null || String.valueOf(objGeneralLedgerTransBean.getLedgerNo()).equalsIgnoreCase("null"))
							cellah0.setCellValue("");
						else
							cellah0.setCellValue(objGeneralLedgerTransBean.getLedgerNo().toString());

						Cell cellah1 = rowsg.createCell(1);
						cellah1.setCellStyle(my_style2);
						if (String.valueOf(objGeneralLedgerTransBean.getLedgerSeq()) == null || String.valueOf(objGeneralLedgerTransBean.getLedgerSeq()).equalsIgnoreCase("null"))
							cellah1.setCellValue("");
						else
							cellah1.setCellValue(objGeneralLedgerTransBean.getLedgerSeq().toString());

						Cell cellah2 = rowsg.createCell(2);
						cellah2.setCellStyle(my_style2);
						cellah2.setCellValue(checkNullValue(objGeneralLedgerTransBean.getTransactionNo()));

						/*
						 * Cell cellah3 = rowsg.createCell(3); cellah3.setCellStyle(my_style2);
						 * cellah3.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getVoucherNo()));
						 */

						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Date date = format.parse(checkNullValue(objGeneralLedgerTransBean.getTransactionDate()));
						Cell cellah4 = rowsg.createCell(3);
						cellah4.setCellStyle(dateCellStyle2);
						cellah4.setCellValue(date);

						Cell cellah5 = rowsg.createCell(4);
						cellah5.setCellStyle(my_style2);
						cellah5.setCellValue(checkNullValue(sSubAccount));

						Cell cellah6 = rowsg.createCell(5);
						cellah6.setCellStyle(my_style2);
						cellah6.setCellValue(checkNullValue(objGeneralLedgerTransBean.getCurrency()));

						Cell cellah7 = rowsg.createCell(6);
						cellah7.setCellStyle(my_style3);
						cellah7.setCellValue(objGeneralLedgerTransBean.getExchangeRate());

						Cell cellah8 = rowsg.createCell(7);
						cellah8.setCellStyle(my_style_narration);
						cellah8.setCellValue(objGeneralLedgerTransBean.getNarration());

						Cell cellah9 = rowsg.createCell(8);
						cellah9.setCellStyle(my_style3);

						Cell cellah24 = rowsg.createCell(9);
						cellah24.setCellStyle(my_style3);

						Cell cellah10 = rowsg.createCell(10);
						cellah10.setCellStyle(my_style3);
						cellah10.setCellValue(objGeneralLedgerTransBean.getTcDebit());

						Cell cellah11 = rowsg.createCell(11);
						cellah11.setCellStyle(my_style3);
						cellah11.setCellValue(objGeneralLedgerTransBean.getTcCredit());

						Cell cellah12 = rowsg.createCell(12);
						cellah12.setCellStyle(my_style3);
						cellah12.setCellValue(objGeneralLedgerTransBean.getBcDebit());

						Cell cellah13 = rowsg.createCell(13);
						cellah13.setCellStyle(my_style3);
						cellah13.setCellValue(objGeneralLedgerTransBean.getBcCredit());

						Cell cellah14 = rowsg.createCell(14);
						cellah14.setCellStyle(my_style2);

						Cell cellah25 = rowsg.createCell(15);
						cellah25.setCellStyle(my_style2);

						Cell cellah15 = rowsg.createCell(16);
						cellah15.setCellStyle(my_style2);
						cellah15.setCellValue(checkNullValue(objGeneralLedgerTransBean.getVesselCode()));

						Cell cellah16 = rowsg.createCell(17);
						cellah16.setCellStyle(my_style3);
						cellah16.setCellValue(checkNullValue(objGeneralLedgerTransBean.getVoyageCode()));

						Cell cellah17 = rowsg.createCell(18);
						cellah17.setCellStyle(my_style2);
						cellah17.setCellValue(checkNullValue(objGeneralLedgerTransBean.getSectorCode()));

						Cell cellah18 = rowsg.createCell(19);
						cellah18.setCellStyle(my_style2);
						if ((objGeneralLedgerTransBean.getPol()) == null || String.valueOf(objGeneralLedgerTransBean.getPol()).equalsIgnoreCase("null"))
							cellah18.setCellValue("");
						else
							cellah18.setCellValue(objGeneralLedgerTransBean.getPol());

						Cell cellah19 = rowsg.createCell(20);
						cellah19.setCellStyle(my_style2);
						if ((objGeneralLedgerTransBean.getPod()) == null || String.valueOf(objGeneralLedgerTransBean.getPod()).equalsIgnoreCase("null"))
							cellah19.setCellValue("");
						else
							cellah19.setCellValue(objGeneralLedgerTransBean.getPod());

						Cell cellah20 = rowsg.createCell(21);
						cellah20.setCellStyle(my_style2);
						cellah20.setCellValue(checkNullValue(objGeneralLedgerTransBean.getCreatedBy()));

						Cell cellah21 = rowsg.createCell(22);
						cellah21.setCellStyle(my_style2);
						cellah21.setCellValue(checkNullValue(objGeneralLedgerTransBean.getPartyInvoiceNo()));

						Cell cellah22 = rowsg.createCell(23);
						cellah22.setCellStyle(my_style2);
						cellah22.setCellValue(checkNullValue(objGeneralLedgerTransBean.getAllocationStatus()));

						Cell cellah23 = rowsg.createCell(24);
						cellah23.setCellStyle(my_style2);
						cellah23.setCellValue(checkNullValue(objGeneralLedgerTransBean.getAllocatedTo()));
					}

				}

				Row rowcb = excelSheet.createRow(record++);
				rowcb.setHeight((short) 350);

				String sClosing_Balance = objGeneralLedgerBean.getAccountHeadCode() + "-" + objGeneralLedgerBean.getAccountHeadName();

				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 0, 5));
				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 6, 8));

				Cell cellcb0 = rowcb.createCell(0);
				cellcb0.setCellStyle(my_style_red);
				cellcb0.setCellValue(sClosing_Balance);

				Cell cellcb1 = rowcb.createCell(5);
				cellcb1.setCellValue("Closing Bal (USD)");
				cellcb1.setCellStyle(my_style_red);

				// rowcb.createCell(1).setCellStyle(my_style2);
				// rowcb.createCell(2).setCellStyle(my_style2);
				// rowcb.createCell(3).setCellStyle(my_style2);
				// rowcb.createCell(4).setCellStyle(my_style2);
				// rowcb.createCell(5).setCellStyle(my_style2);
				// rowcb.createCell(6).setCellStyle(my_style2);
				// rowcb.createCell(7).setCellStyle(my_style2);
				// rowcb.createCell(8).setCellStyle(my_style2);
				rowcb.createCell(9).setCellStyle(my_style2);
				rowcb.createCell(10).setCellStyle(my_style2);
				rowcb.createCell(11).setCellStyle(my_style2);
				rowcb.createCell(12).setCellStyle(my_style2);
				rowcb.createCell(13).setCellStyle(my_style2);
				rowcb.createCell(14).setCellStyle(my_style2);

				Cell cellcb13 = rowcb.createCell(14);
				cellcb13.setCellValue(objGeneralLedgerBean.getClosingBalance());
				cellcb13.setCellStyle(my_style_red_right_align);

				Cell cellcb24 = rowcb.createCell(15);
				cellcb24.setCellValue(objGeneralLedgerBean.getClosingBalanceTC());
				cellcb24.setCellStyle(my_style_red_right_align);

				// rowcb.createCell(13).setCellStyle(my_style2);
				// rowcb.createCell(14).setCellStyle(my_style2);
				// rowcb.createCell(15).setCellStyle(my_style2);
				// rowcb.createCell(16).setCellStyle(my_style2);
				rowcb.createCell(17).setCellStyle(my_style2);
				rowcb.createCell(18).setCellStyle(my_style2);
				rowcb.createCell(19).setCellStyle(my_style2);
				rowcb.createCell(20).setCellStyle(my_style2);
				rowcb.createCell(21).setCellStyle(my_style2);
				rowah.createCell(22).setCellStyle(my_style2);
				rowah.createCell(23).setCellStyle(my_style2);
				/*
				 * Cell cellcb1 = rowcb.createCell(1); cellcb1.setCellStyle(my_style2);
				 * cellcb1.setCellValue(objGeneralLedgerBean .getAccountHeadCode());
				 * 
				 * Cell cellcb2 = rowcb.createCell(2); cellcb2.setCellStyle(my_style2);
				 * cellcb2.setCellValue(objGeneralLedgerBean .getAccountHeadName());
				 * 
				 * Cell cellcb3 = rowcb.createCell(3); cellcb3.setCellStyle(my_style2);
				 * cellcb3.setCellValue("Closing Bal");
				 * 
				 * Cell cellcb4 = rowcb.createCell(4); cellcb4.setCellStyle(my_style2);
				 * cellcb4.setCellValue(objGeneralLedgerBean .getClosingBalance());
				 */

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelSubLedger(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/subLedger.xlsx";

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
			url = path + "/subLedger.xlsx";
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

	/*private String writeExcel(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/DayBook.xlsx";

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
			url = path + "/DayBook.xlsx";
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
	}*/
	
	
	private String writeExcel(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/DayBook.xls";

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
			url = path + "/DayBook.xls";
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
	public List<DayBookBean> getSubLedgerReport(DayBookBean objGeneralLedgerBean) {
		return objGeneralLedgerDao.getSubLedgerReport(objGeneralLedgerBean);
	}

	// through sub ledger
	@Override
	public DayBookResultBean exportSubLedgerExcel(String exportFilesPath, DayBookBean objGeneralLedgerBean) throws IOException, WriteException {

		// TODO Auto-generated method stub
		DayBookResultBean objGeneralLedger = new DayBookResultBean();
		List<DayBookBean> lGeneralLedgerList = new ArrayList<>();
		try {

			List<DayBookBean> objGeneralLedgerOPBean = new ArrayList<>();
			objGeneralLedgerOPBean = objGeneralLedgerDao.getOpeningBalanceSub(objGeneralLedgerBean);
			// lGeneralLedgerList =
			// objGeneralLedgerDao.getSubLedgerReport1(objGeneralLedgerBean);
			String acctHead = "";
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
				org.apache.poi.ss.usermodel.Font font = workbook.createFont();
				font.setFontHeight((short) 200);
				font.setFontName("Arial");
				font.setColor(HSSFColor.YELLOW.index);
				font.setBoldweight((short) Font.BOLD);
				font.setFontHeightInPoints((short) 15);
				my_style.setFont(font);
				XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
				my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
				my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
				my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
				my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
				my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
				my_style1.setAlignment(my_style.ALIGN_CENTER);
				my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
				my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
				org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
				font1.setFontHeight((short) 200);
				font1.setFontName("Arial");
				font1.setColor(HSSFColor.BLACK.index);
				font1.setBoldweight((short) Font.BOLD);
				font1.setFontHeightInPoints((short) 10);
				my_style1.setFont(font1);
				XSSFCellStyle my_style2 = (XSSFCellStyle) workbook.createCellStyle();
				my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

				XSSFCellStyle my_style3 = (XSSFCellStyle) workbook.createCellStyle();
				my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);

				XSSFCellStyle my_style_green = (XSSFCellStyle) workbook.createCellStyle();
				my_style_green.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style_green.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style_green.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style_green.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style_green.setAlignment(my_style.ALIGN_LEFT);

				org.apache.poi.ss.usermodel.Font font_green = workbook.createFont();
				font_green.setColor(HSSFColor.GREEN.index);
				font_green.setBoldweight((short) Font.BOLD);
				my_style_green.setFont(font_green);

				XSSFCellStyle my_style_green_right_align = (XSSFCellStyle) workbook.createCellStyle();
				my_style_green_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style_green_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style_green_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style_green_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style_green_right_align.setAlignment(my_style.ALIGN_RIGHT);
				my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
				font_green.setColor(HSSFColor.GREEN.index);
				((org.apache.poi.ss.usermodel.Font) font_green).setBoldweight((short) Font.BOLD);
				my_style_green_right_align.setFont(font_green);

				XSSFCellStyle my_style_red = (XSSFCellStyle) workbook.createCellStyle();
				my_style_red.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style_red.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style_red.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style_red.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style_red.setAlignment(my_style.ALIGN_LEFT);

				org.apache.poi.ss.usermodel.Font font_red = workbook.createFont();
				font_red.setColor(HSSFColor.RED.index);
				font_red.setBoldweight((short) Font.BOLD);
				my_style_red.setFont(font_red);

				XSSFCellStyle my_style_red_right_align = (XSSFCellStyle) workbook.createCellStyle();
				my_style_red_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
				my_style_red_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
				my_style_red_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
				my_style_red_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				my_style_red_right_align.setAlignment(my_style.ALIGN_RIGHT);
				my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
				font_red.setColor(HSSFColor.RED.index);
				font_red.setBoldweight((short) Font.BOLD);
				my_style_red_right_align.setFont(font_red);

				// Create a blank sheet
				SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("Sub Ledger");
				excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
															// memory,

				// HSSFSheet excelSheet = workbook.createSheet("Sub Ledger");

				// set main header
				setExcelMainHeaderSubLedger(excelSheet, my_style, objGeneralLedgerBean, acctHead);

				// set header
				setExcelHeaderSubLedger(excelSheet, my_style1, objGeneralLedgerBean);

				for (int i = 0; i < 15; i++) {
					excelSheet.autoSizeColumn(i);
				}

				// set Data
				setExcelRowsSubLedgerWithMultiple(workbook, excelSheet, objGeneralLedgerOPBean, lGeneralLedgerList, objGeneralLedgerBean, my_style1, my_style2, my_style3, my_style_green, my_style_green_right_align, my_style_red, my_style_red_right_align);

				// export excell
				String sFileUrl = writeExcelSubLedger(workbook, exportFilesPath);
				objGeneralLedger.setSuccess(true);
			} catch (Exception e) {
				objGeneralLedger.setSuccess(false);
				e.printStackTrace();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return objGeneralLedger;
	}

	public void setExcelHeaderSubLedger(SXSSFSheet excelSheet, XSSFCellStyle my_style1, DayBookBean objGeneralLedgerBean) {
		try {

			Row row = excelSheet.createRow(4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("S.No");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Transaction Type");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Transaction No");

			Cell cell4 = row.createCell(3);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Transaction Dt");

			if (!objGeneralLedgerBean.getMainAccountCode().equalsIgnoreCase("")) {

				Cell cell7 = row.createCell(4);
				cell7.setCellStyle(my_style1);
				cell7.setCellValue("Narration");

				Cell cell12 = row.createCell(5);
				cell12.setCellStyle(my_style1);
				cell12.setCellValue("BC Debit ");

				Cell cell14 = row.createCell(6);
				cell14.setCellStyle(my_style1);
				cell14.setCellValue("BC Credit ");
			} else {

				Cell cell3 = row.createCell(4);
				cell3.setCellStyle(my_style1);
				cell3.setCellValue("Account Head");

				Cell cell7 = row.createCell(5);
				cell7.setCellStyle(my_style1);
				cell7.setCellValue("Narration");

				Cell cell12 = row.createCell(6);
				cell12.setCellStyle(my_style1);
				cell12.setCellValue("BC Debit ");

				Cell cell14 = row.createCell(7);
				cell14.setCellStyle(my_style1);
				cell14.setCellValue("BC Credit ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sub ledger
	public void setExcelRowsSubLedgerWithMultiple(SXSSFWorkbook workbook, SXSSFSheet excelSheet, List<DayBookBean> objGeneralLedgerBeanOP, List<DayBookBean> lGeneralLedgerList, DayBookBean objGeneralLedgerBean, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style_green, XSSFCellStyle my_style_green_right_align, XSSFCellStyle my_style_red, XSSFCellStyle my_style_red_right_align) {
		int record = 3, sno = 1;
		try {

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle2 = workbook.createCellStyle();
			dateCellStyle2.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateCellStyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			/*
			 * Row rowah = excelSheet.createRow( record++); rowah.setHeight( (short) 350);
			 */

			for (DayBookBean op : objGeneralLedgerBeanOP) {
				Row rowah = excelSheet.createRow(record++);
				rowah.setHeight((short) 350);

				String sOpening_Balance = op.getSubAccountCode() + "-" + op.getSubAccountName();

				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 0, 7));
				excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 8, 9));

				Cell cellop = rowah.createCell(0);
				cellop.setCellValue(sOpening_Balance);
				cellop.setCellStyle(my_style_green);

				Cell cellop6 = rowah.createCell(8);
				cellop6.setCellValue("Opening Bal"); /* Opening Bal(USD) */
				cellop6.setCellStyle(my_style_green);

				Cell cellop8 = rowah.createCell(10);
				cellop8.setCellValue(op.getOpeningBalance());
				cellop8.setCellStyle(my_style_green_right_align);

				// rowah.createCell(9).setCellStyle(my_style2);
				// rowah.createCell(10).setCellStyle(my_style2);
				rowah.createCell(11).setCellStyle(my_style2);
				rowah.createCell(12).setCellStyle(my_style2);
				rowah.createCell(13).setCellStyle(my_style2);
				rowah.createCell(14).setCellStyle(my_style2);
				rowah.createCell(15).setCellStyle(my_style2);
				rowah.createCell(16).setCellStyle(my_style2);
				rowah.createCell(17).setCellStyle(my_style2);
				rowah.createCell(18).setCellStyle(my_style2);
				rowah.createCell(19).setCellStyle(my_style2);
				rowah.createCell(20).setCellStyle(my_style2);
				rowah.createCell(21).setCellStyle(my_style2);
				rowah.createCell(22).setCellStyle(my_style2);
				rowah.createCell(23).setCellStyle(my_style2);
				rowah.createCell(24).setCellStyle(my_style2);
				rowah.createCell(25).setCellStyle(my_style2);

				objGeneralLedgerBean.setSubAccountCode(op.getSubAccountCode());
				lGeneralLedgerList = objGeneralLedgerDao.getSubLedgerReport1(objGeneralLedgerBean);
				if (lGeneralLedgerList.size() > 0) {
					for (DayBookBean objGeneralLedgerTransBean : lGeneralLedgerList) {

						Row rowsg = excelSheet.createRow(record++);
						rowsg.setHeight((short) 350);

						Cell cellah0 = rowsg.createCell(0);
						cellah0.setCellStyle(my_style2);
						cellah0.setCellValue(objGeneralLedgerTransBean.getLedgerNo());

						Cell cellah1 = rowsg.createCell(1);
						cellah1.setCellStyle(my_style2);
						cellah1.setCellValue(objGeneralLedgerTransBean.getLedgerSeq());

						Cell cellah2 = rowsg.createCell(2);
						cellah2.setCellStyle(my_style2);
						cellah2.setCellValue(checkNullValue(objGeneralLedgerTransBean.getTransactionNo()));

						/*
						 * Cell cellah3 = rowsg.createCell(3); cellah3.setCellStyle(my_style2);
						 * cellah3.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getVoucherNo()));
						 */

						/*
						 * Cell cellah1 = rowsg.createCell(1); cellah1.setCellStyle(my_style2);
						 * cellah1.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getTransactionDate()));
						 */

						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Date date = format.parse(checkNullValue(objGeneralLedgerTransBean.getTransactionDate()));
						Cell cellah4 = rowsg.createCell(4);
						cellah4.setCellStyle(dateCellStyle2);
						cellah4.setCellValue(date);
						/*
						 * Cell cellah5 = rowsg.createCell(5); cellah5.setCellStyle(my_style2);
						 * cellah5.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getPartyInvoiceNo()));
						 * 
						 * Cell cellah6 = rowsg.createCell(6); cellah6.setCellStyle(my_style2);
						 * cellah6.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getAccountHeadName()));
						 */

						Cell cellah7 = rowsg.createCell(7);
						cellah7.setCellStyle(my_style2);
						cellah7.setCellValue(checkNullValue(objGeneralLedgerTransBean.getNarration()));
						/*
						 * Cell cellah8 = rowsg.createCell(8); cellah8.setCellStyle(my_style2);
						 * cellah8.setCellValue( checkNullValue(objGeneralLedgerTransBean
						 * .getCurrency()));
						 * 
						 * Cell cellah9 = rowsg.createCell(9); cellah9.setCellStyle(my_style3);
						 * cellah9.setCellValue( objGeneralLedgerTransBean.getExchangeRate());
						 */

						Cell cellah10 = rowsg.createCell(10);
						cellah10.setCellStyle(my_style3);

						Cell cellah11 = rowsg.createCell(11);
						cellah11.setCellStyle(my_style3);

						Cell cellah12 = rowsg.createCell(12);
						cellah12.setCellStyle(my_style3);
						cellah12.setCellValue(objGeneralLedgerTransBean.getTcDebit());

						Cell cellah13 = rowsg.createCell(13);
						cellah13.setCellStyle(my_style3);
						cellah13.setCellValue(objGeneralLedgerTransBean.getBcDebit());

						Cell cellah14 = rowsg.createCell(14);
						cellah14.setCellStyle(my_style3);
						cellah14.setCellValue(objGeneralLedgerTransBean.getTcCredit());

						Cell cellah15 = rowsg.createCell(15);
						cellah15.setCellStyle(my_style3);
						cellah15.setCellValue(objGeneralLedgerTransBean.getBcCredit());

						Cell cellah16 = rowsg.createCell(16);
						cellah16.setCellStyle(my_style3);
						Cell cellah17 = rowsg.createCell(17);
						cellah17.setCellStyle(my_style3);

						/*
						 * Cell cellah18 = rowsg.createCell(18); cellah18.setCellStyle(my_style2);
						 * cellah18.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getVesselCode()));
						 * 
						 * Cell cellah19 = rowsg.createCell(19); cellah19.setCellStyle(my_style2);
						 * cellah19.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getVoyageCode()));
						 * 
						 * Cell cellah20 = rowsg.createCell(20); cellah20.setCellStyle(my_style2);
						 * cellah20.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getSectorCode()));
						 * 
						 * Cell cellah21 = rowsg.createCell(21); cellah21.setCellStyle(my_style2);
						 * if((objGeneralLedgerTransBean.getPol()) == null ||
						 * String.valueOf(objGeneralLedgerTransBean.getPol()). equalsIgnoreCase("null"))
						 * cellah21.setCellValue(""); else
						 * cellah21.setCellValue(objGeneralLedgerTransBean.getPol ());
						 * 
						 * Cell cellah22 = rowsg.createCell(22); cellah22.setCellStyle(my_style2);
						 * if((objGeneralLedgerTransBean.getPod()) == null ||
						 * String.valueOf(objGeneralLedgerTransBean.getPod()). equalsIgnoreCase("null"))
						 * cellah22.setCellValue(""); else
						 * cellah22.setCellValue(objGeneralLedgerTransBean.getPod ());
						 * 
						 * Cell cellah23 = rowsg.createCell(23); cellah23.setCellStyle(my_style2);
						 * cellah23.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getCreatedBy()));
						 * 
						 * Cell cellah24 = rowsg.createCell(24); cellah24.setCellStyle(my_style2);
						 * cellah24.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getAllocationStatus()));
						 * 
						 * Cell cellah25 = rowsg.createCell(25); cellah25.setCellStyle(my_style2);
						 * cellah25.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getAllocatedTo()));
						 * 
						 * Cell cellah26 = rowsg.createCell(26); cellah26.setCellStyle(my_style2);
						 * cellah26.setCellValue (checkNullValue(objGeneralLedgerTransBean
						 * .getAllocatedTo2()));
						 * 
						 * Cell cellah27 = rowsg.createCell(27); cellah27.setCellStyle(my_style2);
						 * if(objGeneralLedgerTransBean.getDueDate() != null &&
						 * objGeneralLedgerTransBean.getDueDate() != ""){ cellah27
						 * .setCellValue(objGeneralLedgerTransBean.getDueDate ()); }else
						 * cellah27.setCellValue(checkNullValue(null)); }
						 */

					}

					Row rowcb = excelSheet.createRow(record++);
					rowcb.setHeight((short) 350);

					String sClosing_Balance = op.getSubAccountCode() + "-" + op.getSubAccountName();

					excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 0, 7));
					excelSheet.addMergedRegion(new CellRangeAddress(record - 1, record - 1, 8, 9));

					Cell cellcp = rowcb.createCell(0);
					cellcp.setCellValue(sClosing_Balance);
					cellcp.setCellStyle(my_style_red);

					Cell cellcp6 = rowcb.createCell(8);
					cellcp6.setCellValue("Closing Bal(USD)");
					cellcp6.setCellStyle(my_style_red);

					// rowcb.createCell(8).setCellStyle(my_style2);
					// rowcb.createCell(9).setCellStyle(my_style2);
					rowcb.createCell(10).setCellStyle(my_style2);
					rowcb.createCell(11).setCellStyle(my_style2);
					rowcb.createCell(12).setCellStyle(my_style2);
					rowcb.createCell(13).setCellStyle(my_style2);
					rowcb.createCell(14).setCellStyle(my_style2);

					Cell cellcp13 = rowcb.createCell(15);
					cellcp13.setCellValue(op.getClosingBalance());
					cellcp13.setCellStyle(my_style_red_right_align);

					// rowcb.createCell(14).setCellStyle(my_style2);
					// rowcb.createCell(15).setCellStyle(my_style2);
					rowcb.createCell(16).setCellStyle(my_style2);
					rowcb.createCell(17).setCellStyle(my_style2);
					rowcb.createCell(18).setCellStyle(my_style2);
					rowcb.createCell(19).setCellStyle(my_style2);
					rowcb.createCell(20).setCellStyle(my_style2);
					rowcb.createCell(21).setCellStyle(my_style2);
					rowah.createCell(22).setCellStyle(my_style2);
					rowah.createCell(23).setCellStyle(my_style2);
					rowah.createCell(24).setCellStyle(my_style2);
					rowah.createCell(25).setCellStyle(my_style2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsSubLedger(SXSSFWorkbook workbook, SXSSFSheet excelSheet, DayBookBean objGeneralLedgerBeanOP, List<DayBookBean> lGeneralLedgerList, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style_green, XSSFCellStyle my_style_green_right_align, XSSFCellStyle my_style_red, XSSFCellStyle my_style_red_right_align, DayBookBean objGeneralLedgerOPBean, DayBookBean inputbean) {
		int record = 5, sno = 1;
		double BCDebit = 0.0, BCCredit = 0.0, ClosingBalance1 = 0.0;

		try {

			CreationHelper createHelper = workbook.getCreationHelper();
			CellStyle dateCellStyle2 = workbook.createCellStyle();
			dateCellStyle2.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateCellStyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			dateCellStyle2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style_narration = (XSSFCellStyle) workbook.createCellStyle();
			my_style_narration.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style_narration.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			// my_style_narration.setWrapText(true);

			Row rowah = excelSheet.createRow(record++);
			rowah.setHeight((short) 350);

			if (!inputbean.getMainAccountCode().equalsIgnoreCase("")) {

				Cell cellop6 = rowah.createCell(4);
				cellop6.setCellValue("Opening Bal");
				cellop6.setCellStyle(my_style_green);

				if (objGeneralLedgerOPBean.getOpeningBalance() > 0) {

					Cell cellop8 = rowah.createCell(5);
					cellop8.setCellValue(objGeneralLedgerOPBean.getOpeningBalance());
					cellop8.setCellStyle(my_style_green_right_align);

				} else {
					Cell cellop8 = rowah.createCell(6);
					cellop8.setCellValue(-objGeneralLedgerOPBean.getOpeningBalance());
					cellop8.setCellStyle(my_style_green_right_align);
				}
			} else {

				Cell cellop6 = rowah.createCell(5);
				cellop6.setCellValue("Opening Bal");
				cellop6.setCellStyle(my_style_green);

				if (objGeneralLedgerOPBean.getOpeningBalance() > 0) {

					Cell cellop8 = rowah.createCell(6);
					cellop8.setCellValue(objGeneralLedgerOPBean.getOpeningBalance());
					cellop8.setCellStyle(my_style_green_right_align);

				} else {
					Cell cellop8 = rowah.createCell(7);
					cellop8.setCellValue(-objGeneralLedgerOPBean.getOpeningBalance());
					cellop8.setCellStyle(my_style_green_right_align);
				}
			}

			Double closingBalance = objGeneralLedgerBeanOP.getOpeningBalance();
			Integer sNo = 1;

			if (lGeneralLedgerList.size() > 0) {
				for (DayBookBean objGeneralLedgerTransBean : lGeneralLedgerList) {
					Row rowsg = excelSheet.createRow(record++);
					rowsg.setHeight((short) 350);

					Cell cellah0 = rowsg.createCell(0);
					cellah0.setCellStyle(my_style_narration);
					cellah0.setCellValue(sNo++);

					if (objGeneralLedgerTransBean.getTransactionNo().length() >= 4) {
						if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 4).equalsIgnoreCase("INBR")) {
							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Bank Receipts"));
						} else if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 4).equalsIgnoreCase("INCR")) {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Cash Receipts"));

						}

						else if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("INC")) {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Cash Payment"));

						} else if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("INJ")) {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Journal Voucher"));

						} else if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("INB")) {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Bank Payment"));

						} else if (objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("MUM") || objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("AMD") || objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("DEL") || objGeneralLedgerTransBean.getTransactionNo().substring(0, 3).equalsIgnoreCase("LUD")) {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Invoice"));

						} else {

							Cell cellah1 = rowsg.createCell(1);
							cellah1.setCellStyle(my_style2);
							cellah1.setCellValue(checkNullValue("Invoice"));

						}
					} else {

						Cell cellah1 = rowsg.createCell(1);
						cellah1.setCellStyle(my_style2);
						cellah1.setCellValue(checkNullValue("Invoice"));
					}

					Cell cellah2 = rowsg.createCell(2);
					cellah2.setCellStyle(my_style2);
					cellah2.setCellValue(checkNullValue(objGeneralLedgerTransBean.getTransactionNo()));

					DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					Date date = format.parse(checkNullValue(objGeneralLedgerTransBean.getTransactionDate()));
					Cell cellah4 = rowsg.createCell(3);
					cellah4.setCellStyle(dateCellStyle2);
					cellah4.setCellValue(date);

					if (!inputbean.getMainAccountCode().equalsIgnoreCase("")) {

						Cell cellah7 = rowsg.createCell(4);
						cellah7.setCellStyle(my_style_narration);
						cellah7.setCellValue(checkNullValue(objGeneralLedgerTransBean.getNarration()));

						Cell cellah12 = rowsg.createCell(5);
						cellah12.setCellStyle(my_style3);
						cellah12.setCellValue(objGeneralLedgerTransBean.getBcDebit());

						BCDebit = BCDebit + objGeneralLedgerTransBean.getBcDebit();
						Cell cellah14 = rowsg.createCell(6);
						cellah14.setCellStyle(my_style3);
						cellah14.setCellValue(objGeneralLedgerTransBean.getBcCredit());
						BCCredit = BCCredit + objGeneralLedgerTransBean.getBcCredit();

					} else {

						Cell cellah3 = rowsg.createCell(4);
						cellah3.setCellStyle(my_style3);
						cellah3.setCellValue(checkNullValue(objGeneralLedgerTransBean.getAccountHeadName()));

						Cell cellah7 = rowsg.createCell(5);
						cellah7.setCellStyle(my_style_narration);
						cellah7.setCellValue(checkNullValue(objGeneralLedgerTransBean.getNarration()));

						Cell cellah12 = rowsg.createCell(6);
						cellah12.setCellStyle(my_style3);
						cellah12.setCellValue(objGeneralLedgerTransBean.getBcDebit());

						BCDebit = BCDebit + objGeneralLedgerTransBean.getBcDebit();
						Cell cellah14 = rowsg.createCell(7);
						cellah14.setCellStyle(my_style3);
						cellah14.setCellValue(objGeneralLedgerTransBean.getBcCredit());
						BCCredit = BCCredit + objGeneralLedgerTransBean.getBcCredit();
					}

				}

				if (!inputbean.getMainAccountCode().equalsIgnoreCase("")) {

					Row rowcb = excelSheet.createRow(record++);
					rowcb.setHeight((short) 350);

					Cell cellcp5 = rowcb.createCell(4);
					cellcp5.setCellStyle(my_style_red);
					cellcp5.setCellValue("Total");
					Cell cellcp6 = rowcb.createCell(5);
					cellcp6.setCellValue(BCDebit);
					cellcp6.setCellStyle(my_style_red_right_align);
					Cell cellcp7 = rowcb.createCell(6);
					cellcp7.setCellValue(BCCredit);
					cellcp7.setCellStyle(my_style_red_right_align);

					Row rowcb1 = excelSheet.createRow(record++);
					rowcb1.setHeight((short) 350);

					Cell cellcpp5 = rowcb1.createCell(4);
					cellcpp5.setCellStyle(my_style_red);
					cellcpp5.setCellValue("Closing Balance");

					if (objGeneralLedgerOPBean.getClosingBalance() > 0) {

						Cell cellcpp6 = rowcb1.createCell(5);
						cellcpp6.setCellValue(objGeneralLedgerOPBean.getClosingBalance());
						cellcpp6.setCellStyle(my_style_red_right_align);

					} else {
						Cell cellcpp6 = rowcb1.createCell(6);
						cellcpp6.setCellValue(-objGeneralLedgerOPBean.getClosingBalance());
						cellcpp6.setCellStyle(my_style_red_right_align);
					}
				} else {

					Row rowcb = excelSheet.createRow(record++);
					rowcb.setHeight((short) 350);

					Cell cellcp5 = rowcb.createCell(5);
					cellcp5.setCellStyle(my_style_red);
					cellcp5.setCellValue("Total");
					Cell cellcp6 = rowcb.createCell(6);
					cellcp6.setCellValue(BCDebit);
					cellcp6.setCellStyle(my_style_red_right_align);
					Cell cellcp7 = rowcb.createCell(7);
					cellcp7.setCellValue(BCCredit);
					cellcp7.setCellStyle(my_style_red_right_align);

					Row rowcb1 = excelSheet.createRow(record++);
					rowcb1.setHeight((short) 350);

					Cell cellcpp5 = rowcb1.createCell(5);
					cellcpp5.setCellStyle(my_style_red);
					cellcpp5.setCellValue("Closing Balance");

					if (objGeneralLedgerOPBean.getClosingBalance() > 0) {

						Cell cellcpp6 = rowcb1.createCell(6);
						cellcpp6.setCellValue(objGeneralLedgerOPBean.getClosingBalance());
						cellcpp6.setCellStyle(my_style_red_right_align);

					} else {
						Cell cellcpp6 = rowcb1.createCell(7);
						cellcpp6.setCellValue(objGeneralLedgerOPBean.getClosingBalance());
						cellcpp6.setCellStyle(my_style_red_right_align);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Excel Export
	@Override
	public boolean exportGeneralLedgerExcelOP(String exportFilesPath, DayBookBean objGeneralLedgerBean) {
		String acctHead = "";
		// sub account is empty then we are exporting sub ledger report
		if (true) {

			DayBookResultBean objGeneralLedger = new DayBookResultBean();
			List<DayBookBean> lGeneralLedgerList = new ArrayList<>();
			try {

				DayBookBean objGeneralLedgerOPBean = new DayBookBean();

				// .first
				if (objGeneralLedgerBean.getMainAccountCode() != null && objGeneralLedgerBean.getMainAccountCode() != "") {
					objGeneralLedgerOPBean = objGeneralLedgerDao.getOpeningBalanceValue(objGeneralLedgerBean);
					lGeneralLedgerList = objGeneralLedgerDao.getSubLedgerReport(objGeneralLedgerBean);
					// second
				} else {
					objGeneralLedgerOPBean = objGeneralLedgerDao.getOpeningBalanceValue(objGeneralLedgerBean);
					lGeneralLedgerList = objGeneralLedgerDao.getSubLedgerReport(objGeneralLedgerBean);
				}

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
					org.apache.poi.ss.usermodel.Font font = workbook.createFont();
					font.setFontHeight((short) 200);
					font.setFontName("Arial");
					font.setColor(HSSFColor.YELLOW.index);
					font.setBoldweight((short) Font.BOLD);
					font.setFontHeightInPoints((short) 15);
					my_style.setFont(font);
					XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
					my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
					my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
					my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
					my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
					my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
					my_style1.setAlignment(my_style.ALIGN_CENTER);
					my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
					my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
					my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
					org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
					font1.setFontHeight((short) 200);
					font1.setFontName("Arial");
					font1.setColor(HSSFColor.BLACK.index);
					font1.setBoldweight((short) Font.BOLD);
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

					XSSFCellStyle my_style_green = (XSSFCellStyle) workbook.createCellStyle();
					my_style_green.setBorderLeft(XSSFCellStyle.BORDER_THIN);
					my_style_green.setBorderRight(XSSFCellStyle.BORDER_THIN);
					my_style_green.setBorderTop(XSSFCellStyle.BORDER_THIN);
					my_style_green.setBorderBottom(XSSFCellStyle.BORDER_THIN);
					my_style_green.setAlignment(my_style.ALIGN_LEFT);
					my_style_green.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

					org.apache.poi.ss.usermodel.Font font_green = workbook.createFont();
					font_green.setColor(HSSFColor.GREEN.index);
					font_green.setBoldweight((short) Font.BOLD);
					my_style_green.setFont(font_green);

					XSSFCellStyle my_style_green_right_align = (XSSFCellStyle) workbook.createCellStyle();
					my_style_green_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
					my_style_green_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
					my_style_green_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
					my_style_green_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
					my_style_green_right_align.setAlignment(my_style.ALIGN_RIGHT);
					my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
					font_green.setColor(HSSFColor.GREEN.index);
					font_green.setBoldweight((short) Font.BOLD);

					my_style_green_right_align.setFont(font_green);

					XSSFCellStyle my_style_red = (XSSFCellStyle) workbook.createCellStyle();
					my_style_red.setBorderLeft(XSSFCellStyle.BORDER_THIN);
					my_style_red.setBorderRight(XSSFCellStyle.BORDER_THIN);
					my_style_red.setBorderTop(XSSFCellStyle.BORDER_THIN);
					my_style_red.setBorderBottom(XSSFCellStyle.BORDER_THIN);
					my_style_red.setAlignment(my_style.ALIGN_LEFT);
					my_style_red.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

					org.apache.poi.ss.usermodel.Font font_red = workbook.createFont();
					font_red.setColor(HSSFColor.RED.index);
					font_red.setBoldweight((short) Font.BOLD);
					my_style_red.setFont(font_red);

					XSSFCellStyle my_style_red_right_align = (XSSFCellStyle) workbook.createCellStyle();
					my_style_red_right_align.setBorderLeft(XSSFCellStyle.BORDER_THIN);
					my_style_red_right_align.setBorderRight(XSSFCellStyle.BORDER_THIN);
					my_style_red_right_align.setBorderTop(XSSFCellStyle.BORDER_THIN);
					my_style_red_right_align.setBorderBottom(XSSFCellStyle.BORDER_THIN);
					my_style_red_right_align.setAlignment(my_style.ALIGN_RIGHT);
					my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
					font_red.setColor(HSSFColor.RED.index);
					((org.apache.poi.ss.usermodel.Font) font_red).setBoldweight((short) Font.BOLD);
					my_style_red_right_align.setFont(font_red);

					// Create a blank sheet
					// HSSFSheet excelSheet =
					// workbook.createSheet("General Ledger");

					SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet(objGeneralLedgerBean.getCompanyCode());
					excelSheet.setRandomAccessWindowSize(100);// keep 100 rows
																// in memory,

					// set main header
					setExcelMainHeaderSubLedger(excelSheet, my_style, objGeneralLedgerBean, acctHead);
					setExcelMainHeaderSubLedgerSubgroup(excelSheet, my_style, objGeneralLedgerBean, acctHead);

					// set header
					setExcelHeaderSubLedger(excelSheet, my_style1, objGeneralLedgerBean);

					for (int i = 0; i < 8; i++) {
						excelSheet.autoSizeColumn(i);
					}

					// set Data
					setExcelRowsSubLedger(workbook, excelSheet, objGeneralLedgerBean, lGeneralLedgerList, my_style1, my_style2, my_style3, my_style_green, my_style_green_right_align, my_style_red, my_style_red_right_align, objGeneralLedgerOPBean, objGeneralLedgerBean);

					for (int i = 0; i < 8; i++) {
						excelSheet.autoSizeColumn(i);
					}

					// export excell
					String sFileUrl = writeExcel(workbook, exportFilesPath);
					objGeneralLedger.setSuccess(true);
				} catch (Exception e) {
					objGeneralLedger.setSuccess(false);
					e.printStackTrace();
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}

		}

		return true;
	}

	@Override
	public boolean exportTransactionLevelExcel(String exportFilesPath, DayBookBean objGeneralLedgerBean) {

		TrialBalanceBean objTrialBalanceBean = new TrialBalanceBean();
		objTrialBalanceBean.setCompanyCode(objGeneralLedgerBean.getCompanyCode());
		objTrialBalanceBean.setSubGroupCode(objGeneralLedgerBean.getSubGroupCode());
		objTrialBalanceBean.setAcctHeadCode(objGeneralLedgerBean.getAccountHeadCode());
		objTrialBalanceBean.setSubAccountCode(objGeneralLedgerBean.getSubAccountCode());
		objTrialBalanceBean.setFromDate(objGeneralLedgerBean.getFromDate());
		objTrialBalanceBean.setToDate(objGeneralLedgerBean.getToDate());

		List<TrialBalanceBean> lTrialBalanceList = objTrialBalanceDao.getTrialBalanceGLList(objTrialBalanceBean);
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
		
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight((short) Font.BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
			my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight((short) Font.BOLD);
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
			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("General Ledger");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// set main header
			setExcelMainHeaderTB(excelSheet, my_style);

			// set header
			setExcelHeaderTB(excelSheet, my_style1);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// set Data
			setExcelRowsTB(excelSheet, lTrialBalanceList, my_style1, my_style2, my_style3, my_style4);

			// export excell
			String sFileUrl = writeExcel(workbook, exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelMainHeaderTB(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));
		Cell cell = row.createCell(0);
		cell.setCellValue("General ledger");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeaderTB(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow(2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Main Account");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Sub Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Transaction No");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Opening Balance");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Debit");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Credit");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Closing Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsTB(SXSSFSheet excelSheet, List<TrialBalanceBean> lTrialBalanceList, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;

		try {

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {
				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				String sAccountHead = "";
				sAccountHead = objTrialBalanceBean.getAcctHeadCode() + "-" + objTrialBalanceBean.getAcctHeadName();

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style4);
				cell0.setCellValue(sno++);

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sAccountHead));
				row.createCell(2).setCellStyle(my_style2);
				row.createCell(3).setCellStyle(my_style2);

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style3);
				cell4.setCellValue(objTrialBalanceBean.getOpeningBalance());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style3);
				cell5.setCellValue(objTrialBalanceBean.getDebitAmount());
				dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style3);
				cell6.setCellValue(objTrialBalanceBean.getCreditAmount());
				dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(objTrialBalanceBean.getCurrentBalance());
				firstRow = record;

				if (objTrialBalanceBean.getlTBTransactionList().size() > 0) {
					for (TrialBalanceBean objTrialBalanceSABean : objTrialBalanceBean.getlTBTransactionList()) {
						Row rowsg = excelSheet.createRow(record++);
						rowsg.setHeight((short) 350);
						firstSgRow = record;
						Cell cellsg0 = rowsg.createCell(0);
						cellsg0.setCellStyle(my_style4);
						cellsg0.setCellValue(sno++);

						String sSubAccountCode = checkNullValue(objTrialBalanceSABean.getSubAccountCode()) + "-" + checkNullValue(objTrialBalanceSABean.getSubAccountName());
						Cell cellsg2 = rowsg.createCell(2);
						cellsg2.setCellStyle(my_style2);
						cellsg2.setCellValue(checkNullValue(sSubAccountCode));

						rowsg.createCell(1).setCellStyle(my_style2);
						rowsg.createCell(3).setCellStyle(my_style2);

						Cell cellsg4 = rowsg.createCell(4);
						cellsg4.setCellStyle(my_style3);
						cellsg4.setCellValue(objTrialBalanceSABean.getOpeningBalance());

						Cell cellsg5 = rowsg.createCell(5);
						cellsg5.setCellStyle(my_style3);
						cellsg5.setCellValue(objTrialBalanceSABean.getDebitAmount());

						Cell cellsg6 = rowsg.createCell(6);
						cellsg6.setCellStyle(my_style3);
						cellsg6.setCellValue(objTrialBalanceSABean.getCreditAmount());

						Cell cellsg7 = rowsg.createCell(7);
						cellsg7.setCellStyle(my_style3);
						cellsg7.setCellValue(objTrialBalanceSABean.getCurrentBalance());

						if (objTrialBalanceSABean.getlSATransactionLevelList().size() > 0) {
							for (TrialBalanceBean objTrialBalanceTransactionBean : objTrialBalanceSABean.getlSATransactionLevelList()) {
								Row rowah = excelSheet.createRow(record++);
								rowah.setHeight((short) 350);

								Cell cellah0 = rowah.createCell(0);
								cellah0.setCellStyle(my_style4);
								cellah0.setCellValue(sno++);

								String sTransactionNo = objTrialBalanceTransactionBean.getTransactionNo();
								Cell cellah3 = rowah.createCell(3);
								cellah3.setCellStyle(my_style2);
								cellah3.setCellValue(checkNullValue(sTransactionNo));

								rowah.createCell(1).setCellStyle(my_style2);
								rowah.createCell(2).setCellStyle(my_style2);

								Cell cellah4 = rowah.createCell(4);
								cellah4.setCellStyle(my_style3);
								cellah4.setCellValue("");

								Cell cellah5 = rowah.createCell(5);
								cellah5.setCellStyle(my_style3);
								cellah5.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());

								Cell cellah6 = rowah.createCell(6);
								cellah6.setCellStyle(my_style3);
								cellah6.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());

								Cell cellah7 = rowah.createCell(7);
								cellah7.setCellStyle(my_style3);
								cellah7.setCellValue("");

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

			// Create total row
			Row rowTotal = excelSheet.createRow(record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style1);
			rowTotal.createCell(1).setCellStyle(my_style1);
			rowTotal.createCell(2).setCellStyle(my_style1);
			rowTotal.createCell(3).setCellStyle(my_style1);
			rowTotal.createCell(4).setCellStyle(my_style1);

			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style1);
			cellah1.setCellValue("Total");

			Cell cellah5 = rowTotal.createCell(5);
			cellah5.setCellStyle(my_style1);
			cellah5.setCellValue(dTotalDebitAmt);

			Cell cellah6 = rowTotal.createCell(6);
			cellah6.setCellStyle(my_style1);
			cellah6.setCellValue(dTotalCreditAmt);

			Cell cellah7 = rowTotal.createCell(7);
			cellah7.setCellStyle(my_style1);
			cellah7.setCellValue(dTotalDebitAmt - dTotalCreditAmt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DayBookBean getOpeningBalanceValue(DayBookBean objGeneralLedgerBean) {
		// TODO Auto-generated method stub
		return objGeneralLedgerDao.getOpeningBalanceValue(objGeneralLedgerBean);
	}

	@Override
	public List<DayBookBean> getSubLedgerReport_only(DayBookBean objGeneralLedgerBean) {
		// TODO Auto-generated method stub
		return objGeneralLedgerDao.getSubLedgerReport_only(objGeneralLedgerBean);
	}

	@Override
	public List<SelectivityBean> getsub(List<String> sub) throws CustomException {
		// TODO Auto-generated method stub
		return objGeneralLedgerDao.getsub(sub);
	}

	@Override
	public List<SelectivityBean> getmain(String main) throws CustomException {
		// TODO Auto-generated method stub
		return objGeneralLedgerDao.getmain(main);
	}

	@Override
	public DayBookBean pdfExportNew(DayBookBean detentionTariffBean, String exportFilesPath) {

		// DetentionTariffBean bean = new DetentionTariffBean();
		List<DayBookBean> Listbean = new ArrayList<>();
		try {
			// ServletContext context1 = request.getServletContext();
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/DayBook.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("DayBook Report");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);

			
			document.open();

			
			Listbean = objGeneralLedgerDao.getConsolidatedGeneralLedgerList(detentionTariffBean);
			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD, new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph("Day Book\n",bfBold123);
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
				   float[] columnWidths = {5f, 5f, 5f, 5f,5f,6f,5f,5f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				 
				   //insert column headings
				   insertCell(table1, "VOUCHER DATE", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "VOUCHER NO", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "FUND TYPE", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "CREATED BY", Element.ALIGN_LEFT, 1, bfBold12);				  
				   insertCell(table1, "ACCOUNT HEAD CODE", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "ACCOUNT HEAD NAME", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "CREDIT AMOUNT", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "DEBIT AMOUNT", Element.ALIGN_LEFT, 1, bfBold12);
				   table1.setHeaderRows(1);
				 
				   //insert an empty row
				  /* insertCell(table1, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table1, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);*/
				   double credit=0, debit = 0;				    
				   //just some random data to fill 
				   for(DayBookBean detail : Listbean){
				     
				 
					   BaseColor color = BaseColor.BLACK;
					   if (detail.getCostCenter()==null)
						   detail.setCostCenter("");
					   if (detail.getCreatedBy()==null)
						   detail.setCreatedBy("");

					   insertCell(table1, "" +detail.getTransactionDate()+"" , Element.ALIGN_LEFT,color, 1, bf12);
					   insertCell(table1, "" +detail.getTransactionNo()+"" , Element.ALIGN_LEFT,color, 1, bf12);
					   insertCell(table1, "" +detail.getCostCenter()+"" , Element.ALIGN_LEFT,color, 1, bf12);
					   insertCell(table1, "" +detail.getCreatedBy()+"" , Element.ALIGN_LEFT,color, 1, bf12);
					   insertCell(table1, "" +detail.getAccountHeadCode()+"" , Element.ALIGN_LEFT,color, 1, bf12); 
					   insertCell(table1, "" +detail.getAccountHeadName()+"" , Element.ALIGN_LEFT,color, 1, bf12);   
					   insertCell(table1, "" +df.format(detail.getTcCredit())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
					    insertCell(table1, "" +df.format(detail.getBcCredit())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
					   
					    credit = credit + detail.getTcCredit();
					    debit = debit + detail.getBcCredit();
				   }

				   insertCell(table1, "TOTAL", Element.ALIGN_RIGHT, 6, bfBold12);
				   insertCell(table1, df.format(credit), Element.ALIGN_RIGHT, 1, bf12);
				   insertCell(table1, df.format(debit), Element.ALIGN_RIGHT, 1, bf12);
				 

				/*   insertCell(table1, "Total", Element.ALIGN_RIGHT, 6, bfBold12);
				   insertCell(table1, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);*/
				  
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


			detentionTariffBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detentionTariffBean;
	
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

	public boolean OddorEven(int number) {
		boolean success = true;
		if (number % 2 == 0) {
			success = true;
			// System.out.println("The given number " + number + " is Even ");
		} else {
			success = false;
			// System.out.println("The given number " + number + " is Odd ");
		}
		return success;
	}
	
	private void insertCell1(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(),font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
//		  cell.setBorderColor(color);/
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