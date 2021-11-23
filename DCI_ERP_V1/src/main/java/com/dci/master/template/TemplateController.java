package com.dci.master.template;

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
@RequestMapping(value = "{tenantid}/app/template")
public class TemplateController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

	@Autowired
	TemplateService service;

	@RequestMapping("/list")
	public @ResponseBody TemplateResultBean getList() throws CustomException {
		TemplateResultBean resultBean = new TemplateResultBean();

		try {
			resultBean = service.getList();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return resultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody TemplateBean bean) {
		boolean isSuccess = false;
		try {
			isSuccess = service.getSave(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping("/getTemplateDataEdit")
	public @ResponseBody TemplateBean getTemplateDataEdit(@RequestParam("templateId") int templateId) throws Exception {
		TemplateBean objTemplateBean = new TemplateBean();
		try {
			objTemplateBean = service.getTemplateDataEdit(templateId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objTemplateBean;
	}

	@RequestMapping("/update")
	public @ResponseBody boolean update(@RequestBody TemplateBean bean) throws CustomException {
		boolean isSuccess = false;
		try {
			isSuccess = service.update(bean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestParam("templateId") int templateId) throws Exception {
		boolean isSuccess = false;
		try {
			isSuccess = service.delete(templateId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	@RequestMapping("/sampleTemplate")
	public @ResponseBody TemplateBean sampleTemplate(@RequestParam("templateId") String templateId) throws Exception {
		TemplateBean objTemplateBean = new TemplateBean();
		try {
			objTemplateBean = service.sampleTemplate(templateId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objTemplateBean;
	}

}
