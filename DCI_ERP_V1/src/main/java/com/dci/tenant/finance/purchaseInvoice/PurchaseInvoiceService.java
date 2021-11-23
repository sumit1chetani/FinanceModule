package com.dci.tenant.finance.purchaseInvoice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;

public interface PurchaseInvoiceService {

	public List<PurchaseInvoiceHeaderBean> getSupplierList() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getGrnList(String supplier) throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getChargeList();

	public List<PurchaseInvoiceHeaderBean> getItemList();

	public List<PurchaseInvoiceHeaderBean> getCompanyList() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getcostcenterlist() throws CustomException;

	public List<PurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException;

	public boolean savePurchaseInvoice(PurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws CustomException;

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

	List<PurchaseInvoiceHeaderBean> grnNo(Integer grnNo);

	PurchaseInvoiceHeaderBean budpo(Integer grnNo);

	List<PurchaseInvoiceHeaderBean> getgrnsupplier(String supplier);

	public String uploadFile(MultipartFile file);

	public PurchaseInvoiceHeaderBean getPurchaseInvoiceForView(String puchaseInvoiceNo);

	public List<PurchaseInvoiceHeaderBean> getcostcenterlist1() throws CustomException;

}
