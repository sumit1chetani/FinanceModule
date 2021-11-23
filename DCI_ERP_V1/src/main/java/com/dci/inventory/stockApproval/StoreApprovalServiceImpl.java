package com.dci.inventory.stockApproval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreApprovalServiceImpl implements StoreApprovalService {

	@Autowired
	StoreApprovalDAO storeApprovalDAO;

	@Override
	public StoreApprovalResultBean getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.getEmployeeList();
	}

	@Override
	public StoreApprovalSubBean getItemList(int itemId) throws Exception {
		// TODO Auto-generated method stub

		StoreApprovalSubBean storeToStoreSubBean = storeApprovalDAO.getItemList(itemId);
		return storeToStoreSubBean;
	}

	@Override
	public StoreApprovalResultBean getStoreApprovalById(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.getStoreApprovalById(purchaseRequisitionId);
	}

	@Override
	public StoreApprovalResultBean getStoreApprovalByView(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.getStoreApprovalByView(purchaseRequisitionId);
	}

	@Override
	public List<StoreApproval> getStoreApprovalList() throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.getStoreApprovalList();
	}

	@Override
	public boolean updateStoreApproval(StoreApprovalResultBean storeApprovalResultBean) throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.updateStoreApproval(storeApprovalResultBean);
	}

	@Override
	public boolean deleteStoreApproval(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.deleteStoreApproval(purchaseRequisitionId);
	}

	@Override
	public boolean Approval(int purchaseRequisitionId) throws Exception {
		// TODO Auto-generated method stub
		return storeApprovalDAO.Approval(purchaseRequisitionId);
	}

}
