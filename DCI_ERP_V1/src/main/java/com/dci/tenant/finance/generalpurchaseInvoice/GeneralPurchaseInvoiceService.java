package com.dci.tenant.finance.generalpurchaseInvoice;

import java.util.List;

import javax.servlet.ServletContext;

import com.dci.common.util.CustomException;

public interface GeneralPurchaseInvoiceService {

	public List<GeneralPurchaseInvoiceHeaderBean> getSupplierList() throws CustomException;

	public List<GeneralPurchaseInvoiceHeaderBean> getGrnList() throws CustomException;

	public List<GeneralPurchaseInvoiceHeaderBean> getWoList() throws CustomException;

	public List<GeneralPurchaseInvoiceHeaderBean> getChargeList();

	public List<GeneralPurchaseInvoiceHeaderBean> getItemList();

	public List<GeneralPurchaseInvoiceHeaderBean> getCompanyList() throws CustomException;

	public List<GeneralPurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException;

	public boolean savePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws CustomException;

	public boolean deletePurchaseInvoice(String invoiceNo) throws CustomException;

	public GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo);

	public boolean updatePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean);

	public GeneralPurchaseInvoiceHeaderBean getGrnDetail(int igrnId);

	public GeneralPurchaseInvoiceHeaderBean checkFreightCharges(int igrnId);

	public GeneralPurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId);

	public boolean exportToPurchaseInvoicePdf(String puchaseInvoiceNo, ServletContext context);

	public GeneralPurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception;

	public GeneralPurchaseInvoiceHeaderBean getCurrencyCode(String currencyCode) throws Exception;

	GeneralPurchaseInvoiceHeaderBean printPaymentVoucher(String voucherNo) throws CustomException;

	public List getCostCenterList(String companyCode);

	public List<GeneralPurchaseInvoiceHeaderBean> getDtl(Integer num);

}
