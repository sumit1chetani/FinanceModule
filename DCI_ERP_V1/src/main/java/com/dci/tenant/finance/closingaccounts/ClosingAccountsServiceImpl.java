/*package com.mailapp.hospital.accounts.closingaccounts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingAccountsServiceImpl implements ClosingAccountsService {
	@Autowired
	ClosingAccountsDAO objClosingAccountsDAO;

	@Override
	public ArrayList<ClosingAccounts> getAccountList(ClosingAccounts bean) {
		return objClosingAccountsDAO.getAccountList(bean);
	}

	@Override
	public boolean addAccountList(ClosingAccounts bean, String userId, String companyCode) {
		return objClosingAccountsDAO.addAccountList(bean, userId, companyCode);
	}

	@Override
	public List<ClosingAccounts> getClosingAcctList() {
		return objClosingAccountsDAO.getClosingAcctList();
	}

}*/

package com.dci.tenant.finance.closingaccounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingAccountsServiceImpl implements ClosingAccountsService {

	@Autowired
	ClosingAccountsDAO objClosingAccountsDAO;

	@Override
	public ClosingAccounts edit(Integer closingAccountId) throws Exception {
		// TODO Auto-generated method stub return
		return objClosingAccountsDAO.edit(closingAccountId);
	}

	@Override
	public boolean delete(Integer closingAccountId) throws Exception {
		// TODO Auto-generated method stub
		return objClosingAccountsDAO.delete(closingAccountId);

	}

	/*
	 * @Override public ClosingAccountsResultBean save(ClosingAccountsBean
	 * objClosingAccountsBean) { // TODO Auto-generated method stub return
	 * objClosingAccountsDAO.save(objClosingAccountsBean); }
	 */

	@Override
	public List<ClosingAccounts> getList() throws Exception {
		// TODO Auto-generated method stub
		return objClosingAccountsDAO.getList();
	}

	@Override
	public boolean insertManageCostCenter(ClosingAccounts objClosingAccountsBean) throws Exception {
		// TODO Auto-generated method stub
		return objClosingAccountsDAO.insertManageCostCenter(objClosingAccountsBean);
	}

	@Override
	public boolean update(ClosingAccounts objClosingAccountsBean) throws Exception {
		// TODO Auto-generated method stub
		return objClosingAccountsDAO.update(objClosingAccountsBean);
	}

	/*
	 * @Override public boolean update(ClosingAccountsResultBean
	 * objAccountingYearCloseBean) { // TODO Auto-generated method stub return
	 * objClosingAccountsDAO.update(objAccountingYearCloseBean); }
	 */
}
