/*package com.mailapp.hospital.accounts.closingaccounts;

import java.util.ArrayList;
import java.util.List;

public interface ClosingAccountsService {
	public ArrayList<ClosingAccounts> getAccountList(ClosingAccounts bean);

	public boolean addAccountList(ClosingAccounts bean, String userId, String companyCode);

	public List<ClosingAccounts> getClosingAcctList();
}*/

package com.dci.tenant.finance.closingaccounts;

import java.util.List;

public interface ClosingAccountsService {

	public boolean insertManageCostCenter(ClosingAccounts objClosingAccountsBean) throws Exception;

	public List<ClosingAccounts> getList() throws Exception;

	public boolean update(ClosingAccounts objClosingAccountsBean) throws Exception;

	public ClosingAccounts edit(Integer closingAccountId) throws Exception;

	public boolean delete(Integer closingAccountId) throws Exception;

}
