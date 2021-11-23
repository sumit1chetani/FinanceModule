package com.dci.tenant.finance.reports.sailings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/sailingsreport")
public class SailingsReportController {

	private final static Logger LOGGER = LoggerFactory.getLogger(SailingsReportController.class);
	private int excelRowNum = 0;
	@Autowired
	private SailingsReportService sailingReportService;

	@RequestMapping(value = "/getCompanyList")
	public @ResponseBody List<SelectivityBean> getCompanyList() throws CustomException {
		List<SelectivityBean> lcompanyList = new ArrayList<SelectivityBean>();

		try {
			lcompanyList = sailingReportService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lcompanyList;
	}

	@RequestMapping(value = "/getSailingReports", method = RequestMethod.POST)
	public @ResponseBody SailingsReportResultBean getSailingsReport(@RequestBody SailingsReportBean sailingsReportBean) {
		List<SailingsReportBean> sailingsReportBeanList = new ArrayList<SailingsReportBean>();
		SailingsReportResultBean objSailingsReportResultBean = new SailingsReportResultBean();
		try {
			try {
				sailingsReportBeanList = sailingReportService.getSailingsReport(sailingsReportBean);
				objSailingsReportResultBean.setSailingsReportList(sailingsReportBeanList);
				objSailingsReportResultBean.setSuccess(true);
			} catch (Exception e) {
				objSailingsReportResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objSailingsReportResultBean;
	}

	@RequestMapping(value = "/excelExport")
	public @ResponseBody SailingsReportResultBean getExcelExportList(@RequestBody SailingsReportBean sailingsReportBean, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		SailingsReportResultBean sailingsReportResultBean = new SailingsReportResultBean();

		try {
			System.out.println("Sailing report excel");
			SailingsReportBean sailingsReportBeanWeek = null;
			if (sailingsReportBean.getWeek() != null && !sailingsReportBean.getWeek().trim().isEmpty()) {
				sailingsReportBeanWeek = sailingReportService.getWeek(sailingsReportBean.getWeek(),sailingsReportBean.getYear());
			} else {
				sailingsReportBeanWeek = sailingsReportBean;
			}
			excellExport(sailingReportService.getSailingsReport(sailingsReportBean), sailingsReportBeanWeek, ConfigurationProps.exportFilesPath,
					sailingReportService.getVoyageCompletionList(sailingsReportBean));
			sailingsReportResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sailingsReportResultBean;
	}

	public void excellExport(List<SailingsReportBean> sailingsReportBeanList, SailingsReportBean sailingsReportBean, String filePath,
			List<SailingsReportBean> voyageCompletionReportBeanList) {
		FileInputStream fileInputStream = null;

		try {
			// Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();
			/*
			 * XSSFPalette palette = workbook.getCustomPalette();
			 * palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 0, // RGB
			 * red (byte) 32, // RGB green (byte) 96 // RGB blue );
			 */
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			// my_style.setFillBackgroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			// HSSFColor myColor = palette.findSimilarColor(225, 219, 255);
			// my_style.setFillForegroundColor(myColor.getIndex());
			// my_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.BLUE.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			XSSFCellStyle title = workbook.createCellStyle();
			title.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			title.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			title.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			title.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			title.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			title.setAlignment(my_style.ALIGN_CENTER);
			// XSSFColor myColor3 = palette.findSimilarColor(167, 204, 239);
			my_style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 230, 209)));
			my_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			Font titleFont = workbook.createFont();
			titleFont.setFontHeight((short) 200);
			titleFont.setFontName("Arial");
			titleFont.setColor(HSSFColor.BLUE.index);
			titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titleFont.setFontHeightInPoints((short) 15);
			title.setFont(titleFont);

			XSSFCellStyle my_style1 = workbook.createCellStyle();
			// my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			// my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
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
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			Font fonts = workbook.createFont();

			fonts.setFontName("Arial");
			fonts.setFontHeight((short) 200);
			fonts.setColor(HSSFColor.RED.index);
			fonts.setBoldweight(Font.BOLDWEIGHT_BOLD);
			// font3.setfonts
			fonts.setFontHeightInPoints((short) 12);
			my_style3.setFont(fonts);

			XSSFCellStyle my_style6 = workbook.createCellStyle();
			// my_style6.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			// my_style6.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			Font font6 = workbook.createFont();

			font6.setFontName("Arial");
			font6.setFontHeight((short) 200);
			font6.setColor(HSSFColor.BLUE.index);
			font6.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font6.setFontHeightInPoints((short) 12);
			my_style6.setFont(font6);

			XSSFCellStyle my_style7 = workbook.createCellStyle();
			my_style7.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			Font font7 = workbook.createFont();

			font7.setFontName("Arial");
			font7.setFontHeight((short) 200);
			font7.setColor(HSSFColor.BLUE.index);
			font7.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font7.setFontHeightInPoints((short) 10);
			my_style7.setFont(font7);

			/**
			 * Style For Focus on differentiate Income or Expenses
			 */
			XSSFCellStyle my_style4 = workbook.createCellStyle();
			my_style4.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			Font font2 = workbook.createFont();

			font2.setFontName("Arial");
			font2.setFontHeight((short) 200);
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);
			my_style4.setFont(font2);

			XSSFCellStyle my_style5 = workbook.createCellStyle();
			my_style5.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			Font font3 = workbook.createFont();

			font3.setFontName("Arial");
			font3.setFontHeight((short) 200);
			font3.setColor(HSSFColor.BLUE.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);
			my_style5.setFont(font3);

			XSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style8.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			// HSSFColor myColor1 = palette.findSimilarColor(255, 199, 147);
			// my_style8.setFillForegroundColor(myColor1.getIndex());
			my_style8.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 199, 147)));
			my_style8.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			Font font4 = workbook.createFont();

			font4.setFontName("Arial");
			font4.setFontHeight((short) 200);
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);
			my_style8.setFont(font4);

			// Create a blank sheet
			XSSFSheet excelSheet = workbook.createSheet("Sailings Report");
			excelRowNum = voyageCompletionReportBeanList.size();
			// set main header
			setExcelMainHeader(excelSheet, my_style, sailingsReportBean, title);
			setVoyageComletionHeader(excelSheet, my_style8);
			setVoyageCompletionRow(workbook, excelSheet, voyageCompletionReportBeanList, my_style2, my_style3, my_style4, my_style5, my_style6,
					my_style8);

			setExcelHeader(excelSheet, my_style8);
			setExcelRows(workbook, excelSheet, sailingsReportBeanList, my_style2, my_style3, my_style4, my_style5, my_style6, my_style8);

			// export excell
			writeExcel(workbook, filePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, SailingsReportBean sailingsReportBean, XSSFCellStyle title) {
		int record = 3, sno = 1;

		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 700);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				0, // last row (0-based)
				0, // first column (0-based)
				9 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));

		String weekNo = "";
		if (sailingsReportBean.getWeekNo() != null && !sailingsReportBean.getWeekNo().isEmpty()) {
			weekNo = " WEEK # " + sailingsReportBean.getWeekNo();
		}
		cell.setCellValue("SAILING REPORT" + weekNo);
		cell.setCellStyle(my_style);

		Row row1 = excelSheet.createRow((short) 1);
		row1.setHeight((short) 600);
		Cell cell2 = row1.createCell((short) 0);
		cell2.setCellValue("Voyages Completed between " + sailingsReportBean.getFromDate() + " to " + sailingsReportBean.getToDate());
		cell2.setCellStyle(my_style);

	}

	public void setVoyageComletionHeader(XSSFSheet excelSheet, XSSFCellStyle my_style8) {
		try {

			Row row1 = excelSheet.createRow((short) 2);
			excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SL.NO.");
			excelSheet.setColumnWidth(0, (short) ((30 * 3) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SECTOR");
			excelSheet.setColumnWidth(0, (short) ((30 * 5) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("VESSEL");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));
			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("VOYAGE");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("COMMENCE DATE");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("COMPLETION DATE");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("VOYAGE STATUS");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setVoyageCompletionRow(XSSFWorkbook workbook, XSSFSheet excelSheet, List<SailingsReportBean> sailingsReportBeanList,
			XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5, XSSFCellStyle my_style6,
			XSSFCellStyle my_style8) {
		int record = 3, sno = 1;
		try {

			for (SailingsReportBean sailingsReportBeanObj : sailingsReportBeanList) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sno++);

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getSectorName());
				excelSheet.setColumnWidth(1, (short) ((30 * 10) / ((double) 1 / 20)));
				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVesselName());
				excelSheet.setColumnWidth(2, (short) ((30 * 10) / ((double) 1 / 20)));

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVoyage());
				excelSheet.setColumnWidth(3, (short) ((30 * 10) / ((double) 1 / 20)));
				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVoyageCommenceDt());
				excelSheet.setColumnWidth(4, (short) ((30 * 10) / ((double) 1 / 20)));
				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVoyageCompletionDt());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVoyageStatus());

			}

			/*
			 * for (int i = 0; i < 4; i++) { excelSheet.autoSizeColumn(i); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style8) {
		try {
			excelRowNum = excelRowNum + 5;
			Row row1 = excelSheet.createRow((short) excelRowNum);
			// excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);
			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SL.NO.");
			// excelSheet.setColumnWidth(0, (short) ((30 * 3) / ((double) 1 /
			// 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("WEEK");
			// excelSheet.setColumnWidth(0, (short) ((30 * 5) / ((double) 1 /
			// 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("VOYAGE");
			// excelSheet.setColumnWidth(2, (short) ((30 * 5) / ((double) 1 /
			// 20)));
			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("POL");
			// excelSheet.setColumnWidth(3, (short) ((30 * 5) / ((double) 1 /
			// 20)));
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("POD");
			// excelSheet.setColumnWidth(4, (short) ((30 * 5) / ((double) 1 /
			// 20)));
			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SECTOR");
			excelSheet.setColumnWidth(5, (short) ((30 * 15) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SAILING DATE");
			excelSheet.setColumnWidth(6, (short) ((30 * 10) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 7);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("3rd-PARTY/SFPL");
			excelSheet.setColumnWidth(7, (short) ((30 * 12) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 8);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("ACTIVITY TYPE");
			excelSheet.setColumnWidth(8, (short) ((30 * 12) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 9);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("VESSEL OPERATOR");
			excelSheet.setColumnWidth(9, (short) ((30 * 10) / ((double) 1 / 20)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, List<SailingsReportBean> sailingsReportBeanList, XSSFCellStyle my_style2,
			XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5, XSSFCellStyle my_style6, XSSFCellStyle my_style8) {
		int record = excelRowNum + 1, sno = 1;
		try {

			for (SailingsReportBean sailingsReportBeanObj : sailingsReportBeanList) {
				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sno++);

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getWeek());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVoyage());

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getPol());

				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getPod());

				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getSectorName());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getSailingDate());

				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getThirdPartyOrSsf());

				cell1 = row1.createCell((short) 8);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getActivityType());

				cell1 = row1.createCell((short) 9);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getVesselOperator());

			}
			for (int i = 0; i < 13; i++) {
				if (i == 5 || i == 7 || i == 8 || i == 10 || i == 11 || i == 12) {
					excelSheet.autoSizeColumn(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeExcel(XSSFWorkbook workbook, String filePath) {
		String l_str_file_out = filePath + "/SailingReport.xlsx";
		FileOutputStream fileOut = null;
		// System.out.println("filepath" + l_str_file_out);
		try {
			fileOut = new FileOutputStream(l_str_file_out);
			workbook.write(fileOut);
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

}