package com.dci.tenant.finance.reports.auditTrial.SingleInvoice;

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

@Service
public class SingleInvoiceAuditTrialServiceImpl implements SingleInvoiceAuditTrialService {

	@Autowired
	SingleInvoiceAuditTrialDAO singleInvoiceAuditTrialDAO;

	@Override
	public List<SingleInvoiceAuditTrialBean> getSingleInvoiceList(SingleInvoiceAuditTrialBean invoiceAuditTrialBean) {
		return singleInvoiceAuditTrialDAO.getSingleInvoiceList(invoiceAuditTrialBean);
	}

	@Override
	public void excelExport(List<SingleInvoiceAuditTrialBean> singleInvoiceList, String path) {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFCellStyle my_style = workbook.createCellStyle();
		my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		my_style.setAlignment(my_style.ALIGN_CENTER);
		my_style.setFillForegroundColor(HSSFColor.WHITE.index);
		my_style.setFillPattern(my_style.SOLID_FOREGROUND);
		Font font = workbook.createFont();
		font.setFontHeight((short) 350);
		font.setFontName("Arial");
		font.setColor(HSSFColor.GREEN.index);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 17);
		my_style.setFont(font);

		HSSFCellStyle style = workbook.createCellStyle();
		style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		style.setAlignment(style.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(style.SOLID_FOREGROUND);
		Font font1 = workbook.createFont();
		font1.setFontHeight((short) 300);
		font1.setFontName("Arial");
		font1.setColor(HSSFColor.BLACK.index);
		font1.setBoldweight((short) 25);
		font1.setFontHeightInPoints((short) 10);
		style.setFont(font1);
		HSSFCellStyle my_style2 = workbook.createCellStyle();
		my_style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		my_style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		my_style2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		my_style2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		Font innerFont = workbook.createFont();
		innerFont.setFontHeight((short) 200);
		innerFont.setFontName("Arial");
		innerFont.setColor(HSSFColor.BLACK.index);
		innerFont.setFontHeightInPoints((short) 10);
		my_style2.setFont(innerFont);

		HSSFCellStyle my_style3 = workbook.createCellStyle();
		my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		my_style3.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		my_style3.setAlignment(my_style3.ALIGN_CENTER);
		my_style3.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		my_style3.setFillPattern(my_style3.SOLID_FOREGROUND);
		Font font3 = workbook.createFont();
		font3.setFontHeight((short) 350);
		font3.setFontName("Arial");
		font3.setColor(HSSFColor.RED.index);
		font3.setFontHeightInPoints((short) 12);
		font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
		my_style3.setFont(font3);
		// Create a blank sheet
		HSSFSheet excelSheet = workbook.createSheet("SIAuditTrial");

		// set header
		setExcelHeader(excelSheet, style);

		setExcelRows(excelSheet, singleInvoiceList, my_style2, my_style3);

		setExcelMainHeader(excelSheet, my_style);

		for (int i = 0; i < 20; i++) {
			excelSheet.autoSizeColumn(i);
		}

		writeExcel(workbook, path);
	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				2, // last row (0-based)
				0, // first column (0-based)
				10 // last column (0-based)
				));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("SINGLE INVOICE AUDIT TRIAL");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row headerRow = excelSheet.createRow((short) 3);
			headerRow.setHeight((short) 400);

			Cell headerCell = headerRow.createCell((short) 0);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("INVOICE NO");

			headerCell = headerRow.createCell((short) 1);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("INVOICE DATE");

			headerCell = headerRow.createCell((short) 2);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("CUSTOMER");

			headerCell = headerRow.createCell((short) 3);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("MODE");

			headerCell = headerRow.createCell((short) 4);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("JOB Order NO");

			headerCell = headerRow.createCell((short) 5);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("POL/AOL");

			headerCell = headerRow.createCell((short) 6);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("POD/AOD");

			headerCell = headerRow.createCell((short) 7);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("QUOTATION");

			headerCell = headerRow.createCell((short) 8);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("SAILING DATE/ARRIVAL DATE");

			headerCell = headerRow.createCell((short) 9);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("CREATED BY");

			headerCell = headerRow.createCell((short) 10);
			headerCell.setCellStyle(my_style1);
			headerCell.setCellValue("CREATED DATE");
			// excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeExcel(HSSFWorkbook myWorkBook, String path) {
		String filePath = path + "/SIAuditTrial.xls";
		FileOutputStream fileOut = null;
		System.out.println("filepath" + filePath);
		try {
			fileOut = new FileOutputStream(filePath);
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

	public void setExcelRows(HSSFSheet excelSheet, List<SingleInvoiceAuditTrialBean> invoiceList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int rowCount = 4;
		int prevRowCount = 4;
		String voyageId = "";
		try {

			for (int i = 0; i < 9; i++) {
				excelSheet.autoSizeColumn(i);
			}
			for (SingleInvoiceAuditTrialBean objDtlList : invoiceList) {

				Row row1 = excelSheet.createRow((short) rowCount);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getInvoiceNo());

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getInvoiceDate());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getPayerName());

				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style2);
				if(objDtlList.getVessel().equals("1")){
					objDtlList.setVessel("SEA");
				}else if(objDtlList.getVessel().equals("2")){
					objDtlList.setVessel("AIR");
				}
				cell1.setCellValue(objDtlList.getVessel());

				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getVoyage());

				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getPol());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getPod());

				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getQuotationNo());

				cell1 = row1.createCell((short) 8);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getSailingDate());

				cell1 = row1.createCell((short) 9);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getCreatedName());

				cell1 = row1.createCell((short) 10);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(objDtlList.getCreatedDate());

				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SingleInvoiceAuditTrialBean> getEmployeeList() {
		// TODO Auto-generated method stub
		return singleInvoiceAuditTrialDAO.getEmployeeList();
	}

}
