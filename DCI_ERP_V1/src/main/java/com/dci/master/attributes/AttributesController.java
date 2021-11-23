package com.dci.master.attributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/attributes")
public class AttributesController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AttributesController.class);

	@Autowired
	private AttributeService objAttributeService;

	@RequestMapping("/list")
	public @ResponseBody AttributeResultBean getAttributesList() throws CustomException {
		AttributeResultBean objAttributeResultBean = new AttributeResultBean();
		try {
			objAttributeResultBean.setlAttributeList(objAttributeService.getAttributesList());
			objAttributeResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objAttributeResultBean;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody boolean saveAttribute(@RequestBody AttributeBean objAttribute) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = objAttributeService.saveAttribute(objAttribute);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}
}
