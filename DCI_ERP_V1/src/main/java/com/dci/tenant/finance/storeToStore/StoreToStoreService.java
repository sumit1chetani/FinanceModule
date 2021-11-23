package com.dci.tenant.finance.storeToStore;

import java.util.List;

public interface StoreToStoreService {

	public StoreToStoreResultBean getEmployeeList() throws Exception;

	public StoreToStoreSubBean getItemList(int itemId) throws Exception;

	public StoreToStoreResultBean checkQcItem(StoreToStore storeToStorebean) throws Exception;

	public boolean insertStoreToStore(StoreToStoreResultBean storeToStoreResultBean) throws Exception;

	public StoreToStoreResultBean getStoreToStoreById(int purchaseRequisitionId) throws Exception;

	public List<StoreToStore> getStoreToStoreList() throws Exception;

	public boolean updateStoreToStore(StoreToStoreResultBean storeToStoreResultBean) throws Exception;

	public boolean deleteStoreToStore(int purchaseRequisitionId) throws Exception;

	public int checkStockTransfer(int purchaseRequisitionId) throws Exception;

}
