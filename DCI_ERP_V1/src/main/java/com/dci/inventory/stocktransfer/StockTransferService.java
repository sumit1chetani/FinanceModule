package com.dci.inventory.stocktransfer;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public interface StockTransferService {
	public StockTransferBean getGeneralInvoiceForView(int invoiceNo);

	public List<Object> getDropdown();

	public List<StockTransferBean> getItemrequisition(String id);

	public List<StockTransferBean> getItemrequisition1(String id);

	public void InsertStockHdr(StockTransferBean bean);

	public void InsertStockHdr1(StockTransferBean bean);

	public List<StockTransferBean> getListPage();

	public List<StockTransferBean> getItem(String companyId) throws CustomException;

	public void deleteStock(int id);

	public List<StockTransferBean> getEditData(int id);

	public void updateStockHdr(StockTransferBean bean);

	public List<GRNPurchaseOrderBean> getBatchNoDetails(int itemId, int sourceLoc);

	public List<StockTransferBean> getDtlList(int itemId, int destLoc, String companyId);

	public StockTransferResultBean uploadExeFile(MultipartFile file);

	public List<SelectivityBean> issueTypeList();

	public List<StockTransferBean> ItemList(int destId, String companyId);

	public StockTransferBean getQtyFromStock(int itemId, int destId, String companyId);

	public void InsertStockHdrKitchen(StockTransferBean bean);

	public List<StockTransferBean> getRequisitionListCompanyBased(String companyYd);

}
