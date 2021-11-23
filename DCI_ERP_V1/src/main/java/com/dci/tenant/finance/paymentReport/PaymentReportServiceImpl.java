package com.dci.tenant.finance.paymentReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.finance.GeneralLedger.GeneralLedgerBean;
import com.dci.tenant.finance.cashbankpayment.CashBankPaymentDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Transactional
@Service
public class PaymentReportServiceImpl implements PaymentReportService {

	@Autowired
	CashBankPaymentDAO objCashBankPaymentDAO;

	@Autowired
	PaymentReportDAO PaymentReportDAO;

	@Override
	public PaymentReportResultBean getList() {
		// TODO Auto-generated method stub
		return PaymentReportDAO.getList();
	}

	@Override
	public List<PaymentHistoryReportBean> SearchList(PaymentHistoryReportBean bean) {
		// TODO Auto-generated method stub
		return PaymentReportDAO.SearchList(bean);
	}

	@Override
	public boolean exportPendingPmtExcel(String filepath, PaymentHistoryReportBean bean) {

		boolean isSuccess =false;
		List<PaymentHistoryReportBean> lPendingPmtList = PaymentReportDAO.SearchList(bean);
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
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			HSSFSheet excelSheet = workbook.createSheet("Pending Payment Report");

			// set main header
			setExcelMainHeaderForPendingPmtReport(excelSheet, my_style,bean);

			// set header
			setExcelHeaderForPendingPmtReport(excelSheet, my_style1);

			// set Data
			setExcelRowsForPendingPmtReport(excelSheet, lPendingPmtList, my_style2, my_style3);

			for (int i = 0; i < 7; i++) {
				excelSheet.autoSizeColumn(i);
			}
			if (lPendingPmtList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			// export excell
			String sFileUrl = writeExcelForPendingPmtReport(workbook, filepath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	/**
	 * set Excel Main Header
	 * 
	 * @param excelSheet
	 * @param my_style
	 * @param bean 
	 */
	public void setExcelMainHeaderForPendingPmtReport(HSSFSheet excelSheet, HSSFCellStyle my_style, PaymentHistoryReportBean bean) {
		
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);
		
		
		
		Row row3 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 5));
		Cell cell3 = row3.createCell((short) 0);
		cell3.setCellValue(bean.getFromDate() + " TO " + bean.getToDate());
		cell3.setCellStyle(my_style);
		
		
		Row row2 = excelSheet.createRow((short) 3);
		excelSheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 5));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Pending Payment Report");
		cell2.setCellStyle(my_style);
	}

	public void setExcelHeaderForPendingPmtReport(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 4);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("Sl #");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Invoice No");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Invoice Dt");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Invoice Amt (BC)");


			Cell cell6 = row.createCell(4);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Paid Amt (BC)");

			Cell cell7 = row.createCell(5);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Balance Amt (BC)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsForPendingPmtReport(HSSFSheet excelSheet, List<PaymentHistoryReportBean> lPendingPmtList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 5, sno = 1;
		try {

			for (PaymentHistoryReportBean objPaymentHistoryReportBean : lPendingPmtList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 8; i++) {
					excelSheet.autoSizeColumn(i);
				}

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sInvoiceNo = objPaymentHistoryReportBean.getPurInvoiceNo();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sInvoiceNo));

				String sInvoiceDate = objPaymentHistoryReportBean.getPurInvoiceDate();
				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(sInvoiceDate);

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style3);
				cell3.setCellValue(objPaymentHistoryReportBean.getInvoiceBCAmt());

				
			
				Cell cell6 = row.createCell(4);
				cell6.setCellStyle(my_style3);
				cell6.setCellValue(objPaymentHistoryReportBean.getPaidAmountBC());

				Cell cell7 = row.createCell(5);
				cell7.setCellStyle(my_style3);
				cell7.setCellValue(objPaymentHistoryReportBean.getBcAmountHdr());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelForPendingPmtReport(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/PendingPaymentReport.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/PendingPaymentReport.xls";
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

	/**
	 * export Payment History Excel
	 * 
	 * @param filepath
	 */
	@Override
	public boolean exportPaymentHistoryExcel(String filepath) {

		boolean isSuccess =false;
		List<PaymentHistoryReportBean> lPmtHistoryList = objCashBankPaymentDAO.getPaymentHistoryExportList();
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
			org.apache.poi.ss.usermodel.Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
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
			HSSFSheet excelSheet = workbook.createSheet("Payment History");

			// set main header
			setExcelMainHeaderForPaymentHistory(excelSheet, my_style);

			// set header
			setExcelHeaderForPaymentHistory(excelSheet, my_style1);

			// set Data
			setExcelRowsForPaymentHistory(excelSheet, lPmtHistoryList, my_style2, my_style3);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// export excell
			String sFileUrl = writeExcelForPaymentHistory(workbook, filepath);
			if (lPmtHistoryList.size()> 0) {
				isSuccess = true;
			} else {
				isSuccess = false;

			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return isSuccess;
	}

	public void setExcelMainHeaderForPaymentHistory(HSSFSheet excelSheet, HSSFCellStyle my_style) {
		Row row = excelSheet.createRow((short) 0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 14));
		Cell cell = row.createCell((short) 0);
		cell.setCellValue("Dental Council of India");
		cell.setCellStyle(my_style);
		
		
		Row row1 = excelSheet.createRow((short) 1);
		excelSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 14));
		Cell cell1 = row1.createCell((short) 0);
		cell1.setCellValue("Aiwan-E-Galib Marg, Kotla Road, New Delhi");
		cell1.setCellStyle(my_style);

		Row row2 = excelSheet.createRow((short) 2);
		excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 14));
		Cell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("Payment History");
		cell2.setCellStyle(my_style);
	}

	public void setExcelHeaderForPaymentHistory(HSSFSheet excelSheet, HSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow((short) 3);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("S.No");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("Invoice No");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Invoice Dt");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Vendor");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("Due Dt");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("BC Amt");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Voucher No");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Voucher Dt");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Account Name");

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Invoice No");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Currency");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Exchange Rate");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Invoice Amt (BC)");

			Cell cell13 = row.createCell(13);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("Balance Amt (BC)");

			Cell cell14 = row.createCell(14);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue("Paid Amt (BC)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRowsForPaymentHistory(HSSFSheet excelSheet, List<PaymentHistoryReportBean> lPmtHistoryList, HSSFCellStyle my_style2, HSSFCellStyle my_style3) {
		int record = 4, sno = 1;
		int firstRow = 0, lastRow = 0;
		try {

			for (PaymentHistoryReportBean objPaymentHistoryReportBean : lPmtHistoryList) {
				Row row = excelSheet.createRow((short) record++);
				row.setHeight((short) 350);
				for (int i = 0; i < 15; i++) {
					excelSheet.autoSizeColumn(i);
				}
				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style2);
				cell0.setCellValue(sno++);

				String sPurInvoiceNo = objPaymentHistoryReportBean.getPurInvoiceNo();
				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style2);
				cell1.setCellValue(checkNullValue(sPurInvoiceNo));

				String sPurInvoiceDate = objPaymentHistoryReportBean.getPurInvoiceDate();
				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style2);
				cell2.setCellValue(checkNullValue(sPurInvoiceDate));

				String sVendor = objPaymentHistoryReportBean.getSupplierName();
				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style2);
				cell3.setCellValue(checkNullValue(sVendor));

				String sDueDate = objPaymentHistoryReportBean.getDueDate();
				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style2);
				cell4.setCellValue(sDueDate);

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style3);
				cell5.setCellValue(objPaymentHistoryReportBean.getBcAmountHdr());

				firstRow = record;

				if (objPaymentHistoryReportBean.getPendingRptDtlList().size() > 0) {
					for (PaymentHistoryReportBean objPmtInvBean : objPaymentHistoryReportBean.getPendingRptDtlList()) {
						Row rowInv = excelSheet.createRow((short) record++);
						rowInv.setHeight((short) 350);

						Cell cellInv0 = rowInv.createCell(0);
						cellInv0.setCellStyle(my_style2);
						cellInv0.setCellValue(sno++);

						rowInv.createCell(1).setCellStyle(my_style2);
						rowInv.createCell(2).setCellStyle(my_style2);
						rowInv.createCell(3).setCellStyle(my_style2);
						rowInv.createCell(4).setCellStyle(my_style2);
						rowInv.createCell(5).setCellStyle(my_style2);

						String sVoucherNo = objPmtInvBean.getVoucherNo();
						Cell cellInv6 = rowInv.createCell(6);
						cellInv6.setCellStyle(my_style2);
						cellInv6.setCellValue(checkNullValue(sVoucherNo));

						String sVoucherDate = objPmtInvBean.getVoucherDate();
						Cell cellInv7 = rowInv.createCell(7);
						cellInv7.setCellStyle(my_style2);
						cellInv7.setCellValue(checkNullValue(sVoucherDate));

						String sAccountName = objPmtInvBean.getAccountName();
						Cell cellInv8 = rowInv.createCell(8);
						cellInv8.setCellStyle(my_style2);
						cellInv8.setCellValue(checkNullValue(sAccountName));

						String invoiceNo = objPmtInvBean.getPurInvoiceNo();
						Cell cellInv9 = rowInv.createCell(9);
						cellInv9.setCellStyle(my_style2);
						cellInv9.setCellValue(checkNullValue(invoiceNo));

						String currency = objPmtInvBean.getCurrencyCode();
						Cell cellInv10 = rowInv.createCell(10);
						cellInv10.setCellStyle(my_style2);
						cellInv10.setCellValue(checkNullValue(currency));

						Cell cellInv11 = rowInv.createCell(11);
						cellInv11.setCellStyle(my_style3);
						cellInv11.setCellValue(objPmtInvBean.getExchangeRate());

						Cell cellInv12 = rowInv.createCell(12);
						cellInv12.setCellStyle(my_style3);
						cellInv12.setCellValue(objPmtInvBean.getInvoiceBCAmt());

						Cell cellInv13 = rowInv.createCell(13);
						cellInv13.setCellStyle(my_style3);
						cellInv13.setCellValue(objPmtInvBean.getBcBalanceAmt());

						Cell cellInv14 = rowInv.createCell(14);
						cellInv14.setCellStyle(my_style3);
						cellInv14.setCellValue(objPmtInvBean.getPaidAmountBC());

					}
				}
				lastRow = record;
				excelSheet.groupRow(firstRow, lastRow);
				excelSheet.setRowGroupCollapsed(firstRow, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcelForPaymentHistory(HSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/PaymentHistory.xls";

		File dirCreatory = new File(path);
		if (!dirCreatory.exists()) {
			dirCreatory.mkdir();
		}
		String url = "";

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sOutFile);
			myWorkBook.write(fileOut);
			url = path + "/PaymentHistory.xls";
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

	@Override
	public PaymentHistoryReportBean pdfExportNew(PaymentHistoryReportBean prreport, String exportFilesPath) {
	//	List<PaymentHistoryReportBean> lPendingPmtList = PaymentReportDAO.SearchList(bean);

		List<PaymentHistoryReportBean> Listbean = new ArrayList<>();
		try {
			Document document = new Document(PageSize.A4, 2, 2, 2, 2);

			//PdfWriter writer = null;

			PdfWriter	writer = PdfWriter.getInstance(document,
					new FileOutputStream(exportFilesPath + "/PendingPayment.pdf"));
			document.addAuthor("tg");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("tg");
			document.addTitle("Pending Payment");
			document.setPageSize(PageSize.A4);
			document.setMargins(50, 50, 50, 50);

			
			document.open();

			
			Listbean = PaymentReportDAO.SearchList(prreport);
			 Font bfBold123 = new Font(FontFamily.HELVETICA, 12,  Font.BOLD, new BaseColor(0, 0, 0)); 
				Paragraph paragraph = new Paragraph();
			Paragraph paragraphmain = new Paragraph();
			Paragraph paragraphmain1 = new Paragraph();
			Paragraph paragraphmain3 = new Paragraph();
			paragraphmain3 = new Paragraph("\n",bfBold123);
			paragraphmain = new Paragraph("Pending Payment Report\n",bfBold123);
			paragraphmain1 = new Paragraph("\n",bfBold123);
			paragraphmain.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphmain3);
			document.add(paragraphmain);
			document.add(paragraphmain1);
//			
			
			
			PdfPTable table = new PdfPTable(1);
			table.getDefaultCell().setBorder(0);
			Font bfBold12 = new Font(FontFamily.HELVETICA, 8,  Font.BOLD, new BaseColor(0, 0, 0)); 
			Font bf12 = new Font(FontFamily.HELVETICA, 8); 
			 
			   table = new PdfPTable(2);
			   table.getDefaultCell().setBorder(0);
			    table.setWidthPercentage(100);
				Font tableFont = FontFactory.getFont("Helvetica", 10, Font.NORMAL);

			

				table.addCell("\n");
				table.addCell("\n");
				table.addCell("\n");
			    
			    

				  DecimalFormat df = new DecimalFormat("0.00");

				   document.add(table);
			    

				   //specify column widths
				   float[] columnWidths = {5f, 5f, 5f, 5f, 4f};
				   //create PDF table with the given widths
				   PdfPTable table1 = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table1.setWidthPercentage(100f);
				 
				   //insert column headings
				   insertCell(table1, "INVOICE NO", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "INVOICE DT", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "INVOICE AMT (BC)", Element.ALIGN_CENTER, 1, bfBold12);
				   insertCell(table1, "PAID AMT (BC)", Element.ALIGN_CENTER, 1, bfBold12);				  
				   insertCell(table1, "BALANCE AMT (BC)", Element.ALIGN_CENTER, 1, bfBold12);


				   table1.setHeaderRows(1);
				 
				   //insert an empty row
				  /* insertCell(table1, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table1, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);*/
				   double orderTotal, total = 0;
				    
				   //just some random data to fill 
				   for(PaymentHistoryReportBean detail : Listbean){
				     
				 
					   BaseColor color = BaseColor.BLACK;
					   if (detail.getPurInvoiceNo()==null)
						   detail.setPurInvoiceNo("");
					   if (detail.getPurInvoiceDate()==null)
						   detail.setPurInvoiceDate("");
					  

					   insertCell(table1, "" +detail.getPurInvoiceNo()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +detail.getPurInvoiceDate()+"" , Element.ALIGN_CENTER,color, 1, bf12);
					   insertCell(table1, "" +df.format(detail.getInvoiceBCAmt())+"" , Element.ALIGN_RIGHT,color, 1, bf12);
					   insertCell(table1, "" +df.format(detail.getPaidAmountBC())+"" , Element.ALIGN_RIGHT,color, 1, bf12);
					   insertCell(table1, "" +df.format(detail.getBcAmountHdr())+"" , Element.ALIGN_RIGHT,color, 1, bf12); 
					   
				     
				   }
				   
				/*   insertCell(table1, "Total", Element.ALIGN_RIGHT, 6, bfBold12);
				   insertCell(table1, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);*/
				  
				   paragraph.add(table1);
				   // add the paragraph to the document
				   document.add(paragraph);
				 
			

			
			document.close();
	         writer.close();


	         prreport.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prreport;
	
	}
	
	
private void insertCell(PdfPTable table, String text, int align,BaseColor color, int colspan, Font font){
	   
	  //create a new cell with the specified Text and Font
	  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), (com.itextpdf.text.Font) font));
	  //set the cell alignment
	  cell.setHorizontalAlignment(align);
	  //set the cell column span in case you want to merge two or more cells
	  cell.setColspan(colspan);
	  cell.setBorderColor(color);
	  //in case there is no text and you wan to create an empty row
	  if(text.trim().equalsIgnoreCase("")){
	   cell.setMinimumHeight(10f);
	  }
	  //add the call to the table
	  table.addCell(cell);
	   
	 }

private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
	   
	  //create a new cell with the specified Text and Font
	  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
	  //set the cell alignment
	  cell.setHorizontalAlignment(align);
	  //set the cell column span in case you want to merge two or more cells
	  cell.setColspan(colspan);
	  //in case there is no text and you wan to create an empty row
	  if(text.trim().equalsIgnoreCase("")){
	   cell.setMinimumHeight(10f);
	  }
	  //add the call to the table
	  table.addCell(cell);
	   
	 }
}
