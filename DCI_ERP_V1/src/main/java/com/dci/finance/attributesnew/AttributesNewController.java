package com.dci.finance.attributesnew;

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
@RequestMapping(value = "app/attributesNew")
public class AttributesNewController {

	private final static Logger LOGGER = LoggerFactory.getLogger(AttributesNewController.class);

	@Autowired
	private AttributeNewService objAttributeService;

	@RequestMapping("/list")
	public @ResponseBody AttributeNewResultBean getAttributesList() throws CustomException {
		AttributeNewResultBean objAttributeResultBean = new AttributeNewResultBean();
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
	public @ResponseBody boolean saveAttribute(@RequestBody AttributeNewBean objAttribute) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = objAttributeService.saveAttribute(objAttribute);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/edit")
	public @ResponseBody AttributeNewResultBean editAttribute(@RequestBody String attr) throws Exception {
		AttributeNewResultBean attributeNewResultBean = new AttributeNewResultBean();
		try {
			attributeNewResultBean.setAttributeEdit(objAttributeService.editAttribute(attr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeNewResultBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateAttribute(@RequestBody AttributeNewBean objAttribute) throws CustomException {

		boolean isSuccess = false;
		try {
			isSuccess = objAttributeService.updateAttribute(objAttribute);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody AttributeNewResultBean deleteAttr(@RequestBody String attr) {
		AttributeNewResultBean attributeNewResultBean = new AttributeNewResultBean();
		try {

			attributeNewResultBean.setSuccess(objAttributeService.deleteAttr(attr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attributeNewResultBean;
	}
}
