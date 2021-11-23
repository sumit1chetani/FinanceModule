package com.dci.tenant.finance.reports.customeranalysis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
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
@RequestMapping(value = "{tenantid}/app/customerAnalysis")
public class CustomerAnalysisController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CustomerAnalysisController.class);
	@Autowired
	private CustomerAnalysisService customerAnalysisService;

	@RequestMapping(value = "/getCompanyList")
	public @ResponseBody List<SelectivityBean> getCompanyList() throws CustomException {
		List<SelectivityBean> lcompanyList = new ArrayList<SelectivityBean>();

		try {
			lcompanyList = customerAnalysisService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lcompanyList;
	}
	
	@RequestMapping(value = "/getMLO")
	public @ResponseBody List<CustomerAnalysisBean> getmlo() throws CustomException {
		List<CustomerAnalysisBean> lcompanyList = new ArrayList<CustomerAnalysisBean>();

		try {
			lcompanyList = customerAnalysisService.getMLO();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return lcompanyList;
	}

	@RequestMapping(value = "/getCustomerAnalysisReport", method = RequestMethod.POST)
	public @ResponseBody CustomerAnalysisResultBean getCustomerAnalysisReport(@RequestBody CustomerAnalysisBean customerAnalysisBean) {
		List<CustomerAnalysisBean> customerAnalysisBeanList = new ArrayList<CustomerAnalysisBean>();
		CustomerAnalysisResultBean objCustomerAnalysisResultBean = new CustomerAnalysisResultBean();
		try {
			try {
				customerAnalysisBeanList = customerAnalysisService.getCustomerAnalysisReport(customerAnalysisBean);
				objCustomerAnalysisResultBean.setCustomerAnalysisReportList(customerAnalysisBeanList);
				objCustomerAnalysisResultBean.setSuccess(true);
			} catch (Exception e) {
				objCustomerAnalysisResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objCustomerAnalysisResultBean;
	}

	@RequestMapping(value = "/excelExport")
	public @ResponseBody CustomerAnalysisResultBean getExcelExportList(@RequestBody CustomerAnalysisBean customerAnalysisBean, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		CustomerAnalysisResultBean customerAnalysisResultBean = new CustomerAnalysisResultBean();

		try {
			System.out.println("customer analysis report excel");
			/*CustomerAnalysisBean customerAnalysisBeanBeanWeek = null;
			if (customerAnalysisBean.getWeek() != null && !customerAnalysisBean.getWeek().trim().isEmpty()) {
				customerAnalysisBeanBeanWeek = customerAnalysisService.getWeek(customerAnalysisBean.getWeek(),customerAnalysisBean.getYear());
			} else {
				customerAnalysisBeanBeanWeek = customerAnalysisBean;
			}*/
			excellExport(customerAnalysisService.getCustomerAnalysisReport(customerAnalysisBean), null, ConfigurationProps.exportFilesPath);
			customerAnalysisResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return customerAnalysisResultBean;
	}
	@RequestMapping(value = "/rateAgainstExcel")
	public @ResponseBody CustomerAnalysisResultBean rateAgainstExcel(@RequestBody CustomerAnalysisBean customerAnalysisBean, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		CustomerAnalysisResultBean customerAnalysisResultBean = new CustomerAnalysisResultBean();

		try {
			customerAnalysisService.rateAgainstExcel(customerAnalysisBean,ConfigurationProps.exportFilesPath);
			customerAnalysisResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return customerAnalysisResultBean;
	}
	@RequestMapping(value = "/rateJvAgainstExcel")
	public @ResponseBody CustomerAnalysisResultBean rateJvAgainstExcel(@RequestBody CustomerAnalysisBean customerAnalysisBean, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		CustomerAnalysisResultBean customerAnalysisResultBean = new CustomerAnalysisResultBean();

		try {
			customerAnalysisService.rateJvAgainstExcel(customerAnalysisBean,ConfigurationProps.exportFilesPath);
			customerAnalysisResultBean.setSuccess(true);
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return customerAnalysisResultBean;
	}
	
	public void excellExport(List<CustomerAnalysisBean> customerAnalysisReportBeanList, CustomerAnalysisBean customerAnalysisBean, String filePath
			) {
		FileInputStream fileInputStream = null;

		try {
			// Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setAlignment(my_style.ALIGN_CENTER);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.BROWN.index);
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
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font3.setFontHeightInPoints((short) 10);
			my_style5.setFont(font3);

			XSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style8.setAlignment(HSSFCellStyle.ALIGN_CENTER);
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
			XSSFSheet excelSheet = workbook.createSheet("Customer Analysis Report");
			// set main header
			setExcelMainHeader(excelSheet, my_style, customerAnalysisBean, title);
			setVoyageComletionHeader(excelSheet, my_style8);
			setVoyageCompletionRow(workbook, excelSheet, customerAnalysisReportBeanList, my_style2, my_style3, my_style4, my_style5, my_style6,
					my_style8);

			// export excell
			writeExcel(workbook, filePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, CustomerAnalysisBean customerAnalysisBean, XSSFCellStyle title) {
		int record = 3, sno = 1;

		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 700);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				0, // last row (0-based)
				0, // first column (0-based)
				7 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
	//	excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 7));
/*
		String month = "";
		if (customerAnalysisBean.getMonthName() != null && !customerAnalysisBean.getMonthName().isEmpty() && !customerAnalysisBean.getMonthName().equals("ALL")) {
			month = " MONTH # " + customerAnalysisBean.getMonthName();
		}*/
		
		cell.setCellValue("CUSTOMER ANALYSIS REPORT - 2016 ");
		cell.setCellStyle(my_style);

		

	}

	public void setVoyageComletionHeader(XSSFSheet excelSheet, XSSFCellStyle my_style8) {
		try {

			Row row1 = excelSheet.createRow((short) 1);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("SL.NO.");
			excelSheet.setColumnWidth(0, (short) ((30 * 4) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("CUSTOMER");
			excelSheet.setColumnWidth(1, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("TEUS 2016");
			excelSheet.setColumnWidth(2, (short) ((30 * 6) / ((double) 1 / 20)));
			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("TEUS 2015");
			excelSheet.setColumnWidth(3, (short) ((30 * 6) / ((double) 1 / 20)));
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("REV 2016");
			excelSheet.setColumnWidth(4, (short) ((30 * 6) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("REV 2015");
			excelSheet.setColumnWidth(5, (short) ((30 * 6) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("REV PER TEUS 2016");
			excelSheet.setColumnWidth(6, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 7);
			cell1.setCellStyle(my_style8);
			cell1.setCellValue("REV PER TEUS 2015");
			excelSheet.setColumnWidth(7, (short) ((30 * 7) / ((double) 1 / 20)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setVoyageCompletionRow(XSSFWorkbook workbook, XSSFSheet excelSheet, List<CustomerAnalysisBean> customerAnalysisReportBeanList,
			XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5, XSSFCellStyle my_style6,
			XSSFCellStyle my_style8) {
		int record = 2, sno = 1;
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			for (CustomerAnalysisBean sailingsReportBeanObj : customerAnalysisReportBeanList) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sno++);

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(sailingsReportBeanObj.getCustomer());
				excelSheet.setColumnWidth(1, (short) ((30 * 10) / ((double) 1 / 20)));
				
				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(sailingsReportBeanObj.getTeus2016());
				excelSheet.setColumnWidth(2, (short) ((30 * 6) / ((double) 1 / 20)));

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(sailingsReportBeanObj.getTeus2015());
				excelSheet.setColumnWidth(3, (short) ((30 *6) / ((double) 1 / 20)));
				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(Double.valueOf(df.format(sailingsReportBeanObj.getRev2016())));
				excelSheet.setColumnWidth(4, (short) ((30 * 6) / ((double) 1 / 20)));
				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(Double.valueOf(df.format(sailingsReportBeanObj.getRev2015())));

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(sailingsReportBeanObj.getRev_per_teus2016());
				
				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style5);
				cell1.setCellValue(sailingsReportBeanObj.getRev_per_teus2015());

			}

		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private static void writeExcel(XSSFWorkbook workbook, String filePath) {
		String l_str_file_out = filePath + "/Customer_Analysis_Report.xlsx";
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