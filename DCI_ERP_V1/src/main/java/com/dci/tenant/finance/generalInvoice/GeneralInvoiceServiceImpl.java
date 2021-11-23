package com.dci.tenant.finance.generalInvoice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralInvoiceServiceImpl implements GeneralInvoiceService {

	@Autowired
	GeneralInvoiceDao objGeneralInvoiceDao;

	@Override
	public List<GeneralInvoiceBean> getGeneralInvoiceList(int limit, int offset) throws Exception {

		return objGeneralInvoiceDao.getGeneralInvoiceList(limit, offset);
	}

	@Override
	public List<GeneralInvoiceBean> getCustomerList() {
		return objGeneralInvoiceDao.getCustomerList();
	}

	@Override
	public GeneralInvoiceBean printPaymentVoucher(String voucherNo) {
		// TODO Auto-generated method stub
		return objGeneralInvoiceDao.printPaymentVoucher(voucherNo);
	}

	@Override
	public List<GeneralInvoiceBean> getCustomertrue() {
		return objGeneralInvoiceDao.getCustomertrue();
	}

	@Override
	public List<GeneralInvoiceBean> getAccountHeadList() {
		return objGeneralInvoiceDao.getAccountHeadList();
	}

	@Override
	public boolean saveGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean) {
		return objGeneralInvoiceDao.saveGeneralInvoice(objGeneralInvoiceBean);
	}

	@Override
	public List<GeneralInvoiceBean> getCompanyList() {
		return objGeneralInvoiceDao.getCompanyList();
	}

	@Override
	public List<GeneralInvoiceBean> getSalesOrderList() {
		return objGeneralInvoiceDao.getSalesOrderList();
	}

	@Override
	public List<GeneralInvoiceBean> getGinList() {
		return objGeneralInvoiceDao.getGinList();
	}

	@Override
	public boolean deleteGeneralInvoice(String sInvoiceNo) {
		return objGeneralInvoiceDao.deleteGeneralInvoice(sInvoiceNo);
	}

	@Override
	public GeneralInvoiceBean getInvoiceDetail(String sInvoiceNo) {
		return objGeneralInvoiceDao.getInvoiceDetail(sInvoiceNo);
	}

	@Override
	public boolean updateGeneralInvoice(GeneralInvoiceBean objGeneralInvoiceBean) {
		return objGeneralInvoiceDao.updateGeneralInvoice(objGeneralInvoiceBean);
	}

	@Override
	public List<GeneralInvoiceBean> getItemList() {
		return objGeneralInvoiceDao.getItemList();
	}

	@Override
	public GeneralInvoiceBean getSODetail(int soNo) {
		return objGeneralInvoiceDao.getSODetail(soNo);
	}

	@Override
	public List<GeneralInvoiceBean> getCurrencyList() {
		return objGeneralInvoiceDao.getCurrencyList();
	}

	@Override
	public double getExchangeRate(String currencyCode) {
		return objGeneralInvoiceDao.getExchangeRate(currencyCode);
	}

	@Override
	public boolean exportToGeneralInvoicePdf(String invoiceNo, ServletContext context) {
		return objGeneralInvoiceDao.exportToGeneralInvoicePdf(invoiceNo, context);
	}

	@Override
	public GeneralInvoiceBean getGinDetailList(int ginId) {
		// TODO Auto-generated method stub
		return objGeneralInvoiceDao.getGinDetailList(ginId);
	}

}
