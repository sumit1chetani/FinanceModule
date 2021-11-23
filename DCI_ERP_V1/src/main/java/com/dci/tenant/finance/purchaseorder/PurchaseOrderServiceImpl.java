package com.dci.tenant.finance.purchaseorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestSubBean;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	PurchaseOrderDao objPurchaseOrderDao;

	/*
	 * @Override public List<PurchaseOrder> getPurchaseOrderList(int
	 * purchaseType, String formCode, String userId) throws Exception { // TODO
	 * Auto-generated method stub return
	 * objPurchaseOrderDao.getPurchaseOrderList(purchaseType, formCode, userId);
	 * }
	 */

	@Override
	public List<PurchaseOrder> getPurchaseOrderList(int purchaseType) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderList(purchaseType);
	}

	@Override
	public List<PurchaseOrder> getTotalPurchaseOrderList() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getTotalPurchaseOrderList();
	}

	@Override
	public BasicResultBean savePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.savePurchaseOrder(purchaseOrder, userId);
	}

	@Override
	public boolean updatePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePurchaseOrder(purchaseOrder, userId);
	}

	@Override
	public boolean deletePurchaseOrder(int purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.deletePurchaseOrder(purchaseOrderId);
	}

	@Override
	public boolean deletePurchaseOrderDetail(int purchaseOrderDetailId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.deletePurchaseOrderDetail(purchaseOrderDetailId);
	}

	@Override
	public PurchaseOrder getPurchaseOrder(int purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrder(purchaseOrderId);
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDefList(int formFieldId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderDefList(formFieldId);
	}

	@Override
	public List<PurchaseSelect> getCompanyNames(String user) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getCompanyNames(user);
	}

	@Override
	public List<PurchaseSelect> getVendorNames() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getVendorNames();
	}

	@Override
	public List<PurchaseSelect> getPurchaseReqDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseReqDropDown();
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderDropDown();
	}

	@Override
	public List<PurchaseSelect> getPurchaseInvoiceDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseInvoiceDropDown();
	}

	@Override
	public List<PurchaseSelect> getMaterialIssueDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getMaterialIssueDropDown();
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderStatusDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderStatusDropDown();
	}

	@Override
	public List<PurchaseSelect> getGRNStatusDropDown() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getGRNStatusDropDown();
	}

	@Override
	public List<PurchaseSelect> getLocationNames() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getLocationNames();
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote(String purchaseDateFrom, String purchaseDateTo, int status, String entityId, int quoteStatus, int purchaseType) throws Exception {
		return objPurchaseOrderDao.getApprovedPurchaseQuote(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, purchaseType);
	}

	@Override
	public boolean updatePurchaseOrderStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception {
		return objPurchaseOrderDao.updatePurchaseOrderStatus(statusId, costCenter, purchaseOrderId, budget);
	}

	@Override
	public boolean saveRateContract(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.saveRateContract(purchaseOrder, userId);
	}

	@Override
	public PurchaseOrder getDeliveryPurchaseOrder(int purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getDeliveryPurchaseOrder(purchaseOrderId);
	}

	@Override
	public boolean updateDeliveryPurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updateDeliveryPurchaseOrder(purchaseOrder, userId);
	}

	@Override
	public boolean updatePurchaseOrderDeliverySchedule(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePurchaseOrderDeliverySchedule(purchaseOrder, userId);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderAmendmentList() throws Exception {
		return objPurchaseOrderDao.getPurchaseOrderAmendmentList();
	}

	@Override
	public PurchaseOrder getPurchaseOrderAmendment(int purchaseOrderId) throws Exception {
		return objPurchaseOrderDao.getPurchaseOrderAmendment(purchaseOrderId);
	}

	@Override
	public boolean updateDeliveryPurchaseOrderAmendment(PurchaseOrder purchaseOrder, String userId) throws Exception {
		return objPurchaseOrderDao.updateDeliveryPurchaseOrderAmendment(purchaseOrder, userId);
	}

	@Override
	public List<PurchaseSelect> getConsignmentTransferNumbers() throws Exception {
		return objPurchaseOrderDao.getConsignmentTransferNumbers();
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseConsignmentTransferNumbers(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int stockTransferId) throws Exception {
		return objPurchaseOrderDao.getApprovedPurchaseConsignmentTransferNumbers(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, stockTransferId);
	}

	@Override
	public boolean updateConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updateConsignmentOrder(purchaseOrder, userId);
	}

	@Override
	public boolean saveConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.saveConsignmentOrder(purchaseOrder, userId);
	}

	@Override
	public List<PurchaseOrder> getTotalPurchaseOrderCancelList() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getTotalPurchaseOrderCancelList();
	}

	@Override
	public List<PurchaseOrder> getFilteredPurchaseOrderList(PurchaseFilter purchaseFilter) throws Exception {
		return objPurchaseOrderDao.getFilteredPurchaseOrderList(purchaseFilter);
	}

	@Override
	public List<PurchaseSelect> getItemList() throws Exception {
		return objPurchaseOrderDao.getItemList();
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderSplitList() throws Exception {
		return objPurchaseOrderDao.getPurchaseOrderSplitList();
	}

	@Override
	public boolean exportPurchaseOrderPDF(int purchaseOrderId, ServletContext context) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.exportPurchaseOrderPDF(purchaseOrderId, context);
	}

	@Override
	public boolean updatePurchaseOrderCancelStatus(int statusId, int costCenter, int purchaseOrderId, String remarks, int budget) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePurchaseOrderCancelStatus(statusId, costCenter, purchaseOrderId, remarks, budget);
	}

	@Override
	public boolean updatePurchaseOrderCancelRemarksStatus(int statusId, int purchaseOrderId, String remarks) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePurchaseOrderCancelRemarksStatus(statusId, purchaseOrderId, remarks);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderForMerge() throws Exception {
		return objPurchaseOrderDao.getPurchaseOrderForMerge();
	}

	@Override
	public boolean updatePurchaseOrderMergeStatus(int cancelpurchaseOrderId, int mergepurchaseOrderId, String user) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePurchaseOrderMergeStatus(cancelpurchaseOrderId, mergepurchaseOrderId, user);
	}

	@Override
	public boolean updatePurchaseRecommend(PurchaseOrder purchaseOrder) throws Exception {
		return objPurchaseOrderDao.updatePurchaseRecommend(purchaseOrder);
	}

	@Override
	public List<PurchaseSelect> getConsignmentTransferNumbersEdit() throws Exception {
		return objPurchaseOrderDao.getConsignmentTransferNumbersEdit();
	}

	@Override
	public List<PurchaseOrder> getNotScheduledItemList(PurchaseOrder purchaseOrder) throws Exception {
		return objPurchaseOrderDao.getNotScheduledItemList(purchaseOrder);
	}

	@Override
	public List<PurchaseSelect> getPurchaseOrderDefList1(int formFieldId) throws Exception {
		return objPurchaseOrderDao.getPurchaseOrderDefList1(formFieldId);
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedConsignmentStockDetail(String stockTransferId) throws Exception {
		return objPurchaseOrderDao.getApprovedConsignmentStockDetail(Integer.parseInt(stockTransferId));
	}

	@Override
	public boolean saveSplitPurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception {

		List<PurchaseOrderDetail> orderDetails = purchaseOrder.getPurchaseOrderUpdateList();
		for (PurchaseOrderDetail detail : orderDetails) {
			objPurchaseOrderDao.updatePurchaseSplitQuantity(detail.getPurchaseOrderDetailId(), detail);
		}

		return objPurchaseOrderDao.savePurchaseOrderSplitted(purchaseOrder, userId);
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchasedDetailRateContract(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int purchaseType) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getApprovedPurchasedDetailRateContract(purchaseDateFrom, purchaseDateTo, status, entityId, quoteStatus, purchaseType);
	}

	@Override
	public boolean deletepqdetail(Integer purchasequotedetailId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.deletepqdetail(purchasequotedetailId);
	}

	@Override
	public PurchaseOrder getVendordetails(String vendorId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getVendordetails(vendorId);
	}

	@Override
	public PurchaseOrder getitemList(String requisitionNo, int itemId, double quantity) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getitemList(requisitionNo, itemId, quantity);
	}

	@Override
	public List<SelectivityBean> getCurrency() throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getCurrency();
	}

	@Override
	public List<SelectivityBean> BudgetTypeList(String poType) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.BudgetTypeList(poType);
	}

	@Override
	public String checkpurchaseOrderDetails(String purchaseOrderID) {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.checkpurchaseOrderDetails(purchaseOrderID);
	}

	@Override
	public PrintPurchaseOrderBean printPurchaseOrder(Integer purchaseOrderNo) {
		return objPurchaseOrderDao.printPurchaseOrder(purchaseOrderNo);
	}

	@Override
	public String getPOSequenceNumber(String POType) {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPOSequenceNumber(POType);
	}

	@Override
	public String getPOSeqCompanybased(String POType, String companyId) {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPOSeqCompanybased(POType, companyId);
	}

	@Override
	public PurchaseOrder updatePendingqty(String requisitionNo, int itemId, double quantity) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.updatePendingqty(requisitionNo, itemId, quantity);
	}

	@Override
	public PurchaseOrder getqtyValidation(int requisitionNo, int itemId, int poId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getqtyValidation(requisitionNo, itemId, poId);
	}

	@Override
	public List<ConsignmentRequestSubBean> costcenterList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.costcenterList(companyId);
	}

	@Override
	public PurchaseOrder getPurchaseOrderLog(String purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderLog(purchaseOrderId);
	}

	@Override
	public boolean deletepqdetail1(Integer purchasequotedetailId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.deletepqdetail1(purchasequotedetailId);
	}

	@Override
	public PurchaseOrder getAvailableQTY(int requisitionNo, int itemId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getAvailableQTY(requisitionNo, itemId);
	}

	@Override
	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote1(int status, String entityId, int purchaseType, String poNumber) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getApprovedPurchaseQuote1(status, entityId, purchaseType, poNumber);
	}

	@Override
	public PurchaseOrder getqtycheckFromPO(int requisitionNo, int itemId, int poId) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getqtycheckFromPO(requisitionNo, itemId, poId);
	}

	@Override
	public boolean updatePurchaseOrderWithoutRemarkStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception {
		return objPurchaseOrderDao.updatePurchaseOrderWithoutRemarkStatus(statusId, costCenter, purchaseOrderId, budget);
	}

	@Override
	public PurchaseOrder geYearlytBudgetAmount(PurchaseOrder purchaseOrder, String userId) {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.geYearlytBudgetAmount(purchaseOrder, userId);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderExportList(int purchaseType) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseOrderDao.getPurchaseOrderExportList(purchaseType);
	}

	@Override
	public boolean exportExcel(String sFilePath, List<PurchaseOrder> rsList) {

		try {
			// Blank workbook
			// HSSFWorkbook workbook = new HSSFWorkbook();
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			workbook.setCompressTempFiles(true);

			XSSFCellStyle my_style = (XSSFCellStyle) workbook.createCellStyle();
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style.setAlignment(my_style.ALIGN_CENTER);
			my_style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			my_style.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font = workbook.createFont();
			font.setFontHeight((short) 200);
			font.setFontName("Arial");
			font.setColor(HSSFColor.YELLOW.index);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 15);
			my_style.setFont(font);
			XSSFCellStyle my_style1 = (XSSFCellStyle) workbook.createCellStyle();
			my_style1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style1.setAlignment(my_style.ALIGN_CENTER);
			my_style1.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style1.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font1 = workbook.createFont();
			font1.setFontHeight((short) 200);
			font1.setFontName("Arial");
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font1.setFontHeightInPoints((short) 10);
			my_style1.setFont(font1);
			XSSFCellStyle my_style2 = (XSSFCellStyle) workbook.createCellStyle();
			my_style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style2.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			my_style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style3 = (XSSFCellStyle) workbook.createCellStyle();
			my_style3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			my_style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));

			XSSFCellStyle my_style4 = (XSSFCellStyle) workbook.createCellStyle();
			my_style4.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style4.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			my_style4.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			// my_style4.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			// Create a blank sheet

			XSSFCellStyle my_style11 = (XSSFCellStyle) workbook.createCellStyle();
			my_style11.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			my_style11.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			my_style11.setAlignment(my_style.ALIGN_CENTER);
			my_style11.setFillForegroundColor(HSSFColor.WHITE.index);
			my_style11.setFillPattern(my_style.SOLID_FOREGROUND);
			my_style11.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			Font font11 = workbook.createFont();
			font11.setFontHeight((short) 200);
			font11.setFontName("Arial");
			font11.setColor(HSSFColor.BLACK.index);
			// font11.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font11.setFontHeightInPoints((short) 10);
			my_style11.setFont(font11);

			SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("Purchase Order");
			excelSheet.setRandomAccessWindowSize(100);// keep 100 rows in
														// memory,

			// set main header
			setExcelMainHeader(excelSheet, my_style);

			// set header
			setExcelHeader(excelSheet, my_style1);

			for (int i = 0; i < 15; i++) {
				excelSheet.autoSizeColumn(i);
			}

			// set Data
			setExcelRows(excelSheet, rsList, my_style11, my_style2, my_style3, my_style4);

			// export excell
			String sFileUrl = writeExcel(workbook, sFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return true;

	}

	public void setExcelMainHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style) {
		Row row = excelSheet.createRow(0);
		excelSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 15));
		Cell cell = row.createCell(0);
		cell.setCellValue("PURCHASE ORDER");
		cell.setCellStyle(my_style);
	}

	public void setExcelHeader(SXSSFSheet excelSheet, XSSFCellStyle my_style1) {
		try {

			Row row = excelSheet.createRow(2);
			row.setHeight((short) 350);

			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(my_style1);
			cell0.setCellValue("PO Number");

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(my_style1);
			cell1.setCellValue("PO Date");

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(my_style1);
			cell2.setCellValue("Organization Name");

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(my_style1);
			cell3.setCellValue("Request Type");

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(my_style1);
			cell4.setCellValue("PO Type");

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(my_style1);
			cell5.setCellValue("Vendor ");

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(my_style1);
			cell6.setCellValue("Purchase For ");

			Cell cell7 = row.createCell(7);
			cell7.setCellStyle(my_style1);
			cell7.setCellValue("Destination Location");

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(my_style1);
			cell8.setCellValue("Cost Center");

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(my_style1);
			cell9.setCellValue("Status");

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(my_style1);
			cell10.setCellValue("Payment Days");

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(my_style1);
			cell11.setCellValue("Advance");

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(my_style1);
			cell12.setCellValue("Created By");

			Cell cell13 = row.createCell(13);
			cell13.setCellStyle(my_style1);
			cell13.setCellValue("Created Date");

			Cell cell14 = row.createCell(14);
			cell14.setCellStyle(my_style1);
			cell14.setCellValue("Modified By");

			Cell cell15 = row.createCell(15);
			cell15.setCellStyle(my_style1);
			cell15.setCellValue("Modified Date");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setExcelRows(SXSSFSheet excelSheet, List<PurchaseOrder> list, XSSFCellStyle my_style1, XSSFCellStyle my_style2, XSSFCellStyle my_style3, XSSFCellStyle my_style4) {
		int record = 3, sno = 1;
		int firstRow = 0, firstSgRow = 0;
		int lastRow = 0;
		double dTotalDebitAmt = 0.0, dTotalCreditAmt = 0.0;

		try {
			for (PurchaseOrder bean : list) {

				Row row = excelSheet.createRow(record++);
				row.setHeight((short) 350);

				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(my_style1);
				cell0.setCellValue(bean.getPurchaseOrderNum());

				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(my_style1);
				cell1.setCellValue(bean.getPurchaseOrderDate());

				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(my_style1);
				cell2.setCellValue(bean.getCompanyName());

				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(my_style1);
				cell3.setCellValue(bean.getReqType());

				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(my_style1);
				cell4.setCellValue(bean.getPurchaseTypeName());

				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(my_style1);
				cell5.setCellValue(bean.getVendorName());

				Cell cell6 = row.createCell(6);
				cell6.setCellStyle(my_style1);
				cell6.setCellValue(bean.getPurchaseForName());

				Cell cell7 = row.createCell(7);
				cell7.setCellStyle(my_style1);
				cell7.setCellValue(bean.getLocationName());

				Cell cell8 = row.createCell(8);
				cell8.setCellStyle(my_style1);
				cell8.setCellValue(bean.getCostcenterName());

				Cell cell9 = row.createCell(9);
				cell9.setCellStyle(my_style1);
				cell9.setCellValue(bean.getPurchaseStatus());

				Cell cell10 = row.createCell(10);
				cell10.setCellStyle(my_style1);
				cell10.setCellValue(bean.getPaymentTerms());

				Cell cell11 = row.createCell(11);
				cell11.setCellStyle(my_style1);
				cell11.setCellValue(bean.getAdvanceamt());

				Cell cell12 = row.createCell(12);
				cell12.setCellStyle(my_style1);
				cell12.setCellValue(bean.getCreatedBy());

				Cell cell13 = row.createCell(13);
				cell13.setCellStyle(my_style1);
				cell13.setCellValue(bean.getCreatedDate());

				Cell cell14 = row.createCell(14);
				cell14.setCellStyle(my_style1);
				cell14.setCellValue(bean.getModifiedBy());

				Cell cell15 = row.createCell(15);
				cell15.setCellStyle(my_style1);
				cell15.setCellValue(bean.getModifiedDate());

			}

			// for (int i = 0; i < 7; i++) {
			// excelSheet.autoSizeColumn(i);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String writeExcel(SXSSFWorkbook myWorkBook, String path) {

		String sOutFile = path + "/PurchaseOrder.xlsx";

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
			url = path + "/PurchaseOrder.xlsx";
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
