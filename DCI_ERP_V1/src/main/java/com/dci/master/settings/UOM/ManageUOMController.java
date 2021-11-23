package com.dci.master.settings.UOM;

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
@RequestMapping(value = "app/hospital/inventory/manageUOM")
public class ManageUOMController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManageUOMController.class);

	@Autowired
	private ManageUOMService manageUOMService;

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ManageUOM manageUOM) {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = manageUOMService.insertManageUOM(manageUOM);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public ManageUOMResultBean getManageUOMById(@RequestBody Integer manageUOMId) {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		try {
			ManageUOM manageUOM = manageUOMService.getManageUOMById(manageUOMId);
			manageUOMResultBean.setManageUOM(manageUOM);
			manageUOMResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageUOMResultBean;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ManageUOM manageUOM) {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = manageUOMService.updateManageUOM(manageUOM);
		} catch (CustomException e) {
			manageUOMResultBean.setSuccess(false);
			manageUOMResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public ManageUOMResultBean deleteManageUOM(@RequestBody Integer manageUOMId) {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		try {
			manageUOMService.deleteManageUOM(manageUOMId);
			manageUOMResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manageUOMResultBean;
	}

	@RequestMapping(value = "/list")
	public ManageUOMResultBean getManageUOMList() {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		try {

			manageUOMResultBean.setManageUOMList(manageUOMService.getManageUOMList());
			manageUOMResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return manageUOMResultBean;

	}

	@RequestMapping(value = "/uomCategoryList")
	public ManageUOMResultBean getUOMCategoryList() {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		try {
			manageUOMResultBean = manageUOMService.getUOMCategoryList();
			manageUOMResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageUOMResultBean;
	}

	@RequestMapping(value = "/uomCategList")
	public ManageUOMResultBean getUOMCategList() {
		ManageUOMResultBean manageUOMResultBean = new ManageUOMResultBean();
		try {
			manageUOMResultBean = manageUOMService.getUOMCategList();
			manageUOMResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manageUOMResultBean;
	}

	@RequestMapping("/checkBaseUOM")
	public @ResponseBody int checkBaseUOM(@RequestBody ManageUOM manageUOM) throws CustomException {
		int baseUOM = 0;

		try {
			baseUOM = manageUOMService.checkBaseUOM(manageUOM);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return baseUOM;
	}

	@RequestMapping("/checkUOMName")
	public @ResponseBody int checkUOMName(@RequestParam("uomName") String uomName) throws CustomException {
		int storeName = 0;

		try {
			storeName = manageUOMService.checkUOMName(uomName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeName;
	}

}
