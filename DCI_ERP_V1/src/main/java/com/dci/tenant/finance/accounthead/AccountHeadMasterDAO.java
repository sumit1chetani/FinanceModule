package com.dci.tenant.finance.accounthead;

import java.util.List;

import com.dci.master.attributes.AttributeBean;

public interface AccountHeadMasterDAO {

	public AccountHeadMasterResultBean getSubGroupHead();

	List<AccountHeadMasterBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	public boolean addAcctHeadMaster(AccountHeadMasterBean objSubGroupAccountBean, String userId) throws Exception;

	public AccountHeadMasterBean getAccountHeadValues(String subGrpAcctCode) throws Exception;

	public boolean updateAcctHeadMaster(AccountHeadMasterBean objSubGroupAccountBean) throws Exception;

	public boolean deleteAcctHeadMaster(String subGrpAcctCode) throws Exception;

	public List<AttributeBean> getAttributeList();

	public AccountHeadMasterResultBean getCurrencyList();

	public List<String> getSGAttributeList(String sSubGroupCode);

	public AccountHeadMasterResultBean getvalidate(String accountHeadName, boolean edit, String accountHeadCode);

	public List<AccountHeadMasterBean> searchportDtl(AccountHeadMasterBean objPendingapprovalBean) throws Exception;

}
