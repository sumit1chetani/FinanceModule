package com.dci.tenant.finance.debitnote;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface DebitNoteService {
	List<DebitNoteBean> getDebitNoteList(int limit, int offset) throws Exception;

	public boolean saveDebitNoteData(DebitNoteBean objDebitNoteBean, String userId, String companyCode);

	public boolean deleteDebitNote(String debitNoteNo) throws Exception;

	DebitNoteBean getDebitNoteForEdit(String debitCode);

	boolean updateDebitAcct(DebitNoteBean objDebitNoteBean, String userId);

	public List<SelectivityBean> getDebitNoteCodeList();

	String reversePayment(String debitCode, String createdDate);
}
