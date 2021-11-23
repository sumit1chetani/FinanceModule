package com.dci.tenant.finance.creditnote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CreditNoteServiceImpl implements CreditNoteService {

	@Autowired
	CreditNoteDAO objCreditNoteDAO;

	@Override
	public List<CreditNoteBean> getAcctHeadComboList() {
		return objCreditNoteDAO.getAcctHeadComboList();
	}

	@Override
	public List<CreditNoteBean> getInvoiceNoList(String sAcctHeadCode) {
		return objCreditNoteDAO.getInvoiceNoList(sAcctHeadCode);
	}

	@Override
	public List<CreditNoteBean> getCreditNoteList(int limit, int offset) {
		return objCreditNoteDAO.getCreditNoteList(limit, offset);
	}

	@Override
	public boolean saveCRData(CreditNoteBean objCreditNoteBean, String userId, String companyCode) {
		return objCreditNoteDAO.saveCreditNoteData(objCreditNoteBean, userId, companyCode);
	}

	@Override
	public boolean approveCreditNoteData(String creditnoteCode, String creditNoteStatus, String userId) {
		return objCreditNoteDAO.approveCreditNoteData(creditnoteCode, creditNoteStatus, userId);
	}

	@Override
	public CreditNoteBean getCreditNoteForEdit(String creditCode) {
		return objCreditNoteDAO.getCreditNoteForEdit(creditCode);
	}

	@Override
	public boolean updateCRData(CreditNoteBean objCreditNoteBean, String userId) {
		return objCreditNoteDAO.updateCRData(objCreditNoteBean, userId);
	}

	@Override
	public boolean deleteCreditNote(String creditCode) {
		return objCreditNoteDAO.deleteCreditNote(creditCode);
	}

	@Override
	public List<CreditNoteBean> reverseList() {
		return objCreditNoteDAO.reverseList();
	}

	@Override
	public String reversePayment(String creditNoteNo, String createdDate) {
		return objCreditNoteDAO.reversePayment(creditNoteNo, createdDate);
	}
}
