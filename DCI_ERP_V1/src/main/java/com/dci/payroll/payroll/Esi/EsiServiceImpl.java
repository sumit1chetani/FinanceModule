package com.dci.payroll.payroll.Esi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dci.tenant.user.UserDetail;

@Service
public class EsiServiceImpl implements EsiService {
	@Autowired
	EsiDAO esidao;

	@Override
	public List<EsiBean> getESIList(EsiBean esiBean) throws Exception {
		return esidao.getESIList(esiBean);
	}

	@Override
	public boolean insertEsiList(ArrayList<EsiBean> esiBean) throws Exception {
		// TODO Auto-generated method stub
		return esidao.insertEsiList(esiBean);
	}

	/*@Override
	public void exportExcel(ArrayList<EsiBean> esiBeanList, String filePath) throws IOException, Exception {
		List<EsiBean> esiList = esiBeanList;
		String number = " ";
		HSSFWorkbook wb = new HSSFWorkbook();

		Sheet sheet1 = wb.createSheet("employeeesi");
		sheet1.setZoom(4, 5);
		CellStyle style = wb.createCellStyle();
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setFontHeight((short) 200);
		font.setFontName("Arial");
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		sheet1.setFitToPage(true);
		sheet1.setMargin((short) 0, 0.20);
		sheet1.setMargin((short) 1, 0.20);
		sheet1.setMargin((short) 2, 0.20);
		sheet1.setMargin((short) 3, 0.20);
		PrintSetup ps = sheet1.getPrintSetup();
		ps.setFitHeight((short) 1);
		ps.setFitWidth((short) 1);
		ps.setFooterMargin(0);
		ps.setLandscape(true);
		ps.setLeftToRight(true);
		ps.setScale((short) 100);
		ps.setPaperSize((short) 9);
		ps.setHeaderMargin(0);
		int rowNumber = 0;
		// heading row

		Row row1 = sheet1.createRow((short) rowNumber);
		org.apache.poi.ss.usermodel.Cell cell;
		setHeading(wb, style);
		cell = row1.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("IP Number ");

		cell = row1.createCell((short) 1);
		cell.setCellStyle(style);
		cell.setCellValue("IP Name");

		cell = row1.createCell((short) 2);
		cell.setCellStyle(style);
		cell.setCellValue("No of Days for which wages paid/payable during the month");

		cell = row1.createCell((short) 3);
		cell.setCellStyle(style);
		cell.setCellValue("Total Monthly Wages");

		cell = row1.createCell((short) 4);
		cell.setCellStyle(style);
		cell.setCellValue(" Reason Code for Zero workings days");

		cell = row1.createCell((short) 5);
		cell.setCellStyle(style);
		cell.setCellValue(" Last Working Day( Format DD/MM/YYYY  or DD-MM-YYYY)");

		sheet1.setColumnWidth((short) 0, (short) ((50 * 8) / ((double) 1 / 20)));

		for (EsiBean esiBean : esiList) {
			rowNumber += 1;
			Row row = sheet1.createRow((short) rowNumber);

			cell = row.createCell((short) 0);
			cell.setCellValue(esiBean.getEsicCode());
			cell = row.createCell((short) 1);
			cell.setCellValue(esiBean.getEmployeeId());
			cell = row.createCell((short) 2);
			cell.setCellValue(esiBean.getDays());
			cell = row.createCell((short) 3);
			cell.setCellValue(esiBean.getWages());

		}

		for (int i = 0; i < 10; i++) {
			sheet1.autoSizeColumn(i);
		}
		Random r = new Random();
		number = String.valueOf(r.nextInt()).substring(1, 3);
		writeExcel(wb, filePath);
	}
*/
/*	private void setHeading(HSSFWorkbook wb, CellStyle cellStyle) {
		org.apache.poi.ss.usermodel.Font font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("Aharoni");
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_NORMAL);
		font.setFontHeightInPoints((short) 11);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setFont(font);
		cellStyle.setWrapText(false);

	}*/
/*
	private void writeExcel(HSSFWorkbook wb, String filePath) {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}*/

	
	
	
	@Override
	public void exportExcel(ArrayList<EsiBean> esiBeanList, String filePath) throws IOException, Exception {
		List<EsiBean> esiList = esiBeanList;

		//XSSFWorkbook workbook = new XSSFWorkbook();
		

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
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);

			HSSFCellStyle my_stylenew = workbook.createCellStyle();

			my_stylenew.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew.setAlignment(my_stylenew.ALIGN_LEFT);

			Font fontnew = workbook.createFont();

			fontnew.setFontName("Arial");
			fontnew.setColor(HSSFColor.BLACK.index);
			fontnew.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontnew.setFontHeightInPoints((short) 10);
			my_stylenew.setFont(fontnew);

			HSSFCellStyle my_stylenew1 = workbook.createCellStyle();
			my_stylenew1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_stylenew1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_stylenew1.setAlignment(my_stylenew.ALIGN_LEFT);

			Font fontnew1 = workbook.createFont();

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
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
			//XSSFSheet excelSheet = workbook.createSheet("BL  REPORT");
			HSSFSheet excelSheet = workbook.createSheet("Employee Esi");

			// set main header
			/*setExcelMainHeader(excelSheet, my_style, my_style4);
			// set header
			setExcelHeader(excelSheet, my_style5);
*/
			// set Data
		/*	setExcelRows(workbook, excelSheet,lTrialBalanceList,
					my_style2, my_style3, my_style4, my_style5, my_style6, my_style7,
					my_style8);*/

			while (workbook.getNumberOfSheets() > 1)
				workbook.removeSheetAt(0);

			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);
			setExcelRows(excelSheet, esiList, my_stylenew, my_stylenew1, my_style3);

			
			for (int i = 0; i < 9; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			//String sFileUrl = writeExcel(workbook, exportFilesPath);
			String sFileUrl = writeExcel(workbook, filePath);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return;
	}


	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		Date currentDate = new Date();

		String sOutFile = path + "Employeeesi.xls";

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
			url = sOutFile;
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
	private void setExcelRows(HSSFSheet excelSheet, List<EsiBean> esiList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 2, sno = 1;
			int	firstSgRow =0;
		int lastRow = 0;

		Double totalBuy = 0.0,totalSell = 0.0,total = 0.0;
		
		try {

			for (EsiBean billofLading : esiList) {

				Row row1 = excelSheet.createRow((short) record++);
				row1.setHeight((short) 350);
				firstSgRow = record;

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(billofLading.getEsicCode());
				//row1.createCell(0).setCellStyle(my_style2);

				cell1 = row1.createCell((short) 1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(billofLading.getEmployeeId());

				cell1 = row1.createCell((short) 2);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(billofLading.getDays());

				//row.createCell(2).setCellStyle(my_style2);
				//row.createCell(5).setCellStyle(my_style2);
				cell1 = row1.createCell((short) 3);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(billofLading.getWages());

			

				
				//setlTBAccountHeadLevelList
				
			
			
			
			}
			
			
			//setMergingStyle(record, my_style4, 0, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			Row row = excelSheet.createRow((short) 1);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("IP Number");
			
			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("IP Name");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("No of Days for which wages paid/payable during the month");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Total Monthly Wages");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Reason Code for Zero workings days");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Last Working Day( Format DD/MM/YYYY  or DD-MM-YYYY)");

		

			




			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);
		excelSheet.addMergedRegion(new CellRangeAddress(0, // first row
															// (0-based)
				0, // last row (0-based)
				0, // first column (0-based)
				8 // last column (0-based)
		));

		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Employee ESi Report");
		cell.setCellStyle(my_style);
		//setMergingStyle(row, my_style, 1, 7);
	}

	private void setMergingStyle(Row row, XSSFCellStyle my_style, int start, int end) {
		for (int i = start; i <= end; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(my_style);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
