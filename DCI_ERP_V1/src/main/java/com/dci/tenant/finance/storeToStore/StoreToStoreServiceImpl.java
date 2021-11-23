package com.dci.tenant.finance.storeToStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StoreToStoreServiceImpl implements StoreToStoreService {

	@Autowired
	StoreToStoreDAO storeToStoreDAO;

	//@Value("${location.virtual.consumable}")
	private String consumedLocation;

	@Override
	public StoreToStoreResultBean getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.getEmployeeList();
	}

	@Override
	public StoreToStoreSubBean getItemList(int itemId) throws Exception {
		// TODO Auto-generated method stub

		StoreToStoreSubBean storeToStoreSubBean = storeToStoreDAO.getItemList(itemId);
		return storeToStoreSubBean;
	}

	@Override
	public boolean insertStoreToStore(StoreToStoreResultBean storeToStoreResultBean) throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.insertStoreToStore(storeToStoreResultBean, consumedLocation);
	}

	@Override
	public StoreToStoreResultBean getStoreToStoreById(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.getStoreToStoreById(purchaseRequisitionId);
	}

	@Override
	public List<StoreToStore> getStoreToStoreList() throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.getStoreToStoreList();
	}

	@Override
	public boolean updateStoreToStore(StoreToStoreResultBean storeToStoreResultBean) throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.updateStoreToStore(storeToStoreResultBean, consumedLocation);
	}

	@Override
	public boolean deleteStoreToStore(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.deleteStoreToStore(purchaseRequisitionId);
	}

	@Override
	public int checkStockTransfer(int purchaseRequisitionId) throws Exception {
		return storeToStoreDAO.checkStockTransfer(purchaseRequisitionId);
	}

	@Override
	public StoreToStoreResultBean checkQcItem(StoreToStore storeToStorebean) throws Exception {
		// TODO Auto-generated method stub
		return storeToStoreDAO.checkQcItem(storeToStorebean);
	}

}
