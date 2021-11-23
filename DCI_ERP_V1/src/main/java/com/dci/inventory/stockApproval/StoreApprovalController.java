package com.dci.inventory.stockApproval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@RestController
@RequestMapping(value = "app/hospital/purchase/storeApproval")
public class StoreApprovalController {
	private final static Logger LOGGER = LoggerFactory.getLogger(StoreApprovalController.class);

	@Autowired
	private StoreApprovalService storeApprovalService;

	@RequestMapping(value = "/list")
	public StoreApprovalResultBean getStoreApprovalList() {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		try {

			storeApprovalResultBean.setEmployeeList(storeApprovalService.getStoreApprovalList());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return storeApprovalResultBean;

	}

	@RequestMapping(value = "/employeeList")
	public @ResponseBody StoreApprovalResultBean getEmployeeList() throws Exception {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		try {
			storeApprovalResultBean = storeApprovalService.getEmployeeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return storeApprovalResultBean;

	}

	@RequestMapping(value = "/itemList")
	public StoreApprovalResultBean getItemList(@RequestBody int itemId) {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		try {
			StoreApprovalSubBean soreToStoreSubBean = storeApprovalService.getItemList(itemId);
			storeApprovalResultBean.setItemData(soreToStoreSubBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeApprovalResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody StoreApprovalResultBean getStoreApprovalById(@RequestBody int purchaseRequisitionId) throws Exception {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		storeApprovalResultBean = storeApprovalService.getStoreApprovalById(purchaseRequisitionId);
		return storeApprovalResultBean;
	}

	@RequestMapping("/view")
	public @ResponseBody StoreApprovalResultBean getStoreApprovalByView(@RequestBody int purchaseRequisitionId) throws Exception {
		StoreApprovalResultBean storeApprovalResultBean = new StoreApprovalResultBean();
		storeApprovalResultBean = storeApprovalService.getStoreApprovalByView(purchaseRequisitionId);
		return storeApprovalResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody StoreApprovalResultBean storeApprovalResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = storeApprovalService.updateStoreApproval(storeApprovalResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int purchaseRequisitionId) throws Exception {
		boolean isDeleted = false;
		isDeleted = storeApprovalService.deleteStoreApproval(purchaseRequisitionId);
		return isDeleted;
	}

	@RequestMapping("/approve")
	public @ResponseBody boolean approve(@RequestBody int purchaseRequisitionId) throws Exception {
		boolean isApprove = false;
		isApprove = storeApprovalService.Approval(purchaseRequisitionId);
		return isApprove;
	}

}
