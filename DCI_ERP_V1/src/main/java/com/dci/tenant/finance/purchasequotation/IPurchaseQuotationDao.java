package com.dci.tenant.finance.purchasequotation;

import java.util.List;

import com.dci.common.util.CustomException;
import com.dci.common.util.DefTableBean;
import com.dci.master.settings.UOM.EntityBean;
import com.dci.tenant.finance.storeToStore.StoreToStore;

public interface IPurchaseQuotationDao {

	public List<EntityBean> getVendorList() throws CustomException;

	public List<StoreToStore> getRequisitionList() throws CustomException;

	public List<StoreToStore> getRequisitionList(String companyId) throws CustomException;

	public List<StoreToStore> getRequisitionListByVendor(String vendorId) throws CustomException;

	public List<DefTableBean> getTaxList() throws CustomException;

	public PurchaseQuotationResultBean getRequisitionItemList(PurchaseQuotation purchaseQuotationd) throws CustomException;

	public PurchaseQuotationResultBean getWOItemList(PurchaseQuotation purchaseQuotation) throws CustomException;

	public PurchaseQuotationResultBean insertPurchaseQuotation(PurchaseQuotation purchaseQuotation) throws CustomException;

	public PurchaseQuotationResultBean deletePurchaseQuotation(Integer quotationId) throws CustomException;

	public PurchaseQuotationResultBean getPurchaseQuotationList() throws CustomException;

	public PurchaseQuotationResultBean getItem(int requisitionId, int itemId) throws CustomException;

	public PurchaseQuotationResultBean getWOItem(int requisitionId, int itemId) throws CustomException;

	public PurchaseQuotationResultBean getVendorDetails(String vendorId);

	public PurchaseQuotationResultBean getTaxDetails(int taxId);

	public PurchaseQuotation getPurchaseQuoteDataOnEdit(Integer quotationId);

	public PurchaseQuotationResultBean updatePurchaseQuotation(PurchaseQuotation purchaseQuotation);

	public PurchaseQuotationResultBean checkPurchaseQuotationNumber(PurchaseQuotationDetail purchaseQuotation) throws CustomException;

	public List<StoreToStore> getWorkOrderList(String companyId) throws CustomException;

}
