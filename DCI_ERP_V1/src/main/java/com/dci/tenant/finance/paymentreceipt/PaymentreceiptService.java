package com.dci.tenant.finance.paymentreceipt;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public interface PaymentreceiptService {

	public PaymentreceiptResultBean getSubGroupHead();

	List<PaymentreceiptMasterBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	public boolean addAcctHeadMaster(PaymentreceiptMasterBean objAccountHeadMasterBean, String userId) throws Exception;

	public PaymentreceiptMasterBean getAccountHeadValues(String accountCode) throws Exception;

	public boolean updateAcctHeadMaster(PaymentreceiptMasterBean objAccountHeadMasterBean) throws Exception;

	public boolean deleteAcctHeadMaster(String subAcctHeadMstrCode) throws Exception;

	public List<AttributeBean> getAttributeList();

	public PaymentreceiptResultBean getCurrencyList();

	public PaymentreceiptResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode);

	public List<String> getSGAttributeList(String sSubGroupCode);

	public List<PaymentreceiptMasterBean> searchportDtl(PaymentreceiptMasterBean objPendingapprovalBean) throws Exception;

	void excellExport(PaymentreceiptResultBean ObjPendingapprovalResultBean, PaymentreceiptMasterBean objPendingapprovalBean, String pdfFile);
}
