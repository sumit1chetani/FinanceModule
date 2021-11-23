package com.dci.master.settings.uomcategory;

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
@RequestMapping(value = "app/hospital/inventory/UOMCategory")
public class UOMCatogoryController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UOMCatogoryController.class);

	@Autowired
	private UOMCatogoryService manageUOMService;

	@RequestMapping(value = "/list")
	public UOMCatogoryResultBean getUOMCategoryList() {
		UOMCatogoryResultBean manageUOMResultBean = new UOMCatogoryResultBean();
		try {

			manageUOMResultBean.setUOMCategoryList(manageUOMService.getUOMCategoryList());
			manageUOMResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageUOMResultBean;

	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody UOMCatogoryBean manageUOM) {
		boolean isSuccess = false;
		try {
			isSuccess = manageUOMService.insertUOMCategory(manageUOM);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody UOMCatogoryBean objUomCatogoryBean) {
		boolean isSuccess = false;

		try {
			isSuccess = manageUOMService.updateUOMCategory(objUomCatogoryBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public UOMCatogoryResultBean deleteUOMCategory(@RequestBody Integer UOMCategoryId) {
		UOMCatogoryResultBean manageUOMResultBean = new UOMCatogoryResultBean();
		try {
			manageUOMService.deleteUOMCategory(UOMCategoryId);
			manageUOMResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageUOMResultBean;
	}

	@RequestMapping("/getAutoGenarateNumber")
	public @ResponseBody UOMCatogoryBean getAutoGenarateValues() throws CustomException {
		UOMCatogoryBean objquestionBean = new UOMCatogoryBean();
		try {
			objquestionBean = manageUOMService.getAutoGenarateValues();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objquestionBean;
	}

	@RequestMapping("/uomCategoryEditList")
	public @ResponseBody UOMCatogoryBean uomCategoryEditList(@RequestParam("uomId") int uomId) throws Exception {
		UOMCatogoryBean objUomCatogoryBean = new UOMCatogoryBean();
		objUomCatogoryBean = manageUOMService.uomCategoryEditList(uomId);
		return objUomCatogoryBean;
	}

	@RequestMapping("/checkCategoryName")
	public @ResponseBody int checkCatgeoryName(@RequestParam("uomcategoryName") String uomcategoryName) throws CustomException {
		int category;

		try {
			category = manageUOMService.checkCatgeoryName(uomcategoryName);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return category;
	}

}
