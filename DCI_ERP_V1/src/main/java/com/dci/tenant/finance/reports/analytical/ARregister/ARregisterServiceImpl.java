package com.dci.tenant.finance.reports.analytical.ARregister;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
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
public class ARregisterServiceImpl implements ARregisterService {

	@Autowired
	ARregisterDAO arregisterDao;

	@Override
	public List<ARregister> getARReport(ARregister objarRegister) throws CustomException {
		// TODO Auto-generated method stub
		return arregisterDao.getARregister(objarRegister);
	}

	@Override
	public void excellexport(ARregisterResultBean objWholeData, String filepath, String fileNme) {

		try {
			// Create HSSFWork Book
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFCellStyle mainHeaderStyle = workbook.createCellStyle();
			mainHeaderStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			mainHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

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
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setColor(HSSFColor.BLACK.index);
			font1.setFontHeightInPoints((short) 10);
			subHeaderStyle.setFont(font1);

			// Create a blank sheet
			XSSFSheet excelsheet = workbook.createSheet("ARRegister");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle, objWholeData);
			setExcelRows(excelsheet, workbook, objWholeData, subHeaderStyle);
			String fileName = null;
			if (fileNme != null) {
				fileName = fileNme;
			} else {
				fileName = "ARRegister";
			}
			writeExcel(workbook, filepath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, ARregisterResultBean objWholeData, XSSFCellStyle subHeaderStyle) {
		List<ARregister> lrevenuebean = objWholeData.getlARregisterlists();
		System.out.println("lrevenuebean+++++++++++++++++++++" + lrevenuebean);
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

			int rCount = 5;

			for (int i = 0; i < lrevenuebean.size(); i++) {
				Row row = excelsheet.createRow((short) rCount);
				List<ReportHeaderBean> header = objWholeData.getGetheaderList();
				System.out.println("headerlist+++inside ++++++++++++++++++" + header);
				for (int j = 0; j < header.size(); j++) {

					Cell cell;

					/*
					 * public String payer; public String grp_invoice_no; public
					 * String grp_invoice_dt; public String balance;// amt
					 * public String balance_usd;// amount usd public String
					 * voyage; public String pol; public String pod; public
					 * String sailingDt; public String aging; public String
					 * mloname; public String servicename; public String
					 * country; public String mloCity;
					 */
					if (header.get(j).getId().equals("payer")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getPayer());
					}
					if (header.get(j).getId().equals("grp_invoice_no")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getGrp_invoice_no());

					}
					if (header.get(j).getId().equals("grp_invoice_dt")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getGrp_invoice_dt());

					}
					if (header.get(j).getId().equals("balance")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getBalance()));
					}
					if (header.get(j).getId().equals("balance_usd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(lrevenuebean.get(i).getBalance_usd()));

					}
					if (header.get(j).getId().equals("voyage")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getVoyage());
						System.out.println(lrevenuebean.get(i).getVoyage());
					}
					if (header.get(j).getId().equals("pol")) {

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
					if (header.get(j).getId().equals("sailingDt")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getSailingDt());
						System.out.println(lrevenuebean.get(i).getSailingDt());
					}
					if (header.get(j).getId().equals("aging")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(lrevenuebean.get(i).getAging());
						System.out.println(lrevenuebean.get(i).getAging());
					}
/*					if (header.get(j).getId().equals("customerShortName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCustomerShortName());
						System.out.println(lrevenuebean.get(i).getCustomerShortName());
					}*/
					if (header.get(j).getId().equals("servicename")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getServicename());
						System.out.println(lrevenuebean.get(i).getServicename());
					}
					if (header.get(j).getId().equals("country")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getCountry());
						System.out.println(lrevenuebean.get(i).getCountry());
					}
					if (header.get(j).getId().equals("mloCity")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lrevenuebean.get(i).getMloCity());
						System.out.println(lrevenuebean.get(i).getMloCity());
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
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 14));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("ARRegister Report");

	}

	private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle, ARregisterResultBean objWholeData) {
		try {

			Row row = excelsheet.createRow((short) 4);
			row.setHeight((short) 700);
			subHeaderStyle.setWrapText(true);
			for (int i = 0; i < 20; i++) {
				excelsheet.autoSizeColumn(i);
			}

			List<ReportHeaderBean> header = objWholeData.getGetheaderList();
			System.out.println("print the list ++++++++++++++++++ " + objWholeData.getGetheaderList());
			for (int i = 0; i < header.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(subHeaderStyle);
				cell.setCellValue(header.get(i).getTitle());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("ARRegister")) {
			fileName = filePath + "/" + filePathName + ".xlsx";
		} else {
			fileName = filePath + "/ARRegister.xlsx";
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
}
