package com.dci.tenant.finance.debitnote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;

@Transactional
@Service
public class DebitNoteServiceImpl implements DebitNoteService {

	@Autowired
	DebitNoteDAO objDebitNoteDAO;

	@Override
	public List<DebitNoteBean> getDebitNoteList(int limit, int offset) throws Exception {
		return objDebitNoteDAO.getDebitNoteList(limit, offset);
	}

	@Override
	public boolean saveDebitNoteData(DebitNoteBean objDebitNoteBean, String userId, String companyCode) {
		return objDebitNoteDAO.saveDebitNoteData(objDebitNoteBean, userId, companyCode);
	}

	@Override
	public boolean deleteDebitNote(String debitNoteNo) throws Exception {
		return objDebitNoteDAO.deleteDebitNote(debitNoteNo);
	}

	@Override
	public DebitNoteBean getDebitNoteForEdit(String debitCode) {
		return objDebitNoteDAO.getDebitNoteForEdit(debitCode);
	}

	@Override
	public boolean updateDebitAcct(DebitNoteBean objDebitNoteBean, String userId) {
		return objDebitNoteDAO.updateDebitAcct(objDebitNoteBean, userId);
	}

	@Override
	public List<SelectivityBean> getDebitNoteCodeList() {
		// TODO Auto-generated method stub
		return objDebitNoteDAO.getDebitNoteCodeList();
	}

	@Override
	public String reversePayment(String debitCode, String createdDate) {
		// TODO Auto-generated method stub
		return objDebitNoteDAO.reversePayment(debitCode, createdDate);
	}
}
