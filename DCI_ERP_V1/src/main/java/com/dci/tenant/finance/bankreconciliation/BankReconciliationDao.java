package com.dci.tenant.finance.bankreconciliation;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;

public interface BankReconciliationDao {

	public List<SelectivityBean> getBankList();

	public String uploadFile(MultipartFile file, String sBankCode);

	public BankReconciliationResultBean getDifferenceList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException;

	// void getmail() throws CustomException;
	public String reconcileRecords(List<BankReconciliationBean> alReconciledRecords) throws ParseException;

	public String reconcileRecordsDraft(List<BankReconciliationBean> alReconciledRecords);

	public List<BankReconciliationBean> getReconcileList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException;

	public BankReconciliationBean getReconcileListDraft1(int limit, int offset, String sFromDate, String sToDate, String sBankCode);

	public BankReconciliationBean getReconcileListDraft2(int limit, int offset, String sFromDate, String sToDate, String sBankCode);

	public String approve(int bank_stmt_id) throws Exception;

	public String reject(int bank_stmt_id) throws Exception;

	// BankReconciliationBean bankreconcilePrint(int bank_stmt_id) throws
	// Exception;
	BankReconciliationBean printBankmail(int bank_stmt_id) throws Exception;
	// public String approve(String invoiceNO) throws Exception;

	// public String reject(String invoiceNO) throws Exception;

	public boolean getStatementAvaiablity(String sFromDate, String sToDate, String sBankCode);

	public BankReconciliationResultBean getunReconcileBookAndBankStatement(String sFromDate, String sToDate, String sBankCode);

	public BankReconciliationBean getBankDetails(String sBankCode);

	List<BankReconciliationBean> getReconcileListDraft(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws CustomException;
	// public List<BankReconciliationBean>
	// bulkMailCheck(List<BankReconciliationBean>
	// bankReconciliationBean,HttpServletRequest request);

	void getmail(HttpServletRequest request);

	public BankReconciliationBean getReconcileListNew(int limit, int offset, String sFromDate, String sToDate, String bankcode);

	public String generateExcel(List<BankReconciliationBean> bean);

	public String excludedRecords(BankReconciliationBean reconcileRecords);

}
