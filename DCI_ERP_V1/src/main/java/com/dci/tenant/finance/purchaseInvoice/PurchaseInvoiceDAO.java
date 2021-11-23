package com.dci.tenant.finance.purchaseInvoice;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import com.dci.common.util.CustomException;

public interface PurchaseInvoiceDAO {

	public List<PurchaseInvoiceHeaderBean> getSupplierList() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getGrnList(String supplier);

	public List<PurchaseInvoiceHeaderBean> getChargeList();

	public List<PurchaseInvoiceHeaderBean> getItemList();

	public List<PurchaseInvoiceHeaderBean> getCompanyList() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getcostcenterlist() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException;

	public boolean savePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) throws CustomException;

	public boolean deletePurchaseInvoice(String invoiceNo) throws CustomException;

	public PurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo);

	public boolean updatePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceBean);

	public PurchaseInvoiceHeaderBean getGrnDetail(int igrnId);

	public PurchaseInvoiceHeaderBean checkFreightCharges(int igrnId);

	public PurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId);

	public boolean exportToPurchaseInvoicePdf(String puchaseInvoiceNo, ServletContext context);

	public PurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception;

	public PurchaseInvoiceHeaderBean getCurrencyCode(String currencyCode) throws Exception;

	List<PurchaseInvoiceHeaderBean> getBankAcctListcompanycode(String company);

	List<PurchaseInvoiceHeaderBean> getgrnsupplier(String supplier);

	public boolean checkComSupCost(String company, String supplier, String costCenter);

	public HashMap<String, String> getCompany();

	List<PurchaseInvoiceHeaderBean> grnNo(Integer grnNo);

	PurchaseInvoiceHeaderBean budpo(Integer grnNo);

	public HashMap<String, String> getSupplier();

	public HashMap<String, String> getCostCenter();

	public HashMap<String, String> getCharges();

	public String InsertUploadData(List<PurchaseInvoiceHeaderBean> bean);

	public boolean savePurchaseInvoiceDetailforUpload(PurchaseInvoiceHeaderBean objPurchaseInvoiceListBean) throws CustomException;

	public PurchaseInvoiceHeaderBean getPurchaseInvoiceForView(String puchaseInvoiceNo);

	public List<PurchaseInvoiceHeaderBean> getcostcenterlist1() throws CustomException;

}
