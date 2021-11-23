package com.dci.tenant.finance.shiftmaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "{tenantid}/app/hr/manageshift")

public class ShiftMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftMasterController.class);

	@Autowired
	private ShiftMasterService shiftMasterService;

	@RequestMapping(value = "/list")
	public ShiftMasterResultBean getShiftMasterList() {
		ShiftMasterResultBean shiftMasterBean = new ShiftMasterResultBean();
		try {

			shiftMasterBean.setShiftMasterList(shiftMasterService.getShiftMasterList());
			shiftMasterBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shiftMasterBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ShiftMasterResultBean addShiftMaster(@RequestBody ShiftMasterBean objShiftMasterBean) throws CustomException {
		ShiftMasterResultBean objShiftMasterResultBean = new ShiftMasterResultBean();
		try {
			shiftMasterService.addShiftMaster(objShiftMasterBean);
			objShiftMasterResultBean.setSuccess(true);
		} catch (CustomException e) {
			objShiftMasterResultBean.setSuccess(false);
			objShiftMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objShiftMasterResultBean;
	}

	@RequestMapping("/getShiftMasterEditList")
	public @ResponseBody ShiftMasterBean getShiftMasterEditList(@RequestParam("shiftId") int shiftId) throws Exception {
		ShiftMasterBean objShiftMasterBean = new ShiftMasterBean();
		objShiftMasterBean = shiftMasterService.getShiftMasterEditList(shiftId);
		return objShiftMasterBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteShiftMaster(@RequestBody int shiftId) throws Exception {
		boolean isDeleted = false;
		isDeleted = shiftMasterService.deleteShiftMaster(shiftId);
		return isDeleted;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ShiftMasterResultBean updateShiftMaster(@RequestBody ShiftMasterBean objShiftMasterBean) throws CustomException {
		ShiftMasterResultBean objShiftMasterResultBean = new ShiftMasterResultBean();
		try {
			shiftMasterService.updateShiftMaster(objShiftMasterBean);
			objShiftMasterResultBean.setSuccess(true);
		} catch (CustomException e) {
			objShiftMasterResultBean.setSuccess(false);
			objShiftMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objShiftMasterResultBean;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody ShiftMasterResultBean uploadFile(MultipartFile file) throws CustomException {
		ShiftMasterResultBean shiftMasterResultBean = new ShiftMasterResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					shiftMasterResultBean.setSuccess(shiftMasterService.uploadFile(file));

				} else {
					shiftMasterResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				shiftMasterResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shiftMasterResultBean;
	}

}
