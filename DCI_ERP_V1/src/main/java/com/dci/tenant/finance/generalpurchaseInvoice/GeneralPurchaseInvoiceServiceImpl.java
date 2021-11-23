package com.dci.tenant.finance.generalpurchaseInvoice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dci.common.util.CustomException;

@Component
public class GeneralPurchaseInvoiceServiceImpl implements GeneralPurchaseInvoiceService {

	@Autowired
	GeneralPurchaseInvoiceDAO objPurchaseInvoiceDAO;

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getSupplierList() throws CustomException {
		return objPurchaseInvoiceDAO.getSupplierList();
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getGrnList() throws CustomException {
		return objPurchaseInvoiceDAO.getGrnList();
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getWoList() throws CustomException {
		return objPurchaseInvoiceDAO.getWoList();

	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getChargeList() {
		return objPurchaseInvoiceDAO.getChargeList();
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getItemList() {
		return objPurchaseInvoiceDAO.getItemList();
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getCompanyList() throws CustomException {
		return objPurchaseInvoiceDAO.getCompanyList();
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getPurchaseInvoiceList() throws CustomException {
		return objPurchaseInvoiceDAO.getPurchaseInvoiceList();
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getPurchaseInvoiceDetail(String sPurchaseInvoiceNo) {
		return objPurchaseInvoiceDAO.getPurchaseInvoiceDetail(sPurchaseInvoiceNo);
	}

	@Override
	public boolean updatePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean) {
		return objPurchaseInvoiceDAO.updatePurchaseInvoice(objPurchaseInvoiceBean);
	}

	@Override
	public boolean savePurchaseInvoice(GeneralPurchaseInvoiceHeaderBean objPurchaseInvoiceBean) throws CustomException {
		boolean isSuccess = objPurchaseInvoiceDAO.savePurchaseInvoice(objPurchaseInvoiceBean);
		return true;

	}

	@Override
	public boolean deletePurchaseInvoice(String invoiceNo) throws CustomException {
		return objPurchaseInvoiceDAO.deletePurchaseInvoice(invoiceNo);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getGrnDetail(int igrnId) {
		return objPurchaseInvoiceDAO.getGrnDetail(igrnId);
	}

	@Override
	public boolean exportToPurchaseInvoicePdf(String puchaseInvoiceNo, ServletContext context) {
		return objPurchaseInvoiceDAO.exportToPurchaseInvoicePdf(puchaseInvoiceNo, context);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean checkFreightCharges(int igrnId) {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.checkFreightCharges(igrnId);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getEditcheckFreightCharges(int igrnId) {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.getEditcheckFreightCharges(igrnId);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getExchangeRates(String currencyCode) throws Exception {

		return objPurchaseInvoiceDAO.getExchangeRates(currencyCode);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean getCurrencyCode(String currencyCode) throws Exception {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.getCurrencyCode(currencyCode);
	}

	@Override
	public GeneralPurchaseInvoiceHeaderBean printPaymentVoucher(String voucherNo) throws CustomException {
		// TODO Auto-generated method stub
		return objPurchaseInvoiceDAO.printPaymentVoucher(voucherNo);
	}

	/*
	 * @Override public List<GeneralPurchaseInvoiceHeaderBean>
	 * getCostCenterList(String company) throws CustomException { return
	 * objPurchaseInvoiceDAO.getCostCenterList(company);
	 * 
	 * }
	 */
	@Override
	public List getCostCenterList(String companyCode) {
		return objPurchaseInvoiceDAO.getCostCenterList(companyCode);
	}

	@Override
	public List<GeneralPurchaseInvoiceHeaderBean> getDtl(Integer num) {
		return objPurchaseInvoiceDAO.getDtl(num);
	}

}
