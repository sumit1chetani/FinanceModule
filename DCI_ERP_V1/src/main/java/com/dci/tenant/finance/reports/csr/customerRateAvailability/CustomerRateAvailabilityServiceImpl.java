package com.dci.tenant.finance.reports.csr.customerRateAvailability;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerRateAvailabilityServiceImpl implements CustomerRateAvailabilityService{

	@Autowired
	CustomerRateAvailabilityDAO customerRateAvailabilityDAO;
	
	@Override
	public List<Map<String, Object>> getCustomerRateAvailReportData(CustomerRateAvailabilityBean objCRABean) {
		return customerRateAvailabilityDAO.getCustomerRateAvailReportData(objCRABean);
	}


	@Override
	public void exportCRAExcel(List<Map<String, Object>> listCRAReportData, CustomerRateAvailabilityBean craBeanObj,
			String filePath) {

		try {
			// Blank workbook
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("Customer Rate Availability");
			sheet.setZoom(4, 5);
			sheet.setFitToPage(true);
			sheet.createFreezePane(0, 2);

			XSSFColor color_red = getXSSFColor("FF0000");
			XSSFColor color_blue = getXSSFColor("336699");
			XSSFColor light_red = getXSSFColor("FA5858");

			Font font1 = wb.createFont();
			XSSFCellStyle style1 = wb.createCellStyle();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial Black");
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			((XSSFFont) font1).setColor(color_red);
			font1.setUnderline(XSSFFont.U_SINGLE);
			style1.setWrapText(true);
			style1.setFont(font1);
			style1.setAlignment(CellStyle.ALIGN_CENTER);

			XSSFCellStyle style2 = wb.createCellStyle();
			Font font2 = wb.createFont();
			font2.setFontHeight((short) 200);
			font2.setFontName("Arial Black");
			font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
			((XSSFFont) font2).setColor(color_blue);
			font2.setUnderline(XSSFFont.U_SINGLE);
			style2.setFont(font2);
			style2.setWrapText(true);
			style2.setAlignment(CellStyle.ALIGN_CENTER);

			XSSFCellStyle style3 = wb.createCellStyle();
			Font font3 = wb.createFont();
			font3.setFontHeight((short) 200);
			font3.setFontName("Arial Black");
			font3.setUnderline(XSSFFont.U_SINGLE);
			((XSSFFont) font3).setColor(color_red);
			style3.setFont(font3);
			style3.setWrapText(true);
			style3.setAlignment(CellStyle.ALIGN_CENTER);

			// set main header
			int headerCount = setExcelMainHeader(wb, sheet, style1, style2, style3,listCRAReportData);
			System.out.println("HEADER::::::::;COUNT::::::;;"+headerCount);
			// set Data
			setExcelRows(wb, sheet, listCRAReportData);

			for (int colIndex = 0; colIndex < headerCount; colIndex++) {
				sheet.autoSizeColumn(colIndex);
			}
			// export excell
			WriteExcel(wb, filePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	


	


	private int setExcelMainHeader(XSSFWorkbook wb, XSSFSheet sheet, XSSFCellStyle style1, XSSFCellStyle style2, XSSFCellStyle style3,
			List<Map<String, Object>> listCRAReportData) {
		int headerCount= 0;
		try {
			
			Row row1 = sheet.createRow((short) 0);
			Cell cell1 = row1.createCell((short) 0);
			cell1.setCellStyle(style2);
			cell1.setCellValue("Customer Rate Availability");
			
			int record=0;
			Row row2 = sheet.createRow((short) 1);
			for (Map<String, Object> rowObj : listCRAReportData) {
				Cell cell2 = row2.createCell((short) 0);
			    cell2.setCellStyle(style3);
			    cell2.setCellValue("Sl No");
				for(String key : rowObj.keySet()) {
					//String value = rowObj.get(key).toString();
				    Cell cell3 = row2.createCell((short) record++);
				    cell3.setCellStyle(style3);
				    System.out.println(key);
				    cell3.setCellValue(key.replace("'", ""));	
				    headerCount++;
				}
				record=0;
				break;
			}
			
			sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) headerCount));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return headerCount;
	}

	private void setExcelRows(XSSFWorkbook wb, XSSFSheet sheet, List<Map<String, Object>> listCRAReportData) {
		int record = 2, sno = 1, cellRecord=0;
		try {

			for (Map<String, Object> craBeanObj : listCRAReportData) {

				Row row1 = sheet.createRow((short) record++);
				row1.setHeight((short) 350);

				Cell cell1 = row1.createCell((short) 0);
				cell1.setCellValue(sno++);
					for(String key : craBeanObj.keySet()) {
						cell1 = row1.createCell((short) cellRecord++);
						if(craBeanObj.get(key)!=null){
							String value = craBeanObj.get(key).toString();
							cell1.setCellValue(value);	
						}else{
							cell1.setCellValue("");
						}						
					}
					cellRecord=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void WriteExcel(XSSFWorkbook myWorkBook, String filePath) {
		String l_str_file_out = filePath + "/CustomerRateAvailability.xls";
		System.out.println("filePath::::::::::::::"+filePath);
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
	protected static XSSFColor getXSSFColor(String RGB) {

		int red = Integer.parseInt(RGB.substring(0, 2), 16);
		int green = Integer.parseInt(RGB.substring(2, 4), 16);
		int blue = Integer.parseInt(RGB.substring(4, 6), 16);

		return new XSSFColor(new byte[] { (byte) red, (byte) green, (byte) blue });
	}

}
