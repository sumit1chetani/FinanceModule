package com.dci.tenant.finance.reports.dailyloadingreport;

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
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.ReportHeaderBean;


@Transactional("tenantTransactionManager")
@Service
public class DailyLoadingReportServiceImpl implements DailyLoadingReportService {

	@Autowired
	DailyLoadingReportDAO dailyLoadingReportDAO; 
	
	
	
	
	@Override
	public DailyLoadingReportResultBean getDropDown() {

		return dailyLoadingReportDAO.getDropDown();
	}
	

	@Override
	public DailyLoadingReportResultBean getViewReport(DailyLoadingReportBean dailyloadingReportBean) {

		return dailyLoadingReportDAO.getViewReport(dailyloadingReportBean);
	}
	
	@Override
	public DailyLoadingReportBean exportDailyLoadinReportExcel(String sFilePath, DailyLoadingReportBean dailyloadingReportBean) {
		
		DailyLoadingReportBean dailyloadingBean = new DailyLoadingReportBean();

		List<DailyLoadingReportBean> lCDCList = dailyLoadingReportDAO.exportDailyLoadinReport(dailyloadingReportBean);
		
		if(!lCDCList.isEmpty()){

		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_LEFT);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
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
			my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
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
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Daily Loading Report");

			// set main header
			setExcelMainHeader(excelSheet, my_style,dailyloadingReportBean);

			// set header
			setExcelHeader(excelSheet, my_style1,dailyloadingReportBean);

			// set Data
			setExcelRows(excelSheet, lCDCList,dailyloadingReportBean, my_style1, my_style2, my_style3,my_style_green,my_style_red,my_style_green_right_align,my_style_red_right_align);

			for (int i = 0; i < 43; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);
			
			dailyloadingBean.setFilePath(sFileUrl);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		}
		return dailyloadingBean;
	}

	private void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style,DailyLoadingReportBean dailyloadingReportBean) {
		
		Integer cellSize = dailyloadingReportBean.getExcelHeaderList().size();
		Integer mergeSize = cellSize-1;
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, mergeSize));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("                                                                                                Daily Loading Report");
		cell.setCellStyle(my_style);
		
	}

	

	private void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1,DailyLoadingReportBean dailyloadingReportBean) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);
			
			for (int i = 0; i < 20; i++) {
				excelSheet.autoSizeColumn(i);
			}

			List<ReportHeaderBean> header = dailyloadingReportBean.getExcelHeaderList();
			for (int i = 0; i < header.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(my_style1);
				cell.setCellValue(header.get(i).getTitle());
			}

//			/*Cell cell0 = row.createCell(0);
//			cell0.setCellStyle(my_style1);
//			cell0.setCellValue("Sl #");*/
//             int i=0;
// 			createHeaderCell(row, my_style1, "",i);
//			createHeaderCell(row, my_style1, "LOAD",i++);
//			createHeaderCell(row, my_style1, "DISPATCH",i++);
//			createHeaderCell(row, my_style1, "RETURN",i++);
//			createHeaderCell(row, my_style1, "DURATION",i++);
//			createHeaderCell(row, my_style1, "MODE",i++);
//			createHeaderCell(row, my_style1, "TRUCK NO",i++);
//			createHeaderCell(row, my_style1, "UNIQUE TRIP NO",i++);
//			createHeaderCell(row, my_style1, "DRIVER'S NAME",i++);
//			createHeaderCell(row, my_style1, "CLIENT NAME",i++);
//			createHeaderCell(row, my_style1, "FROM",i++);
//			createHeaderCell(row, my_style1, "TO",i++);
//			createHeaderCell(row, my_style1, "GOODS DESCRIPTION",i++);
//			createHeaderCell(row, my_style1, "CNTNR NO.",i++);
//			createHeaderCell(row, my_style1, "SEAL NO",i++);
//			createHeaderCell(row, my_style1, "BUNDLES",i++);
//			createHeaderCell(row, my_style1, "FILE NO",i++);
//			createHeaderCell(row, my_style1, "JOB NO",i++);
//			createHeaderCell(row, my_style1, "RCN NO",i++);
//			createHeaderCell(row, my_style1, "20",i++);
//			createHeaderCell(row, my_style1, "40",i++);
//			createHeaderCell(row, my_style1, "CLIENT'S DN",i++);
//			createHeaderCell(row, my_style1, "D/N DATE",i++);
//			createHeaderCell(row, my_style1, "WT/VOL",i++);
//			createHeaderCell(row, my_style1, "RATE",i++);
//			createHeaderCell(row, my_style1, "INCOME(KSH)",i++);
//			createHeaderCell(row, my_style1, "INCOME(USD)",i++);
//			createHeaderCell(row, my_style1, "INCOME(Y+Z*100)",i++);
//			createHeaderCell(row, my_style1, "CLEARING FEE",i++);
//			createHeaderCell(row, my_style1, "PORT CHARGES",i++);
//			createHeaderCell(row, my_style1, "NET INCOMES ",i++);
//			createHeaderCell(row, my_style1, "FUEL O/NO",i++);
//			createHeaderCell(row, my_style1, "FUEL (LTRS)",i++);
//			createHeaderCell(row, my_style1, "FUEL KHS",i++);
//			createHeaderCell(row, my_style1, "D/ MILEAGE",i++);
//			createHeaderCell(row, my_style1, "D/ ALLOCATED",i++);
//			createHeaderCell(row, my_style1, "DCS RCVD DATE",i++);
//			createHeaderCell(row, my_style1, "REBATE",i++);
//			createHeaderCell(row, my_style1, "INVOICE NO",i++);
//			createHeaderCell(row, my_style1, "INV ID",i++);
//			createHeaderCell(row, my_style1, "REMARKS",i++);
//			createHeaderCell(row, my_style1, "EIR DATE",i++);
//			createHeaderCell(row, my_style1, "EIR NO.",i++);
//			createHeaderCell(row, my_style1, "DELAYS",i++);
//			createHeaderCell(row, my_style1, "OUT SOURCING",i++);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Cell createHeaderCell(Row row, HSSFCellStyle style, String value, int index){
		Cell cell = row.createCell(index);
		cell.setCellStyle(style);
		cell.setCellValue(value);
		return cell;
	}
	
	private void setExcelRows(HSSFSheet excelSheet, List<DailyLoadingReportBean> lCDCList,DailyLoadingReportBean dailyloadingBean, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3, HSSFCellStyle my_style_green, HSSFCellStyle my_style_red, HSSFCellStyle my_style_green_right_align, HSSFCellStyle my_style_red_right_align) {
		int record = 3, sno = 1;
		try {
			
			
			
			
			for (int i = 0; i < lCDCList.size(); i++) {
				Row row = excelSheet.createRow((short) record);
				List<ReportHeaderBean> header = dailyloadingBean.getExcelHeaderList();
				for (int j = 0; j < header.size(); j++) {

					Cell cell;

				
					if (header.get(j).getId().equals("loadDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getLoadDate());
					}
					if (header.get(j).getId().equals("dispatchDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDispatchDate());

					}
					if (header.get(j).getId().equals("returnDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getReturnDate());

					}
					if (header.get(j).getId().equals("duration")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDuration());

					}if (header.get(j).getId().equals("mode")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getMode());

					}if (header.get(j).getId().equals("truckNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getTruckNo());

					}if (header.get(j).getId().equals("uniqueTripNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getUniqueTripNo());

					}if (header.get(j).getId().equals("driverName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDriverName());

					}if (header.get(j).getId().equals("clientName")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getClientName());

					}if (header.get(j).getId().equals("fromLocation")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFromLocation());

					}if (header.get(j).getId().equals("toLocation")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getToLocation());

					}if (header.get(j).getId().equals("goodsDescription")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getGoodsDescription());

					}if (header.get(j).getId().equals("containerNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getContainerNo());

					}
					if (header.get(j).getId().equals("sealNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getSealNo());

					}if (header.get(j).getId().equals("bundles")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getBundles());

					}if (header.get(j).getId().equals("fileNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFileNo());

					}if (header.get(j).getId().equals("jobNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getJobNo());

					}if (header.get(j).getId().equals("rncNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getRncNo());

					}if (header.get(j).getId().equals("twenty")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getTwenty());

					}if (header.get(j).getId().equals("fourty")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFourty());

					}if (header.get(j).getId().equals("clientDn")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getClientDn());

					}if (header.get(j).getId().equals("dnDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDnDate());

					}if (header.get(j).getId().equals("vtWol")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getVtWol());

					}if (header.get(j).getId().equals("rate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getRate());

					}if (header.get(j).getId().equals("incomeKsh")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getIncomeKsh());

					}
					if (header.get(j).getId().equals("incomeUsd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getIncomeUsd());

					}if (header.get(j).getId().equals("incomeKshUsd")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getIncomeKshUsd());

					}if (header.get(j).getId().equals("clearingFee")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getClearingFee());

					}if (header.get(j).getId().equals("portCharges")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getPortCharges());

					}if (header.get(j).getId().equals("netIncome")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getNetIncome());

					}if (header.get(j).getId().equals("fueloNO")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFueloNO());

					}if (header.get(j).getId().equals("fuelLitter")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFuelLitter());

					}if (header.get(j).getId().equals("fuelKhs")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getFuelKhs());

					}if (header.get(j).getId().equals("dMileage")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getdMileage());

					}if (header.get(j).getId().equals("dAllocated")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getdAllocated());

					}if (header.get(j).getId().equals("dcsRcvdDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDcsRcvdDate());

					}if (header.get(j).getId().equals("rebate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getRebate());

					}if (header.get(j).getId().equals("invoiceNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getInvoiceNo());

					}
					if (header.get(j).getId().equals("invId")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getInvId());

					}if (header.get(j).getId().equals("remark")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getRemark());

					}if (header.get(j).getId().equals("eirDate")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getEirDate());

					}if (header.get(j).getId().equals("eirNo")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getEirNo());

					}if (header.get(j).getId().equals("delay")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getDelay());

					}if (header.get(j).getId().equals("outSourcing")) {

						cell = row.createCell(j);
						cell.setCellStyle(my_style2);
						cell.setCellValue(lCDCList.get(i).getOutSourcing());

					}
					
				}
				record = record + 1;
			}
			
			
//
//			for (DailyLoadingReportBean dailyloadingReportBean : lCDCList) {
//				Row row = excelSheet.createRow((short) record++);
//				row.setHeight((short) 350);
//				/*
//				for (int i = 0; i < 43; i++) {
//					excelSheet.autoSizeColumn(i);
//				}*/
//				
//				
//				
//					/*Cell cell0 = row.createCell(0);
//					cell0.setCellStyle(my_style2);
//					cell0.setCellValue(sno++);*/
//
//					Cell cell1 = row.createCell(0);
//					//cell1.setCellStyle(my_style2);
//					cell1.setCellValue(dailyloadingReportBean.getLoadDate());
//					
//					Cell cell2 = row.createCell(1);
//					//cell2.setCellStyle(my_style2);
//					cell2.setCellValue(dailyloadingReportBean.getDispatchDate());
//
//					Cell cell3 = row.createCell(2);
//					//cell3.setCellStyle(my_style2);
//					cell3.setCellValue(dailyloadingReportBean.getReturnDate());
//
//					Cell cell4 = row.createCell(3);
//					//cell4.setCellStyle(my_style3);
//					cell4.setCellValue(dailyloadingReportBean.getDuration());
//
//					
//					Cell cell5 = row.createCell(4);
//					//cell5.setCellStyle(my_style3);
//					//cell5.setCellValue(dailyloadingReportBean.getMode());
//					cell5.setCellValue("To be discussed");
//
//
//					Cell cell6 = row.createCell(5);
//					//cell6.setCellStyle(my_style_red_right_align);
//					cell6.setCellValue(dailyloadingReportBean.getTruckNo());
//					
//					Cell cell7 = row.createCell(6);
//					//cell7.setCellStyle(my_style_green_right_align);
//					cell7.setCellValue(dailyloadingReportBean.getUniqueTripNo());
//					
//					Cell cell8 = row.createCell(7);
//					//cell8.setCellStyle(my_style_green_right_align);
//					cell8.setCellValue(dailyloadingReportBean.getDriverName());
//					
//					Cell cell9 = row.createCell(8);
//					//cell9.setCellStyle(my_style_red_right_align);
//					cell9.setCellValue(dailyloadingReportBean.getClientName());
//					
//					Cell cell10 = row.createCell(9);
//					//cell10.setCellStyle(my_style_red_right_align);
//					cell10.setCellValue(dailyloadingReportBean.getFromLocation());
//					
//					Cell cell11 = row.createCell(10);
//					//cell11.setCellStyle(my_style_red_right_align);
//					cell11.setCellValue(dailyloadingReportBean.getToLocation());
//					
//					Cell cell12 = row.createCell(11);
//					//cell12.setCellStyle(my_style2);
//					cell12.setCellValue(dailyloadingReportBean.getGoodsDescription());
//					
//					Cell cell13 = row.createCell(12);
//					//cell13.setCellStyle(my_style2);
//					cell13.setCellValue(dailyloadingReportBean.getContainerNo());
//					
//					Cell cell14 = row.createCell(13);
//					//cell14.setCellStyle(my_style2);
//					cell14.setCellValue(dailyloadingReportBean.getSealNo());
//					
//					Cell cell15 = row.createCell(14);
//					//cell15.setCellStyle(my_style2);
//					cell15.setCellValue(dailyloadingReportBean.getBundles());
//					
//					Cell cell16 = row.createCell(15);
//					//cell16.setCellStyle(my_style2);
//					//cell16.setCellValue(dailyloadingReportBean.getFileNo());
//					cell16.setCellValue("To be discussed");
//					
//					
//					Cell cell17 = row.createCell(16);
//					//cell17.setCellStyle(my_style2);
//					//cell17.setCellValue(dailyloadingReportBean.getJobNo());
//					cell17.setCellValue("To be discussed");
//					
//					Cell cell18 = row.createCell(17);
//					//cell18.setCellStyle(my_style2);
//					//cell18.setCellValue(dailyloadingReportBean.getRncNo());
//					cell18.setCellValue("To be discussed");
//
//					
//					Cell cell19 = row.createCell(18);
//					//cell19.setCellStyle(my_style2);
//					cell19.setCellValue(dailyloadingReportBean.getTwenty());
//					
//					Cell cell20 = row.createCell(19);
//					//cell20.setCellStyle(my_style2);
//					cell20.setCellValue(dailyloadingReportBean.getFourty());
//					
//					Cell cell21 = row.createCell(20);
//					//cell21.setCellStyle(my_style2);
//					//cell21.setCellValue(dailyloadingReportBean.getClientDn());
//					cell21.setCellValue("To be discussed");
//
//					
//					Cell cell22 = row.createCell(21);
//					//cell22.setCellStyle(my_style2);
//					//cell22.setCellValue(dailyloadingReportBean.getDnDate());
//					cell22.setCellValue("To be discussed");
//
//					
//					Cell cell23 = row.createCell(22);
//					//cell23.setCellStyle(my_style2);
//					//cell23.setCellValue(dailyloadingReportBean.getVtWol());
//					cell23.setCellValue("To be discussed");
//					
//					
//					Cell cell24 = row.createCell(23);
//					//cell24.setCellStyle(my_style2);
//					//cell24.setCellValue(dailyloadingReportBean.getRate());
//					cell24.setCellValue("To be discussed");
//					
//					Cell cell25 = row.createCell(24);
//					//cell25.setCellStyle(my_style2);
//					cell25.setCellValue(dailyloadingReportBean.getIncomeKsh());
//					//cell25.setCellValue("To be discussed");
//					
//					Cell cell26 = row.createCell(25);
//					//cell26.setCellStyle(my_style2);
//					//cell26.setCellValue(dailyloadingReportBean.getIncomeUsd());
//					cell26.setCellValue("To be discussed");
//					
//					Cell cell27 = row.createCell(26);
//					//cell27.setCellStyle(my_style2);
//					cell27.setCellValue(dailyloadingReportBean.getIncomeKshUsd());
//					//cell27.setCellValue("To be discussed");
//					
//					Cell cell28 = row.createCell(27);
//					//cell28.setCellStyle(my_style2);
//					//cell28.setCellValue(dailyloadingReportBean.getClearingFee());
//					cell28.setCellValue("To be discussed");
//					
//					Cell cell29 = row.createCell(28);
//					//cell29.setCellStyle(my_style2);
//					//cell29.setCellValue(dailyloadingReportBean.getPortCharges());
//					cell29.setCellValue("To be discussed");
//				
//					Cell cell30 = row.createCell(29);
//					//cell30.setCellStyle(my_style2);
//					cell30.setCellValue(dailyloadingReportBean.getNetIncome());
//					//cell30.setCellValue("To be discussed");
//					
//					Cell cell31 = row.createCell(30);
//					//cell31.setCellStyle(my_style2);
//					cell31.setCellValue(dailyloadingReportBean.getFueloNO());
//					//cell31.setCellValue("To be discussed");
//					
//					Cell cell32 = row.createCell(31);
//					//cell32.setCellStyle(my_style2);
//					cell32.setCellValue(dailyloadingReportBean.getFuelLitter());
//					//cell32.setCellValue("To be discussed");
//					
//					Cell cell33 = row.createCell(32);
//					//cell33.setCellStyle(my_style2);
//					//cell33.setCellValue(dailyloadingReportBean.getFuelKhs());
//					cell33.setCellValue("To be discussed");
//					
//					Cell cell34 = row.createCell(33);
//					//cell34.setCellStyle(my_style2);
//					//cell34.setCellValue(dailyloadingReportBean.getdMileage());
//					cell34.setCellValue("To be discussed");
//					
//					Cell cell35 = row.createCell(34);
//					//cell35.setCellStyle(my_style2);
//					//cell35.setCellValue(dailyloadingReportBean.getdAllocated());
//					cell35.setCellValue("1");
//					
//					Cell cell36 = row.createCell(35);
//					//cell36.setCellStyle(my_style2);
//					//cell36.setCellValue(dailyloadingReportBean.getDcsRcvdDate());
//					cell36.setCellValue("To be discussed");
//					
//					Cell cell37 = row.createCell(36);
//					//cell37.setCellStyle(my_style2);
//					//cell37.setCellValue(dailyloadingReportBean.getRebate());
//					cell37.setCellValue("");
//					
//					Cell cell38 = row.createCell(37);
//					//cell38.setCellStyle(my_style2);
//					cell38.setCellValue(dailyloadingReportBean.getInvoiceNo());
//					//cell38.setCellValue("To be discussed");
//					
//					Cell cell39 = row.createCell(38);
//					//cell39.setCellStyle(my_style2);
//					//cell39.setCellValue(dailyloadingReportBean.getInvId());
//					cell39.setCellValue("To be discussed");
//					
//					Cell cell40 = row.createCell(39);
//					//cell40.setCellStyle(my_style2);
//					cell40.setCellValue(dailyloadingReportBean.getRemark());
//					//cell40.setCellValue("To be discussed");
//					
//					Cell cell41 = row.createCell(40);
//					//cell41.setCellStyle(my_style2);
//					cell41.setCellValue(dailyloadingReportBean.getEirDate());
//					//cell41.setCellValue("To be discussed");
//					
//					Cell cell42 = row.createCell(41);
//					//cell42.setCellStyle(my_style2);
//					cell42.setCellValue(dailyloadingReportBean.getEirNo());
//					//cell42.setCellValue("To be discussed");
//					
//					Cell cell43 = row.createCell(42);
//					//cell43.setCellStyle(my_style2);
//					//cell43.setCellValue(dailyloadingReportBean.getDelay());
//					cell43.setCellValue("To be discussed");
//					
//					Cell cell44 = row.createCell(43);
//					//cell44.setCellStyle(my_style2);
//					//cell44.setCellValue(dailyloadingReportBean.getOutSourcing());
//					cell44.setCellValue("No");
//					
//					
//				
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private String writeExcel(HSSFWorkbook myWorkBook, String path) {


        Date currentDate = new Date();
		
		String sOutFile = path + "/DailyLoadingReport" + currentDate.getDate() + "_" + currentDate.getHours() + "_" + currentDate.getMinutes() + "_" + currentDate.getSeconds() + ".xls";
		
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
			url =sOutFile;
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


	
	private String checkNullValue(String value) {

		String t = "";
		try {
			if (value.trim() == null || value.trim().equalsIgnoreCase("null")) {
				value = "";
			}
		} catch (Exception e) {
			return t;
		}

		return value;
	}


	@Override
	public String getDeptCode() {
		
		return dailyLoadingReportDAO.getDeptCode();
	}

	
	
}
