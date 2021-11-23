package com.dci.tenant.finance.generalInvoice;

import java.util.List;

import javax.servlet.ServletContext;

import com.dci.common.util.CustomException;

public interface GeneralInvoiceDao {

	public List<GeneralInvoiceBean> getGeneralInvoiceList(int limit, int offset) throws CustomException;

	public List<GeneralInvoiceBean> getCustomerList();

	GeneralInvoiceBean printPaymentVoucher(String voucherNo);

	public List<GeneralInvoiceBean> getCustomertrue();

	public List<GeneralInvoiceBean> getAccountHeadList();

	public List<GeneralInvoiceBean> getCompanyList();

	public boolean saveGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean);

	public List<GeneralInvoiceBean> getSalesOrderList();

	public boolean deleteGeneralInvoice(String sInvoiceNo);

	public GeneralInvoiceBean getInvoiceDetail(String sInvoiceNo);

	public boolean updateGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean);

	public List<GeneralInvoiceBean> getItemList();

	public List<GeneralInvoiceBean> getGinList();

	public GeneralInvoiceBean getSODetail(int iSoNo);

	public List<GeneralInvoiceBean> getCurrencyList();

	public double getExchangeRate(String currencyCode);

	public boolean exportToGeneralInvoicePdf(String invoiceNo, ServletContext context);

	public GeneralInvoiceBean getGinDetailList(int soNo);
}
