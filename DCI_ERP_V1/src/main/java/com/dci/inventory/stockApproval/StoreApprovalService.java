package com.dci.inventory.stockApproval;

import java.util.List;

public interface StoreApprovalService {

	public StoreApprovalResultBean getEmployeeList() throws Exception;

	public StoreApprovalSubBean getItemList(int itemId) throws Exception;

	public StoreApprovalResultBean getStoreApprovalById(int purchaseRequisitionId) throws Exception;

	public StoreApprovalResultBean getStoreApprovalByView(int purchaseRequisitionId) throws Exception;

	public List<StoreApproval> getStoreApprovalList() throws Exception;

	public boolean updateStoreApproval(StoreApprovalResultBean storeToPurchaseResultBean) throws Exception;

	public boolean deleteStoreApproval(int purchaseRequisitionId) throws Exception;

	public boolean Approval(int purchaseRequisitionId) throws Exception;

}
