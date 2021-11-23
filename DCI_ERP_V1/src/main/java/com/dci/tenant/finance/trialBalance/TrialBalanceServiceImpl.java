package com.dci.tenant.finance.trialBalance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
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





@Service
public class TrialBalanceServiceImpl implements TrialBalanceService {

	@Autowired
	TrialBalanceDAO trialBalanceDAO;

	@Override
	public List<SelectivityBean> getCompanyList() {
		return trialBalanceDAO.getCompanyList();
	}

	@Override
	public List<SelectivityBean> getSubGroupList() {
		return trialBalanceDAO.getSubGroupList();
	}

	@Override
	public List<SelectivityBean> getSubAccountList() {
		return trialBalanceDAO.getSubAccountList();
	}
	@Override
	public List<SelectivityBean> getAccountList() {
		return trialBalanceDAO.getAccountList();
	}
	@Override
	public List<SelectivityBean> getAccountHeadList(String subGroupCode) {
		return trialBalanceDAO.getAccountHeadList(subGroupCode);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGList1(TrialBalanceBean objTrialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSGList1(objTrialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGList(TrialBalanceBean objTrialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSGList(objTrialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSGListRPSplitup(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSGListRPSplitup(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevel(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevel1(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceAHLevel1(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevel(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSALevel(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevel1(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSALevel1(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevelRPonly(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSALevelRPonly(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceSALevelExcludeRP(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceSALevelExcludeRP(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevelRPonly(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceAHLevelRPonly(trialBalanceBean);
	}

	@Override
	public List<TrialBalanceBean> getTrialBalanceAHLevelExcludeRp(TrialBalanceBean trialBalanceBean) {
		return trialBalanceDAO.getTrialBalanceAHLevelExcludeRp(trialBalanceBean);
	}

	@Override
	public boolean exportTBExcelSplitRP(String sFilePath, TrialBalanceBean trialBalanceBean) {
		
		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceListRPSplit(trialBalanceBean);
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
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Trial Balance");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lTrialBalanceList, my_style1, my_style2, my_style3);

			for (int i = 0; i < 11; i++) {
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
	public boolean exportTBExcelWithPlain(String sFilePath, TrialBalanceBean trialBalanceBean) {

		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceListWithPlain(trialBalanceBean);
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
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Trial Balance");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeaderWithPlain(excelSheet, my_style1);

			// set Data
			setExcelRowsWithPlain(excelSheet, lTrialBalanceList, my_style1, my_style2, my_style3);

			for (int i = 0; i < 8; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcelWithPlain(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	@Override
	public boolean exportTBExcel(String sFilePath, TrialBalanceBean trialBalanceBean) {

		boolean isSuccess =false;
		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceList(trialBalanceBean);

		try {

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
			org.apache.poi.ss.usermodel.Font  font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			HSSFCellStyle my_stylenew = workbook.createCellStyle();

			my_stylenew.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew.setAlignment(my_stylenew.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font  fontnew = workbook.createFont();

			fontnew.setFontName("Arial");
			fontnew.setColor(HSSFColor.BLACK.index);
			fontnew.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			fontnew.setFontHeightInPoints((short) 10);
			my_stylenew.setFont(fontnew);

			HSSFCellStyle my_stylenew1 = workbook.createCellStyle();
			my_stylenew1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew1.setAlignment(my_stylenew.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font  fontnew1 = workbook.createFont();

			fontnew1.setFontName("Arial");
			fontnew1.setColor(HSSFColor.BLACK.index);

			fontnew1.setFontHeightInPoints((short) 10);
			my_stylenew1.setFont(fontnew1);

			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
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

			HSSFSheet excelSheet = workbook.createSheet("Trial Balance");

			while (workbook.getNumberOfSheets() > 1)
				workbook.removeSheetAt(0);

			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, lTrialBalanceList, my_stylenew, my_stylenew1, my_style3);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}
			
			if (lTrialBalanceList.size()> 0) {
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

	@Override
	public boolean exportTBExcel1(String sFilePath, TrialBalanceBean trialBalanceBean) {
		boolean isSuccess = false;
		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceList1(trialBalanceBean);

		try {

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
			org.apache.poi.ss.usermodel.Font  font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			HSSFCellStyle my_stylenew = workbook.createCellStyle();

			my_stylenew.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew.setAlignment(my_stylenew.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font  fontnew = workbook.createFont();

			fontnew.setFontName("Arial");
			fontnew.setColor(HSSFColor.BLACK.index);
			fontnew.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			fontnew.setFontHeightInPoints((short) 10);
			my_stylenew.setFont(fontnew);

			HSSFCellStyle my_stylenew1 = workbook.createCellStyle();
			my_stylenew1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew1.setAlignment(my_stylenew.ALIGN_LEFT);

			org.apache.poi.ss.usermodel.Font  fontnew1 = workbook.createFont();

			fontnew1.setFontName("Arial");
			fontnew1.setColor(HSSFColor.BLACK.index);

			fontnew1.setFontHeightInPoints((short) 10);
			my_stylenew1.setFont(fontnew1);

			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
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

			HSSFSheet excelSheet = workbook.createSheet("Trial Balance");

			while (workbook.getNumberOfSheets() > 1)
				workbook.removeSheetAt(0);

			setExcelMainHeader1(excelSheet, my_style,  trialBalanceBean);

			// set header
			setExcelHeader1(excelSheet, my_style1);

			// set Data
			setExcelRows1(excelSheet, lTrialBalanceList, my_stylenew, my_stylenew1, my_style3);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}
			if (lTrialBalanceList.size()> 0) {
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

	public void setExcelRows1(HSSFSheet excelSheet, List<TrialBalanceBean> lTrialBalanceList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;
		try {

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}
				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if ("RELATED PARTY".equalsIgnoreCase(sGroupHead)) {
					Cell cell0 = row.createCell(0);
					cell0.setCellStyle(my_style1);
					cell0.setCellValue(sno++);

					Cell cell1 = row.createCell(1);
					cell1.setCellStyle(my_style1);
					cell1.setCellValue(checkNullValue(sGroupHead));
					row.createCell(2).setCellStyle(my_style1);
					row.createCell(3).setCellStyle(my_style1);
					row.createCell(4).setCellStyle(my_style1);

					Cell cell5 = row.createCell(5);
					cell5.setCellStyle(my_style1);
					cell5.setCellValue("");

					Cell cell6 = row.createCell(6);
					cell6.setCellStyle(my_style1);
					cell6.setCellValue("");

					Cell cell7 = row.createCell(7);
					cell7.setCellStyle(my_style1);
					cell7.setCellValue("");

					Cell cell8 = row.createCell(8);
					cell8.setCellStyle(my_style1);
					cell8.setCellValue("");

					/*
					 * // myprt Cell cell9 = row.createCell(9); cell9.setCellStyle(my_style1);
					 * cell9.setCellValue("");
					 * 
					 * Cell cell10 = row.createCell(10); cell10.setCellStyle(my_style1);
					 * cell10.setCellValue("");
					 * 
					 * Cell cell15 = row.createCell(11); cell15.setCellStyle(my_style1);
					 * cell15.setCellValue("");
					 * 
					 * Cell cell16 = row.createCell(12); cell16.setCellStyle(my_style1);
					 * cell16.setCellValue("");
					 */

				} else {
					Cell cell0 = row.createCell(0);
					cell0.setCellStyle(my_style2);
					cell0.setCellValue(sno++);
					// if(sGroupHeadName.contains("1002") ||
					// sGroupHeadName.contains("1003") ||
					// sGroupHeadName.contains("1006") ||
					// sGroupHeadName.contains("1007") ||
					// sGroupHeadName.contains("1008")){
					//
					// }

					Cell cell1 = row.createCell(1);
					cell1.setCellStyle(my_style2);
					cell1.setCellValue(checkNullValue(sGroupHead));
					row.createCell(2).setCellStyle(my_style2);
					row.createCell(3).setCellStyle(my_style2);
					row.createCell(4).setCellStyle(my_style2);
					row.createCell(5).setCellStyle(my_style2);

					Cell cell5 = row.createCell(6);
					cell5.setCellStyle(my_style3);
					cell5.setCellValue(objTrialBalanceBean.getOpeningBalance());

					Cell cell6 = row.createCell(7);
					cell6.setCellStyle(my_style3);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row.createCell(8);
					cell7.setCellStyle(my_style3);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();

					Cell cell8 = row.createCell(9);
					cell8.setCellStyle(my_style3);
					cell8.setCellValue(objTrialBalanceBean.getCurrentBalance());
					firstRow = record;

					if (objTrialBalanceBean.getlTBAccountHeadLevelList().size() > 0) {
						for (TrialBalanceBean objTrialBalanceAHBean : objTrialBalanceBean.getlTBAccountHeadLevelList()) {
							Row rowsg = excelSheet.createRow((short) record++);
							rowsg.setHeight((short) 350);
							firstSgRow = record;
							Cell cellsg0 = rowsg.createCell(0);
							cellsg0.setCellStyle(my_style2);
							cellsg0.setCellValue(sno++);

							rowsg.createCell(1).setCellStyle(my_style2);

							String sSubGroupCode = objTrialBalanceAHBean.getAcctHeadCode() + "-" + objTrialBalanceAHBean.getAcctHeadName();
							Cell cellsg2 = rowsg.createCell(2);
							cellsg2.setCellStyle(my_style2);
							cellsg2.setCellValue(checkNullValue(sSubGroupCode));

							rowsg.createCell(3).setCellStyle(my_style2);
							rowsg.createCell(4).setCellStyle(my_style2);
							rowsg.createCell(5).setCellStyle(my_style2);

							Cell cellsg5 = rowsg.createCell(6);
							cellsg5.setCellStyle(my_style3);
							cellsg5.setCellValue(objTrialBalanceAHBean.getOpeningBalance());

							Cell cellsg6 = rowsg.createCell(7);
							cellsg6.setCellStyle(my_style3);
							cellsg6.setCellValue(objTrialBalanceAHBean.getDebitAmount());

							Cell cellsg7 = rowsg.createCell(8);
							cellsg7.setCellStyle(my_style3);
							cellsg7.setCellValue(objTrialBalanceAHBean.getCreditAmount());

							Cell cellsg8 = rowsg.createCell(9);
							cellsg8.setCellStyle(my_style3);
							cellsg8.setCellValue(objTrialBalanceAHBean.getCurrentBalance());

							// mypart

							/*
							 * Cell cellsg9 = rowsg.createCell(10); cellsg9.setCellStyle(my_style3);
							 * cellsg9.setCellValue (objTrialBalanceAHBean.getOpeningBalance());
							 * 
							 * Cell cellsg10 = rowsg.createCell(11); cellsg10.setCellStyle(my_style3);
							 * cellsg10.setCellValue (objTrialBalanceAHBean.getDebitAmount());
							 * 
							 * Cell cellsg11 = rowsg.createCell(12); cellsg11.setCellStyle(my_style3);
							 * cellsg11.setCellValue (objTrialBalanceAHBean.getCreditAmount());
							 * 
							 * Cell cellsg12 = rowsg.createCell(13); cellsg12.setCellStyle(my_style3);
							 * cellsg12.setCellValue (objTrialBalanceAHBean.getCurrentBalance());
							 */

							if (objTrialBalanceAHBean.getlTBTransactionList().size() > 0) {
								for (TrialBalanceBean objTrialBalanceTransactionBean : objTrialBalanceAHBean.getlTBTransactionList()) {
									Row rowah = excelSheet.createRow((short) record++);
									rowah.setHeight((short) 350);

									Cell cellah0 = rowah.createCell(0);
									cellah0.setCellStyle(my_style2);
									cellah0.setCellValue(sno++);

									String sSubAccountCode = objTrialBalanceTransactionBean.getSubAccountCode();
									Cell cellah3 = rowah.createCell(4);
									cellah3.setCellStyle(my_style2);
									cellah3.setCellValue(checkNullValue(sSubAccountCode));

									Cell cellah4 = rowah.createCell(5);
									cellah4.setCellStyle(my_style2);
									cellah4.setCellValue(checkNullValue(objTrialBalanceTransactionBean.getSubAccountName()));

									rowah.createCell(1).setCellStyle(my_style2);
									rowah.createCell(2).setCellStyle(my_style2);
									rowah.createCell(3).setCellStyle(my_style2);

									Cell cellah5 = rowah.createCell(6);
									cellah5.setCellStyle(my_style3);
									cellah5.setCellValue(objTrialBalanceTransactionBean.getOpeningBalance());

									Cell cellah6 = rowah.createCell(7);
									cellah6.setCellStyle(my_style3);
									cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());

									Cell cellah7 = rowah.createCell(8);
									cellah7.setCellStyle(my_style3);
									cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());

									Cell cellah8 = rowah.createCell(9);
									cellah8.setCellStyle(my_style3);
									cellah8.setCellValue(objTrialBalanceTransactionBean.getCurrentBalance());

									// my part
									/*
									 * Cell cellah9 = rowah.createCell(10); cellah9.setCellStyle(my_style3);
									 * cellah9.setCellValue (objTrialBalanceTransactionBean .getOpeningBalance());
									 * 
									 * Cell cellah10 = rowah.createCell(11); cellah10.setCellStyle(my_style3);
									 * cellah10 .setCellValue(objTrialBalanceTransactionBean .getDebitAmount());
									 * 
									 * Cell cellah11 = rowah.createCell(12); cellah11.setCellStyle(my_style3);
									 * cellah11 .setCellValue(objTrialBalanceTransactionBean .getCreditAmount());
									 * 
									 * Cell cellah12 = rowah.createCell(13); cellah12.setCellStyle(my_style3);
									 * cellah12 .setCellValue(objTrialBalanceTransactionBean .getCurrentBalance());
									 */
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

			}

			// Create total row
			Row rowTotal = excelSheet.createRow((short) record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style2);
			rowTotal.createCell(1).setCellStyle(my_style2);
			rowTotal.createCell(2).setCellStyle(my_style2);
			rowTotal.createCell(3).setCellStyle(my_style2);
			rowTotal.createCell(4).setCellStyle(my_style2);
			rowTotal.createCell(5).setCellStyle(my_style2);

			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style2);
			cellah1.setCellValue("Total");

			Cell cellah6 = rowTotal.createCell(7);
			cellah6.setCellStyle(my_style2);
			cellah6.setCellValue(dTotalDebitAmt);

			Cell cellah7 = rowTotal.createCell(8);
			cellah7.setCellStyle(my_style2);
			cellah7.setCellValue(dTotalCreditAmt);

			Cell cellah8 = rowTotal.createCell(9);
			cellah8.setCellStyle(my_style2);
			cellah8.setCellValue(dTotalDebitAmt - dTotalCreditAmt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell11 = row.createCell(1);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Particulars");

			Cell cell1 = row.createCell(2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Group");

			Cell cell2 = row.createCell(3);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Main Account");

			Cell cell3 = row.createCell(4);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Sub Account Code");

			Cell cell4 = row.createCell(5);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Sub Account Name");

			Cell cell5 = row.createCell(6);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Opening Balance");

			Cell cell6 = row.createCell(7);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Debit");

			Cell cell7 = row.createCell(8);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Credit");

			Cell cell8 = row.createCell(9);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Closing Balance");

			/*
			 * Cell cell9 = row.createCell(10); cell9.setCellStyle(my_style1);
			 * cell9.setCellValue("Opening Balance");
			 * 
			 * Cell cell10 = row.createCell(11); cell10.setCellStyle(my_style1);
			 * cell10.setCellValue("Debit");
			 * 
			 * Cell cell15 = row.createCell(12); cell15.setCellStyle(my_style1);
			 * cell15.setCellValue("Credit");
			 * 
			 * Cell cell16 = row.createCell(13); cell16.setCellStyle(my_style1);
			 * cell16.setCellValue("Closing Balance");
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelMainHeader1(HSSFSheet excelSheet, HSSFCellStyle my_style , TrialBalanceBean trialBalanceBean) {
		
	
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		


		
		Row row4 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
		Cell cell4 = row4.createCell((short) 0);
		cell4.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell4.setCellStyle(my_style);
	
		
		
		Row row3 = excelSheet.createRow((short)2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 9));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue( trialBalanceBean.getFromDate() +" TO " + trialBalanceBean.getToDate());
		cell3.setCellStyle(my_style);
		
		
		
		Row row2 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 9));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Trial Balance");
		cell2.setCellStyle(my_style);
		
		/*
		 * Row row1 = excelSheet.createRow((short) 0); excelSheet.addMergedRegion(new
		 * CellRangeAddress(0, 10, 0, 13)); Cell cell2 = row.createCell((short) 10);
		 * cell2.setCellValue("OMEGA"); cell2.setCellStyle(my_style);
		 */
	}

	@Override
	public boolean exportTBExcelFormatNew(String sFilePath, TrialBalanceBean trialBalanceBean) {

		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceSGList(trialBalanceBean);
		// objProfitAndLossDao.getProfitLossReportList(objProfitAndLossBean);
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
			org.apache.poi.ss.usermodel.Font  font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			HSSFCellStyle my_stylenew = workbook.createCellStyle();
			// my_stylenew.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			// my_stylenew.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			// my_stylenew.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			// my_stylenew.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_stylenew.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew.setAlignment(my_stylenew.ALIGN_LEFT);
			// my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			// my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  fontnew = workbook.createFont();
			// font1.setFontHeight((short) 200);
			fontnew.setFontName("Arial");
			fontnew.setColor(HSSFColor.BLACK.index);
			fontnew.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
			fontnew.setFontHeightInPoints((short) 10);
			my_stylenew.setFont(fontnew);

			HSSFCellStyle noborder_nobold = workbook.createCellStyle();

			noborder_nobold.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			noborder_nobold.setAlignment(my_stylenew.ALIGN_LEFT);
			noborder_nobold.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			// my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			// my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  fontnew_nbold = workbook.createFont();
			// font1.setFontHeight((short) 200);
			fontnew_nbold.setFontName("Arial");
			fontnew_nbold.setColor(HSSFColor.BLACK.index);
			// fontnew.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontnew_nbold.setFontHeightInPoints((short) 10);
			noborder_nobold.setFont(fontnew_nbold);

			HSSFCellStyle my_stylenew1 = workbook.createCellStyle();
			my_stylenew1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew1.setAlignment(my_stylenew.ALIGN_LEFT);
			// my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			// my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  fontnew1 = workbook.createFont();
			// font1.setFontHeight((short) 200);
			fontnew1.setFontName("Arial");
			fontnew1.setColor(HSSFColor.BLACK.index);
			// fontnew.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontnew1.setFontHeightInPoints((short) 10);
			my_stylenew1.setFont(fontnew1);

			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			org.apache.poi.ss.usermodel.Font  font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font .BOLDWEIGHT_BOLD);
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
			HSSFSheet excelSheet = workbook.createSheet("Trial Balance");

			while (workbook.getNumberOfSheets() > 1)
				workbook.removeSheetAt(0);

			setExcelMainHeaderSheet1(excelSheet, my_stylenew, trialBalanceBean);

			setExcelHeaderSheet1(excelSheet, my_stylenew1, trialBalanceBean);

			// set main header
			// setExcelMainHeader(excelSheet, my_style);

			// set header
			// setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRowsSheet1(excelSheet, lTrialBalanceList, my_stylenew, my_stylenew1, my_style3, trialBalanceBean, noborder_nobold);

			for (int i = 0; i < 8; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcelNew(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelHeaderSheet1(HSSFSheet excelSheet, HSSFCellStyle my_style1, TrialBalanceBean trialBalanceBean) {
		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("");

			Cell cell01 = row.createCell(1);
			cell01.setCellStyle(my_style1);
			my_style1.setWrapText(true);
			cell01.setCellValue("DCI");

			Cell cell011 = row.createCell(2);
			cell011.setCellStyle(my_style1);

			Row row2 = excelSheet.createRow((short) 5);
			row2.setHeight((short) 350);

			Cell cell201 = row2.createCell(0);
			cell201.setCellStyle(my_style1);
			cell201.setCellValue("Particulars");

			Cell cell012 = row2.createCell(1);
			cell012.setCellStyle(my_style1);
			cell012.setCellValue(trialBalanceBean.getFromDate() + " to " + trialBalanceBean.getToDate());

			Cell cell21 = row2.createCell(2);
			cell21.setCellStyle(my_style1);

			Row row34 = excelSheet.createRow((short) 6);
			row34.setHeight((short) 350);

			Cell cell211 = row34.createCell(0);
			cell211.setCellStyle(my_style1);

			excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 2));
			Cell cell1 = row34.createCell((short) 1);
			cell1.setCellValue("Closing Balance");
			cell1.setCellStyle(my_style1);

			Cell cell2111 = row34.createCell(2);
			cell2111.setCellStyle(my_style1);

			Row row3 = excelSheet.createRow((short) 6);
			row3.setHeight((short) 350);

			Cell cell62 = row3.createCell(0);
			cell62.setCellStyle(my_style1);

			Cell cell6 = row3.createCell(1);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Debit");

			Cell cell7 = row3.createCell(2);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Credit");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelHeaderWithPlain(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sub Group Code");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Account Head");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Sub Account");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Opening Balance BC");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Total BC Debit");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Total BC Credit");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Closing Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsSheet1(HSSFSheet excelSheet, List<TrialBalanceBean> lTrialBalanceList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, TrialBalanceBean trialBalanceBean, HSSFCellStyle noborder_nobold) {
		int record = 7, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;

		double dTotaldebitcurrentliab = 0.0, dTotalcreditcurrentliab = 0.0;

		double dLoandebit = 0.0, dLoancredit = 0.0;

		double dintercompdebit = 0.00, dintercompcredit = 0.0;

		double directincomedebit = 0.00, directincomecredit = 0.0;

		double indirectincdebit = 0.00, indirectinccredit = 0.0;

		double dmiscexpdebit = 0.00, dmiscexpcredit = 0.0;

		double dfixedassetdebit = 0.00, dfixedassetcredit = 0.0;

		double directexpdebit = 0.00, directexpcredit = 0.0;

		double indirectexpdebit = 0.00, indirectexpcredit = 0.0;

		try {

			Row row = excelSheet.createRow((short) record++);
			row.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell cell31 = row.createCell(0);
			cell31.setCellStyle(my_style1);
			cell31.setCellValue("Current Assets");

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {

				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if (sGroupHeadName.contains("1002")) {
					Row row1 = excelSheet.createRow((short) record++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("1003")) {

					Row row1 = excelSheet.createRow((short) record++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("1006")) {

					Row row1 = excelSheet.createRow((short) record++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("1007")) {

					Row row1 = excelSheet.createRow((short) record++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("1008")) {

					Row row1 = excelSheet.createRow((short) record++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotalDebitAmt = dTotalDebitAmt + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalCreditAmt = dTotalCreditAmt + objTrialBalanceBean.getCreditAmount();
				}

			}

			Cell cell3211 = row.createCell(1);
			cell3211.setCellStyle(my_style1);
			cell3211.setCellValue(dTotalDebitAmt);

			Cell cell222 = row.createCell(2);
			cell222.setCellStyle(my_style1);
			cell222.setCellValue(dTotalCreditAmt);

			Row row1442 = excelSheet.createRow((short) 14);
			row1442.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell celle3 = row1442.createCell(0);
			celle3.setCellStyle(my_style1);
			celle3.setCellValue("Loans");

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {
				// Row row1 = excelSheet.createRow((short) 16);
				// row1.setHeight((short) 350);
				// for (int i = 0; i < 7; i++) {
				// excelSheet.autoSizeColumn(i);
				// }
				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if (sGroupHeadName.contains("2005")) {

					Row row1 = excelSheet.createRow((short) 15);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dLoandebit = dLoandebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dLoancredit = dLoancredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("2000")) {

					Row row1 = excelSheet.createRow((short) 16);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dLoandebit = dLoandebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dLoancredit = dLoancredit + objTrialBalanceBean.getCreditAmount();
				}
			}

			Cell row121 = row1442.createCell(1);
			row121.setCellStyle(my_style1);
			row121.setCellValue(dLoandebit);

			Cell ceffw = row1442.createCell(2);
			ceffw.setCellStyle(my_style1);
			ceffw.setCellValue(dLoancredit);

			Row row123 = excelSheet.createRow((short) 18);
			row123.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell row113 = row123.createCell(0);
			row113.setCellStyle(my_style1);
			row113.setCellValue("Current Liabilities");

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {

				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}
				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if (sGroupHeadName.contains("2012")) {
					Row row1 = excelSheet.createRow((short) 19);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotaldebitcurrentliab = dTotaldebitcurrentliab + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalcreditcurrentliab = dTotalcreditcurrentliab + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("2006")) {

					Row row1 = excelSheet.createRow((short) 20);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotaldebitcurrentliab = dTotaldebitcurrentliab + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalcreditcurrentliab = dTotalcreditcurrentliab + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("2001")) {

					Row row1 = excelSheet.createRow((short) 21);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					dTotaldebitcurrentliab = dTotaldebitcurrentliab + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					dTotalcreditcurrentliab = dTotalcreditcurrentliab + objTrialBalanceBean.getCreditAmount();
				}
			}
			Cell row1241 = row123.createCell(1);
			row1241.setCellStyle(my_style1);
			row1241.setCellValue(dTotaldebitcurrentliab);

			Cell ceff4w = row123.createCell(2);
			ceff4w.setCellStyle(my_style1);
			ceff4w.setCellValue(dTotalcreditcurrentliab);

			int rowcount = 23;
			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {

				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if (sGroupHeadName.contains("2000")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Branch/Divisions");

					trialBalanceBean.setFilterCode("2000");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());

						dintercompdebit = dintercompdebit + objTrialBalanceTransactionBean.getDebitAmount();

						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());
						dintercompcredit = dintercompcredit + objTrialBalanceTransactionBean.getCreditAmount();
					}

					Cell row1q34 = row1523.createCell(1);
					row1q34.setCellStyle(my_style1);
					row1q34.setCellValue(dintercompdebit);

					Cell row31q34 = row1523.createCell(2);
					row31q34.setCellStyle(my_style1);
					row31q34.setCellValue(dintercompcredit);

				}

				else if (sGroupHeadName.contains("1012")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Fixed Assets");

					trialBalanceBean.setFilterCode("1012");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());

						dfixedassetdebit = dfixedassetdebit + objTrialBalanceTransactionBean.getDebitAmount();

						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());

						dfixedassetcredit = dfixedassetcredit + objTrialBalanceTransactionBean.getCreditAmount();

					}

					Cell row1r241 = row1523.createCell(1);
					row1r241.setCellStyle(my_style1);
					row1r241.setCellValue(dfixedassetdebit);

					Cell ceff4544 = row1523.createCell(2);
					ceff4544.setCellStyle(my_style1);
					row1r241.setCellValue(dfixedassetcredit);

				}

				else if (sGroupHeadName.contains("1015")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Misc. Expenses (ASSET)");

					trialBalanceBean.setFilterCode("1015");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());
						dmiscexpdebit = dmiscexpdebit + objTrialBalanceTransactionBean.getDebitAmount();

						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());
						dmiscexpcredit = dmiscexpcredit + objTrialBalanceTransactionBean.getCreditAmount();

					}

					Cell row1r241 = row1523.createCell(1);
					row1r241.setCellStyle(my_style1);
					row1r241.setCellValue(dmiscexpdebit);

					Cell ceff4544 = row1523.createCell(2);
					ceff4544.setCellStyle(my_style1);
					ceff4544.setCellValue(dmiscexpcredit);

				}

				else if (sGroupHeadName.contains("4001")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Direct Income");

					trialBalanceBean.setFilterCode("4001");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());
						directincomedebit = directincomedebit + objTrialBalanceTransactionBean.getDebitAmount();
						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());
						directincomecredit = directincomecredit + objTrialBalanceTransactionBean.getCreditAmount();

					}

					Cell row1r241 = row1523.createCell(1);
					row1r241.setCellStyle(my_style1);
					row1r241.setCellValue(directincomedebit);

					Cell ceff4544 = row1523.createCell(2);
					ceff4544.setCellStyle(my_style1);
					ceff4544.setCellValue(directincomecredit);

				}

				else if (sGroupHeadName.contains("6000")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Direct Expenses");

					trialBalanceBean.setFilterCode("6000");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());
						directexpdebit = directexpdebit + objTrialBalanceTransactionBean.getDebitAmount();

						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());
						directexpcredit = directexpcredit + objTrialBalanceTransactionBean.getCreditAmount();

					}

					Cell row1r241 = row1523.createCell(1);
					row1r241.setCellStyle(my_style1);
					row1r241.setCellValue(directexpdebit);

					Cell ceff4544 = row1523.createCell(2);
					ceff4544.setCellStyle(my_style1);
					ceff4544.setCellValue(directexpcredit);

				}

				else if (sGroupHeadName.contains("3001")) {

					Row row1523 = excelSheet.createRow((short) rowcount++);
					row1523.setHeight((short) 350);
					excelSheet.getRow(record);

					Cell row1434 = row1523.createCell(0);
					row1434.setCellStyle(my_style1);
					row1434.setCellValue("Indirect Incomes");

					trialBalanceBean.setFilterCode("3001");
					List<TrialBalanceBean> lTrialBalanceListAHlevel = trialBalanceDAO.getTrialBalanceAHLevel(trialBalanceBean);
					for (TrialBalanceBean objTrialBalanceTransactionBean : lTrialBalanceListAHlevel) {
						Row rowah = excelSheet.createRow((short) rowcount++);
						rowah.setHeight((short) 350);

						Cell cellah4 = rowah.createCell(0);
						cellah4.setCellStyle(noborder_nobold);
						cellah4.setCellValue("   " + checkNullValue(objTrialBalanceTransactionBean.getAcctHeadName()));

						Cell cellah6 = rowah.createCell(1);
						cellah6.setCellStyle(noborder_nobold);
						cellah6.setCellValue(objTrialBalanceTransactionBean.getDebitAmount());
						indirectincdebit = indirectincdebit + objTrialBalanceTransactionBean.getDebitAmount();
						Cell cellah7 = rowah.createCell(2);
						cellah7.setCellStyle(noborder_nobold);
						cellah7.setCellValue(objTrialBalanceTransactionBean.getCreditAmount());

						indirectinccredit = indirectinccredit + objTrialBalanceTransactionBean.getCreditAmount();

					}

					Cell row1r241 = row1523.createCell(1);
					row1r241.setCellStyle(my_style1);
					row1r241.setCellValue(indirectincdebit);

					Cell ceff4544 = row1523.createCell(2);
					ceff4544.setCellStyle(my_style1);
					ceff4544.setCellValue(indirectinccredit);

				}

			}
			rowcount++;

			Row rowlast = excelSheet.createRow((short) rowcount++);
			rowlast.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell cell3las1 = rowlast.createCell(0);
			cell3las1.setCellStyle(my_style1);
			cell3las1.setCellValue("Indirect Expenses");

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {

				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if (sGroupHeadName.contains("5001")) {
					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5002")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5003")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5004")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5005")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5006")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				} else if (sGroupHeadName.contains("5007")) {

					Row row1 = excelSheet.createRow((short) rowcount++);
					row1.setHeight((short) 350);

					Cell cell1 = row1.createCell(0);
					cell1.setCellStyle(noborder_nobold);
					cell1.setCellValue("   " + checkNullValue(objTrialBalanceBean.getSubGroupName()));

					Cell cell6 = row1.createCell(1);
					cell6.setCellStyle(noborder_nobold);
					cell6.setCellValue(objTrialBalanceBean.getDebitAmount());
					indirectexpdebit = indirectexpdebit + objTrialBalanceBean.getDebitAmount();

					Cell cell7 = row1.createCell(2);
					cell7.setCellStyle(noborder_nobold);
					cell7.setCellValue(objTrialBalanceBean.getCreditAmount());
					indirectexpcredit = indirectexpcredit + objTrialBalanceBean.getCreditAmount();
				}

			}

			Cell cell3331 = rowlast.createCell(1);
			cell3331.setCellStyle(my_style1);
			cell3331.setCellValue(indirectexpdebit);

			Cell cel442 = rowlast.createCell(2);
			cel442.setCellStyle(my_style1);
			cel442.setCellValue(indirectexpcredit);
			rowcount++;

			Row row152311 = excelSheet.createRow((short) rowcount++);
			row152311.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell row14341 = row152311.createCell(0);
			row14341.setCellStyle(my_style1);
			row14341.setCellValue("Income and Expenditure A/c");

			double totaldebitpandl = directincomedebit + indirectincdebit - directexpdebit - indirectexpdebit;

			double totalcreditpandl = directincomecredit + indirectinccredit - directexpdebit - indirectexpcredit;

			Cell row1r2241 = row152311.createCell(1);
			row1r2241.setCellStyle(my_style1);
			row1r2241.setCellValue(totaldebitpandl);

			Cell ceff45424 = row152311.createCell(2);
			ceff45424.setCellStyle(my_style1);
			ceff45424.setCellValue(totalcreditpandl);

			Row row1523 = excelSheet.createRow((short) rowcount++);
			row1523.setHeight((short) 350);
			excelSheet.getRow(record);

			Cell row1434 = row1523.createCell(0);
			row1434.setCellStyle(my_style1);
			row1434.setCellValue("Grand Total");
			double totaldebit = dTotalDebitAmt + dTotaldebitcurrentliab + dLoandebit + dintercompdebit + directincomedebit + indirectincdebit + dmiscexpdebit + dfixedassetdebit + directexpdebit + indirectexpdebit + totaldebitpandl;

			double totalcredit = dTotalCreditAmt + dTotalcreditcurrentliab + dLoancredit + dintercompcredit + directincomecredit + indirectinccredit + dmiscexpcredit + dfixedassetcredit + directexpcredit + indirectexpcredit + totalcreditpandl;

			Cell row1r241 = row1523.createCell(1);
			row1r241.setCellStyle(my_style1);
			row1r241.setCellValue(totaldebit);

			Cell ceff4544 = row1523.createCell(2);
			ceff4544.setCellStyle(my_style1);
			ceff4544.setCellValue(totalcredit);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsWithPlain(HSSFSheet excelSheet, List<TrialBalanceBean> lTrialBalanceList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {

		int record = 3, sno = 1;

		try {

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {
				Row rowsg = excelSheet.createRow((short) record++);
				rowsg.setHeight((short) 350);

				Cell cellsg1 = rowsg.createCell(0);
				cellsg1.setCellStyle(my_style2);
				cellsg1.setCellValue(checkNullValue(objTrialBalanceBean.getSg()));

				Cell cellsg2 = rowsg.createCell(1);
				cellsg2.setCellStyle(my_style2);
				cellsg2.setCellValue(checkNullValue(objTrialBalanceBean.getAh()));

				Cell cellsg3 = rowsg.createCell(2);
				cellsg3.setCellStyle(my_style2);
				cellsg3.setCellValue(checkNullValue(objTrialBalanceBean.getSa()));

				Cell cellsg4 = rowsg.createCell(3);
				cellsg4.setCellStyle(my_style3);
				cellsg4.setCellValue(checkNullValue(objTrialBalanceBean.getOpeningBalBC()));

				Cell cellsg5 = rowsg.createCell(4);
				cellsg5.setCellStyle(my_style3);
				cellsg5.setCellValue(checkNullValue(objTrialBalanceBean.getTotalBCDebit()));

				Cell cellsg6 = rowsg.createCell(5);
				cellsg6.setCellStyle(my_style3);
				cellsg6.setCellValue(checkNullValue(objTrialBalanceBean.getTotalBCCredit()));

				Cell cellsg7 = rowsg.createCell(6);
				cellsg7.setCellStyle(my_style3);
				cellsg7.setCellValue(checkNullValue(objTrialBalanceBean.getClosingBalBC()));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 25));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Trial Balance");
		cell.setCellStyle(my_style);

	}

	public void setExcelMainHeaderSheet1(HSSFSheet excelSheet, HSSFCellStyle my_style, TrialBalanceBean trialBalanceBean) {

		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("ATHENA GLOBAL LOGISTICS PVT LTD");
		cell.setCellStyle(my_style);

		Row row1 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));
		Cell cellnew = row1.createCell((short) 0);
		cellnew.setCellValue("Trial Balance");
		cellnew.setCellStyle(my_style);

		Row row2 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 2));
		Cell cellnew2 = row2.createCell((short) 0);
		cellnew2.setCellValue(trialBalanceBean.getFromDate() + "  to  " + trialBalanceBean.getToDate());
		cellnew2.setCellStyle(my_style);

	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell11 = row.createCell(1);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Particulars");

			Cell cell1 = row.createCell(2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Group");

			Cell cell23 = row.createCell(3);
			cell23.setCellStyle(my_style1);
			cell23.setCellValue("Main Account");

			Cell cell16 = row.createCell(4);
			cell16.setCellStyle(my_style1);
			cell16.setCellValue("Sub Account Code");
			Cell cell17 = row.createCell(5);
			cell17.setCellStyle(my_style1);
			cell17.setCellValue("Sub Account Name");

			Cell cell2 = row.createCell((short) 6);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Dental Council of India");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 6, (short) 9));

			Cell cell12 = row.createCell((short) 10);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Dental Council of India");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 10, (short) 13));

			Cell cell22 = row.createCell((short) 14);
			cell22.setCellStyle(my_style1);
			cell22.setCellValue("Dental Council of India");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 14, (short) 17));

			Cell cell231 = row.createCell((short) 18);
			cell231.setCellStyle(my_style1);
			cell231.setCellValue("Dental Council of India");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 18, (short) 21));

			Cell cell24 = row.createCell((short) 22);
			cell24.setCellStyle(my_style1);
			cell24.setCellValue("");
			excelSheet.addMergedRegion(new CellRangeAddress(2, (short) 2, 22, (short) 25));
			Row row2 = excelSheet.createRow((short) 3);
			Cell cell21 = row2.createCell((short) 0);
			cell21.setCellStyle(my_style1);
			cell21.setCellValue("");
			excelSheet.addMergedRegion(new CellRangeAddress(3, (short) 3, 0, (short) 5));

			Cell cell212 = row2.createCell(6);
			cell212.setCellStyle(my_style1);
			cell212.setCellValue(" Op Bal");

			Cell cell3 = row2.createCell(7);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue(" Debit");

			Cell cell4 = row2.createCell(8);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue(" Credit");

			Cell cell5 = row2.createCell(9);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue(" Closing Balance");

			Cell cell6 = row2.createCell(10);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue(" Op Bal");

			Cell cell7 = row2.createCell(11);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue(" Debit");

			Cell cell8 = row2.createCell(12);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue(" CREDIT");

			Cell cell9 = row2.createCell(13);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue(" Closing Balance");
			Cell cell10 = row2.createCell(14);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Op Bal");
			Cell cell125 = row2.createCell(15);
			cell125.setCellStyle(my_style1);
			cell125.setCellValue(" Credit");
			Cell cell13 = row2.createCell(16);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("Debit");
			Cell cell14 = row2.createCell(17);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue(" Closing Balance");

			Cell cell15 = row2.createCell(18);
			cell15.setCellStyle(my_style1);
			cell15.setCellValue(" Op Bal");
			Cell cell234 = row2.createCell(19);
			cell234.setCellStyle(my_style1);
			cell234.setCellValue("Credit");
			Cell cell235 = row2.createCell(20);
			cell235.setCellStyle(my_style1);
			cell235.setCellValue("Debit");
			Cell cell18 = row2.createCell(21);
			cell18.setCellStyle(my_style1);
			cell18.setCellValue(" Closing Balance");

			Cell cell19 = row2.createCell(22);
			cell19.setCellStyle(my_style1);
			cell19.setCellValue(" Op Bal");
			Cell cell20 = row2.createCell(23);
			cell20.setCellStyle(my_style1);
			cell20.setCellValue(" Credit");
			Cell cell216 = row2.createCell(24);
			cell216.setCellStyle(my_style1);
			cell216.setCellValue(" Debit");
			Cell cell226 = row2.createCell(25);
			cell226.setCellStyle(my_style1);
			cell226.setCellValue("Closing Balance");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet, List<TrialBalanceBean> lTrialBalanceList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 4, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double C0008debit = 0.0, C0008credit = 0.0, C0009debit = 0.0, C0009credit = 0.0, C0010debit = 0.0, C0010credit = 0.0, C0011debit = 0.0, C0011credit = 0.0, C0012debit = 0.0, C0012credit = 0.0;
		try {

			for (TrialBalanceBean objTrialBalanceBean : lTrialBalanceList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}
				String sGroupHeadName = objTrialBalanceBean.getSubGroupCode();

				String sGroupHead = "";
				if (objTrialBalanceBean.getSubGroupName() != null)
					sGroupHead = objTrialBalanceBean.getSubGroupCode() + "-" + objTrialBalanceBean.getSubGroupName();
				else
					sGroupHead = objTrialBalanceBean.getSubGroupCode();

				if ("RELATED PARTY".equalsIgnoreCase(sGroupHead)) {
					Cell cell0 = row.createCell(0);
					cell0.setCellStyle(my_style1);
					cell0.setCellValue(sno++);

					Cell cell1 = row.createCell(1);
					cell1.setCellStyle(my_style1);
					cell1.setCellValue(checkNullValue(sGroupHead));
					row.createCell(2).setCellStyle(my_style1);
					row.createCell(3).setCellStyle(my_style1);
					row.createCell(4).setCellStyle(my_style1);

					Cell cell5 = row.createCell(5);
					cell5.setCellStyle(my_style1);
					cell5.setCellValue("");

					Cell cell6 = row.createCell(6);
					cell6.setCellStyle(my_style1);
					cell6.setCellValue("");

					Cell cell7 = row.createCell(7);
					cell7.setCellStyle(my_style1);
					cell7.setCellValue("");

					Cell cell8 = row.createCell(8);
					cell8.setCellStyle(my_style1);
					cell8.setCellValue("");

				} else {
					Cell cell0 = row.createCell(0);
					cell0.setCellStyle(my_style2);
					cell0.setCellValue(sno++);

					Cell cell1 = row.createCell(1);
					cell1.setCellStyle(my_style2);
					cell1.setCellValue(checkNullValue(sGroupHead));
					row.createCell(2).setCellStyle(my_style2);
					row.createCell(3).setCellStyle(my_style2);
					row.createCell(4).setCellStyle(my_style2);
					row.createCell(5).setCellStyle(my_style2);

					Cell cell5 = row.createCell(6);
					cell5.setCellStyle(my_style3);
					cell5.setCellValue(objTrialBalanceBean.getC0008_openingbalancebc());

					Cell cell6 = row.createCell(7);
					cell6.setCellStyle(my_style3);
					cell6.setCellValue(objTrialBalanceBean.getC0008_totalbccredit());
					C0008credit = C0008credit + objTrialBalanceBean.getC0008_totalbccredit();

					Cell cell7 = row.createCell(8);
					cell7.setCellStyle(my_style3);
					cell7.setCellValue(objTrialBalanceBean.getC0008_totalbcdebit());
					C0008debit = C0008debit + objTrialBalanceBean.getC0008_totalbcdebit();

					Cell cell8 = row.createCell(9);
					cell8.setCellStyle(my_style3);
					cell8.setCellValue(objTrialBalanceBean.getC0008_closingbalancebc());

					Cell cell9 = row.createCell(10);
					cell9.setCellStyle(my_style3);
					cell9.setCellValue(objTrialBalanceBean.getC0009_openingbalancebc());

					Cell cell10 = row.createCell(11);
					cell10.setCellStyle(my_style3);
					cell10.setCellValue(objTrialBalanceBean.getC0009_totalbccredit());
					C0009credit = C0009credit + objTrialBalanceBean.getC0009_totalbccredit();

					Cell cell11 = row.createCell(12);
					cell11.setCellStyle(my_style3);
					cell11.setCellValue(objTrialBalanceBean.getC0009_totalbcdebit());
					C0009debit = C0009debit + objTrialBalanceBean.getC0009_totalbcdebit();

					Cell cell12 = row.createCell(13);
					cell12.setCellStyle(my_style3);
					cell12.setCellValue(objTrialBalanceBean.getC0009_closingbalancebc());

					Cell cell14 = row.createCell(14);
					cell14.setCellStyle(my_style3);
					cell14.setCellValue(objTrialBalanceBean.getC0010_openingbalancebc());

					Cell cell15 = row.createCell(15);
					cell15.setCellStyle(my_style3);
					cell15.setCellValue(objTrialBalanceBean.getC0010_totalbccredit());
					C0010credit = C0010credit + objTrialBalanceBean.getC0010_totalbccredit();

					Cell cell16 = row.createCell(16);
					cell16.setCellStyle(my_style3);
					cell16.setCellValue(objTrialBalanceBean.getC0010_totalbcdebit());
					C0010debit = C0010debit + objTrialBalanceBean.getC0010_totalbcdebit();

					Cell cell17 = row.createCell(17);
					cell17.setCellStyle(my_style3);
					cell17.setCellValue(objTrialBalanceBean.getC0010_closingbalancebc());

					Cell cell18 = row.createCell(18);
					cell18.setCellStyle(my_style3);
					cell18.setCellValue(objTrialBalanceBean.getC0011_openingbalancebc());

					Cell cell19 = row.createCell(19);
					cell19.setCellStyle(my_style3);
					cell19.setCellValue(objTrialBalanceBean.getC0011_totalbccredit());
					C0011credit = C0011credit + objTrialBalanceBean.getC0011_totalbccredit();

					Cell cell20 = row.createCell(20);
					cell20.setCellStyle(my_style3);
					cell20.setCellValue(objTrialBalanceBean.getC0011_totalbcdebit());
					C0011debit = C0011debit + objTrialBalanceBean.getC0011_totalbcdebit();

					Cell cell21 = row.createCell(21);
					cell21.setCellStyle(my_style3);
					cell21.setCellValue(objTrialBalanceBean.getC0011_closingbalancebc());

					Cell cell22 = row.createCell(22);
					cell22.setCellStyle(my_style3);
					cell22.setCellValue(objTrialBalanceBean.getC0012_openingbalancebc());

					Cell cell23 = row.createCell(23);
					cell23.setCellStyle(my_style3);
					cell23.setCellValue(objTrialBalanceBean.getC0012_totalbccredit());
					C0012credit = C0012credit + objTrialBalanceBean.getC0012_totalbccredit();

					Cell cell24 = row.createCell(24);
					cell24.setCellStyle(my_style3);
					cell24.setCellValue(objTrialBalanceBean.getC0012_totalbcdebit());
					C0012debit = C0012debit + objTrialBalanceBean.getC0012_totalbcdebit();

					Cell cell25 = row.createCell(25);
					cell25.setCellStyle(my_style3);
					cell25.setCellValue(objTrialBalanceBean.getC0012_closingbalancebc());
					firstRow = record;

					if (objTrialBalanceBean.getlTBAccountHeadLevelList().size() > 0) {
						for (TrialBalanceBean objTrialBalanceAHBean : objTrialBalanceBean.getlTBAccountHeadLevelList()) {
							Row rowsg = excelSheet.createRow((short) record++);
							rowsg.setHeight((short) 350);
							firstSgRow = record;
							Cell cellsg0 = rowsg.createCell(0);
							cellsg0.setCellStyle(my_style2);
							cellsg0.setCellValue(sno++);

							rowsg.createCell(1).setCellStyle(my_style2);

							String sSubGroupCode = objTrialBalanceAHBean.getAcctHeadCode() + "-" + objTrialBalanceAHBean.getAcctHeadName();
							Cell cellsg2 = rowsg.createCell(2);
							cellsg2.setCellStyle(my_style2);
							cellsg2.setCellValue(checkNullValue(sSubGroupCode));

							rowsg.createCell(3).setCellStyle(my_style2);
							rowsg.createCell(4).setCellStyle(my_style2);
							rowsg.createCell(5).setCellStyle(my_style2);

							Cell cellsg5 = rowsg.createCell(6);
							cellsg5.setCellStyle(my_style3);
							cellsg5.setCellValue(objTrialBalanceAHBean.getC0008_openingbalancebc());

							Cell cellsg6 = rowsg.createCell(7);
							cellsg6.setCellStyle(my_style3);
							cellsg6.setCellValue(objTrialBalanceAHBean.getC0008_totalbccredit());
							// dTotalDebitAmt = dTotalDebitAmt +
							// objTrialBalanceBean.getC0008_totalbccredit();

							Cell cellsg7 = rowsg.createCell(8);
							cellsg7.setCellStyle(my_style3);
							cellsg7.setCellValue(objTrialBalanceAHBean.getC0008_totalbcdebit());
							// dTotalCreditAmt = dTotalCreditAmt +
							// objTrialBalanceBean.getC0008_totalbcdebit();

							Cell cellsg8 = rowsg.createCell(9);
							cellsg8.setCellStyle(my_style3);
							cellsg8.setCellValue(objTrialBalanceAHBean.getC0008_closingbalancebc());

							Cell cellsg9 = rowsg.createCell(10);
							cellsg9.setCellStyle(my_style3);
							cellsg9.setCellValue(objTrialBalanceAHBean.getC0009_openingbalancebc());

							Cell cellsg10 = rowsg.createCell(11);
							cellsg10.setCellStyle(my_style3);
							cellsg10.setCellValue(objTrialBalanceAHBean.getC0009_totalbccredit());
							// dTotalDebitAmt = dTotalDebitAmt +
							// objTrialBalanceBean.getC0008_totalbccredit();

							Cell cellsg11 = rowsg.createCell(12);
							cellsg11.setCellStyle(my_style3);
							cellsg11.setCellValue(objTrialBalanceAHBean.getC0009_totalbcdebit());
							// dTotalCreditAmt = dTotalCreditAmt +
							// objTrialBalanceBean.getC0008_totalbcdebit();

							Cell cellsg12 = rowsg.createCell(13);
							cellsg12.setCellStyle(my_style3);
							cellsg12.setCellValue(objTrialBalanceAHBean.getC0009_closingbalancebc());

							Cell cellsg14 = rowsg.createCell(14);
							cellsg14.setCellStyle(my_style3);
							cellsg14.setCellValue(objTrialBalanceAHBean.getC0010_openingbalancebc());

							Cell cellsg15 = rowsg.createCell(15);
							cellsg15.setCellStyle(my_style3);
							cellsg15.setCellValue(objTrialBalanceAHBean.getC0010_totalbccredit());
							// dTotalDebitAmt = dTotalDebitAmt +
							// objTrialBalanceBean.getC0008_totalbccredit();

							Cell cellsg16 = rowsg.createCell(16);
							cellsg16.setCellStyle(my_style3);
							cellsg16.setCellValue(objTrialBalanceAHBean.getC0010_totalbcdebit());
							// dTotalCreditAmt = dTotalCreditAmt +
							// objTrialBalanceBean.getC0008_totalbcdebit();

							Cell cellsg17 = rowsg.createCell(17);
							cellsg17.setCellStyle(my_style3);
							cellsg17.setCellValue(objTrialBalanceAHBean.getC0010_closingbalancebc());

							Cell cellsg18 = rowsg.createCell(18);
							cellsg18.setCellStyle(my_style3);
							cellsg18.setCellValue(objTrialBalanceAHBean.getC0011_openingbalancebc());

							Cell cellsg19 = rowsg.createCell(19);
							cellsg19.setCellStyle(my_style3);
							cellsg19.setCellValue(objTrialBalanceAHBean.getC0011_totalbccredit());
							// dTotalDebitAmt = dTotalDebitAmt +
							// objTrialBalanceBean.getC0008_totalbccredit();

							Cell cellsg20 = rowsg.createCell(20);
							cellsg20.setCellStyle(my_style3);
							cellsg20.setCellValue(objTrialBalanceAHBean.getC0011_totalbcdebit());
							// dTotalCreditAmt = dTotalCreditAmt +
							// objTrialBalanceBean.getC0008_totalbcdebit();

							Cell cellsg21 = rowsg.createCell(21);
							cellsg21.setCellStyle(my_style3);
							cellsg21.setCellValue(objTrialBalanceAHBean.getC0011_closingbalancebc());

							Cell cellsg22 = rowsg.createCell(22);
							cellsg22.setCellStyle(my_style3);
							cellsg22.setCellValue(objTrialBalanceAHBean.getC0012_openingbalancebc());

							Cell cellsg23 = rowsg.createCell(23);
							cellsg23.setCellStyle(my_style3);
							cellsg23.setCellValue(objTrialBalanceAHBean.getC0012_totalbccredit());
							// dTotalDebitAmt = dTotalDebitAmt +
							// objTrialBalanceBean.getC0008_totalbccredit();

							Cell cellsg24 = rowsg.createCell(24);
							cellsg24.setCellStyle(my_style3);
							cellsg24.setCellValue(objTrialBalanceAHBean.getC0012_totalbcdebit());
							// dTotalCreditAmt = dTotalCreditAmt +
							// objTrialBalanceBean.getC0008_totalbcdebit();

							Cell cellsg25 = rowsg.createCell(25);
							cellsg25.setCellStyle(my_style3);
							cellsg25.setCellValue(objTrialBalanceAHBean.getC0012_closingbalancebc());

							if (objTrialBalanceAHBean.getlTBTransactionList().size() > 0) {
								for (TrialBalanceBean objTrialBalanceTransactionBean : objTrialBalanceAHBean.getlTBTransactionList()) {
									Row rowah = excelSheet.createRow((short) record++);
									rowah.setHeight((short) 350);

									Cell cellah0 = rowah.createCell(0);
									cellah0.setCellStyle(my_style2);
									cellah0.setCellValue(sno++);

									String sSubAccountCode = objTrialBalanceTransactionBean.getSubAccountCode();
									Cell cellah3 = rowah.createCell(4);
									cellah3.setCellStyle(my_style2);
									cellah3.setCellValue(checkNullValue(sSubAccountCode));

									Cell cellah4 = rowah.createCell(5);
									cellah4.setCellStyle(my_style2);
									cellah4.setCellValue(checkNullValue(objTrialBalanceTransactionBean.getSubAccountName()));

									rowah.createCell(1).setCellStyle(my_style2);
									rowah.createCell(2).setCellStyle(my_style2);
									rowah.createCell(3).setCellStyle(my_style2);
									Cell cellah5 = rowah.createCell(6);
									cellah5.setCellStyle(my_style3);
									cellah5.setCellValue(objTrialBalanceTransactionBean.getC0008_openingbalancebc());

									Cell cellah6 = rowah.createCell(7);
									cellah6.setCellStyle(my_style3);
									cellah6.setCellValue(objTrialBalanceTransactionBean.getC0008_totalbccredit());
									// dTotalDebitAmt = dTotalDebitAmt +
									// objTrialBalanceBean.getC0008_totalbccredit();

									Cell cellah7 = rowah.createCell(8);
									cellah7.setCellStyle(my_style3);
									cellah7.setCellValue(objTrialBalanceTransactionBean.getC0008_totalbcdebit());
									// dTotalCreditAmt = dTotalCreditAmt +
									// objTrialBalanceBean.getC0008_totalbcdebit();

									Cell cellah8 = rowah.createCell(9);
									cellah8.setCellStyle(my_style3);
									cellah8.setCellValue(objTrialBalanceTransactionBean.getC0008_closingbalancebc());

									Cell cellah9 = rowah.createCell(10);
									cellah9.setCellStyle(my_style3);
									cellah9.setCellValue(objTrialBalanceTransactionBean.getC0009_openingbalancebc());

									Cell cellah10 = rowah.createCell(11);
									cellah10.setCellStyle(my_style3);
									cellah10.setCellValue(objTrialBalanceTransactionBean.getC0009_totalbccredit());
									// dTotalDebitAmt = dTotalDebitAmt +
									// objTrialBalanceBean.getC0008_totalbccredit();

									Cell cellah11 = rowah.createCell(12);
									cellah11.setCellStyle(my_style3);
									cellah11.setCellValue(objTrialBalanceTransactionBean.getC0009_totalbcdebit());
									// dTotalCreditAmt = dTotalCreditAmt +
									// objTrialBalanceBean.getC0008_totalbcdebit();

									Cell cellah12 = rowah.createCell(13);
									cellah12.setCellStyle(my_style3);
									cellah12.setCellValue(objTrialBalanceTransactionBean.getC0009_closingbalancebc());

									Cell cellah14 = rowah.createCell(14);
									cellah14.setCellStyle(my_style3);
									cellah14.setCellValue(objTrialBalanceTransactionBean.getC0010_openingbalancebc());

									Cell cellah15 = rowah.createCell(15);
									cellah15.setCellStyle(my_style3);
									cellah15.setCellValue(objTrialBalanceTransactionBean.getC0010_totalbccredit());
									// dTotalDebitAmt = dTotalDebitAmt +
									// objTrialBalanceBean.getC0008_totalbccredit();

									Cell cellah16 = rowah.createCell(16);
									cellah16.setCellStyle(my_style3);
									cellah16.setCellValue(objTrialBalanceTransactionBean.getC0010_totalbcdebit());
									// dTotalCreditAmt = dTotalCreditAmt +
									// objTrialBalanceBean.getC0008_totalbcdebit();

									Cell cellah17 = rowah.createCell(17);
									cellah17.setCellStyle(my_style3);
									cellah17.setCellValue(objTrialBalanceTransactionBean.getC0010_closingbalancebc());

									Cell cellah18 = rowah.createCell(18);
									cellah18.setCellStyle(my_style3);
									cellah18.setCellValue(objTrialBalanceTransactionBean.getC0011_openingbalancebc());

									Cell cellah19 = rowah.createCell(19);
									cellah19.setCellStyle(my_style3);
									cellah19.setCellValue(objTrialBalanceTransactionBean.getC0011_totalbccredit());
									// dTotalDebitAmt = dTotalDebitAmt +
									// objTrialBalanceBean.getC0008_totalbccredit();

									Cell cellah20 = rowah.createCell(20);
									cellah20.setCellStyle(my_style3);
									cellah20.setCellValue(objTrialBalanceTransactionBean.getC0011_totalbcdebit());
									// dTotalCreditAmt = dTotalCreditAmt +
									// objTrialBalanceBean.getC0008_totalbcdebit();

									Cell cellah21 = rowah.createCell(21);
									cellah21.setCellStyle(my_style3);
									cellah21.setCellValue(objTrialBalanceTransactionBean.getC0011_closingbalancebc());

									Cell cellah22 = rowah.createCell(22);
									cellah22.setCellStyle(my_style3);
									cellah22.setCellValue(objTrialBalanceTransactionBean.getC0012_openingbalancebc());

									Cell cellah23 = rowah.createCell(23);
									cellah23.setCellStyle(my_style3);
									cellah23.setCellValue(objTrialBalanceTransactionBean.getC0012_totalbccredit());
									// dTotalDebitAmt = dTotalDebitAmt +
									// objTrialBalanceBean.getC0008_totalbccredit();

									Cell cellah24 = rowah.createCell(24);
									cellah24.setCellStyle(my_style3);
									cellah24.setCellValue(objTrialBalanceTransactionBean.getC0012_totalbcdebit());
									// dTotalCreditAmt = dTotalCreditAmt +
									// objTrialBalanceBean.getC0008_totalbcdebit();

									Cell cellah25 = rowah.createCell(25);
									cellah25.setCellStyle(my_style3);
									cellah25.setCellValue(objTrialBalanceTransactionBean.getC0012_closingbalancebc());
									System.out.println(objTrialBalanceTransactionBean.getC0012_closingbalancebc());

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

			}

			// Create total row

			Row rowTotal = excelSheet.createRow((short) record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style2);
			rowTotal.createCell(1).setCellStyle(my_style2);
			rowTotal.createCell(2).setCellStyle(my_style2);
			rowTotal.createCell(3).setCellStyle(my_style2);
			rowTotal.createCell(4).setCellStyle(my_style2);
			rowTotal.createCell(5).setCellStyle(my_style2);

			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style2);
			cellah1.setCellValue("Total");

			Cell cellah6 = rowTotal.createCell(7);
			cellah6.setCellStyle(my_style2);
			cellah6.setCellValue(C0008credit);

			System.out.println("Tri"+ C0008credit);
			Cell cellah7 = rowTotal.createCell(8);
			cellah7.setCellStyle(my_style2);
			cellah7.setCellValue(C0008debit);

			Cell cellah8 = rowTotal.createCell(9);
			cellah8.setCellStyle(my_style2);
			cellah8.setCellValue(C0008debit - C0008credit);

			Cell cellah9 = rowTotal.createCell(11);
			cellah9.setCellStyle(my_style2);
			cellah9.setCellValue(C0009credit);
			System.out.println("Tri1"+ C0009credit);

			Cell cellah10 = rowTotal.createCell(12);
			cellah10.setCellStyle(my_style2);
			cellah10.setCellValue(C0009debit);

			Cell cellah11 = rowTotal.createCell(13);
			cellah11.setCellStyle(my_style2);
			cellah11.setCellValue(C0009debit - C0009credit);

			Cell cellah12 = rowTotal.createCell(15);
			cellah12.setCellStyle(my_style2);
			cellah12.setCellValue(C0010credit);
			System.out.println("Tri2"+ C0010credit);

			Cell cellah13 = rowTotal.createCell(16);
			cellah13.setCellStyle(my_style2);
			cellah13.setCellValue(C0010debit);

			Cell cellah14 = rowTotal.createCell(17);
			cellah14.setCellStyle(my_style2);
			cellah14.setCellValue(C0010debit - C0010credit);

			Cell cellah15 = rowTotal.createCell(19);
			cellah15.setCellStyle(my_style2);
			cellah15.setCellValue(C0011credit);
			System.out.println("Tri3"+ C0011credit);

			Cell cellah16 = rowTotal.createCell(20);
			cellah16.setCellStyle(my_style2);
			cellah16.setCellValue(C0011debit);

			Cell cellah17 = rowTotal.createCell(21);
			cellah17.setCellStyle(my_style2);
			cellah17.setCellValue(C0011debit - C0011credit);

			Cell cellah18 = rowTotal.createCell(23);
			cellah18.setCellStyle(my_style2);
			cellah18.setCellValue(C0012credit);
			System.out.println("Tri4"+ C0012credit);

			Cell cellah19 = rowTotal.createCell(24);
			cellah19.setCellStyle(my_style2);
			cellah19.setCellValue(C0012debit);

			Cell cellah20 = rowTotal.createCell(25);
			cellah20.setCellStyle(my_style2);
			cellah20.setCellValue(C0012debit - C0012credit);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelWithPlain(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/TrialBalanceWithPlain.xls";

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
			url = path + "/TrialBalanceWithPlain.xls";
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

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/TrialBalance.xls";

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
			url = path + "/TrialBalance.xls";
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

	private String writeExcelNew(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/TrialBalanceReport.xls";

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
			url = path + "/TrialBalanceReport.xls";
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

	/*@Override
	public List<TrialBalanceBean> getTrialBalanceSGList2(TrialBalanceBean trialBalanceBean) {
		// TODO Auto-generated method stub
		return trialBalanceDAO.getTrialBalanceSGList2(trialBalanceBean);
	}*/

	/*@Override
	public List<SelectivityBean> getAccountList() {
		// TODO Auto-generated method stub
		return trialBalanceDAO.getAccountList();
	}*/
	@Override
	public TrialBalanceBean pdfExportNew(TrialBalanceBean tbreport, String exportFilesPath) {
//		List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceList(trialBalanceBean);

		// DetentionTariffBean bean = new DetentionTariffBean();
		List<TrialBalanceBean> Listbean = new ArrayList<>();
		try {
			// ServletContext context1 = request.getServletContext();
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/TrialBalance.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("TrialBalance");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);

			
			document.open();

			
			List<TrialBalanceBean> lTrialBalanceList = trialBalanceDAO.getTrialBalanceListRPSplit(tbreport);

			if (tbreport.getCompanyCode().equalsIgnoreCase("ALL")) {
				Listbean = trialBalanceDAO.getTrialBalanceList(tbreport);
			} else {
				Listbean = trialBalanceDAO.getTrialBalanceList1(tbreport);
			}

			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD, new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph("Trial Balance \n",bfBold123);
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
			    
			    

			//	  DecimalFormat df = new DecimalFormat("0.00");

				   document.add(table);
			    
		//		   double C0008debit = 0.0, C0008credit = 0.0, C0009debit = 0.0, C0009credit = 0.0, C0010debit = 0.0, C0010credit = 0.0, C0011debit = 0.0, C0011credit = 0.0, C0012debit = 0.0, C0012credit = 0.0;

				   //specify column widths
				   float[] columnWidths = {6f, 5f,5f,4f,5f,4f,5f,4f,5f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				   DecimalFormat df = new DecimalFormat("0.00");
				 
				   //insert column headings
				   insertCell(table1, "PARTICULARS", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "GROUP", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "MAIN ACCOUNT", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "SUB ACCOUNT CODE", Element.ALIGN_LEFT, 1, bfBold12);				  
				   insertCell(table1, "SUB ACCOUNT NAME", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "OPENING BALANCE", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "DEBIT", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "CREDIT", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table1, "CLOSING BALANCE", Element.ALIGN_LEFT, 1, bfBold12);
/*				   insertCell(table1, "AMOUNT", Element.ALIGN_RIGHT, 1, bfBold12);
*/
				  
				   table1.setHeaderRows(1);

				   //insert an empty row
				  /* insertCell(table1, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table1, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);*/
				   double credit=0, opening=0, debit = 0;
				    
				   //just some random data to fill 
				   for(TrialBalanceBean detail : Listbean){
				     
				 
					   BaseColor color = BaseColor.BLACK;
			
					   if (detail.getSubGroupCode()==null)
						   detail.setSubGroupCode("");
					   if (detail.getSubGroupName()==null)
						   detail.setSubGroupName("");;
					  
					 
					   
					   if (detail.getTotalBCDebit()==null)
						   detail.setC0010_debitAmount("");
					   if (detail.getC0010_creditAmount()==null)
						   detail.setC0010_creditAmount("");
					   if(detail.getSubAccountName()==null)
						   detail.setSubAccountName("");
					   if(detail.getSubAccountCode()==null)
						   detail.setSubAccountCode("");
					
				
					   insertCell(table1, "" +detail.getSubGroupCode() + "-" + detail.getSubGroupName()+"" , Element.ALIGN_LEFT,color, 1, bf12);
					   insertCell(table1, "" +detail.getSubAccountName()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getAcctHeadId()+"" , Element.ALIGN_CENTER,color, 1, bf12);
		//			   insertCell(table1, "" +detail.getCostCenter()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getSubAccountCode()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getSubAccountName()+"" , Element.ALIGN_CENTER,color, 1, bf12); 
					   insertCell(table1, "" +df.format(detail.getOpeningBalance())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
					   insertCell(table1, "" +df.format(detail.getDebitAmount())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
					    insertCell(table1, "" +df.format(detail.getCreditAmount())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
					    insertCell(table1, "" +df.format(detail.getCurrentBalance())+"" , Element.ALIGN_RIGHT,color, 1, bf12);   
						
					  
					    
					    debit = debit + detail.getDebitAmount();
					    credit = credit + detail.getDebitAmount();
					    opening = credit-debit ;
					    //			    insertCell(table1, "" +detail.getTotalBCCredit()+"" , Element.ALIGN_RIGHT,color, 1, bf12);   

					   
		//			    double totaldebit = dTotalDebitAmt + dTotaldebitcurrentliab + dLoandebit + dintercompdebit + directincomedebit + indirectincdebit + dmiscexpdebit + dfixedassetdebit + directexpdebit + indirectexpdebit + totaldebitpandl;

		//				double totalcredit = dTotalCreditAmt + dTotalcreditcurrentliab + dLoancredit + dintercompcredit + directincomecredit + indirectinccredit + dmiscexpcredit + dfixedassetcredit + directexpcredit + indirectexpcredit + totalcreditpandl;
					   
					  /*  if (detail.getTotalBCCredit()==null)
							   detail.setTotalBCCredit("");
					   insertCell(table1, "Total", Element.ALIGN_RIGHT, 1, bfBold12);
					   insertCell(table1, df.format(detail.getTotalBCCredit()), Element.ALIGN_RIGHT, 1, bfBold12);
					    */
					   
				   }
				   
				  // for(TrialBalanceBean detailxv : lTrialBalanceList){


				   insertCell(table1, "TOTAL", Element.ALIGN_LEFT, 6, bfBold12);
				   insertCell(table1, df.format(debit), Element.ALIGN_RIGHT, 1, bfBold12);
				   insertCell(table1, df.format(credit), Element.ALIGN_RIGHT, 1, bfBold12);
				   insertCell(table1, df.format(opening), Element.ALIGN_RIGHT, 1, bfBold12);

				   //}
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


	         tbreport.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbreport;
	
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