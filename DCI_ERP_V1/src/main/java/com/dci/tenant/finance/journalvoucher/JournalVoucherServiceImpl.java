package com.dci.tenant.finance.journalvoucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;

@Transactional
@Service
public class JournalVoucherServiceImpl implements JournalVoucherService {

	@Autowired
	JournalVoucherDAO journalVoucherDAO;

	@Override
	public List<JournalVoucherDTO> getJournalVoucherList(JournalVoucherBean journalVoucherBean) throws Exception {
		return journalVoucherDAO.getJournalVoucherList(journalVoucherBean);
	}

	@Override
	public boolean saveJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException {
		return journalVoucherDAO.saveJournalVoucherData(objJournalVoucherData, userId, companyCode);
	}

	@Override
	public boolean updateJournalVoucherData(JournalVoucherDTO objJournalVoucherData, String userId, String companyCode) throws CustomException {
		return journalVoucherDAO.updateJournalVoucherData(objJournalVoucherData, userId, companyCode);
	}

	@Override
	public boolean deleteJournalVoucherInfo(String objJournalVoucherId) throws Exception {

		return journalVoucherDAO.deleteJournalVoucherInfo(objJournalVoucherId);
	}

	@Override
	public JournalVoucherDTO getJournalVoucherInfo(String objJournalVoucherId) throws Exception {

		return journalVoucherDAO.getJournalVoucherInfoOnEdit(objJournalVoucherId);
	}
	
	@Override
	public List<JournalVoucherDTO> getLedgerList(){
		return journalVoucherDAO.getLedgerList();
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadList() {
		return journalVoucherDAO.getAccountHeadList();
	}

	@Override
	public List<JournalVoucherDTO> getSubAcctHeadList() {
		return journalVoucherDAO.getSubAcctHeadList();
	}

	@Override
	public List<JournalVoucherDTO> getSubAcctHeadVendorList() {
		return journalVoucherDAO.getSubAcctHeadVendorList();
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadMapList() {
		return journalVoucherDAO.getAccountHeadMapList();
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadCashMapList() {
		return journalVoucherDAO.getAccountHeadCashMapList();
	}

	@Override
	public List<JournalVoucherDTO> getCurrencyList() {
		return journalVoucherDAO.getCurrencyList();
	}

	@Override
	public List<JournalVoucherDTO> getCompanyList() {
		return journalVoucherDAO.getCompanyList();
	}

	@Override
	public JournalVoucherDTO getJournalVoucherforPrint(String jvNumber) {
		return journalVoucherDAO.getJournalVoucherforPrint(jvNumber);
	}

	@Override
	public List<JournalVoucherBean> getjournalNo(String jvcode) {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getjournalNo(jvcode);
	}

	@Override
	public boolean getloggedcompany(String closingDate, String formCode) {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getloggedcompany(closingDate, formCode);
	}

	@Override
	public String reversePayment(String voucherNo, String createdDate) {
		return journalVoucherDAO.reversePayment(voucherNo, createdDate);
	}

	@Override
	public List<JournalVoucherDTO> getSubcollHeadList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getSubcollHeadList();
	}

	@Override
	public List<JournalVoucherDTO> getSubotherHeadList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getSubotherHeadList();
	}

	@Override
	public List<JournalVoucherDTO> getvendorList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getvendorList();
	}

	@Override
	public List<JournalVoucherDTO> getcpotherList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getcpotherList();
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadNewList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getAccountHeadNewList();
	}

	@Override
	public List<JournalVoucherDTO> getAccountHeadPayList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getAccountHeadPayList();
	}

	@Override
	public List<JournalVoucherDTO> getcpothercusList() {
		// TODO Auto-generated method stub
		return journalVoucherDAO.getcpothercusList();
	}

	@Override
	public String generateJournalVoucherNumber() throws CustomException {
		// TODO Auto-generated method stub
		return journalVoucherDAO.generateJournalVoucherNumber();
	}
}
