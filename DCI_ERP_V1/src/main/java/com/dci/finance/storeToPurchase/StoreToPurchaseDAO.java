package com.dci.finance.storeToPurchase;

import java.util.List;

import com.dci.common.util.CustomException;

public interface StoreToPurchaseDAO {

	public StoreToPurchaseResultBean getEmployeeList() throws CustomException;

	public StoreToPurchaseSubBean getItemList(int itemId) throws CustomException;

	public boolean insertStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws CustomException;

	public StoreToPurchaseResultBean getStoreToPurchaseById(int purchaseRequisitionId) throws CustomException;

	public List<StoreToPurchase> getStoreToPurchaseList() throws CustomException;

	public boolean updateStoreToPurchase(StoreToPurchaseResultBean storeToPurchaseResultBean) throws CustomException;

	public boolean deleteStoreToPurchase(int purchaseRequisitionId) throws CustomException;

	public StoreToPurchaseResultBean getAssetItemList();

}
