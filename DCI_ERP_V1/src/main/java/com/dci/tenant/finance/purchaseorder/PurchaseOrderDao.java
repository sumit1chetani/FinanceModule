package com.dci.tenant.finance.purchaseorder;

import java.util.List;

import javax.servlet.ServletContext;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.tenant.finance.consignmentRequest.ConsignmentRequestSubBean;

public interface PurchaseOrderDao {

	// public List<PurchaseOrder> getPurchaseOrderList(int purchaseType, String
	// formCode, String userId) throws Exception;

	public List<PurchaseOrder> getPurchaseOrderList(int purchaseType) throws Exception;

	public List<PurchaseOrder> getTotalPurchaseOrderList() throws Exception;

	public List<PurchaseOrder> getPurchaseOrderAmendmentList() throws Exception;

	public List<PurchaseOrder> getTotalPurchaseOrderCancelList() throws Exception;

	public BasicResultBean savePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public boolean saveRateContract(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public boolean updatePurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public boolean deletePurchaseOrder(int purchaseOrderId) throws Exception;

	public boolean deletePurchaseOrderDetail(int purchaseOrderDetailId) throws Exception;

	public PurchaseOrder getPurchaseOrder(int purchaseOrderId) throws Exception;

	public PurchaseOrder getitemList(String requisitionNo, int itemId, double quantity) throws Exception;

	public PurchaseOrder getVendordetails(String vendorId) throws Exception;

	public List<PurchaseSelect> getPurchaseOrderDefList(int formFieldId) throws Exception;

	public List<PurchaseSelect> getCompanyNames(String user) throws Exception;

	public List<PurchaseSelect> getVendorNames() throws Exception;

	public List<PurchaseSelect> getPurchaseReqDropDown() throws Exception;

	public List<PurchaseSelect> getPurchaseOrderDropDown() throws Exception;

	public List<PurchaseSelect> getPurchaseInvoiceDropDown() throws Exception;

	public List<PurchaseSelect> getMaterialIssueDropDown() throws Exception;

	public List<PurchaseSelect> getPurchaseOrderStatusDropDown() throws Exception;

	public List<PurchaseSelect> getGRNStatusDropDown() throws Exception;

	public boolean deletepqdetail(Integer purchasequotedetailId) throws Exception;

	public List<PurchaseSelect> getLocationNames() throws Exception;

	public List<PurchaseSelect> getConsignmentTransferNumbers() throws Exception;

	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote(String purchaseDateFrom, String purchaseDateTo, int status, String entityId, int quoteStatus, int purchaseType) throws Exception;

	public List<PurchaseQuoteDetail> getApprovedPurchaseQuote1(int status, String entityId, int purchaseType, String poNumber) throws Exception;

	public List<PurchaseQuoteDetail> getApprovedPurchasedDetailRateContract(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int purchaseType) throws Exception;

	public boolean saveRateContractDetail(PurchaseOrderDetail purchaseOrderDetail, int purchaseOrderId, String userId) throws Exception;

	public PurchaseOrder getDeliveryPurchaseOrder(int purchaseOrderId) throws Exception;

	public boolean updateDeliveryPurchaseOrder(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public PurchaseOrder getPurchaseOrderAmendment(int purchaseOrderId) throws Exception;

	public boolean updateDeliveryPurchaseOrderAmendment(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public List<PurchaseQuoteDetail> getApprovedPurchaseConsignmentTransferNumbers(String purchaseDateFrom, String purchaseDateTo, int status, int entityId, int quoteStatus, int stockTransferId) throws Exception;

	public boolean updateConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public boolean saveConsignmentOrder(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public List<PurchaseOrder> getFilteredPurchaseOrderList(PurchaseFilter purchaseFilter) throws Exception;

	public List<PurchaseSelect> getItemList() throws Exception;

	public List<PurchaseOrder> getPurchaseOrderSplitList() throws Exception;

	public boolean exportPurchaseOrderPDF(int purchaseOrderId, ServletContext context) throws Exception;

	public boolean updatePurchaseOrderCancelStatus(int statusId, int costCenter, int purchaseOrderId, String remarks, int budget) throws Exception;

	public List<PurchaseOrder> getPurchaseOrderForMerge() throws Exception;

	public boolean updatePurchaseOrderMergeStatus(int cancelpurchaseOrderId, int mergepurchaseOrderId, String user) throws Exception;

	public boolean updatePurchaseRecommend(PurchaseOrder purchaseOrder) throws Exception;

	public boolean updatePurchaseOrderDeliverySchedule(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public List<PurchaseSelect> getConsignmentTransferNumbersEdit() throws Exception;

	public List<PurchaseOrder> getNotScheduledItemList(PurchaseOrder purchaseOrder) throws Exception;

	public List<PurchaseSelect> getPurchaseOrderDefList1(int formFieldId) throws Exception;

	public List<PurchaseQuoteDetail> getApprovedConsignmentStockDetail(int stockTransferId) throws Exception;

	public boolean updatePurchaseQuantity(int i, Double double1) throws Exception;

	public boolean updatePurchaseSplitQuantity(int i, PurchaseOrderDetail detail) throws Exception;

	public boolean savePurchaseOrderSplitted(PurchaseOrder purchaseOrder, String userId) throws Exception;

	public boolean updatePurchaseOrderCancelRemarksStatus(int statusId, int purchaseOrderId, String remarks) throws Exception;

	public List<SelectivityBean> getCurrency() throws Exception;

	public List<SelectivityBean> BudgetTypeList(String poType) throws Exception;

	public String checkpurchaseOrderDetails(String purchaseOrderID);

	public PrintPurchaseOrderBean printPurchaseOrder(Integer purchaseOrderNo);

	public String getPOSequenceNumber(String POType);

	public String getPOSeqCompanybased(String POType, String companyId);

	public PurchaseOrder updatePendingqty(String requisitionNo, int itemId, double quantity) throws Exception;

	public PurchaseOrder getqtyValidation(int requisitionNo, int itemId, int poId) throws Exception;

	public List<ConsignmentRequestSubBean> costcenterList(String companyId) throws Exception;

	public PurchaseOrder getPurchaseOrderLog(String purchaseOrderId) throws Exception;

	public boolean deletepqdetail1(Integer purchasequotedetailId) throws Exception;

	public PurchaseOrder getAvailableQTY(int requisitionNo, int itemId) throws Exception;

	public PurchaseOrder getqtycheckFromPO(int requisitionNo, int itemId, int poId) throws Exception;

	boolean updatePurchaseOrderWithoutRemarkStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception;

	boolean updatePurchaseOrderStatus(int statusId, int costCenter, int purchaseOrderId, int budget) throws Exception;

	public PurchaseOrder geYearlytBudgetAmount(PurchaseOrder purchaseOrder, String userId);

	public List<PurchaseOrder> getPurchaseOrderExportList(int purchaseType) throws Exception;

}
