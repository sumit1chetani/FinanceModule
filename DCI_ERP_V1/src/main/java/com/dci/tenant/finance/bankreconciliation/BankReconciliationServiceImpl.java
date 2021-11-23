package com.dci.tenant.finance.bankreconciliation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

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
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;

@Service
public class BankReconciliationServiceImpl implements BankReconciliationService {

	@Resource
	private DataSource dataSource;

	@Autowired
	BankReconciliationDao objBankReconciliationDao;

	@Override
	public void getmail(HttpServletRequest request) throws Exception {
		objBankReconciliationDao.getmail(request);
	}

	@Override
	public List<SelectivityBean> getBankList() {
		return objBankReconciliationDao.getBankList();
	}

	@Override
	public BankReconciliationBean printBankmail(int bank_stmt_id) throws Exception {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.printBankmail(bank_stmt_id);
	}

	@Override
	public String uploadFile(MultipartFile file, String sBankCode) {
		return objBankReconciliationDao.uploadFile(file, sBankCode);

	}

	@Override
	public String approve(int bank_stmt_id) throws Exception {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.approve(bank_stmt_id);
	}

	@Override
	public String reject(int bank_stmt_id) throws Exception {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.reject(bank_stmt_id);
	}

	/*
	 * @Override public BankReconciliationBean bankreconcilePrint(int bank_stmt_id)
	 * throws Exception { // TODO Auto-generated method stub return
	 * objBankReconciliationDao.bankreconcilePrint(bank_stmt_id); }
	 */

	@Override
	public BankReconciliationResultBean getDifferenecList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception {
		return objBankReconciliationDao.getDifferenceList(limit, offset, sFromDate, sToDate, sBankCode);
	}

	@Override
	public String reconcileRecords(List<BankReconciliationBean> alReconcileRecord) throws ParseException {
		return objBankReconciliationDao.reconcileRecords(alReconcileRecord);
	}

	@Override
	public String reconcileRecordsDraft(List<BankReconciliationBean> alReconcileRecord) throws ParseException {
		return objBankReconciliationDao.reconcileRecordsDraft(alReconcileRecord);
	}

	@Override
	public List<BankReconciliationBean> getReconcileList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception {
		return objBankReconciliationDao.getReconcileList(limit, offset, sFromDate, sToDate, sBankCode);
	}

	@Override
	public List<BankReconciliationBean> getReconcileListDraft(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception {
		return objBankReconciliationDao.getReconcileListDraft(limit, offset, sFromDate, sToDate, sBankCode);
	}

	@Override
	public BankReconciliationBean getReconcileListDraft1(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception {
		return objBankReconciliationDao.getReconcileListDraft1(limit, offset, sFromDate, sToDate, sBankCode);
	}

	@Override
	public BankReconciliationBean getReconcileListNew(int limit, int offset, String sFromDate, String sToDate, String bankcode) throws Exception {
		return objBankReconciliationDao.getReconcileListNew(limit, offset, sFromDate, sToDate, bankcode);
	}

	@Override
	public BankReconciliationBean getReconcileListDraft2(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception {
		return objBankReconciliationDao.getReconcileListDraft2(limit, offset, sFromDate, sToDate, sBankCode);
	}

	@Override
	public boolean getStatementAvaiablity(String sFromDate, String sToDate, String sBankCode) {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.getStatementAvaiablity(sFromDate, sToDate, sBankCode);
	}
	/*
	 * @Override public List<BankReconciliationBean> bulkMailCheck(
	 * List<BankReconciliationBean> bankReconciliationBean, HttpServletRequest
	 * request) { return objBankReconciliationDao.bulkMailCheck(
	 * bankReconciliationBean, request); }
	 */

	@Override
	public BankReconciliationResultBean getunReconcileBookAndBankStatement(String sFromDate, String sToDate, String sBankCode) {
		return objBankReconciliationDao.getunReconcileBookAndBankStatement(sFromDate, sToDate, sBankCode);
	}

	private int iCommonRowCounter = 0;
	double dUnReconciledPaymentAmount = 0.0;
	double dUnReconciledReceiptAmount = 0.0;
	double dCreditTotalAmount = 0.0;
	double dDebitTotalAmount = 0.0;

	@Override
	public boolean exportunReconciledBankRecord(String sFilePath, String sFromDate, String sToDate, String sBankCode) {

		dUnReconciledPaymentAmount = 0.0;
		dUnReconciledReceiptAmount = 0.0;
		dCreditTotalAmount = 0.0;
		dDebitTotalAmount = 0.0;
		// fetching the account_no and currency
		BankReconciliationBean objBankReconciliationBean = objBankReconciliationDao.getBankDetails(sBankCode);

		// get statement list seperately
		BankReconciliationResultBean objBankReconciliationResultBean = objBankReconciliationDao.getunReconcileBookAndBankStatement(sFromDate, sToDate, sBankCode);

		List<BankReconciliationBean> alBookStatementList = objBankReconciliationResultBean.getlBookStatementList();
		List<BankReconciliationBean> alBankStatementList = objBankReconciliationResultBean.getlBankStatementList();

		// splitting the book statement into payment and receipts
		List<BankReconciliationBean> alUnReconciledPaymentList = new ArrayList<>();
		List<BankReconciliationBean> alUnReconciledReceiptList = new ArrayList<>();
		List<BankReconciliationBean> alCreditAmountList = new ArrayList<>();
		List<BankReconciliationBean> alDebitAmountList = new ArrayList<>();

		for (BankReconciliationBean objBean : alBookStatementList) {
			if (objBean.getBook_credit_amt() != 0 && objBean.getBook_debit_amt() == 0) {
				alUnReconciledPaymentList.add(objBean);
			} else if (objBean.getBook_debit_amt() != 0 && objBean.getBook_credit_amt() == 0) {
				alUnReconciledReceiptList.add(objBean);
			}
		}

		for (BankReconciliationBean objBean : alBankStatementList) {
			if (objBean.getBank_credit_amt() > 0 && objBean.getBank_debit_amt() == 0) {
				alCreditAmountList.add(objBean);
			} else if (objBean.getBank_debit_amt() > 0 && objBean.getBank_credit_amt() == 0) {
				alDebitAmountList.add(objBean);
			}
		}

		for (BankReconciliationBean objPayments : alUnReconciledPaymentList) {
			dUnReconciledPaymentAmount = dUnReconciledPaymentAmount + objPayments.getBook_credit_amt();
		}

		for (BankReconciliationBean objReceipts : alUnReconciledReceiptList) {
			dUnReconciledReceiptAmount = dUnReconciledReceiptAmount + objReceipts.getBook_debit_amt();
		}

		for (BankReconciliationBean objBankCredits : alCreditAmountList) {
			dCreditTotalAmount = dCreditTotalAmount + objBankCredits.getBank_credit_amt();
		}

		for (BankReconciliationBean objBankDebits : alDebitAmountList) {
			dDebitTotalAmount = dDebitTotalAmount + objBankDebits.getBank_debit_amt();
		}
		// code for generating the excel as template
		try {
			// Blank workbook
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
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("Bank Reconcilation");

			// set main header
			setExcelMainHeader(excelSheet, my_style,sFromDate,sToDate);
			// set bank account header
			setBankAccountHeader(excelSheet, my_style, objBankReconciliationBean.getBankAccountNo(),sFromDate,sToDate);
			// set currency header below bank
			setCurrencyHeader(excelSheet, my_style1, objBankReconciliationBean.getBankCurrency());

			// set consolidated header
			iCommonRowCounter = 4;
			setcommonTotalHeader(excelSheet, my_style2);

			// unReconciled book payments header
			setUnReconciledBookPaymentsHeader(excelSheet, my_style1);
			// unReconciled book payments detail Header
			setTransactionLevelHeader(excelSheet, my_style1);
			// unReconciled book payments detail data

			setUnReconciledBookPaymentsDetailData(excelSheet, my_style1, my_style2, alUnReconciledPaymentList);

			// unReconciled book Receipts header
			iCommonRowCounter++;
			setUnReconciledBookReceiptsHeader(excelSheet, my_style1);
			// unReconciled book Receipt detail Header
			setTransactionLevelHeader(excelSheet, my_style1);
			// unReconciled book Receipt detail data
			setUnReconciledBookReceiptsDetailData(excelSheet, my_style1, my_style2, alUnReconciledReceiptList);

			// credit amount in bank but not booked header
			iCommonRowCounter++;
			setCreditsListHeader(excelSheet, my_style1);
			// credit amount in bank but not booked Header
			setTransactionLevelHeader(excelSheet, my_style1);
			// credit amount in bank but not booked detail
			setCreditsListDetailData(excelSheet, my_style1, my_style2, alCreditAmountList);

			// debit amount in bank but not booked header
			iCommonRowCounter++;
			setDebitsListHeader(excelSheet, my_style1);
			// debit amount in bank but not booked Header
			setTransactionLevelHeader(excelSheet, my_style1);
			// debit amount in bank but not booked detail
			setDebitsListDetailData(excelSheet, my_style1, my_style2, alDebitAmountList);

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

	public void setExcelMainHeader(HSSFSheet excelSheet, HSSFCellStyle my_style, String sFromDate, String sToDate) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 6));
		Cell cell = row.createCell((short) 1);
		cell.setCellValue("Bank Reconcilation");
		cell.setCellStyle(my_style);
		
		Row row4 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 6));
		Cell cell4 = row4.createCell((short) 0);
		cell4.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell4.setCellStyle(my_style);
	
		
		
		Row row3 = excelSheet.createRow((short)2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 6));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue( sFromDate +" TO " + sToDate);
		cell3.setCellStyle(my_style);
		
	}

	// Bank Account name and number
	public void setBankAccountHeader(HSSFSheet excelSheet, HSSFCellStyle my_style, String sBankAccountNo, String sFromDate, String sToDate) {
		Row row = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 6));
		Cell cell = row.createCell((short) 1);
		sBankAccountNo = checkNullValue(sBankAccountNo);
		cell.setCellValue("Bank Account :" + sBankAccountNo);
		cell.setCellStyle(my_style);
		
		Row row4 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 6));
		Cell cell4 = row4.createCell((short) 0);
		cell4.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell4.setCellStyle(my_style);
	
		
		
		Row row3 = excelSheet.createRow((short)3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 3, 6));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue( sFromDate +" TO " + sToDate);
		cell3.setCellStyle(my_style);
		
	}

	// set Currency Header below Bank name
	public void setCurrencyHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1, String sCurrency) {
		Row row = excelSheet.createRow((short) 4);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 6));
		Cell cell = row.createCell((short) 1);
		sCurrency = checkNullValue(sCurrency);
		cell.setCellValue("Currency :" + sCurrency);
		cell.setCellStyle(my_style1);
	}

	// setCommon total header
	public void setcommonTotalHeader(HSSFSheet excelSheet, HSSFCellStyle my_style2) {

		Row row = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 6));
		Cell cell = row.createCell((short) 4);
		cell.setCellValue("Bank Reconciliation as of (Date)");
		cell.setCellStyle(my_style2);
		row.createCell(2).setCellStyle(my_style2);
		row.createCell(3).setCellStyle(my_style2);
		row.createCell(4).setCellStyle(my_style2);
		row.createCell(5).setCellStyle(my_style2);
		row.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter = iCommonRowCounter + 2;

		Row row1 = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 6));
		Cell cell1 = row1.createCell((short) 1);
		cell1.setCellValue("Balance as per our Bank Book - As of (Date)");
		cell1.setCellStyle(my_style2);
		row1.createCell(2).setCellStyle(my_style2);
		row1.createCell(3).setCellStyle(my_style2);
		row1.createCell(4).setCellStyle(my_style2);
		row1.createCell(5).setCellStyle(my_style2);
		row1.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter = iCommonRowCounter + 2;

		Row row2 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell2 = row2.createCell((short) 1);
		cell2.setCellValue("Add:");
		cell2.setCellStyle(my_style2);
		row2.createCell(2).setCellStyle(my_style2);
		row2.createCell(3).setCellStyle(my_style2);
		row2.createCell(4).setCellStyle(my_style2);
		row2.createCell(5).setCellStyle(my_style2);
		row2.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter++;

		Row row3 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell3 = row3.createCell((short) 1);
		cell3.setCellValue("Cheques Issued but not Presented by Party");
		cell3.setCellStyle(my_style2);
		row3.createCell(2).setCellStyle(my_style2);
		row3.createCell(3).setCellStyle(my_style2);
		row3.createCell(4).setCellStyle(my_style2);
		row3.createCell(5).setCellStyle(my_style2);
		Cell cellPaymentTotal = row3.createCell((short) 6);
		cellPaymentTotal.setCellValue(dUnReconciledPaymentAmount);
		cellPaymentTotal.setCellStyle(my_style2);
		iCommonRowCounter++;

		Row row4 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell4 = row4.createCell((short) 1);
		cell4.setCellValue("Credits of the Bank to be Accounted in Books");
		cell4.setCellStyle(my_style2);
		row4.createCell(2).setCellStyle(my_style2);
		row4.createCell(3).setCellStyle(my_style2);
		row4.createCell(4).setCellStyle(my_style2);
		row4.createCell(5).setCellStyle(my_style2);
		Cell cellCreditTotal = row4.createCell((short) 6);
		cellCreditTotal.setCellValue(dCreditTotalAmount);
		cellCreditTotal.setCellStyle(my_style2);
		iCommonRowCounter = iCommonRowCounter + 2;

		Row row5 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell5 = row5.createCell((short) 1);
		cell5.setCellValue("Less:");
		cell5.setCellStyle(my_style2);
		row5.createCell(2).setCellStyle(my_style2);
		row5.createCell(3).setCellStyle(my_style2);
		row5.createCell(4).setCellStyle(my_style2);
		row5.createCell(5).setCellStyle(my_style2);
		row5.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter++;

		Row row6 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell6 = row6.createCell((short) 1);
		cell6.setCellValue("Cheques Deposited but not Credited by Bank");
		cell6.setCellStyle(my_style2);
		row6.createCell(2).setCellStyle(my_style2);
		row6.createCell(3).setCellStyle(my_style2);
		row6.createCell(4).setCellStyle(my_style2);
		Cell cellReceiptTotal = row6.createCell((short) 5);
		cellReceiptTotal.setCellValue(dUnReconciledReceiptAmount);
		cellReceiptTotal.setCellStyle(my_style2);
		row6.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter++;

		Row row7 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell7 = row7.createCell((short) 1);
		cell7.setCellValue("Debits of the Bank to be Accounted in Books");
		cell7.setCellStyle(my_style2);
		row7.createCell(2).setCellStyle(my_style2);
		row7.createCell(3).setCellStyle(my_style2);
		row7.createCell(4).setCellStyle(my_style2);
		Cell cellDebitTotal = row7.createCell((short) 5);
		cellDebitTotal.setCellValue(dDebitTotalAmount);
		cellDebitTotal.setCellStyle(my_style2);
		row7.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter = iCommonRowCounter + 2;

		Row row8 = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell8 = row8.createCell((short) 1);
		cell8.setCellValue("Balance as per Bank Statement - As of (Date)");
		cell8.setCellStyle(my_style2);
		row8.createCell(2).setCellStyle(my_style2);
		row8.createCell(3).setCellStyle(my_style2);
		row8.createCell(4).setCellStyle(my_style2);
		row8.createCell(5).setCellStyle(my_style2);
		row8.createCell(6).setCellStyle(my_style2);
		iCommonRowCounter = iCommonRowCounter + 3;

	}

	// set unReconciled payment header
	public void setUnReconciledBookPaymentsHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(iCommonRowCounter, iCommonRowCounter, 1, 6));
		Cell cell = row.createCell((short) 1);
		cell.setCellValue("Details of Cheques / Transfer Letters Issued to Vendors but not Presented by Vendors:");
		cell.setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// setTransaction Detail header
	public void setTransactionLevelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		Row row = excelSheet.createRow((short) iCommonRowCounter);

		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("Cheque Number");

		Cell cell2 = row.createCell(2);
		cell2.setCellStyle(my_style1);
		cell2.setCellValue("Date");

		Cell cell3 = row.createCell(3);
		cell3.setCellStyle(my_style1);
		cell3.setCellValue("Particulars");

		Cell cell4 = row.createCell(4);
		cell4.setCellStyle(my_style1);
		cell4.setCellValue("Reference");

		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue("Amount");

		Cell cell6 = row.createCell(6);
		cell6.setCellStyle(my_style1);
		cell6.setCellValue("Remarks");
		iCommonRowCounter++;
	}

	// set unReconciled payment Detail data
	public void setUnReconciledBookPaymentsDetailData(HSSFSheet excelSheet, HSSFCellStyle my_style1, HSSFCellStyle my_style2, List<BankReconciliationBean> alUnReconciledPaymentList) {

		for (BankReconciliationBean objPayments : alUnReconciledPaymentList) {

			Row row = excelSheet.createRow((short) iCommonRowCounter);

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style2);
			cell1.setCellValue(objPayments.getBook_cheque_no());

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style2);
			cell2.setCellValue(objPayments.getBook_cheque_date());

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style2);
			cell3.setCellValue(objPayments.getTransaction_no());

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style2);
			cell4.setCellValue(objPayments.getBook_narration());

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style2);
			cell5.setCellValue(objPayments.getBook_credit_amt());

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style2);
			cell6.setCellValue(objPayments.getRemarks());
			iCommonRowCounter++;

		}
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue(dUnReconciledPaymentAmount);

		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("Total");
		row.createCell(2).setCellStyle(my_style1);
		row.createCell(3).setCellStyle(my_style1);
		row.createCell(4).setCellStyle(my_style1);
		row.createCell(6).setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set unReconciled Receipt header
	public void setUnReconciledBookReceiptsHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(iCommonRowCounter, iCommonRowCounter, 1, 6));
		Cell cell = row.createCell((short) 1);
		cell.setCellValue("Details of Cheques / Transfer Letters Deposited into Bank but not Credited by the Bank:");
		cell.setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set unReconciled Receipt Detail data
	public void setUnReconciledBookReceiptsDetailData(HSSFSheet excelSheet, HSSFCellStyle my_style1, HSSFCellStyle my_style2, List<BankReconciliationBean> alUnReconciledReceiptList) {
		for (BankReconciliationBean objReceipts : alUnReconciledReceiptList) {
			Row row = excelSheet.createRow((short) iCommonRowCounter);

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style2);
			cell1.setCellValue(objReceipts.getBook_cheque_no());

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style2);
			cell2.setCellValue(objReceipts.getBook_cheque_date());

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style2);
			cell3.setCellValue(objReceipts.getTransaction_no());

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style2);
			cell4.setCellValue(objReceipts.getBook_narration());

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style2);
			cell5.setCellValue(objReceipts.getBook_debit_amt());

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style2);
			cell6.setCellValue(objReceipts.getBook_narration());
			iCommonRowCounter++;
		}
		Row row = excelSheet.createRow((short) iCommonRowCounter);

		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue(dUnReconciledReceiptAmount);

		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("Total");
		row.createCell(2).setCellStyle(my_style1);
		row.createCell(3).setCellStyle(my_style1);
		row.createCell(4).setCellStyle(my_style1);
		row.createCell(6).setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set credit header
	public void setCreditsListHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(iCommonRowCounter, iCommonRowCounter, 1, 6));
		Cell cell = row.createCell((short) 1);
		cell.setCellValue("Details of Amount Credit in the Bank but to be Accounted in the Books:");
		cell.setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set credit Detail data
	public void setCreditsListDetailData(HSSFSheet excelSheet, HSSFCellStyle my_style1, HSSFCellStyle my_style2, List<BankReconciliationBean> alCreditAmountList) {
		for (BankReconciliationBean objBankCredits : alCreditAmountList) {
			Row row = excelSheet.createRow((short) iCommonRowCounter);

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style2);
			cell1.setCellValue(objBankCredits.getBank_cheque_no());

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style2);
			cell2.setCellValue(objBankCredits.getBank_date());

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style2);
			cell3.setCellValue("Bank Credits");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style2);
			cell4.setCellValue(objBankCredits.getBank_narration());

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style2);
			cell5.setCellValue(objBankCredits.getBank_credit_amt());

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style2);
			cell6.setCellValue(objBankCredits.getBank_narration());

			iCommonRowCounter++;
		}

		// set Total Row
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue(dCreditTotalAmount);

		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("Total");
		row.createCell(2).setCellStyle(my_style1);
		row.createCell(3).setCellStyle(my_style1);
		row.createCell(4).setCellStyle(my_style1);
		row.createCell(6).setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set debit header
	public void setDebitsListHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		excelSheet.addMergedRegion(new CellRangeAddress(iCommonRowCounter, iCommonRowCounter, 1, 6));
		Cell cell = row.createCell((short) 1);
		cell.setCellValue("Details of Amount Debited in the Bank but to be Accounted in the Books:");
		cell.setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	// set debit Detail data
	public void setDebitsListDetailData(HSSFSheet excelSheet, HSSFCellStyle my_style1, HSSFCellStyle my_style2, List<BankReconciliationBean> alDebitAmountList) {
		for (BankReconciliationBean objBankDebits : alDebitAmountList) {

			Row row = excelSheet.createRow((short) iCommonRowCounter);

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style2);
			cell1.setCellValue(objBankDebits.getBank_cheque_no());

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style2);
			cell2.setCellValue(objBankDebits.getBank_date());

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style2);
			cell3.setCellValue("Bank Debits");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style2);
			cell4.setCellValue(objBankDebits.getBank_narration());

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style2);
			cell5.setCellValue(objBankDebits.getBank_debit_amt());

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style2);
			cell6.setCellValue(objBankDebits.getBank_narration());
			iCommonRowCounter++;
		}
		// set Total Row
		Row row = excelSheet.createRow((short) iCommonRowCounter);
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(my_style1);
		cell5.setCellValue(dDebitTotalAmount);

		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(my_style1);
		cell1.setCellValue("Total");
		row.createCell(2).setCellStyle(my_style1);
		row.createCell(3).setCellStyle(my_style1);
		row.createCell(4).setCellStyle(my_style1);
		row.createCell(6).setCellStyle(my_style1);
		iCommonRowCounter++;
	}

	private String writeExcel(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/BankReconciliation.xls";

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
			url = path + "/BankReconciliation.xls";
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
	public String generateExcel(List<BankReconciliationBean> bean) {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.generateExcel(bean);
	}

	@Override
	public String excludedRecords(BankReconciliationBean reconcileRecords) {
		// TODO Auto-generated method stub
		return objBankReconciliationDao.excludedRecords(reconcileRecords);
	}

	@Override
	public boolean excellExport(BankReconciliationResultBean rsBean, String sFromDate, String sToDate, String exportFilesPath) {
		// TODO Auto-generated method stub

		//BankReconciliationBean bean = new BankReconciliationBean();
		try {
			// Blank workbook
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCellStyle my_style = workbook.createCellStyle();
			my_style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.DARK_BLUE.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.WHITE.index);
			// font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			HSSFCellStyle my_style1 = workbook.createCellStyle();
			my_style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			// font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
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
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			// Create a blank sheet
			HSSFSheet excelSheet = workbook.createSheet("BANK RECONCILIATION");
			//

			// set main header
			setExcelMainHeaderNEW(excelSheet,rsBean, my_style,sFromDate,sToDate);

			// set header
			setExcelHeaderNEW(excelSheet, my_style1);

			// set Data
			setExcelRows(excelSheet, rsBean, my_style1, my_style2, my_style3);

			// image insert

			for (int i = 0; i < 9; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			writeExcelNEW(workbook, exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return true;

	}

	public void setExcelHeaderNEW(HSSFSheet excelSheet, HSSFCellStyle my_style1) {

		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Customer/Supplier");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Transaction No");

			Cell cell8 = row.createCell(2);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Cheque Date");

			Cell cell9 = row.createCell(3);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Narration");

			Cell cell2 = row.createCell(4);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Transaction Type");

			Cell cell3 = row.createCell(5);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Doc Type");

			Cell cell4 = row.createCell(6);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Credit");

			Cell cell6 = row.createCell(7);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Debit");

			Cell cell61 = row.createCell(8);
			cell61.setCellStyle(my_style1);
			cell61.setCellValue("Bank Date");

			Cell cell7 = row.createCell(9);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Remarks");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setExcelRows(HSSFSheet excelSheet, BankReconciliationResultBean rsbean, HSSFCellStyle my_style1, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		String code = "null";
		String vessel = "null";
		int i = 2;
		int j = 2;
		int k = 3;
		int oldcount = 5;
		try {

			int serial = 1;
			for (BankReconciliationBean Bean : rsbean.getlDifferenceResultList()) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(Bean.getCustomer());

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(Bean.getTransaction_no());

				Cell cell8 = row.createCell(2);
				cell8.setCellStyle(my_style2);
				cell8.setCellValue(Bean.getBook_date());

				Cell cell9 = row.createCell(3);
				cell9.setCellStyle(my_style2);
				cell9.setCellValue(Bean.getBook_narration());

				Cell cell2 = row.createCell(4);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(Bean.getBook_cheque_no());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style2);
				cell5.setCellValue(Bean.getType());

				Cell cell51 = row.createCell(6);
				cell51.setCellStyle(my_style3);
				cell51.setCellValue(Bean.getBook_credit_amt());

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(Bean.getBook_debit_amt());

				Cell cell81 = row.createCell(5);
				cell81.setCellStyle(my_style2);
				cell81.setCellValue(Bean.getBank_date());

				Cell cell91 = row.createCell(9);
				cell91.setCellStyle(my_style2);
				cell91.setCellValue(Bean.getRemarks());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle my_style1) {

		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Charge Code");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Charge Name");

			Cell cell8 = row.createCell(2);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Short Name");

			Cell cell9 = row.createCell(3);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Account Head Code");

			Cell cell2 = row.createCell(4);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Account Head Name");

			Cell cell3 = row.createCell(5);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Charge Type");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelNEW(HSSFWorkbook workbook, String path) {/*
																		 * 
																		 * String l_str_file_out = pdfFile + "/" + "Bank Reconciliation.xls";
																		 * FileOutputStream fileOut = null; System.out.println("filepath" +
																		 * l_str_file_out); try { File file = new File(l_str_file_out);
																		 * 
																		 * if (file.delete()) { System.out.println(file.getName() + " is deleted"); }
																		 * else { System.out.println("delete failed"); }
																		 * 
																		 * fileOut = new FileOutputStream(l_str_file_out); workbook.write(fileOut); }
																		 * catch (IOException e) { e.printStackTrace(); } finally { try {
																		 * fileOut.close(); } catch (Exception e) { e.printStackTrace(); }
																		 * 
																		 * } return "Bank Reconciliation.xls";
																		 */

		String sOutFile = path + "/BankReconciliation.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		System.out.println("filepath" + sOutFile);
		try {
			fileOut = new FileOutputStream(sOutFile);
			workbook.write(fileOut);
			url = path + "/BankReconciliation.xls";
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

	public void setExcelMainHeaderNEW(HSSFSheet excelSheet, BankReconciliationResultBean rsBean, HSSFCellStyle my_style,String sFromDate, String sToDate) {
		
		
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India ");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		/*Row row3 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 9));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue( sFromDate +" TO " + sToDate);
		cell3.setCellStyle(my_style);
*/
		
		
		
		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 9));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue(sFromDate +" TO " + sToDate);
		cell2.setCellStyle(my_style);

		
		Row row3 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 9));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue("Bank Reconcilation");
		cell3.setCellStyle(my_style);
		
	}

}
