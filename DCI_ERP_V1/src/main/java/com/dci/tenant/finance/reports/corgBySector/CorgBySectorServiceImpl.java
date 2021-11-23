package com.dci.tenant.finance.reports.corgBySector;

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

import com.dci.common.util.CommonExcelUtils;

@Service
public class CorgBySectorServiceImpl implements CorgBySectorService {

	@Autowired
	CorgBySectorDAO CorgBySectorDAO;

	@Override
	public CorgBySectorResultBean getCorgBySectorList(CorgBySector core) throws Exception {
		// TODO Auto-generated method stub

		return CorgBySectorDAO.getCorgBySectorList(core);
	}
	
	@Override
	public CorgBySectorResultBean getcorgList(CorgBySector core) throws Exception {
		// TODO Auto-generated method stub

		return CorgBySectorDAO.getcorgList(core);
	}


	@Override
	public void excellexport(CorgBySector objrevenueregister, String filepath, String fileNme) throws Exception{
		CorgBySectorResultBean resultBean = CorgBySectorDAO.getCorgBySectorList(objrevenueregister);
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
			XSSFSheet excelsheet = workbook.createSheet("CorgBySector");
			setExcelMainHeader(excelsheet, mainHeaderStyle);
			setExcelSubHeader(excelsheet, subHeaderStyle , resultBean);
		    setExcelRows(excelsheet, workbook, resultBean, subHeaderStyle);
			String fileName = null;
			if (fileNme != null) {
				fileName = fileNme;
			} else {
				fileName = "CorgBySector";
			}
			writeExcel(workbook, filepath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private void setExcelRows(XSSFSheet excelsheet, XSSFWorkbook workbook, CorgBySectorResultBean objWholeData, XSSFCellStyle subHeaderStyle) {
		try {
			/**
			 * Content
			 */
			List<Object> detail = objWholeData.getDetail();
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
			List<String> header = objWholeData.getHeader();
			int rCount = 5;

			XSSFCellStyle excel = workbook.createCellStyle();
			excel.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			excel.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			excel.setBorderRight(XSSFCellStyle.BORDER_THIN);
			excel.setBorderTop(XSSFCellStyle.BORDER_THIN);
			excel.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			for (int i = 0;i < detail.size();i++) {
				int count = 0;
				Row row = excelsheet.createRow(rCount);
				List dd =  (List) detail.get(i);
				Cell cell;
				for(int j = 0 ; j < header.size() ; j ++)
				{
					 cell = row.createCell(j);
				cell.setCellStyle(my_style2);
				if(j == 0 || j == 1){
					cell.setCellValue(checkData(String.valueOf(dd.get(j))));
				}else{
					cell.setCellStyle(excel);
					cell.setCellValue(Integer.parseInt(CommonExcelUtils.checkEmptyStringToZero(String.valueOf(dd.get(j)))));
				} 
			
				}
				rCount = rCount + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String checkData(String value) {
		try {
			value = value == null || value.equals("null") || value.trim().isEmpty() ? "" : value;
		} catch (Exception e) {

			return "";
		}

		return value;
	}
	private void setExcelSubHeader(XSSFSheet excelsheet, XSSFCellStyle subHeaderStyle, CorgBySectorResultBean objWholeData) {
		try {

			Row row = excelsheet.createRow(4);
			row.setHeight((short) 700);
			subHeaderStyle.setWrapText(true);
			for (int i = 0; i < 20; i++) {
				excelsheet.autoSizeColumn(i);
			}
		
			List<String> header = objWholeData.getHeader();
		      for (int i = 0; i < header.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(subHeaderStyle);
				System.out.println("header list");
				System.out.println(header.get(i));
			    cell.setCellValue(header.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void writeExcel(XSSFWorkbook workbook, String filePath, String filePathName) {
		String fileName = null;
		if (!filePathName.equals("CorgBySector")) {
			fileName = filePath + "/" + filePathName + ".xlsx";
		} else {
			fileName = filePath + "/CorgBySector.xlsx";
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

	private void setExcelMainHeader(XSSFSheet excelsheet, XSSFCellStyle mainHeaderstyle) {
		Row row = excelsheet.createRow(0);
		excelsheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 10));
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(mainHeaderstyle);
		cell.setCellValue("CORG By Sector Wise");

	}
	


}