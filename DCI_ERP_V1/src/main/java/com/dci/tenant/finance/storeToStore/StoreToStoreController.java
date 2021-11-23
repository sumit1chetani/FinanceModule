package com.dci.tenant.finance.storeToStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/hospital/purchase/storeToStore")
public class StoreToStoreController {
	private final static Logger LOGGER = LoggerFactory.getLogger(StoreToStoreController.class);

	@Autowired
	private StoreToStoreService storeToStoreService;

	@RequestMapping(value = "/list")
	public StoreToStoreResultBean getStoreToStoreList() {
		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		try {

			storeToStoreResultBean.setEmployeeList(storeToStoreService.getStoreToStoreList());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return storeToStoreResultBean;

	}

	@RequestMapping(value = "/employeeList")
	public @ResponseBody StoreToStoreResultBean getEmployeeList() throws Exception {
		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		try {
			storeToStoreResultBean = storeToStoreService.getEmployeeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return storeToStoreResultBean;

	}

	@RequestMapping(value = "/itemList")
	public StoreToStoreResultBean getItemList(@RequestBody int itemId) {
		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		try {
			StoreToStoreSubBean soreToStoreSubBean = storeToStoreService.getItemList(itemId);
			storeToStoreResultBean.setItemData(soreToStoreSubBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeToStoreResultBean;
	}

	@RequestMapping(value = "/checkQcItem")
	public StoreToStoreResultBean checkQcItem(@RequestBody StoreToStore storeToStorebean) {
		StoreToStoreResultBean resultBean = new StoreToStoreResultBean();
		try {
			resultBean = storeToStoreService.checkQcItem(storeToStorebean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody boolean save(@RequestBody StoreToStoreResultBean storeToStoreResultBean) {

		boolean isSuccess = false;
		try {
			isSuccess = storeToStoreService.insertStoreToStore(storeToStoreResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/edit")
	public @ResponseBody StoreToStoreResultBean getStoreToStoreById(@RequestBody int purchaseRequisitionId) throws Exception {
		StoreToStoreResultBean storeToStoreResultBean = new StoreToStoreResultBean();
		storeToStoreResultBean = storeToStoreService.getStoreToStoreById(purchaseRequisitionId);
		return storeToStoreResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody StoreToStoreResultBean storeToStoreResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = storeToStoreService.updateStoreToStore(storeToStoreResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int purchaseRequisitionId) throws Exception {
		boolean isDeleted = false;
		isDeleted = storeToStoreService.deleteStoreToStore(purchaseRequisitionId);
		return isDeleted;
	}

	@RequestMapping("/checkStockTransfer")
	public @ResponseBody int checkStockTransfer(@RequestParam("purchaseRequisitionId") int purchaseRequisitionId) throws CustomException {
		int requisitionId;
		try {
			requisitionId = storeToStoreService.checkStockTransfer(purchaseRequisitionId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return requisitionId;
	}

}
