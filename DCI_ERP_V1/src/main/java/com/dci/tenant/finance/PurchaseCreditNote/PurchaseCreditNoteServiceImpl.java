package com.dci.tenant.finance.PurchaseCreditNote;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

/**
 * This class Dispatches the user's service according to the service, it
 * redirects to DAOImpl class via DAO Interface
 * 
 * example the action may be get,add,update,delete and so on.
 * 
 * @author raghavan
 * @version 1.0
 * @revision 12-June-2015; Created
 */

@Service
public class PurchaseCreditNoteServiceImpl implements PurchaseCreditNoteService {

	@Autowired
	PurchaseCreditNoteDAO objCreditNoteDAO;

	@Override
	public List<PurchaseCreditNoteBean> getAcctHeadComboList() {
		return objCreditNoteDAO.getAcctHeadComboList();
	}

	@Override
	public List<PurchaseCreditNoteBean> getInvoiceNoList(String sAcctHeadCode) {
		return objCreditNoteDAO.getInvoiceNoList(sAcctHeadCode);
	}

	/*
	 * @Override public Invoice printInvoice(String invoiceNo, String compLoc)
	 * throws Exception { // TODO Auto-generated method stub return
	 * objCreditNoteDAO.printInvoice(invoiceNo, compLoc); }
	 */

	@Override
	public List<PurchaseCreditNoteBean> getCreditNoteList(int limit, int offset, String formCode, String userId) {
		return objCreditNoteDAO.getCreditNoteList(limit, offset, formCode, userId);
	}

	@Override
	public List<PurchaseCreditNoteBean> reverseList() {
		return objCreditNoteDAO.reverseList();
	}

	@Override
	public List<PurchaseCreditNoteBean> saveCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId) throws ParseException {
		return objCreditNoteDAO.saveCreditNoteData(objCreditNoteBean, userId);
	}

	@Override
	public boolean approveCreditNoteData(String creditnoteCode, String userId) {
		return objCreditNoteDAO.approveCreditNoteData(creditnoteCode, userId);
	}

	@Override
	public boolean approveCreditNoteSign(PurchaseCreditNoteBean purchaseCreditNoteBeans, String userId) {
		return objCreditNoteDAO.approveCreditNoteSign(purchaseCreditNoteBeans, userId);
	}

	@Override
	public PurchaseCreditNoteBean getCreditNoteForEdit(String creditCode) {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.getCreditNoteForEdit(creditCode);
	}

	@Override
	public PurchaseCreditNoteBean getCreditNoteForView(String creditCode) {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.getCreditNoteForView(creditCode);
	}

	@Override
	public PurchaseCreditNoteBean getVesselVoyageDetail(String invoiceNumber) {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.getVesselVoyageDetail(invoiceNumber);
	}

	@Override
	public boolean updateCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId) {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.updateCRData(objCreditNoteBean, userId);
	}

	@Override
	public boolean deleteCreditNote(String creditCode) throws CustomException {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.deleteCreditNote(creditCode);
	}

	@Override
	public String reversePCN(PurchaseCreditNoteBean objCreditNoteBean) {
		// TODO Auto-generated method stub
		return objCreditNoteDAO.reversePCN(objCreditNoteBean);
	}

	@Override
	public List<PurchaseCreditNoteBean> getSupplierCurExg(String sAcctHeadCode) {
		return objCreditNoteDAO.getSupplierCurExg(sAcctHeadCode);
	}

}