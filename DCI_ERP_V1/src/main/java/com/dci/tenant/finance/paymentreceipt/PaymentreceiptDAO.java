package com.dci.tenant.finance.paymentreceipt;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public interface PaymentreceiptDAO {

	public PaymentreceiptResultBean getSubGroupHead();

	List<PaymentreceiptMasterBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	public boolean addAcctHeadMaster(PaymentreceiptMasterBean objSubGroupAccountBean, String userId) throws Exception;

	public PaymentreceiptMasterBean getAccountHeadValues(String subGrpAcctCode) throws Exception;

	public boolean updateAcctHeadMaster(PaymentreceiptMasterBean objSubGroupAccountBean) throws Exception;

	public boolean deleteAcctHeadMaster(String subGrpAcctCode) throws Exception;

	public List<AttributeBean> getAttributeList();

	public PaymentreceiptResultBean getCurrencyList();

	public List<String> getSGAttributeList(String sSubGroupCode);

	public PaymentreceiptResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode);

	public List<PaymentreceiptMasterBean> searchportDtl(PaymentreceiptMasterBean objPendingapprovalBean) throws Exception;

}
