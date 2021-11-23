package com.dci.tenant.finance.bankcompany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class BankcompanyServiceImpl implements BankcompanyService {
	@Autowired
	BankcompanyDAO objBankcompanyDAO;

	@Override
	public boolean addAcctHeadMastercom(BankcompanyBean objSubGroupAccountBean, String userId) throws Exception {
		return objBankcompanyDAO.addAcctHeadMastercom(objSubGroupAccountBean, userId);
	}

	@Override
	public List<BankcompanyBean> getAcctHeadMasterList(int limit, int offset) throws Exception {
		return objBankcompanyDAO.getAcctHeadMasterList(limit, offset);
	}

	@Override
	public BankcompanyBean getBankcompanyValues(String bankCode) throws CustomException {
		// TODO Auto-generated method stub
		return objBankcompanyDAO.getBankcompanyValues(bankCode);

	}

	@Override
	public boolean deleteVendor(String bankCode) throws Exception {
		// TODO Auto-generated method stub return
		return objBankcompanyDAO.deleteVendor(bankCode);
	}

	@Override
	public boolean updateAcctHeadMaster(BankcompanyBean objBankcompanyBean) throws Exception {
		return objBankcompanyDAO.updateAcctHeadMaster(objBankcompanyBean);
	}
	/*
	 * @Override public boolean deleteCurrency(String bankCode) throws
	 * CustomException { return objBankcompanyDAO.deleteCurrency(bankCode);
	 * 
	 * }
	 */
}
