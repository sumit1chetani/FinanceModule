package com.dci.tenant.finance.bankreconciliation;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.SelectivityBean;

public interface BankReconciliationService {
	public List<SelectivityBean> getBankList();

	public String uploadFile(MultipartFile file, String sBankCode);

	public BankReconciliationResultBean getDifferenecList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception;

	public String reconcileRecords(List<BankReconciliationBean> alReconcileRecord) throws ParseException;

	public List<BankReconciliationBean> getReconcileList(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception;

	public String approve(int bank_stmt_id) throws Exception;

	// public BankReconciliationBean bankreconcilePrint(int bank_stmt_id) throws
	// Exception ;
	BankReconciliationBean printBankmail(int bank_stmt_id) throws Exception;

	public String reject(int bank_stmt_id) throws Exception;

	public boolean getStatementAvaiablity(String sFromDate, String sToDate, String sBankCode);

	public BankReconciliationBean getReconcileListDraft1(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception;

	public BankReconciliationBean getReconcileListNew(int limit, int offset, String sFromDate, String sToDate, String bankcode) throws Exception;

	public BankReconciliationBean getReconcileListDraft2(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception;

	public BankReconciliationResultBean getunReconcileBookAndBankStatement(String sFromDate, String sToDate, String sBankCode);

	public boolean exportunReconciledBankRecord(String sFilePath, String sFromDate, String sToDate, String sBankCode);

	public String reconcileRecordsDraft(List<BankReconciliationBean> reconcileRecords) throws ParseException;

	public List<BankReconciliationBean> getReconcileListDraft(int limit, int offset, String sFromDate, String sToDate, String sBankCode) throws Exception;

	// public List<BankReconciliationBean>
	// bulkMailCheck(List<BankReconciliationBean>
	// bankReconciliationBean,HttpServletRequest request);
	void getmail(HttpServletRequest request) throws Exception;

	public String generateExcel(List<BankReconciliationBean> bean);

	public String excludedRecords(BankReconciliationBean reconcileRecords);

	public boolean excellExport(BankReconciliationResultBean rsBean, String sFromDate, String sToDate, String exportFilesPath);

}
