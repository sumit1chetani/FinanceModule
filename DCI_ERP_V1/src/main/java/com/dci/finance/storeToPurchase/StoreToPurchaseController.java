package com.dci.finance.storeToPurchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/hospital/purchase/storeToPurchase")
public class StoreToPurchaseController {
	private final static Logger LOGGER = LoggerFactory.getLogger(StoreToPurchaseController.class);

	@Autowired
	private StoreToPurchaseService storeToPurchaseService;

	@RequestMapping(value = "/list")
	public StoreToPurchaseResultBean getStoreToPurchaseList() {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		try {

			storeToPurchaseResultBean.setEmployeeList(storeToPurchaseService.getStoreToPurchaseList());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return storeToPurchaseResultBean;

	}

	@RequestMapping(value = "/employeeList")
	public @ResponseBody StoreToPurchaseResultBean getEmployeeList() throws Exception {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		try {
			storeToPurchaseResultBean = storeToPurchaseService.getEmployeeList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return storeToPurchaseResultBean;

	}

	@RequestMapping(value = "/itemList")
	public StoreToPurchaseResultBean getItemList(@RequestBody int itemId) {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		try {
			StoreToPurchaseSubBean soreToStoreSubBean = storeToPurchaseService.getItemList(itemId);
			storeToPurchaseResultBean.setItemData(soreToStoreSubBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeToPurchaseResultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody boolean save(@RequestBody StoreToPurchaseResultBean storeToPurchaseResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = storeToPurchaseService.insertStoreToPurchase(storeToPurchaseResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/edit")
	public @ResponseBody StoreToPurchaseResultBean getStoreToPurchaseById(@RequestBody int purchaseRequisitionId) throws Exception {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		storeToPurchaseResultBean = storeToPurchaseService.getStoreToPurchaseById(purchaseRequisitionId);
		return storeToPurchaseResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody StoreToPurchaseResultBean storeToPurchaseResultBean) {
		boolean isSuccess = false;
		try {
			isSuccess = storeToPurchaseService.updateStoreToPurchase(storeToPurchaseResultBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int purchaseRequisitionId) throws Exception {
		boolean isDeleted = false;
		isDeleted = storeToPurchaseService.deleteStoreToPurchase(purchaseRequisitionId);
		return isDeleted;
	}

	@RequestMapping("/itemListBasedAsset")
	public @ResponseBody StoreToPurchaseResultBean AssetItemList() {
		StoreToPurchaseResultBean storeToPurchaseResultBean = new StoreToPurchaseResultBean();
		storeToPurchaseResultBean = storeToPurchaseService.getAssetItemList();
		return storeToPurchaseResultBean;
	}

}
