package com.dci.tenant.finance.PurchaseCreditNote;

import java.text.ParseException;
import java.util.List;

import com.dci.common.util.CustomException;

public interface PurchaseCreditNoteService {

	public List<PurchaseCreditNoteBean> getAcctHeadComboList();

	public List<PurchaseCreditNoteBean> getInvoiceNoList(String sAcctHeadCode);

	public List<PurchaseCreditNoteBean> getCreditNoteList(int limit, int offset, String formCode, String userId) throws Exception;

	public List<PurchaseCreditNoteBean> reverseList() throws Exception;

	public List<PurchaseCreditNoteBean> saveCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId) throws ParseException;

	public boolean approveCreditNoteData(String creditnoteCode, String userId);

	public boolean approveCreditNoteSign(PurchaseCreditNoteBean purchaseCreditNoteBeans, String userId);

	public PurchaseCreditNoteBean getCreditNoteForEdit(String creditCode);

	public PurchaseCreditNoteBean getVesselVoyageDetail(String creditCode);

	public PurchaseCreditNoteBean getCreditNoteForView(String creditCode);

	// public Invoice printInvoice(String invoiceNo, String compLoc) throws
	// Exception;

	public boolean updateCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId);

	public boolean deleteCreditNote(String creditCode) throws CustomException;

	public String reversePCN(PurchaseCreditNoteBean objCreditNoteBean);

	public List<PurchaseCreditNoteBean> getSupplierCurExg(String sAcctHeadCode);

}