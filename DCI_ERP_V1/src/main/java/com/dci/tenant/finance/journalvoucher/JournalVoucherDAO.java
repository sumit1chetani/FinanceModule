package com.dci.tenant.finance.journalvoucher;

import java.util.List;

import com.dci.common.util.CustomException;


public interface JournalVoucherDAO {

	public List<JournalVoucherDTO> getJournalVoucherList(JournalVoucherBean journalVoucherBean) throws Exception;

	public boolean saveJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException;

	public boolean updateJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException;

	public boolean deleteJournalVoucherInfo(String objJournalVoucherId) throws Exception;

	public JournalVoucherDTO getJournalVoucherInfoOnEdit(String objJournalVoucherId) throws Exception;

	public List<JournalVoucherDTO> getLedgerList();
	
	public List<JournalVoucherDTO> getAccountHeadList();

	public List<JournalVoucherDTO> getCurrencyList();

	public List<JournalVoucherDTO> getCompanyList();

	public JournalVoucherDTO getJournalVoucherforPrint(String journalNo);

	List<JournalVoucherDTO> getAccountHeadMapList();

	List<JournalVoucherDTO> getAccountHeadCashMapList();

	public List<JournalVoucherBean> getjournalNo(String quotation);

	public boolean getloggedcompany(String closingDate, String formCode);

	public String reversePayment(String voucherNo, String createdDate);

	public List<JournalVoucherDTO> getSubAcctHeadList();

	public List<JournalVoucherDTO> getSubAcctHeadVendorList();

	public List<JournalVoucherDTO> getSubcollHeadList();

	public List<JournalVoucherDTO> getSubotherHeadList();

	public List<JournalVoucherDTO> getvendorList();
	public List<JournalVoucherDTO> getcpotherList();

	public List<JournalVoucherDTO> getAccountHeadNewList();

	public List<JournalVoucherDTO> getAccountHeadPayList();

	public List<JournalVoucherDTO> getcpothercusList();

	public String generateJournalVoucherNumber() throws CustomException;
	

}
