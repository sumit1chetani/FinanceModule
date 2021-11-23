package com.dci.tenant.finance.manageCustomer;

import java.util.List;

public interface ManageCustomerService {

	public ManageCustomerResultBean getCityList();

	public ManageCustomerResultBean getpaymentList();

	public ManageCustomerResultBean getCityStateCountryList(int cityId);

	public List<ManageCustomerBean> saveCustomerData(ManageCustomerBean objManageCustomerBean, String userId);

	public List<ManageCustomerBean> getCustomerList(int limit, int offset, String entityType);

	public ManageCustomerBean getCustomerDataOnEdit(int entityId, String screenName);

	public List<ManageCustomerBean> updateCustmerData(ManageCustomerBean objManageCustomerBean, String userId);

	public boolean deleteEntityMaster(Integer entityId);

	public int checkVendorName(String entityName) throws Exception;

	public int checkCustomerName(String entityName) throws Exception;

	public boolean deleteEntityCustMaster(Integer entityId);

}
