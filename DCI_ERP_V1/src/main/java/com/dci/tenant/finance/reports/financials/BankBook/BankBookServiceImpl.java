package com.dci.tenant.finance.reports.financials.BankBook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.dci.common.model.SelectivityBean;

@Service
public class BankBookServiceImpl implements BankBookService {
	@Autowired
	BankBookDao objCashBankBookDAO;

	@Override
	public List<BankBook> getBankBookAccountList(BankBook objBankBook) {
		return objCashBankBookDAO.getBankBookAccountList(objBankBook);
	}

	@Override
	public List<BankBook> getBankBookList(BankBook objBankBook)
			throws Exception {
		// TODO Auto-generated method stub
		return objCashBankBookDAO.getBankBookList(objBankBook);
	}

	/*
	 * @Override public List<BankBook> getAccountList() throws Exception { //
	 * TODO Auto-generated method stub return
	 * objCashBankBookDAO.getAccountList(); }
	 */

	@Override
	public List<SelectivityBean> getAccountList() {
		return objCashBankBookDAO.getAccountList();
	}

	@Override
	public boolean exportBankBookExcel(String exportFilesPath,
			BankBook objBankBook) {
		// List<BankBook> lBankLegderList =
		// objCashBankBookDAO.getConsolidatedBankLedgerList(objBankBook);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet excelSheet = workbook.createSheet("Bank Ledger");

		try {

			List<BankBook> lCashLegderMainList = objCashBankBookDAO
					.getBankBookList(objBankBook);
			if (lCashLegderMainList != null && lCashLegderMainList.size() > 0) {
				// Blank workbook
				// HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFCellStyle my_style = workbook.createCellStyle();
				my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
				my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
				my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
				my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
				my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
				my_style.setAlignment(my_style.ALIGN_CENTER);
				my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
				my_style.setFillPattern(my_style.SOLID_FOREGROUND);
				my_style.setDataFormat(HSSFDataFormat
						.getBuiltinFormat("#,##0.00"));
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
				my_style1
						.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
				my_style1.setAlignment(my_style.ALIGN_CENTER);
				my_style1.setFillForegroundColor(HSSFColor.YELLOW.index);
				my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
				my_style1.setDataFormat(HSSFDataFormat
						.getBuiltinFormat("#,##0.00"));
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
				my_style2.setDataFormat(HSSFDataFormat
						.getBuiltinFormat("#,##0.00"));

				HSSFCellStyle my_style3 = workbook.createCellStyle();
				my_style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				my_style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
				my_style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
				my_style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				my_style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				// my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
				// Create a blank sheet
				// HSSFSheet excelSheet = workbook.createSheet("Bank Ledger");

				// set main header
				setExcelMainHeader(excelSheet, my_style);

				// set header
				setExcelHeader(excelSheet, my_style1);

				// set Data

				setExcelRows(excelSheet, lCashLegderMainList, objBankBook,
						my_style1, my_style2, my_style3);

			}
			for (int i = 0; i < 10; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcel(workbook, exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;

	}

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 14));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Bank Ledger");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Account code");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Account name");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Transaction NO");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Transaction Date");

			Cell cell454 = row.createCell(5);
			cell454.setCellStyle(my_style1);
			cell454.setCellValue("Account Head");
			
			
			Cell cell44 = row.createCell(6);
			cell44.setCellStyle(my_style1);
			cell44.setCellValue("Customer/Supplier");

			Cell cell45 = row.createCell(7);
			cell45.setCellStyle(my_style1);
			cell45.setCellValue("ChequeNo/NEFT");

			Cell cell5 = row.createCell(8);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Narration");

			Cell cell6 = row.createCell(9);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Debit BC");
			
			Cell celltc = row.createCell(10);
			celltc.setCellStyle(my_style1);
			celltc.setCellValue("Debit TC");

			Cell cell7 = row.createCell(11);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Credit BC");
			
			Cell cellBc = row.createCell(12);
			cellBc.setCellStyle(my_style1);
			cellBc.setCellValue("Credit TC");

			Cell cell77 = row.createCell(13);
			cell77.setCellStyle(my_style1);
			cell77.setCellValue("Closing Balance");

			Cell cell76 = row.createCell(14);
			cell76.setCellStyle(my_style1);
			cell76.setCellValue("Opening Balance");

			/*
			 * Cell cell8 = row.createCell(8); cell8.setCellStyle(my_style1);
			 * cell8.setCellValue("TC Debit");
			 * 
			 * Cell cell9 = row.createCell(9); cell9.setCellStyle(my_style1);
			 * cell9.setCellValue("TC Credit");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(HSSFSheet excelSheet,
			List<BankBook> lCashLegderMainList, BankBook objBankBook,
			HSSFCellStyle my_style1, HSSFCellStyle my_style2,
			HSSFCellStyle my_style3) {
		int record = 3, sno = 1;

		double dTotalBCDebitAmt = 0.0, dTotalBCCreditAmt = 0.0, dTotalTCDebitAmt = 0.0, dTotalTCCreditAmt = 0.0;
		double dCurrentTotalAmt = 0.0; Double open=0.0;
		double openingBalance = 0.0;
		String accountCode = "";
		try {

			for (BankBook objCashBookMain : lCashLegderMainList) {

				List<BankBook> lBankLegderList = objCashBankBookDAO
						.getConsolidatedBankLedgerList(objBankBook);
				if (objCashBookMain.getAccountCode() != ""
						|| objCashBookMain.getAccountCode() != accountCode) {

					Row row = excelSheet.createRow((short) record++);

					Cell cell0 = row.createCell(0);
					cell0.setCellStyle(my_style3);
					cell0.setCellValue(sno++);

					Cell cell1 = row.createCell(1);
					cell1.setCellStyle(my_style2);
					cell1.setCellValue(checkNullValue(objCashBookMain
							.getAccountCode()));

					Cell cell2 = row.createCell(2);
					cell2.setCellStyle(my_style2);
					cell2.setCellValue(checkNullValue(objCashBookMain
							.getAccountName()));

					Cell cell3 = row.createCell(3);
					cell3.setCellStyle(my_style2);
					cell3.setCellValue(checkNullValue(objCashBookMain
							.getTransactionNo()));

					Cell cell4 = row.createCell(4);
					cell4.setCellStyle(my_style2);
					cell4.setCellValue(checkNullValue(objCashBookMain
							.getTransactionDate()));

					Cell cell454 = row.createCell(5);
					cell454.setCellStyle(my_style2);
					cell454.setCellValue(checkNullValue(objCashBookMain
							.getCustomer()));
					
					Cell cell44 = row.createCell(6);
					cell44.setCellStyle(my_style2);
					cell44.setCellValue(checkNullValue(objCashBookMain
							.getCustomer()));

					Cell cell45 = row.createCell(7);
					cell45.setCellStyle(my_style2);
					cell45.setCellValue(checkNullValue(objCashBookMain
							.getChequeNo()));

					Cell cell5 = row.createCell(8);
					cell5.setCellStyle(my_style2);
					cell5.setCellValue(checkNullValue(objCashBookMain
							.getNarration()));

					Cell cell6 = row.createCell(9);
					cell6.setCellStyle(my_style2);
					// cell6.setCellValue(objCashBookMain.getDebit());
//					dTotalBCDebitAmt = dTotalBCDebitAmt
//							+ objCashBookMain.getDebit();

					Cell cell7 = row.createCell(10);
					cell7.setCellStyle(my_style2);
					// cell7.setCellValue(objCashBookMain.getCredit());
//					dTotalBCCreditAmt = dTotalBCCreditAmt
//							+ objCashBookMain.getCredit();

					Cell cell77 = row.createCell(11);
					cell77.setCellStyle(my_style2);
//					cell77.setCellValue(objCashBookMain.getCurrentBalance());
//					dCurrentTotalAmt = dCurrentTotalAmt
//							+ objCashBookMain.getCurrentBalance();
					Cell celltc = row.createCell(12);
					cell77.setCellStyle(my_style2);
					
					Cell cellbc = row.createCell(13);
					cellbc.setCellStyle(my_style2);
					
					Cell cell465 = row.createCell(14);
					cell465.setCellStyle(my_style2);
					cell465.setCellValue((objCashBookMain.getOpeningBalance()));
					openingBalance = objCashBookMain.getOpeningBalance();

					accountCode = objCashBookMain.getAccountCode();
					for (BankBook objBankBookdtl : lBankLegderList) {
						Row row1 = excelSheet.createRow((short) record++);
						row1.setHeight((short) 350);
						for (int i = 0; i < 9; i++) {
							excelSheet.autoSizeColumn(i);
						}

						Cell cell00 = row1.createCell(0);
						cell00.setCellStyle(my_style3);
						cell00.setCellValue(sno++);

						Cell cell10 = row1.createCell(1);
						cell10.setCellStyle(my_style2);
						// cell10.setCellValue(checkNullValue(objBankBookdtl
						// .getMainAccountCode()));

						Cell cell20 = row1.createCell(2);
						cell20.setCellStyle(my_style2);
						// cell20.setCellValue(checkNullValue(objBankBookdtl
						// .getMainAccountName()));

						Cell cell30 = row1.createCell(3);
						cell30.setCellStyle(my_style2);
						cell30.setCellValue(checkNullValue(objBankBookdtl
								.getTransactionNo()));

						Cell cell40 = row1.createCell(4);
						cell40.setCellStyle(my_style2);
						cell40.setCellValue(checkNullValue(objBankBookdtl
								.getTransactionDate()));

						Cell cell4504 = row1.createCell(5);
						cell4504.setCellStyle(my_style2);
						cell4504.setCellValue(checkNullValue(objBankBookdtl
								.getAcctheadname()));
						
						
						Cell cell440 = row1.createCell(6);
						cell440.setCellStyle(my_style2);
						cell440.setCellValue(checkNullValue(objBankBookdtl
								.getCustomer()));

						Cell cell450 = row1.createCell(7);
						cell450.setCellStyle(my_style2);
						cell450.setCellValue(checkNullValue(objBankBookdtl
								.getChequeNo()));

						Cell cell50 = row1.createCell(8);
						cell50.setCellStyle(my_style2);
						cell50.setCellValue(checkNullValue(objBankBookdtl
								.getNarration()));

						Cell cell60 = row1.createCell(9);
						cell60.setCellStyle(my_style2);
						cell60.setCellValue(objBankBookdtl.getBcDebit());
						 dTotalBCDebitAmt = dTotalBCDebitAmt
						 + objBankBookdtl.getBcDebit();
						 
						 Cell celltc10 = row1.createCell(10);
						 celltc10.setCellStyle(my_style2);
						 celltc10.setCellValue(objBankBookdtl.getTcDebit());
							 dTotalTCDebitAmt = dTotalTCDebitAmt
							 + objBankBookdtl.getTcDebit();

						Cell cell70 = row1.createCell(11);
						cell70.setCellStyle(my_style2);
						cell70.setCellValue(objBankBookdtl.getBcCredit());
					 dTotalBCCreditAmt = dTotalBCCreditAmt
						 + objBankBookdtl.getBcCredit();

					 Cell cellBC70 = row1.createCell(12);
					 cellBC70.setCellStyle(my_style2);
					 cellBC70.setCellValue(objBankBookdtl.getTcCredit());
					 dTotalTCCreditAmt = dTotalTCCreditAmt
						 + objBankBookdtl.getTcCredit();
						
						 open = open + (objBankBookdtl.getBcDebit() - objBankBookdtl.getBcCredit());
						 
						Cell cell770 = row1.createCell(13);
						cell770.setCellStyle(my_style2);
						cell770.setCellValue(open);
						 dCurrentTotalAmt = dCurrentTotalAmt
						+ objBankBookdtl.getCurrentBalance();
							//openingBalance = open;

						accountCode = objBankBookdtl.getMainAccountCode();
						/*
						 * Cell cell8 = row.createCell(8);
						 * cell8.setCellStyle(my_style2);
						 * cell8.setCellValue(objBankBook.getTcDebit());
						 * dTotalTCDebitAmt = dTotalTCDebitAmt +
						 * objBankBook.getTcDebit();
						 * 
						 * Cell cell9 = row.createCell(9);
						 * cell9.setCellStyle(my_style2);
						 * cell9.setCellValue(objBankBook.getTcCredit());
						 * dTotalTCCreditAmt = dTotalTCCreditAmt +
						 * objBankBook.getTcCredit();
						 */

					}
				}
			}
			// Create total row
			Row rowTotal = excelSheet.createRow((short) record++);
			rowTotal.setHeight((short) 350);

			rowTotal.createCell(0).setCellStyle(my_style1);
			rowTotal.createCell(1).setCellStyle(my_style1);
			rowTotal.createCell(2).setCellStyle(my_style1);
			rowTotal.createCell(3).setCellStyle(my_style1);
			rowTotal.createCell(4).setCellStyle(my_style1);
			rowTotal.createCell(5).setCellStyle(my_style1);
			rowTotal.createCell(6).setCellStyle(my_style1);
			rowTotal.createCell(7).setCellStyle(my_style1);
			rowTotal.createCell(8).setCellStyle(my_style1);

			Cell cellah1 = rowTotal.createCell(1);
			cellah1.setCellStyle(my_style1);
			cellah1.setCellValue("Total");

			Cell cellah12 = rowTotal.createCell(9);
			cellah12.setCellStyle(my_style1);
			cellah12.setCellValue(dTotalBCDebitAmt);
			
			Cell cellah10 = rowTotal.createCell(10);
			cellah10.setCellStyle(my_style1);
			cellah10.setCellValue(dTotalTCDebitAmt);

			Cell cellah13 = rowTotal.createCell(11);
			cellah13.setCellStyle(my_style1);
			cellah13.setCellValue(dTotalBCCreditAmt);
			
			Cell cellah14 = rowTotal.createCell(12);
			cellah14.setCellStyle(my_style1);
			cellah14.setCellValue(dTotalTCCreditAmt);

			/*Cell cellah8 = rowTotal.createCell(13);
			cellah8.setCellStyle(my_style1);
			cellah8.setCellValue("");*/

			/*
			 * Cell cellah8 = rowTotal.createCell(10);
			 * cellah8.setCellStyle(my_style1);
			 * cellah8.setCellValue(dTotalBCCreditAmt);
			 * 
			 * Cell cellah9 = rowTotal.createCell(9);
			 * cellah9.setCellStyle(my_style1);
			 * cellah9.setCellValue(dTotalTCCreditAmt);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/bankBook.xls";

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
			url = path + "/bankBook.xls";
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
}