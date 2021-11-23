/*package com.mailapp.hospital.accounts.closingaccounts;

import java.io.Serializable;
import java.util.List;

import com.mailapp.core.util.BasicResultBean;

public class ClosingAccountsResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ClosingAccounts objClosingAccounts = new ClosingAccounts();

	private List<ClosingAccounts> lClosingAccounts;

	public ClosingAccounts getObjClosingAccounts() {
		return objClosingAccounts;
	}

	public void setObjClosingAccounts(ClosingAccounts objClosingAccounts) {
		this.objClosingAccounts = objClosingAccounts;
	}

	public List<ClosingAccounts> getlClosingAccounts() {
		return lClosingAccounts;
	}

	public void setlClosingAccounts(List<ClosingAccounts> lClosingAccounts) {
		this.lClosingAccounts = lClosingAccounts;
	}

}*/

package com.dci.tenant.finance.closingaccounts;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class ClosingAccountsResultBean extends BasicResultBean implements Serializable {

	private ClosingAccounts closingaccounts = new ClosingAccounts();

	public ClosingAccounts getClosingaccounts() {
		return closingaccounts;
	}

	public void setClosingaccounts(ClosingAccounts closingaccounts) {
		this.closingaccounts = closingaccounts;
	}

	public boolean isSuccess;

	private List<ClosingAccounts> list;

	private List<String> Errors;

	@Override
	public List<String> getErrors() {
		return Errors;
	}

	public void setErrors(List<String> errors) {
		Errors = errors;
	}

	@Override
	public boolean isSuccess() {
		return isSuccess;
	}

	@Override
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<ClosingAccounts> getList() {
		return list;
	}

	public void setList(List<ClosingAccounts> list) {
		this.list = list;
	}

}
