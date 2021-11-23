package com.dci.tenant.finance.creditnote;

import java.util.List;

public interface CreditNoteDAO {
	public List<CreditNoteBean> getAcctHeadComboList();

	public List<CreditNoteBean> getInvoiceNoList(String sAcctHeadCode);

	public List<CreditNoteBean> getCreditNoteList(int limit, int offset);

	public boolean saveCreditNoteData(CreditNoteBean objCreditNoteBean, String userId, String companyCode);

	public boolean approveCreditNoteData(String creditnoteCode, String creditNoteStatus, String userId);

	public CreditNoteBean getCreditNoteForEdit(String creditCode);

	public boolean updateCRData(CreditNoteBean objCreditNoteBean, String userId);

	public boolean deleteCreditNote(String creditCode);

	public List<CreditNoteBean> reverseList();

	public String reversePayment(String creditNoteNo, String createdDate);

}
