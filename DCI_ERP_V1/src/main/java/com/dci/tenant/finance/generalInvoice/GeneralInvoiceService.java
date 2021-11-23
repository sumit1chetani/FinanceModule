package com.dci.tenant.finance.generalInvoice;

import java.util.List;

import javax.servlet.ServletContext;

public interface GeneralInvoiceService {

	public List<GeneralInvoiceBean> getGeneralInvoiceList(int limit, int offset) throws Exception;

	public List<GeneralInvoiceBean> getCustomerList();

	public List<GeneralInvoiceBean> getCustomertrue();

	GeneralInvoiceBean printPaymentVoucher(String voucherNo);

	public List<GeneralInvoiceBean> getAccountHeadList();

	public boolean saveGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean);

	public List<GeneralInvoiceBean> getCompanyList();

	public List<GeneralInvoiceBean> getSalesOrderList();

	public List<GeneralInvoiceBean> getGinList();

	public boolean deleteGeneralInvoice(String sInvoiceNo);

	public GeneralInvoiceBean getInvoiceDetail(String sInvoiceNo);

	public boolean updateGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean);

	public List<GeneralInvoiceBean> getItemList();

	public GeneralInvoiceBean getSODetail(int soNo);

	public GeneralInvoiceBean getGinDetailList(int soNo);

	public List<GeneralInvoiceBean> getCurrencyList();

	public double getExchangeRate(String currencyCode);

	public boolean exportToGeneralInvoicePdf(String invoiceNo, ServletContext context);

}
