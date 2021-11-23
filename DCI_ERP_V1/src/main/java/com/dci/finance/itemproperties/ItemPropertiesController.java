package com.dci.finance.itemproperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "his/inventory/settings/itemproperties")
public class ItemPropertiesController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ItemPropertiesController.class);

	@Autowired
	private ItemPropertiesService itemPropertiesService;

	@RequestMapping(value = "/list")
	public ItemPropertiesResultBean getItemPropertiesList() {
		ItemPropertiesResultBean itemPropertiesResultBean = new ItemPropertiesResultBean();
		try {

			itemPropertiesResultBean.setItemPropertiesBeanList(itemPropertiesService.getItemPropertiesList());
			itemPropertiesResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemPropertiesResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteItemProperties(@RequestBody String itemPropertiesId) throws Exception {
		boolean isDeleted = false;
		isDeleted = itemPropertiesService.deleteItemProperties(itemPropertiesId);
		return isDeleted;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addItemProperties(@RequestBody ItemPropertiesBean objItemPropertiesBean) throws CustomException {
		boolean isSuccess = false;
		ItemPropertiesResultBean objItemPropertiesResultBean = new ItemPropertiesResultBean();
		try {

			isSuccess = itemPropertiesService.addItemProperties(objItemPropertiesBean);
			objItemPropertiesResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateItemProperties(@RequestBody ItemPropertiesBean objItemPropertiesBean) throws CustomException {
		boolean isSuccess = false;
		ItemPropertiesResultBean objItemPropertiesResultBean = new ItemPropertiesResultBean();
		try {

			isSuccess = itemPropertiesService.updateItemProperties(objItemPropertiesBean);
			objItemPropertiesResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/getTypeList")
	public ItemPropertiesResultBean getDefaultValueList() {
		ItemPropertiesResultBean objItemPropertiesResultBean = new ItemPropertiesResultBean();
		try {
			objItemPropertiesResultBean = itemPropertiesService.getDefaultValueList();
			objItemPropertiesResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objItemPropertiesResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody ItemPropertiesBean getEditList(@RequestParam("itemPropertiesId") int itemPropertiesId) throws Exception {
		ItemPropertiesBean objItemPropertiesBean = new ItemPropertiesBean();
		objItemPropertiesBean = itemPropertiesService.getEditList(itemPropertiesId);
		return objItemPropertiesBean;
	}

}
