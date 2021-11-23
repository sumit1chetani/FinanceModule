package com.dci.tenant.finance.bankcompany;

import java.util.List;

import com.dci.common.util.CustomException;

public interface BankcompanyDAO {

	public boolean addAcctHeadMastercom(BankcompanyBean objBankcompanyBean, String userId) throws Exception;

	List<BankcompanyBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	BankcompanyBean getBankcompanyValues(String bankCode) throws CustomException;

	public boolean deleteVendor(String bankCode) throws Exception;

	public boolean updateAcctHeadMaster(BankcompanyBean objBankcompanyBean) throws Exception;

	// public boolean deleteCurrency(String bankCode) throws CustomException;

}
