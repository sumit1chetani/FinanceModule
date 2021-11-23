package com.dci.payroll.payroll.gratuity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/gratuity")
public class GratuityController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GratuityController.class);

	@Autowired
	private GratuityService gratuityService;

	@RequestMapping(value = "/list")
	public GratuityResultBean getGratuityList() {
		GratuityResultBean gratuityResultBean = new GratuityResultBean();
		try {

			gratuityResultBean.setGratuityList(gratuityService.getGratuityList());
			gratuityResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gratuityResultBean;

	}

	// Save Method

	@RequestMapping(value = "/add")
	public boolean save(@RequestBody GratuityBean gratuity) {
		boolean isSuccess = false;
		try {
			isSuccess = gratuityService.insertGratuity(gratuity);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/edit")
	public GratuityResultBean getGratuityById(@RequestBody String employeeId) {
		GratuityResultBean gratuityResultBean = new GratuityResultBean();
		try {
			GratuityBean gratuity = gratuityService.getGratuityById(employeeId);
			gratuityResultBean.setGratuityBean(gratuity);
			gratuityResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gratuityResultBean;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody GratuityBean gratuity) {
		GratuityResultBean gratuityResultBean = new GratuityResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = gratuityService.updateGratuity(gratuity);
		} catch (CustomException e) {
			gratuityResultBean.setSuccess(false);
			gratuityResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
