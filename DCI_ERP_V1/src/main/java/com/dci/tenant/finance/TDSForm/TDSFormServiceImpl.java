package com.dci.tenant.finance.TDSForm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class TDSFormServiceImpl implements TDSFormService {
	@Autowired
	TDSFormDAO objTDSFormDAO;

	@Override
	public boolean addAcctHeadMastercom(TDSFormBean objTDSFormBean, String userId) throws Exception {
		return objTDSFormDAO.addAcctHeadMastercom(objTDSFormBean, userId);
	}

	@Override
	public List<TDSFormBean> getAcctHeadMasterList(int limit, int offset) throws Exception {
		return objTDSFormDAO.getAcctHeadMasterList(limit, offset);
	}

	@Override
	public TDSFormBean getBankcompanyValues(String tdsauto) throws CustomException {
		// TODO Auto-generated method stub
		return objTDSFormDAO.getBankcompanyValues(tdsauto);

	}

	@Override
	public boolean deleteVendor(String tdsauto) throws Exception {
		// TODO Auto-generated method stub return
		return objTDSFormDAO.deleteVendor(tdsauto);
	}

	@Override
	public boolean updateAcctHeadMaster(TDSFormBean objTDSFormBean) throws Exception {
		return objTDSFormDAO.updateAcctHeadMaster(objTDSFormBean);
	}
}
