package com.dci.tenant.finance.report.tripPandL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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
public class TripPandLServiceImpl implements TripPandLService  {

	@Autowired
	TripPandLDAO DailyVehicleReportDAO;

	@Override
	public TripPandLResultBean getTruckList() {

		return DailyVehicleReportDAO.getTruckList();
	}
	
	
	@Override
	public TripPandLResultBean getList(TripPandLBean bean) {
		// TODO Auto-generated method stub
		return DailyVehicleReportDAO.getList(bean);
	}


	@Override
	public TripPandLBean exportDailyVehivleReportExcel(String sFilePath, TripPandLBean dailyVehicleReport) {
		
		TripPandLBean dailyloadingBean = new TripPandLBean();


		try {

			
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			
			HSSFCellStyle style = workbook.createCellStyle();
			style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			style.setBorderBottom(HSSFCellStyle.BORDER_NONE);
			style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			style.setAlignment(style.ALIGN_LEFT);
			style.setFillForegroundColor(HSSFColor.WHITE.index);
			style.setFillPattern(style.SOLID_FOREGROUND);
			Font font0 = workbook.createFont();
			font0.setFontHeight((short) 200);
			font0.setFontName("Arial");
			font0.setColor(HSSFColor.BLACK.index);
			font0.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font0.setFontHeightInPoints((short) 15);
			style.setFont(font0);
			
			
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
			my_style.setAlignment(my_style.ALIGN_LEFT);
			my_style.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.BLACK.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.BLACK.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.WHITE.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			
			HSSFCellStyle my_style_green = workbook.createCellStyle();
			my_style_green.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_green.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_green.setAlignment(my_style.ALIGN_LEFT);
			
			Font font_green = workbook.createFont();
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_green.setFont(font_green);
			
			
			HSSFCellStyle my_style_green_right_align = workbook.createCellStyle();
			my_style_green_right_align.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_green_right_align.setAlignment(my_style.ALIGN_CENTER);
			my_style_green_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
			font_green.setColor(HSSFColor.GREEN.index);
			font_green.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_green_right_align.setFont(font_green);
			
			HSSFCellStyle my_style_red = workbook.createCellStyle();
			my_style_red.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_red.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_red.setAlignment(my_style.ALIGN_LEFT);
		
			Font font_red = workbook.createFont();
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_red.setFont(font_red);
			
			
			HSSFCellStyle my_style_red_right_align = workbook.createCellStyle();
			my_style_red_right_align.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style_red_right_align.setAlignment(my_style.ALIGN_CENTER);
			my_style_red_right_align.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
			font_red.setColor(HSSFColor.RED.index);
			font_red.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style_red_right_align.setFont(font_red);
			
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
			my_style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
			
			
			HSSFCellStyle my_style4 = workbook.createCellStyle();
			my_style4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style4.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
		
			
			HSSFCellStyle my_style5 = workbook.createCellStyle();
			my_style5.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style5.setFillBackgroundColor(IndexedColors.ORANGE.getIndex());
			my_style5.setAlignment(my_style5.ALIGN_CENTER);
			my_style5.setFillForegroundColor(HSSFColor.ORANGE.index);
			my_style5.setFillPattern(my_style5.SOLID_FOREGROUND);


			HSSFCellStyle my_style6 = workbook.createCellStyle();
			my_style6.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style6.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			my_style6.setAlignment(my_style6.ALIGN_CENTER);
			my_style6.setFillForegroundColor(HSSFColor.GREEN.index);
			my_style6.setFillPattern(my_style6.SOLID_FOREGROUND);
			
			
			HSSFCellStyle my_style7 = workbook.createCellStyle();
			my_style7.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style7.setFillBackgroundColor(IndexedColors.MAROON.getIndex());
			my_style7.setAlignment(my_style7.ALIGN_CENTER);
			my_style7.setFillForegroundColor(HSSFColor.MAROON.index);
			my_style7.setFillPattern(my_style7.SOLID_FOREGROUND);

			

			HSSFCellStyle my_style8 = workbook.createCellStyle();
			my_style8.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style8.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style8.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style8.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style8.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
			my_style8.setAlignment(my_style8.ALIGN_CENTER);
			my_style8.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style8.setFillPattern(my_style8.SOLID_FOREGROUND);
			
			HSSFCellStyle my_style9 = workbook.createCellStyle();
			my_style9.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style9.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style9.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style9.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style9.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
			my_style9.setAlignment(my_style9.ALIGN_CENTER);
			my_style9.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style9.setFillPattern(my_style9.SOLID_FOREGROUND);

			HSSFCellStyle my_style10 = workbook.createCellStyle();
			my_style10.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style10.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style10.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style10.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style10.setFillBackgroundColor(IndexedColors.RED.getIndex());
			my_style10.setAlignment(my_style10.ALIGN_CENTER);
			my_style10.setFillForegroundColor(HSSFColor.RED.index);
			my_style10.setFillPattern(my_style10.SOLID_FOREGROUND);

			
			
			for (int i = 0; i < dailyVehicleReport.getTruckIdList().size(); i++) {

				TripPandLBean bean = new TripPandLBean();


				String truck = (String) dailyVehicleReport.getTruckIdList().get(i);
					
				
				List<TripPandLBean> lCDCList = DailyVehicleReportDAO.exportDailyVehicleReport(dailyVehicleReport,truck);
				
				if(!lCDCList.isEmpty()){
					
				dailyloadingBean.setData(true);

				bean= DailyVehicleReportDAO.getTruckName(dailyVehicleReport,truck);

				// Create a blank sheet
				HSSFSheet excelSheet = workbook.createSheet(bean.getTruckName());

				// set main header
				setExcelMainHeader(excelSheet, my_style,dailyVehicleReport,truck);
				
			
				// set header
				setExcelHeader(excelSheet, my_style1);
				

				// set Data
				setExcelRows(excelSheet, lCDCList, my_style1, my_style2, my_style3,my_style_green,my_style_red,my_style_green_right_align,my_style_red_right_align,my_style4,my_style5,my_style6,my_style7,my_style8,my_style9,my_style10);
				

				//set Side Table 
				
				setExcelSideTable(excelSheet, my_style,my_style1,my_style2,my_style4,my_style5,my_style6,my_style7,my_style8,my_style9,my_style10);
				

				for (int j = 0; j < 43; j++) {
					excelSheet.autoSizeColumn(j);
				}
				
			}
				
			}
			
			
//			List<DailyVehicleReportBean> lCDCList = DailyVehicleReportDAO.exportDailyVehicleReport(dailyVehicleReport);
//
//			
//			// Create a blank sheet
//			HSSFSheet excelSheet = workbook.createSheet("Daily Vehicle Report");
//
//			// set main header
//			setExcelMainHeader(excelSheet, my_style,dailyVehicleReport);
//			
//		
//			// set header
//			setExcelHeader(excelSheet, my_style1);
//			
//			
//
//			// set Data
//			setExcelRows(excelSheet, lCDCList, my_style1, my_style2, my_style3,my_style_green,my_style_red,my_style_green_right_align,my_style_red_right_align,my_style4,my_style5,my_style6,my_style7,my_style8,my_style9,my_style10);
//			
//
//			//set Side Table 
//			
//			setExcelSideTable(excelSheet, my_style,my_style1,my_style2,my_style4,my_style5,my_style6,my_style7,my_style8,my_style9,my_style10);
//			
//
//			for (int i = 0; i < 43; i++) {
//				excelSheet.autoSizeColumn(i);
//			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);
			
			dailyloadingBean.setFilePath(sFileUrl);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return dailyloadingBean;
	}

	private void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle style,TripPandLBean dailyVehicleReport,String truck) {
		
		
		TripPandLBean bean = new TripPandLBean();
		
		bean= DailyVehicleReportDAO.getTruckName(dailyVehicleReport,truck);

		
		Row row = excelSheet.createRow((short) 0);
		row.setHeight((short) 600);

		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 14));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("                                                                                              BMO Report");
		cell.setCellStyle(style);
		
		
		Row row1 = excelSheet.createRow((short) 1);
		row1.setHeight((short) 600);

		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 14));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("                                              From Date : " + dailyVehicleReport.getFromDate() + "     To Date : "+ dailyVehicleReport.getToDate() + "        Plate Number : " + bean.getTruckName());
		cell1.setCellStyle(style);
		
	}
	

	private void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			/*Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");*/
             int i=0;
 			createHeaderCell(row, my_style1, "",i);
			createHeaderCell(row, my_style1, "Customer",i++);
			createHeaderCell(row, my_style1, "From Location - To Location",i++);
			createHeaderCell(row, my_style1, "Time Start",i++);
			createHeaderCell(row, my_style1, "Time End",i++);
			createHeaderCell(row, my_style1, "Hours(HH:MI:SS)",i++);
			createHeaderCell(row, my_style1, "Status",i++);
			createHeaderCell(row, my_style1, "Trip No",i++);
			createHeaderCell(row, my_style1, "Odometer Start",i++);
			createHeaderCell(row, my_style1, "Odometer End",i++);
			createHeaderCell(row, my_style1, "Distance Travelled",i++);
			createHeaderCell(row, my_style1, "Distance Travelled / Hour",i++);
			createHeaderCell(row, my_style1, "Total Distance Travelled for this Trip",i++);
			createHeaderCell(row, my_style1, "Total Travel Hours for this Trip",i++);
			createHeaderCell(row, my_style1, "Total NonDriving Hours",i++);
			createHeaderCell(row, my_style1, "Exact Reason for Delay",i++);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
    private void setExcelSideTable(HSSFSheet excelSheet, HSSFCellStyle style,HSSFCellStyle my_style1,HSSFCellStyle my_style2,HSSFCellStyle my_style4,HSSFCellStyle my_style5,HSSFCellStyle my_style6,HSSFCellStyle my_style7,HSSFCellStyle my_style8,HSSFCellStyle my_style9,HSSFCellStyle my_style10) {
    
		Row row2 = excelSheet.getRow(2);
		 if(row2 == null){
			 row2 = excelSheet.createRow(2); 
	        }
	    	
		 
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 17, 20));
    	Cell row2cell = row2.createCell(17);
    	row2cell.setCellStyle(style);
    	row2cell.setCellValue("Operations Summary");
		
		
		Row row3 = excelSheet.getRow(3);
		 if(row3 == null){
			 row3 = excelSheet.createRow(3); 
	        }
	    	
		 excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 17, 20));
     	 Cell row3cell1 = row3.createCell(17);
     	row3cell1.setCellStyle(my_style4);
			
     	
     	Row row4 = excelSheet.getRow(4);
		 if(row4 == null){
			 row4 = excelSheet.createRow(4); 
	        }
	    	

		//excelSheet.addMergedRegion(new CellRangeAddress(4, 4, 17, 20));
    	Cell row4cell1 = row4.createCell(17);
    	row4cell1.setCellStyle(my_style4);
		
		Cell row4cell2 = row4.createCell(18);
		row4cell2.setCellStyle(my_style7);
		
		Cell row4cell3 = row4.createCell(19);
		row4cell3.setCellStyle(my_style8);
		
		Cell row4cell4 = row4.createCell(20);
		row4cell4.setCellStyle(my_style9);
     	
     	
		
		
		Row row5 = excelSheet.getRow(5);
		 if(row5 == null){
			 row5 = excelSheet.createRow(5); 
	        }
	    	
		 excelSheet.addMergedRegion(new CellRangeAddress(5, 5, 17, 20));
    	Cell row5cell1 = row5.createCell(17);
    	row5cell1.setCellStyle(my_style4);
     	
		Row row6 = excelSheet.getRow(6);
		 if(row6 == null){
			 row6 = excelSheet.createRow(6); 
	        }
	    	
		 
     	Cell row6cell1 = row6.createCell(17);
     	row6cell1.setCellStyle(my_style1);
     	row6cell1.setCellValue("Hours");
		
		Cell row6cell2 = row6.createCell(18);
		row6cell2.setCellStyle(my_style1);
		row6cell2.setCellValue("Days");
		
		Cell row6cell3 = row6.createCell(19);
		row6cell3.setCellStyle(my_style1);
		row6cell3.setCellValue("Status");
		
		Cell row6cell4 = row6.createCell(20);
		row6cell4.setCellStyle(my_style1);
		row6cell4.setCellValue("Comment");
		
		
		
		
		Row row7 = excelSheet.getRow(7);
		 if(row7 == null){
			 row7 = excelSheet.createRow(7); 
	        }
		 
		 Cell row7cell17 = row7.createCell(17);
		 row7cell17.setCellValue("381.8");
		 row7cell17.setCellStyle(my_style4);

		 
		 Cell row7cell18 = row7.createCell(18);
		 row7cell18.setCellValue("15.9");
		 row7cell18.setCellStyle(my_style4);

		 
		 Cell row7cell19 = row7.createCell(19);
		 row7cell19.setCellStyle(my_style4);
		 row7cell19.setCellValue("ID");
		 
		 Cell row7cell20 = row7.createCell(20);
		 row7cell20.setCellValue("Idle");
		 row7cell20.setCellStyle(my_style2);

		 
		 
		 
		 Row row8 = excelSheet.getRow(8);
		 if(row8 == null){
			 row8 = excelSheet.createRow(8); 
	        }
		 
		 Cell row8cell17 = row8.createCell(17);
		 row8cell17.setCellValue("97.4");
		 row8cell17.setCellStyle(my_style4);

		 
		 Cell row8cell18 = row8.createCell(18);
		 row8cell18.setCellValue("4.1");
		 row8cell18.setCellStyle(my_style4);

		 
		 Cell row8cell19 = row8.createCell(19);
		 row8cell19.setCellStyle(my_style5);
		 row8cell19.setCellValue("WC");
		 
		 Cell row8cell20 = row8.createCell(20);
		 row8cell20.setCellValue("Waiting Cargo");
		 row8cell20.setCellStyle(my_style2);

		 
		 
		 
		 Row row9 = excelSheet.getRow(9);
		 if(row9 == null){
			 row9 = excelSheet.createRow(9); 
	        }
		 
		 Cell row9cell17 = row9.createCell(17);
		 row9cell17.setCellValue("836.0");
		 row9cell17.setCellStyle(my_style4);

		 
		 Cell row9cell18 = row9.createCell(18);
		 row9cell18.setCellValue("34.8");
		 row9cell18.setCellStyle(my_style4);

		 
		 Cell row9cell19 = row9.createCell(19);
		 row9cell19.setCellStyle(my_style6);
		 row9cell19.setCellValue("OW");
		 
		 Cell row9cell20 = row9.createCell(20);
		 row9cell20.setCellValue("On the Way");
		 row9cell20.setCellStyle(my_style2);

		 
		 
		 Row row10 = excelSheet.getRow(10);
		 if(row10 == null){
			 row10 = excelSheet.createRow(10); 
	        }
		 
		 Cell row10cell17 = row10.createCell(17);
		 row10cell17.setCellValue("335.9");
		 row10cell17.setCellStyle(my_style4);

		 
		 Cell row10cell18 = row10.createCell(18);
		 row10cell18.setCellValue("14.0");
		 row10cell18.setCellStyle(my_style4);

		 
		 Cell row10cell19 = row10.createCell(19);
		 row10cell19.setCellStyle(my_style7);
		 row10cell19.setCellValue("WD");
		 
		 Cell row10cell20 = row10.createCell(20);
		 row10cell20.setCellValue("Waiting at Destination");
		 row10cell20.setCellStyle(my_style2);

		 
		 
		 Row row11 = excelSheet.getRow(11);
		 if(row11 == null){
			 row11 = excelSheet.createRow(11); 
	        }
		 
		 Cell row11cell17 = row11.createCell(17);
		 row11cell17.setCellValue("183.7");
		 row11cell17.setCellStyle(my_style4);

		 
		 Cell row11cell18 = row11.createCell(18);
		 row11cell18.setCellValue("7.7");
		 row11cell18.setCellStyle(my_style4);

		 
		 Cell row11cell19 = row11.createCell(19);
		 row11cell19.setCellStyle(my_style8);
		 row11cell19.setCellValue("OB");
		 
		 Cell row11cell20 = row11.createCell(20);
		 row11cell20.setCellValue("On the Border");
		 row11cell20.setCellStyle(my_style2);

		 
		 Row row12 = excelSheet.getRow(12);
		 if(row12 == null){
			 row12 = excelSheet.createRow(12); 
	        }
		 
		 Cell row12cell17 = row12.createCell(17);
		 row12cell17.setCellValue("22.7");
		 row12cell17.setCellStyle(my_style4);

		 
		 Cell row12cell18 = row12.createCell(18);
		 row12cell18.setCellValue("0.9");
		 row12cell18.setCellStyle(my_style4);

		 
		 Cell row12cell19 = row12.createCell(19);
		 row12cell19.setCellStyle(my_style9);
		 row12cell19.setCellValue("SM");
		 
		 Cell row12cell20 = row12.createCell(20);
		 row12cell20.setCellValue("Scheduled Maintenance");
		 row12cell20.setCellStyle(my_style2);

		
		 Row row13 = excelSheet.getRow(13);
		 if(row13 == null){
			 row13 = excelSheet.createRow(13); 
	        }
		 
		 Cell row13cell17 = row13.createCell(17);
		 row13cell17.setCellValue("0.0");
		 row13cell17.setCellStyle(my_style4);

		 
		 Cell row13cell18 = row13.createCell(18);
		 row13cell18.setCellValue("0.0");
		 row13cell18.setCellStyle(my_style4);

		 
		 Cell row13cell19 = row13.createCell(19);
		 row13cell19.setCellStyle(my_style10);
		 row13cell19.setCellValue("TP");
		 
		 Cell row13cell20 = row13.createCell(20);
		 row13cell20.setCellValue("Technical Problem");
		 row13cell20.setCellStyle(my_style2);

		 
		 
		 
		 Row row14 = excelSheet.getRow(14);
		 if(row14 == null){
			 row14 = excelSheet.createRow(14); 
	        }
		 
		 excelSheet.addMergedRegion(new CellRangeAddress(14, 14, 17, 18));
		 Cell row14cell17 = row14.createCell(17);
		 row14cell17.setCellValue("78%");
		 row14cell17.setCellStyle(my_style4);

		 
		 excelSheet.addMergedRegion(new CellRangeAddress(14, 14, 19, 20));
		 Cell row14cell18 = row14.createCell(19);
		 row14cell18.setCellValue("Truck Utilization");
		 row14cell18.setCellStyle(my_style4);

		
	}



	private Cell createHeaderCell(Row row, HSSFCellStyle style, String value, int index){
		Cell cell = row.createCell(index);
		cell.setCellStyle(style);
		cell.setCellValue(value);
		return cell;
	}
	
	private void setExcelRows(HSSFSheet excelSheet, List<TripPandLBean> lCDCList, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_style_green, HSSFCellStyle my_style_red, HSSFCellStyle my_style_green_right_align, HSSFCellStyle my_style_red_right_align,HSSFCellStyle my_style4,HSSFCellStyle my_style5,HSSFCellStyle my_style6,HSSFCellStyle my_style7,HSSFCellStyle my_style8,HSSFCellStyle my_style9,HSSFCellStyle my_style10) {
		int record = 3, sno = 1;
		try {
			
			
			String prvsTripNo="";
			String oldOdometer="";
			String oldTripStartDate="";
			String oldTripEndDate="";
			String prvsCustomer="";




			for (TripPandLBean DailyVehicleReportBean : lCDCList) {
				/*
				for (int i = 0; i < 43; i++) {
					excelSheet.autoSizeColumn(i);
				}*/
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
			
				String customer=null;
				String location=null;
				String timeStart=null;
				String timeEnd=null;
				String hour=null;
				String status=null;
				String tripNo=null;
				String odometerStart=null;
				String odometerEnd=null;
				String distanceTravaled=null;
				String distanceTravalHour=null;
				String totalDistance=null;
				String totalTravalHour=null;
				String totalNonDriveHour=null;
				String delayReason=null;
				
				
				if(prvsCustomer.equals(DailyVehicleReportBean.getCustomer())){
				
				if(!prvsTripNo.equals(DailyVehicleReportBean.getTripNo())){
					TripPandLBean dBean = new TripPandLBean();
					
					//prvsTripNo=DailyVehicleReportBean.getTripNo();
					
					if(!prvsTripNo.equalsIgnoreCase("")){
						
					
					timeStart=oldTripStartDate;
					timeEnd=DailyVehicleReportBean.getTimeStart();
					
					dBean= DailyVehicleReportDAO.getIdleHour(timeStart,timeEnd);
					
					hour="";
					status="Idle";
					odometerStart=oldOdometer;
					odometerEnd=oldOdometer; 
					dBean.setTimeStart(timeStart);
					dBean.setTimeEnd(timeEnd);
					dBean.setHour(dBean.getIdleHour());
					dBean.setStatus(status);
					dBean.setOdometerStart(odometerStart);
					dBean.setOdometerEnd(odometerEnd);
					dBean.setDistanceTravelled("");
					createCells(row, dBean, my_style1, my_style2, my_style3, my_style4, my_style5, my_style6, my_style7, my_style8, my_style9, my_style10);
					row = excelSheet.createRow((short) record++);
					row.setHeight((short) 350);
					  }
					
				} 
			}
					customer = DailyVehicleReportBean.getCustomer();
					location=DailyVehicleReportBean.getLocation();
					timeStart=DailyVehicleReportBean.getTimeStart();
					timeEnd=DailyVehicleReportBean.getTimeEnd();
					hour=DailyVehicleReportBean.getHour();
					status=DailyVehicleReportBean.getStatus();
					tripNo=DailyVehicleReportBean.getTripNo();
					odometerStart=DailyVehicleReportBean.getOdometerStart();
					odometerEnd=DailyVehicleReportBean.getOdometerEnd();
					distanceTravaled=DailyVehicleReportBean.getDistanceTravelled();
					distanceTravalHour=DailyVehicleReportBean.getDistanceTravelledHour();
					totalDistance=DailyVehicleReportBean.getTotalDistance();
					totalTravalHour=DailyVehicleReportBean.getTotalTravelHours();
					totalNonDriveHour=DailyVehicleReportBean.getTotalNonDrivingHour();
					delayReason=DailyVehicleReportBean.getExactReasonDelay();
					
					prvsTripNo=DailyVehicleReportBean.getTripNo();
					oldOdometer=DailyVehicleReportBean.getOdometerEnd();
					oldTripStartDate=DailyVehicleReportBean.getTimeStart();
					oldTripEndDate = DailyVehicleReportBean.getTimeEnd();
					//idleEndDate=DailyVehicleReportBean.getTimeStart();
					prvsCustomer=DailyVehicleReportBean.getCustomer();
					createCells(row, DailyVehicleReportBean, my_style1, my_style2, my_style3, my_style4, my_style5, my_style6, my_style7, my_style8, my_style9, my_style10);
				
			
					
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createCells(Row row, TripPandLBean dBean, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_style4,HSSFCellStyle my_style5,HSSFCellStyle my_style6,HSSFCellStyle my_style7,HSSFCellStyle my_style8,HSSFCellStyle my_style9,HSSFCellStyle my_style10){
		Cell cell1 = row.createCell(0);
		//cell1.setCellStyle(my_style2);
		cell1.setCellValue(dBean.getCustomer());
		
		Cell cell2 = row.createCell(1);
		//cell2.setCellStyle(my_style2);
		cell2.setCellValue(dBean.getLocation());

		Cell cell3 = row.createCell(2);
		//cell3.setCellStyle(my_style2);
		cell3.setCellValue(dBean.getTimeStart());

		Cell cell4 = row.createCell(3);
		//cell4.setCellStyle(my_style3);
		cell4.setCellValue(dBean.getTimeEnd());

		
		Cell cell5 = row.createCell(4);
		//cell5.setCellStyle(my_style3);
		cell5.setCellValue(dBean.getHour());

	
		Cell cell6 = row.createCell(5);
		cell6.setCellValue(dBean.getStatus());
		
		
		if (dBean.getStatus().equalsIgnoreCase("Idle")){
			cell5.setCellStyle(my_style4);
			cell6.setCellStyle(my_style4);
		}
		else if (dBean.getStatus().equalsIgnoreCase("Gate-In (WC)")){
			cell5.setCellStyle(my_style5);
			cell6.setCellStyle(my_style5);
			
		}
		else if (dBean.getStatus().equalsIgnoreCase("On the Way")){
			cell5.setCellStyle(my_style6);
			cell6.setCellStyle(my_style6);
		}
		else if (dBean.getStatus().equalsIgnoreCase("Gate-In (WD)")){
			cell5.setCellStyle(my_style7);
			cell6.setCellStyle(my_style7);
		}
		else if (dBean.getStatus().equalsIgnoreCase("On the Border")){
			cell5.setCellStyle(my_style8);
			cell6.setCellStyle(my_style8);
		}
		else if (dBean.getStatus().equalsIgnoreCase("Scheduled Maintenance")){
			cell5.setCellStyle(my_style9);
			cell6.setCellStyle(my_style9);
		}else if (dBean.getStatus().equalsIgnoreCase("Technical Problem")){
			
			cell5.setCellStyle(my_style10);
			cell6.setCellStyle(my_style10);
		}
		// New Requirment
        else if (dBean.getStatus().equalsIgnoreCase("Load Confirmation/Gate-Out")){
        	
        	cell6.setCellValue("Drive");
		}
		
        else if (dBean.getStatus().equalsIgnoreCase("Crossed Border/Gate-Out")){
        	
        	cell6.setCellValue("Drive");
		}
        else if (dBean.getStatus().equalsIgnoreCase("Arrived at the Border")){
        	
        	cell6.setCellValue("Arrived at the Border (OB)");
		}
       else if (dBean.getStatus().equalsIgnoreCase("Delivery Confirmation/Gate-Out")){
        	
        	cell6.setCellValue("Drive");
		}
		
       else if (dBean.getStatus().equalsIgnoreCase("Crossed Border/Gate-Out")){
       	
       	cell6.setCellValue("Drive");
		}
		
		
		
		
		Cell cell7 = row.createCell(6);
		//cell7.setCellStyle(my_style_green_right_align);
		cell7.setCellValue(dBean.getTripNo());
		
		Cell cell8 = row.createCell(7);
		//cell8.setCellStyle(my_style_green_right_align);
		cell8.setCellValue(dBean.getOdometerStart());
		
		Cell cell9 = row.createCell(8);
		//cell9.setCellStyle(my_style_red_right_align);
		cell9.setCellValue(dBean.getOdometerEnd());
		
		Cell cell10 = row.createCell(9);
		//cell10.setCellStyle(my_style_red_right_align);
		cell10.setCellValue(dBean.getDistanceTravelled());
		
		Cell cell11 = row.createCell(10);
		//cell11.setCellStyle(my_style_red_right_align);
		cell11.setCellValue(dBean.getDistanceTravelledHour());
		
		Cell cell12 = row.createCell(11);
		//cell12.setCellStyle(my_style2);
		cell12.setCellValue(dBean.getTotalDistance());
		
		Cell cell13 = row.createCell(12);
		//cell13.setCellStyle(my_style2);
		cell13.setCellValue(dBean.getTotalTravelHours());
		
		Cell cell14 = row.createCell(13);
		//cell14.setCellStyle(my_style2);
		cell14.setCellValue(dBean.getTotalNonDrivingHour());
		
		Cell cell15 = row.createCell(14);
		//cell15.setCellStyle(my_style2);
		cell15.setCellValue(dBean.getExactReasonDelay());
		
	}
	
	
	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		
		Date currentDate = new Date();
		
		String sOutFile = path + "/BMO_Report" + currentDate.getDate() + "_" + currentDate.getHours() + "_" + currentDate.getMinutes() + "_" + currentDate.getSeconds() + ".xls";

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

	
}

