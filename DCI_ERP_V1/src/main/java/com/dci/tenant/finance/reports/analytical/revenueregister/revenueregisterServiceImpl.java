package com.dci.tenant.finance.reports.analytical.revenueregister;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.ReportHeaderBean;
import com.dci.common.util.CustomException;

@Service
public class revenueregisterServiceImpl implements revenueregisterService {

	@Autowired
	revenueregisterDAO operationBudgetDAO;

	@Override
	public List<revenueregister> getRevenueReport(revenueregister objrevenueregister) throws CustomException, SQLException {
		// TODO Auto-generated method stub
		return operationBudgetDAO.geRevenueRegisterList(objrevenueregister);
	}

	@Override
	public void excellexport(revenueregisterResultBean objWholeData, String filepath, String fileNme) {

		try {
			// Create HSSFWork Book
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle mainHeaderStyle = workbook.createCellStyle();
			mainHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			mainHeaderStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			Font font = workbook.createFont();

			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.BLACK.index);
			font.setFontHeightInPoints((short) 15);

			mainHeaderStyle.setFont(font);

			/**
			 * Style For Focus on SubHeader
			 */

			XSSFCellStyle subHeaderStyle = workbook.createCellStyle();
			subHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			subHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			subHeaderStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.BLACK.index);
			font1.setFontHeightInPoints((short) 10);
			subHeaderStyle.setFont(font1);

			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("RevenueRegister");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle, objWholeData);
			setExcelRows(excelsheet, workbook, objWholeData, subHeaderStyle);
			String fileName = null;
			if (fileNme != null) {
				fileName = fileNme;
			} else {
				fileName = "RevenueRegister";
			}
			writeExcel(workbook, filepath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, revenueregisterResultBean objWholeData, XSSFCellStyle subHeaderStyle) {
		List<revenueregister> lrevenuebean = objWholeData.getLrevenueregisterlist();
		try {
			/**
			 * Content
			 */
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font1.setFontHeightInPoints((short) 10);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle merge_style = workbook.createCellStyle();
			Font fontmerge = workbook.createFont();
			fontmerge.setFontHeight((short) 200);
			fontmerge.setFontName("Arial");
			fontmerge.setColor(HSSFColor.BLACK.index);
			fontmerge.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			fontmerge.setFontHeightInPoints((short) 10);
			my_style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
			merge_style.setFont(fontmerge);

			my_style2.setFont(font1);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			/**
			 * Number Aligned
			 */
			XSSFCellStyle my_style3 = workbook.createCellStyle();
			Font font2 = workbook.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial");
			font2.setColor(HSSFColor.BLACK.index);
			font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
			font2.setFontHeightInPoints((short) 10);

			my_style3.setFont(font2);
			my_style3.setWrapText(true);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			/**
			 * Sub Total and Grand Total
			 */

			XSSFCellStyle totalStyle = workbook.createCellStyle();
			Font font3 = workbook.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial");
			font3.setColor(HSSFColor.BLACK.index);
			font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font3.setFontHeightInPoints((short) 10);

			totalStyle.setFont(font3);
			totalStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			totalStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle totalStyle1 = workbook.createCellStyle();
			Font font4 = workbook.createFont();
			font4.setFontHeight((short) 200);
			font4.setFontName("Arial");
			font4.setColor(HSSFColor.BLACK.index);
			font4.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font4.setFontHeightInPoints((short) 10);

			totalStyle1.setFont(font4);
			totalStyle1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			totalStyle1.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			totalStyle1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			
			CellStyle cellDateStyle = workbook.createCellStyle();
			CreationHelper createHelper = workbook.getCreationHelper();
			cellDateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));
			cellDateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellDateStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellDateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			
			XSSFCellStyle cellStyle2 = workbook.createCellStyle();
	        cellStyle2.setWrapText(true);
	        cellStyle2.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
	        cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);
			
			int rCount = 5;

			for (int i = 0; i < lrevenuebean.size(); i++) {
				Row row = excelsheet.createRow( rCount);
				List<ReportHeaderBean> header = objWholeData.getLrevenueheaderlist();

				for (int j = 0; j < header.size(); j++) {

					Cell cell;
					
					if (header.get(j).getId().equals("customerCode")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCustomerCode());
					}
					if (header.get(j).getId().equals("mloName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getMloName());
					}
					if (header.get(j).getId().equals("companyName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCompanyName());

					}
					/*if (header.get(j).getId().equals("payershortName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getPayershortName());

					}
					if (header.get(j).getId().equals("payerName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getPayerName());

					}
					if (header.get(j).getId().equals("paymentCenter")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getPaymentCenter());

					}
					if (header.get(j).getId().equals("countryName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCountryName());

					}*/
				/*	if (header.get(j).getId().equals("accountname")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getAccountname());

					}*/
					if (header.get(j).getId().equals("invoiceNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getInvoiceNo());
						System.out.println(lrevenuebean.get(i).getInvoiceNo());
					}
					/*if (header.get(j).getId().equals("quotationNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getQuotationNo());

					}*/
					if (header.get(j).getId().equals("invoiceDt")) {

						/*cell = row.createCell(j);
						cell.setCellStyle(my_style2);					
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date date = format.parse(lrevenuebean.get(i).getInvoiceDt());	
						System.out.println("date INVO9ICE ++++++++++++++" + date);
						cell.setCellValue(date);*/
						cell = row.createCell(j);
						//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						String date = lrevenuebean.get(i).getInvoiceDt();
						//Date date = format.parse(lrevenuebean.get(i).getInvoiceDt());
						System.out.println("invoice dt" +date );
						cell.setCellStyle(cellDateStyle);
						cell.setCellValue(date);
					}
						
						
					/*if (header.get(j).getId().equals("pol")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);

						cell.setCellValue(lrevenuebean.get(i).getPol());
						System.out.println(lrevenuebean.get(i).getPol());
					}
					if (header.get(j).getId().equals("pod")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getPod());
						System.out.println(lrevenuebean.get(i).getPod());
					}
					if (header.get(j).getId().equals("fpod")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getFpod());
						System.out.println(lrevenuebean.get(i).getFpod());
					}
					if (header.get(j).getId().equals("mlocode")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getMlocode());
					}*/
					if (header.get(j).getId().equals("voyageName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getVoyageName());
						System.out.println(lrevenuebean.get(i).getVoyageName());
					}
					if (header.get(j).getId().equals("jobNO")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getJobNO());
						System.out.println(lrevenuebean.get(i).getJobNO());
					}
					/*if (header.get(j).getId().equals("sectorId")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getSectorId());
						System.out.println(lrevenuebean.get(i).getSectorId());
					}
					if (header.get(j).getId().equals("sailingDate")) {

						cell = row.createCell(j);
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						if(!"".equalsIgnoreCase(CommonExcelUtils.checkEmptyString(lrevenuebean.get(i).getSailingDate()))){
						Date date = format.parse(lrevenuebean.get(i).getSailingDate());
						System.out.println("SAILING dt" +date );
						cell.setCellStyle(cellDateStyle);
						cell.setCellValue(date);
						}else{
							cell.setCellValue("-");
						}
					}
					if (header.get(j).getId().equals("Month")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getMonth());
					}
					if (header.get(j).getId().equals("activityShortName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getActivityShortName());
						System.out.println(lrevenuebean.get(i).getActivityShortName());
					}*/
					if (header.get(j).getId().equals("createdBy")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCreatedBy());
						System.out.println(lrevenuebean.get(i).getCreatedBy());
					}
					/*if (header.get(j).getId().equals("creditCategory")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCreditCategory());
						System.out.println(lrevenuebean.get(i).getCreditCategory());
					}

					if (header.get(j).getId().equals("customerType")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCustomerType());
					}

					if (header.get(j).getId().equals("category")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCategory());
						System.out.println(lrevenuebean.get(i).getCategory());
					}*/

					/*if (header.get(j).getId().equals("accountHeadName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getAccountHeadName());
						System.out.println(lrevenuebean.get(i).getAccountHeadName());
					}
					if (header.get(j).getId().equals("of_usd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getOf_usd()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getOf_usd());
					}
					if (header.get(j).getId().equals("imco_usd")) {
						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getImco_usd()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getImco_usd());
					}
					if (header.get(j).getId().equals("oog_usd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getOog_usd()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getOog_usd());
					}
					if (header.get(j).getId().equals("cbr_usd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getCbr_usd()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getCbr_usd());
					}
					if (header.get(j).getId().equals("rcr")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getRcr()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getRcr());
					}
					if (header.get(j).getId().equals("others_usd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getOthers_usd()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
						System.out.println(lrevenuebean.get(i).getOthers_usd());
					}*/
					if (header.get(j).getId().equals("tc_amount")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble((lrevenuebean.get(i).getTc_amount())));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
					}
					if (header.get(j).getId().equals("bc_amount")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getBc_amount()));
						cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
					}

				}
				rCount = rCount + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 16));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("RevenueRegister Report");

	}

	private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle, revenueregisterResultBean objWholeData) {
		try {

			Row row = excelsheet.createRow((short) 4);
			row.setHeight((short) 700);
			subHeaderStyle.setWrapText(true);
			for (int i = 0; i < 20; i++) {
				excelsheet.autoSizeColumn(i);
			}
			List<ReportHeaderBean> header = objWholeData.getLrevenueheaderlist();
			for (int i = 0; i < header.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(subHeaderStyle);
				cell.setCellValue(header.get(i).getTitle());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle
	 * subHeaderStyle) { try { int count = 0; Row row =
	 * excelsheet.createRow((short) 4); row.setHeight((short) 700);
	 * subHeaderStyle.setWrapText(true);
	 * 
	 * Cell cell = row.createCell(count); // excelsheet.addMergedRegion(new
	 * CellRangeAddress(4, 4, 0, 1)); cell.setCellValue("MLO SHORT NAME");
	 * cell.setCellStyle(subHeaderStyle);
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("COMPANY NAME");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("PAYER NAME");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("INVOICE NO");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("QUOTATION NO");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("INVOICE DATE");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("POL");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("POD");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("FPOD");
	 * 
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("VESSEL NAME"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("VOYAGE"); cell =
	 * row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("SERVICE"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("SAILING DATE");
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("MONTH"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("ACTIVITY SHORT");
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("CREATED BY"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("CUSTOMER TYPE");
	 * cell = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("CUSTOMER CATEGORY"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("CATEGORY"); cell =
	 * row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("OF_USD"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("IMCO_USD"); cell =
	 * row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("OOG_USD"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("CBR_USD"); cell =
	 * row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("RCR_USD"); cell = row.createCell(count++);
	 * cell.setCellStyle(subHeaderStyle); cell.setCellValue("OTHERS_USD"); cell
	 * = row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("AMOUNT_USD(TC_AMOUNT)"); cell =
	 * row.createCell(count++); cell.setCellStyle(subHeaderStyle);
	 * cell.setCellValue("AMOUNT(BC_AMOUNT)");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	private void writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("RevenueRegister")) {
			fileName = filePath + "/" + filePathName + ".xls";
		} else {
			fileName = filePath + "/RevenueRegister.xls";
		}

		System.out.println("file name");
		System.out.println(fileName);
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
			System.out.println(fileName);
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

	@Override
	public List<revenueregister> getportIsoCode() {
		// TODO Auto-generated method stub
		return operationBudgetDAO.getportIsoCode();
	}

	@Override
	public List<revenueregister> getpayer() {
		// TODO Auto-generated method stub
		return operationBudgetDAO.getpayer();
	}

	@Override
	public List<revenueregister> getCustomer() {
		// TODO Auto-generated method stub
		return operationBudgetDAO.getCustomer();
	}
	
}
