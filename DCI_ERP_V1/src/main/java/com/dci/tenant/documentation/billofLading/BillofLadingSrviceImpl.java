package com.dci.tenant.documentation.billofLading;

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

import com.dci.common.model.SelectivityBean;


@Service
public class BillofLadingSrviceImpl implements BillofLadingService {
	@Autowired
	BillofLadingDao billofLadingDao;


	@Override
	public BillofLadingBean insert(BillofLadingBean billofLading) throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.insert(billofLading);
	}

	@Override
	public List<SelectivityBean> getDropDown() {
		// TODO Auto-generated method stub
		return billofLadingDao.getDropDown();
	}

	@Override
	public List<BillofLadingBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.getList();
	}

	@Override
	public XSSFWorkbook excellExport(List<BillofLadingBean> blList, BillofLadingBean billofLading, String pdfFile) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		try {
			// Blank workbook
			// HSSFWorkbook workbook = new HSSFWorkbook();

			
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
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
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
			XSSFSheet excelSheet = workbook.createSheet("BL  REPORT");

			// set main header
			setExcelMainHeader(excelSheet, my_style, billofLading, my_style4);
			// set header
			setExcelHeader(excelSheet, my_style5);

			// set Data
			setExcelRows(workbook, excelSheet, blList, my_style2, my_style3, my_style4, my_style5, my_style6,
					my_style7, my_style8);

			// export excell
			writeExcel(workbook, pdfFile);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return workbook;
			
	}

	private void writeExcel(XSSFWorkbook myWorkBook, String filePath) {
		String l_str_file_out = filePath + "/ExportBL.xlsx";
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

	private void setExcelRows(XSSFWorkbook workbook, XSSFSheet excelSheet, List<BillofLadingBean> blreport,
			XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4, XSSFCellStyle my_style5,
			XSSFCellStyle my_style6, XSSFCellStyle my_style7, XSSFCellStyle my_style8) {
		int record = 2, sno = 1;
		try {

			for (BillofLadingBean billofLading : blreport) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getBlNo());

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getBookingNo());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getIssuePlace());


				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getIssueDate());
				
				

				cell1 = row1.createCell((short) 4);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getOnBoard());
				
				cell1 = row1.createCell((short) 5);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getReceiptAt());

				cell1 = row1.createCell((short) 6);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getPol());
				
				cell1 = row1.createCell((short) 7);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getPod());

				cell1 = row1.createCell((short) 8);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getPot());
				
				cell1 = row1.createCell((short) 9);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getFpod());
				
				cell1 = row1.createCell((short) 10);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getTerms());
				
				cell1 = row1.createCell((short) 11);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getNoBls());
				
				cell1 = row1.createCell((short) 12);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getRef());
				
				cell1 = row1.createCell((short) 13);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getVslVoyage());
				
				cell1 = row1.createCell((short) 14);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getmVoyage());
				
				cell1 = row1.createCell((short) 15);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getLoadType());
				
				cell1 = row1.createCell((short) 16);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getService());
				
				cell1 = row1.createCell((short) 17);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getReleasedstr());
				
				cell1 = row1.createCell((short) 18);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getClient());
				
				cell1 = row1.createCell((short) 19);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getJobNo());
				
				cell1 = row1.createCell((short) 20);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getAgent());
				
				cell1 = row1.createCell((short) 21);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getRemarks());
				
				cell1 = row1.createCell((short) 22);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getShipment());
				
				cell1 = row1.createCell((short) 23);
				cell1.setCellStyle(my_style4);
				cell1.setCellValue(billofLading.getStatus());
				/*
				 * for (int i = 0; i < 11; i++) { if (i == 4 || i == 7 || i == 9
				 * | i == 10) { excelSheet.autoSizeColumn(i); } }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row1 = excelSheet.createRow((short) 1);
			excelSheet.createFreezePane(0, 2);
			row1.setHeight((short) 350);

			Cell cell1 = row1.createCell((short) 0);


			cell1.setCellStyle(my_style1);
			cell1.setCellValue("B/L No");
			excelSheet.setColumnWidth(0, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Booking No");
			excelSheet.setColumnWidth(1, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 2);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Issue Place");
			excelSheet.setColumnWidth(2, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 3);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Issue Date");
			excelSheet.setColumnWidth(3, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 4);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Onboard");
			excelSheet.setColumnWidth(4, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 5);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("ReceiptAt");
			excelSheet.setColumnWidth(5, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 6);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("POL");
			excelSheet.setColumnWidth(6, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 7);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("POD");
			excelSheet.setColumnWidth(7, (short) ((30 * 7) / ((double) 1 / 20)));

			cell1 = row1.createCell((short) 8);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("POT");
			excelSheet.setColumnWidth(8, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 9);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("FPOD");
			excelSheet.setColumnWidth(9, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 10);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Terms");
			excelSheet.setColumnWidth(10, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 11);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("NO BLS");
			excelSheet.setColumnWidth(11, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 12);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("REF");
			excelSheet.setColumnWidth(12, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 13);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("VslVoyage");
			excelSheet.setColumnWidth(13, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 14);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("MVoyage");
			excelSheet.setColumnWidth(14, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 15);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Load Type");
			excelSheet.setColumnWidth(15, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 16);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Service");
			excelSheet.setColumnWidth(16, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 17);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Released");
			excelSheet.setColumnWidth(17, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 18);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Client");
			excelSheet.setColumnWidth(18, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 19);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Job No");
			excelSheet.setColumnWidth(19, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 20);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Agent");
			excelSheet.setColumnWidth(20, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 21);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Remarks");
			excelSheet.setColumnWidth(21, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 22);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Shipment");
			excelSheet.setColumnWidth(22, (short) ((30 * 7) / ((double) 1 / 20)));
			
			cell1 = row1.createCell((short) 23);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Status");
			excelSheet.setColumnWidth(23, (short) ((30 * 7) / ((double) 1 / 20)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(XSSFSheet excelSheet, XSSFCellStyle my_style, BillofLadingBean billofLading,
			XSSFCellStyle my_style4) {
		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				0, // last row (0-based)
				0, // first column (0-based)
				24 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		cell.setCellValue("BILL OF LADDING REPORT");
		cell.setCellStyle(my_style);
		setMergingStyle(row, my_style, 1, 24);
	}

	private void setMergingStyle(Row row, XSSFCellStyle cellStyle, int start, int end) {
		for (int i = start; i <= end; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
		}
	}

	@Override
	public BillofLadingBean print(String blNo) {
		// TODO Auto-generated method stub
		return billofLadingDao.print(blNo);
	}

	@Override
	public List<BillofLadingBean> getBlList() throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.getBlList();
	}

	@Override
	public BillofLadingBean getBlEdit(String blNo) {
		// TODO Auto-generated method stub
		return billofLadingDao.getBlEdit(blNo);
	}

	@Override
	public BillofLadingBean delete(String blNo) {
		// TODO Auto-generated method stub
		return billofLadingDao.delete(blNo);
	}

	@Override
	public BillofLadingBean update(BillofLadingBean billofLading)
			throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.update(billofLading);
	}

	@Override
	public List<SelectivityBean> getIssuePlace() {
		// TODO Auto-generated method stub
		return billofLadingDao.getIssuePlace();
	}

	@Override
	public List<SelectivityBean> getAgentList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getAgentList();
	}

	@Override
	public List<SelectivityBean> getBookingList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getBookingList();
	}

	@Override
	public List<SelectivityBean> shipmentList() {
		// TODO Auto-generated method stub
		return billofLadingDao.shipmentList();
	}

	@Override
	public List<SelectivityBean> getConatinerTypeList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getConatinerTypeList();
	}

	@Override
	public List<SelectivityBean> getPackageTypeList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getPackageTypeList();
	}

	@Override
	public List<SelectivityBean> getSurChargeList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getSurChargeList();
	}

	@Override
	public List<SelectivityBean> getContainerList() {
		// TODO Auto-generated method stub
		return billofLadingDao.getContainerList();
	}

	@Override
	public BillofLadingResultBean printBL(String blNo) {
		// TODO Auto-generated method stub
		return billofLadingDao.printBL(blNo);
	}
	
	@Override
	public List<BillofLadingBean> printDetailList(String blNo) {
		// TODO Auto-generated method stub
		return billofLadingDao.printDetailList(blNo);
	}
	
	@Override
	public Integer seqPrint(String blNo, String printStatus) throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.seqPrint(blNo, printStatus);
	}
	
	@Override
	public BillofLadingResultBean getcountPrint(String blNo, String printStatus) throws Exception {
		// TODO Auto-generated method stub
		return billofLadingDao.getcountPrint(blNo, printStatus);
	}
}
