package com.dci.inventory.stockApproval;

import java.util.List;

import com.dci.common.util.CustomException;

public interface StoreApprovalDAO {

	public StoreApprovalResultBean getEmployeeList() throws CustomException;

	public StoreApprovalSubBean getItemList(int itemId) throws CustomException;

	public StoreApprovalResultBean getStoreApprovalById(int purchaseRequisitionId) throws CustomException;

	public StoreApprovalResultBean getStoreApprovalByView(int purchaseRequisitionId) throws CustomException;

	public List<StoreApproval> getStoreApprovalList() throws CustomException;

	public boolean updateStoreApproval(StoreApprovalResultBean storeApprovalResultBean) throws CustomException;

	public boolean deleteStoreApproval(int purchaseRequisitionId) throws CustomException;

	public boolean Approval(int purchaseRequisitionId) throws Exception;

}
