package com.dci.tenant.finance.storeToStore;

import java.util.List;

import com.dci.common.util.CustomException;

public interface StoreToStoreDAO {

	public StoreToStoreResultBean getEmployeeList() throws CustomException;

	public StoreToStoreSubBean getItemList(int itemId) throws CustomException;

	public boolean insertStoreToStore(StoreToStoreResultBean storeToStoreResultBean, String consumedLocation) throws CustomException;

	public StoreToStoreResultBean getStoreToStoreById(int purchaseRequisitionId) throws CustomException;

	public List<StoreToStore> getStoreToStoreList() throws CustomException;

	public boolean updateStoreToStore(StoreToStoreResultBean storeToStoreResultBean, String consumedLocation) throws CustomException;

	public boolean deleteStoreToStore(int purchaseRequisitionId) throws CustomException;

	public int checkStockTransfer(int purchaseRequisitionId) throws Exception;

	public StoreToStoreResultBean checkQcItem(StoreToStore storeToStorebean) throws Exception;

}
