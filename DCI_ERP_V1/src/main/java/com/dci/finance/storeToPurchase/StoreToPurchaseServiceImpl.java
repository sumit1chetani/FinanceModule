package com.dci.finance.storeToPurchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreToPurchaseServiceImpl implements StoreToPurchaseService {

	@Autowired
	StoreToPurchaseDAO storeToPurchaseDAO;

	@Override
	public StoreToPurchaseResultBean getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.getEmployeeList();
	}

	@Override
	public StoreToPurchaseSubBean getItemList(int itemId) throws Exception {
		// TODO Auto-generated method stub

		StoreToPurchaseSubBean storeToStoreSubBean = storeToPurchaseDAO.getItemList(itemId);
		return storeToStoreSubBean;
	}

	@Override
	public boolean insertStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.insertStoreToPurchase(storeToPurchaseResultBean);
	}

	@Override
	public StoreToPurchaseResultBean getStoreToPurchaseById(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.getStoreToPurchaseById(purchaseRequisitionId);
	}

	@Override
	public List<StoreToPurchase> getStoreToPurchaseList() throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.getStoreToPurchaseList();
	}

	@Override
	public boolean updateStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.updateStoreToPurchase(storeToPurchaseResultBean);
	}

	@Override
	public boolean deleteStoreToPurchase(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.deleteStoreToPurchase(purchaseRequisitionId);
	}

	@Override
	public StoreToPurchaseResultBean getAssetItemList() {
		// TODO Auto-generated method stub
		return storeToPurchaseDAO.getAssetItemList();
	}

}
