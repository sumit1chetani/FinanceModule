package com.dci.tenant.finance.shiftschememaster;

import java.util.ArrayList;

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
@RequestMapping(value = "{tenantid}/app/hr/shiftschememaster")

public class ShiftSchemeMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftSchemeMasterController.class);

	@Autowired
	private ShiftSchemeMasterService shiftSchemeMasterService;

	@RequestMapping(value = "/list")
	public ShiftSchemeMasterResultBean getShiftSchemeMasterList() {
		ShiftSchemeMasterResultBean shiftSchemeMasterBean = new ShiftSchemeMasterResultBean();
		try {

			shiftSchemeMasterBean.setShiftSchemeMasterList(shiftSchemeMasterService.getShiftSchemeMasterList());
			shiftSchemeMasterBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shiftSchemeMasterBean;
	}

	@RequestMapping(value = "/getShiftNameList")
	public ShiftSchemeMasterResultBean getShiftNameList(@RequestBody ShiftSchemeMasterBean shiftSchemeMasterBean) {
		ShiftSchemeMasterResultBean objShiftSchemeMasterResultBean = new ShiftSchemeMasterResultBean();
		try {
			objShiftSchemeMasterResultBean = shiftSchemeMasterService.getShiftNameList(shiftSchemeMasterBean);
			objShiftSchemeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objShiftSchemeMasterResultBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ShiftSchemeMasterResultBean addShiftSchemeMaster(@RequestBody ShiftSchemeMasterBean objShiftSchemeMasterBean) throws CustomException {
		ShiftSchemeMasterResultBean objShiftSchemeMasterResultBean = new ShiftSchemeMasterResultBean();
		try {
			shiftSchemeMasterService.addShiftSchemeMaster(objShiftSchemeMasterBean);
			objShiftSchemeMasterResultBean.setSuccess(true);
		} catch (CustomException e) {
			objShiftSchemeMasterResultBean.setSuccess(false);
			objShiftSchemeMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objShiftSchemeMasterResultBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ShiftSchemeMasterResultBean updateShiftSchemeMaster(@RequestBody ShiftSchemeMasterBean objShiftSchemeMasterBean) throws CustomException {
		ShiftSchemeMasterResultBean objShiftSchemeMasterResultBean = new ShiftSchemeMasterResultBean();
		try {
			shiftSchemeMasterService.updateShiftSchemeMaster(objShiftSchemeMasterBean);
			objShiftSchemeMasterResultBean.setSuccess(true);
		} catch (CustomException e) {
			objShiftSchemeMasterResultBean.setSuccess(false);
			objShiftSchemeMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objShiftSchemeMasterResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteShiftSchemeMaster(@RequestBody ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception {
		boolean isDeleted = false;
		isDeleted = shiftSchemeMasterService.deleteShiftSchemeMaster(objShiftSchemeMasterBean);
		return isDeleted;
	}

	@RequestMapping("/getShiftSchemeMasterEditList")
	public @ResponseBody ShiftSchemeMasterBean getShiftSchemeMasterEditList(@RequestParam("schemeName") String schemeName) throws Exception {
		ShiftSchemeMasterBean objShiftSchemeMasterBean = new ShiftSchemeMasterBean();
		ArrayList weekList = new ArrayList();

		try {
			objShiftSchemeMasterBean = shiftSchemeMasterService.getShiftSchemeMasterEditList(schemeName);
			weekList = shiftSchemeMasterService.getShiftSchemeMasterWeekList(schemeName);
			objShiftSchemeMasterBean.setWeekList(weekList);
		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return objShiftSchemeMasterBean;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody ShiftSchemeMasterResultBean uploadFile(MultipartFile file) throws CustomException {
		ShiftSchemeMasterResultBean shiftSchemeMasterResultBean = new ShiftSchemeMasterResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					shiftSchemeMasterResultBean.setSuccess(shiftSchemeMasterService.uploadFile(file));

				} else {
					shiftSchemeMasterResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				shiftSchemeMasterResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shiftSchemeMasterResultBean;
	}
}
