package com.dci.payroll.tds.tds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/tds/tds")
public class TdsController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TdsController.class);
	@Autowired
	TdsService tdsService;

	@RequestMapping(value = "/tdslist")
	public TdsResultBean getTaxList(@RequestBody TdsBean resultBean) {
		TdsResultBean tdsResultBean = new TdsResultBean();
		try {
			/***** TAX LIST **************/
			tdsResultBean.setTdsSlabList(tdsService.getSlabList(resultBean.getEmployeeId(), resultBean.getFinancialYear()));
			/***** PAY LIST **************/
			tdsResultBean.setTdsPayList(tdsService.getPayList(resultBean.getEmployeeId(), resultBean.getFinancialYear()));
			/***** TAX SUB SECTION LIST **************/
			tdsResultBean.setTdsSubSectionList(tdsService.getSubSectionList(resultBean.getEmployeeId(), resultBean.getFinancialYear(), resultBean.isDeclared(), resultBean.isActual()));
			/***** OTHER INCOME LIST **************/
			tdsResultBean.setTdsOtherIncomeList(tdsService.getOtherIncomeList(resultBean.getEmployeeId(), resultBean.getFinancialYear()));
			/***** Getting Month count **************/
			tdsResultBean.setMonthbean(tdsService.getmothBean(resultBean.getEmployeeId(), resultBean.getFinancialYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tdsResultBean;
	}

}