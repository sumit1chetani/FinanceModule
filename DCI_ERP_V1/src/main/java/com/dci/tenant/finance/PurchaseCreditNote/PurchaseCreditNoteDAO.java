package com.dci.tenant.finance.PurchaseCreditNote;

import java.text.ParseException;
import java.util.List;

import com.dci.common.util.CustomException;

public interface PurchaseCreditNoteDAO {
	public List<PurchaseCreditNoteBean> getAcctHeadComboList();

	public List<PurchaseCreditNoteBean> getInvoiceNoList(String sAcctHeadCode);

	public List<PurchaseCreditNoteBean> getCreditNoteList(int limit, int offset, String formCode, String userId);

	public List<PurchaseCreditNoteBean> reverseList();

	// public Invoice printInvoice(String invoiceNo, String compLoc) throws
	// CustomException;

	public List<PurchaseCreditNoteBean> saveCreditNoteData(PurchaseCreditNoteBean objCreditNoteBean, String userId) throws ParseException;

	public boolean approveCreditNoteData(String creditnoteCode, String userId);

	public boolean approveCreditNoteSign(PurchaseCreditNoteBean purchaseCreditNoteBeans, String userId);

	public PurchaseCreditNoteBean getCreditNoteForEdit(String creditCode);

	public PurchaseCreditNoteBean getCreditNoteForView(String creditCode);

	public PurchaseCreditNoteBean getVesselVoyageDetail(String invoiceNumber);

	public boolean updateCRData(PurchaseCreditNoteBean objCreditNoteBean, String userId);

	public boolean deleteCreditNote(String creditCode) throws CustomException;

	public String reversePCN(PurchaseCreditNoteBean objCreditNoteBean);

	public List<PurchaseCreditNoteBean> getSupplierCurExg(String sAcctHeadCode);

	public String generateCreditNoteNumber(String sLocnName);
}