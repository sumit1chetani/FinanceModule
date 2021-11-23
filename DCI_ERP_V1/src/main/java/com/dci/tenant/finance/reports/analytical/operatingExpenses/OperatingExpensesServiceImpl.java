package com.dci.tenant.finance.reports.analytical.operatingExpenses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
public class OperatingExpensesServiceImpl implements OperatingExpensesService {

	@Autowired
	OperatingExpensesDAO operatingExpensesDAO;

/*	@Override
	public List<SelectivityBean> getVesselList(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getVesselList(expensesBean);
	}
*/
	@Override
	public List<SelectivityBean> setVoyageList(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.setVoyageList(expensesBean);
	}
	@Override
	public List<SelectivityBean> getVesselList(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getVesselList(expensesBean);
	}


	/*@Override
	public List<SelectivityBean> getServiceList(OperatingExpensesBean expensesBean) {
		return operatingExpensesDAO.getServiceList(expensesBean);
	}
*/
	@Override
	public List<SelectivityBean> getAccoundHeadList(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getAccoundHeadList(expensesBean);
	}

	@Override
	public List<OperatingExpensesBean> getMainReport(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getMainReport(expensesBean);
	}

	@Override
	public List<OperatingExpensesBean> getSubReport(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getSubReport(expensesBean);
	}

	@Override
	public List<SelectivityBean> getCompanyList(OperatingExpensesBean expensesBean) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getCompanyList(expensesBean);
	}

	@Override
	public boolean exportExcel(String sFilePath, OperatingExpensesBean expensesBean) {

		String accountNo = "";
		List<OperatingExpensesBean> mainList = operatingExpensesDAO.getMainReport(expensesBean);
		for (OperatingExpensesBean bean : mainList) {
			if (mainList.size() > 1) {
				accountNo += "'" + bean.getAccountNo() + "',";
			} else {
				accountNo = bean.getAccountNo();
			}
		}
		if (mainList.size() > 1)
			accountNo = accountNo.substring(0, accountNo.length() - 1);
		expensesBean.setAccountNo(accountNo);
		List<OperatingExpensesBean> subList = operatingExpensesDAO.getSubReport(expensesBean);
		try {
			// Blank workbook
			XSSFWorkbook  workbook = new XSSFWorkbook();
			XSSFCellStyle my_style = workbook.createCellStyle();
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
			XSSFCellStyle my_style1 = workbook.createCellStyle();
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
			
			XSSFCellStyle my_style2 = workbook.createCellStyle();
			my_style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			XSSFCellStyle my_style3 = workbook.createCellStyle();
			my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			
			Font font2 = workbook.createFont();
			font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
			my_style3.setFont(font2);
			// Create a blank sheet
			XSSFSheet excelSheet = workbook.createSheet("Operating Expenses");
			//HSSFSheet excelSheet = workbook.createSheet("Operating Expenses");

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, mainList, subList, my_style1, my_style2, my_style3);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;
	}

	public void setExcelMainHeader(XSSFSheet excelSheet,XSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 9));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Operating Income/Expenses");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(XSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {
			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Voucher Date");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Voucher No");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Account Head");
			
			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Customer Name");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Job Order No");
			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Mode");

		
			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("USD Debit");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("USD Credit");
			
			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Balance");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(XSSFSheet excelSheet, List<OperatingExpensesBean> mainList, List<OperatingExpensesBean> subList,
			XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;
		try {

			for (OperatingExpensesBean objMain : mainList) {
				Row row = excelSheet.createRow( record++);
				//row.setHeight((short) 350);
				for (int i = 0; i < 7; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);
				
				row.createCell(1).setCellStyle(my_style2);
				row.createCell(2).setCellStyle(my_style2);
				
				Cell cell1 = row.createCell(3);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(objMain.getAccountName()));
				row.createCell(4).setCellStyle(my_style2);
				row.createCell(5).setCellStyle(my_style2);
				row.createCell(6).setCellStyle(my_style2);

				Cell cell4 = row.createCell(7);
				cell4.setCellStyle(my_style3);
				cell4.setCellValue(objMain.getUsdDebit());
				 dTotalDebitAmt = dTotalDebitAmt + objMain.getUsdDebit();

				Cell cell5 = row.createCell(8);
				cell5.setCellStyle(my_style3);
				cell5.setCellValue(objMain.getUsdCredit());
				 dTotalCreditAmt = dTotalCreditAmt +objMain.getUsdCredit();

				
				 Cell cell8 = row.createCell(9);
				 cell8.setCellStyle(my_style3);
				 cell8.setCellValue(objMain.getBalance());
				 
				 
				firstRow = record;

				if (subList.size() > 0) {
					for (OperatingExpensesBean objSub : subList) {
						if (objMain.getAccountNo().equalsIgnoreCase(objSub.getAccountNo())) {
							Row rowsg = excelSheet.createRow( record++);
							//rowsg.setHeight(350);
							// firstSgRow = record;
							Cell cellsg0 = rowsg.createCell(0);
							cellsg0.setCellStyle(my_style2);
							cellsg0.setCellValue(sno++);

							Cell cellsg1 = rowsg.createCell(1);
							cellsg1.setCellStyle(my_style2);
							cellsg1.setCellValue(checkNullValue(objSub.getVoucherDate()));

							Cell cellsg2 = rowsg.createCell(2);
							cellsg2.setCellStyle(my_style2);
							cellsg2.setCellValue(checkNullValue(objSub.getVoucherNo()));
							
							/*if(objSub.getVoucherNo().startsWith("SIGI")){
								Cell cellsg4 = rowsg.createCell(4);
								cellsg4.setCellStyle(my_style2);
								cellsg4.setCellValue(checkNullValue(objSub.getPayerName()+" - "+objSub.getDescription()));
							}else{
								Cell cellsg4 = rowsg.createCell(4);
								cellsg4.setCellStyle(my_style2);
								cellsg4.setCellValue(checkNullValue(objSub.getDescription()));
							}*/
							
							Cell cellsg3 = rowsg.createCell(3);
							cellsg3.setCellStyle(my_style2);
							cellsg3.setCellValue(checkNullValue(objSub.getDescription()));
							
							
							Cell cellsg4 = rowsg.createCell(4);
							cellsg4.setCellStyle(my_style2);
							cellsg4.setCellValue(checkNullValue(objSub.getPayerName()));

							/*
							 * rowsg.createCell(1).setCellStyle(my_style2);
							 * rowsg.createCell(3).setCellStyle(my_style2);
							 */

							Cell cellsg5 = rowsg.createCell(5);
							cellsg5.setCellStyle(my_style2);
							cellsg5.setCellValue(objSub.getVoyageId());

							Cell cellsg6 = rowsg.createCell(6);
							cellsg6.setCellStyle(my_style2);
							cellsg6.setCellValue(objSub.getVesselCode());

							Cell cellsg7 = rowsg.createCell(7);
							cellsg7.setCellStyle(my_style2);
							cellsg7.setCellValue(objSub.getUsdDebit());
							//dTotalDebitAmt+=objSub.getUsdDebit();

							Cell cellsg8 = rowsg.createCell(8);
							cellsg8.setCellStyle(my_style2);
							cellsg8.setCellValue(objSub.getUsdCredit());
							
							rowsg.createCell(9).setCellStyle(my_style2);
							//dTotalCreditAmt+=objSub.getUsdCredit();

							/*
							 * lastRow = record; excelSheet.groupRow(firstSgRow,
							 * lastRow);
							 * excelSheet.setRowGroupCollapsed(firstSgRow,
							 * true);
							 */
						}
					}

				}
				lastRow = record;
				excelSheet.groupRow(firstRow, lastRow);
				excelSheet.setRowGroupCollapsed(firstRow, true);

			}

			// Create total row
			
			  Row rowTotal = excelSheet.createRow( record++);
			  //rowTotal.setHeight((short) 350);
			  
			  rowTotal.createCell(0).setCellStyle(my_style1);
			  rowTotal.createCell(1).setCellStyle(my_style1);
			  rowTotal.createCell(2).setCellStyle(my_style1);
			  rowTotal.createCell(3).setCellStyle(my_style1);
			  
			  Cell cellah1 = rowTotal.createCell(3);
			  cellah1.setCellStyle(my_style1); cellah1.setCellValue("Total");
			  Cell cellah4 = rowTotal.createCell(4);
			  cellah4.setCellStyle(my_style1);
			  Cell cellah5 = rowTotal.createCell(5);
			  cellah5.setCellStyle(my_style1);
			  Cell cellah6 = rowTotal.createCell(6);
			  cellah6.setCellStyle(my_style1);
			  
			  Cell cellah7 = rowTotal.createCell(7);
			  cellah7.setCellStyle(my_style1);
			  cellah7.setCellValue(dTotalDebitAmt);
			  
			  Cell cellah8 = rowTotal.createCell(8);
			  cellah8.setCellStyle(my_style1);
			  cellah8.setCellValue(dTotalCreditAmt);
			  
			  Cell cellah9 = rowTotal.createCell(9);
			  cellah9.setCellStyle(my_style1);
			  cellah9.setCellValue(dTotalDebitAmt-dTotalCreditAmt);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(XSSFWorkbook myWorkBook, String path) {
		//path = "/home/paragon-anandan/Downloads/Anandh/2017/billofladding";
		String sOutFile = "C:/Users/SJK/Desktop/home" + "/operatingExpenses.xlsx";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			url = path + "/operatingExpenses.xlsx";
			fileOut = new FileOutputStream(url);
			myWorkBook.write(fileOut);
			System.out.println("path"+ path);
			url = path + "/operatingExpenses.xlsx";
			System.out.println(url);
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
	public List<SelectivityBean> getLocationList()  {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getLocationList();
	}

	@Override
	public List<SelectivityBean> getLocationList1(String brnch) {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getLocationList1(brnch);
	}
	@Override
	public List<SelectivityBean> getGroupHeadList() {
		// TODO Auto-generated method stub
		return operatingExpensesDAO.getGroupHeadList();
	}

}
