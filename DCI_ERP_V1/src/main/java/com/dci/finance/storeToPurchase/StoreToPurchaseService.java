package com.dci.finance.storeToPurchase;

import java.util.List;

public interface StoreToPurchaseService {

	public StoreToPurchaseResultBean getEmployeeList() throws Exception;

	public StoreToPurchaseSubBean getItemList(int itemId) throws Exception;

	public boolean insertStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws Exception;

	public StoreToPurchaseResultBean getStoreToPurchaseById(int purchaseRequisitionId) throws Exception;

	public List<StoreToPurchase> getStoreToPurchaseList() throws Exception;

	public boolean updateStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws Exception;

	public boolean deleteStoreToPurchase(int purchaseRequisitionId) throws Exception;

	public StoreToPurchaseResultBean getAssetItemList();

}
