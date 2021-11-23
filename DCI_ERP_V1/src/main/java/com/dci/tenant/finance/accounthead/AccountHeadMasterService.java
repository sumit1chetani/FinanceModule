package com.dci.tenant.finance.accounthead;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public interface AccountHeadMasterService {

	public AccountHeadMasterResultBean getSubGroupHead();

	List<AccountHeadMasterBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	public boolean addAcctHeadMaster(AccountHeadMasterBean objAccountHeadMasterBean, String userId) throws Exception;

	public AccountHeadMasterBean getAccountHeadValues(String accountCode) throws Exception;

	public boolean updateAcctHeadMaster(AccountHeadMasterBean objAccountHeadMasterBean) throws Exception;

	public boolean deleteAcctHeadMaster(String subAcctHeadMstrCode) throws Exception;

	public List<AttributeBean> getAttributeList();

	public AccountHeadMasterResultBean getCurrencyList();

	public AccountHeadMasterResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode);

	public List<String> getSGAttributeList(String sSubGroupCode);

	public List<AccountHeadMasterBean> searchportDtl(AccountHeadMasterBean objPendingapprovalBean) throws Exception;

	void excellExport(AccountHeadMasterResultBean ObjPendingapprovalResultBean, AccountHeadMasterBean objPendingapprovalBean, String pdfFile);
}
