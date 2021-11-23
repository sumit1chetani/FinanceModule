package com.dci.payroll.payroll.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/payroll/rate")
public class RateController {
	private final static Logger LOGGER = LoggerFactory.getLogger(RateController.class);
	@Autowired
	RateService rateService;

	@RequestMapping(value = "/list")
	public RateResultBean getRateList() {
		RateResultBean rateResultBean = new RateResultBean();
		try {
			rateResultBean.setRateList(rateService.getRateList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rateResultBean;
	}

	@RequestMapping(value = "/edit")
	public RateResultBean getRateListById(@RequestBody int rateId) {

		RateResultBean rateResultBean = new RateResultBean();
		try {
			rateResultBean.setRateBean(rateService.getRateListById(rateId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rateResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody RateBean rateBean) {
		boolean isSuccess = false;
		try {

			isSuccess = rateService.insertRate(rateBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody RateBean rateBean) {

		boolean isSuccess = false;
		try {
			isSuccess = rateService.updateRate(rateBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody int id) {
		boolean isDeleted = false;
		try {
			isDeleted = rateService.deleteRate(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}
}
