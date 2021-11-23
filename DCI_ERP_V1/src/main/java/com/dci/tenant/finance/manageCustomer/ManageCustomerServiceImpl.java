package com.dci.tenant.finance.manageCustomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ManageCustomerServiceImpl implements ManageCustomerService {

	@Autowired
	ManagecustomerDAO objmanageCustomerDAO;

	@Override
	public ManageCustomerResultBean getCityList() {
		return objmanageCustomerDAO.getCityList();
	}

	@Override
	public ManageCustomerResultBean getCityStateCountryList(int cityId) {
		return objmanageCustomerDAO.getCityStateCountryList(cityId);
	}

	@Override
	public List<ManageCustomerBean> saveCustomerData(ManageCustomerBean objManageCustomerBean, String userId) {
		return objmanageCustomerDAO.saveCustomerData(objManageCustomerBean, userId);
	}

	@Override
	public List<ManageCustomerBean> getCustomerList(int limit, int offset, String entityType) {
		return objmanageCustomerDAO.getCustomerList(limit, offset, entityType);
	}

	@Override
	public ManageCustomerBean getCustomerDataOnEdit(int entityId, String screenName) {
		return objmanageCustomerDAO.getCustomerDataOnEdit(entityId, screenName);
	}

	@Override
	public List<ManageCustomerBean> updateCustmerData(ManageCustomerBean objManageCustomerBean, String userId) {
		return objmanageCustomerDAO.updateCustmerData(objManageCustomerBean, userId);
	}

	@Override
	public ManageCustomerResultBean getpaymentList() {
		return objmanageCustomerDAO.getpaymentList();
	}

	@Override
	public boolean deleteEntityMaster(Integer entityId) {
		return objmanageCustomerDAO.deleteEntityMaster(entityId);
	}

	@Override
	public int checkVendorName(String entityName) throws Exception {
		return objmanageCustomerDAO.checkVendorName(entityName);
	}

	@Override
	public int checkCustomerName(String entityName) throws Exception {
		return objmanageCustomerDAO.checkCustomerName(entityName);
	}

	@Override
	public boolean deleteEntityCustMaster(Integer entityId) {
		// TODO Auto-generated method stub
		return objmanageCustomerDAO.deleteEntityCustMaster(entityId);
	}

}
