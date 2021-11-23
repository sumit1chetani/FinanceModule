package com.dci.payroll.payroll.fullfinalsettlement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/payroll/finalsettlement")
public class FullFinalSettlementController {
	private final static Logger LOGGER = LoggerFactory.getLogger(FullFinalSettlementController.class);
	@Autowired
	FullFinalSettlementService finalSettlementService;

	@RequestMapping(value = "/list")
	public FullFinalSettlementResultBean getFullFinalSettlementList(@RequestBody FullFinalSettlementBean finalSettlementBean) {
		FullFinalSettlementResultBean finalSettlementResultBean = new FullFinalSettlementResultBean();
		try {
			finalSettlementResultBean.setFullFinalSettlementList(finalSettlementService.getFullFinalSettlementList(finalSettlementBean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalSettlementResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody FullFinalSettlementBean finalSettlementBean) {
		boolean isSuccess = false;
		try {
			isSuccess = finalSettlementService.save(finalSettlementBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/approve")
	public boolean approve(@RequestBody FullFinalSettlementBean finalSettlementBean) {
		boolean isSuccess = false;
		try {
			isSuccess = finalSettlementService.approve(finalSettlementBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}

}