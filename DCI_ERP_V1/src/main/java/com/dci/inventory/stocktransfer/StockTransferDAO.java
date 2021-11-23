package com.dci.inventory.stocktransfer;

import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public interface StockTransferDAO {

	public List<Object> getDropdown();

	public List<StockTransferBean> getItemrequisition(String id);

	public List<StockTransferBean> getItemrequisition1(String id);

	public void InsertStockHdr(StockTransferBean bean);

	public void InsertStockHdr1(StockTransferBean bean);

	public StockTransferBean getGeneralInvoiceForView(int invoiceNo);

	public List<StockTransferBean> getListPage();

	public List<StockTransferBean> getItem(String companyId);

	public void deleteStock(int id);

	public List<StockTransferBean> getEditData(int id);

	public void updateStockHdr(StockTransferBean bean);

	public List<GRNPurchaseOrderBean> getBatchNoDetails(int itemId, int sourceLoc);

	public List<StockTransferBean> getDtlList(int itemId, int destLoc, String companyId);

	public StockTransferBean getRequisition(String requestNumber);

	public StockTransferBean getItemrequisition(String id, String itemCode);

	public boolean InsertStockHdrImport(List<StockTransferBean> bean);

	public List<SelectivityBean> issueTypeList();

	public List<StockTransferBean> ItemList(int destId, String companyId);

	public void InsertStockHdrKitchen(StockTransferBean bean);

	public StockTransferBean getQtyFromStock(int itemId, int destId, String companyId);

	public List<StockTransferBean> getRequisitionListCompanyBased(String companyYd);

}
