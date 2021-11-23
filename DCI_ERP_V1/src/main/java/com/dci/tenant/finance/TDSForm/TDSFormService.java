package com.dci.tenant.finance.TDSForm;

import java.util.List;

import com.dci.common.util.CustomException;

public interface TDSFormService {

	public boolean addAcctHeadMastercom(TDSFormBean objTDSFormBean, String userId) throws Exception;

	List<TDSFormBean> getAcctHeadMasterList(int limit, int offset) throws Exception;

	public TDSFormBean getBankcompanyValues(String tdsauto) throws CustomException;

	public boolean deleteVendor(String tdsauto) throws Exception;

	public boolean updateAcctHeadMaster(TDSFormBean objTDSFormBean) throws Exception;

}
